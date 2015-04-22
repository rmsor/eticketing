package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Reservation;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-21T22:11:29")
@StaticMetamodel(UserInfo.class)
public class UserInfo_ { 

    public static volatile SingularAttribute<UserInfo, String> lastName;
    public static volatile SingularAttribute<UserInfo, String> role;
    public static volatile SingularAttribute<UserInfo, String> gender;
    public static volatile SingularAttribute<UserInfo, Date> registeredDate;
    public static volatile SingularAttribute<UserInfo, String> profilePic;
    public static volatile SingularAttribute<UserInfo, String> phonenumber;
    public static volatile SingularAttribute<UserInfo, String> dtype;
    public static volatile CollectionAttribute<UserInfo, Reservation> reservationCollection;
    public static volatile SingularAttribute<UserInfo, String> userName;
    public static volatile SingularAttribute<UserInfo, String> firstName;
    public static volatile SingularAttribute<UserInfo, String> password;
    public static volatile SingularAttribute<UserInfo, String> addressline2;
    public static volatile SingularAttribute<UserInfo, String> addressline1;
    public static volatile SingularAttribute<UserInfo, Long> id;
    public static volatile SingularAttribute<UserInfo, String> age;
    public static volatile SingularAttribute<UserInfo, String> email;

}