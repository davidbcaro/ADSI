package co.edu.sena.wariosoftjpa.model.jpa.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-07T07:37:01")
@StaticMetamodel(ServerEmail.class)
public class ServerEmail_ { 

    public static volatile SingularAttribute<ServerEmail, Boolean> smtpStartTlsEnable;
    public static volatile SingularAttribute<ServerEmail, String> affairRecovery;
    public static volatile SingularAttribute<ServerEmail, String> password;
    public static volatile SingularAttribute<ServerEmail, String> smtpHost;
    public static volatile SingularAttribute<ServerEmail, Boolean> smtpAuth;
    public static volatile SingularAttribute<ServerEmail, Integer> smtpPort;
    public static volatile SingularAttribute<ServerEmail, String> email;
    public static volatile SingularAttribute<ServerEmail, String> recoveryCase;

}