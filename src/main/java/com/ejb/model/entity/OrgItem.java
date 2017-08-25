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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "org_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrgItem.findAll", query = "SELECT o FROM OrgItem o")
    , @NamedQuery(name = "OrgItem.findById", query = "SELECT o FROM OrgItem o WHERE o.id = :id")
    , @NamedQuery(name = "OrgItem.findByReference", query = "SELECT o FROM OrgItem o WHERE o.reference = :reference")
    , @NamedQuery(name = "OrgItem.findByItemId", query = "SELECT o FROM OrgItem o WHERE o.itemId = :itemId")
    , @NamedQuery(name = "OrgItem.findByReorderLevel", query = "SELECT o FROM OrgItem o WHERE o.reorderLevel = :reorderLevel")
    , @NamedQuery(name = "OrgItem.findByMaxStock", query = "SELECT o FROM OrgItem o WHERE o.maxStock = :maxStock")
    , @NamedQuery(name = "OrgItem.findByMaterialCost", query = "SELECT o FROM OrgItem o WHERE o.materialCost = :materialCost")
    , @NamedQuery(name = "OrgItem.findByVatAmountEligibleForClaim", query = "SELECT o FROM OrgItem o WHERE o.vatAmountEligibleForClaim = :vatAmountEligibleForClaim")
    , @NamedQuery(name = "OrgItem.findBySellingPrice", query = "SELECT o FROM OrgItem o WHERE o.sellingPrice = :sellingPrice")
    , @NamedQuery(name = "OrgItem.findByWorrentyPeriod", query = "SELECT o FROM OrgItem o WHERE o.worrentyPeriod = :worrentyPeriod")})
