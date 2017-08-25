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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "uncommon_voucher_item_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UncommonVoucherItemDetails.findAll", query = "SELECT u FROM UncommonVoucherItemDetails u")
    , @NamedQuery(name = "UncommonVoucherItemDetails.findById", query = "SELECT u FROM UncommonVoucherItemDetails u WHERE u.id = :id")
    , @NamedQuery(name = "UncommonVoucherItemDetails.findByLotNo", query = "SELECT u FROM UncommonVoucherItemDetails u WHERE u.lotNo = :lotNo")
    , @NamedQuery(name = "UncommonVoucherItemDetails.findByMinValue", query = "SELECT u FROM UncommonVoucherItemDetails u WHERE u.minValue = :minValue")
    , @NamedQuery(name = "UncommonVoucherItemDetails.findByMaxValue", query = "SELECT u FROM UncommonVoucherItemDetails u WHERE u.maxValue = :maxValue")
    , @NamedQuery(name = "UncommonVoucherItemDetails.findByAmendedValue", query = "SELECT u FROM UncommonVoucherItemDetails u WHERE u.amendedValue = :amendedValue")
    , @NamedQuery(name = "UncommonVoucherItemDetails.findBySampleAllownce", query = "SELECT u FROM UncommonVoucherItemDetails u WHERE u.sampleAllownce = :sampleAllownce")
    , @NamedQuery(name = "UncommonVoucherItemDetails.findByValuationRecievedDate", query = "SELECT u FROM UncommonVoucherItemDetails u WHERE u.valuationRecievedDate = :valuationRecievedDate")
    , @NamedQuery(name = "UncommonVoucherItemDetails.findBySellingDate", query = "SELECT u FROM UncommonVoucherItemDetails u WHERE u.sellingDate = :sellingDate")
    , @NamedQuery(name = "UncommonVoucherItemDetails.findByCatalogueDate", query = "SELECT u FROM UncommonVoucherItemDetails u WHERE u.catalogueDate = :catalogueDate")
    , @NamedQuery(name = "UncommonVoucherItemDetails.findBySpecialRemarks", query = "SELECT u FROM UncommonVoucherItemDetails u WHERE u.specialRemarks = :specialRemarks")
    , @NamedQuery(name = "UncommonVoucherItemDetails.findByLocation", query = "SELECT u FROM UncommonVoucherItemDetails u WHERE u.location = :location")
    , @NamedQuery(name = "UncommonVoucherItemDetails.findByIsRecatalogued", query = "SELECT u FROM UncommonVoucherItemDetails u WHERE u.isRecatalogued = :isRecatalogued")
    , @NamedQuery(name = "UncommonVoucherItemDetails.findBySaleNo", query = "SELECT u FROM UncommonVoucherItemDetails u WHERE u.saleNo = :saleNo")})
public class UncommonVoucherItemDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "lot_no")
    private String lotNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "min_value")
    private Double minValue;
    @Column(name = "max_value")
    private Double maxValue;
    @Column(name = "amended_value")
    private Double amendedValue;
    @Column(name = "sample_allownce")
    private Double sampleAllownce;
    @Column(name = "valuation_recieved_date")
    @Temporal(TemporalType.DATE)
    private Date valuationRecievedDate;
    @Column(name = "selling_date")
    @Temporal(TemporalType.DATE)
    private Date sellingDate;
    @Column(name = "catalogue_date")
    @Temporal(TemporalType.DATE)
    private Date catalogueDate;
    @Size(max = 450)
    @Column(name = "special_remarks")
    private String specialRemarks;
    @Size(max = 45)
    @Column(name = "location")
    private String location;
    @Column(name = "is_recatalogued")
    private Boolean isRecatalogued;
    @Size(max = 45)
    @Column(name = "sale_no")
    private String saleNo;
    @JoinColumn(name = "voucher_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VoucherItem voucherItemId;

    public UncommonVoucherItemDetails() {
    }

    public UncommonVoucherItemDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    public Double getAmendedValue() {
        return amendedValue;
    }

    public void setAmendedValue(Double amendedValue) {
        this.amendedValue = amendedValue;
    }

    public Double getSampleAllownce() {
        return sampleAllownce;
    }

    public void setSampleAllownce(Double sampleAllownce) {
        this.sampleAllownce = sampleAllownce;
    }

    public Date getValuationRecievedDate() {
        return valuationRecievedDate;
    }

    public void setValuationRecievedDate(Date valuationRecievedDate) {
        this.valuationRecievedDate = valuationRecievedDate;
    }

    public Date getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(Date sellingDate) {
        this.sellingDate = sellingDate;
    }

    public Date getCatalogueDate() {
        return catalogueDate;
    }

    public void setCatalogueDate(Date catalogueDate) {
        this.catalogueDate = catalogueDate;
    }

    public String getSpecialRemarks() {
        return specialRemarks;
    }

    public void setSpecialRemarks(String specialRemarks) {
        this.specialRemarks = specialRemarks;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getIsRecatalogued() {
        return isRecatalogued;
    }

    public void setIsRecatalogued(Boolean isRecatalogued) {
        this.isRecatalogued = isRecatalogued;
    }

    public String getSaleNo() {
        return saleNo;
    }

    public void setSaleNo(String saleNo) {
        this.saleNo = saleNo;
    }

    public VoucherItem getVoucherItemId() {
        return voucherItemId;
    }

    public void setVoucherItemId(VoucherItem voucherItemId) {
        this.voucherItemId = voucherItemId;
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
        if (!(object instanceof UncommonVoucherItemDetails)) {
            return false;
        }
        UncommonVoucherItemDetails other = (UncommonVoucherItemDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UncommonVoucherItemDetails[ id=" + id + " ]";
    }
    
}
