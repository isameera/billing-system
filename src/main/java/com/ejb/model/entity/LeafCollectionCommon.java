/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "leaf_collection_common")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LeafCollectionCommon.findAll", query = "SELECT l FROM LeafCollectionCommon l")
    , @NamedQuery(name = "LeafCollectionCommon.findById", query = "SELECT l FROM LeafCollectionCommon l WHERE l.id = :id")
    , @NamedQuery(name = "LeafCollectionCommon.findByReturnWeight", query = "SELECT l FROM LeafCollectionCommon l WHERE l.returnWeight = :returnWeight")
    , @NamedQuery(name = "LeafCollectionCommon.findByWaterWeight", query = "SELECT l FROM LeafCollectionCommon l WHERE l.waterWeight = :waterWeight")
    , @NamedQuery(name = "LeafCollectionCommon.findByTotalWeight", query = "SELECT l FROM LeafCollectionCommon l WHERE l.totalWeight = :totalWeight")
    , @NamedQuery(name = "LeafCollectionCommon.findByPackgeWeight", query = "SELECT l FROM LeafCollectionCommon l WHERE l.packgeWeight = :packgeWeight")
    , @NamedQuery(name = "LeafCollectionCommon.findByNoOfPackge", query = "SELECT l FROM LeafCollectionCommon l WHERE l.noOfPackge = :noOfPackge")
    , @NamedQuery(name = "LeafCollectionCommon.findByNetWeigth", query = "SELECT l FROM LeafCollectionCommon l WHERE l.netWeigth = :netWeigth")
    , @NamedQuery(name = "LeafCollectionCommon.findByB", query = "SELECT l FROM LeafCollectionCommon l WHERE l.b = :b")
    , @NamedQuery(name = "LeafCollectionCommon.findByBb", query = "SELECT l FROM LeafCollectionCommon l WHERE l.bb = :bb")
    , @NamedQuery(name = "LeafCollectionCommon.findByP", query = "SELECT l FROM LeafCollectionCommon l WHERE l.p = :p")})
public class LeafCollectionCommon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "return_weight")
    private Double returnWeight;
    @Column(name = "water_weight")
    private Double waterWeight;
    @Column(name = "total_weight")
    private Double totalWeight;
    @Column(name = "packge_weight")
    private Double packgeWeight;
    @Column(name = "no_of_packge")
    private Double noOfPackge;
    @Column(name = "net_weigth")
    private Double netWeigth;
    @Column(name = "b")
    private Double b;
    @Column(name = "bb")
    private Double bb;
    @Column(name = "p")
    private Double p;
    @JoinColumn(name = "leaf_package_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LeafPackageType leafPackageTypeId;
    @JoinColumn(name = "leaf_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LeafType leafTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leafCollectionCommonId")
    private Collection<FactoryCollectedLeaf> factoryCollectedLeafCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leafCollectionCommonId")
    private Collection<RouteCollectedLeaf> routeCollectedLeafCollection;

    public LeafCollectionCommon() {
    }

    public LeafCollectionCommon(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getReturnWeight() {
        return returnWeight;
    }

    public void setReturnWeight(Double returnWeight) {
        this.returnWeight = returnWeight;
    }

    public Double getWaterWeight() {
        return waterWeight;
    }

    public void setWaterWeight(Double waterWeight) {
        this.waterWeight = waterWeight;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Double getPackgeWeight() {
        return packgeWeight;
    }

    public void setPackgeWeight(Double packgeWeight) {
        this.packgeWeight = packgeWeight;
    }

    public Double getNoOfPackge() {
        return noOfPackge;
    }

    public void setNoOfPackge(Double noOfPackge) {
        this.noOfPackge = noOfPackge;
    }

    public Double getNetWeigth() {
        return netWeigth;
    }

    public void setNetWeigth(Double netWeigth) {
        this.netWeigth = netWeigth;
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

    @XmlTransient
    public Collection<FactoryCollectedLeaf> getFactoryCollectedLeafCollection() {
        return factoryCollectedLeafCollection;
    }

    public void setFactoryCollectedLeafCollection(Collection<FactoryCollectedLeaf> factoryCollectedLeafCollection) {
        this.factoryCollectedLeafCollection = factoryCollectedLeafCollection;
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
        if (!(object instanceof LeafCollectionCommon)) {
            return false;
        }
        LeafCollectionCommon other = (LeafCollectionCommon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.LeafCollectionCommon[ id=" + id + " ]";
    }
    
}
