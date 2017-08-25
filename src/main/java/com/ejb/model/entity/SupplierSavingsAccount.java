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
@Table(name = "supplier_savings_account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierSavingsAccount.findAll", query = "SELECT s FROM SupplierSavingsAccount s")
    , @NamedQuery(name = "SupplierSavingsAccount.findById", query = "SELECT s FROM SupplierSavingsAccount s WHERE s.id = :id")
    , @NamedQuery(name = "SupplierSavingsAccount.findByRequstedDate", query = "SELECT s FROM SupplierSavingsAccount s WHERE s.requstedDate = :requstedDate")
    , @NamedQuery(name = "SupplierSavingsAccount.findByRegDate", query = "SELECT s FROM SupplierSavingsAccount s WHERE s.regDate = :regDate")
    , @NamedQuery(name = "SupplierSavingsAccount.findByPayableAmount", query = "SELECT s FROM SupplierSavingsAccount s WHERE s.payableAmount = :payableAmount")
    , @NamedQuery(name = "SupplierSavingsAccount.findByRate", query = "SELECT s FROM SupplierSavingsAccount s WHERE s.rate = :rate")})
public class SupplierSavingsAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "requsted_date")
    @Temporal(TemporalType.DATE)
    private Date requstedDate;
    @Column(name = "reg_date")
    @Temporal(TemporalType.DATE)
    private Date regDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "payable_amount")
    private Double payableAmount;
    @Column(name = "rate")
    private Double rate;
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Route routeId;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierRegistration supplierRegistrationId;
    @JoinColumn(name = "universal_approval_status_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalApprovalStatusManager universalApprovalStatusManagerId;
    @JoinColumn(name = "universal_payment_mode_id", referencedColumnName = "id")
    @ManyToOne
    private UniversalPaymentMode universalPaymentModeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierSavingsAccountId")
    private Collection<SupplierSavingsPaymentHistory> supplierSavingsPaymentHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierSavingsAccountId")
    private Collection<SupplierSavingsActiveInactiveHistory> supplierSavingsActiveInactiveHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierSavingsAccountId")
    private Collection<PreparePaymentsForSupplierSavings> preparePaymentsForSupplierSavingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierSavingsAccountId")
    private Collection<SupplierSavingsRequstedMonths> supplierSavingsRequstedMonthsCollection;

    public SupplierSavingsAccount() {
    }

    public SupplierSavingsAccount(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRequstedDate() {
        return requstedDate;
    }

    public void setRequstedDate(Date requstedDate) {
        this.requstedDate = requstedDate;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Double getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(Double payableAmount) {
        this.payableAmount = payableAmount;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    public SupplierRegistration getSupplierRegistrationId() {
        return supplierRegistrationId;
    }

    public void setSupplierRegistrationId(SupplierRegistration supplierRegistrationId) {
        this.supplierRegistrationId = supplierRegistrationId;
    }

    public UniversalApprovalStatusManager getUniversalApprovalStatusManagerId() {
        return universalApprovalStatusManagerId;
    }

    public void setUniversalApprovalStatusManagerId(UniversalApprovalStatusManager universalApprovalStatusManagerId) {
        this.universalApprovalStatusManagerId = universalApprovalStatusManagerId;
    }

    public UniversalPaymentMode getUniversalPaymentModeId() {
        return universalPaymentModeId;
    }

    public void setUniversalPaymentModeId(UniversalPaymentMode universalPaymentModeId) {
        this.universalPaymentModeId = universalPaymentModeId;
    }

    @XmlTransient
    public Collection<SupplierSavingsPaymentHistory> getSupplierSavingsPaymentHistoryCollection() {
        return supplierSavingsPaymentHistoryCollection;
    }

    public void setSupplierSavingsPaymentHistoryCollection(Collection<SupplierSavingsPaymentHistory> supplierSavingsPaymentHistoryCollection) {
        this.supplierSavingsPaymentHistoryCollection = supplierSavingsPaymentHistoryCollection;
    }

    @XmlTransient
    public Collection<SupplierSavingsActiveInactiveHistory> getSupplierSavingsActiveInactiveHistoryCollection() {
        return supplierSavingsActiveInactiveHistoryCollection;
    }

    public void setSupplierSavingsActiveInactiveHistoryCollection(Collection<SupplierSavingsActiveInactiveHistory> supplierSavingsActiveInactiveHistoryCollection) {
        this.supplierSavingsActiveInactiveHistoryCollection = supplierSavingsActiveInactiveHistoryCollection;
    }

    @XmlTransient
    public Collection<PreparePaymentsForSupplierSavings> getPreparePaymentsForSupplierSavingsCollection() {
        return preparePaymentsForSupplierSavingsCollection;
    }

    public void setPreparePaymentsForSupplierSavingsCollection(Collection<PreparePaymentsForSupplierSavings> preparePaymentsForSupplierSavingsCollection) {
        this.preparePaymentsForSupplierSavingsCollection = preparePaymentsForSupplierSavingsCollection;
    }

    @XmlTransient
    public Collection<SupplierSavingsRequstedMonths> getSupplierSavingsRequstedMonthsCollection() {
        return supplierSavingsRequstedMonthsCollection;
    }

    public void setSupplierSavingsRequstedMonthsCollection(Collection<SupplierSavingsRequstedMonths> supplierSavingsRequstedMonthsCollection) {
        this.supplierSavingsRequstedMonthsCollection = supplierSavingsRequstedMonthsCollection;
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
        if (!(object instanceof SupplierSavingsAccount)) {
            return false;
        }
        SupplierSavingsAccount other = (SupplierSavingsAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierSavingsAccount[ id=" + id + " ]";
    }
    
}
