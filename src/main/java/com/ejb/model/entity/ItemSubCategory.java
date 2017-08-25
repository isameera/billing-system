/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "item_sub_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemSubCategory.findAll", query = "SELECT i FROM ItemSubCategory i")
    , @NamedQuery(name = "ItemSubCategory.findById", query = "SELECT i FROM ItemSubCategory i WHERE i.id = :id")
    , @NamedQuery(name = "ItemSubCategory.findByName", query = "SELECT i FROM ItemSubCategory i WHERE i.name = :name")})
public class ItemSubCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 145)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "itemSubCategoryId")
    private Collection<ItemMaster> itemMasterCollection;
    @JoinColumn(name = "item_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemCategory itemCategoryId;

    public ItemSubCategory() {
    }

    public ItemSubCategory(Integer id) {
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
    public Collection<ItemMaster> getItemMasterCollection() {
        return itemMasterCollection;
    }

    public void setItemMasterCollection(Collection<ItemMaster> itemMasterCollection) {
        this.itemMasterCollection = itemMasterCollection;
    }

    public ItemCategory getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(ItemCategory itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
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
        if (!(object instanceof ItemSubCategory)) {
            return false;
        }
        ItemSubCategory other = (ItemSubCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ItemSubCategory[ id=" + id + " ]";
    }
    
}
