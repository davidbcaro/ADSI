package co.edu.sena.eon_jpa.model.jpa.entities;

import co.edu.sena.eon_jpa.model.jpa.entities.Ambience;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-06T09:21:14")
@StaticMetamodel(Headquarters.class)
public class Headquarters_ { 

    public static volatile SingularAttribute<Headquarters, String> nameHeadquarters;
    public static volatile SingularAttribute<Headquarters, String> address;
    public static volatile SingularAttribute<Headquarters, Boolean> state;
    public static volatile CollectionAttribute<Headquarters, Ambience> ambienceCollection;

}