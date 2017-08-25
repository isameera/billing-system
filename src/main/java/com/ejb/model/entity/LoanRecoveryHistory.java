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
@Table(name = "loan_recovery_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoanRecoveryHistory.findAll", query = "SELECT l FROM LoanRecoveryHistory l")
    , @NamedQuery(name = "LoanRecoveryHistory.findById", query = "SELECT l FROM LoanRecoveryHistory l WHERE l.id = :id")
    , @NamedQuery(name = "LoanRecoveryHistory.findByDate", query = "SELECT l FROM LoanRecoveryHistory l WHERE l.date = :date")
    , @NamedQuery(name = "LoanRecoveryHistory.findByAmount", query = "SELECT l FROM LoanRecoveryHistory l WHERE l.amount = :amount")
    , @NamedQuery(name = "LoanRecoveryHistory.findByDeductFromCapital", query = "SELECT l FROM LoanRecoveryHistory l WHERE l.deductFromCapital = :deductFromCapital")
    , @NamedQuery(name = "LoanRecoveryHistory.findByDeductFromInterest", query = "SELECT l FROM LoanRecoveryHistory l WHERE l.deductFromInterest = :deductFromInterest")
    , @NamedQuery(name = "LoanRecoveryHistory.findByArrearsAmount", query = "SELECT l FROM LoanRecoveryHistory l WHERE l.arrearsAmount = :arrearsAmount")
    , @NamedQuery(name = "LoanRecoveryHistory.findByBalance", query = "SELECT l FROM LoanRecoveryHistory l WHERE l.balance = :balance")})
public class LoanRecoveryHistory implements Serializable {

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
    @Column(name = "deduct_from_capital")
    private Double deductFromCapital;
    @Column(name = "deduct_from_interest")
    private Double deductFromInterest;
    @Column(name = "arrears_amount")
    private Double arrearsAmount;
    @Column(name = "balance")
    private Double balance;
    @JoinColumn(name = "loan_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LoanMaster loanMasterId;

    public LoanRecoveryHistory() {
    }

    public LoanRecoveryHistory(Integer id) {
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

    public Double getDeductFromCapital() {
        return deductFromCapital;
    }

    public void setDeductFromCapital(Double deductFromCapital) {
        this.deductFromCapital = deductFromCapital;
    }

    public Double getDeductFromInterest() {
        return deductFromInterest;
    }

    public void setDeductFromInterest(Double deductFromInterest) {
        this.deductFromInterest = deductFromInterest;
    }

    public Double getArrearsAmount() {
        return arrearsAmount;
    }

    public void setArrearsAmount(Double arrearsAmount) {
        this.arrearsAmount = arrearsAmount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LoanMaster getLoanMasterId() {
        return loanMasterId;
    }

    public void setLoanMasterId(LoanMaster loanMasterId) {
        this.loanMasterId = loanMasterId;
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
        if (!(object instanceof LoanRecoveryHistory)) {
            return false;
        }
        LoanRecoveryHistory other = (LoanRecoveryHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.LoanRecoveryHistory[ id=" + id + " ]";
    }
    
}
