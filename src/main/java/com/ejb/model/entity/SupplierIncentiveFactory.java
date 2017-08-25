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
@Table(name = "supplier_incentive_factory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierIncentiveFactory.findAll", query = "SELECT s FROM SupplierIncentiveFactory s")
    , @NamedQuery(name = "SupplierIncentiveFactory.findById", query = "SELECT s FROM SupplierIncentiveFactory s WHERE s.id = :id")
    , @NamedQuery(name = "SupplierIncentiveFactory.findByDateFrom", query = "SELECT s FROM SupplierIncentiveFactory s WHERE s.dateFrom = :dateFrom")
    , @NamedQuery(name = "SupplierIncentiveFactory.findByDateTo", query = "SELECT s FROM SupplierIncentiveFactory s WHERE s.dateTo = :dateTo")
    , @NamedQuery(name = "SupplierIncentiveFactory.findByIncRange", query = "SELECT s FROM SupplierIncentiveFactory s WHERE s.incRange = :incRange")})
public class SupplierIncentiveFactory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date_from")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Column(name = "date_to")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "inc_range")
    private Double incRange;
    @JoinColumn(name = "facory_match_rate_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FactoryMatchRate facoryMatchRateId;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierRegistration supplierRegistrationId;

    public SupplierIncentiveFactory() {
    }

    public SupplierIncentiveFactory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Double getIncRange() {
        return incRange;
    }

    public void setIncRange(Double incRange) {
        this.incRange = incRange;
    }

    public FactoryMatchRate getFacoryMatchRateId() {
        return facoryMatchRateId;
    }

    public void setFacoryMatchRateId(FactoryMatchRate facoryMatchRateId) {
        this.facoryMatchRateId = facoryMatchRateId;
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
        if (!(object instanceof SupplierIncentiveFactory)) {
            return false;
        }
        SupplierIncentiveFactory other = (SupplierIncentiveFactory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierIncentiveFactory[ id=" + id + " ]";
    }
    
}
