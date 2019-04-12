package co.edu.sena.eon_jpa.model.jpa.entities;

import co.edu.sena.eon_jpa.model.jpa.entities.ClientPK;
import co.edu.sena.eon_jpa.model.jpa.entities.Document;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-06T09:21:14")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> firstName;
    public static volatile SingularAttribute<Client, ClientPK> clientPK;
    public static volatile SingularAttribute<Client, String> firstLastname;
    public static volatile SingularAttribute<Client, String> secondLastname;
    public static volatile SingularAttribute<Client, Document> document;
    public static volatile SingularAttribute<Client, byte[]> photo;
    public static volatile SingularAttribute<Client, String> secondName;

}