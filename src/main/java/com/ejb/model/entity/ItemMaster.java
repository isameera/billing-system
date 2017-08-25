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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "item_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemMaster.findAll", query = "SELECT i FROM ItemMaster i")
    , @NamedQuery(name = "ItemMaster.findById", query = "SELECT i FROM ItemMaster i WHERE i.id = :id")
    , @NamedQuery(name = "ItemMaster.findByName", query = "SELECT i FROM ItemMaster i WHERE i.name = :name")
    , @NamedQuery(name = "ItemMaster.findByImage", query = "SELECT i FROM ItemMaster i WHERE i.image = :image")})
public class ItemMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2000)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Size(max = 45)
    @Column(name = "image")
    private String image;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemMasterId")
    private Collection<InventoryController> inventoryControllerCollection;
    @JoinColumn(name = "item_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemCategory itemCategoryId;
    @JoinColumn(name = "item_class_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemClass itemClassId;
    @JoinColumn(name = "item_model_id", referencedColumnName = "id")
    @ManyToOne
    private ItemModel itemModelId;
    @JoinColumn(name = "item_sub_category_id", referencedColumnName = "id")
    @ManyToOne
    private ItemSubCategory itemSubCategoryId;
    @JoinColumn(name = "item_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemType itemTypeId;
    @JoinColumn(name = "unit_of_measure_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UnitOfMeasure unitOfMeasureId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemMasterId")
    private Collection<ItemPackaging> itemPackagingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemMasterId")
    private Collection<TeaFactoryItemInstallment> teaFactoryItemInstallmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemMasterId")
    private Collection<SpecificationTypeManager> specificationTypeManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemMasterId")
    private Collection<OrgItem> orgItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemMasterId")
    private Collection<OrderProduct> orderProductCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private Collection<TaxTypeProductManager> taxTypeProductManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemMasterId")
    private Collection<UniversalItemQtyManager> universalItemQtyManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemMasterId")
    private Collection<ItemSpecificationManager> itemSpecificationManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemMasterId")
    private Collection<ItemGradingRegistration> itemGradingRegistrationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemMasterId")
    private Collection<ProductBatchManager> productBatchManagerCollection;

    public ItemMaster() {
    }

    public ItemMaster(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public Collection<InventoryController> getInventoryControllerCollection() {
        return inventoryControllerCollection;
    }

    public void setInventoryControllerCollection(Collection<InventoryController> inventoryControllerCollection) {
        this.inventoryControllerCollection = inventoryControllerCollection;
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

    public ItemModel getItemModelId() {
        return itemModelId;
    }

    public void setItemModelId(ItemModel itemModelId) {
        this.itemModelId = itemModelId;
    }

    public ItemSubCategory getItemSubCategoryId() {
        return itemSubCategoryId;
    }

    public void setItemSubCategoryId(ItemSubCategory itemSubCategoryId) {
        this.itemSubCategoryId = itemSubCategoryId;
    }

    public ItemType getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(ItemType itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public UnitOfMeasure getUnitOfMeasureId() {
        return unitOfMeasureId;
    }

    public void setUnitOfMeasureId(UnitOfMeasure unitOfMeasureId) {
        this.unitOfMeasureId = unitOfMeasureId;
    }

    @XmlTransient
    public Collection<ItemPackaging> getItemPackagingCollection() {
        return itemPackagingCollection;
    }

    public void setItemPackagingCollection(Collection<ItemPackaging> itemPackagingCollection) {
        this.itemPackagingCollection = itemPackagingCollection;
    }

    @XmlTransient
    public Collection<TeaFactoryItemInstallment> getTeaFactoryItemInstallmentCollection() {
        return teaFactoryItemInstallmentCollection;
    }

    public void setTeaFactoryItemInstallmentCollection(Collection<TeaFactoryItemInstallment> teaFactoryItemInstallmentCollection) {
        this.teaFactoryItemInstallmentCollection = teaFactoryItemInstallmentCollection;
    }

    @XmlTransient
    public Collection<SpecificationTypeManager> getSpecificationTypeManagerCollection() {
        return specificationTypeManagerCollection;
    }

    public void setSpecificationTypeManagerCollection(Collection<SpecificationTypeManager> specificationTypeManagerCollection) {
        this.specificationTypeManagerCollection = specificationTypeManagerCollection;
    }

    @XmlTransient
    public Collection<OrgItem> getOrgItemCollection() {
        return orgItemCollection;
    }

    public void setOrgItemCollection(Collection<OrgItem> orgItemCollection) {
        this.orgItemCollection = orgItemCollection;
    }

    @XmlTransient
    public Collection<OrderProduct> getOrderProductCollection() {
        return orderProductCollection;
    }

    public void setOrderProductCollection(Collection<OrderProduct> orderProductCollection) {
        this.orderProductCollection = orderProductCollection;
    }

    @XmlTransient
    public Collection<TaxTypeProductManager> getTaxTypeProductManagerCollection() {
        return taxTypeProductManagerCollection;
    }

    public void setTaxTypeProductManagerCollection(Collection<TaxTypeProductManager> taxTypeProductManagerCollection) {
        this.taxTypeProductManagerCollection = taxTypeProductManagerCollection;
    }

    @XmlTransient
    public Collection<UniversalItemQtyManager> getUniversalItemQtyManagerCollection() {
        return universalItemQtyManagerCollection;
    }

    public void setUniversalItemQtyManagerCollection(Collection<UniversalItemQtyManager> universalItemQtyManagerCollection) {
        this.universalItemQtyManagerCollection = universalItemQtyManagerCollection;
    }

    @XmlTransient
    public Collection<ItemSpecificationManager> getItemSpecificationManagerCollection() {
        return itemSpecificationManagerCollection;
    }

    public void setItemSpecificationManagerCollection(Collection<ItemSpecificationManager> itemSpecificationManagerCollection) {
        this.itemSpecificationManagerCollection = itemSpecificationManagerCollection;
    }

    @XmlTransient
    public Collection<ItemGradingRegistration> getItemGradingRegistrationCollection() {
        return itemGradingRegistrationCollection;
    }

    public void setItemGradingRegistrationCollection(Collection<ItemGradingRegistration> itemGradingRegistrationCollection) {
        this.itemGradingRegistrationCollection = itemGradingRegistrationCollection;
    }

    @XmlTransient
    public Collection<ProductBatchManager> getProductBatchManagerCollection() {
        return productBatchManagerCollection;
    }

    public void setProductBatchManagerCollection(Collection<ProductBatchManager> productBatchManagerCollection) {
        this.productBatchManagerCollection = productBatchManagerCollection;
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
        if (!(object instanceof ItemMaster)) {
            return false;
        }
        ItemMaster other = (ItemMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ItemMaster[ id=" + id + " ]";
    }
    
}
