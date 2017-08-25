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
@Table(name = "factory_collected_leaf_by_route")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FactoryCollectedLeafByRoute.findAll", query = "SELECT f FROM FactoryCollectedLeafByRoute f")
    , @NamedQuery(name = "FactoryCollectedLeafByRoute.findById", query = "SELECT f FROM FactoryCollectedLeafByRoute f WHERE f.id = :id")})
public class FactoryCollectedLeafByRoute implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "factory_collected_leaf_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FactoryCollectedLeaf factoryCollectedLeafId;
    @JoinColumn(name = "leaf_collection_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LeafCollectionMaster leafCollectionMasterId;

    public FactoryCollectedLeafByRoute() {
    }

    public FactoryCollectedLeafByRoute(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FactoryCollectedLeaf getFactoryCollectedLeafId() {
        return factoryCollectedLeafId;
    }

    public void setFactoryCollectedLeafId(FactoryCollectedLeaf factoryCollectedLeafId) {
        this.factoryCollectedLeafId = factoryCollectedLeafId;
    }

    public LeafCollectionMaster getLeafCollectionMasterId() {
        return leafCollectionMasterId;
    }

    public void setLeafCollectionMasterId(LeafCollectionMaster leafCollectionMasterId) {
        this.leafCollectionMasterId = leafCollectionMasterId;
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
        if (!(object instanceof FactoryCollectedLeafByRoute)) {
            return false;
        }
        FactoryCollectedLeafByRoute other = (FactoryCollectedLeafByRoute) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.FactoryCollectedLeafByRoute[ id=" + id + " ]";
    }
    
}
