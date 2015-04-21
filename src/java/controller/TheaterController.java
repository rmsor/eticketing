/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.TheaterFacade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Theater;

/**
 *
 * @author dharmaraj
 */
@Named
@RequestScoped
public class TheaterController {

    /**
     * Creates a new instance of TheaterBean
     */
    public TheaterController() {

        theaterList = new ArrayList();

    }
    
    @PostConstruct
    public void setThearterList()
    {
               setTheaterList(theaterFacade.findAll());
 
    }

    @Inject
    private TheaterFacade theaterFacade;

    private List<Theater> theaterList;

    public List<Theater> getTheaterList() {
        return theaterList;
    }

    public void setTheaterList(List<Theater> theaterList) {
        this.theaterList = theaterList;
    }

    private String tName;
    private String tLocation;
    private int tNoScreens;

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettLocation() {
        return tLocation;
    }

    public void settLocation(String tLocation) {
        this.tLocation = tLocation;
    }

    public int gettNoScreens() {
        return tNoScreens;
    }

    public void settNoScreens(int tNoScreens) {
        this.tNoScreens = tNoScreens;
    }

    public String addTheater() {
        Theater theaterEntity = new Theater();
        theaterEntity.setTname(tName);
        theaterEntity.setLocation(tLocation);
        theaterEntity.setNoOfScreens(tNoScreens);
        theaterFacade.create(theaterEntity);
        return "theaters?faces-redirect=true";

    }

}
