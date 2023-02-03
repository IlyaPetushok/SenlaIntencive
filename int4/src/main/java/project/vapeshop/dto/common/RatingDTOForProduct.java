package project.vapeshop.dto.common;

public class RatingDTOForProduct {
    private Integer id;
    private String comment;
    private int quantityStar;
    private Integer idUser;

    public RatingDTOForProduct(String comment, int quantityStar, Integer idUser) {
        this.comment = comment;
        this.quantityStar = quantityStar;
        this.idUser = idUser;
    }

    public RatingDTOForProduct(Integer id, String comment, int quantityStar, Integer idUser) {
        this.id = id;
        this.comment = comment;
        this.quantityStar = quantityStar;
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

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
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
}
