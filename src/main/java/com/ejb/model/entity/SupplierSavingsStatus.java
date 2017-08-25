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
@Table(name = "supplier_savings_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierSavingsStatus.findAll", query = "SELECT s FROM SupplierSavingsStatus s")
    , @NamedQuery(name = "SupplierSavingsStatus.findById", query = "SELECT s FROM SupplierSavingsStatus s WHERE s.id = :id")
    , @NamedQuery(name = "SupplierSavingsStatus.findByName", query = "SELECT s FROM SupplierSavingsStatus s WHERE s.name = :name")})
public class SupplierSavingsStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierSavingsStatusId")
    private Collection<SupplierSavingsRequstedMonths> supplierSavingsRequstedMonthsCollection;

    public SupplierSavingsStatus() {
    }

    public SupplierSavingsStatus(Integer id) {
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
    public Collection<SupplierSavingsRequstedMonths> getSupplierSavingsRequstedMonthsCollection() {
        return supplierSavingsRequstedMonthsCollection;
    }

    public void setSupplierSavingsRequstedMonthsCollection(Collection<SupplierSavingsRequstedMonths> supplierSavingsRequstedMonthsCollection) {
        this.supplierSavingsRequstedMonthsCollection = supplierSavingsRequstedMonthsCollection;
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
        if (!(object instanceof SupplierSavingsStatus)) {
            return false;
        }
        SupplierSavingsStatus other = (SupplierSavingsStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierSavingsStatus[ id=" + id + " ]";
    }
    
}
