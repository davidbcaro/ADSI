package co.edu.sena.eon_jpa.model.jpa.entities;

import co.edu.sena.eon_jpa.model.jpa.entities.Schedule;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-06T09:21:15")
@StaticMetamodel(Modality.class)
public class Modality_ { 

    public static volatile CollectionAttribute<Modality, Schedule> scheduleCollection;
    public static volatile SingularAttribute<Modality, String> modalityName;
    public static volatile SingularAttribute<Modality, Boolean> state;

}