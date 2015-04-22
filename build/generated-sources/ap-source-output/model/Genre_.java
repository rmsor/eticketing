package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Movie;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-21T22:11:29")
@StaticMetamodel(Genre.class)
public class Genre_ { 

    public static volatile SingularAttribute<Genre, Long> genreid;
    public static volatile CollectionAttribute<Genre, Movie> movieCollection;
    public static volatile SingularAttribute<Genre, String> name;

}