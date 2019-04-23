package co.edu.sena.wariosoftjpa.model.jpa.entities;

import co.edu.sena.wariosoftjpa.model.jpa.entities.CompetitionPK;
import co.edu.sena.wariosoftjpa.model.jpa.entities.LearningOutcome;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Program;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-07T07:37:01")
@StaticMetamodel(Competition.class)
public class Competition_ { 

    public static volatile SingularAttribute<Competition, CompetitionPK> competitionPK;
    public static volatile CollectionAttribute<Competition, LearningOutcome> learningOutcomeCollection;
    public static volatile SingularAttribute<Competition, String> description;
    public static volatile SingularAttribute<Competition, Program> program;

}