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
import com.ejb.model.entity.GeneralUserProfile;
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
@Named(value = "cusromerRegistrationIndividual")
@SessionScoped
public class CusromerRegistrationIndividual implements Serializable {

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
    private String title;
    private String first_name;
    private String mid_name;
    private String last_name;
    private String no;
    private String street;
    private String city;
    private String gender;
    private String phone_i;
    private String phone_ii;
    private String email;
    private String nic;

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMid_name() {
        return mid_name;
    }

    public void setMid_name(String mid_name) {
        this.mid_name = mid_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    //--------------------------------------------------------------------------
    private int customer_id;

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void getCustumCode() {
        code = comLib.ORGCodeGenerator(main_gop, 2);
    }

    public List<String> completeList(String query) {

        List<String> list = comDev.getGUPnameListAll(query);

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

        GeneralUserProfile o = (GeneralUserProfile) uniDB.find(customer_id, GeneralUserProfile.class);

        title = o.getTitle();
        first_name = o.getFirstName();
        mid_name = o.getMidName();
        last_name = o.getLastName();
        no = o.getAddress1();
        street = o.getAddress2();
        city = o.getAddress3();
        gender = o.getGender();
        phone_i = o.getMobilePhone();
        phone_ii = o.getHomePhone();
        email = o.getEmail();
        nic = o.getNic();

    }

    public void SaveCusromerRegistrationIndividual() {
        boolean result = customerRegistration.SaveGUP(nic, title, first_name, mid_name, last_name, no, street, city, gender, phone_i, phone_ii, email, main_gop);

        RequestContext contex = RequestContext.getCurrentInstance();
        if (result) {
            contex.execute("swal('Congradulation!','Saved Successfully','success')");
            nic = "";
            title = "";
            first_name = "";
            mid_name = "";
            last_name = "";
            no = "";
            street = "";
            city = "";
            gender = "";
            phone_i = "";
            phone_ii = "";
            email = "";
        } else {
            contex.execute("swal('Oops...','Something went wrong!','error')");
        }
    }

}
