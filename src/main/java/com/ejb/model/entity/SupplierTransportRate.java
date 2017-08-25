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
@Table(name = "supplier_transport_rate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierTransportRate.findAll", query = "SELECT s FROM SupplierTransportRate s")
    , @NamedQuery(name = "SupplierTransportRate.findById", query = "SELECT s FROM SupplierTransportRate s WHERE s.id = :id")
    , @NamedQuery(name = "SupplierTransportRate.findByDateFrom", query = "SELECT s FROM SupplierTransportRate s WHERE s.dateFrom = :dateFrom")
    , @NamedQuery(name = "SupplierTransportRate.findByDateTo", query = "SELECT s FROM SupplierTransportRate s WHERE s.dateTo = :dateTo")
    , @NamedQuery(name = "SupplierTransportRate.findByTrRange", query = "SELECT s FROM SupplierTransportRate s WHERE s.trRange = :trRange")
    , @NamedQuery(name = "SupplierTransportRate.findByRecoveryRate", query = "SELECT s FROM SupplierTransportRate s WHERE s.recoveryRate = :recoveryRate")
    , @NamedQuery(name = "SupplierTransportRate.findByPaymentRate", query = "SELECT s FROM SupplierTransportRate s WHERE s.paymentRate = :paymentRate")
    , @NamedQuery(name = "SupplierTransportRate.findBySetOfTr", query = "SELECT s FROM SupplierTransportRate s WHERE s.setOfTr = :setOfTr")})
public class SupplierTransportRate implements Serializable {

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
    @Column(name = "tr_range")
    private Double trRange;
    @Column(name = "recovery_rate")
    private Double recoveryRate;
    @Column(name = "payment_rate")
    private Double paymentRate;
    @Column(name = "set_of_tr")
    private Integer setOfTr;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierRegistration supplierRegistrationId;
    @JoinColumn(name = "supplier_transport_rate_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierTransportRateType supplierTransportRateTypeId;

    public SupplierTransportRate() {
    }

    public SupplierTransportRate(Integer id) {
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

    public Double getTrRange() {
        return trRange;
    }

    public void setTrRange(Double trRange) {
        this.trRange = trRange;
    }

    public Double getRecoveryRate() {
        return recoveryRate;
    }

    public void setRecoveryRate(Double recoveryRate) {
        this.recoveryRate = recoveryRate;
    }

    public Double getPaymentRate() {
        return paymentRate;
    }

    public void setPaymentRate(Double paymentRate) {
        this.paymentRate = paymentRate;
    }

    public Integer getSetOfTr() {
        return setOfTr;
    }

    public void setSetOfTr(Integer setOfTr) {
        this.setOfTr = setOfTr;
    }

    public SupplierRegistration getSupplierRegistrationId() {
        return supplierRegistrationId;
    }

    public void setSupplierRegistrationId(SupplierRegistration supplierRegistrationId) {
        this.supplierRegistrationId = supplierRegistrationId;
    }

    public SupplierTransportRateType getSupplierTransportRateTypeId() {
        return supplierTransportRateTypeId;
    }

    public void setSupplierTransportRateTypeId(SupplierTransportRateType supplierTransportRateTypeId) {
        this.supplierTransportRateTypeId = supplierTransportRateTypeId;
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
        if (!(object instanceof SupplierTransportRate)) {
            return false;
        }
        SupplierTransportRate other = (SupplierTransportRate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierTransportRate[ id=" + id + " ]";
    }
    
}
