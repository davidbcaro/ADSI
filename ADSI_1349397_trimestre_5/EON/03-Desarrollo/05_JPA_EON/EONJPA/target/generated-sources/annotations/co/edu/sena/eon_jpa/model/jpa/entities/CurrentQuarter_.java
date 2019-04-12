package co.edu.sena.eon_jpa.model.jpa.entities;

import co.edu.sena.eon_jpa.model.jpa.entities.Version;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-06T09:21:14")
@StaticMetamodel(CurrentQuarter.class)
public class CurrentQuarter_ { 

    public static volatile SingularAttribute<CurrentQuarter, Date> endDate;
    public static volatile CollectionAttribute<CurrentQuarter, Version> versionCollection;
    public static volatile SingularAttribute<CurrentQuarter, String> idCurrentQuarter;
    public static volatile SingularAttribute<CurrentQuarter, Date> startDate;

}