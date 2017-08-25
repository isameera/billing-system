/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "construction_site_employee_meal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConstructionSiteEmployeeMeal.findAll", query = "SELECT c FROM ConstructionSiteEmployeeMeal c")
    , @NamedQuery(name = "ConstructionSiteEmployeeMeal.findById", query = "SELECT c FROM ConstructionSiteEmployeeMeal c WHERE c.id = :id")
    , @NamedQuery(name = "ConstructionSiteEmployeeMeal.findByDate", query = "SELECT c FROM ConstructionSiteEmployeeMeal c WHERE c.date = :date")
    , @NamedQuery(name = "ConstructionSiteEmployeeMeal.findByBreakfast", query = "SELECT c FROM ConstructionSiteEmployeeMeal c WHERE c.breakfast = :breakfast")
    , @NamedQuery(name = "ConstructionSiteEmployeeMeal.findByLunch", query = "SELECT c FROM ConstructionSiteEmployeeMeal c WHERE c.lunch = :lunch")
    , @NamedQuery(name = "ConstructionSiteEmployeeMeal.findByDiner", query = "SELECT c FROM ConstructionSiteEmployeeMeal c WHERE c.diner = :diner")
    , @NamedQuery(name = "ConstructionSiteEmployeeMeal.findByExceedAmount", query = "SELECT c FROM ConstructionSiteEmployeeMeal c WHERE c.exceedAmount = :exceedAmount")
    , @NamedQuery(name = "ConstructionSiteEmployeeMeal.findByDayAmount", query = "SELECT c FROM ConstructionSiteEmployeeMeal c WHERE c.dayAmount = :dayAmount")
    , @NamedQuery(name = "ConstructionSiteEmployeeMeal.findByConstructionSiteLocationId", query = "SELECT c FROM ConstructionSiteEmployeeMeal c WHERE c.constructionSiteLocationId = :constructionSiteLocationId")})
public class ConstructionSiteEmployeeMeal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "breakfast")
    private Boolean breakfast;
    @Column(name = "lunch")
    private Boolean lunch;
    @Column(name = "diner")
    private Boolean diner;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "exceed_amount")
    private Double exceedAmount;
    @Column(name = "day_amount")
    private Integer dayAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "construction_site_location_id")
    private int constructionSiteLocationId;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "supervisor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee supervisor;

    public ConstructionSiteEmployeeMeal() {
    }

    public ConstructionSiteEmployeeMeal(Integer id) {
        this.id = id;
    }

    public ConstructionSiteEmployeeMeal(Integer id, int constructionSiteLocationId) {
        this.id = id;
        this.constructionSiteLocationId = constructionSiteLocationId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Boolean breakfast) {
        this.breakfast = breakfast;
    }

    public Boolean getLunch() {
        return lunch;
    }

    public void setLunch(Boolean lunch) {
        this.lunch = lunch;
    }

    public Boolean getDiner() {
        return diner;
    }

    public void setDiner(Boolean diner) {
        this.diner = diner;
    }

    public Double getExceedAmount() {
        return exceedAmount;
    }

    public void setExceedAmount(Double exceedAmount) {
        this.exceedAmount = exceedAmount;
    }

    public Integer getDayAmount() {
        return dayAmount;
    }

    public void setDayAmount(Integer dayAmount) {
        this.dayAmount = dayAmount;
    }

    public int getConstructionSiteLocationId() {
        return constructionSiteLocationId;
    }

    public void setConstructionSiteLocationId(int constructionSiteLocationId) {
        this.constructionSiteLocationId = constructionSiteLocationId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConstructionSiteEmployeeMeal)) {
            return false;
        }
        ConstructionSiteEmployeeMeal other = (ConstructionSiteEmployeeMeal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ConstructionSiteEmployeeMeal[ id=" + id + " ]";
    }
    
}
