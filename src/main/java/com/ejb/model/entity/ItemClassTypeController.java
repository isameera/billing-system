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
@Table(name = "item_class_type_controller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemClassTypeController.findAll", query = "SELECT i FROM ItemClassTypeController i")
    , @NamedQuery(name = "ItemClassTypeController.findById", query = "SELECT i FROM ItemClassTypeController i WHERE i.id = :id")})
public class ItemClassTypeController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "item_class_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemClass itemClassId;
    @JoinColumn(name = "item_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemType itemTypeId;

    public ItemClassTypeController() {
    }

    public ItemClassTypeController(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ItemClass getItemClassId() {
        return itemClassId;
    }

    public void setItemClassId(ItemClass itemClassId) {
        this.itemClassId = itemClassId;
    }

    public ItemType getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(ItemType itemTypeId) {
        this.itemTypeId = itemTypeId;
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
        if (!(object instanceof ItemClassTypeController)) {
            return false;
        }
        ItemClassTypeController other = (ItemClassTypeController) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ItemClassTypeController[ id=" + id + " ]";
    }
    
}
