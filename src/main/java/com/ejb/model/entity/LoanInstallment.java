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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "loan_installment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoanInstallment.findAll", query = "SELECT l FROM LoanInstallment l")
    , @NamedQuery(name = "LoanInstallment.findById", query = "SELECT l FROM LoanInstallment l WHERE l.id = :id")
    , @NamedQuery(name = "LoanInstallment.findByDate", query = "SELECT l FROM LoanInstallment l WHERE l.date = :date")
    , @NamedQuery(name = "LoanInstallment.findByAmount", query = "SELECT l FROM LoanInstallment l WHERE l.amount = :amount")
    , @NamedQuery(name = "LoanInstallment.findByInterest", query = "SELECT l FROM LoanInstallment l WHERE l.interest = :interest")
    , @NamedQuery(name = "LoanInstallment.findByIsPaid", query = "SELECT l FROM LoanInstallment l WHERE l.isPaid = :isPaid")})
public class LoanInstallment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private double amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "interest")
    private double interest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_paid")
    private int isPaid;
    @JoinColumn(name = "loan_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LoanMaster loanMasterId;

    public LoanInstallment() {
    }

    public LoanInstallment(Integer id) {
        this.id = id;
    }

    public LoanInstallment(Integer id, Date date, double amount, double interest, int isPaid) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.interest = interest;
        this.isPaid = isPaid;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(int isPaid) {
        this.isPaid = isPaid;
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
        if (!(object instanceof LoanInstallment)) {
            return false;
        }
        LoanInstallment other = (LoanInstallment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.LoanInstallment[ id=" + id + " ]";
    }
    
}
