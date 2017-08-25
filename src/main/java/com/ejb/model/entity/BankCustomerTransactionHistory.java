/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "bank_customer_transaction_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BankCustomerTransactionHistory.findAll", query = "SELECT b FROM BankCustomerTransactionHistory b")
    , @NamedQuery(name = "BankCustomerTransactionHistory.findById", query = "SELECT b FROM BankCustomerTransactionHistory b WHERE b.id = :id")
    , @NamedQuery(name = "BankCustomerTransactionHistory.findByDate", query = "SELECT b FROM BankCustomerTransactionHistory b WHERE b.date = :date")
    , @NamedQuery(name = "BankCustomerTransactionHistory.findByAmount", query = "SELECT b FROM BankCustomerTransactionHistory b WHERE b.amount = :amount")
    , @NamedQuery(name = "BankCustomerTransactionHistory.findByTime", query = "SELECT b FROM BankCustomerTransactionHistory b WHERE b.time = :time")})
public class BankCustomerTransactionHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @JoinColumn(name = "bank_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BankAccount bankAccountId;
    @JoinColumn(name = "credit_or_debit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CreditOrDebit creditOrDebitId;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;

    public BankCustomerTransactionHistory() {
    }

    public BankCustomerTransactionHistory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public BankAccount getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(BankAccount bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public CreditOrDebit getCreditOrDebitId() {
        return creditOrDebitId;
    }

    public void setCreditOrDebitId(CreditOrDebit creditOrDebitId) {
        this.creditOrDebitId = creditOrDebitId;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
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
        if (!(object instanceof BankCustomerTransactionHistory)) {
            return false;
        }
        BankCustomerTransactionHistory other = (BankCustomerTransactionHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.BankCustomerTransactionHistory[ id=" + id + " ]";
    }
    
}
