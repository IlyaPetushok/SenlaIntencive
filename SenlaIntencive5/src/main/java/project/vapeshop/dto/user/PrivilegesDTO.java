package project.vapeshop.dto.user;

public class PrivilegesDTO {
    private Integer id;
    private String name;

    public PrivilegesDTO() {
    }

    public PrivilegesDTO(String name) {
        this.name = name;
    }

    public PrivilegesDTO(Integer id, String name) {
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
