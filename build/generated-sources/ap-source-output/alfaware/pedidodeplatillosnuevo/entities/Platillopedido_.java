package alfaware.pedidodeplatillosnuevo.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Platillopedido.class)
public abstract class Platillopedido_ {

	public static volatile SingularAttribute<Platillopedido, Platillo> idPlatillo;
	public static volatile SingularAttribute<Platillopedido, String> id;
	public static volatile SingularAttribute<Platillopedido, Integer> cantidad;
	public static volatile SingularAttribute<Platillopedido, Pedido> idPedido;

}

