package co.edu.sena.wariosoftjpa.model.jpa.entities;

import co.edu.sena.wariosoftjpa.model.jpa.entities.Teacher;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-07T07:37:01")
@StaticMetamodel(Specialty.class)
public class Specialty_ { 

    public static volatile SingularAttribute<Specialty, String> nameSpecialty;
    public static volatile SingularAttribute<Specialty, Boolean> state;
    public static volatile CollectionAttribute<Specialty, Teacher> teacherCollection;

}