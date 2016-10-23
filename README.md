This is simple description of system TODO demcak.

System consists of two sides.
Side 1.
FRONT END - angularjs client. THere are used 2 controllers and 2 views. One for login form an checking or registering new user.
I have used bootstrap for mobile first technique and third side scripts are stored on other servers.

Side 2.
BACK END is build on spring framework. Backend provides REST api for creating new TODO task, mark task as done or retrieving tasks for specific user.

Because of time limitations system does not use any database. So this is the reason why every restart of server will delete all data.

Backend supports maven (pom.xml) file for compiling and creating war file, which is deployed on server (http://app.demcak.net/demcak_todo_backend-1)

----------------------------

GUIDE:
I have deployed TODO app on 
http://app.demcak.net/ROOT2/index2.html

You can use any loginname as username (system creates if username does not exist).

!!! IMPORTANT PART OF GUIDE !!!
YOU HAVE TO USE PASSWORD "test" for log in to todo system (without quotes).

GUI consists of 3 parts. First is for submitting new task. Second column shows actual tasks and column on right shows archived tasks.


REsources:
OK ICON - http://www.softicons.com/toolbar-icons/flat-2013-toolbar-icons-by-aha-soft/ok-icon 
