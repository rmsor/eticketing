package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Show;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-21T22:11:29")
@StaticMetamodel(Theater.class)
public class Theater_ { 

    public static volatile SingularAttribute<Theater, Integer> noOfScreens;
    public static volatile CollectionAttribute<Theater, Show> showCollection;
    public static volatile SingularAttribute<Theater, String> tname;
    public static volatile SingularAttribute<Theater, String> location;
    public static volatile SingularAttribute<Theater, Long> tid;

}