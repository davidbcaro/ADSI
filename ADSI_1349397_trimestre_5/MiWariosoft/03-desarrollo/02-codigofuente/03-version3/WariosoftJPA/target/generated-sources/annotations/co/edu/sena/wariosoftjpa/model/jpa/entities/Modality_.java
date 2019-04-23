package co.edu.sena.wariosoftjpa.model.jpa.entities;

import co.edu.sena.wariosoftjpa.model.jpa.entities.Schedule;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-07T07:37:01")
@StaticMetamodel(Modality.class)
public class Modality_ { 

    public static volatile CollectionAttribute<Modality, Schedule> scheduleCollection;
    public static volatile SingularAttribute<Modality, String> nameModality;
    public static volatile SingularAttribute<Modality, Boolean> state;

}