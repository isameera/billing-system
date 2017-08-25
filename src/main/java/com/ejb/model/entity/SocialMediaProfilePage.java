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
@Table(name = "social_media_profile_page")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SocialMediaProfilePage.findAll", query = "SELECT s FROM SocialMediaProfilePage s")
    , @NamedQuery(name = "SocialMediaProfilePage.findById", query = "SELECT s FROM SocialMediaProfilePage s WHERE s.id = :id")
    , @NamedQuery(name = "SocialMediaProfilePage.findByName", query = "SELECT s FROM SocialMediaProfilePage s WHERE s.name = :name")
    , @NamedQuery(name = "SocialMediaProfilePage.findByProfileImage", query = "SELECT s FROM SocialMediaProfilePage s WHERE s.profileImage = :profileImage")
    , @NamedQuery(name = "SocialMediaProfilePage.findByCoverImage", query = "SELECT s FROM SocialMediaProfilePage s WHERE s.coverImage = :coverImage")
    , @NamedQuery(name = "SocialMediaProfilePage.findByIsActive", query = "SELECT s FROM SocialMediaProfilePage s WHERE s.isActive = :isActive")
    , @NamedQuery(name = "SocialMediaProfilePage.findByJoinedDate", query = "SELECT s FROM SocialMediaProfilePage s WHERE s.joinedDate = :joinedDate")
    , @NamedQuery(name = "SocialMediaProfilePage.findByThemeColor", query = "SELECT s FROM SocialMediaProfilePage s WHERE s.themeColor = :themeColor")
    , @NamedQuery(name = "SocialMediaProfilePage.findByLikes", query = "SELECT s FROM SocialMediaProfilePage s WHERE s.likes = :likes")
    , @NamedQuery(name = "SocialMediaProfilePage.findByDislikes", query = "SELECT s FROM SocialMediaProfilePage s WHERE s.dislikes = :dislikes")
    , @NamedQuery(name = "SocialMediaProfilePage.findByShareCount", query = "SELECT s FROM SocialMediaProfilePage s WHERE s.shareCount = :shareCount")
    , @NamedQuery(name = "SocialMediaProfilePage.findByLikeCount", query = "SELECT s FROM SocialMediaProfilePage s WHERE s.likeCount = :likeCount")
    , @NamedQuery(name = "SocialMediaProfilePage.findByTshirtSize", query = "SELECT s FROM SocialMediaProfilePage s WHERE s.tshirtSize = :tshirtSize")})
