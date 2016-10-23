package net.demcak.dump.services;

import net.demcak.dump.model.TodoEntity;
import net.demcak.dump.model.User;

import javax.xml.crypto.Data;
import java.util.*;

/**
 * Created by WlaDo on 16. 8. 2015.
 */
public class DatabaseService extends HashMap {

    private static DatabaseService instance = null;
    private HashMap db;
    private ArrayList<User> users;
    private int maxUserId = -1;

    private DatabaseService() {
    }

    public static DatabaseService getInstance() {
        if (instance == null) {
            instance = new DatabaseService();
            instance.setDb(new HashMap<Integer, List<TodoEntity>>());
            instance.setUsers(new ArrayList<User>());
        }
        return instance;
    }

    public HashMap getDb() {
        return db;
    }

    public void setDb(HashMap db) {
        this.db = db;
    }

    public int createUser(User u){
        maxUserId++;
        u.setId(maxUserId);
        instance.getUsers().add(u);
        return maxUserId;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
