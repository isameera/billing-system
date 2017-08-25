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
@Table(name = "leaf_collection_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LeafCollectionMaster.findAll", query = "SELECT l FROM LeafCollectionMaster l")
    , @NamedQuery(name = "LeafCollectionMaster.findById", query = "SELECT l FROM LeafCollectionMaster l WHERE l.id = :id")
    , @NamedQuery(name = "LeafCollectionMaster.findByTrNo", query = "SELECT l FROM LeafCollectionMaster l WHERE l.trNo = :trNo")
    , @NamedQuery(name = "LeafCollectionMaster.findByLeafQty", query = "SELECT l FROM LeafCollectionMaster l WHERE l.leafQty = :leafQty")
    , @NamedQuery(name = "LeafCollectionMaster.findByDate", query = "SELECT l FROM LeafCollectionMaster l WHERE l.date = :date")
    , @NamedQuery(name = "LeafCollectionMaster.findByIsConfirmed", query = "SELECT l FROM LeafCollectionMaster l WHERE l.isConfirmed = :isConfirmed")})
public class LeafCollectionMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "tr_no")
    private String trNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "leaf_qty")
    private Double leafQty;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "is_confirmed")
    private Integer isConfirmed;
    @JoinColumn(name = "helper", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee helper;
    @JoinColumn(name = "collection_officer", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee collectionOfficer;
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Route routeId;
    @JoinColumn(name = "route_employee_type_officer", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RouteEmployeeType routeEmployeeTypeOfficer;
    @JoinColumn(name = "route_vehicle_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RouteVehicleType routeVehicleTypeId;
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vehicle vehicleId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "route_employee_type_helper", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RouteEmployeeType routeEmployeeTypeHelper;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierRegistration supplierRegistrationId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leafCollectionMasterId")
    private Collection<FactoryCollectedLeafByRoute> factoryCollectedLeafByRouteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leafCollectionMasterId")
    private Collection<RouteCollectedLeaf> routeCollectedLeafCollection;

    public LeafCollectionMaster() {
    }

    public LeafCollectionMaster(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrNo() {
        return trNo;
    }

    public void setTrNo(String trNo) {
        this.trNo = trNo;
    }

    public Double getLeafQty() {
        return leafQty;
    }

    public void setLeafQty(Double leafQty) {
        this.leafQty = leafQty;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getIsConfirmed() {
        return isConfirmed;
    }

    public void setIsConfirmed(Integer isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    public Employee getHelper() {
        return helper;
    }

    public void setHelper(Employee helper) {
        this.helper = helper;
    }

    public Employee getCollectionOfficer() {
        return collectionOfficer;
    }

    public void setCollectionOfficer(Employee collectionOfficer) {
        this.collectionOfficer = collectionOfficer;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    public RouteEmployeeType getRouteEmployeeTypeOfficer() {
        return routeEmployeeTypeOfficer;
    }

    public void setRouteEmployeeTypeOfficer(RouteEmployeeType routeEmployeeTypeOfficer) {
        this.routeEmployeeTypeOfficer = routeEmployeeTypeOfficer;
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

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public RouteEmployeeType getRouteEmployeeTypeHelper() {
        return routeEmployeeTypeHelper;
    }

    public void setRouteEmployeeTypeHelper(RouteEmployeeType routeEmployeeTypeHelper) {
        this.routeEmployeeTypeHelper = routeEmployeeTypeHelper;
    }

    public SupplierRegistration getSupplierRegistrationId() {
        return supplierRegistrationId;
    }

    public void setSupplierRegistrationId(SupplierRegistration supplierRegistrationId) {
        this.supplierRegistrationId = supplierRegistrationId;
    }

    @XmlTransient
    public Collection<FactoryCollectedLeafByRoute> getFactoryCollectedLeafByRouteCollection() {
        return factoryCollectedLeafByRouteCollection;
    }

    public void setFactoryCollectedLeafByRouteCollection(Collection<FactoryCollectedLeafByRoute> factoryCollectedLeafByRouteCollection) {
        this.factoryCollectedLeafByRouteCollection = factoryCollectedLeafByRouteCollection;
    }

    @XmlTransient
    public Collection<RouteCollectedLeaf> getRouteCollectedLeafCollection() {
        return routeCollectedLeafCollection;
    }

    public void setRouteCollectedLeafCollection(Collection<RouteCollectedLeaf> routeCollectedLeafCollection) {
        this.routeCollectedLeafCollection = routeCollectedLeafCollection;
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
        if (!(object instanceof LeafCollectionMaster)) {
            return false;
        }
        LeafCollectionMaster other = (LeafCollectionMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.LeafCollectionMaster[ id=" + id + " ]";
    }
    
}
