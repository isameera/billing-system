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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "universal_payment_mode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniversalPaymentMode.findAll", query = "SELECT u FROM UniversalPaymentMode u")
    , @NamedQuery(name = "UniversalPaymentMode.findById", query = "SELECT u FROM UniversalPaymentMode u WHERE u.id = :id")
    , @NamedQuery(name = "UniversalPaymentMode.findByName", query = "SELECT u FROM UniversalPaymentMode u WHERE u.name = :name")})
public class UniversalPaymentMode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "universalPaymentModeId")
    private Collection<SupplierSavingsAccount> supplierSavingsAccountCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPaymentModeId")
    private Collection<VoucherPaymentMode> voucherPaymentModeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPaymentModeId")
    private Collection<SupplierPaymentModeManager> supplierPaymentModeManagerCollection;
    @OneToMany(mappedBy = "universalPaymentModeId")
    private Collection<Voucher> voucherCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPaymentModeId")
    private Collection<UniversalOrgPersonFinancialHistory> universalOrgPersonFinancialHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPaymentModeId")
    private Collection<GeneralJournalEntry> generalJournalEntryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPaymentModeId")
    private Collection<PreparePaymentsForSupplierSavings> preparePaymentsForSupplierSavingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPaymentModeId")
    private Collection<SupplierFinalPaymentHistory> supplierFinalPaymentHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPaymentModeId")
    private Collection<SupplierAdvanceRequest> supplierAdvanceRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPaymentModeId")
    private Collection<SupplierAdvanceIssuingSummary> supplierAdvanceIssuingSummaryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPaymentModeId")
    private Collection<PurchaseMethod> purchaseMethodCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentModeId")
    private Collection<TeaSupplierPayments> teaSupplierPaymentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPaymentModeId")
    private Collection<EmployeePaymentDetails> employeePaymentDetailsCollection;

    public UniversalPaymentMode() {
    }

    public UniversalPaymentMode(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<SupplierSavingsAccount> getSupplierSavingsAccountCollection() {
        return supplierSavingsAccountCollection;
    }

    public void setSupplierSavingsAccountCollection(Collection<SupplierSavingsAccount> supplierSavingsAccountCollection) {
        this.supplierSavingsAccountCollection = supplierSavingsAccountCollection;
    }

    @XmlTransient
    public Collection<VoucherPaymentMode> getVoucherPaymentModeCollection() {
        return voucherPaymentModeCollection;
    }

    public void setVoucherPaymentModeCollection(Collection<VoucherPaymentMode> voucherPaymentModeCollection) {
        this.voucherPaymentModeCollection = voucherPaymentModeCollection;
    }

    @XmlTransient
    public Collection<SupplierPaymentModeManager> getSupplierPaymentModeManagerCollection() {
        return supplierPaymentModeManagerCollection;
    }

    public void setSupplierPaymentModeManagerCollection(Collection<SupplierPaymentModeManager> supplierPaymentModeManagerCollection) {
        this.supplierPaymentModeManagerCollection = supplierPaymentModeManagerCollection;
    }

    @XmlTransient
    public Collection<Voucher> getVoucherCollection() {
        return voucherCollection;
    }

    public void setVoucherCollection(Collection<Voucher> voucherCollection) {
        this.voucherCollection = voucherCollection;
    }

    @XmlTransient
    public Collection<UniversalOrgPersonFinancialHistory> getUniversalOrgPersonFinancialHistoryCollection() {
        return universalOrgPersonFinancialHistoryCollection;
    }

    public void setUniversalOrgPersonFinancialHistoryCollection(Collection<UniversalOrgPersonFinancialHistory> universalOrgPersonFinancialHistoryCollection) {
        this.universalOrgPersonFinancialHistoryCollection = universalOrgPersonFinancialHistoryCollection;
    }

    @XmlTransient
    public Collection<GeneralJournalEntry> getGeneralJournalEntryCollection() {
        return generalJournalEntryCollection;
    }

    public void setGeneralJournalEntryCollection(Collection<GeneralJournalEntry> generalJournalEntryCollection) {
        this.generalJournalEntryCollection = generalJournalEntryCollection;
    }

    @XmlTransient
    public Collection<PreparePaymentsForSupplierSavings> getPreparePaymentsForSupplierSavingsCollection() {
        return preparePaymentsForSupplierSavingsCollection;
    }

    public void setPreparePaymentsForSupplierSavingsCollection(Collection<PreparePaymentsForSupplierSavings> preparePaymentsForSupplierSavingsCollection) {
        this.preparePaymentsForSupplierSavingsCollection = preparePaymentsForSupplierSavingsCollection;
    }

    @XmlTransient
    public Collection<SupplierFinalPaymentHistory> getSupplierFinalPaymentHistoryCollection() {
        return supplierFinalPaymentHistoryCollection;
    }

    public void setSupplierFinalPaymentHistoryCollection(Collection<SupplierFinalPaymentHistory> supplierFinalPaymentHistoryCollection) {
        this.supplierFinalPaymentHistoryCollection = supplierFinalPaymentHistoryCollection;
    }

    @XmlTransient
    public Collection<SupplierAdvanceRequest> getSupplierAdvanceRequestCollection() {
        return supplierAdvanceRequestCollection;
    }

    public void setSupplierAdvanceRequestCollection(Collection<SupplierAdvanceRequest> supplierAdvanceRequestCollection) {
        this.supplierAdvanceRequestCollection = supplierAdvanceRequestCollection;
    }

    @XmlTransient
    public Collection<SupplierAdvanceIssuingSummary> getSupplierAdvanceIssuingSummaryCollection() {
        return supplierAdvanceIssuingSummaryCollection;
    }

    public void setSupplierAdvanceIssuingSummaryCollection(Collection<SupplierAdvanceIssuingSummary> supplierAdvanceIssuingSummaryCollection) {
        this.supplierAdvanceIssuingSummaryCollection = supplierAdvanceIssuingSummaryCollection;
    }

    @XmlTransient
    public Collection<PurchaseMethod> getPurchaseMethodCollection() {
        return purchaseMethodCollection;
    }

    public void setPurchaseMethodCollection(Collection<PurchaseMethod> purchaseMethodCollection) {
        this.purchaseMethodCollection = purchaseMethodCollection;
    }

    @XmlTransient
    public Collection<TeaSupplierPayments> getTeaSupplierPaymentsCollection() {
        return teaSupplierPaymentsCollection;
    }

    public void setTeaSupplierPaymentsCollection(Collection<TeaSupplierPayments> teaSupplierPaymentsCollection) {
        this.teaSupplierPaymentsCollection = teaSupplierPaymentsCollection;
    }

    @XmlTransient
    public Collection<EmployeePaymentDetails> getEmployeePaymentDetailsCollection() {
        return employeePaymentDetailsCollection;
    }

    public void setEmployeePaymentDetailsCollection(Collection<EmployeePaymentDetails> employeePaymentDetailsCollection) {
        this.employeePaymentDetailsCollection = employeePaymentDetailsCollection;
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
        if (!(object instanceof UniversalPaymentMode)) {
            return false;
        }
        UniversalPaymentMode other = (UniversalPaymentMode) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UniversalPaymentMode[ id=" + id + " ]";
    }
    
}