public class OrgItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "reference")
    private Integer reference;
    @Size(max = 145)
    @Column(name = "item_id")
    private String itemId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "reorder_level")
    private Double reorderLevel;
    @Column(name = "max_stock")
    private Double maxStock;
    @Column(name = "material_cost")
    private Double materialCost;
    @Column(name = "vat_amount_eligible_for_claim")
    private Double vatAmountEligibleForClaim;
    @Column(name = "selling_price")
    private Double sellingPrice;
    @Column(name = "worrenty_period")
    private Integer worrentyPeriod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgItemId")
    private Collection<SupportVehicleModels> supportVehicleModelsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgItemId")
    private Collection<OrgItemLocation> orgItemLocationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgItemId")
    private Collection<MonthlyProductionPlan> monthlyProductionPlanCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgItemId")
    private Collection<SupplierItemManager> supplierItemManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgItemId")
    private Collection<ComRequestedItem> comRequestedItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgItemId")
    private Collection<ItemUomPrice> itemUomPriceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgItemId")
    private Collection<SellerItem> sellerItemCollection;
    @JoinColumn(name = "item_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemCategory itemCategoryId;
    @JoinColumn(name = "item_class_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemClass itemClassId;
    @JoinColumn(name = "item_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemMaster itemMasterId;
    @JoinColumn(name = "item_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemType itemTypeId;
    @JoinColumn(name = "universal_person_or_org_type_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgItemId")
    private Collection<OrgItemPurchsedDetail> orgItemPurchsedDetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgItemId")
    private Collection<UniversalBoughtleafItemRequestedItem> universalBoughtleafItemRequestedItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgItemId")
    private Collection<OrgItemLineManager> orgItemLineManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgItemId")
    private Collection<PriceLevel> priceLevelCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgItemId")
    private Collection<UniversalBoughtleafItemController> universalBoughtleafItemControllerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgItemId")
    private Collection<VoucherItem> voucherItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgItemId")
    private Collection<Course> courseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgItemId")
    private Collection<JobItems> jobItemsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgItemId")
    private Collection<DepreciationMaster> depreciationMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgItemRowId")
    private Collection<AssemblyItemManager> assemblyItemManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgItemFinischedId")
    private Collection<AssemblyItemManager> assemblyItemManagerCollection1;

    public OrgItem() {
    }

    public OrgItem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Double getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Double reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public Double getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Double maxStock) {
        this.maxStock = maxStock;
    }

    public Double getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(Double materialCost) {
        this.materialCost = materialCost;
    }

    public Double getVatAmountEligibleForClaim() {
        return vatAmountEligibleForClaim;
    }

    public void setVatAmountEligibleForClaim(Double vatAmountEligibleForClaim) {
        this.vatAmountEligibleForClaim = vatAmountEligibleForClaim;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Integer getWorrentyPeriod() {
        return worrentyPeriod;
    }

    public void setWorrentyPeriod(Integer worrentyPeriod) {
        this.worrentyPeriod = worrentyPeriod;
    }

    @XmlTransient
    public Collection<SupportVehicleModels> getSupportVehicleModelsCollection() {
        return supportVehicleModelsCollection;
    }

    public void setSupportVehicleModelsCollection(Collection<SupportVehicleModels> supportVehicleModelsCollection) {
        this.supportVehicleModelsCollection = supportVehicleModelsCollection;
    }

    @XmlTransient
    public Collection<OrgItemLocation> getOrgItemLocationCollection() {
        return orgItemLocationCollection;
    }

    public void setOrgItemLocationCollection(Collection<OrgItemLocation> orgItemLocationCollection) {
        this.orgItemLocationCollection = orgItemLocationCollection;
    }

    @XmlTransient
    public Collection<MonthlyProductionPlan> getMonthlyProductionPlanCollection() {
        return monthlyProductionPlanCollection;
    }

    public void setMonthlyProductionPlanCollection(Collection<MonthlyProductionPlan> monthlyProductionPlanCollection) {
        this.monthlyProductionPlanCollection = monthlyProductionPlanCollection;
    }

    @XmlTransient
    public Collection<SupplierItemManager> getSupplierItemManagerCollection() {
        return supplierItemManagerCollection;
    }

    public void setSupplierItemManagerCollection(Collection<SupplierItemManager> supplierItemManagerCollection) {
        this.supplierItemManagerCollection = supplierItemManagerCollection;
    }

    @XmlTransient
    public Collection<ComRequestedItem> getComRequestedItemCollection() {
        return comRequestedItemCollection;
    }

    public void setComRequestedItemCollection(Collection<ComRequestedItem> comRequestedItemCollection) {
        this.comRequestedItemCollection = comRequestedItemCollection;
    }

    @XmlTransient
    public Collection<ItemUomPrice> getItemUomPriceCollection() {
        return itemUomPriceCollection;
    }

    public void setItemUomPriceCollection(Collection<ItemUomPrice> itemUomPriceCollection) {
        this.itemUomPriceCollection = itemUomPriceCollection;
    }

    @XmlTransient
    public Collection<SellerItem> getSellerItemCollection() {
        return sellerItemCollection;
    }

    public void setSellerItemCollection(Collection<SellerItem> sellerItemCollection) {
        this.sellerItemCollection = sellerItemCollection;
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

    public ItemMaster getItemMasterId() {
        return itemMasterId;
    }

    public void setItemMasterId(ItemMaster itemMasterId) {
        this.itemMasterId = itemMasterId;
    }

    public ItemType getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(ItemType itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public UniversalPersonOrOrgTypeManager getUniversalPersonOrOrgTypeManagerId() {
        return universalPersonOrOrgTypeManagerId;
    }

    public void setUniversalPersonOrOrgTypeManagerId(UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId) {
        this.universalPersonOrOrgTypeManagerId = universalPersonOrOrgTypeManagerId;
    }

    @XmlTransient
    public Collection<OrgItemPurchsedDetail> getOrgItemPurchsedDetailCollection() {
        return orgItemPurchsedDetailCollection;
    }

    public void setOrgItemPurchsedDetailCollection(Collection<OrgItemPurchsedDetail> orgItemPurchsedDetailCollection) {
        this.orgItemPurchsedDetailCollection = orgItemPurchsedDetailCollection;
    }

    @XmlTransient
    public Collection<UniversalBoughtleafItemRequestedItem> getUniversalBoughtleafItemRequestedItemCollection() {
        return universalBoughtleafItemRequestedItemCollection;
    }

    public void setUniversalBoughtleafItemRequestedItemCollection(Collection<UniversalBoughtleafItemRequestedItem> universalBoughtleafItemRequestedItemCollection) {
        this.universalBoughtleafItemRequestedItemCollection = universalBoughtleafItemRequestedItemCollection;
    }

    @XmlTransient
    public Collection<OrgItemLineManager> getOrgItemLineManagerCollection() {
        return orgItemLineManagerCollection;
    }

    public void setOrgItemLineManagerCollection(Collection<OrgItemLineManager> orgItemLineManagerCollection) {
        this.orgItemLineManagerCollection = orgItemLineManagerCollection;
    }

    @XmlTransient
    public Collection<PriceLevel> getPriceLevelCollection() {
        return priceLevelCollection;
    }

    public void setPriceLevelCollection(Collection<PriceLevel> priceLevelCollection) {
        this.priceLevelCollection = priceLevelCollection;
    }

    @XmlTransient
    public Collection<UniversalBoughtleafItemController> getUniversalBoughtleafItemControllerCollection() {
        return universalBoughtleafItemControllerCollection;
    }

    public void setUniversalBoughtleafItemControllerCollection(Collection<UniversalBoughtleafItemController> universalBoughtleafItemControllerCollection) {
        this.universalBoughtleafItemControllerCollection = universalBoughtleafItemControllerCollection;
    }

    @XmlTransient
    public Collection<VoucherItem> getVoucherItemCollection() {
        return voucherItemCollection;
    }

    public void setVoucherItemCollection(Collection<VoucherItem> voucherItemCollection) {
        this.voucherItemCollection = voucherItemCollection;
    }

    @XmlTransient
    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    @XmlTransient
    public Collection<JobItems> getJobItemsCollection() {
        return jobItemsCollection;
    }

    public void setJobItemsCollection(Collection<JobItems> jobItemsCollection) {
        this.jobItemsCollection = jobItemsCollection;
    }

    @XmlTransient
    public Collection<DepreciationMaster> getDepreciationMasterCollection() {
        return depreciationMasterCollection;
    }

    public void setDepreciationMasterCollection(Collection<DepreciationMaster> depreciationMasterCollection) {
        this.depreciationMasterCollection = depreciationMasterCollection;
    }

    @XmlTransient
    public Collection<AssemblyItemManager> getAssemblyItemManagerCollection() {
        return assemblyItemManagerCollection;
    }

    public void setAssemblyItemManagerCollection(Collection<AssemblyItemManager> assemblyItemManagerCollection) {
        this.assemblyItemManagerCollection = assemblyItemManagerCollection;
    }

    @XmlTransient
    public Collection<AssemblyItemManager> getAssemblyItemManagerCollection1() {
        return assemblyItemManagerCollection1;
    }

    public void setAssemblyItemManagerCollection1(Collection<AssemblyItemManager> assemblyItemManagerCollection1) {
        this.assemblyItemManagerCollection1 = assemblyItemManagerCollection1;
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
        if (!(object instanceof OrgItem)) {
            return false;
        }
        OrgItem other = (OrgItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.OrgItem[ id=" + id + " ]";
    }
    
}
