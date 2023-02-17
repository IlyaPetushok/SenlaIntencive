package project.vapeshop.dto.common;

import project.vapeshop.dto.product.ItemDTOInfoForCatalog;
import project.vapeshop.dto.user.UserDTOAfterAuthorization;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.user.User;

public class RatingDTOFullInfo {
    private Integer id;
    private String comment;
    private int quantityStar;
    private ItemDTOInfoForCatalog item;
    private UserDTOAfterAuthorization user;

    public RatingDTOFullInfo() {
    }

    public RatingDTOFullInfo(String comment, int quantityStar, ItemDTOInfoForCatalog item, UserDTOAfterAuthorization user) {
        this.comment = comment;
        this.quantityStar = quantityStar;
        this.item = item;
        this.user = user;
    }

    public RatingDTOFullInfo(Integer id, String comment, int quantityStar, ItemDTOInfoForCatalog item, UserDTOAfterAuthorization user) {
        this.id = id;
        this.comment = comment;
        this.quantityStar = quantityStar;
        this.item = item;
        this.user = user;
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

    public ItemDTOInfoForCatalog getItem() {
        return item;
    }

    public void setItem(ItemDTOInfoForCatalog item) {
        this.item = item;
    }

    public UserDTOAfterAuthorization getUser() {
        return user;
    }

    public void setUser(UserDTOAfterAuthorization user) {
        this.user = user;
    }
}
