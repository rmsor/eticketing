/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rmsor_000
 */
@Entity
@Table(name = "show")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Show.findAll", query = "SELECT s FROM Show s"),
    @NamedQuery(name = "Show.findByShowid", query = "SELECT s FROM Show s WHERE s.showid = :showid"),
    @NamedQuery(name = "Show.findByStTime", query = "SELECT s FROM Show s WHERE s.stTime = :stTime"),
    @NamedQuery(name = "Show.findByEndTime", query = "SELECT s FROM Show s WHERE s.endTime = :endTime"),
    @NamedQuery(name = "Show.findByLanguage", query = "SELECT s FROM Show s WHERE s.language = :language"),
    @NamedQuery(name = "Show.findByScreenType", query = "SELECT s FROM Show s WHERE s.screenType = :screenType"),
    @NamedQuery(name = "Show.findByAvailableSeats", query = "SELECT s FROM Show s WHERE s.availableSeats = :availableSeats"),
    @NamedQuery(name = "Show.findByBookedSeats", query = "SELECT s FROM Show s WHERE s.bookedSeats = :bookedSeats")})
public class Show implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "showid")
    private Long showid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "stTime")
    private String stTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "endTime")
    private String endTime;
    @Size(max = 100)
    @Column(name = "language")
    private String language;
    @Size(max = 10)
    @Column(name = "screenType")
    private String screenType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "availableSeats")
    private int availableSeats;
    @Column(name = "bookedSeats")
    private Integer bookedSeats;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "showid")
    private Collection<Creditinfo> creditinfoCollection;
    @JoinColumn(name = "movieid", referencedColumnName = "movieid")
    @ManyToOne(optional = false)
    private Movie movieid;
    @JoinColumn(name = "tid", referencedColumnName = "tid")
    @ManyToOne(optional = false)
    private Theater tid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "showid")
    private Collection<Reservation> reservationCollection;

    public Show() {
    }

    public Show(Long showid) {
        this.showid = showid;
    }

    public Show(Long showid, String stTime, String endTime, int availableSeats) {
        this.showid = showid;
        this.stTime = stTime;
        this.endTime = endTime;
        this.availableSeats = availableSeats;
    }

    public Long getShowid() {
        return showid;
    }

    public void setShowid(Long showid) {
        this.showid = showid;
    }

    public String getStTime() {
        return stTime;
    }

    public void setStTime(String stTime) {
        this.stTime = stTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Integer getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(Integer bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    @XmlTransient
    public Collection<Creditinfo> getCreditinfoCollection() {
        return creditinfoCollection;
    }

    public void setCreditinfoCollection(Collection<Creditinfo> creditinfoCollection) {
        this.creditinfoCollection = creditinfoCollection;
    }

    public Movie getMovieid() {
        return movieid;
    }

    public void setMovieid(Movie movieid) {
        this.movieid = movieid;
    }

    public Theater getTid() {
        return tid;
    }

    public void setTid(Theater tid) {
        this.tid = tid;
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
        hash += (showid != null ? showid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Show)) {
            return false;
        }
        Show other = (Show) object;
        if ((this.showid == null && other.showid != null) || (this.showid != null && !this.showid.equals(other.showid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Show[ showid=" + showid + " ]";
    }
    
}
