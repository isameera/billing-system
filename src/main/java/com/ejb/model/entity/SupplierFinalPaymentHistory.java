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
@Table(name = "supplier_final_payment_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierFinalPaymentHistory.findAll", query = "SELECT s FROM SupplierFinalPaymentHistory s")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findById", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.id = :id")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByIssuedDate", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.issuedDate = :issuedDate")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByYear", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.year = :year")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByMonth", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.month = :month")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByNormalLeafQty", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.normalLeafQty = :normalLeafQty")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByNormalLeafRate", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.normalLeafRate = :normalLeafRate")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByNormalLeafAmount", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.normalLeafAmount = :normalLeafAmount")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findBySuperLeafQty", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.superLeafQty = :superLeafQty")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findBySuperLeafRate", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.superLeafRate = :superLeafRate")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findBySuperLeafAmount", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.superLeafAmount = :superLeafAmount")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByTotalQty", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.totalQty = :totalQty")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByTotalAmountOfLeaf", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.totalAmountOfLeaf = :totalAmountOfLeaf")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByTrAddPayAmount", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.trAddPayAmount = :trAddPayAmount")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByIncentive", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.incentive = :incentive")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByTransport", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.transport = :transport")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByAdvance", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.advance = :advance")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByTea", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.tea = :tea")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByBfFertlizerRec", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.bfFertlizerRec = :bfFertlizerRec")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByThisMonthFertilizerRec", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.thisMonthFertilizerRec = :thisMonthFertilizerRec")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByLoan", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.loan = :loan")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByFuneralFund", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.funeralFund = :funeralFund")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findBySaving", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.saving = :saving")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByOther", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.other = :other")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByStamp", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.stamp = :stamp")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByBfDebit", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.bfDebit = :bfDebit")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByTotalDeduction", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.totalDeduction = :totalDeduction")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByBalance", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.balance = :balance")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByCfDebit", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.cfDebit = :cfDebit")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByCfFertilizer", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.cfFertilizer = :cfFertilizer")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByLoanInstallment", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.loanInstallment = :loanInstallment")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByPrevLoanArriers", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.prevLoanArriers = :prevLoanArriers")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByThisMonthLoanRec", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.thisMonthLoanRec = :thisMonthLoanRec")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByLoanArriers", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.loanArriers = :loanArriers")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByAddPay", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.addPay = :addPay")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByBfOther", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.bfOther = :bfOther")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByCfOther", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.cfOther = :cfOther")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByLoanInterest", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.loanInterest = :loanInterest")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByFertilizerTransport", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.fertilizerTransport = :fertilizerTransport")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByLeafSack", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.leafSack = :leafSack")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByChemical", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.chemical = :chemical")
    , @NamedQuery(name = "SupplierFinalPaymentHistory.findByIsPaid", query = "SELECT s FROM SupplierFinalPaymentHistory s WHERE s.isPaid = :isPaid")})
