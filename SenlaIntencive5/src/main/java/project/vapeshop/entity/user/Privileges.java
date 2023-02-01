package project.vapeshop.entity.user;

public class Privileges {
    private Integer id;
    private String name;

    public Privileges(String name) {
        this.name = name;
    }

    public Privileges() {
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
