/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapps.controller.managebeans.utility;

import com.ejb.model.common.Security;
import com.ejb.model.common.UniDBLocal;
import com.ejb.model.common.Util;
import com.ejb.model.entity.UserLogin;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Sameera
 */
@Named(value = "privacy")
@SessionScoped
public class Privacy implements Serializable {

    @EJB
    private UniDBLocal uniDB;

    /**
     * Creates a new instance of Privacy
     */
    private String username;
    private String currentPassword;
    private String password;
    private String confirmPassword;

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void changePassword() throws IOException {

        boolean is_confirmed = password.equals(confirmPassword);

        RequestContext contex = RequestContext.getCurrentInstance();
        if (is_confirmed) {

            try {
                UserLogin ul = (UserLogin) uniDB.find(Util.ulId, UserLogin.class);
                boolean is_matched = currentPassword.equals(Security.decrypt(ul.getPassword()));

                if (is_matched) {
                    ul.setPassword(Security.encrypt(password));
                    uniDB.update(ul);

                    username = "";
                    currentPassword = "";
                    password = "";
                    confirmPassword = "";

                    contex.execute("swal('Congradulation!','Changed Successfully!','success')");
                } else {
                    contex.execute("swal('Oops...','Current password is invalid!','error')");
                }

            } catch (GeneralSecurityException ex) {
                Logger.getLogger(Privacy.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            contex.execute("swal('Oops...','Password is not matched!','error')");
        }

    }

//    public void setUsernameValue() {
//        UserLogin ul = Util.ul;
//        username = ul.getUsername();
//    }
}
