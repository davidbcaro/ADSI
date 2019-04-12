package co.edu.sena.eon_jpa.model.jpa.entities;

import co.edu.sena.eon_jpa.model.jpa.entities.FichaHasTrimester;
import co.edu.sena.eon_jpa.model.jpa.entities.Program;
import co.edu.sena.eon_jpa.model.jpa.entities.StatusFicha;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-06T09:21:14")
@StaticMetamodel(Ficha.class)
public class Ficha_ { 

    public static volatile CollectionAttribute<Ficha, FichaHasTrimester> fichaHasTrimesterCollection;
    public static volatile SingularAttribute<Ficha, String> route;
    public static volatile SingularAttribute<Ficha, StatusFicha> nameState;
    public static volatile SingularAttribute<Ficha, String> numberFicha;
    public static volatile SingularAttribute<Ficha, Date> endDate;
    public static volatile SingularAttribute<Ficha, Program> program;
    public static volatile SingularAttribute<Ficha, Date> startDate;

}