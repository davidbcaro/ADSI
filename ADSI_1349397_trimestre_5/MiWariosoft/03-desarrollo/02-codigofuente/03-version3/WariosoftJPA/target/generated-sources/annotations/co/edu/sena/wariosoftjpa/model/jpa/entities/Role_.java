package co.edu.sena.wariosoftjpa.model.jpa.entities;

import co.edu.sena.wariosoftjpa.model.jpa.entities.RoleHasClient;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-07T07:37:01")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile SingularAttribute<Role, String> descriptionRole;
    public static volatile SingularAttribute<Role, String> idRole;
    public static volatile CollectionAttribute<Role, RoleHasClient> roleHasClientCollection;
    public static volatile SingularAttribute<Role, Boolean> state;

}