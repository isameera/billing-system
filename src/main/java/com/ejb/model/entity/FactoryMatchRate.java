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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "factory_match_rate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FactoryMatchRate.findAll", query = "SELECT f FROM FactoryMatchRate f")
    , @NamedQuery(name = "FactoryMatchRate.findById", query = "SELECT f FROM FactoryMatchRate f WHERE f.id = :id")
    , @NamedQuery(name = "FactoryMatchRate.findByName", query = "SELECT f FROM FactoryMatchRate f WHERE f.name = :name")})
public class FactoryMatchRate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facoryMatchRateId")
    private Collection<FactoryMatchRateRecords> factoryMatchRateRecordsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facoryMatchRateId")
    private Collection<SupplierIncentiveFactory> supplierIncentiveFactoryCollection;

    public FactoryMatchRate() {
    }

    public FactoryMatchRate(Integer id) {
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

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    @XmlTransient
    public Collection<FactoryMatchRateRecords> getFactoryMatchRateRecordsCollection() {
        return factoryMatchRateRecordsCollection;
    }

    public void setFactoryMatchRateRecordsCollection(Collection<FactoryMatchRateRecords> factoryMatchRateRecordsCollection) {
        this.factoryMatchRateRecordsCollection = factoryMatchRateRecordsCollection;
    }

    @XmlTransient
    public Collection<SupplierIncentiveFactory> getSupplierIncentiveFactoryCollection() {
        return supplierIncentiveFactoryCollection;
    }

    public void setSupplierIncentiveFactoryCollection(Collection<SupplierIncentiveFactory> supplierIncentiveFactoryCollection) {
        this.supplierIncentiveFactoryCollection = supplierIncentiveFactoryCollection;
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
        if (!(object instanceof FactoryMatchRate)) {
            return false;
        }
        FactoryMatchRate other = (FactoryMatchRate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.FactoryMatchRate[ id=" + id + " ]";
    }
    
}
