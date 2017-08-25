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
@Table(name = "route_vehicle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RouteVehicle.findAll", query = "SELECT r FROM RouteVehicle r")
    , @NamedQuery(name = "RouteVehicle.findById", query = "SELECT r FROM RouteVehicle r WHERE r.id = :id")
    , @NamedQuery(name = "RouteVehicle.findByEndDate", query = "SELECT r FROM RouteVehicle r WHERE r.endDate = :endDate")
    , @NamedQuery(name = "RouteVehicle.findByAssignedDate", query = "SELECT r FROM RouteVehicle r WHERE r.assignedDate = :assignedDate")})
public class RouteVehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "assigned_date")
    @Temporal(TemporalType.DATE)
    private Date assignedDate;
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Route routeId;
    @JoinColumn(name = "route_vehicle_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RouteVehicleType routeVehicleTypeId;
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vehicle vehicleId;

    public RouteVehicle() {
    }

    public RouteVehicle(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    public RouteVehicleType getRouteVehicleTypeId() {
        return routeVehicleTypeId;
    }

    public void setRouteVehicleTypeId(RouteVehicleType routeVehicleTypeId) {
        this.routeVehicleTypeId = routeVehicleTypeId;
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
        if (!(object instanceof RouteVehicle)) {
            return false;
        }
        RouteVehicle other = (RouteVehicle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.RouteVehicle[ id=" + id + " ]";
    }
    
}
