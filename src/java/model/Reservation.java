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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "reservation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r"),
    @NamedQuery(name = "Reservation.findByReservationid", query = "SELECT r FROM Reservation r WHERE r.reservationid = :reservationid"),
    @NamedQuery(name = "Reservation.findByReservationDate", query = "SELECT r FROM Reservation r WHERE r.reservationDate = :reservationDate"),
    @NamedQuery(name = "Reservation.findByNoOfSeat", query = "SELECT r FROM Reservation r WHERE r.noOfSeat = :noOfSeat"),
    @NamedQuery(name = "Reservation.findByTicketNo", query = "SELECT r FROM Reservation r WHERE r.ticketNo = :ticketNo")})
public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reservationid")
    private Long reservationid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reservationDate")
    @Temporal(TemporalType.DATE)
    private Date reservationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "noOfSeat")
    private int noOfSeat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ticket_no")
    private String ticketNo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservationid")
    private Collection<Creditinfo> creditinfoCollection;
    @JoinColumn(name = "userid", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private UserInfo userid;
    @JoinColumn(name = "showid", referencedColumnName = "showid")
    @ManyToOne(optional = false)
    private Show showid;

    public Reservation() {
    }

    public Reservation(Long reservationid) {
        this.reservationid = reservationid;
    }

    public Reservation(Long reservationid, Date reservationDate, int noOfSeat, String ticketNo) {
        this.reservationid = reservationid;
        this.reservationDate = reservationDate;
        this.noOfSeat = noOfSeat;
        this.ticketNo = ticketNo;
    }

    public Long getReservationid() {
        return reservationid;
    }

    public void setReservationid(Long reservationid) {
        this.reservationid = reservationid;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getNoOfSeat() {
        return noOfSeat;
    }

    public void setNoOfSeat(int noOfSeat) {
        this.noOfSeat = noOfSeat;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    @XmlTransient
    public Collection<Creditinfo> getCreditinfoCollection() {
        return creditinfoCollection;
    }

    public void setCreditinfoCollection(Collection<Creditinfo> creditinfoCollection) {
        this.creditinfoCollection = creditinfoCollection;
    }

    public UserInfo getUserid() {
        return userid;
    }

    public void setUserid(UserInfo userid) {
        this.userid = userid;
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
        hash += (reservationid != null ? reservationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.reservationid == null && other.reservationid != null) || (this.reservationid != null && !this.reservationid.equals(other.reservationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Reservation[ reservationid=" + reservationid + " ]";
    }
    
}
