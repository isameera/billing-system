/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapps.controller.managebeans.task;

/**
 *
 * @author Sameera
 */
import com.ejb.model.businesslogic.OrderRequest;
import com.ejb.model.common.ComDev;
import com.ejb.model.common.ComLib;
import com.ejb.model.entity.LoginSession;
import com.ejb.model.entity.UserLogin;
import com.webapps.filterlogin.beans.LoginBean;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

@ManagedBean(name = "order")
@SessionScoped
public class OrderBean implements Serializable {

    @EJB
    private OrderRequest orderRequest;

    @EJB
    private ComLib comLib;

    @EJB
    private ComDev comDev;

    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    int gop = (int) request.getSession().getAttribute("gopId");
    int main_gop = (int) request.getSession().getAttribute("gopMainId");
    LoginSession ls = (LoginSession) request.getSession().getAttribute("loginsession");
    UserLogin ul = (UserLogin) request.getSession().getAttribute("userloin");

    static Logger log = Logger.getLogger(OrderBean.class.getName());
//    private static final long serialVersionUID = 1L;
    private String productName;
    private String totalAmount;
    private String qty;

    public List<String> completeItem(String query) {

        List<String> list = comDev.getProductnameList(query, gop);

        return list;
    }

    public void onItemNameSelect(SelectEvent event) {

    }

    //--------------------------------------------------------------------------
    private String orderNo;
    private String customer;
    private int customer_id;
    private String date;
    private String color_des;
    private String advance;
    private String delivery_date;
    private Date delivery_date_object;
    private double voucher_total;
    private int gop_gup_type;
    private String po_no;
    private String dn_no;

    public String getPo_no() {
        return po_no;
    }

    public void setPo_no(String po_no) {
        this.po_no = po_no;
    }

    public String getDn_no() {
        return dn_no;
    }

