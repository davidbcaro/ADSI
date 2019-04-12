package co.edu.sena.eon_jpa.model.jpa.entities;

import co.edu.sena.eon_jpa.model.jpa.entities.Ficha;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-06T09:21:14")
@StaticMetamodel(StatusFicha.class)
public class StatusFicha_ { 

    public static volatile SingularAttribute<StatusFicha, String> nameState;
    public static volatile SingularAttribute<StatusFicha, Boolean> state;
    public static volatile CollectionAttribute<StatusFicha, Ficha> fichaCollection;

}