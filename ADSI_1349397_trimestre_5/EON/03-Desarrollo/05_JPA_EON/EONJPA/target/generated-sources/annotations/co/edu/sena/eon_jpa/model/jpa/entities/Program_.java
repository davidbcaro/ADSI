package co.edu.sena.eon_jpa.model.jpa.entities;

import co.edu.sena.eon_jpa.model.jpa.entities.Competition;
import co.edu.sena.eon_jpa.model.jpa.entities.Ficha;
import co.edu.sena.eon_jpa.model.jpa.entities.ProgramPK;
import co.edu.sena.eon_jpa.model.jpa.entities.TrainingLevel;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-06T09:21:14")
@StaticMetamodel(Program.class)
public class Program_ { 

    public static volatile CollectionAttribute<Program, Competition> competitionCollection;
    public static volatile SingularAttribute<Program, String> initials;
    public static volatile SingularAttribute<Program, String> name;
    public static volatile SingularAttribute<Program, Boolean> state;
    public static volatile CollectionAttribute<Program, Ficha> fichaCollection;
    public static volatile SingularAttribute<Program, ProgramPK> programPK;
    public static volatile SingularAttribute<Program, TrainingLevel> trainingLevel;

}