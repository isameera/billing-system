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
@Table(name = "supplier_bag_weight")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierBagWeight.findAll", query = "SELECT s FROM SupplierBagWeight s")
    , @NamedQuery(name = "SupplierBagWeight.findById", query = "SELECT s FROM SupplierBagWeight s WHERE s.id = :id")
    , @NamedQuery(name = "SupplierBagWeight.findByPerBagWeight", query = "SELECT s FROM SupplierBagWeight s WHERE s.perBagWeight = :perBagWeight")
    , @NamedQuery(name = "SupplierBagWeight.findByDate", query = "SELECT s FROM SupplierBagWeight s WHERE s.date = :date")})
public class SupplierBagWeight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "per_bag_weight")
    private Double perBagWeight;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierRegistration supplierRegistrationId;

    public SupplierBagWeight() {
    }

    public SupplierBagWeight(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPerBagWeight() {
        return perBagWeight;
    }

    public void setPerBagWeight(Double perBagWeight) {
        this.perBagWeight = perBagWeight;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SupplierRegistration getSupplierRegistrationId() {
        return supplierRegistrationId;
    }

    public void setSupplierRegistrationId(SupplierRegistration supplierRegistrationId) {
        this.supplierRegistrationId = supplierRegistrationId;
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
        if (!(object instanceof SupplierBagWeight)) {
            return false;
        }
        SupplierBagWeight other = (SupplierBagWeight) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierBagWeight[ id=" + id + " ]";
    }
    
}
