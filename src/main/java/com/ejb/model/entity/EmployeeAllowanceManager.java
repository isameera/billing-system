/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "employee_allowance_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeAllowanceManager.findAll", query = "SELECT e FROM EmployeeAllowanceManager e")
    , @NamedQuery(name = "EmployeeAllowanceManager.findById", query = "SELECT e FROM EmployeeAllowanceManager e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeAllowanceManager.findByAllowanceValue", query = "SELECT e FROM EmployeeAllowanceManager e WHERE e.allowanceValue = :allowanceValue")})
public class EmployeeAllowanceManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "allowance_value")
    private Double allowanceValue;
    @JoinColumn(name = "allowance_or_deduction_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AllowanceOrDeduction allowanceOrDeductionId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "salary_allowance_or_deductions_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AllowanceOrDeductionType salaryAllowanceOrDeductionsId;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeAllowanceManagerId")
    private Collection<EmployeeAllowanceHistory> employeeAllowanceHistoryCollection;

    public EmployeeAllowanceManager() {
    }

    public EmployeeAllowanceManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAllowanceValue() {
        return allowanceValue;
    }

    public void setAllowanceValue(Double allowanceValue) {
        this.allowanceValue = allowanceValue;
    }

    public AllowanceOrDeduction getAllowanceOrDeductionId() {
        return allowanceOrDeductionId;
    }

    public void setAllowanceOrDeductionId(AllowanceOrDeduction allowanceOrDeductionId) {
        this.allowanceOrDeductionId = allowanceOrDeductionId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public AllowanceOrDeductionType getSalaryAllowanceOrDeductionsId() {
        return salaryAllowanceOrDeductionsId;
    }

    public void setSalaryAllowanceOrDeductionsId(AllowanceOrDeductionType salaryAllowanceOrDeductionsId) {
        this.salaryAllowanceOrDeductionsId = salaryAllowanceOrDeductionsId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    @XmlTransient
    public Collection<EmployeeAllowanceHistory> getEmployeeAllowanceHistoryCollection() {
        return employeeAllowanceHistoryCollection;
    }

    public void setEmployeeAllowanceHistoryCollection(Collection<EmployeeAllowanceHistory> employeeAllowanceHistoryCollection) {
        this.employeeAllowanceHistoryCollection = employeeAllowanceHistoryCollection;
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
        if (!(object instanceof EmployeeAllowanceManager)) {
            return false;
        }
        EmployeeAllowanceManager other = (EmployeeAllowanceManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.EmployeeAllowanceManager[ id=" + id + " ]";
    }
    
}
