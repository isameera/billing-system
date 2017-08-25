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
@Table(name = "item_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemCategory.findAll", query = "SELECT i FROM ItemCategory i")
    , @NamedQuery(name = "ItemCategory.findById", query = "SELECT i FROM ItemCategory i WHERE i.id = :id")
    , @NamedQuery(name = "ItemCategory.findByName", query = "SELECT i FROM ItemCategory i WHERE i.name = :name")})
public class ItemCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 150)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemCategoryId")
    private Collection<ComItemRequest> comItemRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemCategoryId")
    private Collection<ItemMaster> itemMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemCategoryId")
    private Collection<SupplierItemManager> supplierItemManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemCategoryId")
    private Collection<OrgItem> orgItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemCategoryId")
    private Collection<OrgItemCategory> orgItemCategoryCollection;
    @OneToMany(mappedBy = "itemCategoryId")
    private Collection<ItemCategory> itemCategoryCollection;
    @JoinColumn(name = "item_category_id", referencedColumnName = "id")
    @ManyToOne
    private ItemCategory itemCategoryId;
    @JoinColumn(name = "item_class_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemClass itemClassId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemCategoryId")
    private Collection<ItemSubCategory> itemSubCategoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemCategoryId")
    private Collection<ItemCategoryTypeController> itemCategoryTypeControllerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemCategoryId")
    private Collection<JobItems> jobItemsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemCategoryId")
    private Collection<AssemblyItemManager> assemblyItemManagerCollection;

    public ItemCategory() {
    }

    public ItemCategory(Integer id) {
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

    @XmlTransient
    public Collection<ComItemRequest> getComItemRequestCollection() {
        return comItemRequestCollection;
    }

    public void setComItemRequestCollection(Collection<ComItemRequest> comItemRequestCollection) {
        this.comItemRequestCollection = comItemRequestCollection;
    }

    @XmlTransient
    public Collection<ItemMaster> getItemMasterCollection() {
        return itemMasterCollection;
    }

    public void setItemMasterCollection(Collection<ItemMaster> itemMasterCollection) {
        this.itemMasterCollection = itemMasterCollection;
    }

    @XmlTransient
    public Collection<SupplierItemManager> getSupplierItemManagerCollection() {
        return supplierItemManagerCollection;
    }

    public void setSupplierItemManagerCollection(Collection<SupplierItemManager> supplierItemManagerCollection) {
        this.supplierItemManagerCollection = supplierItemManagerCollection;
    }

    @XmlTransient
    public Collection<OrgItem> getOrgItemCollection() {
        return orgItemCollection;
    }

    public void setOrgItemCollection(Collection<OrgItem> orgItemCollection) {
        this.orgItemCollection = orgItemCollection;
    }

    @XmlTransient
    public Collection<OrgItemCategory> getOrgItemCategoryCollection() {
        return orgItemCategoryCollection;
    }

    public void setOrgItemCategoryCollection(Collection<OrgItemCategory> orgItemCategoryCollection) {
        this.orgItemCategoryCollection = orgItemCategoryCollection;
    }

    @XmlTransient
    public Collection<ItemCategory> getItemCategoryCollection() {
        return itemCategoryCollection;
    }

    public void setItemCategoryCollection(Collection<ItemCategory> itemCategoryCollection) {
        this.itemCategoryCollection = itemCategoryCollection;
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

    @XmlTransient
    public Collection<ItemSubCategory> getItemSubCategoryCollection() {
        return itemSubCategoryCollection;
    }

    public void setItemSubCategoryCollection(Collection<ItemSubCategory> itemSubCategoryCollection) {
        this.itemSubCategoryCollection = itemSubCategoryCollection;
    }

    @XmlTransient
    public Collection<ItemCategoryTypeController> getItemCategoryTypeControllerCollection() {
        return itemCategoryTypeControllerCollection;
    }

    public void setItemCategoryTypeControllerCollection(Collection<ItemCategoryTypeController> itemCategoryTypeControllerCollection) {
        this.itemCategoryTypeControllerCollection = itemCategoryTypeControllerCollection;
    }

    @XmlTransient
    public Collection<JobItems> getJobItemsCollection() {
        return jobItemsCollection;
    }

    public void setJobItemsCollection(Collection<JobItems> jobItemsCollection) {
        this.jobItemsCollection = jobItemsCollection;
    }

    @XmlTransient
    public Collection<AssemblyItemManager> getAssemblyItemManagerCollection() {
        return assemblyItemManagerCollection;
    }

    public void setAssemblyItemManagerCollection(Collection<AssemblyItemManager> assemblyItemManagerCollection) {
        this.assemblyItemManagerCollection = assemblyItemManagerCollection;
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
        if (!(object instanceof ItemCategory)) {
            return false;
        }
        ItemCategory other = (ItemCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ItemCategory[ id=" + id + " ]";
    }
    
}
