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
        if (adminName.equals("rmsor.pth02@gmail.com") && adminPassword.equals("admin")) {
            isLoggedIn = true;
            return "/faces/pages/admin/dashboard?faces-redirect=true";
        }else{
            FacesMessage facesMessage = new FacesMessage("Invalid User Name or Password !!");
            facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            return "/faces/pages/adminlogin";
        }
    }

    public Boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public String logout() {
        isLoggedIn = false;
        return "/faces/pages/adminlogin?faces-redirect=true";
    }

    /* send to login page if they are not logged in */
    public void checkLogin(ComponentSystemEvent event) {

        if (!isLoggedIn) {

            FacesContext context = FacesContext.getCurrentInstance();

            ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();

            handler.performNavigation("/faces/pages/adminlogin?faces-redirect=true");

        }

    }
}
