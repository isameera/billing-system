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
@Table(name = "employee_allowance_deduction_history_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeAllowanceDeductionHistoryManager.findAll", query = "SELECT e FROM EmployeeAllowanceDeductionHistoryManager e")
    , @NamedQuery(name = "EmployeeAllowanceDeductionHistoryManager.findById", query = "SELECT e FROM EmployeeAllowanceDeductionHistoryManager e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeAllowanceDeductionHistoryManager.findByValue", query = "SELECT e FROM EmployeeAllowanceDeductionHistoryManager e WHERE e.value = :value")})
public class EmployeeAllowanceDeductionHistoryManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "value")
    private Double value;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeAllowanceDeductionHistoryManagerId")
    private Collection<VariableAllowanceTransactions> variableAllowanceTransactionsCollection;
    @JoinColumn(name = "employee_monthly_salary_history_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EmployeeMonthlySalaryHistory employeeMonthlySalaryHistoryId;
    @JoinColumn(name = "allowance_or_deduction_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AllowanceOrDeduction allowanceOrDeductionId;
    @JoinColumn(name = "allowance_or_deduction_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AllowanceOrDeductionType allowanceOrDeductionTypeId;

    public EmployeeAllowanceDeductionHistoryManager() {
    }

    public EmployeeAllowanceDeductionHistoryManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @XmlTransient
    public Collection<VariableAllowanceTransactions> getVariableAllowanceTransactionsCollection() {
        return variableAllowanceTransactionsCollection;
    }

    public void setVariableAllowanceTransactionsCollection(Collection<VariableAllowanceTransactions> variableAllowanceTransactionsCollection) {
        this.variableAllowanceTransactionsCollection = variableAllowanceTransactionsCollection;
    }

    public EmployeeMonthlySalaryHistory getEmployeeMonthlySalaryHistoryId() {
        return employeeMonthlySalaryHistoryId;
    }

    public void setEmployeeMonthlySalaryHistoryId(EmployeeMonthlySalaryHistory employeeMonthlySalaryHistoryId) {
        this.employeeMonthlySalaryHistoryId = employeeMonthlySalaryHistoryId;
    }

    public AllowanceOrDeduction getAllowanceOrDeductionId() {
        return allowanceOrDeductionId;
    }

    public void setAllowanceOrDeductionId(AllowanceOrDeduction allowanceOrDeductionId) {
        this.allowanceOrDeductionId = allowanceOrDeductionId;
    }

    public AllowanceOrDeductionType getAllowanceOrDeductionTypeId() {
        return allowanceOrDeductionTypeId;
    }

    public void setAllowanceOrDeductionTypeId(AllowanceOrDeductionType allowanceOrDeductionTypeId) {
        this.allowanceOrDeductionTypeId = allowanceOrDeductionTypeId;
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
        if (!(object instanceof EmployeeAllowanceDeductionHistoryManager)) {
            return false;
        }
        EmployeeAllowanceDeductionHistoryManager other = (EmployeeAllowanceDeductionHistoryManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.EmployeeAllowanceDeductionHistoryManager[ id=" + id + " ]";
    }
    
}
