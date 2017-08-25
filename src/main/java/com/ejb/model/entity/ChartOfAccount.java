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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "chart_of_account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChartOfAccount.findAll", query = "SELECT c FROM ChartOfAccount c")
    , @NamedQuery(name = "ChartOfAccount.findById", query = "SELECT c FROM ChartOfAccount c WHERE c.id = :id")
    , @NamedQuery(name = "ChartOfAccount.findByName", query = "SELECT c FROM ChartOfAccount c WHERE c.name = :name")
    , @NamedQuery(name = "ChartOfAccount.findByIsActive", query = "SELECT c FROM ChartOfAccount c WHERE c.isActive = :isActive")})
public class ChartOfAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private int isActive;
    @JoinColumn(name = "main_chart_of_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MainChartOfAccount mainChartOfAccountId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chartOfAccountId")
    private Collection<RecurantExpenses> recurantExpensesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chartOfAccountId")
    private Collection<GeneralJournalEntry> generalJournalEntryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chartOfAccountId")
    private Collection<CoaScoaManager> coaScoaManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chartOfAccountId")
    private Collection<PersonCoaManager> personCoaManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chartOfAccountId")
    private Collection<CoaAccountCategory> coaAccountCategoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chartOfAccountId")
    private Collection<JournalEntryReport> journalEntryReportCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chartOfAccountId")
    private Collection<GopCoaManager> gopCoaManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chartOfAccountId")
    private Collection<OrgCoaManager> orgCoaManagerCollection;
    @OneToMany(mappedBy = "chartOfAccountId")
    private Collection<CashSettlementHistory> cashSettlementHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chartOfAccountId")
    private Collection<DualEntryRecord> dualEntryRecordCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chartOfAccountId")
    private Collection<OrgChartOfAccount> orgChartOfAccountCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chartOfAccountId")
    private Collection<TransactionManagement> transactionManagementCollection;

    public ChartOfAccount() {
    }

    public ChartOfAccount(Integer id) {
        this.id = id;
    }

    public ChartOfAccount(Integer id, String name, int isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
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

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public MainChartOfAccount getMainChartOfAccountId() {
        return mainChartOfAccountId;
    }

    public void setMainChartOfAccountId(MainChartOfAccount mainChartOfAccountId) {
        this.mainChartOfAccountId = mainChartOfAccountId;
    }

    @XmlTransient
    public Collection<RecurantExpenses> getRecurantExpensesCollection() {
        return recurantExpensesCollection;
    }

    public void setRecurantExpensesCollection(Collection<RecurantExpenses> recurantExpensesCollection) {
        this.recurantExpensesCollection = recurantExpensesCollection;
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
    public Collection<PersonCoaManager> getPersonCoaManagerCollection() {
        return personCoaManagerCollection;
    }

    public void setPersonCoaManagerCollection(Collection<PersonCoaManager> personCoaManagerCollection) {
        this.personCoaManagerCollection = personCoaManagerCollection;
    }

    @XmlTransient
    public Collection<CoaAccountCategory> getCoaAccountCategoryCollection() {
        return coaAccountCategoryCollection;
    }

    public void setCoaAccountCategoryCollection(Collection<CoaAccountCategory> coaAccountCategoryCollection) {
        this.coaAccountCategoryCollection = coaAccountCategoryCollection;
    }

    @XmlTransient
    public Collection<JournalEntryReport> getJournalEntryReportCollection() {
        return journalEntryReportCollection;
    }

    public void setJournalEntryReportCollection(Collection<JournalEntryReport> journalEntryReportCollection) {
        this.journalEntryReportCollection = journalEntryReportCollection;
    }

    @XmlTransient
    public Collection<GopCoaManager> getGopCoaManagerCollection() {
        return gopCoaManagerCollection;
    }

    public void setGopCoaManagerCollection(Collection<GopCoaManager> gopCoaManagerCollection) {
        this.gopCoaManagerCollection = gopCoaManagerCollection;
    }

    @XmlTransient
    public Collection<OrgCoaManager> getOrgCoaManagerCollection() {
        return orgCoaManagerCollection;
    }

    public void setOrgCoaManagerCollection(Collection<OrgCoaManager> orgCoaManagerCollection) {
        this.orgCoaManagerCollection = orgCoaManagerCollection;
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
    public Collection<OrgChartOfAccount> getOrgChartOfAccountCollection() {
        return orgChartOfAccountCollection;
    }

    public void setOrgChartOfAccountCollection(Collection<OrgChartOfAccount> orgChartOfAccountCollection) {
        this.orgChartOfAccountCollection = orgChartOfAccountCollection;
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
        if (!(object instanceof ChartOfAccount)) {
            return false;
        }
        ChartOfAccount other = (ChartOfAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ChartOfAccount[ id=" + id + " ]";
    }
    
}
