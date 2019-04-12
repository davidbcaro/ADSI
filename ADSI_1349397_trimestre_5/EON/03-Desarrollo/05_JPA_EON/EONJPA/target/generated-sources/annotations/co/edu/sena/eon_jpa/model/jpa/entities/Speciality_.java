package co.edu.sena.eon_jpa.model.jpa.entities;

import co.edu.sena.eon_jpa.model.jpa.entities.Instructor;
import co.edu.sena.eon_jpa.model.jpa.entities.Trimester;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-06T09:21:14")
@StaticMetamodel(Speciality.class)
public class Speciality_ { 

    public static volatile CollectionAttribute<Speciality, Instructor> instructorCollection;
    public static volatile SingularAttribute<Speciality, String> specialityName;
    public static volatile CollectionAttribute<Speciality, Trimester> trimesterCollection;
    public static volatile SingularAttribute<Speciality, Boolean> status;

}