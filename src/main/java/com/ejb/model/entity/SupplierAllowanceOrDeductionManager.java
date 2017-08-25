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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "supplier_allowance_or_deduction_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierAllowanceOrDeductionManager.findAll", query = "SELECT s FROM SupplierAllowanceOrDeductionManager s")
    , @NamedQuery(name = "SupplierAllowanceOrDeductionManager.findById", query = "SELECT s FROM SupplierAllowanceOrDeductionManager s WHERE s.id = :id")
    , @NamedQuery(name = "SupplierAllowanceOrDeductionManager.findByDate", query = "SELECT s FROM SupplierAllowanceOrDeductionManager s WHERE s.date = :date")
    , @NamedQuery(name = "SupplierAllowanceOrDeductionManager.findByAmount", query = "SELECT s FROM SupplierAllowanceOrDeductionManager s WHERE s.amount = :amount")})
public class SupplierAllowanceOrDeductionManager implements Serializable {

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
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "allowance_or_deduction_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AllowanceOrDeduction allowanceOrDeductionId;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierRegistration supplierRegistrationId;

    public SupplierAllowanceOrDeductionManager() {
    }

    public SupplierAllowanceOrDeductionManager(Integer id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AllowanceOrDeduction getAllowanceOrDeductionId() {
        return allowanceOrDeductionId;
    }

    public void setAllowanceOrDeductionId(AllowanceOrDeduction allowanceOrDeductionId) {
        this.allowanceOrDeductionId = allowanceOrDeductionId;
    }

    public SupplierRegistration getSupplierRegistrationId() {
        return supplierRegistrationId;
    }

    public void setSupplierRegistrationId(SupplierRegistration supplierRegistrationId) {
        this.supplierRegistrationId = supplierRegistrationId;
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
        if (!(object instanceof SupplierAllowanceOrDeductionManager)) {
            return false;
        }
        SupplierAllowanceOrDeductionManager other = (SupplierAllowanceOrDeductionManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierAllowanceOrDeductionManager[ id=" + id + " ]";
    }
    
}
