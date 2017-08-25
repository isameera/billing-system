/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapps.controller.managebeans.task;

import com.ejb.model.businesslogic.Invoice;
import com.ejb.model.common.ComLib;
import com.ejb.model.entity.LoginSession;
import com.ejb.model.entity.UserLogin;
import static com.webapps.controller.managebeans.task.OrderBean.log;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
@Named(value = "outstandingEntryForm")
@SessionScoped
public class OutstandingEntryForm implements Serializable {

    @EJB
    private ComLib comLib;

    @EJB
    private Invoice invoice;

    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    int gop = (int) request.getSession().getAttribute("gopId");
    int main_gop = (int) request.getSession().getAttribute("gopMainId");
    LoginSession ls = (LoginSession) request.getSession().getAttribute("loginsession");
    UserLogin ul = (UserLogin) request.getSession().getAttribute("userloin");

    private int gop_gup_type;
    private String customer;
    private int customer_id;

    public int getGop_gup_type() {
        return gop_gup_type;
    }

    public void setGop_gup_type(int gop_gup_type) {
        this.gop_gup_type = gop_gup_type;
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

    public List<String> completeCustomersList(String query) {

        List<String> list = comLib.completeList(query, main_gop, gop_gup_type);

        return list;

    }

    public void onCustomerSelect(SelectEvent event) {

        try {
            String str = event.getObject().toString();

            String result = str.split("%")[1];

            customer_id = Integer.valueOf(result.trim());

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", result));
        } catch (Exception ex) {
            log.error("This is an Error: " + ex);
        }
    }

    //--------------------------------------------------------------------------
    private String invoiceNo;
    private String date;
    private Date datebject;
    private String invoiceTotal;
    private String outstandingAmount;

    public Date getDatebject() {
        return datebject;
    }

    public void setDatebject(Date datebject) {
        this.datebject = datebject;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
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

    public String getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(String outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }

    //--------------------------------------------------------------------------
    public static ArrayList<InvoiceList> invoiceLists = new ArrayList<InvoiceList>();

    public ArrayList<InvoiceList> getInvoiceLists() {
        return invoiceLists;
    }

    public void setInvoiceLists(ArrayList<InvoiceList> invoiceLists) {
        OutstandingEntryForm.invoiceLists = invoiceLists;
    }

    private String netTotal;
    private double netTotalDouble;

    private String netOutstanding;
    private double netOutstandingDouble;

    public String getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(String netTotal) {
        this.netTotal = netTotal;
    }

    public double getNetTotalDouble() {
        return netTotalDouble;
    }

    public void setNetTotalDouble(double netTotalDouble) {
        this.netTotalDouble = netTotalDouble;
    }

    public String getNetOutstanding() {
        return netOutstanding;
    }

    public void setNetOutstanding(String netOutstanding) {
        this.netOutstanding = netOutstanding;
    }

    public double getNetOutstandingDouble() {
        return netOutstandingDouble;
    }

    public void setNetOutstandingDouble(double netOutstandingDouble) {
        this.netOutstandingDouble = netOutstandingDouble;
    }

    public void addRow() throws IOException {

        boolean b = false;
        for (InvoiceList i : invoiceLists) {

            b = ((i.getInvoiceNo().equals(this.invoiceNo)) ? true : false);
            if (b) {
                break;
            }
        }

        if (b) {
            RequestContext contex = RequestContext.getCurrentInstance();
            contex.execute("swal('Duplicate Entry!','Item name is already exists in the table...!','error')");
        } else {

            InvoiceList il = new InvoiceList(invoiceNo, date, invoiceTotal, outstandingAmount);
            invoiceLists.add(il);

            invoiceNo = "";
            date = "";
            datebject = null;
            invoiceTotal = "";
            outstandingAmount = "";

            netTotal = "";
            netTotalDouble = 0;
            netOutstanding = "";
            netOutstandingDouble = 0;

            for (InvoiceList o : invoiceLists) {
                netTotalDouble += Double.parseDouble(o.invoiceTotal);
                netOutstandingDouble += Double.parseDouble(o.outstandingAmount);
            }

            netTotal = ComLib.getDouble(netTotalDouble);
            netOutstanding = ComLib.getDouble(netOutstandingDouble);

        }
//        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
//        context.redirect("./order-request.xhtml");
//        return "/secured/order-request.xhtml";
    }

    public void onRowEdit(RowEditEvent event) {

        netTotal = "";
        netTotalDouble = 0;
        netOutstanding = "";
        netOutstandingDouble = 0;

        for (InvoiceList o : invoiceLists) {
            netTotalDouble += Double.parseDouble(o.invoiceTotal);
            netOutstandingDouble += Double.parseDouble(o.outstandingAmount);
        }

        netTotal = ComLib.getDouble(netTotalDouble);
        netOutstanding = ComLib.getDouble(netOutstandingDouble);

        RequestContext.getCurrentInstance().update("@form");
        FacesMessage msg = new FacesMessage("Car Edited", ((InvoiceList) event.getObject()).getInvoiceNo());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((InvoiceList) event.getObject()).getInvoiceNo());
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

    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        setDate(format.format(event.getObject()));
        setDatebject(ComLib.getDateObjectUltima(event.getObject().toString()));
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));

    }

    public void fireSelection(ValueChangeEvent event) {
        gop_gup_type = Integer.valueOf(event.getNewValue().toString());

        customer_id = 0;
        customer = "";
    }

    public void deleteAction(InvoiceList il) throws IOException {

        invoiceLists.remove(il);

        netTotal = "";
        netTotalDouble = 0;
        netOutstanding = "";
        netOutstandingDouble = 0;

        for (InvoiceList o : invoiceLists) {
            netTotalDouble += Double.parseDouble(o.invoiceTotal);
            netOutstandingDouble += Double.parseDouble(o.outstandingAmount);
        }

        netTotal = ComLib.getDouble(netTotalDouble);
        netOutstanding = ComLib.getDouble(netOutstandingDouble);

    }

    public void Save() {

        gop_gup_type = ((gop_gup_type == 3) ? 1 : gop_gup_type);

        int voucher_type = ((gop_gup_type == 1) ? 1 : 94);

        invoice.SaveOutstandingInvoice(gop_gup_type, customer_id, ul.getGeneralUserProfileId().getId(), ls.getId(), ul.getId(), voucher_type, gop, 0, invoiceLists);

        invoiceNo = "";
        date = "";
        datebject = null;
        invoiceTotal = "";
        outstandingAmount = "";

        //----------------------------------------------------------------------
        netTotal = "";
        netTotalDouble = 0;
        netOutstanding = "";
        netOutstandingDouble = 0;
        invoiceLists.clear();

        gop_gup_type = 0;
        customer = "";

        RequestContext contex = RequestContext.getCurrentInstance();
        contex.execute("swal('Congradulation!','Saved Successfully','success')");

    }

    public static class InvoiceList implements Serializable {

        private String invoiceNo;
        private String date;
        private String invoiceTotal;
        private String outstandingAmount;

        public InvoiceList(String invoiceNo, String date, String invoiceTotal, String outstandingAmount) {
            this.invoiceNo = invoiceNo;
            this.date = date;
            this.invoiceTotal = invoiceTotal;
            this.outstandingAmount = outstandingAmount;
        }

        public String getInvoiceNo() {
            return invoiceNo;
        }

        public void setInvoiceNo(String invoiceNo) {
            this.invoiceNo = invoiceNo;
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

        public String getOutstandingAmount() {
            return outstandingAmount;
        }

        public void setOutstandingAmount(String outstandingAmount) {
            this.outstandingAmount = outstandingAmount;
        }

    }
}
