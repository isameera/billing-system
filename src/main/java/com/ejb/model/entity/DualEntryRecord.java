/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "dual_entry_record")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DualEntryRecord.findAll", query = "SELECT d FROM DualEntryRecord d")
    , @NamedQuery(name = "DualEntryRecord.findById", query = "SELECT d FROM DualEntryRecord d WHERE d.id = :id")
    , @NamedQuery(name = "DualEntryRecord.findByIsActive", query = "SELECT d FROM DualEntryRecord d WHERE d.isActive = :isActive")})
public class DualEntryRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "is_active")
    private Integer isActive;
    @JoinColumn(name = "sub_chart_of_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SubChartOfAccount subChartOfAccountId;
    @JoinColumn(name = "account_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AccountType accountTypeId;
    @JoinColumn(name = "chart_of_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ChartOfAccount chartOfAccountId;
    @JoinColumn(name = "credit_or_debit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CreditOrDebit creditOrDebitId;
    @JoinColumn(name = "dual_entry_action_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DualEntryAction dualEntryActionId;
    @JoinColumn(name = "main_chart_of_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MainChartOfAccount mainChartOfAccountId;

    public DualEntryRecord() {
    }

    public DualEntryRecord(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public SubChartOfAccount getSubChartOfAccountId() {
        return subChartOfAccountId;
    }

    public void setSubChartOfAccountId(SubChartOfAccount subChartOfAccountId) {
        this.subChartOfAccountId = subChartOfAccountId;
    }

    public AccountType getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(AccountType accountTypeId) {
        this.accountTypeId = accountTypeId;
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

    public DualEntryAction getDualEntryActionId() {
        return dualEntryActionId;
    }

    public void setDualEntryActionId(DualEntryAction dualEntryActionId) {
        this.dualEntryActionId = dualEntryActionId;
    }

    public MainChartOfAccount getMainChartOfAccountId() {
        return mainChartOfAccountId;
    }

    public void setMainChartOfAccountId(MainChartOfAccount mainChartOfAccountId) {
        this.mainChartOfAccountId = mainChartOfAccountId;
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
        if (!(object instanceof DualEntryRecord)) {
            return false;
        }
        DualEntryRecord other = (DualEntryRecord) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.DualEntryRecord[ id=" + id + " ]";
    }
    
}
