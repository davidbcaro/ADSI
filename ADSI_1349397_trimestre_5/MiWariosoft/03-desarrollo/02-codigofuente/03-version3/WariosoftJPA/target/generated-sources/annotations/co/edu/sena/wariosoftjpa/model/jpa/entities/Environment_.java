package co.edu.sena.wariosoftjpa.model.jpa.entities;

import co.edu.sena.wariosoftjpa.model.jpa.entities.EnvironmentPK;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Headquarters;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Schedule;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-07T07:37:01")
@StaticMetamodel(Environment.class)
public class Environment_ { 

    public static volatile CollectionAttribute<Environment, Schedule> scheduleCollection;
    public static volatile SingularAttribute<Environment, Headquarters> headquarters;
    public static volatile SingularAttribute<Environment, EnvironmentPK> environmentPK;
    public static volatile SingularAttribute<Environment, String> description;
    public static volatile SingularAttribute<Environment, Boolean> state;

}