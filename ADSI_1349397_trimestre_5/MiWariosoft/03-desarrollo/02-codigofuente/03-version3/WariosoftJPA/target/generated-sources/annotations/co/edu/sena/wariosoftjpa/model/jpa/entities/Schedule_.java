package co.edu.sena.wariosoftjpa.model.jpa.entities;

import co.edu.sena.wariosoftjpa.model.jpa.entities.Day;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Environment;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Modality;
import co.edu.sena.wariosoftjpa.model.jpa.entities.NumberGroupHasTrimester;
import co.edu.sena.wariosoftjpa.model.jpa.entities.SchedulePK;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Teacher;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Version;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-07T07:37:01")
@StaticMetamodel(Schedule.class)
public class Schedule_ { 

    public static volatile SingularAttribute<Schedule, Environment> environment;
    public static volatile SingularAttribute<Schedule, Modality> nameModality;
    public static volatile SingularAttribute<Schedule, Teacher> teacher;
    public static volatile SingularAttribute<Schedule, String> startTime;
    public static volatile SingularAttribute<Schedule, String> endTime;
    public static volatile SingularAttribute<Schedule, Day> day;
    public static volatile SingularAttribute<Schedule, NumberGroupHasTrimester> numberGroupHasTrimester;
    public static volatile SingularAttribute<Schedule, Version> version;
    public static volatile SingularAttribute<Schedule, SchedulePK> schedulePK;

}