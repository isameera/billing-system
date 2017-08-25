/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "route_transport_rate_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RouteTransportRateHistory.findAll", query = "SELECT r FROM RouteTransportRateHistory r")
    , @NamedQuery(name = "RouteTransportRateHistory.findById", query = "SELECT r FROM RouteTransportRateHistory r WHERE r.id = :id")
    , @NamedQuery(name = "RouteTransportRateHistory.findByRate", query = "SELECT r FROM RouteTransportRateHistory r WHERE r.rate = :rate")
    , @NamedQuery(name = "RouteTransportRateHistory.findByYear", query = "SELECT r FROM RouteTransportRateHistory r WHERE r.year = :year")
    , @NamedQuery(name = "RouteTransportRateHistory.findByMonth", query = "SELECT r FROM RouteTransportRateHistory r WHERE r.month = :month")})
public class RouteTransportRateHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rate")
    private Double rate;
    @Column(name = "year")
    private Integer year;
    @Column(name = "month")
    private Integer month;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "route", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Route route;

    public RouteTransportRateHistory() {
    }

    public RouteTransportRateHistory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
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
        if (!(object instanceof RouteTransportRateHistory)) {
            return false;
        }
        RouteTransportRateHistory other = (RouteTransportRateHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.RouteTransportRateHistory[ id=" + id + " ]";
    }
    
}
