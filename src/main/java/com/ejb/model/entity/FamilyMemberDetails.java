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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "family_member_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FamilyMemberDetails.findAll", query = "SELECT f FROM FamilyMemberDetails f")
    , @NamedQuery(name = "FamilyMemberDetails.findById", query = "SELECT f FROM FamilyMemberDetails f WHERE f.id = :id")
    , @NamedQuery(name = "FamilyMemberDetails.findByIsExsistingSupplier", query = "SELECT f FROM FamilyMemberDetails f WHERE f.isExsistingSupplier = :isExsistingSupplier")
    , @NamedQuery(name = "FamilyMemberDetails.findByFamilyMemberOrDependent", query = "SELECT f FROM FamilyMemberDetails f WHERE f.familyMemberOrDependent = :familyMemberOrDependent")
    , @NamedQuery(name = "FamilyMemberDetails.findByIsWelfareMember", query = "SELECT f FROM FamilyMemberDetails f WHERE f.isWelfareMember = :isWelfareMember")})
public class FamilyMemberDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "is_exsisting_supplier")
    private Integer isExsistingSupplier;
    @Size(max = 45)
    @Column(name = "family_member_or_dependent")
    private String familyMemberOrDependent;
    @Column(name = "is_welfare_member")
    private Integer isWelfareMember;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "familyMemberDetailsId")
    private Collection<SupplierWelfareMemberPayment> supplierWelfareMemberPaymentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "familyMemberDetailsId")
    private Collection<ChildrenDetails> childrenDetailsCollection;
    @JoinColumn(name = "family_member_relationship_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Relationship familyMemberRelationshipId;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierRegistration supplierRegistrationId;

    public FamilyMemberDetails() {
    }

    public FamilyMemberDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsExsistingSupplier() {
        return isExsistingSupplier;
    }

    public void setIsExsistingSupplier(Integer isExsistingSupplier) {
        this.isExsistingSupplier = isExsistingSupplier;
    }

    public String getFamilyMemberOrDependent() {
        return familyMemberOrDependent;
    }

    public void setFamilyMemberOrDependent(String familyMemberOrDependent) {
        this.familyMemberOrDependent = familyMemberOrDependent;
    }

    public Integer getIsWelfareMember() {
        return isWelfareMember;
    }

    public void setIsWelfareMember(Integer isWelfareMember) {
        this.isWelfareMember = isWelfareMember;
    }

    @XmlTransient
    public Collection<SupplierWelfareMemberPayment> getSupplierWelfareMemberPaymentCollection() {
        return supplierWelfareMemberPaymentCollection;
    }

    public void setSupplierWelfareMemberPaymentCollection(Collection<SupplierWelfareMemberPayment> supplierWelfareMemberPaymentCollection) {
        this.supplierWelfareMemberPaymentCollection = supplierWelfareMemberPaymentCollection;
    }

    @XmlTransient
    public Collection<ChildrenDetails> getChildrenDetailsCollection() {
        return childrenDetailsCollection;
    }

    public void setChildrenDetailsCollection(Collection<ChildrenDetails> childrenDetailsCollection) {
        this.childrenDetailsCollection = childrenDetailsCollection;
    }

    public Relationship getFamilyMemberRelationshipId() {
        return familyMemberRelationshipId;
    }

    public void setFamilyMemberRelationshipId(Relationship familyMemberRelationshipId) {
        this.familyMemberRelationshipId = familyMemberRelationshipId;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
    }

    public SupplierRegistration getSupplierRegistrationId() {
        return supplierRegistrationId;
    }

    public void setSupplierRegistrationId(SupplierRegistration supplierRegistrationId) {
        this.supplierRegistrationId = supplierRegistrationId;
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
        if (!(object instanceof FamilyMemberDetails)) {
            return false;
        }
        FamilyMemberDetails other = (FamilyMemberDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.FamilyMemberDetails[ id=" + id + " ]";
    }
    
}
