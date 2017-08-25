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
@Table(name = "cheque_deposit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChequeDeposit.findAll", query = "SELECT c FROM ChequeDeposit c")
    , @NamedQuery(name = "ChequeDeposit.findById", query = "SELECT c FROM ChequeDeposit c WHERE c.id = :id")
    , @NamedQuery(name = "ChequeDeposit.findByDepositDate", query = "SELECT c FROM ChequeDeposit c WHERE c.depositDate = :depositDate")})
public class ChequeDeposit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "deposit_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date depositDate;
    @JoinColumn(name = "general_journal_entry_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralJournalEntry generalJournalEntryId;
    @JoinColumn(name = "received_cheques_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ReceivedCheques receivedChequesId;

    public ChequeDeposit() {
    }

    public ChequeDeposit(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(Date depositDate) {
        this.depositDate = depositDate;
    }

    public GeneralJournalEntry getGeneralJournalEntryId() {
        return generalJournalEntryId;
    }

    public void setGeneralJournalEntryId(GeneralJournalEntry generalJournalEntryId) {
        this.generalJournalEntryId = generalJournalEntryId;
    }

    public ReceivedCheques getReceivedChequesId() {
        return receivedChequesId;
    }

    public void setReceivedChequesId(ReceivedCheques receivedChequesId) {
        this.receivedChequesId = receivedChequesId;
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
        if (!(object instanceof ChequeDeposit)) {
            return false;
        }
        ChequeDeposit other = (ChequeDeposit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ChequeDeposit[ id=" + id + " ]";
    }
    
}
