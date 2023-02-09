package project.vapeshop.entity.user;

import project.vapeshop.entity.EntityId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="privileges")
public class Privileges implements EntityId<Integer> {
    @Id
    @Column(name="id_privelege")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name_privelege")
    private String name;

    @ManyToMany(mappedBy = "privileges",fetch = FetchType.LAZY)
    private List<Role> roleList;


    public Privileges(String name) {
        this.name = name;
    }

    public Privileges() {
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
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
