package project.vapeshop.entity.user;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import project.vapeshop.entity.common.Order;
import project.vapeshop.entity.common.Rating;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> patronymic;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, Role> role;
	public static volatile SingularAttribute<User, String> mail;
	public static volatile SingularAttribute<User, String> surname;
	public static volatile ListAttribute<User, Rating> ratings;
	public static volatile SingularAttribute<User, String> name;
	public static volatile ListAttribute<User, Order> orders;
	public static volatile SingularAttribute<User, Integer> id;
	public static volatile SingularAttribute<User, String> login;

	public static final String PATRONYMIC = "patronymic";
	public static final String PASSWORD = "password";
	public static final String ROLE = "role";
	public static final String MAIL = "mail";
	public static final String SURNAME = "surname";
	public static final String RATINGS = "ratings";
	public static final String NAME = "name";
	public static final String ORDERS = "orders";
	public static final String ID = "id";
	public static final String LOGIN = "login";

}

