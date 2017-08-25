/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "gup_gop_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GupGopManager.findAll", query = "SELECT g FROM GupGopManager g")
    , @NamedQuery(name = "GupGopManager.findById", query = "SELECT g FROM GupGopManager g WHERE g.id = :id")
    , @NamedQuery(name = "GupGopManager.findByStartDate", query = "SELECT g FROM GupGopManager g WHERE g.startDate = :startDate")
    , @NamedQuery(name = "GupGopManager.findByEndDate", query = "SELECT g FROM GupGopManager g WHERE g.endDate = :endDate")
    , @NamedQuery(name = "GupGopManager.findByCode", query = "SELECT g FROM GupGopManager g WHERE g.code = :code")})
public class GupGopManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Size(max = 45)
    @Column(name = "code")
    private String code;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gupGopManagerId")
    private Collection<GupGopDesignationManager> gupGopDesignationManagerCollection;

    public GupGopManager() {
    }

    public GupGopManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
    }

    @XmlTransient
    public Collection<GupGopDesignationManager> getGupGopDesignationManagerCollection() {
        return gupGopDesignationManagerCollection;
    }

    public void setGupGopDesignationManagerCollection(Collection<GupGopDesignationManager> gupGopDesignationManagerCollection) {
        this.gupGopDesignationManagerCollection = gupGopDesignationManagerCollection;
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
        if (!(object instanceof GupGopManager)) {
            return false;
        }
        GupGopManager other = (GupGopManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.GupGopManager[ id=" + id + " ]";
    }
    
}
