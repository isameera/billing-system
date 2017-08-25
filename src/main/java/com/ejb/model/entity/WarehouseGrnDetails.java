/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "warehouse_grn_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WarehouseGrnDetails.findAll", query = "SELECT w FROM WarehouseGrnDetails w")
    , @NamedQuery(name = "WarehouseGrnDetails.findById", query = "SELECT w FROM WarehouseGrnDetails w WHERE w.id = :id")
    , @NamedQuery(name = "WarehouseGrnDetails.findByDate", query = "SELECT w FROM WarehouseGrnDetails w WHERE w.date = :date")
    , @NamedQuery(name = "WarehouseGrnDetails.findByReceivedBy", query = "SELECT w FROM WarehouseGrnDetails w WHERE w.receivedBy = :receivedBy")
    , @NamedQuery(name = "WarehouseGrnDetails.findByDriverName", query = "SELECT w FROM WarehouseGrnDetails w WHERE w.driverName = :driverName")
    , @NamedQuery(name = "WarehouseGrnDetails.findByWarehouseLocation", query = "SELECT w FROM WarehouseGrnDetails w WHERE w.warehouseLocation = :warehouseLocation")})
public class WarehouseGrnDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 255)
    @Column(name = "received_by")
    private String receivedBy;
    @Size(max = 255)
    @Column(name = "driver_name")
    private String driverName;
    @Size(max = 255)
    @Column(name = "warehouse_location")
    private String warehouseLocation;
    @JoinColumn(name = "delivery_note_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DeliveryNote deliveryNoteId;
    @JoinColumn(name = "voucher_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Voucher voucherId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "warehouseGrnDetailsId")
    private Collection<WarehouseGrnItemDetails> warehouseGrnItemDetailsCollection;

    public WarehouseGrnDetails() {
    }

    public WarehouseGrnDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(String receivedBy) {
        this.receivedBy = receivedBy;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getWarehouseLocation() {
        return warehouseLocation;
    }

    public void setWarehouseLocation(String warehouseLocation) {
        this.warehouseLocation = warehouseLocation;
    }

    public DeliveryNote getDeliveryNoteId() {
        return deliveryNoteId;
    }

    public void setDeliveryNoteId(DeliveryNote deliveryNoteId) {
        this.deliveryNoteId = deliveryNoteId;
    }

    public Voucher getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Voucher voucherId) {
        this.voucherId = voucherId;
    }

    @XmlTransient
    public Collection<WarehouseGrnItemDetails> getWarehouseGrnItemDetailsCollection() {
        return warehouseGrnItemDetailsCollection;
    }

    public void setWarehouseGrnItemDetailsCollection(Collection<WarehouseGrnItemDetails> warehouseGrnItemDetailsCollection) {
        this.warehouseGrnItemDetailsCollection = warehouseGrnItemDetailsCollection;
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
        if (!(object instanceof WarehouseGrnDetails)) {
            return false;
        }
        WarehouseGrnDetails other = (WarehouseGrnDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.WarehouseGrnDetails[ id=" + id + " ]";
    }
    
}
