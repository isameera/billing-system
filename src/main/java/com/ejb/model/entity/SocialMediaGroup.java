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
import javax.persistence.Lob;
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
@Table(name = "social_media_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SocialMediaGroup.findAll", query = "SELECT s FROM SocialMediaGroup s")
    , @NamedQuery(name = "SocialMediaGroup.findById", query = "SELECT s FROM SocialMediaGroup s WHERE s.id = :id")
    , @NamedQuery(name = "SocialMediaGroup.findByName", query = "SELECT s FROM SocialMediaGroup s WHERE s.name = :name")
    , @NamedQuery(name = "SocialMediaGroup.findByStartDate", query = "SELECT s FROM SocialMediaGroup s WHERE s.startDate = :startDate")
    , @NamedQuery(name = "SocialMediaGroup.findByGroupProfileImage", query = "SELECT s FROM SocialMediaGroup s WHERE s.groupProfileImage = :groupProfileImage")
    , @NamedQuery(name = "SocialMediaGroup.findByCoverImage", query = "SELECT s FROM SocialMediaGroup s WHERE s.coverImage = :coverImage")
    , @NamedQuery(name = "SocialMediaGroup.findByTagLine", query = "SELECT s FROM SocialMediaGroup s WHERE s.tagLine = :tagLine")
    , @NamedQuery(name = "SocialMediaGroup.findByThemeColor", query = "SELECT s FROM SocialMediaGroup s WHERE s.themeColor = :themeColor")})
public class SocialMediaGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Size(max = 255)
    @Column(name = "group_profile_image")
    private String groupProfileImage;
    @Size(max = 255)
    @Column(name = "cover_image")
    private String coverImage;
    @Size(max = 255)
    @Column(name = "tag_line")
    private String tagLine;
    @Lob
    @Size(max = 65535)
    @Column(name = "mission")
    private String mission;
    @Lob
    @Size(max = 65535)
    @Column(name = "vision")
    private String vision;
    @Lob
    @Size(max = 65535)
    @Column(name = "objectives")
    private String objectives;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Size(max = 45)
    @Column(name = "theme_color")
    private String themeColor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaGroupId")
    private Collection<SocialMediaUserGroups> socialMediaUserGroupsCollection;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "social_media_group_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaGroupType socialMediaGroupTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaGroupId")
    private Collection<SocialMediaEvents> socialMediaEventsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaUserGroupId")
    private Collection<SocialMediaUniversalGroupMessaging> socialMediaUniversalGroupMessagingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaGroupId")
    private Collection<SocialMediaInvitationController> socialMediaInvitationControllerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaGroupId")
    private Collection<SocialMediaUnivarsalPost> socialMediaUnivarsalPostCollection;

    public SocialMediaGroup() {
    }

    public SocialMediaGroup(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getGroupProfileImage() {
        return groupProfileImage;
    }

    public void setGroupProfileImage(String groupProfileImage) {
        this.groupProfileImage = groupProfileImage;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getTagLine() {
        return tagLine;
    }

    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThemeColor() {
        return themeColor;
    }

    public void setThemeColor(String themeColor) {
        this.themeColor = themeColor;
    }

    @XmlTransient
    public Collection<SocialMediaUserGroups> getSocialMediaUserGroupsCollection() {
        return socialMediaUserGroupsCollection;
    }

    public void setSocialMediaUserGroupsCollection(Collection<SocialMediaUserGroups> socialMediaUserGroupsCollection) {
        this.socialMediaUserGroupsCollection = socialMediaUserGroupsCollection;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public SocialMediaGroupType getSocialMediaGroupTypeId() {
        return socialMediaGroupTypeId;
    }

    public void setSocialMediaGroupTypeId(SocialMediaGroupType socialMediaGroupTypeId) {
        this.socialMediaGroupTypeId = socialMediaGroupTypeId;
    }

    @XmlTransient
    public Collection<SocialMediaEvents> getSocialMediaEventsCollection() {
        return socialMediaEventsCollection;
    }

    public void setSocialMediaEventsCollection(Collection<SocialMediaEvents> socialMediaEventsCollection) {
        this.socialMediaEventsCollection = socialMediaEventsCollection;
    }

    @XmlTransient
    public Collection<SocialMediaUniversalGroupMessaging> getSocialMediaUniversalGroupMessagingCollection() {
        return socialMediaUniversalGroupMessagingCollection;
    }

    public void setSocialMediaUniversalGroupMessagingCollection(Collection<SocialMediaUniversalGroupMessaging> socialMediaUniversalGroupMessagingCollection) {
        this.socialMediaUniversalGroupMessagingCollection = socialMediaUniversalGroupMessagingCollection;
    }

    @XmlTransient
    public Collection<SocialMediaInvitationController> getSocialMediaInvitationControllerCollection() {
        return socialMediaInvitationControllerCollection;
    }

    public void setSocialMediaInvitationControllerCollection(Collection<SocialMediaInvitationController> socialMediaInvitationControllerCollection) {
        this.socialMediaInvitationControllerCollection = socialMediaInvitationControllerCollection;
    }

    @XmlTransient
    public Collection<SocialMediaUnivarsalPost> getSocialMediaUnivarsalPostCollection() {
        return socialMediaUnivarsalPostCollection;
    }

    public void setSocialMediaUnivarsalPostCollection(Collection<SocialMediaUnivarsalPost> socialMediaUnivarsalPostCollection) {
        this.socialMediaUnivarsalPostCollection = socialMediaUnivarsalPostCollection;
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
        if (!(object instanceof SocialMediaGroup)) {
            return false;
        }
        SocialMediaGroup other = (SocialMediaGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SocialMediaGroup[ id=" + id + " ]";
    }
    
}
