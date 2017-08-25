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
@Table(name = "route_collection_summary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RouteCollectionSummary.findAll", query = "SELECT r FROM RouteCollectionSummary r")
    , @NamedQuery(name = "RouteCollectionSummary.findById", query = "SELECT r FROM RouteCollectionSummary r WHERE r.id = :id")
    , @NamedQuery(name = "RouteCollectionSummary.findByDate", query = "SELECT r FROM RouteCollectionSummary r WHERE r.date = :date")
    , @NamedQuery(name = "RouteCollectionSummary.findByTotalCollections", query = "SELECT r FROM RouteCollectionSummary r WHERE r.totalCollections = :totalCollections")
    , @NamedQuery(name = "RouteCollectionSummary.findByTotalLoss", query = "SELECT r FROM RouteCollectionSummary r WHERE r.totalLoss = :totalLoss")
    , @NamedQuery(name = "RouteCollectionSummary.findByDayTarget", query = "SELECT r FROM RouteCollectionSummary r WHERE r.dayTarget = :dayTarget")
    , @NamedQuery(name = "RouteCollectionSummary.findByB", query = "SELECT r FROM RouteCollectionSummary r WHERE r.b = :b")
    , @NamedQuery(name = "RouteCollectionSummary.findByBb", query = "SELECT r FROM RouteCollectionSummary r WHERE r.bb = :bb")
    , @NamedQuery(name = "RouteCollectionSummary.findByP", query = "SELECT r FROM RouteCollectionSummary r WHERE r.p = :p")})
public class RouteCollectionSummary implements Serializable {

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
    @Column(name = "total_collections")
    private Double totalCollections;
    @Column(name = "total_loss")
    private Double totalLoss;
    @Column(name = "day_target")
    private Double dayTarget;
    @Column(name = "b")
    private Double b;
    @Column(name = "bb")
    private Double bb;
    @Column(name = "p")
    private Double p;
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Route routeId;

    public RouteCollectionSummary() {
    }

    public RouteCollectionSummary(Integer id) {
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

    public Double getTotalCollections() {
        return totalCollections;
    }

    public void setTotalCollections(Double totalCollections) {
        this.totalCollections = totalCollections;
    }

    public Double getTotalLoss() {
        return totalLoss;
    }

    public void setTotalLoss(Double totalLoss) {
        this.totalLoss = totalLoss;
    }

    public Double getDayTarget() {
        return dayTarget;
    }

    public void setDayTarget(Double dayTarget) {
        this.dayTarget = dayTarget;
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

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
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
        if (!(object instanceof RouteCollectionSummary)) {
            return false;
        }
        RouteCollectionSummary other = (RouteCollectionSummary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.RouteCollectionSummary[ id=" + id + " ]";
    }
    
}
