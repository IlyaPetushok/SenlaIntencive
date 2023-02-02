package project.vapeshop.entity.user;

import project.vapeshop.entity.EntityGetSetId;

public class Privileges implements EntityGetSetId {
    private Integer id;
    private String name;

    public Privileges(String name) {
        this.name = name;
    }

    public Privileges(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
