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

    private List<Genre> genreList;

    /**
     * Creates a new instance of SignupController
     */
    public GenreController() {
        genreList = new ArrayList();
    }
    
    @PostConstruct
    public void setData(){        
        setGenreList(gF.findAll());
    }

    public String save() {
        Genre gnr = new Genre();
        gnr.setName(name);
        gF.create(gnr);
        FacesMessage facesMessage = new FacesMessage("Genre Added Successfully");
        facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        return "genre?faces-redirect=true";
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

}
