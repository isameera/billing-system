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
@Table(name = "route_employee_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RouteEmployeeType.findAll", query = "SELECT r FROM RouteEmployeeType r")
    , @NamedQuery(name = "RouteEmployeeType.findById", query = "SELECT r FROM RouteEmployeeType r WHERE r.id = :id")
    , @NamedQuery(name = "RouteEmployeeType.findByName", query = "SELECT r FROM RouteEmployeeType r WHERE r.name = :name")})
public class RouteEmployeeType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeEmployeeTypeOfficer")
    private Collection<LeafCollectionMaster> leafCollectionMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeEmployeeTypeHelper")
    private Collection<LeafCollectionMaster> leafCollectionMasterCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeEmployeeTypeId")
    private Collection<RouteEmployee> routeEmployeeCollection;

    public RouteEmployeeType() {
    }

    public RouteEmployeeType(Integer id) {
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
    public Collection<LeafCollectionMaster> getLeafCollectionMasterCollection() {
        return leafCollectionMasterCollection;
    }

    public void setLeafCollectionMasterCollection(Collection<LeafCollectionMaster> leafCollectionMasterCollection) {
        this.leafCollectionMasterCollection = leafCollectionMasterCollection;
    }

    @XmlTransient
    public Collection<LeafCollectionMaster> getLeafCollectionMasterCollection1() {
        return leafCollectionMasterCollection1;
    }

    public void setLeafCollectionMasterCollection1(Collection<LeafCollectionMaster> leafCollectionMasterCollection1) {
        this.leafCollectionMasterCollection1 = leafCollectionMasterCollection1;
    }

    @XmlTransient
    public Collection<RouteEmployee> getRouteEmployeeCollection() {
        return routeEmployeeCollection;
    }

    public void setRouteEmployeeCollection(Collection<RouteEmployee> routeEmployeeCollection) {
        this.routeEmployeeCollection = routeEmployeeCollection;
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
        if (!(object instanceof RouteEmployeeType)) {
            return false;
        }
        RouteEmployeeType other = (RouteEmployeeType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.RouteEmployeeType[ id=" + id + " ]";
    }
    
}
