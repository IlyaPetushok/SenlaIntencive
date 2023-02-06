package project.vapeshop.entity.user;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Integer id;

    @Column(name = "name_role")
    private String name;

    @OneToMany(mappedBy = "role")
    private List<User> users;

    @ManyToMany()
    @JoinTable(name = "role_privileges",
            joinColumns = @JoinColumn(name = "rp_id_role"),
            inverseJoinColumns = @JoinColumn(name = "rp_id_privileges"))
    private List<Privileges> privileges;

    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }

    public Role(Integer id, String name) {
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
