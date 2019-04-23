package co.edu.sena.wariosoftjpa.model.jpa.entities;

import co.edu.sena.wariosoftjpa.model.jpa.entities.Activity;
import co.edu.sena.wariosoftjpa.model.jpa.entities.PhasePK;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Project;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-07T07:37:01")
@StaticMetamodel(Phase.class)
public class Phase_ { 

    public static volatile SingularAttribute<Phase, PhasePK> phasePK;
    public static volatile SingularAttribute<Phase, Project> project;
    public static volatile SingularAttribute<Phase, Boolean> state;
    public static volatile CollectionAttribute<Phase, Activity> activityCollection;

}