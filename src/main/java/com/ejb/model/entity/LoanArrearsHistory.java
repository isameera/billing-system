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
@Table(name = "loan_arrears_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoanArrearsHistory.findAll", query = "SELECT l FROM LoanArrearsHistory l")
    , @NamedQuery(name = "LoanArrearsHistory.findById", query = "SELECT l FROM LoanArrearsHistory l WHERE l.id = :id")
    , @NamedQuery(name = "LoanArrearsHistory.findByArrearsFrom", query = "SELECT l FROM LoanArrearsHistory l WHERE l.arrearsFrom = :arrearsFrom")
    , @NamedQuery(name = "LoanArrearsHistory.findByArrearsTo", query = "SELECT l FROM LoanArrearsHistory l WHERE l.arrearsTo = :arrearsTo")
    , @NamedQuery(name = "LoanArrearsHistory.findByArrearsDates", query = "SELECT l FROM LoanArrearsHistory l WHERE l.arrearsDates = :arrearsDates")
    , @NamedQuery(name = "LoanArrearsHistory.findByArrearsAmount", query = "SELECT l FROM LoanArrearsHistory l WHERE l.arrearsAmount = :arrearsAmount")
    , @NamedQuery(name = "LoanArrearsHistory.findByArrearsPanalty", query = "SELECT l FROM LoanArrearsHistory l WHERE l.arrearsPanalty = :arrearsPanalty")})
public class LoanArrearsHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "arrears_from")
    @Temporal(TemporalType.DATE)
    private Date arrearsFrom;
    @Column(name = "arrears_to")
    @Temporal(TemporalType.DATE)
    private Date arrearsTo;
    @Column(name = "arrears_dates")
    private Integer arrearsDates;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "arrears_amount")
    private Double arrearsAmount;
    @Column(name = "arrears_panalty")
    private Double arrearsPanalty;
    @JoinColumn(name = "loan_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LoanMaster loanMasterId;

    public LoanArrearsHistory() {
    }

    public LoanArrearsHistory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getArrearsFrom() {
        return arrearsFrom;
    }

    public void setArrearsFrom(Date arrearsFrom) {
        this.arrearsFrom = arrearsFrom;
    }

    public Date getArrearsTo() {
        return arrearsTo;
    }

    public void setArrearsTo(Date arrearsTo) {
        this.arrearsTo = arrearsTo;
    }

    public Integer getArrearsDates() {
        return arrearsDates;
    }

    public void setArrearsDates(Integer arrearsDates) {
        this.arrearsDates = arrearsDates;
    }

    public Double getArrearsAmount() {
        return arrearsAmount;
    }

    public void setArrearsAmount(Double arrearsAmount) {
        this.arrearsAmount = arrearsAmount;
    }

    public Double getArrearsPanalty() {
        return arrearsPanalty;
    }

    public void setArrearsPanalty(Double arrearsPanalty) {
        this.arrearsPanalty = arrearsPanalty;
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
        if (!(object instanceof LoanArrearsHistory)) {
            return false;
        }
        LoanArrearsHistory other = (LoanArrearsHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.LoanArrearsHistory[ id=" + id + " ]";
    }
    
}
