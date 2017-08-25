/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapps.controller.managebeans.task;

import com.ejb.model.businesslogic.Invoice;
import com.ejb.model.common.ComDev;
import com.ejb.model.common.ComLib;
import com.ejb.model.entity.LoginSession;
import com.ejb.model.entity.UserLogin;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
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
@Named(value = "invoiceCop")
@SessionScoped
public class InvoiceCop implements Serializable {

    @EJB
    private ComLib comLib;

    @EJB
    private Invoice invoice;

    @EJB
    private ComDev comDev;

    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    int gop = (int) request.getSession().getAttribute("gopId");
    LoginSession ls = (LoginSession) request.getSession().getAttribute("loginsession");
    UserLogin ul = (UserLogin) request.getSession().getAttribute("userloin");

    public List<String> completeItem(String query) {

        List<String> list = comDev.getProductnameList(query, gop);

        return list;
    }

    public void onItemSelect(SelectEvent event) {

    }

    //--------------------------------------------------------------------------
    private String productName;
    private String price;
    private String qty;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    //--------------------------------------------------------------------------
    public static ArrayList<InvoiceItem> invoiceItemList = new ArrayList<InvoiceItem>();
    public static String orderNo;
    public static String invoiceNo;
    public static int voucherId;
    public static String invoiceTotal;
    public static double invoiceTotalDouble;
    public static double invoiceDue;
    public static double advance;
    private String payment;
    private String dnNo;
    private String poNo;
    private boolean vat;
    private boolean nbt;
    private double vat_amount;
    private double nbt_amount;
    private String vatNo;

    public String getVatNo() {
        return vatNo;
    }

    public void setVatNo(String vatNo) {
        this.vatNo = vatNo;
    }

    public double getVat_amount() {
        return vat_amount;
    }

    public void setVat_amount(double vat_amount) {
        this.vat_amount = vat_amount;
    }

    public double getNbt_amount() {
        return nbt_amount;
    }

    public void setNbt_amount(double nbt_amount) {
        this.nbt_amount = nbt_amount;
    }

    public boolean isVat() {
        return vat;
    }

    public void setVat(boolean vat) {
        this.vat = vat;
    }

    public boolean isNbt() {
        return nbt;
    }

    public void setNbt(boolean nbt) {
        this.nbt = nbt;
    }

    public String getDnNo() {
        return dnNo;
    }

