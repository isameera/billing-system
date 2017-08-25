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
@Table(name = "property_owenership_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PropertyOwenershipType.findAll", query = "SELECT p FROM PropertyOwenershipType p")
    , @NamedQuery(name = "PropertyOwenershipType.findById", query = "SELECT p FROM PropertyOwenershipType p WHERE p.id = :id")
    , @NamedQuery(name = "PropertyOwenershipType.findByName", query = "SELECT p FROM PropertyOwenershipType p WHERE p.name = :name")})
public class PropertyOwenershipType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyOwenershipTypeId")
    private Collection<PropertyMaster> propertyMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyOwenershipTypeId")
    private Collection<OrgPropertyStatus> orgPropertyStatusCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyOwenershipTypeFrom")
    private Collection<PropertyOwenershipManager> propertyOwenershipManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyOwenershipTypeTo")
    private Collection<PropertyOwenershipManager> propertyOwenershipManagerCollection1;

    public PropertyOwenershipType() {
    }

    public PropertyOwenershipType(Integer id) {
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
    public Collection<PropertyMaster> getPropertyMasterCollection() {
        return propertyMasterCollection;
    }

    public void setPropertyMasterCollection(Collection<PropertyMaster> propertyMasterCollection) {
        this.propertyMasterCollection = propertyMasterCollection;
    }

    @XmlTransient
    public Collection<OrgPropertyStatus> getOrgPropertyStatusCollection() {
        return orgPropertyStatusCollection;
    }

    public void setOrgPropertyStatusCollection(Collection<OrgPropertyStatus> orgPropertyStatusCollection) {
        this.orgPropertyStatusCollection = orgPropertyStatusCollection;
    }

    @XmlTransient
    public Collection<PropertyOwenershipManager> getPropertyOwenershipManagerCollection() {
        return propertyOwenershipManagerCollection;
    }

    public void setPropertyOwenershipManagerCollection(Collection<PropertyOwenershipManager> propertyOwenershipManagerCollection) {
        this.propertyOwenershipManagerCollection = propertyOwenershipManagerCollection;
    }

    @XmlTransient
    public Collection<PropertyOwenershipManager> getPropertyOwenershipManagerCollection1() {
        return propertyOwenershipManagerCollection1;
    }

    public void setPropertyOwenershipManagerCollection1(Collection<PropertyOwenershipManager> propertyOwenershipManagerCollection1) {
        this.propertyOwenershipManagerCollection1 = propertyOwenershipManagerCollection1;
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
        if (!(object instanceof PropertyOwenershipType)) {
            return false;
        }
        PropertyOwenershipType other = (PropertyOwenershipType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.PropertyOwenershipType[ id=" + id + " ]";
    }
    
}
