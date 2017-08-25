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
@Table(name = "item_supplier_types")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemSupplierTypes.findAll", query = "SELECT i FROM ItemSupplierTypes i")
    , @NamedQuery(name = "ItemSupplierTypes.findById", query = "SELECT i FROM ItemSupplierTypes i WHERE i.id = :id")})
public class ItemSupplierTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "item_supplier_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemSupplier itemSupplierId;
    @JoinColumn(name = "item_supplier_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemSupplierType itemSupplierTypeId;

    public ItemSupplierTypes() {
    }

    public ItemSupplierTypes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ItemSupplier getItemSupplierId() {
        return itemSupplierId;
    }

    public void setItemSupplierId(ItemSupplier itemSupplierId) {
        this.itemSupplierId = itemSupplierId;
    }

    public ItemSupplierType getItemSupplierTypeId() {
        return itemSupplierTypeId;
    }

    public void setItemSupplierTypeId(ItemSupplierType itemSupplierTypeId) {
        this.itemSupplierTypeId = itemSupplierTypeId;
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
        if (!(object instanceof ItemSupplierTypes)) {
            return false;
        }
        ItemSupplierTypes other = (ItemSupplierTypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ItemSupplierTypes[ id=" + id + " ]";
    }
    
}
