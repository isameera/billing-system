/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "property_owenership_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PropertyOwenershipManager.findAll", query = "SELECT p FROM PropertyOwenershipManager p")
    , @NamedQuery(name = "PropertyOwenershipManager.findById", query = "SELECT p FROM PropertyOwenershipManager p WHERE p.id = :id")
    , @NamedQuery(name = "PropertyOwenershipManager.findByOwenershipFrom", query = "SELECT p FROM PropertyOwenershipManager p WHERE p.owenershipFrom = :owenershipFrom")
    , @NamedQuery(name = "PropertyOwenershipManager.findByOwenershipTo", query = "SELECT p FROM PropertyOwenershipManager p WHERE p.owenershipTo = :owenershipTo")
    , @NamedQuery(name = "PropertyOwenershipManager.findByDateTransfer", query = "SELECT p FROM PropertyOwenershipManager p WHERE p.dateTransfer = :dateTransfer")})
public class PropertyOwenershipManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "owenership_from")
    private Integer owenershipFrom;
    @Column(name = "owenership_to")
    private Integer owenershipTo;
    @Column(name = "date_transfer")
    @Temporal(TemporalType.DATE)
    private Date dateTransfer;
    @JoinColumn(name = "property_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PropertyMaster propertyMasterId;
    @JoinColumn(name = "property_owenership_type_from", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PropertyOwenershipType propertyOwenershipTypeFrom;
    @JoinColumn(name = "property_owenership_type_to", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PropertyOwenershipType propertyOwenershipTypeTo;

    public PropertyOwenershipManager() {
    }

    public PropertyOwenershipManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwenershipFrom() {
        return owenershipFrom;
    }

    public void setOwenershipFrom(Integer owenershipFrom) {
        this.owenershipFrom = owenershipFrom;
    }

    public Integer getOwenershipTo() {
        return owenershipTo;
    }

    public void setOwenershipTo(Integer owenershipTo) {
        this.owenershipTo = owenershipTo;
    }

    public Date getDateTransfer() {
        return dateTransfer;
    }

    public void setDateTransfer(Date dateTransfer) {
        this.dateTransfer = dateTransfer;
    }

    public PropertyMaster getPropertyMasterId() {
        return propertyMasterId;
    }

    public void setPropertyMasterId(PropertyMaster propertyMasterId) {
        this.propertyMasterId = propertyMasterId;
    }

    public PropertyOwenershipType getPropertyOwenershipTypeFrom() {
        return propertyOwenershipTypeFrom;
    }

    public void setPropertyOwenershipTypeFrom(PropertyOwenershipType propertyOwenershipTypeFrom) {
        this.propertyOwenershipTypeFrom = propertyOwenershipTypeFrom;
    }

    public PropertyOwenershipType getPropertyOwenershipTypeTo() {
        return propertyOwenershipTypeTo;
    }

    public void setPropertyOwenershipTypeTo(PropertyOwenershipType propertyOwenershipTypeTo) {
        this.propertyOwenershipTypeTo = propertyOwenershipTypeTo;
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
        if (!(object instanceof PropertyOwenershipManager)) {
            return false;
        }
        PropertyOwenershipManager other = (PropertyOwenershipManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.PropertyOwenershipManager[ id=" + id + " ]";
    }
    
}
