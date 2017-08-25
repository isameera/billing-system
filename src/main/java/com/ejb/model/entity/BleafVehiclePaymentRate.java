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
@Table(name = "bleaf_vehicle_payment_rate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BleafVehiclePaymentRate.findAll", query = "SELECT b FROM BleafVehiclePaymentRate b")
    , @NamedQuery(name = "BleafVehiclePaymentRate.findById", query = "SELECT b FROM BleafVehiclePaymentRate b WHERE b.id = :id")
    , @NamedQuery(name = "BleafVehiclePaymentRate.findByDateFrom", query = "SELECT b FROM BleafVehiclePaymentRate b WHERE b.dateFrom = :dateFrom")
    , @NamedQuery(name = "BleafVehiclePaymentRate.findByDateTo", query = "SELECT b FROM BleafVehiclePaymentRate b WHERE b.dateTo = :dateTo")
    , @NamedQuery(name = "BleafVehiclePaymentRate.findByAmount", query = "SELECT b FROM BleafVehiclePaymentRate b WHERE b.amount = :amount")})
public class BleafVehiclePaymentRate implements Serializable {

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
    @Column(name = "amount")
    private Double amount;
    @JoinColumn(name = "bleaf_vehicle_payment_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BleafVehiclePaymentType bleafVehiclePaymentTypeId;
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vehicle vehicleId;

    public BleafVehiclePaymentRate() {
    }

    public BleafVehiclePaymentRate(Integer id) {
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public BleafVehiclePaymentType getBleafVehiclePaymentTypeId() {
        return bleafVehiclePaymentTypeId;
    }

    public void setBleafVehiclePaymentTypeId(BleafVehiclePaymentType bleafVehiclePaymentTypeId) {
        this.bleafVehiclePaymentTypeId = bleafVehiclePaymentTypeId;
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
        if (!(object instanceof BleafVehiclePaymentRate)) {
            return false;
        }
        BleafVehiclePaymentRate other = (BleafVehiclePaymentRate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.BleafVehiclePaymentRate[ id=" + id + " ]";
    }
    
}
