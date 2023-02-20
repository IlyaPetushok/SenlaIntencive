package project.vapeshop.entity.product;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Liquide.class)
public abstract class Liquide_ {

	public static volatile SingularAttribute<Liquide, Integer> volume;
	public static volatile SingularAttribute<Liquide, Integer> fortress;
	public static volatile SingularAttribute<Liquide, String> flavour;
	public static volatile SingularAttribute<Liquide, String> typeNicotine;
	public static volatile SingularAttribute<Liquide, Item> itemForLiquide;
	public static volatile SingularAttribute<Liquide, Integer> id;

	public static final String VOLUME = "volume";
	public static final String FORTRESS = "fortress";
	public static final String FLAVOUR = "flavour";
	public static final String TYPE_NICOTINE = "typeNicotine";
	public static final String ITEM_FOR_LIQUIDE = "itemForLiquide";
	public static final String ID = "id";

}

