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
@Table(name = "genre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Genre.findAll", query = "SELECT g FROM Genre g"),
    @NamedQuery(name = "Genre.findByGenreid", query = "SELECT g FROM Genre g WHERE g.genreid = :genreid"),
    @NamedQuery(name = "Genre.findByName", query = "SELECT g FROM Genre g WHERE g.genreName = :name")})
public class Genre implements Serializable {
    @OneToMany(mappedBy = "genreid")
    private Collection<Movie> movieCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "genreid")
    private Long genreid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "genreName")
    private String genreName;
    

    public Genre() {
    }

    public Genre(Long genreid) {
        this.genreid = genreid;
    }

    public Genre(Long genreid, String genreName) {
        this.genreid = genreid;
        this.genreName = genreName;
    }

    public Long getGenreid() {
        return genreid;
    }

    public void setGenreid(Long genreid) {
        this.genreid = genreid;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (genreid != null ? genreid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genre)) {
            return false;
        }
        Genre other = (Genre) object;
        if ((this.genreid == null && other.genreid != null) || (this.genreid != null && !this.genreid.equals(other.genreid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Genre[ genreid=" + genreid + " ]";
    }

    @XmlTransient
    public Collection<Movie> getMovieCollection() {
        return movieCollection;
    }

    public void setMovieCollection(Collection<Movie> movieCollection) {
        this.movieCollection = movieCollection;
    }
    
}
