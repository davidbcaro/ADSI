package co.edu.sena.wariosoftjpa.model.jpa.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-07T07:37:01")
@StaticMetamodel(LogError.class)
public class LogError_ { 

    public static volatile SingularAttribute<LogError, Date> date;
    public static volatile SingularAttribute<LogError, String> logName;
    public static volatile SingularAttribute<LogError, String> level;
    public static volatile SingularAttribute<LogError, String> message;
    public static volatile SingularAttribute<LogError, String> user;
    public static volatile SingularAttribute<LogError, Long> idLog;

}