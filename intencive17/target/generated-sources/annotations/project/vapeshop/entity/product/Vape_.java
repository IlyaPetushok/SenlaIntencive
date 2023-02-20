package project.vapeshop.entity.product;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Vape.class)
public abstract class Vape_ {

	public static volatile SingularAttribute<Vape, Item> itemForVape;
	public static volatile SingularAttribute<Vape, Integer> id;
	public static volatile SingularAttribute<Vape, Integer> power;
	public static volatile SingularAttribute<Vape, Integer> battery;
	public static volatile SingularAttribute<Vape, String> type;

	public static final String ITEM_FOR_VAPE = "itemForVape";
	public static final String ID = "id";
	public static final String POWER = "power";
	public static final String BATTERY = "battery";
	public static final String TYPE = "type";

}

