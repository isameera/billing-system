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
@Table(name = "leaf_final_payment_rate_by_route")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LeafFinalPaymentRateByRoute.findAll", query = "SELECT l FROM LeafFinalPaymentRateByRoute l")
    , @NamedQuery(name = "LeafFinalPaymentRateByRoute.findById", query = "SELECT l FROM LeafFinalPaymentRateByRoute l WHERE l.id = :id")
    , @NamedQuery(name = "LeafFinalPaymentRateByRoute.findByYear", query = "SELECT l FROM LeafFinalPaymentRateByRoute l WHERE l.year = :year")
    , @NamedQuery(name = "LeafFinalPaymentRateByRoute.findByMonth", query = "SELECT l FROM LeafFinalPaymentRateByRoute l WHERE l.month = :month")
    , @NamedQuery(name = "LeafFinalPaymentRateByRoute.findByRate", query = "SELECT l FROM LeafFinalPaymentRateByRoute l WHERE l.rate = :rate")})
public class LeafFinalPaymentRateByRoute implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "year")
    private Integer year;
    @Column(name = "month")
    private Integer month;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rate")
    private Double rate;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Route routeId;

    public LeafFinalPaymentRateByRoute() {
    }

    public LeafFinalPaymentRateByRoute(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LeafFinalPaymentRateByRoute)) {
            return false;
        }
        LeafFinalPaymentRateByRoute other = (LeafFinalPaymentRateByRoute) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.LeafFinalPaymentRateByRoute[ id=" + id + " ]";
    }
    
}
