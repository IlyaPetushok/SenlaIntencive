package project.vapeshop.entity.user;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Privileges.class)
public abstract class Privileges_ {

	public static volatile SingularAttribute<Privileges, String> name;
	public static volatile SingularAttribute<Privileges, Integer> id;
	public static volatile ListAttribute<Privileges, Role> roleList;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String ROLE_LIST = "roleList";

}