    public void setDn_no(String dn_no) {
        this.dn_no = dn_no;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getGop_gup_type() {
        return gop_gup_type;
    }

    public void setGop_gup_type(int gop_gup_type) {
        this.gop_gup_type = gop_gup_type;
    }

    public double getVoucher_total() {
        return voucher_total;
    }

    public void setVoucher_total(double voucher_total) {
        this.voucher_total = voucher_total;
    }

    public Date getDelivery_date_object() {
        return delivery_date_object;
    }

    public void setDelivery_date_object(Date delivery_date_object) {
        this.delivery_date_object = delivery_date_object;
    }
    private String printing_des;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    //--------------------------------------------------------------------------
    public String getCutomer() {
        return customer;
    }

    public void setCutomer(String cutomer) {
        this.customer = cutomer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getColor_des() {
        return color_des;
    }

    public void setColor_des(String color_des) {
        this.color_des = color_des;
    }

    public String getAdvance() {
        return advance;
    }

    public void setAdvance(String advance) {
        this.advance = advance;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getPrinting_des() {
        return printing_des;
    }

    public void setPrinting_des(String printing_des) {
        this.printing_des = printing_des;
    }

    private static final ArrayList<Order> orderList = new ArrayList<Order>();

    public ArrayList<Order> getOrderList() {

        return orderList;

    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public void onRowEdit(RowEditEvent event) {

        setVoucher_total(0);

        for (Order o : orderList) {
            voucher_total += o.line_total;
        }

        Order ii = (Order) event.getObject();
        ii.setPrice((ii.line_total / ii.qty));

        FacesMessage msg = new FacesMessage("Car Edited", ((Order) event.getObject()).getProductName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Order) event.getObject()).getProductName());
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

    public void addAction() throws IOException {

        boolean b = false;
        for (Order o : orderList) {

            b = ((o.getProductName().equals(this.productName)));
            if (b) {
                break;
            }
        }

        if (b) {
            RequestContext contex = RequestContext.getCurrentInstance();
            contex.execute("swal('Duplicate Entry!','Item name is already exists...!','error')");
        } else {

            Order order = new Order(productName, Double.valueOf(qty), (Double.valueOf(totalAmount) / Double.valueOf(qty)), Double.valueOf(totalAmount));

            orderList.add(order);

            setVoucher_total(0);
            for (Order o : orderList) {
                voucher_total += o.line_total;
            }

            qty = "";
            productName = "";
            totalAmount = "";
        }
//        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
//        context.redirect("./order-request.xhtml");
//        return "/secured/order-request.xhtml";
    }

    public String deleteAction(Order order) throws IOException {

        orderList.remove(order);

        setVoucher_total(0);
        for (Order o : orderList) {
            voucher_total += o.line_total;
        }
//        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
//        context.redirect("./order-request.xhtml");

        return null;
    }

    private String date_1 = ComLib.getDate(new Date());

    public String getDate_1() {
        return date_1;
    }

    public void setDate_1(String date_1) {
        this.date_1 = ComLib.getDate(new Date());
    }

    public void fireSelection(ValueChangeEvent event) {
        gop_gup_type = Integer.valueOf(event.getNewValue().toString());

        customer_id = 0;
        customer = "";
    }

    public List<String> completeCustomersList(String query) {

        List<String> list = comDev.getGOPnameList(query, main_gop);
        return list;
    }

    public List<String> completeCustomersListIn(String query) {

        List<String> list = comLib.completeList(query, main_gop, gop_gup_type);

        return list;
    }

    public void onCustomerSelect(SelectEvent event) {

        try {
            String str = event.getObject().toString();

            String result = str.split("%")[1];

            customer_id = Integer.valueOf(result.trim());
            gop_gup_type = 1;

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", result));
        } catch (Exception ex) {
            log.error("This is an Error: " + ex);
        }
    }

    public void onCustomerSelectIn(SelectEvent event) {

        try {
            String str = event.getObject().toString();

            String result = str.split("%")[1];

            customer_id = Integer.valueOf(result.trim());

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", result));
        } catch (Exception ex) {
            log.error("This is an Error: " + ex);
        }
    }

    public void loadOrderNoCop() {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        UserLogin ul = (UserLogin) request.getSession().getAttribute("userloin");

        LoginBean.order_no = comLib.ComTIDGenerator(ul.getGeneralOrganizationProfileId().getId(), 92);
    }

    public void loadOrderNoIn() {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        UserLogin ul = (UserLogin) request.getSession().getAttribute("userloin");

        LoginBean.order_no = comLib.VIDGenerator(ul.getGeneralOrganizationProfileId().getId(), 93);
    }

    public void SaveCorporateOrder() {

        RequestContext contex = RequestContext.getCurrentInstance();

        int cid = 0;
        String[] elements = customer.split("%");
//        String[] trailing = Arrays.copyOfRange(elements,1,elements.length);

        if (elements.length > 1) {
            String result = customer.split("%")[1];
            cid = ((result.equals("")) ? 0 : Integer.valueOf(result.trim()));
        }

        if (cid != 0) {

            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            LoginSession ls = (LoginSession) request.getSession().getAttribute("loginsession");
            UserLogin ul = (UserLogin) request.getSession().getAttribute("userloin");
//        GeneralOrganizationProfile gop = (GeneralOrganizationProfile) request.getSession().getAttribute("gop");
//        GeneralUserProfile gup = (GeneralUserProfile) request.getSession().getAttribute("gup");

            double advance_amount = ((advance.equals("")) ? 0 : Double.valueOf(advance));

            gop_gup_type = ((gop_gup_type == 3) ? 1 : gop_gup_type);

            orderRequest.SaveOrderRequest("", "", delivery_date, voucher_total, advance_amount, (voucher_total - advance_amount), 0, printing_des, 1, gop_gup_type, cid, ul.getGeneralUserProfileId().getId(), ls.getId(), ul.getId(), 92, ul.getGeneralOrganizationProfileId().getId(), 0, orderList, dn_no, po_no);

            LoginBean.order_no = comLib.ComTIDGenerator(ul.getGeneralOrganizationProfileId().getId(), 92);
            qty = "";
            productName = "";
            totalAmount = "";

            gop_gup_type = 0;
            customer = "";
            advance = "";
            delivery_date_object = null;
            voucher_total = 0.0;
            printing_des = "";
            dn_no = "";
            po_no = "";
            orderList.clear();

            contex.execute("swal('Congradulation!','Saved Successfully','success')");
            contex.execute("PF('dlg3').show()");

        } else {
            contex.execute("swal('Oops..!','Customer is not selected properly...!','error')");
        }
    }

    public void SaveCorporateOrderIndividual() {

        RequestContext contex = RequestContext.getCurrentInstance();

        int cid = 0;
        String[] elements = customer.split("%");
//        String[] trailing = Arrays.copyOfRange(elements,1,elements.length);

        if (elements.length > 1) {
            String result = customer.split("%")[1];
            cid = ((result.equals("")) ? 0 : Integer.valueOf(result.trim()));
        }

        if (cid != 0) {

//        GeneralOrganizationProfile gop = (GeneralOrganizationProfile) request.getSession().getAttribute("gop");
//        GeneralUserProfile gup = (GeneralUserProfile) request.getSession().getAttribute("gup");
            double advance_amount = ((advance.equals("")) ? 0 : Double.valueOf(advance));

            gop_gup_type = ((gop_gup_type == 3) ? 1 : gop_gup_type);

            orderRequest.SaveOrderRequest("", "", delivery_date, voucher_total, advance_amount, (voucher_total - advance_amount), 0, printing_des, 1, gop_gup_type, cid, ul.getGeneralUserProfileId().getId(), ls.getId(), ul.getId(), 93, ul.getGeneralOrganizationProfileId().getId(), 0, orderList, dn_no, po_no);

            LoginBean.order_no = comLib.VIDGenerator(ul.getGeneralOrganizationProfileId().getId(), 93);
            qty = "";
            productName = "";
            totalAmount = "";

            productName = "";
            totalAmount = "";

            gop_gup_type = 0;
            customer = "";
            advance = "";
            delivery_date_object = null;
            voucher_total = 0.0;
            printing_des = "";
            po_no = "";
            orderList.clear();

            contex.execute("swal('Congradulation!','Saved Successfully','success')");
            contex.execute("PF('dlg3').show()");

        } else {
            contex.execute("swal('Oops..!','Customer is not selected properly...!','error')");
        }
    }

    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        setDelivery_date(format.format(event.getObject()));
        setDelivery_date_object((Date) event.getObject());
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));

    }

    public static class Order implements Serializable {

//        String orderNo;
        private String productName;
        private double price;
        private double qty;
        private double line_total;

        public Order(String productName, double qty, double price, double line_total) {
//            this.orderNo = orderNo;
            this.productName = productName;
            this.price = price;
            this.qty = qty;
            this.line_total = line_total;
        }

        public double getLine_total() {
            return line_total;
        }

//        public String getOrderNo() {
//            return orderNo;
//        }
//
//        public void setOrderNo(String orderNo) {
//            this.orderNo = orderNo;
//        }
        public void setLine_total(double line_total) {
            this.line_total = line_total;
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

    }

}
