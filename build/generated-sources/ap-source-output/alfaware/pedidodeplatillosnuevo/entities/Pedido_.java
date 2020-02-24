package alfaware.pedidodeplatillosnuevo.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pedido.class)
public abstract class Pedido_ {

	public static volatile SingularAttribute<Pedido, String> fecha;
	public static volatile CollectionAttribute<Pedido, Platillopedido> platillopedidoCollection;
	public static volatile SingularAttribute<Pedido, String> id;
	public static volatile SingularAttribute<Pedido, Persona> idPersona;

}

