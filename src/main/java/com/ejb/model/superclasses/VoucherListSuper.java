package com.ejb.model.superclasses;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;

/**
 *
 * @author Sameera
 */
public class VoucherListSuper implements Serializable {

    public int voucherId;
    public String id;
    private String date;
    private String customer;
    private String voucherTotal;
    private String due;
    private String description;
    private String delivery_date;

    public VoucherListSuper(int voucherId, String id, String date, String customer, String voucherTotal, String due, String description, String delivery_date) {
        this.voucherId = voucherId;
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.voucherTotal = voucherTotal;
        this.due = due;
        this.description = description;
        this.delivery_date = delivery_date;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVoucherTotal() {
        return voucherTotal;
    }

    public void setVoucherTotal(String voucherTotal) {
        this.voucherTotal = voucherTotal;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VoucherListSuper other = (VoucherListSuper) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
}
