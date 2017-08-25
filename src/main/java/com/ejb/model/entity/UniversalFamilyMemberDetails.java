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
@Table(name = "universal_family_member_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniversalFamilyMemberDetails.findAll", query = "SELECT u FROM UniversalFamilyMemberDetails u")
    , @NamedQuery(name = "UniversalFamilyMemberDetails.findById", query = "SELECT u FROM UniversalFamilyMemberDetails u WHERE u.id = :id")
    , @NamedQuery(name = "UniversalFamilyMemberDetails.findByIsWelfare", query = "SELECT u FROM UniversalFamilyMemberDetails u WHERE u.isWelfare = :isWelfare")
    , @NamedQuery(name = "UniversalFamilyMemberDetails.findByFamilyMemberOrDependent", query = "SELECT u FROM UniversalFamilyMemberDetails u WHERE u.familyMemberOrDependent = :familyMemberOrDependent")})
public class UniversalFamilyMemberDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "is_welfare")
    private Integer isWelfare;
    @Column(name = "family_member_or_dependent")
    private Integer familyMemberOrDependent;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "general_user_profile_id1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalFamilyMemberDetailsId")
    private Collection<WelfareMemberPayments> welfareMemberPaymentsCollection;

    public UniversalFamilyMemberDetails() {
    }

    public UniversalFamilyMemberDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsWelfare() {
        return isWelfare;
    }

    public void setIsWelfare(Integer isWelfare) {
        this.isWelfare = isWelfare;
    }

    public Integer getFamilyMemberOrDependent() {
        return familyMemberOrDependent;
    }

    public void setFamilyMemberOrDependent(Integer familyMemberOrDependent) {
        this.familyMemberOrDependent = familyMemberOrDependent;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
    }

    public GeneralUserProfile getGeneralUserProfileId1() {
        return generalUserProfileId1;
    }

    public void setGeneralUserProfileId1(GeneralUserProfile generalUserProfileId1) {
        this.generalUserProfileId1 = generalUserProfileId1;
    }

    @XmlTransient
    public Collection<WelfareMemberPayments> getWelfareMemberPaymentsCollection() {
        return welfareMemberPaymentsCollection;
    }

    public void setWelfareMemberPaymentsCollection(Collection<WelfareMemberPayments> welfareMemberPaymentsCollection) {
        this.welfareMemberPaymentsCollection = welfareMemberPaymentsCollection;
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
        if (!(object instanceof UniversalFamilyMemberDetails)) {
            return false;
        }
        UniversalFamilyMemberDetails other = (UniversalFamilyMemberDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UniversalFamilyMemberDetails[ id=" + id + " ]";
    }
    
}
