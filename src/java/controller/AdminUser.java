/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author rmsor_000
 */
import java.io.Serializable;
import javax.inject.Named;
   // or import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
// or import javax.faces.bean.SessionScoped;

@Named("adminUser")
@SessionScoped
public class AdminUser implements Serializable {

    private String adminName;
    private String adminPassword;
    private Boolean isLoggedIn = false;

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String newValue) {
        adminName = newValue;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String newValue) {
        adminPassword = newValue;
    }

    public String login() {
        if (adminName.equals("ram") && adminPassword.equals("shyam")) {
            isLoggedIn = true;
            return "pages/admin/dashboard";
        }else{
            FacesMessage facesMessage = new FacesMessage("Registration Failed - user already exists");
            facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            System.out.println("Invalid User Name or Password !!");
            return "pages/adminlogin";
        }
    }

    public Boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public String logout() {
        isLoggedIn = false;
        return "login";
    }

    /* send to login page if they are not logged in */
    public void checkLogin(ComponentSystemEvent event) {

        if (!isLoggedIn) {

            FacesContext context = FacesContext.getCurrentInstance();

            ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();

            handler.performNavigation("pages/adminlogin");

        }

    }
}
