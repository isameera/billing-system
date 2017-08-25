/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapps.controller.managebeans.reports;

import com.ejb.model.businesslogic.OrderRequest;
import com.webapps.controller.managebeans.task.InvoiceCop;
import com.ejb.model.common.ComDev;
import com.ejb.model.common.ComLib;
import com.ejb.model.interfaces.DatatableComInterface;
import com.ejb.model.interfaces.ReportComInterface;
import com.ejb.model.superclasses.ReportComSuper;
import com.ejb.model.superclasses.UniversalSearchResource;
import com.ejb.model.superclasses.VoucherListSuper;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Sameera
 */
@ManagedBean(name = "reportOrderRequest")
@SessionScoped
public class ReportOrderRequest extends ReportComSuper implements DatatableComInterface, ReportComInterface, Serializable {

    @EJB
    private ComLib comLib;

    @EJB
    private OrderRequest orderRequest;

    @EJB
    private ComDev comDev;

    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    int gop = (int) request.getSession().getAttribute("gopId");
    int main_gop = (int) request.getSession().getAttribute("gopMainId");

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

        Map<Integer, UniversalSearchResource> map = comLib.UniversalVoucherSearchByDefaultDate(gop, 92);
        for (Map.Entry<Integer, UniversalSearchResource> entry : map.entrySet()) {
            int key = entry.getKey();
            UniversalSearchResource b = entry.getValue();

            setVoucherList(b.getVoucherList());

        }

    }

    @Override
    public void searchActionCop() {

        Map<Integer, UniversalSearchResource> map = comLib.UniversalVoucherSearch(gop, 92, getCustomer_id(), getGop_gup_type(), getDate_from(), getDate_to());

        for (Map.Entry<Integer, UniversalSearchResource> entry : map.entrySet()) {
            int key = entry.getKey();
            UniversalSearchResource b = entry.getValue();

            setVoucherList(b.getVoucherList());

        }

    }

    @Override
    public void searchActionIndByDefaultDate() {

        Map<Integer, UniversalSearchResource> map = comLib.UniversalVoucherSearchByDefaultDate(gop, 93);

        for (Map.Entry<Integer, UniversalSearchResource> entry : map.entrySet()) {
            int key = entry.getKey();
            UniversalSearchResource b = entry.getValue();

            setVoucherList(b.getVoucherList());

        }

    }

    @Override
    public void searchActionInd() {

        Map<Integer, UniversalSearchResource> map = comLib.UniversalVoucherSearch(gop, 93, getCustomer_id(), getGop_gup_type(), getDate_from(), getDate_to());

        for (Map.Entry<Integer, UniversalSearchResource> entry : map.entrySet()) {
            int key = entry.getKey();
            UniversalSearchResource b = entry.getValue();

            setVoucherList(b.getVoucherList());

        }

    }

    @Override
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Car Selected", ((VoucherListSuper) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    @Override
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Car Unselected", ((VoucherListSuper) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteAction(VoucherListSuper vls) throws IOException {

        orderRequest.deleteAction(vls.getVoucherId());
        getVoucherList().remove(vls);

    }

    public void printAction(VoucherListSuper vls) {
        comDev.getOrderPrint(vls.getVoucherId());
    }

    public void loadInvoice(VoucherListSuper vls) throws IOException {

        InvoiceCop.voucherId = vls.getVoucherId();

        comDev.getinvoiceItemList();

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect("./../invoice.xhtml");
    }

    public void loadInvoiceIndividual(VoucherListSuper vls) throws IOException {

        InvoiceCop.voucherId = vls.getVoucherId();

        comDev.getIndividualInvoiceItemList();

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect("./../invoice-in.xhtml");
    }

}
