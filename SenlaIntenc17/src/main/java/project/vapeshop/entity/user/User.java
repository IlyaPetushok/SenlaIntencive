package project.vapeshop.entity.user;

import project.vapeshop.entity.EntityId;
import project.vapeshop.entity.common.Order;
import project.vapeshop.entity.common.Rating;

import javax.persistence.*;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "users")
public class User implements EntityId<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;
    @Column(name = "surname")
    private String surname;
    @Column(name = "name")
    private String name;
    @Column(name="patronymic")
    private String patronymic;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name="mail")
    private String mail;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Order> orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id_role",referencedColumnName = "id_role")
    private Role role;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Rating> ratings;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(String surname, String name, String patronymic, String login, String password, String mail, Role role) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.role = role;
    }

    public User(Integer id, String surname, String name, String patronymic, String login, String password, String mail, Role role) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.role = role;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
