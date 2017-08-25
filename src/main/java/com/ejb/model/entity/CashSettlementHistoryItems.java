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
@Table(name = "cash_settlement_history_items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CashSettlementHistoryItems.findAll", query = "SELECT c FROM CashSettlementHistoryItems c")
    , @NamedQuery(name = "CashSettlementHistoryItems.findByIdCshi", query = "SELECT c FROM CashSettlementHistoryItems c WHERE c.idCshi = :idCshi")})
public class CashSettlementHistoryItems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cshi")
    private Integer idCshi;
    @JoinColumn(name = "cash_settlement_history_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CashSettlementHistory cashSettlementHistoryId;
    @JoinColumn(name = "transaction_management_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TransactionManagement transactionManagementId;

    public CashSettlementHistoryItems() {
    }

    public CashSettlementHistoryItems(Integer idCshi) {
        this.idCshi = idCshi;
    }

    public Integer getIdCshi() {
        return idCshi;
    }

    public void setIdCshi(Integer idCshi) {
        this.idCshi = idCshi;
    }

    public CashSettlementHistory getCashSettlementHistoryId() {
        return cashSettlementHistoryId;
    }

    public void setCashSettlementHistoryId(CashSettlementHistory cashSettlementHistoryId) {
        this.cashSettlementHistoryId = cashSettlementHistoryId;
    }

    public TransactionManagement getTransactionManagementId() {
        return transactionManagementId;
    }

    public void setTransactionManagementId(TransactionManagement transactionManagementId) {
        this.transactionManagementId = transactionManagementId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCshi != null ? idCshi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CashSettlementHistoryItems)) {
            return false;
        }
        CashSettlementHistoryItems other = (CashSettlementHistoryItems) object;
        if ((this.idCshi == null && other.idCshi != null) || (this.idCshi != null && !this.idCshi.equals(other.idCshi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.CashSettlementHistoryItems[ idCshi=" + idCshi + " ]";
    }
    
}
