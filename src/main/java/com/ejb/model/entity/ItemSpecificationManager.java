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
@Table(name = "item_specification_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemSpecificationManager.findAll", query = "SELECT i FROM ItemSpecificationManager i")
    , @NamedQuery(name = "ItemSpecificationManager.findById", query = "SELECT i FROM ItemSpecificationManager i WHERE i.id = :id")
    , @NamedQuery(name = "ItemSpecificationManager.findByValue", query = "SELECT i FROM ItemSpecificationManager i WHERE i.value = :value")})
public class ItemSpecificationManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "value")
    private String value;
    @JoinColumn(name = "item_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemMaster itemMasterId;
    @JoinColumn(name = "specification_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Specification specificationId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemSpecificationManagerId")
    private Collection<OrgItemSpecification> orgItemSpecificationCollection;

    public ItemSpecificationManager() {
    }

    public ItemSpecificationManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ItemMaster getItemMasterId() {
        return itemMasterId;
    }

    public void setItemMasterId(ItemMaster itemMasterId) {
        this.itemMasterId = itemMasterId;
    }

    public Specification getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Specification specificationId) {
        this.specificationId = specificationId;
    }

    @XmlTransient
    public Collection<OrgItemSpecification> getOrgItemSpecificationCollection() {
        return orgItemSpecificationCollection;
    }

    public void setOrgItemSpecificationCollection(Collection<OrgItemSpecification> orgItemSpecificationCollection) {
        this.orgItemSpecificationCollection = orgItemSpecificationCollection;
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
        if (!(object instanceof ItemSpecificationManager)) {
            return false;
        }
        ItemSpecificationManager other = (ItemSpecificationManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ItemSpecificationManager[ id=" + id + " ]";
    }
    
}
