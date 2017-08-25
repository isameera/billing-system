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
@Table(name = "supplier_payment_mode_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierPaymentModeManager.findAll", query = "SELECT s FROM SupplierPaymentModeManager s")
    , @NamedQuery(name = "SupplierPaymentModeManager.findById", query = "SELECT s FROM SupplierPaymentModeManager s WHERE s.id = :id")})
public class SupplierPaymentModeManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "suppler_payment_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplerPaymentType supplerPaymentTypeId;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierRegistration supplierRegistrationId;
    @JoinColumn(name = "universal_payment_mode_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalPaymentMode universalPaymentModeId;

    public SupplierPaymentModeManager() {
    }

    public SupplierPaymentModeManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SupplerPaymentType getSupplerPaymentTypeId() {
        return supplerPaymentTypeId;
    }

    public void setSupplerPaymentTypeId(SupplerPaymentType supplerPaymentTypeId) {
        this.supplerPaymentTypeId = supplerPaymentTypeId;
    }

    public SupplierRegistration getSupplierRegistrationId() {
        return supplierRegistrationId;
    }

    public void setSupplierRegistrationId(SupplierRegistration supplierRegistrationId) {
        this.supplierRegistrationId = supplierRegistrationId;
    }

    public UniversalPaymentMode getUniversalPaymentModeId() {
        return universalPaymentModeId;
    }

    public void setUniversalPaymentModeId(UniversalPaymentMode universalPaymentModeId) {
        this.universalPaymentModeId = universalPaymentModeId;
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
        if (!(object instanceof SupplierPaymentModeManager)) {
            return false;
        }
        SupplierPaymentModeManager other = (SupplierPaymentModeManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierPaymentModeManager[ id=" + id + " ]";
    }
    
}
