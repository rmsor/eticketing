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
    public void setThearterList() {

        setTheaterList(theaterFacade.findAll());
        System.out.println("Hello Size=" + theaterList.size());

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

    private Long tID;

    public Long gettID() {
        return tID;
    }

    public void settID(Long tID) {
        this.tID = tID;
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

        System.out.println("TID=" + tID);

        if (tID != null) {

            Theater theaterEntity = new Theater();
            theaterEntity.setTid(tID);
            theaterEntity.setTname(tName);
            theaterEntity.setLocation(tLocation);
            theaterEntity.setNoOfScreens(tNoScreens);
            theaterFacade.edit(theaterEntity);

            return "theaters?faces-redirect=true";

        } else {
            Theater theaterEntity = new Theater();
            theaterEntity.setTname(tName);
            theaterEntity.setLocation(tLocation);
            theaterEntity.setNoOfScreens(tNoScreens);
            theaterFacade.create(theaterEntity);
            return "theaters?faces-redirect=true";
        }

    }

    public String deleteRecord(long deleteID) {
        Theater t = theaterFacade.find(deleteID);
        theaterFacade.remove(t);
        System.out.println(" Delete ID=" + deleteID);
        return "theaters?faces-redirect=true";

    }

    public String editPageDisplay(long editID) {

        System.out.println("Edit ID=" + editID);

        Theater t = theaterFacade.find(editID);
        settID(t.getTid());
        settName(t.getTname());
        settLocation(t.getLocation());
        settNoScreens(t.getNoOfScreens());

        System.out.println("After set ID=" + tID + "=" + tName);

        return "addTheaters?faces-redirect=false";
    }

}
