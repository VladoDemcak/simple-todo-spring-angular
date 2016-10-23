package net.demcak.dump.model;

/**
 * Created by WlaDo on 15. 8. 2015.
 * UserEntity
 *
 */
public class User {
    private int id;
    private String login;
    private String avatar;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
