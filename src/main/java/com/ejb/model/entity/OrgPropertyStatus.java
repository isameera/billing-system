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
@Table(name = "org_property_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrgPropertyStatus.findAll", query = "SELECT o FROM OrgPropertyStatus o")
    , @NamedQuery(name = "OrgPropertyStatus.findById", query = "SELECT o FROM OrgPropertyStatus o WHERE o.id = :id")})
public class OrgPropertyStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "property_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PropertyMaster propertyMasterId;
    @JoinColumn(name = "property_owenership_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PropertyOwenershipType propertyOwenershipTypeId;
    @JoinColumn(name = "property_status_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PropertyStatusType propertyStatusTypeId;

    public OrgPropertyStatus() {
    }

    public OrgPropertyStatus(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PropertyMaster getPropertyMasterId() {
        return propertyMasterId;
    }

    public void setPropertyMasterId(PropertyMaster propertyMasterId) {
        this.propertyMasterId = propertyMasterId;
    }

    public PropertyOwenershipType getPropertyOwenershipTypeId() {
        return propertyOwenershipTypeId;
    }

    public void setPropertyOwenershipTypeId(PropertyOwenershipType propertyOwenershipTypeId) {
        this.propertyOwenershipTypeId = propertyOwenershipTypeId;
    }

    public PropertyStatusType getPropertyStatusTypeId() {
        return propertyStatusTypeId;
    }

    public void setPropertyStatusTypeId(PropertyStatusType propertyStatusTypeId) {
        this.propertyStatusTypeId = propertyStatusTypeId;
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
        if (!(object instanceof OrgPropertyStatus)) {
            return false;
        }
        OrgPropertyStatus other = (OrgPropertyStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.OrgPropertyStatus[ id=" + id + " ]";
    }
    
}
