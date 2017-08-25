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
@Table(name = "family_members")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FamilyMembers.findAll", query = "SELECT f FROM FamilyMembers f")
    , @NamedQuery(name = "FamilyMembers.findById", query = "SELECT f FROM FamilyMembers f WHERE f.id = :id")
    , @NamedQuery(name = "FamilyMembers.findByEmploymentStatus", query = "SELECT f FROM FamilyMembers f WHERE f.employmentStatus = :employmentStatus")
    , @NamedQuery(name = "FamilyMembers.findByMemberOrDependent", query = "SELECT f FROM FamilyMembers f WHERE f.memberOrDependent = :memberOrDependent")})
public class FamilyMembers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "employment_status")
    private Boolean employmentStatus;
    @Column(name = "member_or_dependent")
    private Boolean memberOrDependent;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile employee;
    @JoinColumn(name = "relationship_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Relationship relationshipId;
    @JoinColumn(name = "family_member", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile familyMember;

    public FamilyMembers() {
    }

    public FamilyMembers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(Boolean employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public Boolean getMemberOrDependent() {
        return memberOrDependent;
    }

    public void setMemberOrDependent(Boolean memberOrDependent) {
        this.memberOrDependent = memberOrDependent;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public GeneralUserProfile getEmployee() {
        return employee;
    }

    public void setEmployee(GeneralUserProfile employee) {
        this.employee = employee;
    }

    public Relationship getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(Relationship relationshipId) {
        this.relationshipId = relationshipId;
    }

    public GeneralUserProfile getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(GeneralUserProfile familyMember) {
        this.familyMember = familyMember;
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
        if (!(object instanceof FamilyMembers)) {
            return false;
        }
        FamilyMembers other = (FamilyMembers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.FamilyMembers[ id=" + id + " ]";
    }
    
}
