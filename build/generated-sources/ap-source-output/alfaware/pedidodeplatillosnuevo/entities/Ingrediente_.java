package alfaware.pedidodeplatillosnuevo.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Ingrediente.class)
public abstract class Ingrediente_ {

	public static volatile SingularAttribute<Ingrediente, Double> costoGramo;
	public static volatile CollectionAttribute<Ingrediente, Platilloingrediente> platilloingredienteCollection;
	public static volatile SingularAttribute<Ingrediente, String> id;
	public static volatile SingularAttribute<Ingrediente, String> nombre;

}

