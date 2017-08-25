/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "variable_allowance_transactions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VariableAllowanceTransactions.findAll", query = "SELECT v FROM VariableAllowanceTransactions v")
    , @NamedQuery(name = "VariableAllowanceTransactions.findById", query = "SELECT v FROM VariableAllowanceTransactions v WHERE v.id = :id")
    , @NamedQuery(name = "VariableAllowanceTransactions.findByDate", query = "SELECT v FROM VariableAllowanceTransactions v WHERE v.date = :date")
    , @NamedQuery(name = "VariableAllowanceTransactions.findByValue", query = "SELECT v FROM VariableAllowanceTransactions v WHERE v.value = :value")})
public class VariableAllowanceTransactions implements Serializable {

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
    @Column(name = "value")
    private Double value;
    @Lob
    @Size(max = 65535)
    @Column(name = "reason")
    private String reason;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "variableAllowanceTransactionsId")
    private Collection<VatEarController> vatEarControllerCollection;
    @JoinColumn(name = "employee_allowance_deduction_history_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EmployeeAllowanceDeductionHistoryManager employeeAllowanceDeductionHistoryManagerId;
    @JoinColumn(name = "voucher_id", referencedColumnName = "id")
    @ManyToOne
    private Voucher voucherId;

    public VariableAllowanceTransactions() {
    }

    public VariableAllowanceTransactions(Integer id) {
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @XmlTransient
    public Collection<VatEarController> getVatEarControllerCollection() {
        return vatEarControllerCollection;
    }

    public void setVatEarControllerCollection(Collection<VatEarController> vatEarControllerCollection) {
        this.vatEarControllerCollection = vatEarControllerCollection;
    }

    public EmployeeAllowanceDeductionHistoryManager getEmployeeAllowanceDeductionHistoryManagerId() {
        return employeeAllowanceDeductionHistoryManagerId;
    }

    public void setEmployeeAllowanceDeductionHistoryManagerId(EmployeeAllowanceDeductionHistoryManager employeeAllowanceDeductionHistoryManagerId) {
        this.employeeAllowanceDeductionHistoryManagerId = employeeAllowanceDeductionHistoryManagerId;
    }

    public Voucher getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Voucher voucherId) {
        this.voucherId = voucherId;
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
        if (!(object instanceof VariableAllowanceTransactions)) {
            return false;
        }
        VariableAllowanceTransactions other = (VariableAllowanceTransactions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.VariableAllowanceTransactions[ id=" + id + " ]";
    }
    
}
