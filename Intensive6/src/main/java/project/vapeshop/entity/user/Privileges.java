package project.vapeshop.entity.user;

import lombok.*;
import project.vapeshop.entity.EntityId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="privileges")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Privileges implements EntityId<Integer> {
    @Id
    @Column(name="id_privelege")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name_privelege")
    private String name;

    @ToString.Exclude
    @ManyToMany(mappedBy = "privileges",fetch = FetchType.LAZY)
    private List<Role> roleList;

    public Privileges(String name) {
        this.name = name;
    }

    public Privileges(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
