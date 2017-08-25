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
@Table(name = "social_media_user_groups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SocialMediaUserGroups.findAll", query = "SELECT s FROM SocialMediaUserGroups s")
    , @NamedQuery(name = "SocialMediaUserGroups.findById", query = "SELECT s FROM SocialMediaUserGroups s WHERE s.id = :id")
    , @NamedQuery(name = "SocialMediaUserGroups.findByMembershipNo", query = "SELECT s FROM SocialMediaUserGroups s WHERE s.membershipNo = :membershipNo")
    , @NamedQuery(name = "SocialMediaUserGroups.findByMemberRegistrationDate", query = "SELECT s FROM SocialMediaUserGroups s WHERE s.memberRegistrationDate = :memberRegistrationDate")
    , @NamedQuery(name = "SocialMediaUserGroups.findByIsDefault", query = "SELECT s FROM SocialMediaUserGroups s WHERE s.isDefault = :isDefault")})
public class SocialMediaUserGroups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "membership_no")
    private String membershipNo;
    @Column(name = "member_registration_date")
    @Temporal(TemporalType.DATE)
    private Date memberRegistrationDate;
    @Column(name = "is_default")
    private Boolean isDefault;
    @JoinColumn(name = "social_media_group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaGroup socialMediaGroupId;
    @JoinColumn(name = "social_media_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaProfilePage socialMediaUserId;
    @JoinColumn(name = "social_media_user_network_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaUserNetworkStatus socialMediaUserNetworkStatusId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "introducedBy")
    private Collection<SocialMediaUserNetwork> socialMediaUserNetworkCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "introducee")
    private Collection<SocialMediaUserNetwork> socialMediaUserNetworkCollection1;

    public SocialMediaUserGroups() {
    }

    public SocialMediaUserGroups(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMembershipNo() {
        return membershipNo;
    }

    public void setMembershipNo(String membershipNo) {
        this.membershipNo = membershipNo;
    }

    public Date getMemberRegistrationDate() {
        return memberRegistrationDate;
    }

    public void setMemberRegistrationDate(Date memberRegistrationDate) {
        this.memberRegistrationDate = memberRegistrationDate;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public SocialMediaGroup getSocialMediaGroupId() {
        return socialMediaGroupId;
    }

    public void setSocialMediaGroupId(SocialMediaGroup socialMediaGroupId) {
        this.socialMediaGroupId = socialMediaGroupId;
    }

    public SocialMediaProfilePage getSocialMediaUserId() {
        return socialMediaUserId;
    }

    public void setSocialMediaUserId(SocialMediaProfilePage socialMediaUserId) {
        this.socialMediaUserId = socialMediaUserId;
    }

    public SocialMediaUserNetworkStatus getSocialMediaUserNetworkStatusId() {
        return socialMediaUserNetworkStatusId;
    }

    public void setSocialMediaUserNetworkStatusId(SocialMediaUserNetworkStatus socialMediaUserNetworkStatusId) {
        this.socialMediaUserNetworkStatusId = socialMediaUserNetworkStatusId;
    }

    @XmlTransient
    public Collection<SocialMediaUserNetwork> getSocialMediaUserNetworkCollection() {
        return socialMediaUserNetworkCollection;
    }

    public void setSocialMediaUserNetworkCollection(Collection<SocialMediaUserNetwork> socialMediaUserNetworkCollection) {
        this.socialMediaUserNetworkCollection = socialMediaUserNetworkCollection;
    }

    @XmlTransient
    public Collection<SocialMediaUserNetwork> getSocialMediaUserNetworkCollection1() {
        return socialMediaUserNetworkCollection1;
    }

    public void setSocialMediaUserNetworkCollection1(Collection<SocialMediaUserNetwork> socialMediaUserNetworkCollection1) {
        this.socialMediaUserNetworkCollection1 = socialMediaUserNetworkCollection1;
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
        if (!(object instanceof SocialMediaUserGroups)) {
            return false;
        }
        SocialMediaUserGroups other = (SocialMediaUserGroups) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SocialMediaUserGroups[ id=" + id + " ]";
    }
    
}
