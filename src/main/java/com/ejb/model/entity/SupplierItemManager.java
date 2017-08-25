/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "supplier_item_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierItemManager.findAll", query = "SELECT s FROM SupplierItemManager s")
    , @NamedQuery(name = "SupplierItemManager.findById", query = "SELECT s FROM SupplierItemManager s WHERE s.id = :id")
    , @NamedQuery(name = "SupplierItemManager.findByQty", query = "SELECT s FROM SupplierItemManager s WHERE s.qty = :qty")
    , @NamedQuery(name = "SupplierItemManager.findByQtyRecived", query = "SELECT s FROM SupplierItemManager s WHERE s.qtyRecived = :qtyRecived")
    , @NamedQuery(name = "SupplierItemManager.findByQtyIssued", query = "SELECT s FROM SupplierItemManager s WHERE s.qtyIssued = :qtyIssued")
    , @NamedQuery(name = "SupplierItemManager.findByQtyReturn", query = "SELECT s FROM SupplierItemManager s WHERE s.qtyReturn = :qtyReturn")
    , @NamedQuery(name = "SupplierItemManager.findBySellingPrice", query = "SELECT s FROM SupplierItemManager s WHERE s.sellingPrice = :sellingPrice")
    , @NamedQuery(name = "SupplierItemManager.findByIsActive", query = "SELECT s FROM SupplierItemManager s WHERE s.isActive = :isActive")
    , @NamedQuery(name = "SupplierItemManager.findByPurchasingPrice", query = "SELECT s FROM SupplierItemManager s WHERE s.purchasingPrice = :purchasingPrice")})
public class SupplierItemManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qty")
    private Double qty;
    @Column(name = "qty_recived")
    private Double qtyRecived;
    @Column(name = "qty_issued")
    private Double qtyIssued;
    @Column(name = "qty_return")
    private Double qtyReturn;
    @Column(name = "selling_price")
    private Double sellingPrice;
    @Column(name = "is_active")
    private Integer isActive;
    @Column(name = "purchasing_price")
    private Double purchasingPrice;
    @JoinColumn(name = "item_supplier_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemSupplier itemSupplierId;
    @JoinColumn(name = "item_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemCategory itemCategoryId;
    @JoinColumn(name = "item_class_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemClass itemClassId;
    @JoinColumn(name = "org_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrgItem orgItemId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierItemManagerId")
    private Collection<OrgItemSpecification> orgItemSpecificationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierItemManagerId")
    private Collection<SupplierItemManagerBatch> supplierItemManagerBatchCollection;

    public SupplierItemManager() {
    }

    public SupplierItemManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getQtyRecived() {
        return qtyRecived;
    }

    public void setQtyRecived(Double qtyRecived) {
        this.qtyRecived = qtyRecived;
    }

    public Double getQtyIssued() {
        return qtyIssued;
    }

    public void setQtyIssued(Double qtyIssued) {
        this.qtyIssued = qtyIssued;
    }

    public Double getQtyReturn() {
        return qtyReturn;
    }

    public void setQtyReturn(Double qtyReturn) {
        this.qtyReturn = qtyReturn;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Double getPurchasingPrice() {
        return purchasingPrice;
    }

    public void setPurchasingPrice(Double purchasingPrice) {
        this.purchasingPrice = purchasingPrice;
    }

    public ItemSupplier getItemSupplierId() {
        return itemSupplierId;
    }

    public void setItemSupplierId(ItemSupplier itemSupplierId) {
        this.itemSupplierId = itemSupplierId;
    }

    public ItemCategory getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(ItemCategory itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    public ItemClass getItemClassId() {
        return itemClassId;
    }

    public void setItemClassId(ItemClass itemClassId) {
        this.itemClassId = itemClassId;
    }

    public OrgItem getOrgItemId() {
        return orgItemId;
    }

    public void setOrgItemId(OrgItem orgItemId) {
        this.orgItemId = orgItemId;
    }

    @XmlTransient
    public Collection<OrgItemSpecification> getOrgItemSpecificationCollection() {
        return orgItemSpecificationCollection;
    }

    public void setOrgItemSpecificationCollection(Collection<OrgItemSpecification> orgItemSpecificationCollection) {
        this.orgItemSpecificationCollection = orgItemSpecificationCollection;
    }

    @XmlTransient
    public Collection<SupplierItemManagerBatch> getSupplierItemManagerBatchCollection() {
        return supplierItemManagerBatchCollection;
    }

    public void setSupplierItemManagerBatchCollection(Collection<SupplierItemManagerBatch> supplierItemManagerBatchCollection) {
        this.supplierItemManagerBatchCollection = supplierItemManagerBatchCollection;
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
        if (!(object instanceof SupplierItemManager)) {
            return false;
        }
        SupplierItemManager other = (SupplierItemManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierItemManager[ id=" + id + " ]";
    }
    
}
