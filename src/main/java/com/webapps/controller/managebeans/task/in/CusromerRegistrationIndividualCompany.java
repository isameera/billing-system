/*
 * To change this license header; choose License Headers in Project Properties.
 * To change this template file; choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapps.controller.managebeans.task.in;

import com.ejb.model.businesslogic.CustomerRegistration;
import com.ejb.model.common.ComDev;
import com.ejb.model.common.ComLib;
import com.ejb.model.common.UniDBLocal;
import com.ejb.model.entity.GeneralOrganizationProfile;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Sameera
 */
@Named(value = "cusromerRegistrationIndividualCompany")
@SessionScoped
public class CusromerRegistrationIndividualCompany implements Serializable {

    @EJB
    private UniDBLocal uniDB;

    @EJB
    private ComDev comDev;

    @EJB
    private ComLib comLib;

    @EJB
    private CustomerRegistration customerRegistration;

    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    int main_gop = (int) request.getSession().getAttribute("gopMainId");

    /**
     * Creates a new instance of CusromerRegistrationCorporate
     */
    private String code;
    private String name;
    private String no;
    private String street;
    private String city;
    private String postal_code;
    private String phone_i;
    private String phone_ii;
    private String email;
    private String fax;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getPhone_i() {
        return phone_i;
    }

    public void setPhone_i(String phone_i) {
        this.phone_i = phone_i;
    }

    public String getPhone_ii() {
        return phone_ii;
    }

    public void setPhone_ii(String phone_ii) {
        this.phone_ii = phone_ii;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void getCustumCode() {
        code = comLib.ORGCodeGenerator(main_gop, 3);
    }

    //--------------------------------------------------------------------------
    private String customer;
    private int customer_id;

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

    public List<String> completeList(String query) {

        List<String> list = comDev.getGOPnameListAll(query);

        return list;
    }

    public void onItemSelect(SelectEvent event) {

        String str = event.getObject().toString();

        String result = str.split("%")[1];

        customer_id = Integer.valueOf(result.trim());

        loadCustomerInfo();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", result));

    }

    public void loadCustomerInfo() {

        GeneralOrganizationProfile o = (GeneralOrganizationProfile) uniDB.find(customer_id, GeneralOrganizationProfile.class);

        name = o.getName();
        no = o.getAddress1();
        street = o.getAddress2();
        city = o.getAddress3();
        phone_i = o.getPhone();
        phone_ii = o.getPhoneOther();
        email = o.getEmail();
        postal_code = o.getPostalCode();
        fax = o.getFax();

    }

    //--------------------------------------------------------------------------
    public void SaveCusromerRegistrationIndividualCo() {
        boolean result = customerRegistration.SaveIndividualCompany(name, no, street, city, postal_code, phone_i, phone_ii, email, fax, main_gop);

        RequestContext contex = RequestContext.getCurrentInstance();
        if (result) {
            contex.execute("swal('Congradulation!','Saved Successfully','success')");
            name = "";
            no = "";
            street = "";
            city = "";
            postal_code = "";
            phone_i = "";
            phone_ii = "";
            email = "";
            fax = "";
        } else {
            contex.execute("swal('Oops...','Something went wrong!','error')");
        }
    }

}
