/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.superclasses;

import java.util.List;

/**
 *
 * @author Sameera
 */
public class UniversalSearchResource {
    
    private List<VoucherListSuper> voucherList;
    private String total;
    private String due;

    public UniversalSearchResource(List<VoucherListSuper> invoiceList, String total, String due) {
        this.voucherList = invoiceList;
        this.total = total;
        this.due = due;
    }

    public List<VoucherListSuper> getVoucherList() {
        return voucherList;
    }

    public void setVoucherList(List<VoucherListSuper> voucherList) {
        this.voucherList = voucherList;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }
    
    
}
