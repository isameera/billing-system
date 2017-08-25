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
@Table(name = "suplier_area_property")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SuplierAreaProperty.findAll", query = "SELECT s FROM SuplierAreaProperty s")
    , @NamedQuery(name = "SuplierAreaProperty.findById", query = "SELECT s FROM SuplierAreaProperty s WHERE s.id = :id")})
public class SuplierAreaProperty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "property_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PropertyMaster propertyMasterId;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierRegistration supplierRegistrationId;
    @JoinColumn(name = "property_area_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PropertyArea propertyAreaId;

    public SuplierAreaProperty() {
    }

    public SuplierAreaProperty(Integer id) {
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

    public SupplierRegistration getSupplierRegistrationId() {
        return supplierRegistrationId;
    }

    public void setSupplierRegistrationId(SupplierRegistration supplierRegistrationId) {
        this.supplierRegistrationId = supplierRegistrationId;
    }

    public PropertyArea getPropertyAreaId() {
        return propertyAreaId;
    }

    public void setPropertyAreaId(PropertyArea propertyAreaId) {
        this.propertyAreaId = propertyAreaId;
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
        if (!(object instanceof SuplierAreaProperty)) {
            return false;
        }
        SuplierAreaProperty other = (SuplierAreaProperty) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SuplierAreaProperty[ id=" + id + " ]";
    }
    
}
