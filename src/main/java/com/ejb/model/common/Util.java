/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.common;

import com.ejb.model.entity.GeneralOrganizationProfile;
import com.ejb.model.entity.GeneralUserProfile;
import com.ejb.model.entity.LoginSession;
import com.ejb.model.entity.UserLogin;
import java.io.Serializable;
import org.apache.log4j.Logger;

/**
 *
 * @author Sameera
 */
public class Util implements Serializable {

    static Logger log = Logger.getLogger(Util.class.getName());

    public static int gupId = 0;
    public static int gopId = 0;
    public static int gopIdMain = 0;
    public static int ulId = 0;
    public static int lsId = 0;

    public static GeneralUserProfile gup = null;
    public static GeneralOrganizationProfile gop = null;
    public static UserLogin ul = null;
    public static LoginSession ls = null;
    
    

}
