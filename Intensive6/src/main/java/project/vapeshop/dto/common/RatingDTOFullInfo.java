package project.vapeshop.dto.common;

import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.user.User;

public class RatingDTOFullInfo {
    private Integer id;
    private String comment;
    private int quantityStar;
    private Item idItem;
    private User idUser;

    public RatingDTOFullInfo() {
    }

    public RatingDTOFullInfo(String comment, int quantityStar, Item idItem, User idUser) {
        this.comment = comment;
        this.quantityStar = quantityStar;
        this.idItem = idItem;
        this.idUser = idUser;
    }

    public RatingDTOFullInfo(Integer id, String comment, int quantityStar, Item idItem, User idUser) {
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

    public Item getIdItem() {
        return idItem;
    }

    public void setIdItem(Item idItem) {
        this.idItem = idItem;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }
}
