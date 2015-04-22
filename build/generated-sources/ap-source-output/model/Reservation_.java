package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Creditinfo;
import model.Show;
import model.UserInfo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-21T22:11:29")
@StaticMetamodel(Reservation.class)
public class Reservation_ { 

    public static volatile SingularAttribute<Reservation, Show> showid;
    public static volatile SingularAttribute<Reservation, Long> reservationid;
    public static volatile SingularAttribute<Reservation, String> ticketNo;
    public static volatile SingularAttribute<Reservation, Integer> noOfSeat;
    public static volatile SingularAttribute<Reservation, Date> reservationDate;
    public static volatile SingularAttribute<Reservation, UserInfo> userid;
    public static volatile CollectionAttribute<Reservation, Creditinfo> creditinfoCollection;

}