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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "loan_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoanMaster.findAll", query = "SELECT l FROM LoanMaster l")
    , @NamedQuery(name = "LoanMaster.findById", query = "SELECT l FROM LoanMaster l WHERE l.id = :id")
    , @NamedQuery(name = "LoanMaster.findByLoanId", query = "SELECT l FROM LoanMaster l WHERE l.loanId = :loanId")
    , @NamedQuery(name = "LoanMaster.findByAmount", query = "SELECT l FROM LoanMaster l WHERE l.amount = :amount")
    , @NamedQuery(name = "LoanMaster.findByGrantAmount", query = "SELECT l FROM LoanMaster l WHERE l.grantAmount = :grantAmount")
    , @NamedQuery(name = "LoanMaster.findByRecoveryAmount", query = "SELECT l FROM LoanMaster l WHERE l.recoveryAmount = :recoveryAmount")
    , @NamedQuery(name = "LoanMaster.findByTotalPaidCapital", query = "SELECT l FROM LoanMaster l WHERE l.totalPaidCapital = :totalPaidCapital")
    , @NamedQuery(name = "LoanMaster.findByTotalPaidInterest", query = "SELECT l FROM LoanMaster l WHERE l.totalPaidInterest = :totalPaidInterest")
    , @NamedQuery(name = "LoanMaster.findByLoanInterestRate", query = "SELECT l FROM LoanMaster l WHERE l.loanInterestRate = :loanInterestRate")
    , @NamedQuery(name = "LoanMaster.findByDue", query = "SELECT l FROM LoanMaster l WHERE l.due = :due")
    , @NamedQuery(name = "LoanMaster.findByTotalArrears", query = "SELECT l FROM LoanMaster l WHERE l.totalArrears = :totalArrears")
    , @NamedQuery(name = "LoanMaster.findByRequestedDate", query = "SELECT l FROM LoanMaster l WHERE l.requestedDate = :requestedDate")
    , @NamedQuery(name = "LoanMaster.findByIssuedDate", query = "SELECT l FROM LoanMaster l WHERE l.issuedDate = :issuedDate")
    , @NamedQuery(name = "LoanMaster.findByCompletedDate", query = "SELECT l FROM LoanMaster l WHERE l.completedDate = :completedDate")
    , @NamedQuery(name = "LoanMaster.findByDuration", query = "SELECT l FROM LoanMaster l WHERE l.duration = :duration")
    , @NamedQuery(name = "LoanMaster.findByRequstedAmount", query = "SELECT l FROM LoanMaster l WHERE l.requstedAmount = :requstedAmount")
    , @NamedQuery(name = "LoanMaster.findByRequestedPeriod", query = "SELECT l FROM LoanMaster l WHERE l.requestedPeriod = :requestedPeriod")
    , @NamedQuery(name = "LoanMaster.findByStartingDate", query = "SELECT l FROM LoanMaster l WHERE l.startingDate = :startingDate")})
