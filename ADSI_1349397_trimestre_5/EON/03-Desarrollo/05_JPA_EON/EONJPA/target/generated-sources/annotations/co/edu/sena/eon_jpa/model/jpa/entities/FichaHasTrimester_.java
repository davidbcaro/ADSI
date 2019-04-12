package co.edu.sena.eon_jpa.model.jpa.entities;

import co.edu.sena.eon_jpa.model.jpa.entities.Ficha;
import co.edu.sena.eon_jpa.model.jpa.entities.FichaHasTrimesterPK;
import co.edu.sena.eon_jpa.model.jpa.entities.LearningResult;
import co.edu.sena.eon_jpa.model.jpa.entities.Schedule;
import co.edu.sena.eon_jpa.model.jpa.entities.Trimester;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-06T09:21:14")
@StaticMetamodel(FichaHasTrimester.class)
public class FichaHasTrimester_ { 

    public static volatile CollectionAttribute<FichaHasTrimester, Schedule> scheduleCollection;
    public static volatile SingularAttribute<FichaHasTrimester, FichaHasTrimesterPK> fichaHasTrimesterPK;
    public static volatile CollectionAttribute<FichaHasTrimester, LearningResult> learningResultCollection;
    public static volatile SingularAttribute<FichaHasTrimester, Ficha> ficha;
    public static volatile SingularAttribute<FichaHasTrimester, Trimester> trimester;

}