public class SupplierFinalPaymentHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "issued_date")
    @Temporal(TemporalType.DATE)
    private Date issuedDate;
    @Column(name = "year")
    private Integer year;
    @Column(name = "month")
    private Integer month;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "normal_leaf_qty")
    private Double normalLeafQty;
    @Column(name = "normal_leaf_rate")
    private Double normalLeafRate;
    @Column(name = "normal_leaf_amount")
    private Double normalLeafAmount;
    @Column(name = "super_leaf_qty")
    private Double superLeafQty;
    @Column(name = "super_leaf_rate")
    private Double superLeafRate;
    @Column(name = "super_leaf_amount")
    private Double superLeafAmount;
    @Column(name = "total_qty")
    private Double totalQty;
    @Column(name = "total_amount_of_leaf")
    private Double totalAmountOfLeaf;
    @Column(name = "tr_add_pay_amount")
    private Double trAddPayAmount;
    @Column(name = "incentive")
    private Double incentive;
    @Column(name = "transport")
    private Double transport;
    @Column(name = "advance")
    private Double advance;
    @Column(name = "tea")
    private Double tea;
    @Column(name = "bf_fertlizer_rec")
    private Double bfFertlizerRec;
    @Column(name = "this_month_fertilizer_rec")
    private Double thisMonthFertilizerRec;
    @Column(name = "loan")
    private Double loan;
    @Column(name = "funeral_fund")
    private Double funeralFund;
    @Column(name = "saving")
    private Double saving;
    @Column(name = "other")
    private Double other;
    @Column(name = "stamp")
    private Double stamp;
    @Column(name = "bf_debit")
    private Double bfDebit;
    @Column(name = "total_deduction")
    private Double totalDeduction;
    @Column(name = "balance")
    private Double balance;
    @Column(name = "cf_debit")
    private Double cfDebit;
    @Column(name = "cf_fertilizer")
    private Double cfFertilizer;
    @Column(name = "loan_installment")
    private Double loanInstallment;
    @Column(name = "prev_loan_arriers")
    private Double prevLoanArriers;
    @Column(name = "this_month_loan_rec")
    private Double thisMonthLoanRec;
    @Column(name = "loan_arriers")
    private Double loanArriers;
    @Column(name = "add_pay")
    private Double addPay;
    @Column(name = "bf_other")
    private Double bfOther;
    @Column(name = "cf_other")
    private Double cfOther;
    @Column(name = "loan_interest")
    private Double loanInterest;
    @Column(name = "fertilizer_transport")
    private Double fertilizerTransport;
    @Column(name = "leaf_sack")
    private Double leafSack;
    @Column(name = "chemical")
    private Double chemical;
    @Column(name = "is_paid")
    private Integer isPaid;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Route routeId;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierRegistration supplierRegistrationId;
    @JoinColumn(name = "universal_payment_mode_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalPaymentMode universalPaymentModeId;

    public SupplierFinalPaymentHistory() {
    }

    public SupplierFinalPaymentHistory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getNormalLeafQty() {
        return normalLeafQty;
    }

    public void setNormalLeafQty(Double normalLeafQty) {
        this.normalLeafQty = normalLeafQty;
    }

    public Double getNormalLeafRate() {
        return normalLeafRate;
    }

    public void setNormalLeafRate(Double normalLeafRate) {
        this.normalLeafRate = normalLeafRate;
    }

    public Double getNormalLeafAmount() {
        return normalLeafAmount;
    }

    public void setNormalLeafAmount(Double normalLeafAmount) {
        this.normalLeafAmount = normalLeafAmount;
    }

    public Double getSuperLeafQty() {
        return superLeafQty;
    }

    public void setSuperLeafQty(Double superLeafQty) {
        this.superLeafQty = superLeafQty;
    }

    public Double getSuperLeafRate() {
        return superLeafRate;
    }

    public void setSuperLeafRate(Double superLeafRate) {
        this.superLeafRate = superLeafRate;
    }

    public Double getSuperLeafAmount() {
        return superLeafAmount;
    }

    public void setSuperLeafAmount(Double superLeafAmount) {
        this.superLeafAmount = superLeafAmount;
    }

    public Double getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(Double totalQty) {
        this.totalQty = totalQty;
    }

    public Double getTotalAmountOfLeaf() {
        return totalAmountOfLeaf;
    }

    public void setTotalAmountOfLeaf(Double totalAmountOfLeaf) {
        this.totalAmountOfLeaf = totalAmountOfLeaf;
    }

    public Double getTrAddPayAmount() {
        return trAddPayAmount;
    }

    public void setTrAddPayAmount(Double trAddPayAmount) {
        this.trAddPayAmount = trAddPayAmount;
    }

    public Double getIncentive() {
        return incentive;
    }

    public void setIncentive(Double incentive) {
        this.incentive = incentive;
    }

    public Double getTransport() {
        return transport;
    }

    public void setTransport(Double transport) {
        this.transport = transport;
    }

    public Double getAdvance() {
        return advance;
    }

    public void setAdvance(Double advance) {
        this.advance = advance;
    }

    public Double getTea() {
        return tea;
    }

    public void setTea(Double tea) {
        this.tea = tea;
    }

    public Double getBfFertlizerRec() {
        return bfFertlizerRec;
    }

    public void setBfFertlizerRec(Double bfFertlizerRec) {
        this.bfFertlizerRec = bfFertlizerRec;
    }

    public Double getThisMonthFertilizerRec() {
        return thisMonthFertilizerRec;
    }

    public void setThisMonthFertilizerRec(Double thisMonthFertilizerRec) {
        this.thisMonthFertilizerRec = thisMonthFertilizerRec;
    }

    public Double getLoan() {
        return loan;
    }

    public void setLoan(Double loan) {
        this.loan = loan;
    }

    public Double getFuneralFund() {
        return funeralFund;
    }

    public void setFuneralFund(Double funeralFund) {
        this.funeralFund = funeralFund;
    }

    public Double getSaving() {
        return saving;
    }

    public void setSaving(Double saving) {
        this.saving = saving;
    }

    public Double getOther() {
        return other;
    }

    public void setOther(Double other) {
        this.other = other;
    }

    public Double getStamp() {
        return stamp;
    }

    public void setStamp(Double stamp) {
        this.stamp = stamp;
    }

    public Double getBfDebit() {
        return bfDebit;
    }

    public void setBfDebit(Double bfDebit) {
        this.bfDebit = bfDebit;
    }

    public Double getTotalDeduction() {
        return totalDeduction;
    }

    public void setTotalDeduction(Double totalDeduction) {
        this.totalDeduction = totalDeduction;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getCfDebit() {
        return cfDebit;
    }

    public void setCfDebit(Double cfDebit) {
        this.cfDebit = cfDebit;
    }

    public Double getCfFertilizer() {
        return cfFertilizer;
    }

    public void setCfFertilizer(Double cfFertilizer) {
        this.cfFertilizer = cfFertilizer;
    }

    public Double getLoanInstallment() {
        return loanInstallment;
    }

    public void setLoanInstallment(Double loanInstallment) {
        this.loanInstallment = loanInstallment;
    }

    public Double getPrevLoanArriers() {
        return prevLoanArriers;
    }

    public void setPrevLoanArriers(Double prevLoanArriers) {
        this.prevLoanArriers = prevLoanArriers;
    }

    public Double getThisMonthLoanRec() {
        return thisMonthLoanRec;
    }

    public void setThisMonthLoanRec(Double thisMonthLoanRec) {
        this.thisMonthLoanRec = thisMonthLoanRec;
    }

    public Double getLoanArriers() {
        return loanArriers;
    }

    public void setLoanArriers(Double loanArriers) {
        this.loanArriers = loanArriers;
    }

    public Double getAddPay() {
        return addPay;
    }

    public void setAddPay(Double addPay) {
        this.addPay = addPay;
    }

    public Double getBfOther() {
        return bfOther;
    }

    public void setBfOther(Double bfOther) {
        this.bfOther = bfOther;
    }

    public Double getCfOther() {
        return cfOther;
    }

    public void setCfOther(Double cfOther) {
        this.cfOther = cfOther;
    }

    public Double getLoanInterest() {
        return loanInterest;
    }

    public void setLoanInterest(Double loanInterest) {
        this.loanInterest = loanInterest;
    }

    public Double getFertilizerTransport() {
        return fertilizerTransport;
    }

    public void setFertilizerTransport(Double fertilizerTransport) {
        this.fertilizerTransport = fertilizerTransport;
    }

    public Double getLeafSack() {
        return leafSack;
    }

    public void setLeafSack(Double leafSack) {
        this.leafSack = leafSack;
    }

    public Double getChemical() {
        return chemical;
    }

    public void setChemical(Double chemical) {
        this.chemical = chemical;
    }

    public Integer getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Integer isPaid) {
        this.isPaid = isPaid;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    public SupplierRegistration getSupplierRegistrationId() {
        return supplierRegistrationId;
    }

    public void setSupplierRegistrationId(SupplierRegistration supplierRegistrationId) {
        this.supplierRegistrationId = supplierRegistrationId;
    }

    public UniversalPaymentMode getUniversalPaymentModeId() {
        return universalPaymentModeId;
    }

    public void setUniversalPaymentModeId(UniversalPaymentMode universalPaymentModeId) {
        this.universalPaymentModeId = universalPaymentModeId;
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
        if (!(object instanceof SupplierFinalPaymentHistory)) {
            return false;
        }
        SupplierFinalPaymentHistory other = (SupplierFinalPaymentHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierFinalPaymentHistory[ id=" + id + " ]";
    }
    
}
