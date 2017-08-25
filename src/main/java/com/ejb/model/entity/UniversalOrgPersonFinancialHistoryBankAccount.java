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
@Table(name = "universal_org_person_financial_history_bank_account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniversalOrgPersonFinancialHistoryBankAccount.findAll", query = "SELECT u FROM UniversalOrgPersonFinancialHistoryBankAccount u")
    , @NamedQuery(name = "UniversalOrgPersonFinancialHistoryBankAccount.findById", query = "SELECT u FROM UniversalOrgPersonFinancialHistoryBankAccount u WHERE u.id = :id")})
public class UniversalOrgPersonFinancialHistoryBankAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "bank_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BankAccount bankAccountId;
    @JoinColumn(name = "universal_org_person_financial_history_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalOrgPersonFinancialHistory universalOrgPersonFinancialHistoryId;

    public UniversalOrgPersonFinancialHistoryBankAccount() {
    }

    public UniversalOrgPersonFinancialHistoryBankAccount(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BankAccount getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(BankAccount bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public UniversalOrgPersonFinancialHistory getUniversalOrgPersonFinancialHistoryId() {
        return universalOrgPersonFinancialHistoryId;
    }

    public void setUniversalOrgPersonFinancialHistoryId(UniversalOrgPersonFinancialHistory universalOrgPersonFinancialHistoryId) {
        this.universalOrgPersonFinancialHistoryId = universalOrgPersonFinancialHistoryId;
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
        if (!(object instanceof UniversalOrgPersonFinancialHistoryBankAccount)) {
            return false;
        }
        UniversalOrgPersonFinancialHistoryBankAccount other = (UniversalOrgPersonFinancialHistoryBankAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UniversalOrgPersonFinancialHistoryBankAccount[ id=" + id + " ]";
    }
    
}
