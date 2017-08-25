/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapps.controller.managebeans.task;

import com.ejb.model.common.ComDev;
import com.ejb.model.common.ComLib;
import com.ejb.model.common.UniDBLocal;
import com.ejb.model.entity.PaymentHistory;
import com.ejb.model.entity.VoucherItem;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Sameera
 */
@Named(value = "creditNote")
@SessionScoped
public class CreditNote implements Serializable {

    /**
     * Creates a new instance of CreditNote
     */
    @EJB
    private ComLib comLib;

    @EJB
    private UniDBLocal uniDB;

    @EJB
    private ComDev comDev;

    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    int gop = (int) request.getSession().getAttribute("gopId");
    int main_gop = (int) request.getSession().getAttribute("gopMainId");

    /**
     * Creates a new instance of ReceiptCop
     */
    private String customer;
    private int customer_id;
    private int gop_gup_type;
    private Date date_from;
    private Date date_to;

    private List<String> bankList;

    public List<String> getBankList() {
        return bankList;
    }

    public void setBankList(List<String> bankList) {
        this.bankList = bankList;
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

    //--------------------------------------------------------------------------
    private String creditNoteNo;
    private String creditNoteDate;
    private String RefInvoiceNo;
    private String RefInvoiceDate;
    private String RefInvoiceValue;
    private int RefInvoiceId;

    public int getRefInvoiceId() {
        return RefInvoiceId;
    }

    public void setRefInvoiceId(int RefInvoiceId) {
        this.RefInvoiceId = RefInvoiceId;
    }

    public String getCreditNoteDate() {
        return creditNoteDate;
    }

    public void setCreditNoteDate(String creditNoteDate) {
        this.creditNoteDate = creditNoteDate;
    }

    public String getRefInvoiceNo() {
        return RefInvoiceNo;
    }

    public void setRefInvoiceNo(String RefInvoiceNo) {
        this.RefInvoiceNo = RefInvoiceNo;
    }

    public String getRefInvoiceDate() {
        return RefInvoiceDate;
    }

    public void setRefInvoiceDate(String RefInvoiceDate) {
        this.RefInvoiceDate = RefInvoiceDate;
    }

    public String getRefInvoiceValue() {
        return RefInvoiceValue;
    }

    public void setRefInvoiceValue(String RefInvoiceValue) {
        this.RefInvoiceValue = RefInvoiceValue;
    }

    public String getCreditNoteNo() {
        return creditNoteNo;
    }

    public void setCreditNoteNo(String creditNoteNo) {
        this.creditNoteNo = creditNoteNo;
    }

    public List<String> completeCustomersList(String query) {
        List<String> list = comDev.getGOPnameList(query, main_gop);
        return list;
    }

    public void onInvoiceItemSelect(SelectEvent event) {
        String str = event.getObject().toString();
        String result = str.split("%")[1];
        customer_id = Integer.valueOf(result.trim());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", result));
    }

    public void fireSelection(ValueChangeEvent event) {
        gop_gup_type = Integer.valueOf(event.getNewValue().toString());
        customer_id = 0;
        customer = "";
    }

    public List<String> completeListIndividual(String query) {

        List<String> list = comLib.completeList(query, main_gop, gop_gup_type);// ((gop_gup_type == 1) ? comDev.getGOPnameList(query) : comDev.getGUPnameList(query));

        return list;
    }

    public static List<InvoiceList> invoiceLists = new ArrayList<InvoiceList>();
    private InvoiceList selectedlist;
    private List<InvoiceList> selectedInvoises;

    public List<InvoiceList> getInvoiceLists() {
        return invoiceLists;
    }

    public void setInvoiceLists(List<InvoiceList> invoiceLists) {
        this.invoiceLists = invoiceLists;
    }

    public InvoiceList getSelectedlist() {
        return selectedlist;
    }

    public void setSelectedlist(InvoiceList selectedlist) {
        this.selectedlist = selectedlist;
    }

    public List<InvoiceList> getSelectedInvoises() {
        return selectedInvoises;
    }

    public void setSelectedInvoises(List<InvoiceList> selectedInvoises) {
        this.selectedInvoises = selectedInvoises;
    }

    public void Search() {

        invoiceLists.clear();

        String query1 = ((customer_id == 0) ? "" : " AND v.universalPersonOrOrgTypeManagerId.id='1' AND v.referenceId='" + customer_id + "'");
        String query2 = ((date_from == null && date_to == null) ? "" : " AND v.voucherId.date BETWEEN '" + ComLib.getDate(date_from) + "' AND '" + ComLib.getDate(date_to) + "'");

        List<PaymentHistory> ph = uniDB.searchByQueryLimit("SELECT v FROM PaymentHistory v WHERE v.voucherId.generalOrganizationProfileId.id='" + gop + "' " + query1 + " " + query2 + " AND v.voucherTypeId.id=1 ORDER BY v.voucherId.id ASC", 500);
        for (PaymentHistory p : ph) {

            String description = "";
            List<VoucherItem> vi = uniDB.searchByQueryLimit("SELECT v FROM VoucherItem v WHERE v.voucherId1.id='" + p.getVoucherId().getId() + "'", 500);
            for (VoucherItem item : vi) {
                description += item.getOrgItemId().getItemId() + ", ";
            }

            invoiceLists.add(new InvoiceList(p.getVoucherId().getId(), p.getVoucherId().getVoucherId(), ComLib.getDateFormated(p.getVoucherId().getDate()), comDev.getGOPGUPName(p.getReferenceId(), p.getUniversalPersonOrOrgTypeManagerId().getId()), ComLib.getDouble(p.getVoucherId().getVoucherTotal()), description));
        }
        System.out.println("SELECT v FROM PaymentHistory v WHERE v.voucherId.generalOrganizationProfileId.id='" + gop + "' " + query1 + " " + query2 + " AND v.voucherTypeId.id=1 ORDER BY v.voucherId.id ASC");
    }

    public void SearchIndividual() {

        invoiceLists.clear();

        String query1 = ((customer_id == 0) ? "" : " AND v.universalPersonOrOrgTypeManagerId.id='1' AND v.referenceId='" + customer_id + "'");
        String query2 = ((date_from == null && date_to == null) ? "" : " AND v.voucherId.date BETWEEN '" + ComLib.getDate(date_from) + "' AND '" + ComLib.getDate(date_to) + "'");

        List<PaymentHistory> ph = uniDB.searchByQueryLimit("SELECT v FROM PaymentHistory v WHERE v.voucherId.generalOrganizationProfileId.id='" + gop + "' " + query1 + " " + query2 + " AND v.voucherTypeId.id=94 ORDER BY v.voucherId.id ASC", 500);
        for (PaymentHistory p : ph) {

            String description = "";
            List<VoucherItem> vi = uniDB.searchByQueryLimit("SELECT v FROM VoucherItem v WHERE v.voucherId1.id='" + p.getVoucherId().getId() + "'", 500);
            for (VoucherItem item : vi) {
                description += item.getOrgItemId().getItemId() + ", ";
            }

            invoiceLists.add(new InvoiceList(p.getVoucherId().getId(), p.getVoucherId().getVoucherId(), ComLib.getDateFormated(p.getVoucherId().getDate()), comDev.getGOPGUPName(p.getReferenceId(), p.getUniversalPersonOrOrgTypeManagerId().getId()), ComLib.getDouble(p.getVoucherId().getVoucherTotal()), description));
        }
    }

    public void loadCreditNoteView(InvoiceList invoice) {
        System.out.println("invoice: " + invoice);
        RefInvoiceNo = invoice.getId();
        RefInvoiceId = invoice.getInvoiceId();
        RefInvoiceDate = invoice.getDate();
        RefInvoiceValue = invoice.getInvoiceTotal();
        creditNoteNo = comLib.VIDGenerator(gop, 96);
        comDev.loadCreditNote(invoice.getInvoiceId());

    }

    public void loadCreditNoteViewIndividual(InvoiceList invoice) {

        RefInvoiceNo = invoice.getId();
        RefInvoiceId = invoice.getInvoiceId();
        RefInvoiceDate = invoice.getDate();
        RefInvoiceValue = invoice.getInvoiceTotal();
        creditNoteNo = comLib.VIDGenerator(gop, 97);
        comDev.loadCreditNote(invoice.getInvoiceId());

    }

    public void emptyTable() {

        invoiceLists.clear();

    }

    public void emptyCustomer(AjaxBehaviorEvent event) {
        customer_id = 0;
        if (!customer.equals("")) {
            String result = customer.split("%")[1];
            try {
                if (result != null) {
                    customer_id = Integer.valueOf(result.trim());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    //--------------------------------------------------------------------------
    public static class InvoiceList implements Serializable {

        public int invoiceId;
        public String id;
        private String date;
        private String customer;
        private String invoiceTotal;
        private String description;

        public InvoiceList(int invoiceId, String id, String date, String customer, String invoiceTotal, String desc) {
            this.invoiceId = invoiceId;
            this.id = id;
            this.date = date;
            this.customer = customer;
            this.invoiceTotal = invoiceTotal;
            this.description = desc;
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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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
            final InvoiceList other = (InvoiceList) obj;
            if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
                return false;
            }
            return true;
        }

    }

    public void onRowEdit(RowEditEvent event) {

        InvoiceItem ii = (InvoiceItem) event.getObject();
        ii.setPrice(ii.getLine_total() / ii.getQty());

        RequestContext.getCurrentInstance().update("@form");
        FacesMessage msg = new FacesMessage("Car Edited", ((InvoiceItem) event.getObject()).getProductName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((InvoiceItem) event.getObject()).getProductName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void deleteAction(InvoiceItem order) throws IOException {

        invoiceItemList.remove(order);

    }

    public static ArrayList<InvoiceItem> invoiceItemList = new ArrayList<InvoiceItem>();

    public ArrayList<InvoiceItem> getInvoiceItemList() {
        return invoiceItemList;
    }

    public void setInvoiceItemList(ArrayList<InvoiceItem> invoiceItemList) {
        this.invoiceItemList = invoiceItemList;
    }

    public static class InvoiceItem implements Serializable {

        private String id;
        private String productName;
        public double price;
        public double qty;
        private double line_total;

        public InvoiceItem(String id, String productName, double qty, double price, double lineTotal) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.qty = qty;
            this.line_total = lineTotal;
        }

        public double getTine_total() {
            return line_total;
        }

        public void setTine_total(double tine_total) {
            this.line_total = tine_total;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public double getLine_total() {
            return line_total;
        }

        public void setLine_total(double line_total) {
            this.line_total = line_total;
        }

    }

}
