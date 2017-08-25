/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapps.controller.managebeans.task;

import com.ejb.model.common.ComDev;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Sameera
 */
@Named(value = "corporateOrderRequest")
@RequestScoped
public class CorporateOrderRequest {

    @EJB
    private ComDev comDev;

    /**
     * Creates a new instance of CorporateOrderRequest
     */
    public CorporateOrderRequest() {
    }

    private String cutomer;
    private String date;
    private String color_des;
    private String advance;
    private String delivery_date;
    private String printing_des;

    public String getCutomer() {
        return cutomer;
    }

    public void setCutomer(String cutomer) {
        this.cutomer = cutomer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getColor_des() {
        return color_des;
    }

    public void setColor_des(String color_des) {
        this.color_des = color_des;
    }

    public String getAdvance() {
        return advance;
    }

    public void setAdvance(String advance) {
        this.advance = advance;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getPrinting_des() {
        return printing_des;
    }

    public void setPrinting_des(String printing_des) {
        this.printing_des = printing_des;
    }

    public void SaveCorporateOrderRequest() {

        RequestContext contex = RequestContext.getCurrentInstance();

        contex.execute("swal('Congradulation!','Saved Successfully','success')");
    }


}
