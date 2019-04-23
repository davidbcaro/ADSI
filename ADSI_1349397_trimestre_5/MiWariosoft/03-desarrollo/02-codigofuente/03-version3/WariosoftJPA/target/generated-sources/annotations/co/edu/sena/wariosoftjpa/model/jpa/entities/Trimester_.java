package co.edu.sena.wariosoftjpa.model.jpa.entities;

import co.edu.sena.wariosoftjpa.model.jpa.entities.LearningOutcome;
import co.edu.sena.wariosoftjpa.model.jpa.entities.NumberGroupHasTrimester;
import co.edu.sena.wariosoftjpa.model.jpa.entities.TrainingLevel;
import co.edu.sena.wariosoftjpa.model.jpa.entities.TrimesterPK;
import co.edu.sena.wariosoftjpa.model.jpa.entities.WorkingDay;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-07T07:37:01")
@StaticMetamodel(Trimester.class)
public class Trimester_ { 

    public static volatile SingularAttribute<Trimester, WorkingDay> workingDay;
    public static volatile CollectionAttribute<Trimester, LearningOutcome> learningOutcomeCollection;
    public static volatile SingularAttribute<Trimester, TrimesterPK> trimesterPK;
    public static volatile SingularAttribute<Trimester, TrainingLevel> trainingLevel1;
    public static volatile CollectionAttribute<Trimester, NumberGroupHasTrimester> numberGroupHasTrimesterCollection;

}