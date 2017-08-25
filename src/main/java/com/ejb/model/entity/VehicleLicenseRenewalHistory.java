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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "vehicle_license_renewal_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehicleLicenseRenewalHistory.findAll", query = "SELECT v FROM VehicleLicenseRenewalHistory v")
    , @NamedQuery(name = "VehicleLicenseRenewalHistory.findById", query = "SELECT v FROM VehicleLicenseRenewalHistory v WHERE v.id = :id")
    , @NamedQuery(name = "VehicleLicenseRenewalHistory.findByDateOfRenewal", query = "SELECT v FROM VehicleLicenseRenewalHistory v WHERE v.dateOfRenewal = :dateOfRenewal")
    , @NamedQuery(name = "VehicleLicenseRenewalHistory.findByDateOfExp", query = "SELECT v FROM VehicleLicenseRenewalHistory v WHERE v.dateOfExp = :dateOfExp")
    , @NamedQuery(name = "VehicleLicenseRenewalHistory.findByCost", query = "SELECT v FROM VehicleLicenseRenewalHistory v WHERE v.cost = :cost")
    , @NamedQuery(name = "VehicleLicenseRenewalHistory.findByComment", query = "SELECT v FROM VehicleLicenseRenewalHistory v WHERE v.comment = :comment")})
public class VehicleLicenseRenewalHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_of_renewal")
    @Temporal(TemporalType.DATE)
    private Date dateOfRenewal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_of_exp")
    @Temporal(TemporalType.DATE)
    private Date dateOfExp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost")
    private double cost;
    @Size(max = 450)
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vehicle vehicleId;

    public VehicleLicenseRenewalHistory() {
    }

    public VehicleLicenseRenewalHistory(Integer id) {
        this.id = id;
    }

    public VehicleLicenseRenewalHistory(Integer id, Date dateOfRenewal, Date dateOfExp, double cost) {
        this.id = id;
        this.dateOfRenewal = dateOfRenewal;
        this.dateOfExp = dateOfExp;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateOfRenewal() {
        return dateOfRenewal;
    }

    public void setDateOfRenewal(Date dateOfRenewal) {
        this.dateOfRenewal = dateOfRenewal;
    }

    public Date getDateOfExp() {
        return dateOfExp;
    }

    public void setDateOfExp(Date dateOfExp) {
        this.dateOfExp = dateOfExp;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        if (!(object instanceof VehicleLicenseRenewalHistory)) {
            return false;
        }
        VehicleLicenseRenewalHistory other = (VehicleLicenseRenewalHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.VehicleLicenseRenewalHistory[ id=" + id + " ]";
    }
    
}
