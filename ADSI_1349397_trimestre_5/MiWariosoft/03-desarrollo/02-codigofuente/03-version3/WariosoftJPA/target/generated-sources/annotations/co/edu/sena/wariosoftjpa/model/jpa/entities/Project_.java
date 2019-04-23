package co.edu.sena.wariosoftjpa.model.jpa.entities;

import co.edu.sena.wariosoftjpa.model.jpa.entities.Phase;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-07T07:37:01")
@StaticMetamodel(Project.class)
public class Project_ { 

    public static volatile CollectionAttribute<Project, Phase> phaseCollection;
    public static volatile SingularAttribute<Project, String> projectCode;
    public static volatile SingularAttribute<Project, String> nameProject;
    public static volatile SingularAttribute<Project, Boolean> state;

}