package com.webapps.controller.managebeans.test;

import com.ejb.model.common.UniDBLocal;
import com.ejb.model.entity.UnitOfMeasure;
import com.ejb.model.entity.VoucherType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.ultima.domain.Car;

@ManagedBean(name = "advanceRequest")
@ViewScoped
public class AdvanceRequestSheetDataLoader implements Serializable {

    @EJB
    UniDBLocal uni;

    private List<RequestType> RequestTypes =new ArrayList<RequestType>();
    private List<SelectItem> unitList = new ArrayList<SelectItem>();
    RequestType fuel;
    RequestType advance_or_rent;
    RequestType other_expenses;

    public List<SelectItem> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<SelectItem> unitList) {
        this.unitList = unitList;
    }

    @PostConstruct
    public void init() {
        
        populatePlayers();
    }

    public void populatePlayers() {

        getUnitList().add(new SelectItem(0, ""));

        String query = "SELECT g from UnitOfMeasure g ORDER BY g.name ASC";

        List<UnitOfMeasure> listAS = uni.searchByQuery(query);
        for (UnitOfMeasure cc : listAS) {

            getUnitList().add(new SelectItem(cc.getId(), cc.getName()));
        }

        RequestTypes = new ArrayList<RequestType>();

        fuel = new RequestType(1, "Fuel");

        fuel.getDetails().add(new RequestDetails("1", "Vehicle", "", getUnitList(), "", "", ""));
        fuel.getDetails().add(new RequestDetails("2", "Machine", "", getUnitList(), "", "", ""));
        fuel.getDetails().add(new RequestDetails("3", "", "", getUnitList(), "", "", ""));

        RequestTypes.add(fuel);

        advance_or_rent = new RequestType(2, "Advance Payments / Rent");
        advance_or_rent.getDetails().add(new RequestDetails("1", "", "", getUnitList(), "", "", ""));
        advance_or_rent.getDetails().add(new RequestDetails("2", "", "", getUnitList(), "", "", ""));
        advance_or_rent.getDetails().add(new RequestDetails("3", "", "", getUnitList(), "", "", ""));

        RequestTypes.add(advance_or_rent);

        other_expenses = new RequestType(3, "Other Expenses");
        other_expenses.getDetails().add(new RequestDetails("1", "", "", getUnitList(), "", "", ""));
        other_expenses.getDetails().add(new RequestDetails("2", "", "", getUnitList(), "", "", ""));
        other_expenses.getDetails().add(new RequestDetails("3", "", "", getUnitList(), "", "", ""));
        other_expenses.getDetails().add(new RequestDetails("4", "", "", getUnitList(), "", "", ""));
        other_expenses.getDetails().add(new RequestDetails("5", "", "", getUnitList(), "", "", ""));
        other_expenses.getDetails().add(new RequestDetails("6", "", "", getUnitList(), "", "", ""));

        RequestTypes.add(other_expenses);
    }

    public List<RequestType> getRequestTypes() {
        return RequestTypes;
    }

    public class RequestType implements Serializable {

        private String name;
        private int typeID;

        private List<RequestDetails> details = new ArrayList<RequestDetails>();

        public RequestType() {
        }

        public RequestType(int typeID, String name) {
            this.typeID = typeID;
            this.name = name;

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getTypeID() {
            return typeID;
        }

        public void setTypeID(int typeID) {
            this.typeID = typeID;
        }

        public List<RequestDetails> getDetails() {
            return details;
        }

        public void setDetails(List<RequestDetails> details) {
            this.details = details;
        }

    }

    public class RequestDetails implements Serializable {

        private String no;
        private String fixText;
        private String description;
        private List<SelectItem> unitList = new ArrayList<SelectItem>();
        private String qty;
        private String rate;
        private String amount;

        public RequestDetails() {
        }

        public RequestDetails(String no, String fixText, String description, List<SelectItem> unitList, String qty, String rate, String amount) {
            this.no = no;
            this.fixText = fixText;
            this.description = description;
            this.qty = qty;
            this.rate = rate;
            this.amount = amount;
            this.unitList = unitList;

        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getFixText() {
            return fixText;
        }

        public void setFixText(String fixText) {
            this.fixText = fixText;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getQty() {
            return qty;
        }

        public void setQty(String qty) {
            this.qty = qty;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public List<SelectItem> getUnitList() {
            return unitList;
        }

        public void setUnitList(List<SelectItem> unitList) {
            this.unitList = unitList;
        }

    }

    public String addRow() {

//        String message = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("msg");
        fuel.getDetails().add(new RequestDetails("1", "ABC", "", getUnitList(), "", "", ""));

        System.out.println("getRequestTypes() " + getRequestTypes());

        return null;
    }

}
