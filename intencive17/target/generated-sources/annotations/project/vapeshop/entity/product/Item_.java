package project.vapeshop.entity.product;

import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import project.vapeshop.entity.common.Order;
import project.vapeshop.entity.common.Rating;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Item.class)
public abstract class Item_ {

	public static volatile SingularAttribute<Item, Integer> quantity;
	public static volatile SingularAttribute<Item, Liquide> liquide;
	public static volatile SingularAttribute<Item, BigDecimal> price;
	public static volatile ListAttribute<Item, Rating> ratings;
	public static volatile SingularAttribute<Item, Vape> vape;
	public static volatile SingularAttribute<Item, String> name;
	public static volatile SingularAttribute<Item, String> photo;
	public static volatile SingularAttribute<Item, Integer> id;
	public static volatile SingularAttribute<Item, Category> category;
	public static volatile ListAttribute<Item, Order> order;
	public static volatile SingularAttribute<Item, Vaporizer> vaporizer;

	public static final String QUANTITY = "quantity";
	public static final String LIQUIDE = "liquide";
	public static final String PRICE = "price";
	public static final String RATINGS = "ratings";
	public static final String VAPE = "vape";
	public static final String NAME = "name";
	public static final String PHOTO = "photo";
	public static final String ID = "id";
	public static final String CATEGORY = "category";
	public static final String ORDER = "order";
	public static final String VAPORIZER = "vaporizer";

}

