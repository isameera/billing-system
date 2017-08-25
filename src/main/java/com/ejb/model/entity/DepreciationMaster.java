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
@Table(name = "depreciation_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DepreciationMaster.findAll", query = "SELECT d FROM DepreciationMaster d")
    , @NamedQuery(name = "DepreciationMaster.findById", query = "SELECT d FROM DepreciationMaster d WHERE d.id = :id")
    , @NamedQuery(name = "DepreciationMaster.findByDuration", query = "SELECT d FROM DepreciationMaster d WHERE d.duration = :duration")
    , @NamedQuery(name = "DepreciationMaster.findByCurrentValue", query = "SELECT d FROM DepreciationMaster d WHERE d.currentValue = :currentValue")
    , @NamedQuery(name = "DepreciationMaster.findByMonthlyDepreciationAmount", query = "SELECT d FROM DepreciationMaster d WHERE d.monthlyDepreciationAmount = :monthlyDepreciationAmount")})
public class DepreciationMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "duration")
    private Integer duration;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "current_value")
    private Double currentValue;
    @Column(name = "monthly_depreciation_amount")
    private Double monthlyDepreciationAmount;
    @JoinColumn(name = "org_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrgItem orgItemId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "depreciationMasterId")
    private Collection<DepreciationHistory> depreciationHistoryCollection;

    public DepreciationMaster() {
    }

    public DepreciationMaster(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

    public Double getMonthlyDepreciationAmount() {
        return monthlyDepreciationAmount;
    }

    public void setMonthlyDepreciationAmount(Double monthlyDepreciationAmount) {
        this.monthlyDepreciationAmount = monthlyDepreciationAmount;
    }

    public OrgItem getOrgItemId() {
        return orgItemId;
    }

    public void setOrgItemId(OrgItem orgItemId) {
        this.orgItemId = orgItemId;
    }

    @XmlTransient
    public Collection<DepreciationHistory> getDepreciationHistoryCollection() {
        return depreciationHistoryCollection;
    }

    public void setDepreciationHistoryCollection(Collection<DepreciationHistory> depreciationHistoryCollection) {
        this.depreciationHistoryCollection = depreciationHistoryCollection;
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
        if (!(object instanceof DepreciationMaster)) {
            return false;
        }
        DepreciationMaster other = (DepreciationMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.DepreciationMaster[ id=" + id + " ]";
    }
    
}
