package co.edu.sena.eon_jpa.model.jpa.entities;

import co.edu.sena.eon_jpa.model.jpa.entities.Ambience;
import co.edu.sena.eon_jpa.model.jpa.entities.Day;
import co.edu.sena.eon_jpa.model.jpa.entities.FichaHasTrimester;
import co.edu.sena.eon_jpa.model.jpa.entities.Instructor;
import co.edu.sena.eon_jpa.model.jpa.entities.Modality;
import co.edu.sena.eon_jpa.model.jpa.entities.SchedulePK;
import co.edu.sena.eon_jpa.model.jpa.entities.Version;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-06T09:21:14")
@StaticMetamodel(Schedule.class)
public class Schedule_ { 

    public static volatile SingularAttribute<Schedule, Instructor> instructor;
    public static volatile SingularAttribute<Schedule, Modality> modalityName;
    public static volatile SingularAttribute<Schedule, Ambience> ambience;
    public static volatile SingularAttribute<Schedule, FichaHasTrimester> fichaHasTrimester;
    public static volatile SingularAttribute<Schedule, String> startTime;
    public static volatile SingularAttribute<Schedule, String> endTime;
    public static volatile SingularAttribute<Schedule, Day> day;
    public static volatile SingularAttribute<Schedule, Version> version;
    public static volatile SingularAttribute<Schedule, SchedulePK> schedulePK;

}