public class LoanMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "loan_id")
    private String loanId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private double amount;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "grant_amount")
    private Double grantAmount;
    @Column(name = "recovery_amount")
    private Double recoveryAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_paid_capital")
    private double totalPaidCapital;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_paid_interest")
    private double totalPaidInterest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "loan_interest_rate")
    private double loanInterestRate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "due")
    private double due;
    @Column(name = "total_arrears")
    private Double totalArrears;
    @Basic(optional = false)
    @NotNull
    @Column(name = "requested_date")
    @Temporal(TemporalType.DATE)
    private Date requestedDate;
    @Column(name = "issued_date")
    @Temporal(TemporalType.DATE)
    private Date issuedDate;
    @Column(name = "completed_date")
    @Temporal(TemporalType.DATE)
    private Date completedDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duration")
    private int duration;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "purpose")
    private String purpose;
    @Column(name = "requsted_amount")
    private Double requstedAmount;
    @Column(name = "requested_period")
    private Double requestedPeriod;
    @Column(name = "starting_date")
    @Temporal(TemporalType.DATE)
    private Date startingDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loanMasterId")
    private Collection<LoanArrearsHistory> loanArrearsHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loanMasterId")
    private Collection<LoanRecoveryHistory> loanRecoveryHistoryCollection;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "applied_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile appliedBy;
    @JoinColumn(name = "loan_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LoanStatus loanStatusId;
    @JoinColumn(name = "gup_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GupType gupTypeId;
    @JoinColumn(name = "loan_step_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LoanStep loanStepId;
    @JoinColumn(name = "loan_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LoanType loanTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loanId")
    private Collection<GurantorLoanManager> gurantorLoanManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loanMasterId")
    private Collection<LoanInstallment> loanInstallmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loanMasterId")
    private Collection<LoanApproval> loanApprovalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loanMasterId")
    private Collection<LoanTransferForApproval> loanTransferForApprovalCollection;

    public LoanMaster() {
    }

    public LoanMaster(Integer id) {
        this.id = id;
    }

    public LoanMaster(Integer id, String loanId, double amount, double totalPaidCapital, double totalPaidInterest, double loanInterestRate, double due, Date requestedDate, int duration, String purpose) {
        this.id = id;
        this.loanId = loanId;
        this.amount = amount;
        this.totalPaidCapital = totalPaidCapital;
        this.totalPaidInterest = totalPaidInterest;
        this.loanInterestRate = loanInterestRate;
        this.due = due;
        this.requestedDate = requestedDate;
        this.duration = duration;
        this.purpose = purpose;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Double getGrantAmount() {
        return grantAmount;
    }

    public void setGrantAmount(Double grantAmount) {
        this.grantAmount = grantAmount;
    }

    public Double getRecoveryAmount() {
        return recoveryAmount;
    }

    public void setRecoveryAmount(Double recoveryAmount) {
        this.recoveryAmount = recoveryAmount;
    }

    public double getTotalPaidCapital() {
        return totalPaidCapital;
    }

    public void setTotalPaidCapital(double totalPaidCapital) {
        this.totalPaidCapital = totalPaidCapital;
    }

    public double getTotalPaidInterest() {
        return totalPaidInterest;
    }

    public void setTotalPaidInterest(double totalPaidInterest) {
        this.totalPaidInterest = totalPaidInterest;
    }

    public double getLoanInterestRate() {
        return loanInterestRate;
    }

    public void setLoanInterestRate(double loanInterestRate) {
        this.loanInterestRate = loanInterestRate;
    }

    public double getDue() {
        return due;
    }

    public void setDue(double due) {
        this.due = due;
    }

    public Double getTotalArrears() {
        return totalArrears;
    }

    public void setTotalArrears(Double totalArrears) {
        this.totalArrears = totalArrears;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Double getRequstedAmount() {
        return requstedAmount;
    }

    public void setRequstedAmount(Double requstedAmount) {
        this.requstedAmount = requstedAmount;
    }

    public Double getRequestedPeriod() {
        return requestedPeriod;
    }

    public void setRequestedPeriod(Double requestedPeriod) {
        this.requestedPeriod = requestedPeriod;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    @XmlTransient
    public Collection<LoanArrearsHistory> getLoanArrearsHistoryCollection() {
        return loanArrearsHistoryCollection;
    }

    public void setLoanArrearsHistoryCollection(Collection<LoanArrearsHistory> loanArrearsHistoryCollection) {
        this.loanArrearsHistoryCollection = loanArrearsHistoryCollection;
    }

    @XmlTransient
    public Collection<LoanRecoveryHistory> getLoanRecoveryHistoryCollection() {
        return loanRecoveryHistoryCollection;
    }

    public void setLoanRecoveryHistoryCollection(Collection<LoanRecoveryHistory> loanRecoveryHistoryCollection) {
        this.loanRecoveryHistoryCollection = loanRecoveryHistoryCollection;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public GeneralUserProfile getAppliedBy() {
        return appliedBy;
    }

    public void setAppliedBy(GeneralUserProfile appliedBy) {
        this.appliedBy = appliedBy;
    }

    public LoanStatus getLoanStatusId() {
        return loanStatusId;
    }

    public void setLoanStatusId(LoanStatus loanStatusId) {
        this.loanStatusId = loanStatusId;
    }

    public GupType getGupTypeId() {
        return gupTypeId;
    }

    public void setGupTypeId(GupType gupTypeId) {
        this.gupTypeId = gupTypeId;
    }

    public LoanStep getLoanStepId() {
        return loanStepId;
    }

    public void setLoanStepId(LoanStep loanStepId) {
        this.loanStepId = loanStepId;
    }

    public LoanType getLoanTypeId() {
        return loanTypeId;
    }

    public void setLoanTypeId(LoanType loanTypeId) {
        this.loanTypeId = loanTypeId;
    }

    @XmlTransient
    public Collection<GurantorLoanManager> getGurantorLoanManagerCollection() {
        return gurantorLoanManagerCollection;
    }

    public void setGurantorLoanManagerCollection(Collection<GurantorLoanManager> gurantorLoanManagerCollection) {
        this.gurantorLoanManagerCollection = gurantorLoanManagerCollection;
    }

    @XmlTransient
    public Collection<LoanInstallment> getLoanInstallmentCollection() {
        return loanInstallmentCollection;
    }

    public void setLoanInstallmentCollection(Collection<LoanInstallment> loanInstallmentCollection) {
        this.loanInstallmentCollection = loanInstallmentCollection;
    }

    @XmlTransient
    public Collection<LoanApproval> getLoanApprovalCollection() {
        return loanApprovalCollection;
    }

    public void setLoanApprovalCollection(Collection<LoanApproval> loanApprovalCollection) {
        this.loanApprovalCollection = loanApprovalCollection;
    }

    @XmlTransient
    public Collection<LoanTransferForApproval> getLoanTransferForApprovalCollection() {
        return loanTransferForApprovalCollection;
    }

    public void setLoanTransferForApprovalCollection(Collection<LoanTransferForApproval> loanTransferForApprovalCollection) {
        this.loanTransferForApprovalCollection = loanTransferForApprovalCollection;
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
        if (!(object instanceof LoanMaster)) {
            return false;
        }
        LoanMaster other = (LoanMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.LoanMaster[ id=" + id + " ]";
    }
    
}
