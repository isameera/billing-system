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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "route_collected_leaf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RouteCollectedLeaf.findAll", query = "SELECT r FROM RouteCollectedLeaf r")
    , @NamedQuery(name = "RouteCollectedLeaf.findById", query = "SELECT r FROM RouteCollectedLeaf r WHERE r.id = :id")
    , @NamedQuery(name = "RouteCollectedLeaf.findByVoucherId", query = "SELECT r FROM RouteCollectedLeaf r WHERE r.voucherId = :voucherId")
    , @NamedQuery(name = "RouteCollectedLeaf.findByIsRemoved", query = "SELECT r FROM RouteCollectedLeaf r WHERE r.isRemoved = :isRemoved")})
public class RouteCollectedLeaf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "voucher_id")
    private int voucherId;
    @Column(name = "is_removed")
    private Integer isRemoved;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeCollectedLeafId")
    private Collection<RouteCollectedLeafRemovedLog> routeCollectedLeafRemovedLogCollection;
    @JoinColumn(name = "leaf_collection_common_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LeafCollectionCommon leafCollectionCommonId;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierRegistration supplierRegistrationId;
    @JoinColumn(name = "leaf_collection_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LeafCollectionMaster leafCollectionMasterId;
    @JoinColumn(name = "supplier_passbook_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierPassbook supplierPassbookId;

    public RouteCollectedLeaf() {
    }

    public RouteCollectedLeaf(Integer id) {
        this.id = id;
    }

    public RouteCollectedLeaf(Integer id, int voucherId) {
        this.id = id;
        this.voucherId = voucherId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    public Integer getIsRemoved() {
        return isRemoved;
    }

    public void setIsRemoved(Integer isRemoved) {
        this.isRemoved = isRemoved;
    }

    @XmlTransient
    public Collection<RouteCollectedLeafRemovedLog> getRouteCollectedLeafRemovedLogCollection() {
        return routeCollectedLeafRemovedLogCollection;
    }

    public void setRouteCollectedLeafRemovedLogCollection(Collection<RouteCollectedLeafRemovedLog> routeCollectedLeafRemovedLogCollection) {
        this.routeCollectedLeafRemovedLogCollection = routeCollectedLeafRemovedLogCollection;
    }

    public LeafCollectionCommon getLeafCollectionCommonId() {
        return leafCollectionCommonId;
    }

    public void setLeafCollectionCommonId(LeafCollectionCommon leafCollectionCommonId) {
        this.leafCollectionCommonId = leafCollectionCommonId;
    }

    public SupplierRegistration getSupplierRegistrationId() {
        return supplierRegistrationId;
    }

    public void setSupplierRegistrationId(SupplierRegistration supplierRegistrationId) {
        this.supplierRegistrationId = supplierRegistrationId;
    }

    public LeafCollectionMaster getLeafCollectionMasterId() {
        return leafCollectionMasterId;
    }

    public void setLeafCollectionMasterId(LeafCollectionMaster leafCollectionMasterId) {
        this.leafCollectionMasterId = leafCollectionMasterId;
    }

    public SupplierPassbook getSupplierPassbookId() {
        return supplierPassbookId;
    }

    public void setSupplierPassbookId(SupplierPassbook supplierPassbookId) {
        this.supplierPassbookId = supplierPassbookId;
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
        if (!(object instanceof RouteCollectedLeaf)) {
            return false;
        }
        RouteCollectedLeaf other = (RouteCollectedLeaf) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.RouteCollectedLeaf[ id=" + id + " ]";
    }
    
}
