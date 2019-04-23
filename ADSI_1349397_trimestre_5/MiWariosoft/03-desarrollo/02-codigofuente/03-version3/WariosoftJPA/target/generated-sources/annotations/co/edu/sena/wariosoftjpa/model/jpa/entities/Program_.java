package co.edu.sena.wariosoftjpa.model.jpa.entities;

import co.edu.sena.wariosoftjpa.model.jpa.entities.Competition;
import co.edu.sena.wariosoftjpa.model.jpa.entities.NumberGroup;
import co.edu.sena.wariosoftjpa.model.jpa.entities.ProgramPK;
import co.edu.sena.wariosoftjpa.model.jpa.entities.TrainingLevel;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-07T07:37:01")
@StaticMetamodel(Program.class)
public class Program_ { 

    public static volatile CollectionAttribute<Program, Competition> competitionCollection;
    public static volatile SingularAttribute<Program, String> initials;
    public static volatile CollectionAttribute<Program, NumberGroup> numberGroupCollection;
    public static volatile SingularAttribute<Program, String> name;
    public static volatile SingularAttribute<Program, Boolean> state;
    public static volatile SingularAttribute<Program, ProgramPK> programPK;
    public static volatile SingularAttribute<Program, TrainingLevel> trainingLevel;

}