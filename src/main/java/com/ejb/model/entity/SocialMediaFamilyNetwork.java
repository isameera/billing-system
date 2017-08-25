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
@Table(name = "social_media_family_network")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SocialMediaFamilyNetwork.findAll", query = "SELECT s FROM SocialMediaFamilyNetwork s")
    , @NamedQuery(name = "SocialMediaFamilyNetwork.findById", query = "SELECT s FROM SocialMediaFamilyNetwork s WHERE s.id = :id")})
public class SocialMediaFamilyNetwork implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "civil_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CivilStatus civilStatusId;
    @JoinColumn(name = "general_user_profile_id_father", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileIdFather;
    @JoinColumn(name = "general_user_profile_id_mother", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileIdMother;
    @JoinColumn(name = "general_user_profile_id_child", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileIdChild;

    public SocialMediaFamilyNetwork() {
    }

    public SocialMediaFamilyNetwork(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CivilStatus getCivilStatusId() {
        return civilStatusId;
    }

    public void setCivilStatusId(CivilStatus civilStatusId) {
        this.civilStatusId = civilStatusId;
    }

    public GeneralUserProfile getGeneralUserProfileIdFather() {
        return generalUserProfileIdFather;
    }

    public void setGeneralUserProfileIdFather(GeneralUserProfile generalUserProfileIdFather) {
        this.generalUserProfileIdFather = generalUserProfileIdFather;
    }

    public GeneralUserProfile getGeneralUserProfileIdMother() {
        return generalUserProfileIdMother;
    }

    public void setGeneralUserProfileIdMother(GeneralUserProfile generalUserProfileIdMother) {
        this.generalUserProfileIdMother = generalUserProfileIdMother;
    }

    public GeneralUserProfile getGeneralUserProfileIdChild() {
        return generalUserProfileIdChild;
    }

    public void setGeneralUserProfileIdChild(GeneralUserProfile generalUserProfileIdChild) {
        this.generalUserProfileIdChild = generalUserProfileIdChild;
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
        if (!(object instanceof SocialMediaFamilyNetwork)) {
            return false;
        }
        SocialMediaFamilyNetwork other = (SocialMediaFamilyNetwork) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SocialMediaFamilyNetwork[ id=" + id + " ]";
    }
    
}
