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
@Table(name = "designation_level_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DesignationLevelManager.findAll", query = "SELECT d FROM DesignationLevelManager d")
    , @NamedQuery(name = "DesignationLevelManager.findById", query = "SELECT d FROM DesignationLevelManager d WHERE d.id = :id")})
public class DesignationLevelManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "designationLevelManagerId")
    private Collection<DesignationLevelUserManager> designationLevelUserManagerCollection;
    @JoinColumn(name = "designation_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Designation designationId;
    @JoinColumn(name = "designation_level_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DesignationLevel designationLevelId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;

    public DesignationLevelManager() {
    }

    public DesignationLevelManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<DesignationLevelUserManager> getDesignationLevelUserManagerCollection() {
        return designationLevelUserManagerCollection;
    }

    public void setDesignationLevelUserManagerCollection(Collection<DesignationLevelUserManager> designationLevelUserManagerCollection) {
        this.designationLevelUserManagerCollection = designationLevelUserManagerCollection;
    }

    public Designation getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Designation designationId) {
        this.designationId = designationId;
    }

    public DesignationLevel getDesignationLevelId() {
        return designationLevelId;
    }

    public void setDesignationLevelId(DesignationLevel designationLevelId) {
        this.designationLevelId = designationLevelId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
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
        if (!(object instanceof DesignationLevelManager)) {
            return false;
        }
        DesignationLevelManager other = (DesignationLevelManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.DesignationLevelManager[ id=" + id + " ]";
    }
    
}
