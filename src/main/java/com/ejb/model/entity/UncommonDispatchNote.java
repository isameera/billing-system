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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "uncommon_dispatch_note")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UncommonDispatchNote.findAll", query = "SELECT u FROM UncommonDispatchNote u")
    , @NamedQuery(name = "UncommonDispatchNote.findById", query = "SELECT u FROM UncommonDispatchNote u WHERE u.id = :id")
    , @NamedQuery(name = "UncommonDispatchNote.findByDriverName", query = "SELECT u FROM UncommonDispatchNote u WHERE u.driverName = :driverName")
    , @NamedQuery(name = "UncommonDispatchNote.findByLicenseNo", query = "SELECT u FROM UncommonDispatchNote u WHERE u.licenseNo = :licenseNo")
    , @NamedQuery(name = "UncommonDispatchNote.findByVehicleNo", query = "SELECT u FROM UncommonDispatchNote u WHERE u.vehicleNo = :vehicleNo")
    , @NamedQuery(name = "UncommonDispatchNote.findByVehicleCondition", query = "SELECT u FROM UncommonDispatchNote u WHERE u.vehicleCondition = :vehicleCondition")})
public class UncommonDispatchNote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "driver_name")
    private String driverName;
    @Size(max = 45)
    @Column(name = "license _no")
    private String licenseNo;
    @Size(max = 45)
    @Column(name = "vehicle_no")
    private String vehicleNo;
    @Size(max = 450)
    @Column(name = "vehicle_condition")
    private String vehicleCondition;
    @JoinColumn(name = "delivery_note_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DeliveryNote deliveryNoteId;
    @JoinColumn(name = "checked_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile checkedBy;
    @JoinColumn(name = "dispatched_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile dispatchedBy;

    public UncommonDispatchNote() {
    }

    public UncommonDispatchNote(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleCondition() {
        return vehicleCondition;
    }

    public void setVehicleCondition(String vehicleCondition) {
        this.vehicleCondition = vehicleCondition;
    }

    public DeliveryNote getDeliveryNoteId() {
        return deliveryNoteId;
    }

    public void setDeliveryNoteId(DeliveryNote deliveryNoteId) {
        this.deliveryNoteId = deliveryNoteId;
    }

    public GeneralUserProfile getCheckedBy() {
        return checkedBy;
    }

    public void setCheckedBy(GeneralUserProfile checkedBy) {
        this.checkedBy = checkedBy;
    }

    public GeneralUserProfile getDispatchedBy() {
        return dispatchedBy;
    }

    public void setDispatchedBy(GeneralUserProfile dispatchedBy) {
        this.dispatchedBy = dispatchedBy;
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
        if (!(object instanceof UncommonDispatchNote)) {
            return false;
        }
        UncommonDispatchNote other = (UncommonDispatchNote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UncommonDispatchNote[ id=" + id + " ]";
    }
    
}
