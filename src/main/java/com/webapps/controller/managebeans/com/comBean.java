/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapps.controller.managebeans.com;

import com.ejb.model.common.ComDev;
import com.ejb.model.common.ComLib;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Sameera
 */
@Named(value = "comBean")
@SessionScoped
public class comBean implements Serializable {

    @EJB
    private ComDev comDev;

    private String current_date = ComLib.getDate(new Date());

    private int gop_gup_type = 0;

    public int getGop_gup_type() {
        return gop_gup_type;
    }

    public void setGop_gup_type(int gop_gup_type) {
        this.gop_gup_type = gop_gup_type;
    }

    public String getCurrent_date() {
        return current_date;
    }

    public void setCurrent_date(String current_date) {
        this.current_date = ComLib.getDate(new Date());;
    }

//    public List<String> completeList(String query) {
//
//        List<String> list = ((gop_gup_type == 1) ? comDev.getGOPnameList(query) : comDev.getGUPnameList(query));
//
//        return list;
//    }

    public void onItemSelect(SelectEvent event) {

        String str = event.getObject().toString();

        String result = str.split("%")[1];

//        customer_id = Integer.valueOf(result.trim());

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", result));
    }

        public void fireSelection(ValueChangeEvent event) {
        gop_gup_type = Integer.valueOf(event.getNewValue().toString());
        
    }
    
}
