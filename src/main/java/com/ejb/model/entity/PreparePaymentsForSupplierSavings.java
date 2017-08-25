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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "prepare_payments_for_supplier_savings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreparePaymentsForSupplierSavings.findAll", query = "SELECT p FROM PreparePaymentsForSupplierSavings p")
    , @NamedQuery(name = "PreparePaymentsForSupplierSavings.findById", query = "SELECT p FROM PreparePaymentsForSupplierSavings p WHERE p.id = :id")
    , @NamedQuery(name = "PreparePaymentsForSupplierSavings.findBySavingAmount", query = "SELECT p FROM PreparePaymentsForSupplierSavings p WHERE p.savingAmount = :savingAmount")
    , @NamedQuery(name = "PreparePaymentsForSupplierSavings.findByDate", query = "SELECT p FROM PreparePaymentsForSupplierSavings p WHERE p.date = :date")
    , @NamedQuery(name = "PreparePaymentsForSupplierSavings.findByIsPaid", query = "SELECT p FROM PreparePaymentsForSupplierSavings p WHERE p.isPaid = :isPaid")
    , @NamedQuery(name = "PreparePaymentsForSupplierSavings.findByBfCoins", query = "SELECT p FROM PreparePaymentsForSupplierSavings p WHERE p.bfCoins = :bfCoins")
    , @NamedQuery(name = "PreparePaymentsForSupplierSavings.findByInterestRate", query = "SELECT p FROM PreparePaymentsForSupplierSavings p WHERE p.interestRate = :interestRate")
    , @NamedQuery(name = "PreparePaymentsForSupplierSavings.findByBalanceAmount", query = "SELECT p FROM PreparePaymentsForSupplierSavings p WHERE p.balanceAmount = :balanceAmount")
    , @NamedQuery(name = "PreparePaymentsForSupplierSavings.findByPaidAmount", query = "SELECT p FROM PreparePaymentsForSupplierSavings p WHERE p.paidAmount = :paidAmount")
    , @NamedQuery(name = "PreparePaymentsForSupplierSavings.findByCfCoins", query = "SELECT p FROM PreparePaymentsForSupplierSavings p WHERE p.cfCoins = :cfCoins")})
public class PreparePaymentsForSupplierSavings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saving_amount")
    private Double savingAmount;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "is_paid")
    private Integer isPaid;
    @Column(name = "bf_coins")
    private Double bfCoins;
    @Column(name = "interest_rate")
    private Double interestRate;
    @Column(name = "balance_amount")
    private Double balanceAmount;
    @Column(name = "paid_amount")
    private Double paidAmount;
    @Column(name = "cf_coins")
    private Double cfCoins;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Route routeId;
    @JoinColumn(name = "supplier_savings_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierSavingsAccount supplierSavingsAccountId;
    @JoinColumn(name = "universal_payment_mode_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalPaymentMode universalPaymentModeId;
    @JoinColumn(name = "voucher_id", referencedColumnName = "id")
    @ManyToOne
    private Voucher voucherId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preparePaymentsForSupplierSavingsId")
    private Collection<SupplierSavingsPaymentManager> supplierSavingsPaymentManagerCollection;

    public PreparePaymentsForSupplierSavings() {
    }

    public PreparePaymentsForSupplierSavings(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSavingAmount() {
        return savingAmount;
    }

    public void setSavingAmount(Double savingAmount) {
        this.savingAmount = savingAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Integer isPaid) {
        this.isPaid = isPaid;
    }

    public Double getBfCoins() {
        return bfCoins;
    }

    public void setBfCoins(Double bfCoins) {
        this.bfCoins = bfCoins;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(Double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Double getCfCoins() {
        return cfCoins;
    }

    public void setCfCoins(Double cfCoins) {
        this.cfCoins = cfCoins;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    public SupplierSavingsAccount getSupplierSavingsAccountId() {
        return supplierSavingsAccountId;
    }

    public void setSupplierSavingsAccountId(SupplierSavingsAccount supplierSavingsAccountId) {
        this.supplierSavingsAccountId = supplierSavingsAccountId;
    }

    public UniversalPaymentMode getUniversalPaymentModeId() {
        return universalPaymentModeId;
    }

    public void setUniversalPaymentModeId(UniversalPaymentMode universalPaymentModeId) {
        this.universalPaymentModeId = universalPaymentModeId;
    }

    public Voucher getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Voucher voucherId) {
        this.voucherId = voucherId;
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
        if (!(object instanceof PreparePaymentsForSupplierSavings)) {
            return false;
        }
        PreparePaymentsForSupplierSavings other = (PreparePaymentsForSupplierSavings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.PreparePaymentsForSupplierSavings[ id=" + id + " ]";
    }
    
}
