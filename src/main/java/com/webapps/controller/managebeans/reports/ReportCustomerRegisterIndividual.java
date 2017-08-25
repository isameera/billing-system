/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapps.controller.managebeans.reports;

import com.ejb.model.common.ComDev;
import com.ejb.model.common.UniDBLocal;
import com.ejb.model.entity.GeneralUserProfile;
import com.ejb.model.entity.GupGopManager;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Sameera
 */
@Named(value = "reportCustomerRegisterIndividual")
@SessionScoped
public class ReportCustomerRegisterIndividual implements Serializable {

    @EJB
    private ComDev comDev;

    @EJB
    private UniDBLocal uniDB;

    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    int main_gop = (int) request.getSession().getAttribute("gopMainId");
    /**
     * Creates a new instance of ReportCustomerRegister
     */
    public ReportCustomerRegisterIndividual() {
    }

    private String customer;
    private int customer_id;
    private Date date_from;
    private Date date_to;
    private int gup_id;

    public int getGup_id() {
        return gup_id;
    }

    public void setGup_id(int gup_id) {
        this.gup_id = gup_id;
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

    public List<String> completeList(String query) {

        List<String> list = comDev.getGUPnameList(query, main_gop);

        return list;
    }

    public void onItemSelect(SelectEvent event) {

        String str = event.getObject().toString();

        String result = str.split("%")[1];

        customer_id = Integer.valueOf(result.trim());

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", result));
    }

    //--------------------------------------------------------------------------
    private List<CustomersList> customersLists = new ArrayList<>();

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
    private String fullname;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

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

    public List<CustomersList> getCustomersLists() {
        return customersLists;
    }

    public void setCustomersLists(List<CustomersList> customersLists) {
        this.customersLists = customersLists;
    }

    public void loadCustomersList() {

        customersLists.clear();
        List<GupGopManager> list = uniDB.searchByQueryLimit("SELECT o FROM GupGopManager o WHERE o.generalOrganizationProfileId.id='" + main_gop + "' ", 500);
        for (GupGopManager o : list) {
            customersLists.add(new CustomersList(o.getGeneralUserProfileId().getId(), o.getGeneralUserProfileId().getNic(), o.getCode(), o.getGeneralUserProfileId().getTitle() + " " + o.getGeneralUserProfileId().getFullName(), o.getGeneralUserProfileId().getMobilePhone(), o.getGeneralUserProfileId().getEmail()));
        }

    }

    public void searchCustomer() {

        customersLists.clear();
        List<GupGopManager> list = uniDB.searchByQueryLimit("SELECT o FROM GupGopManager o WHERE o.generalUserProfileId.id='" + customer_id + "' ", 500);
        for (GupGopManager o : list) {
            customersLists.add(new CustomersList(o.getGeneralUserProfileId().getId(), o.getGeneralUserProfileId().getNic(), o.getCode(), o.getGeneralUserProfileId().getTitle() + " " + o.getGeneralUserProfileId().getFullName(), o.getGeneralUserProfileId().getMobilePhone(), o.getGeneralUserProfileId().getEmail()));
        }

    }

    public void loadCustomerInfo(CustomersList cl) {

        GeneralUserProfile o = (GeneralUserProfile) uniDB.find(cl.id, GeneralUserProfile.class);

        code = cl.code;
        title = ((o.getTitle().equals("")) ? "-" : o.getTitle());
        first_name = ((o.getFirstName().equals("")) ? "-" : o.getFirstName());
        mid_name = ((o.getMidName().equals("")) ? "-" : o.getMidName());
        last_name = ((o.getLastName().equals("")) ? "-" : o.getLastName());
        no = ((o.getAddress1().equals("")) ? "-" : o.getAddress1());
        street = ((o.getAddress2().equals("")) ? "-" : o.getAddress2());
        city = ((o.getAddress3().equals("")) ? "-" : o.getAddress3());
        gender = ((o.getGender().equals("")) ? "-" : o.getGender());
        phone_i = ((o.getMobilePhone().equals("")) ? "-" : o.getMobilePhone());
        phone_ii = ((o.getHomePhone().equals("")) ? "-" : o.getHomePhone());
        email = ((o.getEmail().equals("")) ? "-" : o.getEmail());
        nic = ((o.getNic().equals("")) ? "-" : o.getNic());
        fullname = ((o.getFullName().equals("")) ? "-" : o.getFullName());
        gup_id = o.getId();

    }

    //--------------------------------------------------------------------------
    public void editNic() {

        GeneralUserProfile o = (GeneralUserProfile) uniDB.find(gup_id, GeneralUserProfile.class);
        o.setNic(nic);
        uniDB.update(o);
    }

    public void editTitle(ValueChangeEvent event) {

        GeneralUserProfile o = (GeneralUserProfile) uniDB.find(gup_id, GeneralUserProfile.class);
        o.setTitle(event.getNewValue().toString());
        uniDB.update(o);
    }

    public void editFirstName() {

        GeneralUserProfile o = (GeneralUserProfile) uniDB.find(gup_id, GeneralUserProfile.class);
        o.setFirstName(first_name);
        uniDB.update(o);
    }

    public void editLastName() {

        GeneralUserProfile o = (GeneralUserProfile) uniDB.find(gup_id, GeneralUserProfile.class);
        o.setLastName(last_name);
        uniDB.update(o);
    }

    public void editMidName() {

        GeneralUserProfile o = (GeneralUserProfile) uniDB.find(gup_id, GeneralUserProfile.class);
        o.setMidName(mid_name);
        uniDB.update(o);
    }

    public void editNo() {

        GeneralUserProfile o = (GeneralUserProfile) uniDB.find(gup_id, GeneralUserProfile.class);
        o.setAddress1(no);
        uniDB.update(o);
    }

    public void editStreet() {

        GeneralUserProfile o = (GeneralUserProfile) uniDB.find(gup_id, GeneralUserProfile.class);
        o.setAddress2(street);
        uniDB.update(o);
    }

    public void editCity() {

        GeneralUserProfile o = (GeneralUserProfile) uniDB.find(gup_id, GeneralUserProfile.class);
        o.setAddress3(city);
        uniDB.update(o);
    }

    public void editGender(ValueChangeEvent event) {

        GeneralUserProfile o = (GeneralUserProfile) uniDB.find(gup_id, GeneralUserProfile.class);
        o.setGender(event.getNewValue().toString());
        uniDB.update(o);
    }

    public void editMobilePhone() {

        GeneralUserProfile o = (GeneralUserProfile) uniDB.find(gup_id, GeneralUserProfile.class);
        o.setMobilePhone(phone_i);
        uniDB.update(o);
    }

    public void editHomePhone() {

        GeneralUserProfile o = (GeneralUserProfile) uniDB.find(gup_id, GeneralUserProfile.class);
        o.setHomePhone(phone_ii);
        uniDB.update(o);
    }

    public void editEmail() {

        GeneralUserProfile o = (GeneralUserProfile) uniDB.find(gup_id, GeneralUserProfile.class);
        o.setEmail(email);
        uniDB.update(o);
    }

    public void editFullName() {

        GeneralUserProfile o = (GeneralUserProfile) uniDB.find(gup_id, GeneralUserProfile.class);
        o.setFullName(fullname);
        uniDB.update(o);
    }

    //--------------------------------------------------------------------------
    public static class CustomersList implements Serializable {

        private int id;
        private String code;
        private String nic;
        private String name;
        private String phone;
        private String email;

        public CustomersList(int id, String nic, String code, String name, String phone, String email) {
            this.id = id;
            this.nic = nic;
            this.code = code;
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

        public String getNic() {
            return nic;
        }

        public void setNic(String nic) {
            this.nic = nic;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 59 * hash + (this.code != null ? this.code.hashCode() : 0);
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
            final CustomersList other = (CustomersList) obj;
            if ((this.code == null) ? (other.code != null) : !this.code.equals(other.code)) {
                return false;
            }
            return true;
        }

    }

}
