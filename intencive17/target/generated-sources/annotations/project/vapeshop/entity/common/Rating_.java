package project.vapeshop.entity.common;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.user.User;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Rating.class)
public abstract class Rating_ {

	public static volatile SingularAttribute<Rating, Item> item;
	public static volatile SingularAttribute<Rating, Integer> quantityStar;
	public static volatile SingularAttribute<Rating, String> comment;
	public static volatile SingularAttribute<Rating, Integer> id;
	public static volatile SingularAttribute<Rating, User> user;

	public static final String ITEM = "item";
	public static final String QUANTITY_STAR = "quantityStar";
	public static final String COMMENT = "comment";
	public static final String ID = "id";
	public static final String USER = "user";

}

