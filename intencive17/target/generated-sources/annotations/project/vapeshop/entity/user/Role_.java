package project.vapeshop.entity.user;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Role.class)
public abstract class Role_ {

	public static volatile ListAttribute<Role, Privileges> privileges;
	public static volatile SingularAttribute<Role, String> name;
	public static volatile SingularAttribute<Role, Integer> id;

	public static final String PRIVILEGES = "privileges";
	public static final String NAME = "name";
	public static final String ID = "id";

}

