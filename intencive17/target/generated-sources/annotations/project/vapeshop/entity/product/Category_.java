package project.vapeshop.entity.product;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Category.class)
public abstract class Category_ {

	public static volatile SingularAttribute<Category, String> name;
	public static volatile ListAttribute<Category, Item> itemList;
	public static volatile SingularAttribute<Category, Integer> id;

	public static final String NAME = "name";
	public static final String ITEM_LIST = "itemList";
	public static final String ID = "id";

}

