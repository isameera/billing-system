/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.superclasses;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Sameera
 */
public class ReportComSuper {

    private String customer;
    private int customer_id;
    private int gop_gup_type;
    private Date date_from;
    private Date date_to;

    private String Total;
    private String Due;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getGop_gup_type() {
        return gop_gup_type;
    }

    public void setGop_gup_type(int gop_gup_type) {
        this.gop_gup_type = gop_gup_type;
    }

    public Date getDate_from() {
        return date_from;
    }

    public void setDate_from(Date date_from) {
        this.date_from = date_from;
    }

    public Date getDate_to() {
        return date_to;
    }

    public void setDate_to(Date date_to) {
        this.date_to = date_to;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }

    public String getDue() {
        return Due;
    }

    public void setDue(String Due) {
        this.Due = Due;
    }

    private List<VoucherListSuper> voucherList = new ArrayList<>();
    private VoucherListSuper selectedVoucher;
    private List<VoucherListSuper> selectedVouchers;

    public List<VoucherListSuper> getVoucherList() {
        return voucherList;
    }

    public void setVoucherList(List<VoucherListSuper> voucherList) {
        this.voucherList = voucherList;
    }

    public VoucherListSuper getSelectedVoucher() {
        return selectedVoucher;
    }

    public void setSelectedVoucher(VoucherListSuper selectedVoucher) {
        this.selectedVoucher = selectedVoucher;
    }

    public List<VoucherListSuper> getSelectedVouchers() {
        return selectedVouchers;
    }

    public void setSelectedVouchers(List<VoucherListSuper> selectedVouchers) {
        this.selectedVouchers = selectedVouchers;
    }

    public void onItemSelect(SelectEvent event) {

        String str = event.getObject().toString();
        String result = str.split("%")[1];
        setCustomer_id(Integer.valueOf(result.trim()));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer Selected", result));

    }

    public void customerTypeSelection(ValueChangeEvent event) {

        setGop_gup_type(Integer.valueOf(event.getNewValue().toString()));
        setCustomer_id(0);
        setCustomer("");

    }

    public void emptyCustomer(AjaxBehaviorEvent event) {

        setCustomer_id(0);
        if (!getCustomer().equals("")) {
            String result = getCustomer().split("%")[1];
            try {
                if (result != null) {
                    setCustomer_id(Integer.valueOf(result.trim()));
                }
            } catch (NumberFormatException e) {
            }
        }

    }
}
