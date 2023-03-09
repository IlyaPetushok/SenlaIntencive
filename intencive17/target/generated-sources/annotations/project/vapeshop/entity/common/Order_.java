package project.vapeshop.entity.common;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.user.User;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, Date> date;
	public static volatile SingularAttribute<Order, Double> price;
	public static volatile SingularAttribute<Order, Integer> id;
	public static volatile SingularAttribute<Order, User> user;
	public static volatile ListAttribute<Order, Item> items;
	public static volatile SingularAttribute<Order, StatusOrder> status;

	public static final String DATE = "date";
	public static final String PRICE = "price";
	public static final String ID = "id";
	public static final String USER = "user";
	public static final String ITEMS = "items";
	public static final String STATUS = "status";

}

