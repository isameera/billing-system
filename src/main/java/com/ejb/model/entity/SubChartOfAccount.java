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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "sub_chart_of_account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubChartOfAccount.findAll", query = "SELECT s FROM SubChartOfAccount s")
    , @NamedQuery(name = "SubChartOfAccount.findById", query = "SELECT s FROM SubChartOfAccount s WHERE s.id = :id")
    , @NamedQuery(name = "SubChartOfAccount.findByStatus", query = "SELECT s FROM SubChartOfAccount s WHERE s.status = :status")
    , @NamedQuery(name = "SubChartOfAccount.findByBalance", query = "SELECT s FROM SubChartOfAccount s WHERE s.balance = :balance")})
public class SubChartOfAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "reference")
    private String reference;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "status")
    private String status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "balance")
    private Double balance;
    @OneToMany(mappedBy = "subChartOfAccountisSca")
    private Collection<BankAccount> bankAccountCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subChartOfAccountId")
    private Collection<RecurantExpenses> recurantExpensesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subChartOfAccountId")
    private Collection<SubChartOfAccountCop> subChartOfAccountCopCollection;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "scoa_type_id", referencedColumnName = "id")
    @ManyToOne
    private ScoaType scoaTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subChartOfAccountId")
    private Collection<GeneralJournalEntry> generalJournalEntryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subChartOfAccountId")
    private Collection<CoaScoaManager> coaScoaManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subChartOfAccountId")
    private Collection<SupplierAdvanceIssuingSummary> supplierAdvanceIssuingSummaryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subChartOfAccountId")
    private Collection<SubCartOfAccountPaymentHistory> subCartOfAccountPaymentHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subChartOfAccountId")
    private Collection<GjeScoaManager> gjeScoaManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subChartOfAccountId")
    private Collection<JournalEntryReport> journalEntryReportCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subChartOfAccountId")
    private Collection<CashSettlementHistory> cashSettlementHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subChartOfAccountId")
    private Collection<DualEntryRecord> dualEntryRecordCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subChartOfAccountId")
    private Collection<VoucherItem> voucherItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subChartOfAccountId")
    private Collection<Course> courseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subChartOfAccountId")
    private Collection<SubChartOfAccountLevelManager> subChartOfAccountLevelManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subChartOfAccountId1")
    private Collection<SubChartOfAccountLevelManager> subChartOfAccountLevelManagerCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subChartOfAccountId")
    private Collection<TransactionManagement> transactionManagementCollection;

    public SubChartOfAccount() {
    }

    public SubChartOfAccount(Integer id) {
        this.id = id;
    }

    public SubChartOfAccount(Integer id, String reference, String name, String status) {
        this.id = id;
        this.reference = reference;
        this.name = name;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @XmlTransient
    public Collection<BankAccount> getBankAccountCollection() {
        return bankAccountCollection;
    }

    public void setBankAccountCollection(Collection<BankAccount> bankAccountCollection) {
        this.bankAccountCollection = bankAccountCollection;
    }

    @XmlTransient
    public Collection<RecurantExpenses> getRecurantExpensesCollection() {
        return recurantExpensesCollection;
    }

    public void setRecurantExpensesCollection(Collection<RecurantExpenses> recurantExpensesCollection) {
        this.recurantExpensesCollection = recurantExpensesCollection;
    }

    @XmlTransient
    public Collection<SubChartOfAccountCop> getSubChartOfAccountCopCollection() {
        return subChartOfAccountCopCollection;
    }

    public void setSubChartOfAccountCopCollection(Collection<SubChartOfAccountCop> subChartOfAccountCopCollection) {
        this.subChartOfAccountCopCollection = subChartOfAccountCopCollection;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public ScoaType getScoaTypeId() {
        return scoaTypeId;
    }

    public void setScoaTypeId(ScoaType scoaTypeId) {
        this.scoaTypeId = scoaTypeId;
    }

    @XmlTransient
    public Collection<GeneralJournalEntry> getGeneralJournalEntryCollection() {
        return generalJournalEntryCollection;
    }

    public void setGeneralJournalEntryCollection(Collection<GeneralJournalEntry> generalJournalEntryCollection) {
        this.generalJournalEntryCollection = generalJournalEntryCollection;
    }

    @XmlTransient
    public Collection<CoaScoaManager> getCoaScoaManagerCollection() {
        return coaScoaManagerCollection;
    }

    public void setCoaScoaManagerCollection(Collection<CoaScoaManager> coaScoaManagerCollection) {
        this.coaScoaManagerCollection = coaScoaManagerCollection;
    }

    @XmlTransient
    public Collection<SupplierAdvanceIssuingSummary> getSupplierAdvanceIssuingSummaryCollection() {
        return supplierAdvanceIssuingSummaryCollection;
    }

    public void setSupplierAdvanceIssuingSummaryCollection(Collection<SupplierAdvanceIssuingSummary> supplierAdvanceIssuingSummaryCollection) {
        this.supplierAdvanceIssuingSummaryCollection = supplierAdvanceIssuingSummaryCollection;
    }

    @XmlTransient
    public Collection<SubCartOfAccountPaymentHistory> getSubCartOfAccountPaymentHistoryCollection() {
        return subCartOfAccountPaymentHistoryCollection;
    }

    public void setSubCartOfAccountPaymentHistoryCollection(Collection<SubCartOfAccountPaymentHistory> subCartOfAccountPaymentHistoryCollection) {
        this.subCartOfAccountPaymentHistoryCollection = subCartOfAccountPaymentHistoryCollection;
    }

    @XmlTransient
    public Collection<GjeScoaManager> getGjeScoaManagerCollection() {
        return gjeScoaManagerCollection;
    }

    public void setGjeScoaManagerCollection(Collection<GjeScoaManager> gjeScoaManagerCollection) {
        this.gjeScoaManagerCollection = gjeScoaManagerCollection;
    }

    @XmlTransient
    public Collection<JournalEntryReport> getJournalEntryReportCollection() {
        return journalEntryReportCollection;
    }

    public void setJournalEntryReportCollection(Collection<JournalEntryReport> journalEntryReportCollection) {
        this.journalEntryReportCollection = journalEntryReportCollection;
    }

    @XmlTransient
    public Collection<CashSettlementHistory> getCashSettlementHistoryCollection() {
        return cashSettlementHistoryCollection;
    }

    public void setCashSettlementHistoryCollection(Collection<CashSettlementHistory> cashSettlementHistoryCollection) {
        this.cashSettlementHistoryCollection = cashSettlementHistoryCollection;
    }

    @XmlTransient
    public Collection<DualEntryRecord> getDualEntryRecordCollection() {
        return dualEntryRecordCollection;
    }

    public void setDualEntryRecordCollection(Collection<DualEntryRecord> dualEntryRecordCollection) {
        this.dualEntryRecordCollection = dualEntryRecordCollection;
    }

    @XmlTransient
    public Collection<VoucherItem> getVoucherItemCollection() {
        return voucherItemCollection;
    }

    public void setVoucherItemCollection(Collection<VoucherItem> voucherItemCollection) {
        this.voucherItemCollection = voucherItemCollection;
    }

    @XmlTransient
    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    @XmlTransient
    public Collection<SubChartOfAccountLevelManager> getSubChartOfAccountLevelManagerCollection() {
        return subChartOfAccountLevelManagerCollection;
    }

    public void setSubChartOfAccountLevelManagerCollection(Collection<SubChartOfAccountLevelManager> subChartOfAccountLevelManagerCollection) {
        this.subChartOfAccountLevelManagerCollection = subChartOfAccountLevelManagerCollection;
    }

    @XmlTransient
    public Collection<SubChartOfAccountLevelManager> getSubChartOfAccountLevelManagerCollection1() {
        return subChartOfAccountLevelManagerCollection1;
    }

    public void setSubChartOfAccountLevelManagerCollection1(Collection<SubChartOfAccountLevelManager> subChartOfAccountLevelManagerCollection1) {
        this.subChartOfAccountLevelManagerCollection1 = subChartOfAccountLevelManagerCollection1;
    }

    @XmlTransient
    public Collection<TransactionManagement> getTransactionManagementCollection() {
        return transactionManagementCollection;
    }

    public void setTransactionManagementCollection(Collection<TransactionManagement> transactionManagementCollection) {
        this.transactionManagementCollection = transactionManagementCollection;
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
        if (!(object instanceof SubChartOfAccount)) {
            return false;
        }
        SubChartOfAccount other = (SubChartOfAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SubChartOfAccount[ id=" + id + " ]";
    }
    
}
