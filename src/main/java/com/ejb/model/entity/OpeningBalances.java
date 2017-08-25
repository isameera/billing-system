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
@Table(name = "opening_balances")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpeningBalances.findAll", query = "SELECT o FROM OpeningBalances o")
    , @NamedQuery(name = "OpeningBalances.findById", query = "SELECT o FROM OpeningBalances o WHERE o.id = :id")
    , @NamedQuery(name = "OpeningBalances.findByDate", query = "SELECT o FROM OpeningBalances o WHERE o.date = :date")
    , @NamedQuery(name = "OpeningBalances.findByAmount", query = "SELECT o FROM OpeningBalances o WHERE o.amount = :amount")})
public class OpeningBalances implements Serializable {

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
    @JoinColumn(name = "general_journal_entry_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralJournalEntry generalJournalEntryId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "opening_balance_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OpeningBalanceType openingBalanceTypeId;

    public OpeningBalances() {
    }

    public OpeningBalances(Integer id) {
        this.id = id;
    }

    public OpeningBalances(Integer id, Date date, double amount) {
        this.id = id;
        this.date = date;
        this.amount = amount;
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

    public GeneralJournalEntry getGeneralJournalEntryId() {
        return generalJournalEntryId;
    }

    public void setGeneralJournalEntryId(GeneralJournalEntry generalJournalEntryId) {
        this.generalJournalEntryId = generalJournalEntryId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public OpeningBalanceType getOpeningBalanceTypeId() {
        return openingBalanceTypeId;
    }

    public void setOpeningBalanceTypeId(OpeningBalanceType openingBalanceTypeId) {
        this.openingBalanceTypeId = openingBalanceTypeId;
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
        if (!(object instanceof OpeningBalances)) {
            return false;
        }
        OpeningBalances other = (OpeningBalances) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.OpeningBalances[ id=" + id + " ]";
    }
    
}
