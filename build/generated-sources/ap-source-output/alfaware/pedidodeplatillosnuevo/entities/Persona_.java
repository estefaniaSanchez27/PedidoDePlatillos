package alfaware.pedidodeplatillosnuevo.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Persona.class)
public abstract class Persona_ {

	public static volatile SingularAttribute<Persona, String> direccion;
	public static volatile SingularAttribute<Persona, String> id;
	public static volatile CollectionAttribute<Persona, Pedido> pedidoCollection;
	public static volatile SingularAttribute<Persona, String> telefono;
	public static volatile SingularAttribute<Persona, String> nombre;

}

