package net.demcak.dump.model;

/**
 * Created by WlaDo on 15. 8. 2015.
 * ToDoEntity
 */
public class TodoEntity {
    private int id;
    private String fk_uid;
    private String title;
    private String date;
    private String description;
    private boolean archive;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFK_uid() {
        return fk_uid;
    }

    public void setFK_uid(String FK_uid) {
        this.fk_uid = FK_uid;
    }

    public boolean isArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
