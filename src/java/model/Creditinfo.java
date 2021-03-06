/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rmsor_000
 */
@Entity
@Table(name = "creditinfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Creditinfo.findAll", query = "SELECT c FROM Creditinfo c"),
    @NamedQuery(name = "Creditinfo.findByUserid", query = "SELECT c FROM Creditinfo c WHERE c.userid = :userid"),
    @NamedQuery(name = "Creditinfo.findByCreditCardNo", query = "SELECT c FROM Creditinfo c WHERE c.creditCardNo = :creditCardNo"),
    @NamedQuery(name = "Creditinfo.findByType", query = "SELECT c FROM Creditinfo c WHERE c.type = :type"),
    @NamedQuery(name = "Creditinfo.findByName", query = "SELECT c FROM Creditinfo c WHERE c.name = :name"),
    @NamedQuery(name = "Creditinfo.findByExpiryDate", query = "SELECT c FROM Creditinfo c WHERE c.expiryDate = :expiryDate")})
public class Creditinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userid")
    private Long userid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "creditCardNo")
    private String creditCardNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "expiryDate")
    private String expiryDate;
    @JoinColumn(name = "reservationid", referencedColumnName = "reservationid")
    @ManyToOne(optional = false)
    private Reservation reservationid;
    @JoinColumn(name = "showid", referencedColumnName = "showid")
    @ManyToOne(optional = false)
    private Show showid;

    public Creditinfo() {
    }

    public Creditinfo(Long userid) {
        this.userid = userid;
    }

    public Creditinfo(Long userid, String creditCardNo, String type, String name, String expiryDate) {
        this.userid = userid;
        this.creditCardNo = creditCardNo;
        this.type = type;
        this.name = name;
        this.expiryDate = expiryDate;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Reservation getReservationid() {
        return reservationid;
    }

    public void setReservationid(Reservation reservationid) {
        this.reservationid = reservationid;
    }

    public Show getShowid() {
        return showid;
    }

    public void setShowid(Show showid) {
        this.showid = showid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Creditinfo)) {
            return false;
        }
        Creditinfo other = (Creditinfo) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Creditinfo[ userid=" + userid + " ]";
    }
    
}
