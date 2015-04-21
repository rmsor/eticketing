/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rmsor_000
 */
@Entity
@Table(name = "user_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserInfo.findAll", query = "SELECT u FROM UserInfo u"),
    @NamedQuery(name = "UserInfo.findById", query = "SELECT u FROM UserInfo u WHERE u.id = :id"),
    @NamedQuery(name = "UserInfo.findByAddressline1", query = "SELECT u FROM UserInfo u WHERE u.addressline1 = :addressline1"),
    @NamedQuery(name = "UserInfo.findByAddressline2", query = "SELECT u FROM UserInfo u WHERE u.addressline2 = :addressline2"),
    @NamedQuery(name = "UserInfo.findByAge", query = "SELECT u FROM UserInfo u WHERE u.age = :age"),
    @NamedQuery(name = "UserInfo.findByDtype", query = "SELECT u FROM UserInfo u WHERE u.dtype = :dtype"),
    @NamedQuery(name = "UserInfo.findByEmail", query = "SELECT u FROM UserInfo u WHERE u.email = :email"),
    @NamedQuery(name = "UserInfo.findByFirstname", query = "SELECT u FROM UserInfo u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "UserInfo.findByGender", query = "SELECT u FROM UserInfo u WHERE u.gender = :gender"),
    @NamedQuery(name = "UserInfo.findByLastname", query = "SELECT u FROM UserInfo u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "UserInfo.findByPassword", query = "SELECT u FROM UserInfo u WHERE u.password = :password"),
    @NamedQuery(name = "UserInfo.findByPhonenumber", query = "SELECT u FROM UserInfo u WHERE u.phonenumber = :phonenumber"),
    @NamedQuery(name = "UserInfo.findByProfilepic", query = "SELECT u FROM UserInfo u WHERE u.profilePic = :profilePic"),
    @NamedQuery(name = "UserInfo.findByRegistereddate", query = "SELECT u FROM UserInfo u WHERE u.registeredDate = :registeredDate"),
    @NamedQuery(name = "UserInfo.findByRole", query = "SELECT u FROM UserInfo u WHERE u.role = :role"),
    @NamedQuery(name = "UserInfo.findByUsername", query = "SELECT u FROM UserInfo u WHERE u.userName = :userName")})
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 255)
    @Column(name = "ADDRESSLINE1")
    private String addressline1;
    @Size(max = 255)
    @Column(name = "ADDRESSLINE2")
    private String addressline2;
    @Size(max = 255)
    @Column(name = "AGE")
    private String age;
    @Size(max = 255)
    @Column(name = "DTYPE")
    private String dtype;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 255)
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Size(max = 255)
    @Column(name = "GENDER")
    private String gender;
    @Size(max = 255)
    @Column(name = "LASTNAME")
    private String lastName;
    @Size(max = 255)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 255)
    @Column(name = "PHONENUMBER")
    private String phonenumber;
    @Size(max = 255)
    @Column(name = "PROFILEPIC")
    private String profilePic;
    @Column(name = "REGISTEREDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredDate;
    @Size(max = 255)
    @Column(name = "ROLE")
    private String role;
    @Size(max = 255)
    @Column(name = "USERNAME")
    private String userName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Reservation> reservationCollection;

    public UserInfo() {
    }

    public UserInfo(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddressLine1() {
        return addressline1;
    }

    public void setAddressLine1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressLine2() {
        return addressline2;
    }

    public void setAddressLine2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phonenumber;
    }

    public void setPhoneNumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @XmlTransient
    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserInfo)) {
            return false;
        }
        UserInfo other = (UserInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UserInfo[ id=" + id + " ]";
    }
    
}
