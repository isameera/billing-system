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
@Table(name = "bank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bank.findAll", query = "SELECT b FROM Bank b")
    , @NamedQuery(name = "Bank.findById", query = "SELECT b FROM Bank b WHERE b.id = :id")
    , @NamedQuery(name = "Bank.findByName", query = "SELECT b FROM Bank b WHERE b.name = :name")
    , @NamedQuery(name = "Bank.findByCode", query = "SELECT b FROM Bank b WHERE b.code = :code")})
public class Bank implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "code")
    private String code;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankId")
    private Collection<BankAccount> bankAccountCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankId")
    private Collection<ChequeDetails> chequeDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankId")
    private Collection<DailyBankBalance> dailyBankBalanceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankId")
    private Collection<OrgBankAccount> orgBankAccountCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankId")
    private Collection<ReceivedCheques> receivedChequesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankId")
    private Collection<BrancheOfTheBank> brancheOfTheBankCollection;

    public Bank() {
    }

    public Bank(Integer id) {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlTransient
    public Collection<BankAccount> getBankAccountCollection() {
        return bankAccountCollection;
    }

    public void setBankAccountCollection(Collection<BankAccount> bankAccountCollection) {
        this.bankAccountCollection = bankAccountCollection;
    }

    @XmlTransient
    public Collection<ChequeDetails> getChequeDetailsCollection() {
        return chequeDetailsCollection;
    }

    public void setChequeDetailsCollection(Collection<ChequeDetails> chequeDetailsCollection) {
        this.chequeDetailsCollection = chequeDetailsCollection;
    }

    @XmlTransient
    public Collection<DailyBankBalance> getDailyBankBalanceCollection() {
        return dailyBankBalanceCollection;
    }

    public void setDailyBankBalanceCollection(Collection<DailyBankBalance> dailyBankBalanceCollection) {
        this.dailyBankBalanceCollection = dailyBankBalanceCollection;
    }

    @XmlTransient
    public Collection<OrgBankAccount> getOrgBankAccountCollection() {
        return orgBankAccountCollection;
    }

    public void setOrgBankAccountCollection(Collection<OrgBankAccount> orgBankAccountCollection) {
        this.orgBankAccountCollection = orgBankAccountCollection;
    }

    @XmlTransient
    public Collection<ReceivedCheques> getReceivedChequesCollection() {
        return receivedChequesCollection;
    }

    public void setReceivedChequesCollection(Collection<ReceivedCheques> receivedChequesCollection) {
        this.receivedChequesCollection = receivedChequesCollection;
    }

    @XmlTransient
    public Collection<BrancheOfTheBank> getBrancheOfTheBankCollection() {
        return brancheOfTheBankCollection;
    }

    public void setBrancheOfTheBankCollection(Collection<BrancheOfTheBank> brancheOfTheBankCollection) {
        this.brancheOfTheBankCollection = brancheOfTheBankCollection;
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
        if (!(object instanceof Bank)) {
            return false;
        }
        Bank other = (Bank) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.Bank[ id=" + id + " ]";
    }
    
}
