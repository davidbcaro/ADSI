package co.edu.sena.eon_jpa.model.jpa.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-06T09:21:14")
@StaticMetamodel(MailServer.class)
public class MailServer_ { 

    public static volatile SingularAttribute<MailServer, String> password;
    public static volatile SingularAttribute<MailServer, String> smtpHost;
    public static volatile SingularAttribute<MailServer, Integer> mail;
    public static volatile SingularAttribute<MailServer, Boolean> smtpAuth;
    public static volatile SingularAttribute<MailServer, Integer> smtpPort;
    public static volatile SingularAttribute<MailServer, Boolean> smtpStarttlsenable;
    public static volatile SingularAttribute<MailServer, String> messageRecovery;
    public static volatile SingularAttribute<MailServer, String> recoveryCase;

}