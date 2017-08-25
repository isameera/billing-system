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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "employee_salary_increment_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeSalaryIncrementHistory.findAll", query = "SELECT e FROM EmployeeSalaryIncrementHistory e")
    , @NamedQuery(name = "EmployeeSalaryIncrementHistory.findById", query = "SELECT e FROM EmployeeSalaryIncrementHistory e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeSalaryIncrementHistory.findByDate", query = "SELECT e FROM EmployeeSalaryIncrementHistory e WHERE e.date = :date")
    , @NamedQuery(name = "EmployeeSalaryIncrementHistory.findByAmount", query = "SELECT e FROM EmployeeSalaryIncrementHistory e WHERE e.amount = :amount")
    , @NamedQuery(name = "EmployeeSalaryIncrementHistory.findByOccurrence", query = "SELECT e FROM EmployeeSalaryIncrementHistory e WHERE e.occurrence = :occurrence")})
public class EmployeeSalaryIncrementHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @Column(name = "occurrence")
    private Integer occurrence;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;

    public EmployeeSalaryIncrementHistory() {
    }

    public EmployeeSalaryIncrementHistory(Integer id) {
        this.id = id;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(Integer occurrence) {
        this.occurrence = occurrence;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
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
        if (!(object instanceof EmployeeSalaryIncrementHistory)) {
            return false;
        }
        EmployeeSalaryIncrementHistory other = (EmployeeSalaryIncrementHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.EmployeeSalaryIncrementHistory[ id=" + id + " ]";
    }
    
}