    public void setDnNo(String dnNo) {
        this.dnNo = dnNo;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public double getInvoiceTotalDouble() {
        return invoiceTotalDouble;
    }

    public void setInvoiceTotalDouble(double invoiceTotalDouble) {
        this.invoiceTotalDouble = invoiceTotalDouble;
    }

    public double getInvoiceDue() {
        return invoiceDue;
    }

    public void setInvoiceDue(double invoiceDue) {
        this.invoiceDue = invoiceDue;
    }

    public double getAdvance() {
        return advance;
    }

    public void setAdvance(double advance) {
        this.advance = advance;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public ArrayList<InvoiceItem> getInvoiceItemList() {
        return invoiceItemList;
    }

    public String getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(String invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        InvoiceCop.orderNo = orderNo;
    }

    public void addRow() throws IOException {

        boolean b = false;
        for (InvoiceItem o : invoiceItemList) {

            b = ((o.getProductName().equals(this.productName)));
            if (b) {
                break;
            }
        }

        if (b) {
            RequestContext contex = RequestContext.getCurrentInstance();
            contex.execute("swal('Duplicate Entry!','Item name is already exists in the table...!','error')");
        } else {

            InvoiceCop.InvoiceItem invoiceItem = new InvoiceCop.InvoiceItem("", productName, Double.valueOf(qty), (Double.valueOf(price) / Double.valueOf(qty)), Double.valueOf(price));

            invoiceItemList.add(invoiceItem);

//            setInvoiceTotal("");
//            invoiceTotalDouble = 0;
//            for (InvoiceItem o : invoiceItemList) {
//                invoiceTotalDouble += o.line_total;
//            }
//            invoiceTotal = ComLib.getDouble(invoiceTotalDouble);
//            invoiceDue = (invoiceTotalDouble - advance);
            comVatFilter();

            qty = "";
            productName = "";
            price = "";
        }
//        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
//        context.redirect("./order-request.xhtml");
//        return "/secured/order-request.xhtml";
    }

    public void onRowEdit(RowEditEvent event) {

//        setInvoiceTotal("");
//        invoiceTotalDouble = 0;
//        for (InvoiceItem o : invoiceItemList) {
//            invoiceTotalDouble += o.line_total;
//        }
//        invoiceTotal = ComLib.getDouble(invoiceTotalDouble);
//        invoiceDue = (invoiceTotalDouble - advance);
        comVatFilter();

        InvoiceItem ii = (InvoiceItem) event.getObject();
        ii.setPrice(ii.line_total / ii.qty);

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

//        setInvoiceTotal("");
//        invoiceTotalDouble = 0;
//        for (InvoiceItem o : invoiceItemList) {
//            invoiceTotalDouble += o.line_total;
//        }
//        invoiceTotal = ComLib.getDouble(invoiceTotalDouble);
//        invoiceDue = (invoiceTotalDouble - advance);
        comVatFilter();

    }

    public void vatFilter(ValueChangeEvent dege) {
//        System.out.println(dege.toString());

        nbt_amount = 0;
        vat_amount = 0;

        nbt = false;
        vat = false;

        setInvoiceTotal("");
        invoiceTotalDouble = 0;
        System.out.println("invoiceTotalDouble: " + invoiceTotalDouble);
        for (InvoiceItem o : invoiceItemList) {
            invoiceTotalDouble += o.line_total;
        }
        System.out.println("invoiceTotalDouble: " + invoiceTotalDouble);
        invoiceTotal = ComLib.getDouble(invoiceTotalDouble);
        invoiceDue = (invoiceTotalDouble - advance);

        Object[] objArr = (Object[]) dege.getNewValue();
        for (Object obj : objArr) {

            System.out.println(obj.toString());

//            nbt = ((obj.toString().equals("2")));
//            vat = ((obj.toString().equals("1")));
            if (obj.toString().equals("2")) {
                nbt = true;
            }

            if (obj.toString().equals("1")) {
                vat = true;
            }

        }

        if (nbt) {
            nbt_amount = invoiceTotalDouble / 100 * 2;
        } else {
            nbt = false;
        }

        invoiceTotalDouble = (invoiceTotalDouble + nbt_amount);

        if (vat) {
            vat_amount = invoiceTotalDouble / 100 * 15;
        } else {
            vat = false;
        }

        invoiceTotalDouble = (invoiceTotalDouble + vat_amount);

        invoiceTotal = ComLib.getDouble(invoiceTotalDouble);
        invoiceDue = (invoiceTotalDouble - advance);

    }

    public void comVatFilter() {
//        System.out.println(dege.toString());

        nbt_amount = 0;
        vat_amount = 0;

        nbt = false;
        vat = false;

        setInvoiceTotal("");
        invoiceTotalDouble = 0;
        for (InvoiceItem o : invoiceItemList) {
            invoiceTotalDouble += o.line_total;
        }

//        if (nbt) {
//            nbt_amount = (invoiceTotalDouble / 100) * 2;
//            System.out.println("nbt_amount: " + nbt_amount);
//        }
//
//        invoiceTotalDouble = (invoiceTotalDouble + nbt_amount);
//        if (vat) {
//            vat_amount = (invoiceTotalDouble / 100) * 15;
//        }
//
//        invoiceTotalDouble = (invoiceTotalDouble + vat_amount);
        invoiceTotal = ComLib.getDouble(invoiceTotalDouble);
        invoiceDue = (invoiceTotalDouble - advance);

    }

    public void SaveCorporateInvoice() {


        double paymentD = Double.parseDouble(payment);
        invoice.SaveInvoiceCorporate("", voucherId, invoiceTotalDouble, (advance + paymentD), (invoiceDue - paymentD), 0, "", 1, ul.getGeneralUserProfileId().getId(), ls.getId(), ul.getId(), 1, ul.getGeneralOrganizationProfileId().getId(), 0, invoiceItemList, dnNo, poNo, vat, nbt, vat_amount, nbt_amount, vatNo);
        invoiceNo = comLib.ComTIDGenerator(ul.getGeneralOrganizationProfileId().getId(), 1);

        qty = "";
        productName = "";
        price = "";
        //----------------------------------------------------------------------
        advance = 0;
        invoiceDue = 0;
        payment = "";
        invoiceNo = "";
        invoiceTotal = "";
        invoiceTotalDouble = 0;
        poNo = "";
        dnNo = "";
        vat = false;
        nbt = false;
        vatNo = "";
        vat_amount = 0;
        nbt_amount = 0;
        invoiceItemList.clear();

        RequestContext contex = RequestContext.getCurrentInstance();
        contex.execute("swal('Congradulation!','Saved Successfully','success')");
        contex.execute("PF('dlg3').show()");

    }

    public void SaveIndividualInvoice() {

        double paymentD = Double.parseDouble(payment);
        invoice.SaveInvoiceCorporate("", voucherId, invoiceTotalDouble, (advance + paymentD), (invoiceDue - paymentD), 0, "", 1, ul.getGeneralUserProfileId().getId(), ls.getId(), ul.getId(), 94, ul.getGeneralOrganizationProfileId().getId(), 0, invoiceItemList, dnNo, poNo, vat, nbt, vat_amount, nbt_amount, vatNo);
        invoiceNo = comLib.VIDGenerator(ul.getGeneralOrganizationProfileId().getId(), 94);

        qty = "";
        productName = "";
        price = "";
        //----------------------------------------------------------------------
        advance = 0;
        invoiceDue = 0;
        payment = "";
        invoiceNo = "";
        invoiceTotal = "";
        invoiceTotalDouble = 0;
        poNo = "";
        dnNo = "";
        vat = false;
        nbt = false;
        vatNo = "";
        vat_amount = 0;
        nbt_amount = 0;
        invoiceItemList.clear();

        RequestContext contex = RequestContext.getCurrentInstance();
        contex.execute("swal('Congradulation!','Saved Successfully','success')");
        contex.execute("PF('dlg3').show()");

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
