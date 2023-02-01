package project.vapeshop.dto.user;

public class UserDTOAfterAuthorization {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String mail;
    private Integer idRole;

    public UserDTOAfterAuthorization() {
    }

    public UserDTOAfterAuthorization(String surname, String name, String patronymic, String mail, Integer idRole) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.mail = mail;
        this.idRole = idRole;
    }

    public UserDTOAfterAuthorization(Integer id, String surname, String name, String patronymic, String mail, Integer idRole) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }
}
