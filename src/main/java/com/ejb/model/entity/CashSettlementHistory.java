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
@Table(name = "cash_settlement_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CashSettlementHistory.findAll", query = "SELECT c FROM CashSettlementHistory c")
    , @NamedQuery(name = "CashSettlementHistory.findById", query = "SELECT c FROM CashSettlementHistory c WHERE c.id = :id")
    , @NamedQuery(name = "CashSettlementHistory.findBySettlementId", query = "SELECT c FROM CashSettlementHistory c WHERE c.settlementId = :settlementId")
    , @NamedQuery(name = "CashSettlementHistory.findByDate", query = "SELECT c FROM CashSettlementHistory c WHERE c.date = :date")
    , @NamedQuery(name = "CashSettlementHistory.findByBalance", query = "SELECT c FROM CashSettlementHistory c WHERE c.balance = :balance")})
public class CashSettlementHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "settlement_id")
    private Integer settlementId;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "balance")
    private Double balance;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cashSettlementHistoryId")
    private Collection<CashSettlementHistoryItems> cashSettlementHistoryItemsCollection;
    @JoinColumn(name = "chart_of_account_id", referencedColumnName = "id")
    @ManyToOne
    private ChartOfAccount chartOfAccountId;
    @JoinColumn(name = "general_journal_entry_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralJournalEntry generalJournalEntryId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "general_user_profile_id1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId1;
    @JoinColumn(name = "sub_chart_of_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SubChartOfAccount subChartOfAccountId;

    public CashSettlementHistory() {
    }

    public CashSettlementHistory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(Integer settlementId) {
        this.settlementId = settlementId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @XmlTransient
    public Collection<CashSettlementHistoryItems> getCashSettlementHistoryItemsCollection() {
        return cashSettlementHistoryItemsCollection;
    }

    public void setCashSettlementHistoryItemsCollection(Collection<CashSettlementHistoryItems> cashSettlementHistoryItemsCollection) {
        this.cashSettlementHistoryItemsCollection = cashSettlementHistoryItemsCollection;
    }

    public ChartOfAccount getChartOfAccountId() {
        return chartOfAccountId;
    }

    public void setChartOfAccountId(ChartOfAccount chartOfAccountId) {
        this.chartOfAccountId = chartOfAccountId;
    }

    public GeneralJournalEntry getGeneralJournalEntryId() {
        return generalJournalEntryId;
    }

    public void setGeneralJournalEntryId(GeneralJournalEntry generalJournalEntryId) {
        this.generalJournalEntryId = generalJournalEntryId;
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

    public GeneralUserProfile getGeneralUserProfileId1() {
        return generalUserProfileId1;
    }

    public void setGeneralUserProfileId1(GeneralUserProfile generalUserProfileId1) {
        this.generalUserProfileId1 = generalUserProfileId1;
    }

    public SubChartOfAccount getSubChartOfAccountId() {
        return subChartOfAccountId;
    }

    public void setSubChartOfAccountId(SubChartOfAccount subChartOfAccountId) {
        this.subChartOfAccountId = subChartOfAccountId;
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
        if (!(object instanceof CashSettlementHistory)) {
            return false;
        }
        CashSettlementHistory other = (CashSettlementHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.CashSettlementHistory[ id=" + id + " ]";
    }
    
}
