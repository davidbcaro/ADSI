package co.edu.sena.wariosoftjpa.model.jpa.entities;

import co.edu.sena.wariosoftjpa.model.jpa.entities.Availability;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Client;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Linking;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Schedule;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Specialty;
import co.edu.sena.wariosoftjpa.model.jpa.entities.TeacherPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-07T07:37:01")
@StaticMetamodel(Teacher.class)
public class Teacher_ { 

    public static volatile CollectionAttribute<Teacher, Schedule> scheduleCollection;
    public static volatile SingularAttribute<Teacher, TeacherPK> teacherPK;
    public static volatile CollectionAttribute<Teacher, Availability> availabilityCollection;
    public static volatile SingularAttribute<Teacher, Specialty> nameSpecialty;
    public static volatile SingularAttribute<Teacher, Client> client;
    public static volatile SingularAttribute<Teacher, Linking> typeLinking;

}