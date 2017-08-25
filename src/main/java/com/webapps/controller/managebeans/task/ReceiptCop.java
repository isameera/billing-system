/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapps.controller.managebeans.task;

import com.ejb.model.businesslogic.Receipt;
import com.ejb.model.common.ComDev;
import com.ejb.model.common.ComLib;
import com.ejb.model.common.UniDBLocal;
import com.ejb.model.entity.Bank;
import com.ejb.model.entity.LoginSession;
import com.ejb.model.entity.PaymentHistory;
import com.ejb.model.entity.UserLogin;
import com.webapps.controller.managebeans.print.InvoicePrint;
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
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Sameera
 */
@Named(value = "receiptCop")
@SessionScoped
public class ReceiptCop implements Serializable {

    @EJB
    private ComLib comLib;

    @EJB
    private Receipt receipt;

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
    private int coc;
    private String chequeNo;
    private String chequeDate;
    private Date chequeDateObj;
    private int chequeController;
    private int bank;
    private String bank_branch;

//    private List<banks> bankList;
//
//    public List<banks> getBankList() {
//        return bankList;
//    }
//
//    public void setBankList(List<banks> bankList) {
//        this.bankList = bankList;
//    }
    private List<String> bankList;

    public List<String> getBankList() {
        return bankList;
    }

    public void setBankList(List<String> bankList) {
        this.bankList = bankList;
    }

//    @PostConstruct
//    public void init() {
//        getBankListService();
//    }
    public void getBankListService() {

        List<Bank> bs = uniDB.searchByQuery("SELECT b FROM Bank b WHERE b.id in(3,4,5,6,7,8,9,10,11,12,13,30,32,33,35,37,49,53,55,57,58,63) ORDER BY b.name");
        for (Bank b : bs) {
            System.out.println("bank name: " + b.getName());
//            banks bl = new banks(b.getName(), b.getId());
            bankList.add(b.getName());
        }

    }

    public int getGop_gup_type() {
        return gop_gup_type;
    }

    public void setGop_gup_type(int gop_gup_type) {
        this.gop_gup_type = gop_gup_type;
    }

    public int getChequeController() {
        return chequeController;
    }

    public void setChequeController(int chequeController) {
        this.chequeController = chequeController;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    public String getBank_branch() {
        return bank_branch;
    }

    public void setBank_branch(String bank_branch) {
        this.bank_branch = bank_branch;
    }

    public String getChequeDate() {
        return chequeDate;
    }

    public void setChequeDate(String chequeDate) {
        this.chequeDate = chequeDate;
    }

    public Date getChequeDateObj() {
        return chequeDateObj;
    }

    public void setChequeDateObj(Date chequeDateObj) {
        this.chequeDateObj = chequeDateObj;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public int getCoc() {
        return coc;
    }

    public void setCoc(int coc) {
        this.coc = coc;
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

    public List<String> completeCustomersList(String query) {
        List<String> list = comDev.getGOPnameList(query, (int) request.getSession().getAttribute("gopMainId"));
        return list;
    }

    public void onInvoiceItemSelect(SelectEvent event) {
        String str = event.getObject().toString();
        String result = str.split("%")[1];
        customer_id = Integer.valueOf(result.trim());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", result));
    }

    public void invoiveFireSelection(ValueChangeEvent event) {

        this.coc = Integer.valueOf(event.getNewValue().toString());

        chequeController = 0;
        chequeDate = "";
        chequeDateObj = null;
        chequeNo = "";
        bank = 0;
        bank_branch = "";

    }

    public void fireSelection(ValueChangeEvent event) {
        gop_gup_type = Integer.valueOf(event.getNewValue().toString());
        customer_id = 0;
        customer = "";
    }

    public List<String> completeListIndividual(String query) {
        System.out.println(query + " " + main_gop + " " + gop_gup_type);
        List<String> list = comLib.completeList(query, main_gop, gop_gup_type);

        return list;
    }

    public void selectBank(ValueChangeEvent event) {

        this.bank = Integer.valueOf(event.getNewValue().toString());

    }

    public void selectChequeController(ValueChangeEvent event) {

        this.chequeController = Integer.valueOf(event.getNewValue().toString());

    }

    public List<String> completeBranchList(String query) {

        List<String> list = comDev.getBankBranchList(query, bank);

        return list;
    }

    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        setChequeDate(format.format(event.getObject()));
        setChequeDateObj((Date) event.getObject());
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));

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

        List<PaymentHistory> ph = uniDB.searchByQueryLimit("SELECT v FROM PaymentHistory v WHERE v.voucherId.generalOrganizationProfileId.id='" + gop + "' " + query1 + " " + query2 + " AND v.voucherTypeId.id=1 AND v.voucherId.due > 0 ORDER BY v.voucherId.id ASC", 500);
        for (PaymentHistory p : ph) {
            invoiceLists.add(new InvoiceList(p.getVoucherId().getId(), p.getVoucherId().getVoucherId(), ComLib.getDateFormated(p.getVoucherId().getDate()), comDev.getGOPGUPName(p.getReferenceId(), p.getUniversalPersonOrOrgTypeManagerId().getId()), ComLib.getDouble(p.getVoucherId().getVoucherTotal()), ComLib.getDouble(p.getVoucherId().getDue())));
        }
    }

