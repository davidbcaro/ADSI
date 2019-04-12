package co.edu.sena.eon_jpa.model.jpa.entities;

import co.edu.sena.eon_jpa.model.jpa.entities.Availability;
import co.edu.sena.eon_jpa.model.jpa.entities.Bonding;
import co.edu.sena.eon_jpa.model.jpa.entities.Client;
import co.edu.sena.eon_jpa.model.jpa.entities.InstructorPK;
import co.edu.sena.eon_jpa.model.jpa.entities.Schedule;
import co.edu.sena.eon_jpa.model.jpa.entities.Speciality;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-06T09:21:14")
@StaticMetamodel(Instructor.class)
public class Instructor_ { 

    public static volatile CollectionAttribute<Instructor, Schedule> scheduleCollection;
    public static volatile CollectionAttribute<Instructor, Availability> availabilityCollection;
    public static volatile SingularAttribute<Instructor, Speciality> specialityName;
    public static volatile SingularAttribute<Instructor, Client> client;
    public static volatile SingularAttribute<Instructor, Bonding> typeLinkage;
    public static volatile SingularAttribute<Instructor, InstructorPK> instructorPK;

}