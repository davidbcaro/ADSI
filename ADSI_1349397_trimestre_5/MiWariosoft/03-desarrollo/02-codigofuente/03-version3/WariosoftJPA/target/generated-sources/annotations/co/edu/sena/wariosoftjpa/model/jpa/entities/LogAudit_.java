package co.edu.sena.wariosoftjpa.model.jpa.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-07T07:37:01")
@StaticMetamodel(LogAudit.class)
public class LogAudit_ { 

    public static volatile SingularAttribute<LogAudit, Date> date;
    public static volatile SingularAttribute<LogAudit, String> logName;
    public static volatile SingularAttribute<LogAudit, String> level;
    public static volatile SingularAttribute<LogAudit, String> message;
    public static volatile SingularAttribute<LogAudit, String> user;
    public static volatile SingularAttribute<LogAudit, Long> idLog;

}