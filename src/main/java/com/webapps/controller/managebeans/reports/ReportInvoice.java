/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapps.controller.managebeans.reports;

import com.ejb.model.businesslogic.Invoice;
import com.ejb.model.common.ComDev;
import com.ejb.model.common.ComLib;
import com.ejb.model.superclasses.VoucherListSuper;
import com.ejb.model.superclasses.ReportComSuper;
import com.ejb.model.superclasses.UniversalSearchResource;
import com.webapps.controller.managebeans.print.InvoicePrint;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import com.ejb.model.interfaces.DatatableComInterface;
import com.ejb.model.interfaces.ReportComInterface;

/**
 *
 * @author Sameera
 */
@Named(value = "reportInvoice")
@SessionScoped
public class ReportInvoice extends ReportComSuper implements DatatableComInterface, ReportComInterface, Serializable {

    @EJB
    private ComLib comLib;

    @EJB
    private Invoice invoice;

    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    int gop = (int) request.getSession().getAttribute("gopId");
    int main_gop = (int) request.getSession().getAttribute("gopMainId");

    @EJB
    private ComDev comDev;

    @Override
    public List<String> customerAutoCompleteCop(String query) {

        setGop_gup_type(1);
        List<String> list = comDev.getGOPnameList(query, main_gop);

        return list;
    }

    @Override
    public List<String> customerAutoComplete(String query) {

        List<String> list = comLib.completeList(query, main_gop, getGop_gup_type());

        return list;
    }


    @Override
    public void searchActionCopByDefaultDate() {

        Map<Integer, UniversalSearchResource> map = comLib.UniversalVoucherSearchByDefaultDate(gop, 1);
        for (Map.Entry<Integer, UniversalSearchResource> entry : map.entrySet()) {
            int key = entry.getKey();
            UniversalSearchResource b = entry.getValue();

            setTotal(b.getTotal());
            setDue(b.getDue());
            setVoucherList(b.getVoucherList());

        }

    }

    @Override
    public void searchActionCop() {

        Map<Integer, UniversalSearchResource> map = comLib.UniversalVoucherSearch(gop, 1, getCustomer_id(), getGop_gup_type(), getDate_from(), getDate_to());

        for (Map.Entry<Integer, UniversalSearchResource> entry : map.entrySet()) {
            int key = entry.getKey();
            UniversalSearchResource b = entry.getValue();

            setTotal(b.getTotal());
            setDue(b.getDue());
            setVoucherList(b.getVoucherList());

        }

    }

    @Override
    public void searchActionIndByDefaultDate() {

        Map<Integer, UniversalSearchResource> map = comLib.UniversalVoucherSearchByDefaultDate(gop, 94);

        for (Map.Entry<Integer, UniversalSearchResource> entry : map.entrySet()) {
            int key = entry.getKey();
            UniversalSearchResource b = entry.getValue();

            setTotal(b.getTotal());
            setDue(b.getDue());
            setVoucherList(b.getVoucherList());

        }

    }

    @Override
    public void searchActionInd() {

        Map<Integer, UniversalSearchResource> map = comLib.UniversalVoucherSearch(gop, 94, getCustomer_id(), getGop_gup_type(), getDate_from(), getDate_to());

        for (Map.Entry<Integer, UniversalSearchResource> entry : map.entrySet()) {
            int key = entry.getKey();
            UniversalSearchResource b = entry.getValue();

            setTotal(b.getTotal());
            setDue(b.getDue());
            setVoucherList(b.getVoucherList());

        }

    }

    @Override
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Item Selected", ((VoucherListSuper) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    @Override
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Item Unselected", ((VoucherListSuper) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteAction(VoucherListSuper invoiceListSuper) throws IOException {

        invoice.deleteInvoice(invoiceListSuper.getVoucherId());
        getVoucherList().remove(invoiceListSuper);

    }

    public void printAction(VoucherListSuper invoiceListSuper) {
        InvoicePrint.invoiceNo = invoiceListSuper.getId();
        InvoicePrint.invoiceId = invoiceListSuper.getVoucherId();
        comDev.getinvoicePrint(invoiceListSuper.getVoucherId());
    }

}
