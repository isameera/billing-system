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
@Table(name = "main_chart_of_account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MainChartOfAccount.findAll", query = "SELECT m FROM MainChartOfAccount m")
    , @NamedQuery(name = "MainChartOfAccount.findById", query = "SELECT m FROM MainChartOfAccount m WHERE m.id = :id")
    , @NamedQuery(name = "MainChartOfAccount.findByName", query = "SELECT m FROM MainChartOfAccount m WHERE m.name = :name")
    , @NamedQuery(name = "MainChartOfAccount.findByAccountStatus", query = "SELECT m FROM MainChartOfAccount m WHERE m.accountStatus = :accountStatus")})
public class MainChartOfAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "account_status")
    private Integer accountStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mainChartOfAccountId")
    private Collection<ChartOfAccount> chartOfAccountCollection;
    @JoinColumn(name = "account_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AccountType accountTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mainChartOfAccountId")
    private Collection<OrgMainChartOfAccount> orgMainChartOfAccountCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mainChartOfAccountId")
    private Collection<JournalEntryReport> journalEntryReportCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mainChartOfAccountId")
    private Collection<DualEntryRecord> dualEntryRecordCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mainChartOfAccountId")
    private Collection<TransactionManagement> transactionManagementCollection;

    public MainChartOfAccount() {
    }

    public MainChartOfAccount(Integer id) {
        this.id = id;
    }

    public MainChartOfAccount(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public Integer getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    @XmlTransient
    public Collection<ChartOfAccount> getChartOfAccountCollection() {
        return chartOfAccountCollection;
    }

    public void setChartOfAccountCollection(Collection<ChartOfAccount> chartOfAccountCollection) {
        this.chartOfAccountCollection = chartOfAccountCollection;
    }

    public AccountType getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(AccountType accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @XmlTransient
    public Collection<OrgMainChartOfAccount> getOrgMainChartOfAccountCollection() {
        return orgMainChartOfAccountCollection;
    }

    public void setOrgMainChartOfAccountCollection(Collection<OrgMainChartOfAccount> orgMainChartOfAccountCollection) {
        this.orgMainChartOfAccountCollection = orgMainChartOfAccountCollection;
    }

    @XmlTransient
    public Collection<JournalEntryReport> getJournalEntryReportCollection() {
        return journalEntryReportCollection;
    }

    public void setJournalEntryReportCollection(Collection<JournalEntryReport> journalEntryReportCollection) {
        this.journalEntryReportCollection = journalEntryReportCollection;
    }

    @XmlTransient
    public Collection<DualEntryRecord> getDualEntryRecordCollection() {
        return dualEntryRecordCollection;
    }

    public void setDualEntryRecordCollection(Collection<DualEntryRecord> dualEntryRecordCollection) {
        this.dualEntryRecordCollection = dualEntryRecordCollection;
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
        if (!(object instanceof MainChartOfAccount)) {
            return false;
        }
        MainChartOfAccount other = (MainChartOfAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.MainChartOfAccount[ id=" + id + " ]";
    }
    
}
