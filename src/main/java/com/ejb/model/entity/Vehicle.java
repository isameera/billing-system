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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "vehicle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v")
    , @NamedQuery(name = "Vehicle.findById", query = "SELECT v FROM Vehicle v WHERE v.id = :id")
    , @NamedQuery(name = "Vehicle.findByRegNo", query = "SELECT v FROM Vehicle v WHERE v.regNo = :regNo")
    , @NamedQuery(name = "Vehicle.findByRegDate", query = "SELECT v FROM Vehicle v WHERE v.regDate = :regDate")
    , @NamedQuery(name = "Vehicle.findByValue", query = "SELECT v FROM Vehicle v WHERE v.value = :value")
    , @NamedQuery(name = "Vehicle.findByImage", query = "SELECT v FROM Vehicle v WHERE v.image = :image")})
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "reg_no")
    private String regNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reg_date")
    @Temporal(TemporalType.DATE)
    private Date regDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "value")
    private double value;
    @Size(max = 45)
    @Column(name = "image")
    private String image;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleId")
    private Collection<VehicleGopManager> vehicleGopManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleId")
    private Collection<VehicleUserManager> vehicleUserManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleId")
    private Collection<RouteVehicle> routeVehicleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleId")
    private Collection<LeafCollectionMaster> leafCollectionMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleId")
    private Collection<BleafVehicleTarget> bleafVehicleTargetCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleId")
    private Collection<VehicleMaintenanceHistory> vehicleMaintenanceHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleId")
    private Collection<BleafVehiclePaymentRate> bleafVehiclePaymentRateCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleId")
    private Collection<SupplierVehicleMonthlyPayments> supplierVehicleMonthlyPaymentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleId")
    private Collection<VehicleOwnerManager> vehicleOwnerManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleId")
    private Collection<VehicleInsurance> vehicleInsuranceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleId")
    private Collection<VehicleLicenseRenewalHistory> vehicleLicenseRenewalHistoryCollection;
    @OneToMany(mappedBy = "vehicleId")
    private Collection<GatePass> gatePassCollection;
    @JoinColumn(name = "vehicle_brand_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VehicleBrand vehicleBrandId;
    @JoinColumn(name = "vehicle_model_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VehicleModel vehicleModelId;
    @JoinColumn(name = "vehicle_owner_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VehicleOwnerStatus vehicleOwnerStatusId;
    @JoinColumn(name = "vehicle_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VehicleType vehicleTypeId;

    public Vehicle() {
    }

    public Vehicle(Integer id) {
        this.id = id;
    }

    public Vehicle(Integer id, String regNo, Date regDate, double value) {
        this.id = id;
        this.regNo = regNo;
        this.regDate = regDate;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public Collection<VehicleGopManager> getVehicleGopManagerCollection() {
        return vehicleGopManagerCollection;
    }

    public void setVehicleGopManagerCollection(Collection<VehicleGopManager> vehicleGopManagerCollection) {
        this.vehicleGopManagerCollection = vehicleGopManagerCollection;
    }

    @XmlTransient
    public Collection<VehicleUserManager> getVehicleUserManagerCollection() {
        return vehicleUserManagerCollection;
    }

    public void setVehicleUserManagerCollection(Collection<VehicleUserManager> vehicleUserManagerCollection) {
        this.vehicleUserManagerCollection = vehicleUserManagerCollection;
    }

    @XmlTransient
    public Collection<RouteVehicle> getRouteVehicleCollection() {
        return routeVehicleCollection;
    }

    public void setRouteVehicleCollection(Collection<RouteVehicle> routeVehicleCollection) {
        this.routeVehicleCollection = routeVehicleCollection;
    }

    @XmlTransient
    public Collection<LeafCollectionMaster> getLeafCollectionMasterCollection() {
        return leafCollectionMasterCollection;
    }

    public void setLeafCollectionMasterCollection(Collection<LeafCollectionMaster> leafCollectionMasterCollection) {
        this.leafCollectionMasterCollection = leafCollectionMasterCollection;
    }

    @XmlTransient
    public Collection<BleafVehicleTarget> getBleafVehicleTargetCollection() {
        return bleafVehicleTargetCollection;
    }

    public void setBleafVehicleTargetCollection(Collection<BleafVehicleTarget> bleafVehicleTargetCollection) {
        this.bleafVehicleTargetCollection = bleafVehicleTargetCollection;
    }

    @XmlTransient
    public Collection<VehicleMaintenanceHistory> getVehicleMaintenanceHistoryCollection() {
        return vehicleMaintenanceHistoryCollection;
    }

    public void setVehicleMaintenanceHistoryCollection(Collection<VehicleMaintenanceHistory> vehicleMaintenanceHistoryCollection) {
        this.vehicleMaintenanceHistoryCollection = vehicleMaintenanceHistoryCollection;
    }

    @XmlTransient
    public Collection<BleafVehiclePaymentRate> getBleafVehiclePaymentRateCollection() {
        return bleafVehiclePaymentRateCollection;
    }

    public void setBleafVehiclePaymentRateCollection(Collection<BleafVehiclePaymentRate> bleafVehiclePaymentRateCollection) {
        this.bleafVehiclePaymentRateCollection = bleafVehiclePaymentRateCollection;
    }

    @XmlTransient
    public Collection<SupplierVehicleMonthlyPayments> getSupplierVehicleMonthlyPaymentsCollection() {
        return supplierVehicleMonthlyPaymentsCollection;
    }

    public void setSupplierVehicleMonthlyPaymentsCollection(Collection<SupplierVehicleMonthlyPayments> supplierVehicleMonthlyPaymentsCollection) {
        this.supplierVehicleMonthlyPaymentsCollection = supplierVehicleMonthlyPaymentsCollection;
    }

    @XmlTransient
    public Collection<VehicleOwnerManager> getVehicleOwnerManagerCollection() {
        return vehicleOwnerManagerCollection;
    }

    public void setVehicleOwnerManagerCollection(Collection<VehicleOwnerManager> vehicleOwnerManagerCollection) {
        this.vehicleOwnerManagerCollection = vehicleOwnerManagerCollection;
    }

    @XmlTransient
    public Collection<VehicleInsurance> getVehicleInsuranceCollection() {
        return vehicleInsuranceCollection;
    }

    public void setVehicleInsuranceCollection(Collection<VehicleInsurance> vehicleInsuranceCollection) {
        this.vehicleInsuranceCollection = vehicleInsuranceCollection;
    }

    @XmlTransient
    public Collection<VehicleLicenseRenewalHistory> getVehicleLicenseRenewalHistoryCollection() {
        return vehicleLicenseRenewalHistoryCollection;
    }

    public void setVehicleLicenseRenewalHistoryCollection(Collection<VehicleLicenseRenewalHistory> vehicleLicenseRenewalHistoryCollection) {
        this.vehicleLicenseRenewalHistoryCollection = vehicleLicenseRenewalHistoryCollection;
    }

    @XmlTransient
    public Collection<GatePass> getGatePassCollection() {
        return gatePassCollection;
    }

    public void setGatePassCollection(Collection<GatePass> gatePassCollection) {
        this.gatePassCollection = gatePassCollection;
    }

    public VehicleBrand getVehicleBrandId() {
        return vehicleBrandId;
    }

    public void setVehicleBrandId(VehicleBrand vehicleBrandId) {
        this.vehicleBrandId = vehicleBrandId;
    }

    public VehicleModel getVehicleModelId() {
        return vehicleModelId;
    }

    public void setVehicleModelId(VehicleModel vehicleModelId) {
        this.vehicleModelId = vehicleModelId;
    }

    public VehicleOwnerStatus getVehicleOwnerStatusId() {
        return vehicleOwnerStatusId;
    }

    public void setVehicleOwnerStatusId(VehicleOwnerStatus vehicleOwnerStatusId) {
        this.vehicleOwnerStatusId = vehicleOwnerStatusId;
    }

    public VehicleType getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(VehicleType vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
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
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.Vehicle[ id=" + id + " ]";
    }
    
}
