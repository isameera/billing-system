/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapps.controller.managebeans.print;

import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Sameera
 */
@Named(value = "invoicePrint")
@SessionScoped
public class InvoicePrint implements Serializable {

    /**
     * Creates a new instance of InvoicePrint
     */
    public static ArrayList<InvoiceItem> invoiceItemList = new ArrayList<InvoiceItem>();
    public static ArrayList<PaymentHistory> phs = new ArrayList<PaymentHistory>();

    public static String customerName;
    public static String customerAddress;
    public static String customerCity;
    public static String invoiceNo;
    public static String orderNo;
    public static int invoiceId;
    public static String invoiceTotal;
    public static String invoiceTotalDes;
    public static String invoiceDue;
    public static String invoicePaid;
    public static String invoiceDate;
    public static String dnNo;
    public static String poNo;
    public static String vatNo;
    public static String nbtNum;
    public static String nbtDes;
    public static String grossNum;
    public static String grossDes;
    public static String vatNum;
    public static String vatDes;

    //--------------------------------------------------------------------------
    public static String receiptNo;
    public static String receiptDate;
    public static String receiptPoNo;
    public static String receiptDnNo;
    public static String receiptAmount;
    public static int receiptId;
    public static String receiptPaymentMode;
    public static String receiptChequeController;
    public static String receiptChequeNumber;
    public static String receiptChequeDate;
    public static String receiptChequeBank;
    public static String receiptChequeBankBranch;
    //--------------------------------------------------------------------------
    
    public ArrayList<InvoiceItem> getInvoiceItemList() {
        return invoiceItemList;
    }

    public String getReceiptPaymentMode() {
        return receiptPaymentMode;
    }

    public void setReceiptPaymentMode(String receiptPaymentMode) {
        this.receiptPaymentMode = receiptPaymentMode;
    }

    public String getReceiptChequeController() {
        return receiptChequeController;
    }

    public void setReceiptChequeController(String receiptChequeController) {
        this.receiptChequeController = receiptChequeController;
    }

    public String getReceiptChequeNumber() {
        return receiptChequeNumber;
    }

    public void setReceiptChequeNumber(String receiptChequeNumber) {
        this.receiptChequeNumber = receiptChequeNumber;
    }

    public String getReceiptChequeDate() {
        return receiptChequeDate;
    }

    public void setReceiptChequeDate(String receiptChequeDate) {
        this.receiptChequeDate = receiptChequeDate;
    }

    public String getReceiptChequeBank() {
        return receiptChequeBank;
    }

    public void setReceiptChequeBank(String receiptChequeBank) {
        this.receiptChequeBank = receiptChequeBank;
    }

    public String getReceiptChequeBankBranch() {
        return receiptChequeBankBranch;
    }

    public void setReceiptChequeBankBranch(String receiptChequeBankBranch) {
        this.receiptChequeBankBranch = receiptChequeBankBranch;
    }

    
    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getReceiptPoNo() {
        return receiptPoNo;
    }

    public void setReceiptPoNo(String receiptPoNo) {
        this.receiptPoNo = receiptPoNo;
    }

    public String getReceiptDnNo() {
        return receiptDnNo;
    }

    public void setReceiptDnNo(String receiptDnNo) {
        this.receiptDnNo = receiptDnNo;
    }

    public String getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(String receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public String getNbtNum() {
        return nbtNum;
    }

    public void setNbtNum(String nbtNum) {
        this.nbtNum = nbtNum;
    }

    public ArrayList<PaymentHistory> getPhs() {
        return phs;
    }

    public String getVatNo() {
        return vatNo;
    }

    public void setVatNo(String vatNo) {
        this.vatNo = vatNo;
    }

    public String getNbtDes() {
        return nbtDes;
    }

    public void setNbtDes(String nbtDes) {
        this.nbtDes = nbtDes;
    }

    public String getGrossNum() {
        return grossNum;
    }

    public void setGrossNum(String grossNum) {
        this.grossNum = grossNum;
    }

    public String getGrossDes() {
        return grossDes;
    }

    public void setGrossDes(String grossDes) {
        this.grossDes = grossDes;
    }

    public String getVatNum() {
        return vatNum;
    }

    public void setVatNum(String vatNum) {
        this.vatNum = vatNum;
    }

    public String getVatDes() {
        return vatDes;
    }

    public void setVatDes(String vatDes) {
        this.vatDes = vatDes;
    }

    public void setPhs(ArrayList<PaymentHistory> phs) {
        this.phs = phs;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public String getInvoiceTotalDes() {
        return invoiceTotalDes;
    }

    public void setInvoiceTotalDes(String invoiceTotalDes) {
        this.invoiceTotalDes = invoiceTotalDes;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getInvoicePaid() {
        return invoicePaid;
    }

    public void setInvoicePaid(String invoicePaid) {
        this.invoicePaid = invoicePaid;
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

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(String invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        InvoicePrint.orderNo = orderNo;
    }

    public String getInvoiceDue() {
        return invoiceDue;
    }

    public void setInvoiceDue(String invoiceDue) {
        this.invoiceDue = invoiceDue;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        InvoicePrint.invoiceDate = invoiceDate;
    }

    public static class InvoiceItem implements Serializable {

        private String id;
        private String productName;
        public String price;
        public String qty;
        private String line_total;
        private String line_total_decimal;

        public InvoiceItem(String id, String productName, String qty,
                String price, String lineTotal, String lineTotalDecimal) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.qty = qty;
            this.line_total = lineTotal;
            this.line_total_decimal = lineTotalDecimal;
        }

        public String getLine_total_decimal() {
            return line_total_decimal;
        }

        public void setLine_total_decimal(String line_total_decimal) {
            this.line_total_decimal = line_total_decimal;
        }

        public String getTine_total() {
            return line_total;
        }

        public void setTine_total(String tine_total) {
            this.line_total = tine_total;
        }

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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLine_total() {
            return line_total;
        }

        public void setLine_total(String line_total) {
            this.line_total = line_total;
        }

    }

    public static class PaymentHistory implements Serializable {

        private String id;
        private String date;
        private String amount;

        public PaymentHistory(String id, String date, String amount) {
            this.id = id;
            this.date = date;
            this.amount = amount;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

    }

}
