/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "received_cheques")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReceivedCheques.findAll", query = "SELECT r FROM ReceivedCheques r")
    , @NamedQuery(name = "ReceivedCheques.findById", query = "SELECT r FROM ReceivedCheques r WHERE r.id = :id")
    , @NamedQuery(name = "ReceivedCheques.findByChequeNo", query = "SELECT r FROM ReceivedCheques r WHERE r.chequeNo = :chequeNo")
    , @NamedQuery(name = "ReceivedCheques.findByChequeDate", query = "SELECT r FROM ReceivedCheques r WHERE r.chequeDate = :chequeDate")
    , @NamedQuery(name = "ReceivedCheques.findByIsDeposited", query = "SELECT r FROM ReceivedCheques r WHERE r.isDeposited = :isDeposited")
    , @NamedQuery(name = "ReceivedCheques.findByChequeAmount", query = "SELECT r FROM ReceivedCheques r WHERE r.chequeAmount = :chequeAmount")})
public class ReceivedCheques implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "cheque_no")
    private String chequeNo;
    @Column(name = "cheque_date")
    @Temporal(TemporalType.DATE)
    private Date chequeDate;
    @Column(name = "is_deposited")
    private Integer isDeposited;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cheque_amount")
    private Double chequeAmount;
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bank bankId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receivedChequesId")
    private Collection<UniversalOrgPersonFinancialHistoryCheque> universalOrgPersonFinancialHistoryChequeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receivedChequesId")
    private Collection<LoanGuarantorChequeDetails> loanGuarantorChequeDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receivedChequesId")
    private Collection<VoucherItemReceivedCheques> voucherItemReceivedChequesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receivedChequesId")
    private Collection<GeneralJournalEntryReceivedCheques> generalJournalEntryReceivedChequesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receivedChequesId")
    private Collection<ChequeDeposit> chequeDepositCollection;

    public ReceivedCheques() {
    }

    public ReceivedCheques(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public Date getChequeDate() {
        return chequeDate;
    }

    public void setChequeDate(Date chequeDate) {
        this.chequeDate = chequeDate;
    }

    public Integer getIsDeposited() {
        return isDeposited;
    }

    public void setIsDeposited(Integer isDeposited) {
        this.isDeposited = isDeposited;
    }

    public Double getChequeAmount() {
        return chequeAmount;
    }

    public void setChequeAmount(Double chequeAmount) {
        this.chequeAmount = chequeAmount;
    }

    public Bank getBankId() {
        return bankId;
    }

    public void setBankId(Bank bankId) {
        this.bankId = bankId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
    }

    @XmlTransient
    public Collection<UniversalOrgPersonFinancialHistoryCheque> getUniversalOrgPersonFinancialHistoryChequeCollection() {
        return universalOrgPersonFinancialHistoryChequeCollection;
    }

    public void setUniversalOrgPersonFinancialHistoryChequeCollection(Collection<UniversalOrgPersonFinancialHistoryCheque> universalOrgPersonFinancialHistoryChequeCollection) {
        this.universalOrgPersonFinancialHistoryChequeCollection = universalOrgPersonFinancialHistoryChequeCollection;
    }

    @XmlTransient
    public Collection<LoanGuarantorChequeDetails> getLoanGuarantorChequeDetailsCollection() {
        return loanGuarantorChequeDetailsCollection;
    }

    public void setLoanGuarantorChequeDetailsCollection(Collection<LoanGuarantorChequeDetails> loanGuarantorChequeDetailsCollection) {
        this.loanGuarantorChequeDetailsCollection = loanGuarantorChequeDetailsCollection;
    }

    @XmlTransient
    public Collection<VoucherItemReceivedCheques> getVoucherItemReceivedChequesCollection() {
        return voucherItemReceivedChequesCollection;
    }

    public void setVoucherItemReceivedChequesCollection(Collection<VoucherItemReceivedCheques> voucherItemReceivedChequesCollection) {
        this.voucherItemReceivedChequesCollection = voucherItemReceivedChequesCollection;
    }

    @XmlTransient
    public Collection<GeneralJournalEntryReceivedCheques> getGeneralJournalEntryReceivedChequesCollection() {
        return generalJournalEntryReceivedChequesCollection;
    }

    public void setGeneralJournalEntryReceivedChequesCollection(Collection<GeneralJournalEntryReceivedCheques> generalJournalEntryReceivedChequesCollection) {
        this.generalJournalEntryReceivedChequesCollection = generalJournalEntryReceivedChequesCollection;
    }

    @XmlTransient
    public Collection<ChequeDeposit> getChequeDepositCollection() {
        return chequeDepositCollection;
    }

    public void setChequeDepositCollection(Collection<ChequeDeposit> chequeDepositCollection) {
        this.chequeDepositCollection = chequeDepositCollection;
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
        if (!(object instanceof ReceivedCheques)) {
            return false;
        }
        ReceivedCheques other = (ReceivedCheques) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ReceivedCheques[ id=" + id + " ]";
    }
    
}
