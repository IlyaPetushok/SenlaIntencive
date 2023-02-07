package project.vapeshop.entity.user;

import project.vapeshop.entity.Entity;

public class Privileges implements Entity<Integer> {
    private Integer id;
    private String name;

    public Privileges(String name) {
        this.name = name;
    }

    public Privileges(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
