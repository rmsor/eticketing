package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Genre;
import model.Show;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-21T22:11:29")
@StaticMetamodel(Movie.class)
public class Movie_ { 

    public static volatile SingularAttribute<Movie, Genre> genreid;
    public static volatile CollectionAttribute<Movie, Show> showCollection;
    public static volatile SingularAttribute<Movie, Date> releaseDate;
    public static volatile SingularAttribute<Movie, String> caste;
    public static volatile SingularAttribute<Movie, String> director;
    public static volatile SingularAttribute<Movie, String> rating;
    public static volatile SingularAttribute<Movie, String> length;
    public static volatile SingularAttribute<Movie, Long> movieid;
    public static volatile SingularAttribute<Movie, String> mname;

}