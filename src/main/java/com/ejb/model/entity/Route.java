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
@Table(name = "route")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r")
    , @NamedQuery(name = "Route.findById", query = "SELECT r FROM Route r WHERE r.id = :id")
    , @NamedQuery(name = "Route.findByRouteId", query = "SELECT r FROM Route r WHERE r.routeId = :routeId")
    , @NamedQuery(name = "Route.findByName", query = "SELECT r FROM Route r WHERE r.name = :name")
    , @NamedQuery(name = "Route.findByRegDate", query = "SELECT r FROM Route r WHERE r.regDate = :regDate")
    , @NamedQuery(name = "Route.findByStartDate", query = "SELECT r FROM Route r WHERE r.startDate = :startDate")
    , @NamedQuery(name = "Route.findByDistance", query = "SELECT r FROM Route r WHERE r.distance = :distance")
    , @NamedQuery(name = "Route.findByFixedTransportRate", query = "SELECT r FROM Route r WHERE r.fixedTransportRate = :fixedTransportRate")
    , @NamedQuery(name = "Route.findByCode", query = "SELECT r FROM Route r WHERE r.code = :code")
    , @NamedQuery(name = "Route.findByIsTeaCategoryActive", query = "SELECT r FROM Route r WHERE r.isTeaCategoryActive = :isTeaCategoryActive")})
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "route_id")
    private String routeId;
    @Size(max = 450)
    @Column(name = "name")
    private String name;
    @Column(name = "reg_date")
    @Temporal(TemporalType.DATE)
    private Date regDate;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "distance")
    private Double distance;
    @Column(name = "fixed_transport_rate")
    private Double fixedTransportRate;
    @Size(max = 45)
    @Column(name = "code")
    private String code;
    @Column(name = "is_tea_category_active")
    private Integer isTeaCategoryActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Collection<LeafFinalPaymentRateByRoute> leafFinalPaymentRateByRouteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Collection<SupplierSavingsAccount> supplierSavingsAccountCollection;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "start_location", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RouteLocation startLocation;
    @JoinColumn(name = "end_location", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RouteLocation endLocation;
    @OneToMany(mappedBy = "routeId")
    private Collection<WelfareManager> welfareManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Collection<RouteCollectionSummary> routeCollectionSummaryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Collection<UniversalBoughtleafItemRequest> universalBoughtleafItemRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Collection<RouteVehicle> routeVehicleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Collection<RouteCollectedLeafController> routeCollectedLeafControllerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Collection<LeafCollectionMaster> leafCollectionMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Collection<LeafMatchRateByRoute> leafMatchRateByRouteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Collection<PreparePaymentsForSupplierSavings> preparePaymentsForSupplierSavingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Collection<SupplierFinalPaymentHistory> supplierFinalPaymentHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Collection<SupplierAdvanceRequest> supplierAdvanceRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Collection<SupplierAdvanceIssuingSummary> supplierAdvanceIssuingSummaryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Collection<SupplierRoute> supplierRouteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Collection<CollectionTarget> collectionTargetCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Collection<RouteEmployee> routeEmployeeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Collection<LeafRateManager> leafRateManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "route")
    private Collection<RouteTransportRateHistory> routeTransportRateHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Collection<SupplierPassbook> supplierPassbookCollection;

    public Route() {
    }

    public Route(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getFixedTransportRate() {
        return fixedTransportRate;
    }

    public void setFixedTransportRate(Double fixedTransportRate) {
        this.fixedTransportRate = fixedTransportRate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getIsTeaCategoryActive() {
        return isTeaCategoryActive;
    }

    public void setIsTeaCategoryActive(Integer isTeaCategoryActive) {
        this.isTeaCategoryActive = isTeaCategoryActive;
    }

    @XmlTransient
    public Collection<LeafFinalPaymentRateByRoute> getLeafFinalPaymentRateByRouteCollection() {
        return leafFinalPaymentRateByRouteCollection;
    }

    public void setLeafFinalPaymentRateByRouteCollection(Collection<LeafFinalPaymentRateByRoute> leafFinalPaymentRateByRouteCollection) {
        this.leafFinalPaymentRateByRouteCollection = leafFinalPaymentRateByRouteCollection;
    }

    @XmlTransient
    public Collection<SupplierSavingsAccount> getSupplierSavingsAccountCollection() {
        return supplierSavingsAccountCollection;
    }

    public void setSupplierSavingsAccountCollection(Collection<SupplierSavingsAccount> supplierSavingsAccountCollection) {
        this.supplierSavingsAccountCollection = supplierSavingsAccountCollection;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public RouteLocation getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(RouteLocation startLocation) {
        this.startLocation = startLocation;
    }

    public RouteLocation getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(RouteLocation endLocation) {
        this.endLocation = endLocation;
    }

    @XmlTransient
    public Collection<WelfareManager> getWelfareManagerCollection() {
        return welfareManagerCollection;
    }

    public void setWelfareManagerCollection(Collection<WelfareManager> welfareManagerCollection) {
        this.welfareManagerCollection = welfareManagerCollection;
    }

    @XmlTransient
    public Collection<RouteCollectionSummary> getRouteCollectionSummaryCollection() {
        return routeCollectionSummaryCollection;
    }

    public void setRouteCollectionSummaryCollection(Collection<RouteCollectionSummary> routeCollectionSummaryCollection) {
        this.routeCollectionSummaryCollection = routeCollectionSummaryCollection;
    }

    @XmlTransient
    public Collection<UniversalBoughtleafItemRequest> getUniversalBoughtleafItemRequestCollection() {
        return universalBoughtleafItemRequestCollection;
    }

    public void setUniversalBoughtleafItemRequestCollection(Collection<UniversalBoughtleafItemRequest> universalBoughtleafItemRequestCollection) {
        this.universalBoughtleafItemRequestCollection = universalBoughtleafItemRequestCollection;
    }

    @XmlTransient
    public Collection<RouteVehicle> getRouteVehicleCollection() {
        return routeVehicleCollection;
    }

    public void setRouteVehicleCollection(Collection<RouteVehicle> routeVehicleCollection) {
        this.routeVehicleCollection = routeVehicleCollection;
    }

    @XmlTransient
    public Collection<RouteCollectedLeafController> getRouteCollectedLeafControllerCollection() {
        return routeCollectedLeafControllerCollection;
    }

    public void setRouteCollectedLeafControllerCollection(Collection<RouteCollectedLeafController> routeCollectedLeafControllerCollection) {
        this.routeCollectedLeafControllerCollection = routeCollectedLeafControllerCollection;
    }

    @XmlTransient
    public Collection<LeafCollectionMaster> getLeafCollectionMasterCollection() {
        return leafCollectionMasterCollection;
    }

    public void setLeafCollectionMasterCollection(Collection<LeafCollectionMaster> leafCollectionMasterCollection) {
        this.leafCollectionMasterCollection = leafCollectionMasterCollection;
    }

    @XmlTransient
    public Collection<LeafMatchRateByRoute> getLeafMatchRateByRouteCollection() {
        return leafMatchRateByRouteCollection;
    }

    public void setLeafMatchRateByRouteCollection(Collection<LeafMatchRateByRoute> leafMatchRateByRouteCollection) {
        this.leafMatchRateByRouteCollection = leafMatchRateByRouteCollection;
    }

    @XmlTransient
    public Collection<PreparePaymentsForSupplierSavings> getPreparePaymentsForSupplierSavingsCollection() {
        return preparePaymentsForSupplierSavingsCollection;
    }

    public void setPreparePaymentsForSupplierSavingsCollection(Collection<PreparePaymentsForSupplierSavings> preparePaymentsForSupplierSavingsCollection) {
        this.preparePaymentsForSupplierSavingsCollection = preparePaymentsForSupplierSavingsCollection;
    }

    @XmlTransient
    public Collection<SupplierFinalPaymentHistory> getSupplierFinalPaymentHistoryCollection() {
        return supplierFinalPaymentHistoryCollection;
    }

    public void setSupplierFinalPaymentHistoryCollection(Collection<SupplierFinalPaymentHistory> supplierFinalPaymentHistoryCollection) {
        this.supplierFinalPaymentHistoryCollection = supplierFinalPaymentHistoryCollection;
    }

    @XmlTransient
    public Collection<SupplierAdvanceRequest> getSupplierAdvanceRequestCollection() {
        return supplierAdvanceRequestCollection;
    }

    public void setSupplierAdvanceRequestCollection(Collection<SupplierAdvanceRequest> supplierAdvanceRequestCollection) {
        this.supplierAdvanceRequestCollection = supplierAdvanceRequestCollection;
    }

    @XmlTransient
    public Collection<SupplierAdvanceIssuingSummary> getSupplierAdvanceIssuingSummaryCollection() {
        return supplierAdvanceIssuingSummaryCollection;
    }

    public void setSupplierAdvanceIssuingSummaryCollection(Collection<SupplierAdvanceIssuingSummary> supplierAdvanceIssuingSummaryCollection) {
        this.supplierAdvanceIssuingSummaryCollection = supplierAdvanceIssuingSummaryCollection;
    }

    @XmlTransient
    public Collection<SupplierRoute> getSupplierRouteCollection() {
        return supplierRouteCollection;
    }

    public void setSupplierRouteCollection(Collection<SupplierRoute> supplierRouteCollection) {
        this.supplierRouteCollection = supplierRouteCollection;
    }

    @XmlTransient
    public Collection<CollectionTarget> getCollectionTargetCollection() {
        return collectionTargetCollection;
    }

    public void setCollectionTargetCollection(Collection<CollectionTarget> collectionTargetCollection) {
        this.collectionTargetCollection = collectionTargetCollection;
    }

    @XmlTransient
    public Collection<RouteEmployee> getRouteEmployeeCollection() {
        return routeEmployeeCollection;
    }

    public void setRouteEmployeeCollection(Collection<RouteEmployee> routeEmployeeCollection) {
        this.routeEmployeeCollection = routeEmployeeCollection;
    }

    @XmlTransient
    public Collection<LeafRateManager> getLeafRateManagerCollection() {
        return leafRateManagerCollection;
    }

    public void setLeafRateManagerCollection(Collection<LeafRateManager> leafRateManagerCollection) {
        this.leafRateManagerCollection = leafRateManagerCollection;
    }

    @XmlTransient
    public Collection<RouteTransportRateHistory> getRouteTransportRateHistoryCollection() {
        return routeTransportRateHistoryCollection;
    }

    public void setRouteTransportRateHistoryCollection(Collection<RouteTransportRateHistory> routeTransportRateHistoryCollection) {
        this.routeTransportRateHistoryCollection = routeTransportRateHistoryCollection;
    }

    @XmlTransient
    public Collection<SupplierPassbook> getSupplierPassbookCollection() {
        return supplierPassbookCollection;
    }

    public void setSupplierPassbookCollection(Collection<SupplierPassbook> supplierPassbookCollection) {
        this.supplierPassbookCollection = supplierPassbookCollection;
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
        if (!(object instanceof Route)) {
            return false;
        }
        Route other = (Route) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.Route[ id=" + id + " ]";
    }
    
}
