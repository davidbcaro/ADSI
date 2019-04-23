package co.edu.sena.wariosoftjpa.model.jpa.entities;

import co.edu.sena.wariosoftjpa.model.jpa.entities.ActivityPK;
import co.edu.sena.wariosoftjpa.model.jpa.entities.LearningOutcome;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Phase;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-07T07:37:01")
@StaticMetamodel(Activity.class)
public class Activity_ { 

    public static volatile SingularAttribute<Activity, Phase> phase;
    public static volatile SingularAttribute<Activity, ActivityPK> activityPK;
    public static volatile SingularAttribute<Activity, String> nameActivity;
    public static volatile CollectionAttribute<Activity, LearningOutcome> learningOutcomeCollection;

}