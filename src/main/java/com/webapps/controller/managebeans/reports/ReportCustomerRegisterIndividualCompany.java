/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapps.controller.managebeans.reports;

import com.ejb.model.common.ComDev;
import com.ejb.model.common.UniDBLocal;
import com.ejb.model.entity.GeneralOrganizationProfile;
import com.ejb.model.entity.OrganizationTypeManager;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Sameera
 */
@Named(value = "reportCustomerRegisterIndividualCompany")
@SessionScoped
public class ReportCustomerRegisterIndividualCompany implements Serializable {

    @EJB
    private ComDev comDev;

    @EJB
    private UniDBLocal uniDB;

    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    int main_gop = (int) request.getSession().getAttribute("gopMainId");

    /**
     * Creates a new instance of ReportCustomerRegister
     */
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

        List<String> list = comDev.getIndividualCorporateList(query, main_gop);

        return list;
    }

    public void onItemSelect(SelectEvent event) {

        String str = event.getObject().toString();

        String result = str.split("%")[1];

        customer_id = Integer.valueOf(result.trim());

        loadCustomersListBySearch();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", result));

    }

    //--------------------------------------------------------------------------
    private List<CustomersList> customersLists = new ArrayList<>();

    private int gop_id;
    private String code;
    private String name;
    private String phone;
    private String email;
    private String no;
    private String street;
    private String city;
    private String postalCode;
    private String phoneOther;
    private String fax;

    public int getGop_id() {
        return gop_id;
    }

    public void setGop_id(int gop_id) {
        this.gop_id = gop_id;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneOther() {
        return phoneOther;
    }

    public void setPhoneOther(String phoneOther) {
        this.phoneOther = phoneOther;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
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

    public List<CustomersList> getCustomersLists() {
        return customersLists;
    }

    public void setCustomersLists(List<CustomersList> customersLists) {
        this.customersLists = customersLists;
    }

    public void loadCustomersList() {

        customersLists.clear();
        List<OrganizationTypeManager> list = uniDB.searchByQueryLimit("SELECT o FROM OrganizationTypeManager o WHERE o.generalOrganizationProfileId.id='" + main_gop + "' AND o.organizationTypeId.id='28' ", 500);
        for (OrganizationTypeManager o : list) {
            customersLists.add(new CustomersList(o.getGeneralOrganizationProfileId1().getId(), o.getCode(), o.getGeneralOrganizationProfileId1().getName(), o.getGeneralOrganizationProfileId1().getPhone(), o.getGeneralOrganizationProfileId1().getEmail()));
        }

    }

    public void loadCustomersListBySearch() {

        customersLists.clear();
        List<OrganizationTypeManager> list = uniDB.searchByQueryLimit("SELECT o FROM OrganizationTypeManager o WHERE o.generalOrganizationProfileId.id='" + main_gop + "' AND o.generalOrganizationProfileId1.id='" + customer_id + "' AND o.organizationTypeId.id='28' ", 500);
        for (OrganizationTypeManager o : list) {
            customersLists.add(new CustomersList(o.getGeneralOrganizationProfileId1().getId(), o.getCode(), o.getGeneralOrganizationProfileId1().getName(), o.getGeneralOrganizationProfileId1().getPhone(), o.getGeneralOrganizationProfileId1().getEmail()));
        }

    }

    public void loadCustomerInfo(CustomersList cl) {

        GeneralOrganizationProfile o = (GeneralOrganizationProfile) uniDB.find(cl.id, GeneralOrganizationProfile.class);

        code = cl.code;
        name = ((o.getName().equals("")) ? "-" : o.getName());
        no = ((o.getAddress1().equals("")) ? "-" : o.getAddress1());
        street = ((o.getAddress2().equals("")) ? "-" : o.getAddress2());
        city = ((o.getAddress3().equals("")) ? "-" : o.getAddress3());
        phone = ((o.getPhone().equals("")) ? "-" : o.getPhone());
        postalCode = ((o.getPostalCode().equals("")) ? "-" : o.getPostalCode());
        email = ((o.getEmail().equals("")) ? "-" : o.getEmail());
        phoneOther = ((o.getPhoneOther().equals("")) ? "-" : o.getPhoneOther());
        fax = ((o.getFax().equals("")) ? "-" : o.getFax());
        gop_id = o.getId();

    }

    //--------------------------------------------------------------------------
    public void editName() {

        GeneralOrganizationProfile o = (GeneralOrganizationProfile) uniDB.find(gop_id, GeneralOrganizationProfile.class);
        o.setName(name);
        uniDB.update(o);
    }

    public void editNo() {

        GeneralOrganizationProfile o = (GeneralOrganizationProfile) uniDB.find(gop_id, GeneralOrganizationProfile.class);
        o.setAddress1(no);
        uniDB.update(o);
    }

    public void editStreet() {

        GeneralOrganizationProfile o = (GeneralOrganizationProfile) uniDB.find(gop_id, GeneralOrganizationProfile.class);
        o.setAddress2(street);
        uniDB.update(o);
    }

    public void editCity() {

        GeneralOrganizationProfile o = (GeneralOrganizationProfile) uniDB.find(gop_id, GeneralOrganizationProfile.class);
        o.setAddress3(city);
        uniDB.update(o);
    }

    public void editPhone() {

        GeneralOrganizationProfile o = (GeneralOrganizationProfile) uniDB.find(gop_id, GeneralOrganizationProfile.class);
        o.setPhone(phone);
        uniDB.update(o);
    }

    public void editPhoneOther() {

        GeneralOrganizationProfile o = (GeneralOrganizationProfile) uniDB.find(gop_id, GeneralOrganizationProfile.class);
        o.setPhoneOther(phoneOther);
        uniDB.update(o);
    }

    public void editEmail() {

        GeneralOrganizationProfile o = (GeneralOrganizationProfile) uniDB.find(gop_id, GeneralOrganizationProfile.class);
        o.setEmail(email);
        uniDB.update(o);
    }

    public void editFax() {

        GeneralOrganizationProfile o = (GeneralOrganizationProfile) uniDB.find(gop_id, GeneralOrganizationProfile.class);
        o.setFax(fax);
        uniDB.update(o);
    }

    //--------------------------------------------------------------------------
    public static class CustomersList implements Serializable {

        private int id;
        private String code;
        private String name;
        private String phone;
        private String email;

        public CustomersList(int id, String code, String name, String phone, String email) {
            this.id = id;
            this.code = code;
            this.name = name;
            this.phone = phone;
            this.email = email;
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
