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
@Table(name = "supplier_incentive")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierIncentive.findAll", query = "SELECT s FROM SupplierIncentive s")
    , @NamedQuery(name = "SupplierIncentive.findById", query = "SELECT s FROM SupplierIncentive s WHERE s.id = :id")
    , @NamedQuery(name = "SupplierIncentive.findByDateFrom", query = "SELECT s FROM SupplierIncentive s WHERE s.dateFrom = :dateFrom")
    , @NamedQuery(name = "SupplierIncentive.findByDateTo", query = "SELECT s FROM SupplierIncentive s WHERE s.dateTo = :dateTo")
    , @NamedQuery(name = "SupplierIncentive.findByRate", query = "SELECT s FROM SupplierIncentive s WHERE s.rate = :rate")
    , @NamedQuery(name = "SupplierIncentive.findByIncRange", query = "SELECT s FROM SupplierIncentive s WHERE s.incRange = :incRange")})
public class SupplierIncentive implements Serializable {

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
    @Column(name = "rate")
    private Double rate;
    @Column(name = "inc_range")
    private Double incRange;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierRegistration supplierRegistrationId;

    public SupplierIncentive() {
    }

    public SupplierIncentive(Integer id) {
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

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getIncRange() {
        return incRange;
    }

    public void setIncRange(Double incRange) {
        this.incRange = incRange;
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
        if (!(object instanceof SupplierIncentive)) {
            return false;
        }
        SupplierIncentive other = (SupplierIncentive) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierIncentive[ id=" + id + " ]";
    }
    
}
