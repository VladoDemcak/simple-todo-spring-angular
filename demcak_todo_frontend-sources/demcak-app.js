var demcakTODOapp = angular.module('demcakTODOapp', ['ngRoute']);

demcakTODOapp.config(function($routeProvider) {
        $routeProvider
            // route for the home page
            .when('/', {
                templateUrl : 'login.html',
                controller  : 'LoginController'
            })

            .when('/todo', {
                templateUrl : 'todo.html',
                controller  : 'net-demcak-TODO-controller'
            });
    });


demcakTODOapp.controller('net-demcak-TODO-controller',  function ($route, $scope, $http,  sharedActualUser) {
	$scope.user_id = ''
	$scope.user = '';
	$scope.newTodo = '';

	$scope.todosList = [/*{title:'title',date:'date'}*/];

	$scope.selectedTodoTask = '';

	init();

	$scope.setSelectedTask = function(actTodoTask){
		$scope.selectedTodoTask = actTodoTask; 
	}

	$scope.addNewTodo = function (){
		var newTD;
		if($scope.newTodo.title == null){
			return;
		}
		console.log('added new todo: '+$scope.newTodo);
		if($scope.newTodo.date == null){
			$scope.newTodo.date = 'someday'
		}
		$scope.newTodo.fk_uid = sharedActualUser.getActualUser();
		

		var req = {
            method: 'POST',
            url: '/demcak_todo_backend-1/add',
            headers: {
                'Content-Type': 'application/json'
            },
            data: JSON.stringify($scope.newTodo)
			
        }

        $http(req).success(function (data) {
            console.log(data);
            init();
        }).error(function () {
            console.log("calling url failed");
            return "failed";
        });

	}

	$scope.makeDone = function (actTodo){

		console.log('added new todo: '+actTodo.title);

		var req = {
            method: 'PUT',
            url: '/demcak_todo_backend-1/put?u_id='+actTodo.fk_uid+'&todo_id='+actTodo.id,
            headers: {
                'Content-Type': 'application/json'
            }
        }

        $http(req).success(function (data) {
            console.log(data);
            init();
        }).error(function () {
            console.log("calling url failed");
            return "failed";
        });
	}

	function init() {

		var req = {
            method: 'GET',
            url: '/demcak_todo_backend-1/get?id='+sharedActualUser.getActualUser(),
            headers: {
                'Content-Type': 'application/json'
            }
        }

        $http(req).success(function (data) {
            console.log(data);
            $scope.todosList = data;
        }).error(function () {
            console.log("calling url failed");
            return "failed";
        });
    }

});


demcakTODOapp.controller('LoginController', function($route, $scope, $http, sharedActualUser, $location) {
		

		this.postForm = function() {
		
			var encodedString = 'username=' + encodeURIComponent(this.inputData.username);
				
			if(encodeURIComponent(this.inputData.password) != "test"){
				alert('wrong password');
				return;
			}

			$http({
				method: 'GET',
				url: '/demcak_todo_backend-1/login?'+encodedString,
				data: encodedString,
				headers: {
	                'Content-Type': 'application/json'
	            }
			})
			.success(function(data, status, headers, config) {
				console.log("data userId"+data.userId);
				sharedActualUser.setActualUser(data.userId);
				$location.path('todo');
			})
			.error(function(data, status, headers, config) {
				$scope.errorMsg = 'Error while loggining';
			})
		}
		
	});


demcakTODOapp.factory('sharedActualUser', function () {
    var actualUser = '';

    return {
        getActualUser: function () {
            return actualUser;
        },
        setActualUser: function (a) {
            actualUser = a;
        }
    };
});
