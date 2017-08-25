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
@Table(name = "route_employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RouteEmployee.findAll", query = "SELECT r FROM RouteEmployee r")
    , @NamedQuery(name = "RouteEmployee.findById", query = "SELECT r FROM RouteEmployee r WHERE r.id = :id")
    , @NamedQuery(name = "RouteEmployee.findByAssignedDate", query = "SELECT r FROM RouteEmployee r WHERE r.assignedDate = :assignedDate")
    , @NamedQuery(name = "RouteEmployee.findByEndDate", query = "SELECT r FROM RouteEmployee r WHERE r.endDate = :endDate")})
public class RouteEmployee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "assigned_date")
    @Temporal(TemporalType.DATE)
    private Date assignedDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Route routeId;
    @JoinColumn(name = "route_employee_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RouteEmployeeType routeEmployeeTypeId;

    public RouteEmployee() {
    }

    public RouteEmployee(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    public RouteEmployeeType getRouteEmployeeTypeId() {
        return routeEmployeeTypeId;
    }

    public void setRouteEmployeeTypeId(RouteEmployeeType routeEmployeeTypeId) {
        this.routeEmployeeTypeId = routeEmployeeTypeId;
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
        if (!(object instanceof RouteEmployee)) {
            return false;
        }
        RouteEmployee other = (RouteEmployee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.RouteEmployee[ id=" + id + " ]";
    }
    
}
