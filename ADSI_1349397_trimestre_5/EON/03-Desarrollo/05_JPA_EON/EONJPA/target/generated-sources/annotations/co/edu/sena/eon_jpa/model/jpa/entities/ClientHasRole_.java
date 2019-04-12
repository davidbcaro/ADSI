package co.edu.sena.eon_jpa.model.jpa.entities;

import co.edu.sena.eon_jpa.model.jpa.entities.Client;
import co.edu.sena.eon_jpa.model.jpa.entities.ClientHasRolePK;
import co.edu.sena.eon_jpa.model.jpa.entities.Role;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-06T09:21:14")
@StaticMetamodel(ClientHasRole.class)
public class ClientHasRole_ { 

    public static volatile SingularAttribute<ClientHasRole, Role> role;
    public static volatile SingularAttribute<ClientHasRole, ClientHasRolePK> clientHasRolePK;
    public static volatile SingularAttribute<ClientHasRole, Client> client;
    public static volatile SingularAttribute<ClientHasRole, Boolean> status;

}