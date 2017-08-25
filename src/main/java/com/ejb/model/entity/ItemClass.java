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
@Table(name = "item_class")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemClass.findAll", query = "SELECT i FROM ItemClass i")
    , @NamedQuery(name = "ItemClass.findById", query = "SELECT i FROM ItemClass i WHERE i.id = :id")
    , @NamedQuery(name = "ItemClass.findByName", query = "SELECT i FROM ItemClass i WHERE i.name = :name")})
public class ItemClass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 150)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemClassId")
    private Collection<OrgItemClass> orgItemClassCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemClassId")
    private Collection<ItemMaster> itemMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemClassId")
    private Collection<ItemClassTypeController> itemClassTypeControllerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemClassId")
    private Collection<SupplierItemManager> supplierItemManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemClassId")
    private Collection<OrgItem> orgItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemClassId")
    private Collection<ItemCategory> itemCategoryCollection;

    public ItemClass() {
    }

    public ItemClass(Integer id) {
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
    public Collection<OrgItemClass> getOrgItemClassCollection() {
        return orgItemClassCollection;
    }

    public void setOrgItemClassCollection(Collection<OrgItemClass> orgItemClassCollection) {
        this.orgItemClassCollection = orgItemClassCollection;
    }

    @XmlTransient
    public Collection<ItemMaster> getItemMasterCollection() {
        return itemMasterCollection;
    }

    public void setItemMasterCollection(Collection<ItemMaster> itemMasterCollection) {
        this.itemMasterCollection = itemMasterCollection;
    }

    @XmlTransient
    public Collection<ItemClassTypeController> getItemClassTypeControllerCollection() {
        return itemClassTypeControllerCollection;
    }

    public void setItemClassTypeControllerCollection(Collection<ItemClassTypeController> itemClassTypeControllerCollection) {
        this.itemClassTypeControllerCollection = itemClassTypeControllerCollection;
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
    public Collection<ItemCategory> getItemCategoryCollection() {
        return itemCategoryCollection;
    }

    public void setItemCategoryCollection(Collection<ItemCategory> itemCategoryCollection) {
        this.itemCategoryCollection = itemCategoryCollection;
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
        if (!(object instanceof ItemClass)) {
            return false;
        }
        ItemClass other = (ItemClass) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ItemClass[ id=" + id + " ]";
    }
    
}
