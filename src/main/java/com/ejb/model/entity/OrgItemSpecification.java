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
@Table(name = "org_item_specification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrgItemSpecification.findAll", query = "SELECT o FROM OrgItemSpecification o")
    , @NamedQuery(name = "OrgItemSpecification.findById", query = "SELECT o FROM OrgItemSpecification o WHERE o.id = :id")})
public class OrgItemSpecification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "item_specification_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemSpecificationManager itemSpecificationManagerId;
    @JoinColumn(name = "supplier_item_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierItemManager supplierItemManagerId;

    public OrgItemSpecification() {
    }

    public OrgItemSpecification(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ItemSpecificationManager getItemSpecificationManagerId() {
        return itemSpecificationManagerId;
    }

    public void setItemSpecificationManagerId(ItemSpecificationManager itemSpecificationManagerId) {
        this.itemSpecificationManagerId = itemSpecificationManagerId;
    }

    public SupplierItemManager getSupplierItemManagerId() {
        return supplierItemManagerId;
    }

    public void setSupplierItemManagerId(SupplierItemManager supplierItemManagerId) {
        this.supplierItemManagerId = supplierItemManagerId;
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
        if (!(object instanceof OrgItemSpecification)) {
            return false;
        }
        OrgItemSpecification other = (OrgItemSpecification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.OrgItemSpecification[ id=" + id + " ]";
    }
    
}
