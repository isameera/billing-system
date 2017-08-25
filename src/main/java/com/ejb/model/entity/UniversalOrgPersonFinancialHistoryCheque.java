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
@Table(name = "universal_org_person_financial_history_cheque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniversalOrgPersonFinancialHistoryCheque.findAll", query = "SELECT u FROM UniversalOrgPersonFinancialHistoryCheque u")
    , @NamedQuery(name = "UniversalOrgPersonFinancialHistoryCheque.findById", query = "SELECT u FROM UniversalOrgPersonFinancialHistoryCheque u WHERE u.id = :id")})
public class UniversalOrgPersonFinancialHistoryCheque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "received_cheques_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ReceivedCheques receivedChequesId;
    @JoinColumn(name = "universal_org_person_financial_history_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalOrgPersonFinancialHistory universalOrgPersonFinancialHistoryId;

    public UniversalOrgPersonFinancialHistoryCheque() {
    }

    public UniversalOrgPersonFinancialHistoryCheque(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ReceivedCheques getReceivedChequesId() {
        return receivedChequesId;
    }

    public void setReceivedChequesId(ReceivedCheques receivedChequesId) {
        this.receivedChequesId = receivedChequesId;
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
        if (!(object instanceof UniversalOrgPersonFinancialHistoryCheque)) {
            return false;
        }
        UniversalOrgPersonFinancialHistoryCheque other = (UniversalOrgPersonFinancialHistoryCheque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UniversalOrgPersonFinancialHistoryCheque[ id=" + id + " ]";
    }
    
}
