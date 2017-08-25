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
@Table(name = "supplier_vehicle_monthly_payments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierVehicleMonthlyPayments.findAll", query = "SELECT s FROM SupplierVehicleMonthlyPayments s")
    , @NamedQuery(name = "SupplierVehicleMonthlyPayments.findById", query = "SELECT s FROM SupplierVehicleMonthlyPayments s WHERE s.id = :id")
    , @NamedQuery(name = "SupplierVehicleMonthlyPayments.findByYear", query = "SELECT s FROM SupplierVehicleMonthlyPayments s WHERE s.year = :year")
    , @NamedQuery(name = "SupplierVehicleMonthlyPayments.findByMonth", query = "SELECT s FROM SupplierVehicleMonthlyPayments s WHERE s.month = :month")
    , @NamedQuery(name = "SupplierVehicleMonthlyPayments.findByGivenLeafQty", query = "SELECT s FROM SupplierVehicleMonthlyPayments s WHERE s.givenLeafQty = :givenLeafQty")
    , @NamedQuery(name = "SupplierVehicleMonthlyPayments.findByTrRange", query = "SELECT s FROM SupplierVehicleMonthlyPayments s WHERE s.trRange = :trRange")
    , @NamedQuery(name = "SupplierVehicleMonthlyPayments.findByTransportPaymentRate", query = "SELECT s FROM SupplierVehicleMonthlyPayments s WHERE s.transportPaymentRate = :transportPaymentRate")
    , @NamedQuery(name = "SupplierVehicleMonthlyPayments.findByBlPaymentRate", query = "SELECT s FROM SupplierVehicleMonthlyPayments s WHERE s.blPaymentRate = :blPaymentRate")})
public class SupplierVehicleMonthlyPayments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "year")
    private Integer year;
    @Column(name = "month")
    private Integer month;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "given_leaf_qty")
    private Double givenLeafQty;
    @Column(name = "tr_range")
    private Double trRange;
    @Column(name = "transport_payment_rate")
    private Double transportPaymentRate;
    @Column(name = "bl_payment_rate")
    private Double blPaymentRate;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierRegistration supplierRegistrationId;
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vehicle vehicleId;

    public SupplierVehicleMonthlyPayments() {
    }

    public SupplierVehicleMonthlyPayments(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getGivenLeafQty() {
        return givenLeafQty;
    }

    public void setGivenLeafQty(Double givenLeafQty) {
        this.givenLeafQty = givenLeafQty;
    }

    public Double getTrRange() {
        return trRange;
    }

    public void setTrRange(Double trRange) {
        this.trRange = trRange;
    }

    public Double getTransportPaymentRate() {
        return transportPaymentRate;
    }

    public void setTransportPaymentRate(Double transportPaymentRate) {
        this.transportPaymentRate = transportPaymentRate;
    }

    public Double getBlPaymentRate() {
        return blPaymentRate;
    }

    public void setBlPaymentRate(Double blPaymentRate) {
        this.blPaymentRate = blPaymentRate;
    }

    public SupplierRegistration getSupplierRegistrationId() {
        return supplierRegistrationId;
    }

    public void setSupplierRegistrationId(SupplierRegistration supplierRegistrationId) {
        this.supplierRegistrationId = supplierRegistrationId;
    }

    public Vehicle getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Vehicle vehicleId) {
        this.vehicleId = vehicleId;
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
        if (!(object instanceof SupplierVehicleMonthlyPayments)) {
            return false;
        }
        SupplierVehicleMonthlyPayments other = (SupplierVehicleMonthlyPayments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierVehicleMonthlyPayments[ id=" + id + " ]";
    }
    
}
