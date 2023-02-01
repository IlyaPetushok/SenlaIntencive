package project.vapeshop.entity.common;

public class Rating {
    private Integer id;
    private String comment;
    private int quantityStar;
    private Integer idItem;
    private Integer idUser;

    public Rating() {
    }

    public Rating(String comment, int quantityStar, Integer idItem, Integer idUser) {
        this.comment = comment;
        this.quantityStar = quantityStar;
        this.idItem = idItem;
        this.idUser = idUser;
    }

    public Rating(Integer id, String comment, int quantityStar, Integer idItem, Integer idUser) {
        this.id = id;
        this.comment = comment;
        this.quantityStar = quantityStar;
        this.idItem = idItem;
        this.idUser = idUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getQuantityStar() {
        return quantityStar;
    }

    public void setQuantityStar(int quantityStar) {
        this.quantityStar = quantityStar;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
}
