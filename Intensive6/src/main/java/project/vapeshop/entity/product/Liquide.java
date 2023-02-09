package project.vapeshop.entity.product;

//import org.hibernate.annotations.LazyToOne;
//import org.hibernate.annotations.LazyToOneOption;
import project.vapeshop.entity.EntityId;

import javax.persistence.*;

@NamedEntityGraph(
        name = "liquide-with-item",
        attributeNodes = {
                @NamedAttributeNode("itemForLiquide"),
        }
)
@Entity
@Table(name = "liquide")
public class Liquide implements EntityId<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_liquide")
    private Integer id;

    @OneToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "liquide_id_item",referencedColumnName = "id_item")
    private Item itemForLiquide;

//    @Column(name="liquide_id_item")
//    private Integer itemForLiquide;

    @Column(name = "flavour")
    private String flavour;
    @Column(name = "fortress")
    private int fortress;
//    Enum mb
    @Column(name="type_nicotine")
    private String typeNicotine;
    @Column(name="volume")
    private int volume;

    public Liquide() {
    }

    public Liquide(String flavour, int fortress, String typeNicotine, int volume) {
        this.flavour = flavour;
        this.fortress = fortress;
        this.typeNicotine = typeNicotine;
        this.volume = volume;
    }

    public Liquide(Integer id, String flavour, int fortress, String typeNicotine, int volume) {
        this.id = id;
        this.flavour = flavour;
        this.fortress = fortress;
        this.typeNicotine = typeNicotine;
        this.volume = volume;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public int getFortress() {
        return fortress;
    }

    public void setFortress(int fortress) {
        this.fortress = fortress;
    }

    public String getTypeNicotine() {
        return typeNicotine;
    }

    public void setTypeNicotine(String typeNicotine) {
        this.typeNicotine = typeNicotine;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }


    public Item getItemForLiquide() {
        return itemForLiquide;
    }

    public void setItemForLiquide(Item itemForLiquide) {
        this.itemForLiquide = itemForLiquide;
    }

//    public Integer getItemForLiquide() {
//        return itemForLiquide;
//    }
//
//    public void setItemForLiquide(Integer itemForLiquide) {
//        this.itemForLiquide = itemForLiquide;
//    }
}
