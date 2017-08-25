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
@Table(name = "sub_cart_of_account_payment_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubCartOfAccountPaymentHistory.findAll", query = "SELECT s FROM SubCartOfAccountPaymentHistory s")
    , @NamedQuery(name = "SubCartOfAccountPaymentHistory.findById", query = "SELECT s FROM SubCartOfAccountPaymentHistory s WHERE s.id = :id")
    , @NamedQuery(name = "SubCartOfAccountPaymentHistory.findByDate", query = "SELECT s FROM SubCartOfAccountPaymentHistory s WHERE s.date = :date")
    , @NamedQuery(name = "SubCartOfAccountPaymentHistory.findByToDateBalance", query = "SELECT s FROM SubCartOfAccountPaymentHistory s WHERE s.toDateBalance = :toDateBalance")
    , @NamedQuery(name = "SubCartOfAccountPaymentHistory.findByBalanceAmount", query = "SELECT s FROM SubCartOfAccountPaymentHistory s WHERE s.balanceAmount = :balanceAmount")
    , @NamedQuery(name = "SubCartOfAccountPaymentHistory.findByTotalCredit", query = "SELECT s FROM SubCartOfAccountPaymentHistory s WHERE s.totalCredit = :totalCredit")
    , @NamedQuery(name = "SubCartOfAccountPaymentHistory.findByTotalDebit", query = "SELECT s FROM SubCartOfAccountPaymentHistory s WHERE s.totalDebit = :totalDebit")})
public class SubCartOfAccountPaymentHistory implements Serializable {

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
    @Column(name = "to_date_balance")
    private Double toDateBalance;
    @Column(name = "balance_amount")
    private Double balanceAmount;
    @Column(name = "total_credit")
    private Double totalCredit;
    @Column(name = "total_debit")
    private Double totalDebit;
    @JoinColumn(name = "sub_chart_of_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SubChartOfAccount subChartOfAccountId;

    public SubCartOfAccountPaymentHistory() {
    }

    public SubCartOfAccountPaymentHistory(Integer id) {
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

    public Double getToDateBalance() {
        return toDateBalance;
    }

    public void setToDateBalance(Double toDateBalance) {
        this.toDateBalance = toDateBalance;
    }

    public Double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(Double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public Double getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(Double totalCredit) {
        this.totalCredit = totalCredit;
    }

    public Double getTotalDebit() {
        return totalDebit;
    }

    public void setTotalDebit(Double totalDebit) {
        this.totalDebit = totalDebit;
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
        if (!(object instanceof SubCartOfAccountPaymentHistory)) {
            return false;
        }
        SubCartOfAccountPaymentHistory other = (SubCartOfAccountPaymentHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SubCartOfAccountPaymentHistory[ id=" + id + " ]";
    }
    
}