    public void SearchIndividual() {

        invoiceLists.clear();

        String query1 = ((customer_id == 0) ? "" : " AND v.universalPersonOrOrgTypeManagerId.id='1' AND v.referenceId='" + customer_id + "'");
        String query2 = ((date_from == null && date_to == null) ? "" : " AND v.voucherId.date BETWEEN '" + ComLib.getDate(date_from) + "' AND '" + ComLib.getDate(date_to) + "'");

        List<PaymentHistory> ph = uniDB.searchByQueryLimit("SELECT v FROM PaymentHistory v WHERE v.voucherId.generalOrganizationProfileId.id='" + gop + "' " + query1 + " " + query2 + " AND v.voucherTypeId.id=94 AND v.voucherId.due > 0 ORDER BY v.voucherId.id ASC", 500);
        for (PaymentHistory p : ph) {
            invoiceLists.add(new InvoiceList(p.getVoucherId().getId(), p.getVoucherId().getVoucherId(), ComLib.getDateFormated(p.getVoucherId().getDate()), comDev.getGOPGUPName(p.getReferenceId(), p.getUniversalPersonOrOrgTypeManagerId().getId()), ComLib.getDouble(p.getVoucherId().getVoucherTotal()), ComLib.getDouble(p.getVoucherId().getDue())));
        }
    }

    public void loadReceiptPrint(InvoiceList invoice) throws IOException {

        InvoicePrint.invoiceNo = invoice.getId();
        InvoicePrint.invoiceId = invoice.getInvoiceId();
        comDev.getinvoicePrint(invoice.getInvoiceId());

    }

    public void loadReceiptPrintIndividual(InvoiceList invoice) throws IOException {

        InvoicePrint.invoiceNo = invoice.getId();
        InvoicePrint.invoiceId = invoice.getInvoiceId();
        comDev.getinvoicePrint(invoice.getInvoiceId());
        receiptNo = comLib.VIDGenerator((int) request.getSession().getAttribute("gopId"), 95);

    }

    public void emptyTable() {

        invoiceLists.clear();

    }

    //--------------------------------------------------------------------------
    public static String dnNo;
    public static String poNo;
    private String payment;
    public static String receiptNo;
    public static int voucherId;

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
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

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public void SaveCorporateReceipt() {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        LoginSession ls = (LoginSession) request.getSession().getAttribute("loginsession");
        UserLogin ul = (UserLogin) request.getSession().getAttribute("userloin");

        double paymentD = Double.parseDouble(payment);
        receipt.SaveReceiptCorporate("", voucherId, paymentD, "", 1, ul.getGeneralUserProfileId().getId(), ls.getId(), ul.getId(), 2, ul.getGeneralOrganizationProfileId().getId(), 0, dnNo, poNo, chequeNo, chequeDate, bank, bank_branch, chequeController, coc);

        payment = "";
        poNo = "";
        dnNo = "";

        coc = 0;
        chequeController = 0;
        chequeDate = "";
        chequeDateObj = null;
        chequeNo = "";
        bank = 0;
        bank_branch = "";

        RequestContext contex = RequestContext.getCurrentInstance();
        contex.execute("PF('dlg1').hide()");
        contex.execute("swal('Congradulation!','Saved Successfully','success')");
        contex.execute("PF('dlg3').show()");

    }

    public void SaveIndividualReceipt() {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        LoginSession ls = (LoginSession) request.getSession().getAttribute("loginsession");
        UserLogin ul = (UserLogin) request.getSession().getAttribute("userloin");

        double paymentD = Double.parseDouble(payment);
        receipt.SaveReceiptCorporate("", voucherId, paymentD, "", 1, ul.getGeneralUserProfileId().getId(), ls.getId(), ul.getId(), 95, ul.getGeneralOrganizationProfileId().getId(), 0, dnNo, poNo, chequeNo, chequeDate, bank, bank_branch, chequeController, coc);

        payment = "";
        poNo = "";
        dnNo = "";

        coc = 0;
        chequeController = 0;
        chequeDate = "";
        chequeDateObj = null;
        chequeNo = "";
        bank = 0;
        bank_branch = "";

        RequestContext contex = RequestContext.getCurrentInstance();
        contex.execute("PF('dlg1').hide()");
        contex.execute("swal('Congradulation!','Saved Successfully','success')");
        contex.execute("PF('dlg3').show()");

    }

    //--------------------------------------------------------------------------
    public static class InvoiceList implements Serializable {

        public int invoiceId;
        public String id;
        private String date;
        private String customer;
        private String invoiceTotal;
        private String due;

        public InvoiceList(int invoiceId, String id, String date, String customer, String invoiceTotal, String due) {
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
            final InvoiceList other = (InvoiceList) obj;
            if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
                return false;
            }
            return true;
        }

    }

    public static class banks implements Serializable {

        private String name;
        private int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public banks(String name, int id) {
            this.name = name;
            this.id = id;
        }

    }

}
