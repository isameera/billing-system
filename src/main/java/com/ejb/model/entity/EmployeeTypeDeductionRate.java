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
@Table(name = "employee_type_deduction_rate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeTypeDeductionRate.findAll", query = "SELECT e FROM EmployeeTypeDeductionRate e")
    , @NamedQuery(name = "EmployeeTypeDeductionRate.findById", query = "SELECT e FROM EmployeeTypeDeductionRate e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeTypeDeductionRate.findByStartYear", query = "SELECT e FROM EmployeeTypeDeductionRate e WHERE e.startYear = :startYear")
    , @NamedQuery(name = "EmployeeTypeDeductionRate.findByStartMonth", query = "SELECT e FROM EmployeeTypeDeductionRate e WHERE e.startMonth = :startMonth")
    , @NamedQuery(name = "EmployeeTypeDeductionRate.findByEndYear", query = "SELECT e FROM EmployeeTypeDeductionRate e WHERE e.endYear = :endYear")
    , @NamedQuery(name = "EmployeeTypeDeductionRate.findByEndMonth", query = "SELECT e FROM EmployeeTypeDeductionRate e WHERE e.endMonth = :endMonth")
    , @NamedQuery(name = "EmployeeTypeDeductionRate.findByRate", query = "SELECT e FROM EmployeeTypeDeductionRate e WHERE e.rate = :rate")})
public class EmployeeTypeDeductionRate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "start_year")
    private Integer startYear;
    @Column(name = "start_month")
    private Integer startMonth;
    @Column(name = "end_year")
    private Integer endYear;
    @Column(name = "end_month")
    private Integer endMonth;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rate")
    private Double rate;
    @JoinColumn(name = "employee_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EmployeeType employeeTypeId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;

    public EmployeeTypeDeductionRate() {
    }

    public EmployeeTypeDeductionRate(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Integer startMonth) {
        this.startMonth = startMonth;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public Integer getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(Integer endMonth) {
        this.endMonth = endMonth;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public EmployeeType getEmployeeTypeId() {
        return employeeTypeId;
    }

    public void setEmployeeTypeId(EmployeeType employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
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
        if (!(object instanceof EmployeeTypeDeductionRate)) {
            return false;
        }
        EmployeeTypeDeductionRate other = (EmployeeTypeDeductionRate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.EmployeeTypeDeductionRate[ id=" + id + " ]";
    }
    
}
