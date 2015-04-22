package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Creditinfo;
import model.Movie;
import model.Reservation;
import model.Theater;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-21T22:11:29")
@StaticMetamodel(Show.class)
public class Show_ { 

    public static volatile SingularAttribute<Show, Long> showid;
    public static volatile SingularAttribute<Show, Integer> availableSeats;
    public static volatile SingularAttribute<Show, String> stTime;
    public static volatile SingularAttribute<Show, String> screenType;
    public static volatile CollectionAttribute<Show, Reservation> reservationCollection;
    public static volatile SingularAttribute<Show, String> language;
    public static volatile SingularAttribute<Show, Movie> movieid;
    public static volatile SingularAttribute<Show, String> endTime;
    public static volatile CollectionAttribute<Show, Creditinfo> creditinfoCollection;
    public static volatile SingularAttribute<Show, Theater> tid;
    public static volatile SingularAttribute<Show, Integer> bookedSeats;

}