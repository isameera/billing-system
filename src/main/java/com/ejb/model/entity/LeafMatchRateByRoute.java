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
@Table(name = "leaf_match_rate_by_route")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LeafMatchRateByRoute.findAll", query = "SELECT l FROM LeafMatchRateByRoute l")
    , @NamedQuery(name = "LeafMatchRateByRoute.findById", query = "SELECT l FROM LeafMatchRateByRoute l WHERE l.id = :id")
    , @NamedQuery(name = "LeafMatchRateByRoute.findByRateFrom", query = "SELECT l FROM LeafMatchRateByRoute l WHERE l.rateFrom = :rateFrom")
    , @NamedQuery(name = "LeafMatchRateByRoute.findByRateTo", query = "SELECT l FROM LeafMatchRateByRoute l WHERE l.rateTo = :rateTo")
    , @NamedQuery(name = "LeafMatchRateByRoute.findByYear", query = "SELECT l FROM LeafMatchRateByRoute l WHERE l.year = :year")
    , @NamedQuery(name = "LeafMatchRateByRoute.findByMonth", query = "SELECT l FROM LeafMatchRateByRoute l WHERE l.month = :month")})
public class LeafMatchRateByRoute implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rate_from")
    private Double rateFrom;
    @Column(name = "rate_to")
    private Double rateTo;
    @Column(name = "year")
    private Integer year;
    @Column(name = "month")
    private Integer month;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Route routeId;
    @JoinColumn(name = "user_role_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserRole userRoleId;

    public LeafMatchRateByRoute() {
    }

    public LeafMatchRateByRoute(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getRateFrom() {
        return rateFrom;
    }

    public void setRateFrom(Double rateFrom) {
        this.rateFrom = rateFrom;
    }

    public Double getRateTo() {
        return rateTo;
    }

    public void setRateTo(Double rateTo) {
        this.rateTo = rateTo;
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

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    public UserRole getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(UserRole userRoleId) {
        this.userRoleId = userRoleId;
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
        if (!(object instanceof LeafMatchRateByRoute)) {
            return false;
        }
        LeafMatchRateByRoute other = (LeafMatchRateByRoute) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.LeafMatchRateByRoute[ id=" + id + " ]";
    }
    
}
