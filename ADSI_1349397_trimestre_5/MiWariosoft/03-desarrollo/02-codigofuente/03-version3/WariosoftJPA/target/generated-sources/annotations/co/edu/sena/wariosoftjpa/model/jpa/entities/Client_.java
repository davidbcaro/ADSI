package co.edu.sena.wariosoftjpa.model.jpa.entities;

import co.edu.sena.wariosoftjpa.model.jpa.entities.ClientPK;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Document;
import co.edu.sena.wariosoftjpa.model.jpa.entities.RoleHasClient;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Teacher;
import co.edu.sena.wariosoftjpa.model.jpa.entities.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-07T07:37:01")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> firstName;
    public static volatile SingularAttribute<Client, ClientPK> clientPK;
    public static volatile SingularAttribute<Client, String> firstLastname;
    public static volatile SingularAttribute<Client, Teacher> teacher;
    public static volatile CollectionAttribute<Client, RoleHasClient> roleHasClientCollection;
    public static volatile SingularAttribute<Client, String> secondLastname;
    public static volatile SingularAttribute<Client, Document> document;
    public static volatile SingularAttribute<Client, byte[]> photo;
    public static volatile SingularAttribute<Client, User> user;
    public static volatile SingularAttribute<Client, String> secondName;

}