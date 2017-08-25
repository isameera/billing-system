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
@Table(name = "universal_org_person_financial_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniversalOrgPersonFinancialHistory.findAll", query = "SELECT u FROM UniversalOrgPersonFinancialHistory u")
    , @NamedQuery(name = "UniversalOrgPersonFinancialHistory.findById", query = "SELECT u FROM UniversalOrgPersonFinancialHistory u WHERE u.id = :id")
    , @NamedQuery(name = "UniversalOrgPersonFinancialHistory.findByReference", query = "SELECT u FROM UniversalOrgPersonFinancialHistory u WHERE u.reference = :reference")
    , @NamedQuery(name = "UniversalOrgPersonFinancialHistory.findByAmount", query = "SELECT u FROM UniversalOrgPersonFinancialHistory u WHERE u.amount = :amount")
    , @NamedQuery(name = "UniversalOrgPersonFinancialHistory.findByDate", query = "SELECT u FROM UniversalOrgPersonFinancialHistory u WHERE u.date = :date")
    , @NamedQuery(name = "UniversalOrgPersonFinancialHistory.findByTime", query = "SELECT u FROM UniversalOrgPersonFinancialHistory u WHERE u.time = :time")})
public class UniversalOrgPersonFinancialHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "reference")
    private Integer reference;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalOrgPersonFinancialHistoryId")
    private Collection<UniversalOrgPersonFinancialHistoryBankAccount> universalOrgPersonFinancialHistoryBankAccountCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalOrgPersonFinancialHistoryId")
    private Collection<UniversalOrgPersonFinancialHistoryCheque> universalOrgPersonFinancialHistoryChequeCollection;
    @JoinColumn(name = "credit_or_debit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CreditOrDebit creditOrDebitId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "universal_org_person_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalOrgPersonCategory universalOrgPersonCategoryId;
    @JoinColumn(name = "universal_payment_mode_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalPaymentMode universalPaymentModeId;
    @JoinColumn(name = "universal_person_or_org_type_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId;
    @JoinColumn(name = "voucher_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VoucherType voucherTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalOrgPersonFinancialHistoryId")
    private Collection<UniversalOrgPersonFinancialHistoryVoucher> universalOrgPersonFinancialHistoryVoucherCollection;

    public UniversalOrgPersonFinancialHistory() {
    }

    public UniversalOrgPersonFinancialHistory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @XmlTransient
    public Collection<UniversalOrgPersonFinancialHistoryBankAccount> getUniversalOrgPersonFinancialHistoryBankAccountCollection() {
        return universalOrgPersonFinancialHistoryBankAccountCollection;
    }

    public void setUniversalOrgPersonFinancialHistoryBankAccountCollection(Collection<UniversalOrgPersonFinancialHistoryBankAccount> universalOrgPersonFinancialHistoryBankAccountCollection) {
        this.universalOrgPersonFinancialHistoryBankAccountCollection = universalOrgPersonFinancialHistoryBankAccountCollection;
    }

    @XmlTransient
    public Collection<UniversalOrgPersonFinancialHistoryCheque> getUniversalOrgPersonFinancialHistoryChequeCollection() {
        return universalOrgPersonFinancialHistoryChequeCollection;
    }

    public void setUniversalOrgPersonFinancialHistoryChequeCollection(Collection<UniversalOrgPersonFinancialHistoryCheque> universalOrgPersonFinancialHistoryChequeCollection) {
        this.universalOrgPersonFinancialHistoryChequeCollection = universalOrgPersonFinancialHistoryChequeCollection;
    }

    public CreditOrDebit getCreditOrDebitId() {
        return creditOrDebitId;
    }

    public void setCreditOrDebitId(CreditOrDebit creditOrDebitId) {
        this.creditOrDebitId = creditOrDebitId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public UniversalOrgPersonCategory getUniversalOrgPersonCategoryId() {
        return universalOrgPersonCategoryId;
    }

    public void setUniversalOrgPersonCategoryId(UniversalOrgPersonCategory universalOrgPersonCategoryId) {
        this.universalOrgPersonCategoryId = universalOrgPersonCategoryId;
    }

    public UniversalPaymentMode getUniversalPaymentModeId() {
        return universalPaymentModeId;
    }

    public void setUniversalPaymentModeId(UniversalPaymentMode universalPaymentModeId) {
        this.universalPaymentModeId = universalPaymentModeId;
    }

    public UniversalPersonOrOrgTypeManager getUniversalPersonOrOrgTypeManagerId() {
        return universalPersonOrOrgTypeManagerId;
    }

    public void setUniversalPersonOrOrgTypeManagerId(UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId) {
        this.universalPersonOrOrgTypeManagerId = universalPersonOrOrgTypeManagerId;
    }

    public VoucherType getVoucherTypeId() {
        return voucherTypeId;
    }

    public void setVoucherTypeId(VoucherType voucherTypeId) {
        this.voucherTypeId = voucherTypeId;
    }

    @XmlTransient
    public Collection<UniversalOrgPersonFinancialHistoryVoucher> getUniversalOrgPersonFinancialHistoryVoucherCollection() {
        return universalOrgPersonFinancialHistoryVoucherCollection;
    }

    public void setUniversalOrgPersonFinancialHistoryVoucherCollection(Collection<UniversalOrgPersonFinancialHistoryVoucher> universalOrgPersonFinancialHistoryVoucherCollection) {
        this.universalOrgPersonFinancialHistoryVoucherCollection = universalOrgPersonFinancialHistoryVoucherCollection;
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
        if (!(object instanceof UniversalOrgPersonFinancialHistory)) {
            return false;
        }
        UniversalOrgPersonFinancialHistory other = (UniversalOrgPersonFinancialHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UniversalOrgPersonFinancialHistory[ id=" + id + " ]";
    }
    
}
