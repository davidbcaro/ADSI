package co.edu.sena.eon_jpa.model.jpa.entities;

import co.edu.sena.eon_jpa.model.jpa.entities.Activity;
import co.edu.sena.eon_jpa.model.jpa.entities.Competition;
import co.edu.sena.eon_jpa.model.jpa.entities.FichaHasTrimester;
import co.edu.sena.eon_jpa.model.jpa.entities.LearningResultPK;
import co.edu.sena.eon_jpa.model.jpa.entities.Trimester;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-06T09:21:14")
@StaticMetamodel(LearningResult.class)
public class LearningResult_ { 

    public static volatile CollectionAttribute<LearningResult, FichaHasTrimester> fichaHasTrimesterCollection;
    public static volatile CollectionAttribute<LearningResult, Trimester> trimesterCollection;
    public static volatile SingularAttribute<LearningResult, String> description;
    public static volatile SingularAttribute<LearningResult, Competition> competition;
    public static volatile SingularAttribute<LearningResult, LearningResultPK> learningResultPK;
    public static volatile CollectionAttribute<LearningResult, Activity> activityCollection;

}