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
@Table(name = "universal_settings_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniversalSettingsManager.findAll", query = "SELECT u FROM UniversalSettingsManager u")
    , @NamedQuery(name = "UniversalSettingsManager.findById", query = "SELECT u FROM UniversalSettingsManager u WHERE u.id = :id")
    , @NamedQuery(name = "UniversalSettingsManager.findByValue", query = "SELECT u FROM UniversalSettingsManager u WHERE u.value = :value")
    , @NamedQuery(name = "UniversalSettingsManager.findByPercentage", query = "SELECT u FROM UniversalSettingsManager u WHERE u.percentage = :percentage")
    , @NamedQuery(name = "UniversalSettingsManager.findByAmount", query = "SELECT u FROM UniversalSettingsManager u WHERE u.amount = :amount")})
public class UniversalSettingsManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "value")
    private Double value;
    @Column(name = "percentage")
    private Double percentage;
    @Column(name = "amount")
    private Double amount;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "universal_settings_manager_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalSettingsManagerType universalSettingsManagerTypeId;

    public UniversalSettingsManager() {
    }

    public UniversalSettingsManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public UniversalSettingsManagerType getUniversalSettingsManagerTypeId() {
        return universalSettingsManagerTypeId;
    }

    public void setUniversalSettingsManagerTypeId(UniversalSettingsManagerType universalSettingsManagerTypeId) {
        this.universalSettingsManagerTypeId = universalSettingsManagerTypeId;
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
        if (!(object instanceof UniversalSettingsManager)) {
            return false;
        }
        UniversalSettingsManager other = (UniversalSettingsManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UniversalSettingsManager[ id=" + id + " ]";
    }
    
}
