package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Reservation;
import model.Show;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-21T22:11:29")
@StaticMetamodel(Creditinfo.class)
public class Creditinfo_ { 

    public static volatile SingularAttribute<Creditinfo, String> expiryDate;
    public static volatile SingularAttribute<Creditinfo, Show> showid;
    public static volatile SingularAttribute<Creditinfo, String> creditCardNo;
    public static volatile SingularAttribute<Creditinfo, Reservation> reservationid;
    public static volatile SingularAttribute<Creditinfo, String> name;
    public static volatile SingularAttribute<Creditinfo, String> type;
    public static volatile SingularAttribute<Creditinfo, Long> userid;

}