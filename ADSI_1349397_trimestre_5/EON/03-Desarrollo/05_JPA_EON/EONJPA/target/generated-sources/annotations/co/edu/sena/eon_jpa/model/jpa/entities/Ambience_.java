package co.edu.sena.eon_jpa.model.jpa.entities;

import co.edu.sena.eon_jpa.model.jpa.entities.AmbiencePK;
import co.edu.sena.eon_jpa.model.jpa.entities.Headquarters;
import co.edu.sena.eon_jpa.model.jpa.entities.Schedule;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-06T09:21:14")
@StaticMetamodel(Ambience.class)
public class Ambience_ { 

    public static volatile CollectionAttribute<Ambience, Schedule> scheduleCollection;
    public static volatile SingularAttribute<Ambience, Headquarters> headquarters;
    public static volatile SingularAttribute<Ambience, AmbiencePK> ambiencePK;
    public static volatile SingularAttribute<Ambience, String> description;
    public static volatile SingularAttribute<Ambience, Boolean> status;

}