public class SocialMediaProfilePage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 145)
    @Column(name = "name")
    private String name;
    @Size(max = 145)
    @Column(name = "profile_image")
    private String profileImage;
    @Size(max = 145)
    @Column(name = "cover_image")
    private String coverImage;
    @Column(name = "is_active")
    private Integer isActive;
    @Column(name = "joined_date")
    @Temporal(TemporalType.DATE)
    private Date joinedDate;
    @Size(max = 45)
    @Column(name = "theme_color")
    private String themeColor;
    @Column(name = "likes")
    private Integer likes;
    @Column(name = "dislikes")
    private Integer dislikes;
    @Column(name = "share_count")
    private Integer shareCount;
    @Column(name = "like_count")
    private Integer likeCount;
    @Size(max = 45)
    @Column(name = "tshirt_size")
    private String tshirtSize;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaProfilePageId")
    private Collection<TimeLine> timeLineCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaUserId")
    private Collection<SocialMediaUserGroups> socialMediaUserGroupsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaProfilePageId")
    private Collection<SocialMediaProfilePageByOrg> socialMediaProfilePageByOrgCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaUserId")
    private Collection<SocialMediaUniversalUsersMessaging> socialMediaUniversalUsersMessagingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "messageFrom")
    private Collection<SocialMediaUniversalMessaging> socialMediaUniversalMessagingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaProfilePageId")
    private Collection<OrgSocialMediaProfilePage> orgSocialMediaProfilePageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaProfilePageId")
    private Collection<EventParticipateController> eventParticipateControllerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaProfilePageId")
    private Collection<SocialMediaEvents> socialMediaEventsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaProfilePageId")
    private Collection<SocialMediaUserLivingHistory> socialMediaUserLivingHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaProfilePageId")
    private Collection<SocialMediaUnivarsalPost> socialMediaUnivarsalPostCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaProfilePageId")
    private Collection<SocialMediaPostReaction> socialMediaPostReactionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaProfilePageId")
    private Collection<SocialMediaEventReactionController> socialMediaEventReactionControllerCollection;
    @JoinColumn(name = "social_media_profile_page_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaProfilePageCategory socialMediaProfilePageCategoryId;
    @JoinColumn(name = "social_media_profile_page_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaProfilePageType socialMediaProfilePageTypeId;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaUserPerent")
    private Collection<SocialMediaUserFriends> socialMediaUserFriendsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaUserSlave")
    private Collection<SocialMediaUserFriends> socialMediaUserFriendsCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "communicateFrom")
    private Collection<SocialMediaUniversalCommunication> socialMediaUniversalCommunicationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "communicateTo")
    private Collection<SocialMediaUniversalCommunication> socialMediaUniversalCommunicationCollection1;

    public SocialMediaProfilePage() {
    }

    public SocialMediaProfilePage(Integer id) {
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

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getThemeColor() {
        return themeColor;
    }

    public void setThemeColor(String themeColor) {
        this.themeColor = themeColor;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    public Integer getShareCount() {
        return shareCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public String getTshirtSize() {
        return tshirtSize;
    }

    public void setTshirtSize(String tshirtSize) {
        this.tshirtSize = tshirtSize;
    }

    @XmlTransient
    public Collection<TimeLine> getTimeLineCollection() {
        return timeLineCollection;
    }

    public void setTimeLineCollection(Collection<TimeLine> timeLineCollection) {
        this.timeLineCollection = timeLineCollection;
    }

    @XmlTransient
    public Collection<SocialMediaUserGroups> getSocialMediaUserGroupsCollection() {
        return socialMediaUserGroupsCollection;
    }

    public void setSocialMediaUserGroupsCollection(Collection<SocialMediaUserGroups> socialMediaUserGroupsCollection) {
        this.socialMediaUserGroupsCollection = socialMediaUserGroupsCollection;
    }

    @XmlTransient
    public Collection<SocialMediaProfilePageByOrg> getSocialMediaProfilePageByOrgCollection() {
        return socialMediaProfilePageByOrgCollection;
    }

    public void setSocialMediaProfilePageByOrgCollection(Collection<SocialMediaProfilePageByOrg> socialMediaProfilePageByOrgCollection) {
        this.socialMediaProfilePageByOrgCollection = socialMediaProfilePageByOrgCollection;
    }

    @XmlTransient
    public Collection<SocialMediaUniversalUsersMessaging> getSocialMediaUniversalUsersMessagingCollection() {
        return socialMediaUniversalUsersMessagingCollection;
    }

    public void setSocialMediaUniversalUsersMessagingCollection(Collection<SocialMediaUniversalUsersMessaging> socialMediaUniversalUsersMessagingCollection) {
        this.socialMediaUniversalUsersMessagingCollection = socialMediaUniversalUsersMessagingCollection;
    }

    @XmlTransient
    public Collection<SocialMediaUniversalMessaging> getSocialMediaUniversalMessagingCollection() {
        return socialMediaUniversalMessagingCollection;
    }

    public void setSocialMediaUniversalMessagingCollection(Collection<SocialMediaUniversalMessaging> socialMediaUniversalMessagingCollection) {
        this.socialMediaUniversalMessagingCollection = socialMediaUniversalMessagingCollection;
    }

    @XmlTransient
    public Collection<OrgSocialMediaProfilePage> getOrgSocialMediaProfilePageCollection() {
        return orgSocialMediaProfilePageCollection;
    }

    public void setOrgSocialMediaProfilePageCollection(Collection<OrgSocialMediaProfilePage> orgSocialMediaProfilePageCollection) {
        this.orgSocialMediaProfilePageCollection = orgSocialMediaProfilePageCollection;
    }

    @XmlTransient
    public Collection<EventParticipateController> getEventParticipateControllerCollection() {
        return eventParticipateControllerCollection;
    }

    public void setEventParticipateControllerCollection(Collection<EventParticipateController> eventParticipateControllerCollection) {
        this.eventParticipateControllerCollection = eventParticipateControllerCollection;
    }

    @XmlTransient
    public Collection<SocialMediaEvents> getSocialMediaEventsCollection() {
        return socialMediaEventsCollection;
    }

    public void setSocialMediaEventsCollection(Collection<SocialMediaEvents> socialMediaEventsCollection) {
        this.socialMediaEventsCollection = socialMediaEventsCollection;
    }

    @XmlTransient
    public Collection<SocialMediaUserLivingHistory> getSocialMediaUserLivingHistoryCollection() {
        return socialMediaUserLivingHistoryCollection;
    }

    public void setSocialMediaUserLivingHistoryCollection(Collection<SocialMediaUserLivingHistory> socialMediaUserLivingHistoryCollection) {
        this.socialMediaUserLivingHistoryCollection = socialMediaUserLivingHistoryCollection;
    }

    @XmlTransient
    public Collection<SocialMediaUnivarsalPost> getSocialMediaUnivarsalPostCollection() {
        return socialMediaUnivarsalPostCollection;
    }

    public void setSocialMediaUnivarsalPostCollection(Collection<SocialMediaUnivarsalPost> socialMediaUnivarsalPostCollection) {
        this.socialMediaUnivarsalPostCollection = socialMediaUnivarsalPostCollection;
    }

    @XmlTransient
    public Collection<SocialMediaPostReaction> getSocialMediaPostReactionCollection() {
        return socialMediaPostReactionCollection;
    }

    public void setSocialMediaPostReactionCollection(Collection<SocialMediaPostReaction> socialMediaPostReactionCollection) {
        this.socialMediaPostReactionCollection = socialMediaPostReactionCollection;
    }

    @XmlTransient
    public Collection<SocialMediaEventReactionController> getSocialMediaEventReactionControllerCollection() {
        return socialMediaEventReactionControllerCollection;
    }

    public void setSocialMediaEventReactionControllerCollection(Collection<SocialMediaEventReactionController> socialMediaEventReactionControllerCollection) {
        this.socialMediaEventReactionControllerCollection = socialMediaEventReactionControllerCollection;
    }

    public SocialMediaProfilePageCategory getSocialMediaProfilePageCategoryId() {
        return socialMediaProfilePageCategoryId;
    }

    public void setSocialMediaProfilePageCategoryId(SocialMediaProfilePageCategory socialMediaProfilePageCategoryId) {
        this.socialMediaProfilePageCategoryId = socialMediaProfilePageCategoryId;
    }

    public SocialMediaProfilePageType getSocialMediaProfilePageTypeId() {
        return socialMediaProfilePageTypeId;
    }

    public void setSocialMediaProfilePageTypeId(SocialMediaProfilePageType socialMediaProfilePageTypeId) {
        this.socialMediaProfilePageTypeId = socialMediaProfilePageTypeId;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
    }

    @XmlTransient
    public Collection<SocialMediaUserFriends> getSocialMediaUserFriendsCollection() {
        return socialMediaUserFriendsCollection;
    }

    public void setSocialMediaUserFriendsCollection(Collection<SocialMediaUserFriends> socialMediaUserFriendsCollection) {
        this.socialMediaUserFriendsCollection = socialMediaUserFriendsCollection;
    }

    @XmlTransient
    public Collection<SocialMediaUserFriends> getSocialMediaUserFriendsCollection1() {
        return socialMediaUserFriendsCollection1;
    }

    public void setSocialMediaUserFriendsCollection1(Collection<SocialMediaUserFriends> socialMediaUserFriendsCollection1) {
        this.socialMediaUserFriendsCollection1 = socialMediaUserFriendsCollection1;
    }

    @XmlTransient
    public Collection<SocialMediaUniversalCommunication> getSocialMediaUniversalCommunicationCollection() {
        return socialMediaUniversalCommunicationCollection;
    }

    public void setSocialMediaUniversalCommunicationCollection(Collection<SocialMediaUniversalCommunication> socialMediaUniversalCommunicationCollection) {
        this.socialMediaUniversalCommunicationCollection = socialMediaUniversalCommunicationCollection;
    }

    @XmlTransient
    public Collection<SocialMediaUniversalCommunication> getSocialMediaUniversalCommunicationCollection1() {
        return socialMediaUniversalCommunicationCollection1;
    }

    public void setSocialMediaUniversalCommunicationCollection1(Collection<SocialMediaUniversalCommunication> socialMediaUniversalCommunicationCollection1) {
        this.socialMediaUniversalCommunicationCollection1 = socialMediaUniversalCommunicationCollection1;
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
        if (!(object instanceof SocialMediaProfilePage)) {
            return false;
        }
        SocialMediaProfilePage other = (SocialMediaProfilePage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SocialMediaProfilePage[ id=" + id + " ]";
    }
    
}
