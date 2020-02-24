package alfaware.pedidodeplatillosnuevo.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Platilloingrediente.class)
public abstract class Platilloingrediente_ {

	public static volatile SingularAttribute<Platilloingrediente, Platillo> idPlatillo;
	public static volatile SingularAttribute<Platilloingrediente, String> id;
	public static volatile SingularAttribute<Platilloingrediente, Double> gramos;
	public static volatile SingularAttribute<Platilloingrediente, Ingrediente> idIngrediente;

}

