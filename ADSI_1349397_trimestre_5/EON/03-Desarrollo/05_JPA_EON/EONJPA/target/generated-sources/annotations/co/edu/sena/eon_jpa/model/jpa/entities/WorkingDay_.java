package co.edu.sena.eon_jpa.model.jpa.entities;

import co.edu.sena.eon_jpa.model.jpa.entities.Availability;
import co.edu.sena.eon_jpa.model.jpa.entities.Trimester;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-06T09:21:14")
@StaticMetamodel(WorkingDay.class)
public class WorkingDay_ { 

    public static volatile SingularAttribute<WorkingDay, byte[]> image;
    public static volatile CollectionAttribute<WorkingDay, Availability> availabilityCollection;
    public static volatile CollectionAttribute<WorkingDay, Trimester> trimesterCollection;
    public static volatile SingularAttribute<WorkingDay, String> name;
    public static volatile SingularAttribute<WorkingDay, String> description;
    public static volatile SingularAttribute<WorkingDay, Boolean> state;
    public static volatile SingularAttribute<WorkingDay, String> acronymsWorkingDay;

}