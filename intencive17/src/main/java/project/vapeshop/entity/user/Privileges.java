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
@RequiredArgsConstructor
public class Privileges implements EntityId<Integer> {
    @Id
    @NonNull
    @Column(name="id_privelege")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name_privelege")
    private String name;

    @NonNull
    @ManyToMany(mappedBy = "privileges",fetch = FetchType.LAZY)
    private List<Role> roleList;


    public Privileges(String name) {
        this.name = name;
    }

}
