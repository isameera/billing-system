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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "transaction_management")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionManagement.findAll", query = "SELECT t FROM TransactionManagement t")
    , @NamedQuery(name = "TransactionManagement.findById", query = "SELECT t FROM TransactionManagement t WHERE t.id = :id")
    , @NamedQuery(name = "TransactionManagement.findByTransactionId", query = "SELECT t FROM TransactionManagement t WHERE t.transactionId = :transactionId")
    , @NamedQuery(name = "TransactionManagement.findByDate", query = "SELECT t FROM TransactionManagement t WHERE t.date = :date")
    , @NamedQuery(name = "TransactionManagement.findByStatus", query = "SELECT t FROM TransactionManagement t WHERE t.status = :status")})
public class TransactionManagement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "transaction_id")
    private int transactionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactionManagementId")
    private Collection<CashSettlementHistoryItems> cashSettlementHistoryItemsCollection;
    @JoinColumn(name = "chart_of_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ChartOfAccount chartOfAccountId;
    @JoinColumn(name = "coa_scoa_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CoaScoaManager coaScoaManagerId;
    @JoinColumn(name = "general_journal_entry_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralJournalEntry generalJournalEntryId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "main_chart_of_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MainChartOfAccount mainChartOfAccountId;
    @JoinColumn(name = "sub_chart_of_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SubChartOfAccount subChartOfAccountId;

    public TransactionManagement() {
    }

    public TransactionManagement(Integer id) {
        this.id = id;
    }

    public TransactionManagement(Integer id, int transactionId, Date date, int status) {
        this.id = id;
        this.transactionId = transactionId;
        this.date = date;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public CoaScoaManager getCoaScoaManagerId() {
        return coaScoaManagerId;
    }

    public void setCoaScoaManagerId(CoaScoaManager coaScoaManagerId) {
        this.coaScoaManagerId = coaScoaManagerId;
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

    public MainChartOfAccount getMainChartOfAccountId() {
        return mainChartOfAccountId;
    }

    public void setMainChartOfAccountId(MainChartOfAccount mainChartOfAccountId) {
        this.mainChartOfAccountId = mainChartOfAccountId;
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
        if (!(object instanceof TransactionManagement)) {
            return false;
        }
        TransactionManagement other = (TransactionManagement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.TransactionManagement[ id=" + id + " ]";
    }
    
}
