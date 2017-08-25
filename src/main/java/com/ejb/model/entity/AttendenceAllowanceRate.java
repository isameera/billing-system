/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "attendence_allowance_rate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AttendenceAllowanceRate.findAll", query = "SELECT a FROM AttendenceAllowanceRate a")
    , @NamedQuery(name = "AttendenceAllowanceRate.findById", query = "SELECT a FROM AttendenceAllowanceRate a WHERE a.id = :id")
    , @NamedQuery(name = "AttendenceAllowanceRate.findByYearFrom", query = "SELECT a FROM AttendenceAllowanceRate a WHERE a.yearFrom = :yearFrom")
    , @NamedQuery(name = "AttendenceAllowanceRate.findByMonthFrom", query = "SELECT a FROM AttendenceAllowanceRate a WHERE a.monthFrom = :monthFrom")
    , @NamedQuery(name = "AttendenceAllowanceRate.findByYearTo", query = "SELECT a FROM AttendenceAllowanceRate a WHERE a.yearTo = :yearTo")
    , @NamedQuery(name = "AttendenceAllowanceRate.findByMonthTo", query = "SELECT a FROM AttendenceAllowanceRate a WHERE a.monthTo = :monthTo")
    , @NamedQuery(name = "AttendenceAllowanceRate.findByDaysFrom", query = "SELECT a FROM AttendenceAllowanceRate a WHERE a.daysFrom = :daysFrom")
    , @NamedQuery(name = "AttendenceAllowanceRate.findByDaysTo", query = "SELECT a FROM AttendenceAllowanceRate a WHERE a.daysTo = :daysTo")
    , @NamedQuery(name = "AttendenceAllowanceRate.findByAmount", query = "SELECT a FROM AttendenceAllowanceRate a WHERE a.amount = :amount")})
public class AttendenceAllowanceRate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "year_from")
    private Integer yearFrom;
    @Column(name = "month_from")
    private Integer monthFrom;
    @Column(name = "year_to")
    private Integer yearTo;
    @Column(name = "month_to")
    private Integer monthTo;
    @Column(name = "days_from")
    private Integer daysFrom;
    @Column(name = "days_to")
    private Integer daysTo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @JoinColumn(name = "employee_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EmployeeCategory employeeCategoryId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;

    public AttendenceAllowanceRate() {
    }

    public AttendenceAllowanceRate(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(Integer yearFrom) {
        this.yearFrom = yearFrom;
    }

    public Integer getMonthFrom() {
        return monthFrom;
    }

    public void setMonthFrom(Integer monthFrom) {
        this.monthFrom = monthFrom;
    }

    public Integer getYearTo() {
        return yearTo;
    }

    public void setYearTo(Integer yearTo) {
        this.yearTo = yearTo;
    }

    public Integer getMonthTo() {
        return monthTo;
    }

    public void setMonthTo(Integer monthTo) {
        this.monthTo = monthTo;
    }

    public Integer getDaysFrom() {
        return daysFrom;
    }

    public void setDaysFrom(Integer daysFrom) {
        this.daysFrom = daysFrom;
    }

    public Integer getDaysTo() {
        return daysTo;
    }

    public void setDaysTo(Integer daysTo) {
        this.daysTo = daysTo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public EmployeeCategory getEmployeeCategoryId() {
        return employeeCategoryId;
    }

    public void setEmployeeCategoryId(EmployeeCategory employeeCategoryId) {
        this.employeeCategoryId = employeeCategoryId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
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
        if (!(object instanceof AttendenceAllowanceRate)) {
            return false;
        }
        AttendenceAllowanceRate other = (AttendenceAllowanceRate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.AttendenceAllowanceRate[ id=" + id + " ]";
    }
    
}
