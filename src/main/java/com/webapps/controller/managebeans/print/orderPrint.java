/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapps.controller.managebeans.print;

import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Sameera
 */
@Named(value = "orderPrint")
@Dependent
public class orderPrint {

    /**
     * Creates a new instance of orderPrint
     */
    public static ArrayList<OrderItem> orderItemList = new ArrayList<OrderItem>();
    
    public static String customerName;
    public static String customerAddress;
    public static String customerCity;
    public static String orderNo;
    public static int invoiceId;
    public static String orderTotal;
    public static String orderDue;
    public static String orderPaid;
    public static String orderDate;
    public static String dnNo;
    public static String poNo;
    public static String orderDescription;
    
    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }
    
    

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(String orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getOrderDue() {
        return orderDue;
    }

    public void setOrderDue(String orderDue) {
        this.orderDue = orderDue;
    }

    public String getOrderPaid() {
        return orderPaid;
    }

    public void setOrderPaid(String orderPaid) {
        this.orderPaid = orderPaid;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
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


    public static class OrderItem implements Serializable {

        private String id;
        private String productName;
        public String price;
        public String qty;
        private String line_total;

        public OrderItem(String id, String productName, String qty,
                String price, String lineTotal) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.qty = qty;
            this.line_total = lineTotal;
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


}
