/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.ReservationFacade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import model.Reservation;

/**
 *
 * @author dharmaraj
 */
@Named("reservationController")
@RequestScoped
public class ReservationController {

    /**
     * Creates a new instance of ReservationController
     */
    public ReservationController() {
        reservationList = new ArrayList();
    }

    @PostConstruct
    public void setData() {
        setReservationList(reservationFacade.findAll());
    }

    @Inject
    private ReservationFacade reservationFacade;

    private List<Reservation> reservationList;

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

}
