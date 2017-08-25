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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "general_journal_entry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GeneralJournalEntry.findAll", query = "SELECT g FROM GeneralJournalEntry g")
    , @NamedQuery(name = "GeneralJournalEntry.findById", query = "SELECT g FROM GeneralJournalEntry g WHERE g.id = :id")
    , @NamedQuery(name = "GeneralJournalEntry.findByDescription", query = "SELECT g FROM GeneralJournalEntry g WHERE g.description = :description")
    , @NamedQuery(name = "GeneralJournalEntry.findByCredit", query = "SELECT g FROM GeneralJournalEntry g WHERE g.credit = :credit")
    , @NamedQuery(name = "GeneralJournalEntry.findByDebit", query = "SELECT g FROM GeneralJournalEntry g WHERE g.debit = :debit")
    , @NamedQuery(name = "GeneralJournalEntry.findByAmount", query = "SELECT g FROM GeneralJournalEntry g WHERE g.amount = :amount")
    , @NamedQuery(name = "GeneralJournalEntry.findByDate", query = "SELECT g FROM GeneralJournalEntry g WHERE g.date = :date")
    , @NamedQuery(name = "GeneralJournalEntry.findByIsActive", query = "SELECT g FROM GeneralJournalEntry g WHERE g.isActive = :isActive")
    , @NamedQuery(name = "GeneralJournalEntry.findByChequeno", query = "SELECT g FROM GeneralJournalEntry g WHERE g.chequeno = :chequeno")})
public class GeneralJournalEntry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "credit")
    private double credit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "debit")
    private double debit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private double amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private int isActive;
    @Size(max = 45)
    @Column(name = "chequeno")
    private String chequeno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalJournalEntryId")
    private Collection<GjeVoucherManager> gjeVoucherManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalJournalEntryId")
    private Collection<GjeVoucherItem> gjeVoucherItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalJournalEntryId")
    private Collection<OpeningBalances> openingBalancesCollection;
    @JoinColumn(name = "chart_of_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ChartOfAccount chartOfAccountId;
    @JoinColumn(name = "credit_or_debit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CreditOrDebit creditOrDebitId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "login_session_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LoginSession loginSessionId;
    @JoinColumn(name = "sub_chart_of_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SubChartOfAccount subChartOfAccountId;
    @JoinColumn(name = "universal_payment_mode_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalPaymentMode universalPaymentModeId;
    @JoinColumn(name = "user_login_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserLogin userLoginId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalJournalEntryId")
    private Collection<GjeScoaManager> gjeScoaManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalJournalEntryId")
    private Collection<CashSettlementHistory> cashSettlementHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalJournalEntryId")
    private Collection<GeneralJournalEntryReceivedCheques> generalJournalEntryReceivedChequesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalJournalEntryId")
    private Collection<ChequeDeposit> chequeDepositCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalJournalEntryId")
    private Collection<TransactionManagement> transactionManagementCollection;

    public GeneralJournalEntry() {
    }

    public GeneralJournalEntry(Integer id) {
        this.id = id;
    }

    public GeneralJournalEntry(Integer id, double credit, double debit, double amount, Date date, int isActive) {
        this.id = id;
        this.credit = credit;
        this.debit = debit;
        this.amount = amount;
        this.date = date;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getChequeno() {
        return chequeno;
    }

    public void setChequeno(String chequeno) {
        this.chequeno = chequeno;
    }

    @XmlTransient
    public Collection<GjeVoucherManager> getGjeVoucherManagerCollection() {
        return gjeVoucherManagerCollection;
    }

    public void setGjeVoucherManagerCollection(Collection<GjeVoucherManager> gjeVoucherManagerCollection) {
        this.gjeVoucherManagerCollection = gjeVoucherManagerCollection;
    }

    @XmlTransient
    public Collection<GjeVoucherItem> getGjeVoucherItemCollection() {
        return gjeVoucherItemCollection;
    }

    public void setGjeVoucherItemCollection(Collection<GjeVoucherItem> gjeVoucherItemCollection) {
        this.gjeVoucherItemCollection = gjeVoucherItemCollection;
    }

    @XmlTransient
    public Collection<OpeningBalances> getOpeningBalancesCollection() {
        return openingBalancesCollection;
    }

    public void setOpeningBalancesCollection(Collection<OpeningBalances> openingBalancesCollection) {
        this.openingBalancesCollection = openingBalancesCollection;
    }

    public ChartOfAccount getChartOfAccountId() {
        return chartOfAccountId;
    }

    public void setChartOfAccountId(ChartOfAccount chartOfAccountId) {
        this.chartOfAccountId = chartOfAccountId;
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

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
    }

    public LoginSession getLoginSessionId() {
        return loginSessionId;
    }

    public void setLoginSessionId(LoginSession loginSessionId) {
        this.loginSessionId = loginSessionId;
    }

    public SubChartOfAccount getSubChartOfAccountId() {
        return subChartOfAccountId;
    }

    public void setSubChartOfAccountId(SubChartOfAccount subChartOfAccountId) {
        this.subChartOfAccountId = subChartOfAccountId;
    }

    public UniversalPaymentMode getUniversalPaymentModeId() {
        return universalPaymentModeId;
    }

    public void setUniversalPaymentModeId(UniversalPaymentMode universalPaymentModeId) {
        this.universalPaymentModeId = universalPaymentModeId;
    }

    public UserLogin getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(UserLogin userLoginId) {
        this.userLoginId = userLoginId;
    }

    @XmlTransient
    public Collection<GjeScoaManager> getGjeScoaManagerCollection() {
        return gjeScoaManagerCollection;
    }

    public void setGjeScoaManagerCollection(Collection<GjeScoaManager> gjeScoaManagerCollection) {
        this.gjeScoaManagerCollection = gjeScoaManagerCollection;
    }

    @XmlTransient
    public Collection<CashSettlementHistory> getCashSettlementHistoryCollection() {
        return cashSettlementHistoryCollection;
    }

    public void setCashSettlementHistoryCollection(Collection<CashSettlementHistory> cashSettlementHistoryCollection) {
        this.cashSettlementHistoryCollection = cashSettlementHistoryCollection;
    }

    @XmlTransient
    public Collection<GeneralJournalEntryReceivedCheques> getGeneralJournalEntryReceivedChequesCollection() {
        return generalJournalEntryReceivedChequesCollection;
    }

    public void setGeneralJournalEntryReceivedChequesCollection(Collection<GeneralJournalEntryReceivedCheques> generalJournalEntryReceivedChequesCollection) {
        this.generalJournalEntryReceivedChequesCollection = generalJournalEntryReceivedChequesCollection;
    }

    @XmlTransient
    public Collection<ChequeDeposit> getChequeDepositCollection() {
        return chequeDepositCollection;
    }

    public void setChequeDepositCollection(Collection<ChequeDeposit> chequeDepositCollection) {
        this.chequeDepositCollection = chequeDepositCollection;
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
        if (!(object instanceof GeneralJournalEntry)) {
            return false;
        }
        GeneralJournalEntry other = (GeneralJournalEntry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.GeneralJournalEntry[ id=" + id + " ]";
    }
    
}
