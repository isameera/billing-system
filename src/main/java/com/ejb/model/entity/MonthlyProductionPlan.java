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
@Table(name = "monthly_production_plan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MonthlyProductionPlan.findAll", query = "SELECT m FROM MonthlyProductionPlan m")
    , @NamedQuery(name = "MonthlyProductionPlan.findById", query = "SELECT m FROM MonthlyProductionPlan m WHERE m.id = :id")
    , @NamedQuery(name = "MonthlyProductionPlan.findByTarget", query = "SELECT m FROM MonthlyProductionPlan m WHERE m.target = :target")
    , @NamedQuery(name = "MonthlyProductionPlan.findByAchieved", query = "SELECT m FROM MonthlyProductionPlan m WHERE m.achieved = :achieved")
    , @NamedQuery(name = "MonthlyProductionPlan.findByYear", query = "SELECT m FROM MonthlyProductionPlan m WHERE m.year = :year")
    , @NamedQuery(name = "MonthlyProductionPlan.findByMonth", query = "SELECT m FROM MonthlyProductionPlan m WHERE m.month = :month")})
public class MonthlyProductionPlan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "target")
    private Double target;
    @Column(name = "achieved")
    private Double achieved;
    @Column(name = "year")
    private Integer year;
    @Column(name = "month")
    private Integer month;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "org_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrgItem orgItemId;

    public MonthlyProductionPlan() {
    }

    public MonthlyProductionPlan(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTarget() {
        return target;
    }

    public void setTarget(Double target) {
        this.target = target;
    }

    public Double getAchieved() {
        return achieved;
    }

    public void setAchieved(Double achieved) {
        this.achieved = achieved;
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

    public OrgItem getOrgItemId() {
        return orgItemId;
    }

    public void setOrgItemId(OrgItem orgItemId) {
        this.orgItemId = orgItemId;
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
        if (!(object instanceof MonthlyProductionPlan)) {
            return false;
        }
        MonthlyProductionPlan other = (MonthlyProductionPlan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.MonthlyProductionPlan[ id=" + id + " ]";
    }
    
}
