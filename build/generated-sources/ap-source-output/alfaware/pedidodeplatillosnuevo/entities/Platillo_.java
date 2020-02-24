package alfaware.pedidodeplatillosnuevo.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Platillo.class)
public abstract class Platillo_ {

	public static volatile SingularAttribute<Platillo, Double> costoPrep;
	public static volatile CollectionAttribute<Platillo, Platilloingrediente> platilloingredienteCollection;
	public static volatile CollectionAttribute<Platillo, Platillopedido> platillopedidoCollection;
	public static volatile SingularAttribute<Platillo, String> id;
	public static volatile SingularAttribute<Platillo, String> nombre;

}

