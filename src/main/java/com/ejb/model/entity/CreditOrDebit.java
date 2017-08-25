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
@Table(name = "credit_or_debit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CreditOrDebit.findAll", query = "SELECT c FROM CreditOrDebit c")
    , @NamedQuery(name = "CreditOrDebit.findById", query = "SELECT c FROM CreditOrDebit c WHERE c.id = :id")
    , @NamedQuery(name = "CreditOrDebit.findByName", query = "SELECT c FROM CreditOrDebit c WHERE c.name = :name")})
public class CreditOrDebit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creditOrDebitId")
    private Collection<UniversalOrgPersonFinancialHistory> universalOrgPersonFinancialHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creditOrDebitId")
    private Collection<GeneralJournalEntry> generalJournalEntryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creditOrDebitId")
    private Collection<DualEntryRecord> dualEntryRecordCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creditOrDebitId")
    private Collection<BankCustomerTransactionHistory> bankCustomerTransactionHistoryCollection;

    public CreditOrDebit() {
    }

    public CreditOrDebit(Integer id) {
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
    public Collection<DualEntryRecord> getDualEntryRecordCollection() {
        return dualEntryRecordCollection;
    }

    public void setDualEntryRecordCollection(Collection<DualEntryRecord> dualEntryRecordCollection) {
        this.dualEntryRecordCollection = dualEntryRecordCollection;
    }

    @XmlTransient
    public Collection<BankCustomerTransactionHistory> getBankCustomerTransactionHistoryCollection() {
        return bankCustomerTransactionHistoryCollection;
    }

    public void setBankCustomerTransactionHistoryCollection(Collection<BankCustomerTransactionHistory> bankCustomerTransactionHistoryCollection) {
        this.bankCustomerTransactionHistoryCollection = bankCustomerTransactionHistoryCollection;
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
        if (!(object instanceof CreditOrDebit)) {
            return false;
        }
        CreditOrDebit other = (CreditOrDebit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.CreditOrDebit[ id=" + id + " ]";
    }
    
}
