/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.businesslogic;

import com.ejb.model.common.Security;
import com.ejb.model.common.UniDBLocal;
import com.ejb.model.common.Util;
import com.ejb.model.entity.UserLogin;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Sameera
 */
@Stateless
@LocalBean
public class Login {

    @EJB
    private UniDBLocal uniDB;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public boolean ValidateUserLogin(String username, String password) {

        boolean b = false;
        List<UserLogin> ul = uniDB.searchByQuery("SELECT u FROM UserLogin u WHERE u.username='" + username + "'");
        for (UserLogin userLogin : ul) {
            String pass = "";
            try {
                pass = Security.decrypt(userLogin.getPassword());
            } catch (Exception e) {
            }

            b = ((pass.equals(password)));

            if (b) {
                Util.ul = userLogin;
            }

        }

//        Object userlogin = uniDB.searchByQuerySingle("SELECT u FROM UserLogin u WHERE u.username='" + username + "' ");
        return b;
    }

}
