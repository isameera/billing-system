/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "welfare_committee_members")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WelfareCommitteeMembers.findAll", query = "SELECT w FROM WelfareCommitteeMembers w")
    , @NamedQuery(name = "WelfareCommitteeMembers.findById", query = "SELECT w FROM WelfareCommitteeMembers w WHERE w.id = :id")
    , @NamedQuery(name = "WelfareCommitteeMembers.findByCmid", query = "SELECT w FROM WelfareCommitteeMembers w WHERE w.cmid = :cmid")
    , @NamedQuery(name = "WelfareCommitteeMembers.findByRegDate", query = "SELECT w FROM WelfareCommitteeMembers w WHERE w.regDate = :regDate")
    , @NamedQuery(name = "WelfareCommitteeMembers.findBySignature", query = "SELECT w FROM WelfareCommitteeMembers w WHERE w.signature = :signature")})
public class WelfareCommitteeMembers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "cmid")
    private String cmid;
    @Column(name = "reg_date")
    @Temporal(TemporalType.DATE)
    private Date regDate;
    @Size(max = 45)
    @Column(name = "signature")
    private String signature;
    @JoinColumn(name = "committee_member_posision_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CommitteeMemberPosision committeeMemberPosisionId;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne
    private SupplierRegistration supplierRegistrationId;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;

    public WelfareCommitteeMembers() {
    }

    public WelfareCommitteeMembers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCmid() {
        return cmid;
    }

    public void setCmid(String cmid) {
        this.cmid = cmid;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public CommitteeMemberPosision getCommitteeMemberPosisionId() {
        return committeeMemberPosisionId;
    }

    public void setCommitteeMemberPosisionId(CommitteeMemberPosision committeeMemberPosisionId) {
        this.committeeMemberPosisionId = committeeMemberPosisionId;
    }

    public SupplierRegistration getSupplierRegistrationId() {
        return supplierRegistrationId;
    }

    public void setSupplierRegistrationId(SupplierRegistration supplierRegistrationId) {
        this.supplierRegistrationId = supplierRegistrationId;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
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
        if (!(object instanceof WelfareCommitteeMembers)) {
            return false;
        }
        WelfareCommitteeMembers other = (WelfareCommitteeMembers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.WelfareCommitteeMembers[ id=" + id + " ]";
    }
    
}
