package net.demcak.dump;

import net.demcak.dump.model.TodoEntity;
import net.demcak.dump.services.DatabaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Controller for manipulation with task entity
 *
 * @author  Vlado Demcak
 * @version 1.0
 */
@RestController
@RequestMapping("/")
public class RESTTaskController {

    /**
     * This method returns list of tasks for user (his id)
     * @param id
     * @return ResponseEntity status of adding task.
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public
    @ResponseBody
    List getTodoListForUserId(@RequestParam("id") int id) {
        List userTodoList = (List) DatabaseService.getInstance().getDb().get(id);
        return userTodoList;
    }

    /**
     * This method adds new task in "database".
     * @param newTodo newTodo.
     * @return ResponseEntity status of adding task.
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createTodoForUserId(@RequestBody TodoEntity newTodo) {
        int id;
        try {
            id = Integer.valueOf(newTodo.getFK_uid());
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        List userTodoList = (List) DatabaseService.getInstance().getDb().get(id);

        if (userTodoList == null) {
            DatabaseService.getInstance().getDb().put(id, new LinkedList<TodoEntity>());
            userTodoList = (List) DatabaseService.getInstance().getDb().get(id);
        }

        newTodo.setId(userTodoList.size());
        userTodoList.add(newTodo);
        DatabaseService.getInstance().getDb().put(id, userTodoList);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * This method edits task. We need id of user and id of task (because we dont have global list of task)".
     * @param u_id user id.
     *  @param todo_id todo task id position in list.
     * @return ResponseEntity status of mark task done.
     */
    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public
    @ResponseBody
    ResponseEntity<Object> makeTodoDoneByTodoID(@RequestParam("u_id") int u_id, @RequestParam("todo_id") int todo_id) {
        int id;
        try {
            id = Integer.valueOf(u_id);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        List userTodoList = (List) DatabaseService.getInstance().getDb().get(id);

        if (userTodoList == null) {
            DatabaseService.getInstance().getDb().put(id, new LinkedList<TodoEntity>());
            userTodoList = (List) DatabaseService.getInstance().getDb().get(id);
        }

        ((TodoEntity) userTodoList.get(todo_id)).setArchive(true);
        DatabaseService.getInstance().getDb().put(id, userTodoList);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}