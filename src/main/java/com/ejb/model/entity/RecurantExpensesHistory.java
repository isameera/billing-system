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
@Table(name = "recurant_expenses_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecurantExpensesHistory.findAll", query = "SELECT r FROM RecurantExpensesHistory r")
    , @NamedQuery(name = "RecurantExpensesHistory.findById", query = "SELECT r FROM RecurantExpensesHistory r WHERE r.id = :id")
    , @NamedQuery(name = "RecurantExpensesHistory.findByDate", query = "SELECT r FROM RecurantExpensesHistory r WHERE r.date = :date")
    , @NamedQuery(name = "RecurantExpensesHistory.findByAmount", query = "SELECT r FROM RecurantExpensesHistory r WHERE r.amount = :amount")
    , @NamedQuery(name = "RecurantExpensesHistory.findByIsDone", query = "SELECT r FROM RecurantExpensesHistory r WHERE r.isDone = :isDone")})
public class RecurantExpensesHistory implements Serializable {

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
    @Column(name = "is_done")
    private Boolean isDone;
    @JoinColumn(name = "recurant_expenses_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RecurantExpenses recurantExpensesId;
    @JoinColumn(name = "voucher_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Voucher voucherId;

    public RecurantExpensesHistory() {
    }

    public RecurantExpensesHistory(Integer id) {
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

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    public RecurantExpenses getRecurantExpensesId() {
        return recurantExpensesId;
    }

    public void setRecurantExpensesId(RecurantExpenses recurantExpensesId) {
        this.recurantExpensesId = recurantExpensesId;
    }

    public Voucher getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Voucher voucherId) {
        this.voucherId = voucherId;
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
        if (!(object instanceof RecurantExpensesHistory)) {
            return false;
        }
        RecurantExpensesHistory other = (RecurantExpensesHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.RecurantExpensesHistory[ id=" + id + " ]";
    }
    
}
