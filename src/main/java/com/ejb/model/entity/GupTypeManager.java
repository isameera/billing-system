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
@Table(name = "gup_type_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GupTypeManager.findAll", query = "SELECT g FROM GupTypeManager g")
    , @NamedQuery(name = "GupTypeManager.findByIdGtm", query = "SELECT g FROM GupTypeManager g WHERE g.idGtm = :idGtm")})
public class GupTypeManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_gtm")
    private Integer idGtm;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "gup_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GupType gupTypeId;

    public GupTypeManager() {
    }

    public GupTypeManager(Integer idGtm) {
        this.idGtm = idGtm;
    }

    public Integer getIdGtm() {
        return idGtm;
    }

    public void setIdGtm(Integer idGtm) {
        this.idGtm = idGtm;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
    }

    public GupType getGupTypeId() {
        return gupTypeId;
    }

    public void setGupTypeId(GupType gupTypeId) {
        this.gupTypeId = gupTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGtm != null ? idGtm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GupTypeManager)) {
            return false;
        }
        GupTypeManager other = (GupTypeManager) object;
        if ((this.idGtm == null && other.idGtm != null) || (this.idGtm != null && !this.idGtm.equals(other.idGtm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.GupTypeManager[ idGtm=" + idGtm + " ]";
    }
    
}
