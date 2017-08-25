/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapps.controller.managebeans.reports;

import com.ejb.model.common.ComDev;
import com.ejb.model.common.ComLib;
import com.ejb.model.common.UniDBLocal;
import com.ejb.model.entity.PaymentHistory;
import com.webapps.controller.managebeans.print.InvoicePrint;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Sameera
 */
@Named(value = "reportCustomerOutstanding")
@SessionScoped
public class ReportCustomerOutstanding implements Serializable {

    /**
     * Creates a new instance of ReportInvoiceCorporate
     */
    @EJB
    private UniDBLocal uniDB;

    @EJB
    private ComDev comDev;

    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    int gop = (int) request.getSession().getAttribute("gopId");

    private String customer;
    private int customer_id;
    private int gop_gup_type = 0;

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

    public List<String> getAutoCompleteList(String query) {
        List<String> list = null;// ((gop_gup_type == 1) ? comDev.getGOPnameList(query) : comDev.getGUPnameList(query));

        switch (this.gop_gup_type) {
            case 1:
                list = comDev.getGOPnameList(query, (int) request.getSession().getAttribute("gopMainId"));
                break;
            case 2:
                list = comDev.getGUPnameList(query, (int) request.getSession().getAttribute("gopMainId"));
                break;
            case 3:
                list = comDev.getIndividualCorporateList(query, (int) request.getSession().getAttribute("gopMainId"));
                break;
            default:
                System.out.println("Invalid Type!");
        }
        return list;
    }

    public void onItemSelect(SelectEvent event) {

        String str = event.getObject().toString();

        String result = str.split("%")[1];

        customer_id = Integer.valueOf(result.trim());

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", result));
    }

    //--------------------------------------------------------------------------
    public static List<InvoiceItems> invoiceItemsesList = new ArrayList<InvoiceItems>();
    private InvoiceItems selectedInvoice;
    private List<InvoiceItems> selectedInvoises;

    public List<InvoiceItems> getInvoiceItemsesList() {
        return invoiceItemsesList;
    }

    public void setInvoiceItemsesList(List<InvoiceItems> invoiceItemsesList) {
        this.invoiceItemsesList = invoiceItemsesList;
    }

    public InvoiceItems getSelectedInvoice() {
        return selectedInvoice;
    }

    public void setSelectedInvoice(InvoiceItems selectedInvoice) {
        this.selectedInvoice = selectedInvoice;
    }

    public List<InvoiceItems> getSelectedInvoises() {
        return selectedInvoises;
    }

    public void setSelectedInvoises(List<InvoiceItems> selectedInvoises) {
        this.selectedInvoises = selectedInvoises;
    }

    @PostConstruct
    public void init() {
        createInvoiceList();
    }

    public void createInvoiceList() {

        invoiceItemsesList.clear();
        List<PaymentHistory> ph = uniDB.searchByQueryLimit("SELECT v FROM PaymentHistory v WHERE v.voucherId.date BETWEEN '" + ComLib.getDate(new Date()) + "' AND '" + ComLib.getDate(new Date()) + "' AND v.voucherId.generalOrganizationProfileId.id='" + gop + "'  AND v.voucherTypeId.id in(1,94)", 500);
        for (PaymentHistory p : ph) {
            invoiceItemsesList.add(new InvoiceItems(p.getVoucherId().getId(), p.getVoucherId().getVoucherId(), ComLib.getDateFormated(p.getVoucherId().getDate()), comDev.getGOPGUPName(p.getReferenceId(), p.getUniversalPersonOrOrgTypeManagerId().getId()), ComLib.getDouble(p.getVoucherId().getVoucherTotal()), ComLib.getDouble(p.getVoucherId().getDue())));
        }
    }

    public void invoiceBySearch() {

        invoiceItemsesList.clear();

        gop_gup_type = ((gop_gup_type == 3) ? 1 : gop_gup_type);

        String query1 = ((customer_id == 0) ? "" : " AND v.universalPersonOrOrgTypeManagerId.id='" + gop_gup_type + "' AND v.referenceId='" + customer_id + "'");

        List<PaymentHistory> ph = uniDB.searchByQueryLimit("SELECT v FROM PaymentHistory v WHERE v.voucherId.generalOrganizationProfileId.id='" + gop + "' " + query1 + " AND v.voucherTypeId.id in(1,94) ORDER BY v.voucherId.id ASC", 500);
        for (PaymentHistory p : ph) {
            System.out.println("R:" + p.getReferenceId() + "Ty:" + p.getUniversalPersonOrOrgTypeManagerId().getId());
            invoiceItemsesList.add(new InvoiceItems(p.getVoucherId().getId(), p.getVoucherId().getVoucherId(), ComLib.getDateFormated(p.getVoucherId().getDate()), comDev.getGOPGUPName(p.getReferenceId(), p.getUniversalPersonOrOrgTypeManagerId().getId()), ComLib.getDouble(p.getVoucherId().getVoucherTotal()), ComLib.getDouble(p.getVoucherId().getDue())));
        }

    }

    public void invoiveFireSelection(ValueChangeEvent event) {

        this.gop_gup_type = Integer.valueOf(event.getNewValue().toString());
        this.customer_id = 0;
        this.customer = "";

    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Car Selected", ((InvoiceItems) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Car Unselected", ((InvoiceItems) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void loadInvoicePrint(InvoiceItems invoice) throws IOException {

        InvoicePrint.invoiceNo = invoice.getId();
        InvoicePrint.invoiceId = invoice.getInvoiceId();
        comDev.getinvoicePrint(invoice.getInvoiceId());

    }

    public static class InvoiceItems implements Serializable {

        public int invoiceId;
        public String id;
        private String date;
        private String customer;
        private String invoiceTotal;
        private String due;

        public InvoiceItems(int invoiceId, String id, String date, String customer, String invoiceTotal, String due) {
            this.invoiceId = invoiceId;
            this.id = id;
            this.date = date;
            this.customer = customer;
            this.invoiceTotal = invoiceTotal;
            this.due = due;
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

        public int getInvoiceId() {
            return invoiceId;
        }

        public void setInvoiceId(int invoiceId) {
            this.invoiceId = invoiceId;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getInvoiceTotal() {
            return invoiceTotal;
        }

        public void setInvoiceTotal(String invoiceTotal) {
            this.invoiceTotal = invoiceTotal;
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
            final InvoiceItems other = (InvoiceItems) obj;
            if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
                return false;
            }
            return true;
        }

    }

}
