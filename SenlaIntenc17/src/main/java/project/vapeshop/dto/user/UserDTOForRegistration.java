package project.vapeshop.dto.user;

import project.vapeshop.entity.user.Role;

public class UserDTOForRegistration {
    private Integer id;
    private String surname;
    private String name;
    private String patronymic;
    private String login;
    private String password;
    private String mail;
    private Role idRole;

    public UserDTOForRegistration() {
    }

    public UserDTOForRegistration(String surname, String name, String patronymic, String login, String password, String mail, Role idRole) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.idRole = idRole;
    }

    public UserDTOForRegistration(Integer id, String surname, String name, String patronymic, String login, String password, String mail, Role idRole) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.idRole = idRole;
    }

    public Integer getId() {
        return id;
    }

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

    public Role getIdRole() {
        return idRole;
    }

    public void setIdRole(Role idRole) {
        this.idRole = idRole;
    }
}