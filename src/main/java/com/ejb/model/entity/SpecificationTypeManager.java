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
@Table(name = "specification_type_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpecificationTypeManager.findAll", query = "SELECT s FROM SpecificationTypeManager s")
    , @NamedQuery(name = "SpecificationTypeManager.findById", query = "SELECT s FROM SpecificationTypeManager s WHERE s.id = :id")})
public class SpecificationTypeManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "item_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemMaster itemMasterId;
    @JoinColumn(name = "specification_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SpecificationType specificationTypeId;

    public SpecificationTypeManager() {
    }

    public SpecificationTypeManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ItemMaster getItemMasterId() {
        return itemMasterId;
    }

    public void setItemMasterId(ItemMaster itemMasterId) {
        this.itemMasterId = itemMasterId;
    }

    public SpecificationType getSpecificationTypeId() {
        return specificationTypeId;
    }

    public void setSpecificationTypeId(SpecificationType specificationTypeId) {
        this.specificationTypeId = specificationTypeId;
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
        if (!(object instanceof SpecificationTypeManager)) {
            return false;
        }
        SpecificationTypeManager other = (SpecificationTypeManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SpecificationTypeManager[ id=" + id + " ]";
    }
    
}
