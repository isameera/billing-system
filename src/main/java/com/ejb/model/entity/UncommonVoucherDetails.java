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
@Table(name = "uncommon_voucher_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UncommonVoucherDetails.findAll", query = "SELECT u FROM UncommonVoucherDetails u")
    , @NamedQuery(name = "UncommonVoucherDetails.findById", query = "SELECT u FROM UncommonVoucherDetails u WHERE u.id = :id")
    , @NamedQuery(name = "UncommonVoucherDetails.findByFactoryValidation", query = "SELECT u FROM UncommonVoucherDetails u WHERE u.factoryValidation = :factoryValidation")
    , @NamedQuery(name = "UncommonVoucherDetails.findBySoldAmount", query = "SELECT u FROM UncommonVoucherDetails u WHERE u.soldAmount = :soldAmount")
    , @NamedQuery(name = "UncommonVoucherDetails.findByDateOfSold", query = "SELECT u FROM UncommonVoucherDetails u WHERE u.dateOfSold = :dateOfSold")
    , @NamedQuery(name = "UncommonVoucherDetails.findByManufacturingDateFrom", query = "SELECT u FROM UncommonVoucherDetails u WHERE u.manufacturingDateFrom = :manufacturingDateFrom")
    , @NamedQuery(name = "UncommonVoucherDetails.findByManufacturingDateTo", query = "SELECT u FROM UncommonVoucherDetails u WHERE u.manufacturingDateTo = :manufacturingDateTo")
    , @NamedQuery(name = "UncommonVoucherDetails.findByPromptDate", query = "SELECT u FROM UncommonVoucherDetails u WHERE u.promptDate = :promptDate")
    , @NamedQuery(name = "UncommonVoucherDetails.findByIsReturned", query = "SELECT u FROM UncommonVoucherDetails u WHERE u.isReturned = :isReturned")
    , @NamedQuery(name = "UncommonVoucherDetails.findByIsSold", query = "SELECT u FROM UncommonVoucherDetails u WHERE u.isSold = :isSold")
    , @NamedQuery(name = "UncommonVoucherDetails.findBySaleNo", query = "SELECT u FROM UncommonVoucherDetails u WHERE u.saleNo = :saleNo")})
public class UncommonVoucherDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "factory_validation")
    private Double factoryValidation;
    @Column(name = "sold_amount")
    private Double soldAmount;
    @Column(name = "date_of_sold")
    @Temporal(TemporalType.DATE)
    private Date dateOfSold;
    @Column(name = "manufacturing_date_from")
    @Temporal(TemporalType.DATE)
    private Date manufacturingDateFrom;
    @Column(name = "manufacturing_date_to")
    @Temporal(TemporalType.DATE)
    private Date manufacturingDateTo;
    @Column(name = "prompt_date")
    @Temporal(TemporalType.DATE)
    private Date promptDate;
    @Column(name = "is_returned")
    private Boolean isReturned;
    @Column(name = "is_sold")
    private Boolean isSold;
    @Size(max = 45)
    @Column(name = "sale_no")
    private String saleNo;
    @JoinColumn(name = "selling_mark_id", referencedColumnName = "id")
    @ManyToOne
    private SellingMark sellingMarkId;
    @JoinColumn(name = "voucher_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Voucher voucherId;
    @JoinColumn(name = "accounting_year_id", referencedColumnName = "id")
    @ManyToOne
    private FinanceYear accountingYearId;
    @JoinColumn(name = "tea_location_id", referencedColumnName = "id")
    @ManyToOne
    private TeaLocation teaLocationId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uncommonVoucherDetailsId")
    private Collection<DispatchedInvoiceReturn> dispatchedInvoiceReturnCollection;

    public UncommonVoucherDetails() {
    }

    public UncommonVoucherDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getFactoryValidation() {
        return factoryValidation;
    }

    public void setFactoryValidation(Double factoryValidation) {
        this.factoryValidation = factoryValidation;
    }

    public Double getSoldAmount() {
        return soldAmount;
    }

    public void setSoldAmount(Double soldAmount) {
        this.soldAmount = soldAmount;
    }

    public Date getDateOfSold() {
        return dateOfSold;
    }

    public void setDateOfSold(Date dateOfSold) {
        this.dateOfSold = dateOfSold;
    }

    public Date getManufacturingDateFrom() {
        return manufacturingDateFrom;
    }

    public void setManufacturingDateFrom(Date manufacturingDateFrom) {
        this.manufacturingDateFrom = manufacturingDateFrom;
    }

    public Date getManufacturingDateTo() {
        return manufacturingDateTo;
    }

    public void setManufacturingDateTo(Date manufacturingDateTo) {
        this.manufacturingDateTo = manufacturingDateTo;
    }

    public Date getPromptDate() {
        return promptDate;
    }

    public void setPromptDate(Date promptDate) {
        this.promptDate = promptDate;
    }

    public Boolean getIsReturned() {
        return isReturned;
    }

    public void setIsReturned(Boolean isReturned) {
        this.isReturned = isReturned;
    }

    public Boolean getIsSold() {
        return isSold;
    }

    public void setIsSold(Boolean isSold) {
        this.isSold = isSold;
    }

    public String getSaleNo() {
        return saleNo;
    }

    public void setSaleNo(String saleNo) {
        this.saleNo = saleNo;
    }

    public SellingMark getSellingMarkId() {
        return sellingMarkId;
    }

    public void setSellingMarkId(SellingMark sellingMarkId) {
        this.sellingMarkId = sellingMarkId;
    }

    public Voucher getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Voucher voucherId) {
        this.voucherId = voucherId;
    }

    public FinanceYear getAccountingYearId() {
        return accountingYearId;
    }

    public void setAccountingYearId(FinanceYear accountingYearId) {
        this.accountingYearId = accountingYearId;
    }

    public TeaLocation getTeaLocationId() {
        return teaLocationId;
    }

    public void setTeaLocationId(TeaLocation teaLocationId) {
        this.teaLocationId = teaLocationId;
    }

    @XmlTransient
    public Collection<DispatchedInvoiceReturn> getDispatchedInvoiceReturnCollection() {
        return dispatchedInvoiceReturnCollection;
    }

    public void setDispatchedInvoiceReturnCollection(Collection<DispatchedInvoiceReturn> dispatchedInvoiceReturnCollection) {
        this.dispatchedInvoiceReturnCollection = dispatchedInvoiceReturnCollection;
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
        if (!(object instanceof UncommonVoucherDetails)) {
            return false;
        }
        UncommonVoucherDetails other = (UncommonVoucherDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UncommonVoucherDetails[ id=" + id + " ]";
    }
    
}
