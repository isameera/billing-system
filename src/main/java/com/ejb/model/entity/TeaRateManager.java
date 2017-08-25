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
@Table(name = "tea_rate_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TeaRateManager.findAll", query = "SELECT t FROM TeaRateManager t")
    , @NamedQuery(name = "TeaRateManager.findById", query = "SELECT t FROM TeaRateManager t WHERE t.id = :id")
    , @NamedQuery(name = "TeaRateManager.findByRate", query = "SELECT t FROM TeaRateManager t WHERE t.rate = :rate")
    , @NamedQuery(name = "TeaRateManager.findByAssignedDate", query = "SELECT t FROM TeaRateManager t WHERE t.assignedDate = :assignedDate")
    , @NamedQuery(name = "TeaRateManager.findByEndDate", query = "SELECT t FROM TeaRateManager t WHERE t.endDate = :endDate")})
public class TeaRateManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rate")
    private Double rate;
    @Column(name = "assigned_date")
    @Temporal(TemporalType.DATE)
    private Date assignedDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "rate_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RateType rateTypeId;

    public TeaRateManager() {
    }

    public TeaRateManager(Integer id) {
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

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public RateType getRateTypeId() {
        return rateTypeId;
    }

    public void setRateTypeId(RateType rateTypeId) {
        this.rateTypeId = rateTypeId;
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
        if (!(object instanceof TeaRateManager)) {
            return false;
        }
        TeaRateManager other = (TeaRateManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.TeaRateManager[ id=" + id + " ]";
    }
    
}
