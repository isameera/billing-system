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
@Table(name = "supplier_item_manager_batch_voucher_items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierItemManagerBatchVoucherItems.findAll", query = "SELECT s FROM SupplierItemManagerBatchVoucherItems s")
    , @NamedQuery(name = "SupplierItemManagerBatchVoucherItems.findById", query = "SELECT s FROM SupplierItemManagerBatchVoucherItems s WHERE s.id = :id")})
public class SupplierItemManagerBatchVoucherItems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "supplier_item_manager_batch_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierItemManagerBatch supplierItemManagerBatchId;
    @JoinColumn(name = "voucher_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VoucherItem voucherItemId;

    public SupplierItemManagerBatchVoucherItems() {
    }

    public SupplierItemManagerBatchVoucherItems(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SupplierItemManagerBatch getSupplierItemManagerBatchId() {
        return supplierItemManagerBatchId;
    }

    public void setSupplierItemManagerBatchId(SupplierItemManagerBatch supplierItemManagerBatchId) {
        this.supplierItemManagerBatchId = supplierItemManagerBatchId;
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
        if (!(object instanceof SupplierItemManagerBatchVoucherItems)) {
            return false;
        }
        SupplierItemManagerBatchVoucherItems other = (SupplierItemManagerBatchVoucherItems) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierItemManagerBatchVoucherItems[ id=" + id + " ]";
    }
    
}
