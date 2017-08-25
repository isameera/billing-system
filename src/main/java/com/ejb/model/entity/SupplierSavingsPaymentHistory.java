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
@Table(name = "supplier_savings_payment_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierSavingsPaymentHistory.findAll", query = "SELECT s FROM SupplierSavingsPaymentHistory s")
    , @NamedQuery(name = "SupplierSavingsPaymentHistory.findById", query = "SELECT s FROM SupplierSavingsPaymentHistory s WHERE s.id = :id")
    , @NamedQuery(name = "SupplierSavingsPaymentHistory.findByYear", query = "SELECT s FROM SupplierSavingsPaymentHistory s WHERE s.year = :year")
    , @NamedQuery(name = "SupplierSavingsPaymentHistory.findByMonth", query = "SELECT s FROM SupplierSavingsPaymentHistory s WHERE s.month = :month")
    , @NamedQuery(name = "SupplierSavingsPaymentHistory.findByLeafQty", query = "SELECT s FROM SupplierSavingsPaymentHistory s WHERE s.leafQty = :leafQty")
    , @NamedQuery(name = "SupplierSavingsPaymentHistory.findByValue", query = "SELECT s FROM SupplierSavingsPaymentHistory s WHERE s.value = :value")
    , @NamedQuery(name = "SupplierSavingsPaymentHistory.findByRate", query = "SELECT s FROM SupplierSavingsPaymentHistory s WHERE s.rate = :rate")
    , @NamedQuery(name = "SupplierSavingsPaymentHistory.findByIsPaid", query = "SELECT s FROM SupplierSavingsPaymentHistory s WHERE s.isPaid = :isPaid")})
public class SupplierSavingsPaymentHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "year")
    private Integer year;
    @Column(name = "month")
    private Integer month;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "leaf_qty")
    private Double leafQty;
    @Column(name = "value")
    private Double value;
    @Column(name = "rate")
    private Double rate;
    @Column(name = "is_paid")
    private Integer isPaid;
    @JoinColumn(name = "supplier_savings_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierSavingsAccount supplierSavingsAccountId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierSavingsPaymentHistoryId")
    private Collection<SupplierSavingsPaymentManager> supplierSavingsPaymentManagerCollection;

    public SupplierSavingsPaymentHistory() {
    }

    public SupplierSavingsPaymentHistory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getLeafQty() {
        return leafQty;
    }

    public void setLeafQty(Double leafQty) {
        this.leafQty = leafQty;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Integer isPaid) {
        this.isPaid = isPaid;
    }

    public SupplierSavingsAccount getSupplierSavingsAccountId() {
        return supplierSavingsAccountId;
    }

    public void setSupplierSavingsAccountId(SupplierSavingsAccount supplierSavingsAccountId) {
        this.supplierSavingsAccountId = supplierSavingsAccountId;
    }

    @XmlTransient
    public Collection<SupplierSavingsPaymentManager> getSupplierSavingsPaymentManagerCollection() {
        return supplierSavingsPaymentManagerCollection;
    }

    public void setSupplierSavingsPaymentManagerCollection(Collection<SupplierSavingsPaymentManager> supplierSavingsPaymentManagerCollection) {
        this.supplierSavingsPaymentManagerCollection = supplierSavingsPaymentManagerCollection;
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
        if (!(object instanceof SupplierSavingsPaymentHistory)) {
            return false;
        }
        SupplierSavingsPaymentHistory other = (SupplierSavingsPaymentHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierSavingsPaymentHistory[ id=" + id + " ]";
    }
    
}
