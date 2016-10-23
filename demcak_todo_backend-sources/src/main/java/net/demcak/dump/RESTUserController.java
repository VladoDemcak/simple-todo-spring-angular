package net.demcak.dump;

import net.demcak.dump.model.TodoEntity;
import net.demcak.dump.model.User;
import net.demcak.dump.services.DatabaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Controller for manipulation with login
 *
 * @author  Vlado Demcak
 * @version 1.0
 */
@RestController
@RequestMapping("/")
public class RESTUserController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public
    @ResponseBody
    HashMap loginCheck(@RequestParam("username") String username) {

        HashMap response = new HashMap<String, Object>();
        response.put("new_registration", "false");

        int userId = selectUserFromDbByUsername(username);
        if (userId == -1) {
            userId = createNewUser(username);
            response.put("new_registration", "true");
            DatabaseService.getInstance().getDb();
        }


        response.put("status", "ok");
        response.put("userId", userId);
        return response;
    }

    private int createNewUser(String username) {
            User u = new User();
            u.setLogin(username);
            return DatabaseService.getInstance().createUser(u);
    }

    private int selectUserFromDbByUsername(String username) {
        ArrayList<User> listUsers = DatabaseService.getInstance().getUsers();
        for(User un : listUsers){
            if(un.getLogin().equalsIgnoreCase(username)){
                return un.getId();
            }
        }
        return -1;
    }
}




