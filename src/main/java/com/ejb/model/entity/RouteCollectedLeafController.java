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
@Table(name = "route_collected_leaf_controller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RouteCollectedLeafController.findAll", query = "SELECT r FROM RouteCollectedLeafController r")
    , @NamedQuery(name = "RouteCollectedLeafController.findById", query = "SELECT r FROM RouteCollectedLeafController r WHERE r.id = :id")
    , @NamedQuery(name = "RouteCollectedLeafController.findByDate", query = "SELECT r FROM RouteCollectedLeafController r WHERE r.date = :date")
    , @NamedQuery(name = "RouteCollectedLeafController.findByNetWeight", query = "SELECT r FROM RouteCollectedLeafController r WHERE r.netWeight = :netWeight")
    , @NamedQuery(name = "RouteCollectedLeafController.findByNoOfPackage", query = "SELECT r FROM RouteCollectedLeafController r WHERE r.noOfPackage = :noOfPackage")
    , @NamedQuery(name = "RouteCollectedLeafController.findByPackageWeight", query = "SELECT r FROM RouteCollectedLeafController r WHERE r.packageWeight = :packageWeight")
    , @NamedQuery(name = "RouteCollectedLeafController.findByTotalWeight", query = "SELECT r FROM RouteCollectedLeafController r WHERE r.totalWeight = :totalWeight")
    , @NamedQuery(name = "RouteCollectedLeafController.findByWaterWeight", query = "SELECT r FROM RouteCollectedLeafController r WHERE r.waterWeight = :waterWeight")
    , @NamedQuery(name = "RouteCollectedLeafController.findByOtherWeight", query = "SELECT r FROM RouteCollectedLeafController r WHERE r.otherWeight = :otherWeight")
    , @NamedQuery(name = "RouteCollectedLeafController.findByReturnBagCount", query = "SELECT r FROM RouteCollectedLeafController r WHERE r.returnBagCount = :returnBagCount")
    , @NamedQuery(name = "RouteCollectedLeafController.findByReturnWeight", query = "SELECT r FROM RouteCollectedLeafController r WHERE r.returnWeight = :returnWeight")
    , @NamedQuery(name = "RouteCollectedLeafController.findByB", query = "SELECT r FROM RouteCollectedLeafController r WHERE r.b = :b")
    , @NamedQuery(name = "RouteCollectedLeafController.findByBb", query = "SELECT r FROM RouteCollectedLeafController r WHERE r.bb = :bb")
    , @NamedQuery(name = "RouteCollectedLeafController.findByP", query = "SELECT r FROM RouteCollectedLeafController r WHERE r.p = :p")
    , @NamedQuery(name = "RouteCollectedLeafController.findByIsConfermed", query = "SELECT r FROM RouteCollectedLeafController r WHERE r.isConfermed = :isConfermed")})
public class RouteCollectedLeafController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "net_weight")
    private Double netWeight;
    @Column(name = "no_of_package")
    private Double noOfPackage;
    @Column(name = "package_weight")
    private Double packageWeight;
    @Column(name = "total_weight")
    private Double totalWeight;
    @Column(name = "water_weight")
    private Double waterWeight;
    @Column(name = "other_weight")
    private Double otherWeight;
    @Column(name = "return_bag_count")
    private Double returnBagCount;
    @Column(name = "return_weight")
    private Double returnWeight;
    @Column(name = "b")
    private Double b;
    @Column(name = "bb")
    private Double bb;
    @Column(name = "p")
    private Double p;
    @Column(name = "is_confermed")
    private Integer isConfermed;
    @JoinColumn(name = "leaf_package_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LeafPackageType leafPackageTypeId;
    @JoinColumn(name = "leaf_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LeafType leafTypeId;
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Route routeId;
    @JoinColumn(name = "route_collected_leaf_controller_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RouteCollectedLeafControllerType routeCollectedLeafControllerTypeId;

    public RouteCollectedLeafController() {
    }

    public RouteCollectedLeafController(Integer id) {
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

    public Double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(Double netWeight) {
        this.netWeight = netWeight;
    }

    public Double getNoOfPackage() {
        return noOfPackage;
    }

    public void setNoOfPackage(Double noOfPackage) {
        this.noOfPackage = noOfPackage;
    }

    public Double getPackageWeight() {
        return packageWeight;
    }

    public void setPackageWeight(Double packageWeight) {
        this.packageWeight = packageWeight;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Double getWaterWeight() {
        return waterWeight;
    }

    public void setWaterWeight(Double waterWeight) {
        this.waterWeight = waterWeight;
    }

    public Double getOtherWeight() {
        return otherWeight;
    }

    public void setOtherWeight(Double otherWeight) {
        this.otherWeight = otherWeight;
    }

    public Double getReturnBagCount() {
        return returnBagCount;
    }

    public void setReturnBagCount(Double returnBagCount) {
        this.returnBagCount = returnBagCount;
    }

    public Double getReturnWeight() {
        return returnWeight;
    }

    public void setReturnWeight(Double returnWeight) {
        this.returnWeight = returnWeight;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    public Double getBb() {
        return bb;
    }

    public void setBb(Double bb) {
        this.bb = bb;
    }

    public Double getP() {
        return p;
    }

    public void setP(Double p) {
        this.p = p;
    }

    public Integer getIsConfermed() {
        return isConfermed;
    }

    public void setIsConfermed(Integer isConfermed) {
        this.isConfermed = isConfermed;
    }

    public LeafPackageType getLeafPackageTypeId() {
        return leafPackageTypeId;
    }

    public void setLeafPackageTypeId(LeafPackageType leafPackageTypeId) {
        this.leafPackageTypeId = leafPackageTypeId;
    }

    public LeafType getLeafTypeId() {
        return leafTypeId;
    }

    public void setLeafTypeId(LeafType leafTypeId) {
        this.leafTypeId = leafTypeId;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    public RouteCollectedLeafControllerType getRouteCollectedLeafControllerTypeId() {
        return routeCollectedLeafControllerTypeId;
    }

    public void setRouteCollectedLeafControllerTypeId(RouteCollectedLeafControllerType routeCollectedLeafControllerTypeId) {
        this.routeCollectedLeafControllerTypeId = routeCollectedLeafControllerTypeId;
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
        if (!(object instanceof RouteCollectedLeafController)) {
            return false;
        }
        RouteCollectedLeafController other = (RouteCollectedLeafController) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.RouteCollectedLeafController[ id=" + id + " ]";
    }
    
}
