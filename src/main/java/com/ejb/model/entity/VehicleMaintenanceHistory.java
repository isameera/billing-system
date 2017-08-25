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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "vehicle_maintenance_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehicleMaintenanceHistory.findAll", query = "SELECT v FROM VehicleMaintenanceHistory v")
    , @NamedQuery(name = "VehicleMaintenanceHistory.findById", query = "SELECT v FROM VehicleMaintenanceHistory v WHERE v.id = :id")
    , @NamedQuery(name = "VehicleMaintenanceHistory.findByDate", query = "SELECT v FROM VehicleMaintenanceHistory v WHERE v.date = :date")
    , @NamedQuery(name = "VehicleMaintenanceHistory.findByCost", query = "SELECT v FROM VehicleMaintenanceHistory v WHERE v.cost = :cost")})
public class VehicleMaintenanceHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost")
    private double cost;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "reason")
    private String reason;
    @Lob
    @Size(max = 65535)
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "maintenance_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile maintenanceBy;
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vehicle vehicleId;

    public VehicleMaintenanceHistory() {
    }

    public VehicleMaintenanceHistory(Integer id) {
        this.id = id;
    }

    public VehicleMaintenanceHistory(Integer id, Date date, double cost, String reason) {
        this.id = id;
        this.date = date;
        this.cost = cost;
        this.reason = reason;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public GeneralOrganizationProfile getMaintenanceBy() {
        return maintenanceBy;
    }

    public void setMaintenanceBy(GeneralOrganizationProfile maintenanceBy) {
        this.maintenanceBy = maintenanceBy;
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
        if (!(object instanceof VehicleMaintenanceHistory)) {
            return false;
        }
        VehicleMaintenanceHistory other = (VehicleMaintenanceHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.VehicleMaintenanceHistory[ id=" + id + " ]";
    }
    
}
