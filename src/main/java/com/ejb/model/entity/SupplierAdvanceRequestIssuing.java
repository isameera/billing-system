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
@Table(name = "supplier_advance_request_issuing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierAdvanceRequestIssuing.findAll", query = "SELECT s FROM SupplierAdvanceRequestIssuing s")
    , @NamedQuery(name = "SupplierAdvanceRequestIssuing.findById", query = "SELECT s FROM SupplierAdvanceRequestIssuing s WHERE s.id = :id")
    , @NamedQuery(name = "SupplierAdvanceRequestIssuing.findByVoucherId", query = "SELECT s FROM SupplierAdvanceRequestIssuing s WHERE s.voucherId = :voucherId")
    , @NamedQuery(name = "SupplierAdvanceRequestIssuing.findByDate", query = "SELECT s FROM SupplierAdvanceRequestIssuing s WHERE s.date = :date")
    , @NamedQuery(name = "SupplierAdvanceRequestIssuing.findByYear", query = "SELECT s FROM SupplierAdvanceRequestIssuing s WHERE s.year = :year")
    , @NamedQuery(name = "SupplierAdvanceRequestIssuing.findByMonth", query = "SELECT s FROM SupplierAdvanceRequestIssuing s WHERE s.month = :month")
    , @NamedQuery(name = "SupplierAdvanceRequestIssuing.findByAmount", query = "SELECT s FROM SupplierAdvanceRequestIssuing s WHERE s.amount = :amount")
    , @NamedQuery(name = "SupplierAdvanceRequestIssuing.findByLeafQty", query = "SELECT s FROM SupplierAdvanceRequestIssuing s WHERE s.leafQty = :leafQty")
    , @NamedQuery(name = "SupplierAdvanceRequestIssuing.findByMatchRate", query = "SELECT s FROM SupplierAdvanceRequestIssuing s WHERE s.matchRate = :matchRate")
    , @NamedQuery(name = "SupplierAdvanceRequestIssuing.findByGross", query = "SELECT s FROM SupplierAdvanceRequestIssuing s WHERE s.gross = :gross")
    , @NamedQuery(name = "SupplierAdvanceRequestIssuing.findByTotalDeduction", query = "SELECT s FROM SupplierAdvanceRequestIssuing s WHERE s.totalDeduction = :totalDeduction")
    , @NamedQuery(name = "SupplierAdvanceRequestIssuing.findByIsPaid", query = "SELECT s FROM SupplierAdvanceRequestIssuing s WHERE s.isPaid = :isPaid")})
public class SupplierAdvanceRequestIssuing implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "voucher_id")
    private String voucherId;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "year")
    private Integer year;
    @Column(name = "month")
    private Integer month;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @Column(name = "leaf_qty")
    private Double leafQty;
    @Column(name = "match_rate")
    private Double matchRate;
    @Column(name = "gross")
    private Double gross;
    @Column(name = "total_deduction")
    private Double totalDeduction;
    @Column(name = "is_paid")
    private Integer isPaid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierAdvanceRequestIssuingId")
    private Collection<SupplierAdvanceIssuingSummaryDetails> supplierAdvanceIssuingSummaryDetailsCollection;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "supplier_advance_request_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierAdvanceRequest supplierAdvanceRequestId;

    public SupplierAdvanceRequestIssuing() {
    }

    public SupplierAdvanceRequestIssuing(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(String voucherId) {
        this.voucherId = voucherId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getLeafQty() {
        return leafQty;
    }

    public void setLeafQty(Double leafQty) {
        this.leafQty = leafQty;
    }

    public Double getMatchRate() {
        return matchRate;
    }

    public void setMatchRate(Double matchRate) {
        this.matchRate = matchRate;
    }

    public Double getGross() {
        return gross;
    }

    public void setGross(Double gross) {
        this.gross = gross;
    }

    public Double getTotalDeduction() {
        return totalDeduction;
    }

    public void setTotalDeduction(Double totalDeduction) {
        this.totalDeduction = totalDeduction;
    }

    public Integer getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Integer isPaid) {
        this.isPaid = isPaid;
    }

    @XmlTransient
    public Collection<SupplierAdvanceIssuingSummaryDetails> getSupplierAdvanceIssuingSummaryDetailsCollection() {
        return supplierAdvanceIssuingSummaryDetailsCollection;
    }

    public void setSupplierAdvanceIssuingSummaryDetailsCollection(Collection<SupplierAdvanceIssuingSummaryDetails> supplierAdvanceIssuingSummaryDetailsCollection) {
        this.supplierAdvanceIssuingSummaryDetailsCollection = supplierAdvanceIssuingSummaryDetailsCollection;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public SupplierAdvanceRequest getSupplierAdvanceRequestId() {
        return supplierAdvanceRequestId;
    }

    public void setSupplierAdvanceRequestId(SupplierAdvanceRequest supplierAdvanceRequestId) {
        this.supplierAdvanceRequestId = supplierAdvanceRequestId;
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
        if (!(object instanceof SupplierAdvanceRequestIssuing)) {
            return false;
        }
        SupplierAdvanceRequestIssuing other = (SupplierAdvanceRequestIssuing) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierAdvanceRequestIssuing[ id=" + id + " ]";
    }
    
}
