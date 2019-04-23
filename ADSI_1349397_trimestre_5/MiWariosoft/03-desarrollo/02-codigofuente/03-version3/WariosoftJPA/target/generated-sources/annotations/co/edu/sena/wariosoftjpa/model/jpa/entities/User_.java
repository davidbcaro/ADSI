package co.edu.sena.wariosoftjpa.model.jpa.entities;

import co.edu.sena.wariosoftjpa.model.jpa.entities.Client;
import co.edu.sena.wariosoftjpa.model.jpa.entities.UserPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-07T07:37:01")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> dateTerminate;
    public static volatile SingularAttribute<User, Client> client;
    public static volatile SingularAttribute<User, UserPK> userPK;
    public static volatile SingularAttribute<User, String> email;

}