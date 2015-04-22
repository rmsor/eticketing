/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.MovieFacade;
import ejb.ShowFacade;
import ejb.TheaterFacade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import model.Movie;
import model.Show;
import model.Theater;

/**
 *
 * @author dharmaraj
 */
@Named("showController")
@RequestScoped
public class ShowController {

    /**
     * Creates a new instance of ShowController
     */
    public ShowController() {

        showList = new ArrayList();
    }

    @PostConstruct
    public void setData() {
        setShowList(showFacade.findAll());
    }

    @Inject
    private MovieFacade movieFacade;

    @Inject
    private TheaterFacade theaterFacade;

    @Inject
    private ShowFacade showFacade;

    private List<Show> showList;

    public List<Show> getShowList() {
        return showList;
    }

    public void setShowList(List<Show> showList) {
        this.showList = showList;
    }

    private Long showID;
    private String startTime;
    private String endTime;
    private String language;
    private String screenType;
    private int availableSeats;
    private int bookedSeats;
    private Movie movieObj;
    private Theater theaterObj;

    private Long movieID;
    private Long theaterID;

    public Long getMovieID() {
        return movieID;
    }

    public void setMovieID(Long movieID) {
        this.movieID = movieID;
    }

    public Long getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(Long theaterID) {
        this.theaterID = theaterID;
    }

    public ShowFacade getShowFacade() {
        return showFacade;
    }

    public void setShowFacade(ShowFacade showFacade) {
        this.showFacade = showFacade;
    }

    public MovieFacade getMovieFacade() {
        return movieFacade;
    }

    public void setMovieFacade(MovieFacade movieFacade) {
        this.movieFacade = movieFacade;
    }

    public TheaterFacade getTheaterFacade() {
        return theaterFacade;
    }

    public void setTheaterFacade(TheaterFacade theaterFacade) {
        this.theaterFacade = theaterFacade;
    }

    public Long getShowID() {
        return showID;
    }

    public void setShowID(Long showID) {
        this.showID = showID;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
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

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public Movie getMovieObj() {
        return movieObj;
    }

    public void setMovieObj(Movie movieObj) {
        this.movieObj = movieObj;
    }

    public Theater getTheaterObj() {
        return theaterObj;
    }

    public void setTheaterObj(Theater theaterObj) {
        this.theaterObj = theaterObj;
    }

    public String addShow() {

        FacesMessage facesMessage;
        Show showEntity = (showID != null) ? showFacade.find(showID) : new Show();

        showEntity.setStTime(startTime);
        showEntity.setEndTime(endTime);
        showEntity.setLanguage(language);
        showEntity.setScreenType(screenType);
        showEntity.setAvailableSeats(availableSeats);
        showEntity.setBookedSeats(bookedSeats);

        setMovieObj(movieFacade.find(movieID));
        setTheaterObj(theaterFacade.find(theaterID));

        showEntity.setMovieid(movieObj);
        showEntity.setTid(theaterObj);
        if (showID != null) {
            showFacade.edit(showEntity);
            facesMessage = new FacesMessage("Show Updated Successfully");
        } else {
            showFacade.create(showEntity);
            facesMessage = new FacesMessage("Show Added Successfully");
        }
        facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        return "/faces/pages/admin/shows?faces-redirect=true";

    }

    public String delete(Long gid) {
        Show showObj = showFacade.find(gid);
        showFacade.remove(showObj);
        FacesMessage facesMessage = new FacesMessage("Deleted Successfully");
        facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        return "/faces/pages/admin/shows?faces-redirect=true";
    }

    public String update(Long gid) {
        Show showEntity = showFacade.find(gid);
        setShowID(gid);
        setStartTime(showEntity.getStTime());
        setEndTime(showEntity.getEndTime());
        setLanguage(showEntity.getLanguage());
        setScreenType(showEntity.getScreenType());
        setAvailableSeats(showEntity.getAvailableSeats());
        setBookedSeats(showEntity.getBookedSeats());
        setMovieID(showEntity.getMovieid().getMovieid());
        setTheaterID(showEntity.getTid().getTid());

        return "/faces/pages/admin/addShow";
    }

}
