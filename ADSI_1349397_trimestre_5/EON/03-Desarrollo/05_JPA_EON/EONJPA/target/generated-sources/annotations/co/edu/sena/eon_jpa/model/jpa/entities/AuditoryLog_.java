package co.edu.sena.eon_jpa.model.jpa.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-06T09:21:14")
@StaticMetamodel(AuditoryLog.class)
public class AuditoryLog_ { 

    public static volatile SingularAttribute<AuditoryLog, Date> date;
    public static volatile SingularAttribute<AuditoryLog, String> logName;
    public static volatile SingularAttribute<AuditoryLog, String> level;
    public static volatile SingularAttribute<AuditoryLog, String> message;
    public static volatile SingularAttribute<AuditoryLog, String> user;
    public static volatile SingularAttribute<AuditoryLog, Long> idLog;

}