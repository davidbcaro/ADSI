package co.edu.sena.eon_jpa.model.jpa.entities;

import co.edu.sena.eon_jpa.model.jpa.entities.AvailabilityPK;
import co.edu.sena.eon_jpa.model.jpa.entities.Day;
import co.edu.sena.eon_jpa.model.jpa.entities.Instructor;
import co.edu.sena.eon_jpa.model.jpa.entities.WorkingDay;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-06T09:21:14")
@StaticMetamodel(Availability.class)
public class Availability_ { 

    public static volatile SingularAttribute<Availability, WorkingDay> workingDay;
    public static volatile SingularAttribute<Availability, Instructor> instructor;
    public static volatile SingularAttribute<Availability, AvailabilityPK> availabilityPK;
    public static volatile SingularAttribute<Availability, Date> endTime;
    public static volatile SingularAttribute<Availability, Day> day;

}