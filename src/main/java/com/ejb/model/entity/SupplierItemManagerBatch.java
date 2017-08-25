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
@Table(name = "supplier_item_manager_batch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierItemManagerBatch.findAll", query = "SELECT s FROM SupplierItemManagerBatch s")
    , @NamedQuery(name = "SupplierItemManagerBatch.findById", query = "SELECT s FROM SupplierItemManagerBatch s WHERE s.id = :id")
    , @NamedQuery(name = "SupplierItemManagerBatch.findByBatchNo", query = "SELECT s FROM SupplierItemManagerBatch s WHERE s.batchNo = :batchNo")
    , @NamedQuery(name = "SupplierItemManagerBatch.findByReceivedDate", query = "SELECT s FROM SupplierItemManagerBatch s WHERE s.receivedDate = :receivedDate")
    , @NamedQuery(name = "SupplierItemManagerBatch.findByReceivedQty", query = "SELECT s FROM SupplierItemManagerBatch s WHERE s.receivedQty = :receivedQty")
    , @NamedQuery(name = "SupplierItemManagerBatch.findByIssuedQty", query = "SELECT s FROM SupplierItemManagerBatch s WHERE s.issuedQty = :issuedQty")
    , @NamedQuery(name = "SupplierItemManagerBatch.findByBalanceQty", query = "SELECT s FROM SupplierItemManagerBatch s WHERE s.balanceQty = :balanceQty")
    , @NamedQuery(name = "SupplierItemManagerBatch.findByUnitPrice", query = "SELECT s FROM SupplierItemManagerBatch s WHERE s.unitPrice = :unitPrice")
    , @NamedQuery(name = "SupplierItemManagerBatch.findBySellingPrice", query = "SELECT s FROM SupplierItemManagerBatch s WHERE s.sellingPrice = :sellingPrice")})
public class SupplierItemManagerBatch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "batch_no")
    private String batchNo;
    @Column(name = "received_date")
    @Temporal(TemporalType.DATE)
    private Date receivedDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "received_qty")
    private Double receivedQty;
    @Column(name = "issued_qty")
    private Double issuedQty;
    @Column(name = "balance_qty")
    private Double balanceQty;
    @Column(name = "unit_price")
    private Double unitPrice;
    @Column(name = "selling_price")
    private Double sellingPrice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierItemManagerBatchId")
    private Collection<SupplierItemManagerBatchVoucherItems> supplierItemManagerBatchVoucherItemsCollection;
    @JoinColumn(name = "supplier_item_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierItemManager supplierItemManagerId;
    @JoinColumn(name = "voucher_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Voucher voucherId;

    public SupplierItemManagerBatch() {
    }

    public SupplierItemManagerBatch(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Double getReceivedQty() {
        return receivedQty;
    }

    public void setReceivedQty(Double receivedQty) {
        this.receivedQty = receivedQty;
    }

    public Double getIssuedQty() {
        return issuedQty;
    }

    public void setIssuedQty(Double issuedQty) {
        this.issuedQty = issuedQty;
    }

    public Double getBalanceQty() {
        return balanceQty;
    }

    public void setBalanceQty(Double balanceQty) {
        this.balanceQty = balanceQty;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    @XmlTransient
    public Collection<SupplierItemManagerBatchVoucherItems> getSupplierItemManagerBatchVoucherItemsCollection() {
        return supplierItemManagerBatchVoucherItemsCollection;
    }

    public void setSupplierItemManagerBatchVoucherItemsCollection(Collection<SupplierItemManagerBatchVoucherItems> supplierItemManagerBatchVoucherItemsCollection) {
        this.supplierItemManagerBatchVoucherItemsCollection = supplierItemManagerBatchVoucherItemsCollection;
    }

    public SupplierItemManager getSupplierItemManagerId() {
        return supplierItemManagerId;
    }

    public void setSupplierItemManagerId(SupplierItemManager supplierItemManagerId) {
        this.supplierItemManagerId = supplierItemManagerId;
    }

    public Voucher getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Voucher voucherId) {
        this.voucherId = voucherId;
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
        if (!(object instanceof SupplierItemManagerBatch)) {
            return false;
        }
        SupplierItemManagerBatch other = (SupplierItemManagerBatch) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierItemManagerBatch[ id=" + id + " ]";
    }
    
}
