package co.edu.sena.eon_jpa.model.jpa.entities;

import co.edu.sena.eon_jpa.model.jpa.entities.FichaHasTrimester;
import co.edu.sena.eon_jpa.model.jpa.entities.LearningResult;
import co.edu.sena.eon_jpa.model.jpa.entities.Speciality;
import co.edu.sena.eon_jpa.model.jpa.entities.TrimesterPK;
import co.edu.sena.eon_jpa.model.jpa.entities.WorkingDay;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-06T09:21:14")
@StaticMetamodel(Trimester.class)
public class Trimester_ { 

    public static volatile SingularAttribute<Trimester, WorkingDay> workingDay;
    public static volatile SingularAttribute<Trimester, Speciality> speciality;
    public static volatile CollectionAttribute<Trimester, FichaHasTrimester> fichaHasTrimesterCollection;
    public static volatile SingularAttribute<Trimester, TrimesterPK> trimesterPK;
    public static volatile CollectionAttribute<Trimester, LearningResult> learningResultCollection;

}