package co.edu.sena.wariosoftjpa.model.jpa.entities;

import co.edu.sena.wariosoftjpa.model.jpa.entities.NumberGroupHasTrimester;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Program;
import co.edu.sena.wariosoftjpa.model.jpa.entities.StateNumberGroup;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-07T07:37:01")
@StaticMetamodel(NumberGroup.class)
public class NumberGroup_ { 

    public static volatile SingularAttribute<NumberGroup, String> numberGroup;
    public static volatile SingularAttribute<NumberGroup, String> route;
    public static volatile SingularAttribute<NumberGroup, StateNumberGroup> nameState;
    public static volatile SingularAttribute<NumberGroup, Date> endDate;
    public static volatile CollectionAttribute<NumberGroup, NumberGroupHasTrimester> numberGroupHasTrimesterCollection;
    public static volatile SingularAttribute<NumberGroup, Program> program;
    public static volatile SingularAttribute<NumberGroup, Date> startDate;

}