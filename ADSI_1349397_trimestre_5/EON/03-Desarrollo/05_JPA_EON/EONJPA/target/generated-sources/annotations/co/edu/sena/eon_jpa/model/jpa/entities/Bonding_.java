package co.edu.sena.eon_jpa.model.jpa.entities;

import co.edu.sena.eon_jpa.model.jpa.entities.Instructor;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-06T09:21:14")
@StaticMetamodel(Bonding.class)
public class Bonding_ { 

    public static volatile SingularAttribute<Bonding, Integer> hours;
    public static volatile CollectionAttribute<Bonding, Instructor> instructorCollection;
    public static volatile SingularAttribute<Bonding, String> typeLinkage;
    public static volatile SingularAttribute<Bonding, Boolean> status;

}