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
@Table(name = "leaf_package_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LeafPackageType.findAll", query = "SELECT l FROM LeafPackageType l")
    , @NamedQuery(name = "LeafPackageType.findById", query = "SELECT l FROM LeafPackageType l WHERE l.id = :id")
    , @NamedQuery(name = "LeafPackageType.findByName", query = "SELECT l FROM LeafPackageType l WHERE l.name = :name")})
public class LeafPackageType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leafPackageTypeId")
    private Collection<LeafPackgeWeight> leafPackgeWeightCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leafPackageTypeId")
    private Collection<RouteCollectedLeafController> routeCollectedLeafControllerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leafPackageTypeId")
    private Collection<LeafCollectionCommon> leafCollectionCommonCollection;

    public LeafPackageType() {
    }

    public LeafPackageType(Integer id) {
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
    public Collection<LeafPackgeWeight> getLeafPackgeWeightCollection() {
        return leafPackgeWeightCollection;
    }

    public void setLeafPackgeWeightCollection(Collection<LeafPackgeWeight> leafPackgeWeightCollection) {
        this.leafPackgeWeightCollection = leafPackgeWeightCollection;
    }

    @XmlTransient
    public Collection<RouteCollectedLeafController> getRouteCollectedLeafControllerCollection() {
        return routeCollectedLeafControllerCollection;
    }

    public void setRouteCollectedLeafControllerCollection(Collection<RouteCollectedLeafController> routeCollectedLeafControllerCollection) {
        this.routeCollectedLeafControllerCollection = routeCollectedLeafControllerCollection;
    }

    @XmlTransient
    public Collection<LeafCollectionCommon> getLeafCollectionCommonCollection() {
        return leafCollectionCommonCollection;
    }

    public void setLeafCollectionCommonCollection(Collection<LeafCollectionCommon> leafCollectionCommonCollection) {
        this.leafCollectionCommonCollection = leafCollectionCommonCollection;
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
        if (!(object instanceof LeafPackageType)) {
            return false;
        }
        LeafPackageType other = (LeafPackageType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.LeafPackageType[ id=" + id + " ]";
    }
    
}
