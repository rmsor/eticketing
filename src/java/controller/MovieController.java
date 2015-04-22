/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.GenreFacade;
import ejb.MovieFacade;
import helpers.ImageHelper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import model.Genre;
import model.Movie;

/**
 *
 * @author rmsor_000
 */
@Named("movie")
@RequestScoped
public class MovieController {

    @Inject
    private MovieFacade gF;
    @Inject
    private GenreFacade geF;

    private String mname;
    private String rating;
    private Date releaseDate;
    private String caste;
    private String director;
    private String length;
    private Genre genreObj;
    private Long movieid;
    private Long genreid;
    private String profilePic;
    private Part file1;
    private String message;
    private String oldImage;

    private List<Movie> movieList;

    /**
     * Creates a new instance of SignupController
     */
    public MovieController() {
        movieList = new ArrayList();
    }

    @PostConstruct
    public void setData() {
        setMovieList(gF.findAll());
    }

    public String save() throws IOException {
        FacesMessage facesMessage;
        Movie gnr = (movieid != null) ? gF.findById(movieid) : new Movie();
        gnr.setMname(mname);
        gnr.setCaste(caste);
        gnr.setDirector(director);
        gnr.setLength(length);
        gnr.setRating(rating);
        gnr.setReleaseDate(releaseDate);
        genreObj = (Genre) geF.findById(genreid);
        gnr.setGenreid(genreObj);
        String st = "success";
        if (getFile1() != null) {
            st = ImageHelper.upload(file1, oldImage,"movie_pics");
            setMessage(ImageHelper.getMessage());
            if (st.equalsIgnoreCase("success")) {

                String fileName = "";
                if (getFile1() != null) {
                    fileName = "/" + "faces" + "/" + "resources" + "/" + "movie_pics" + "/" + ImageHelper.getNewFileName();
                }
                gnr.setProfilePic(fileName);

            } else {
                facesMessage = new FacesMessage("Could Not Upload Image");
                facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
                FacesContext.getCurrentInstance().addMessage(null, facesMessage);
                return "addMovie";
            }
        }
        if (movieid != null) {
            if (getFile1() == null) {
                gnr.setProfilePic(oldImage);
            }
            gF.edit(gnr);
            facesMessage = new FacesMessage("Movie Updated Successfully");
        } else {
            gF.create(gnr);
            facesMessage = new FacesMessage("Movie Added Successfully");
        }
        facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        return "/faces/pages/admin/movies?faces-redirect=true";

    }

    public String update(Long gid) {
        Movie gnr = gF.findById(gid);;
        setCaste(gnr.getCaste());
        setDirector(gnr.getDirector());
        setMname(gnr.getMname());
        setRating(gnr.getRating());
        setGenreid(gnr.getGenreID());
        setReleaseDate(gnr.getReleaseDate());
        setLength(gnr.getLength());
        setMovieid(gnr.getMovieid());
        setProfilePic(gnr.getProfilePic());
        setOldImage(gnr.getProfilePic());
        return "/faces/pages/admin/addMovie";
    }
    
    
    public String movieDetilsPage(Long movieID)
    {
         Movie gnr = gF.findById(movieID);
        setCaste(gnr.getCaste());
        setDirector(gnr.getDirector());
        setMname(gnr.getMname());
        setRating(gnr.getRating());
        setGenreid(gnr.getGenreID());
        setReleaseDate(gnr.getReleaseDate());
        setLength(gnr.getLength());
        setMovieid(gnr.getMovieid());
        setProfilePic(gnr.getProfilePic());
        setOldImage(gnr.getProfilePic());
        System.out.println("Name="+gnr.getMname());
        return "details";
    }

    public String delete(Long gid) {
        Movie gnr = gF.findById(gid);;
        gF.remove(gnr);
        FacesMessage facesMessage = new FacesMessage("Deleted Successfully");
        facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        return "/faces/pages/admin/movies?faces-redirect=true";
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public Genre getGenreObj() {
        return genreObj;
    }

    public void setGenreObj(Genre genreObj) {
        this.genreObj = genreObj;
    }

    public void setMovieid(Long movieid) {
        this.movieid = movieid;
    }

    public Long getMovieid() {
        return movieid;
    }

    public Long getGenreid() {
        return genreid;
    }

    public void setGenreid(Long genreid) {
        this.genreid = genreid;
    }

    public GenreFacade getGeF() {
        return geF;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setOldImage(String oldImage) {
        this.oldImage = oldImage;
    }

    public String getOldImage() {
        return oldImage;
    }
    

}
