/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.GenreFacade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import model.Genre;

/**
 *
 * @author rmsor_000
 */
@Named("genre")
@RequestScoped
public class GenreController {

    @Inject
    private GenreFacade gF;

    private String name;

    private Long genreid;

    private List<Genre> genreList;

    /**
     * Creates a new instance of SignupController
     */
    public GenreController() {
        genreList = new ArrayList();
    }

    @PostConstruct
    public void setData() {
        setGenreList(gF.findAll());
    }

    public String save() {
        FacesMessage facesMessage;
        if (genreid !=null) {
            Genre gnr = gF.findById(genreid);
            gnr.setGenreName(name);
            gF.edit(gnr);
            facesMessage = new FacesMessage("Genre Updated Successfully");
        } else {
            Genre gnr = new Genre();
            gnr.setGenreName(name);
            gF.create(gnr);
            facesMessage = new FacesMessage("Genre Added Successfully");
        }
        facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        return "/faces/pages/admin/genre?faces-redirect=true";
    }

    public String update(Long gid) {
        Genre gnr = gF.findById(gid);;
        setName(gnr.getGenreName());
        setGenreid(gnr.getGenreid());
        return "/faces/pages/admin/addGenre";
    }
    public String delete(Long gid) {
        Genre gnr = gF.findById(gid);;
        gF.remove(gnr);
        FacesMessage facesMessage = new FacesMessage("Deleted Successfully");
        facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        return "/faces/pages/admin/genre?faces-redirect=true";
    }

    public String getGender() {
        return name;
    }

    public void setGender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public void setGenreid(Long genreid) {
        this.genreid = genreid;
    }

    public Long getGenreid() {
        return genreid;
    }

}
