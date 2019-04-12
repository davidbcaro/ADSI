package co.edu.sena.eon_jpa.model.jpa.entities;

import co.edu.sena.eon_jpa.model.jpa.entities.Client;
import co.edu.sena.eon_jpa.model.jpa.entities.UserPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-06T09:21:14")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Date> dateendind;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> mail;
    public static volatile SingularAttribute<User, Client> client;
    public static volatile SingularAttribute<User, UserPK> userPK;

}