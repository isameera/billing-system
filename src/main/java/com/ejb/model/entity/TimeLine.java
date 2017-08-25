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
@Table(name = "time_line")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TimeLine.findAll", query = "SELECT t FROM TimeLine t")
    , @NamedQuery(name = "TimeLine.findById", query = "SELECT t FROM TimeLine t WHERE t.id = :id")
    , @NamedQuery(name = "TimeLine.findByPostedDate", query = "SELECT t FROM TimeLine t WHERE t.postedDate = :postedDate")
    , @NamedQuery(name = "TimeLine.findByPostedTime", query = "SELECT t FROM TimeLine t WHERE t.postedTime = :postedTime")
    , @NamedQuery(name = "TimeLine.findByLikes", query = "SELECT t FROM TimeLine t WHERE t.likes = :likes")
    , @NamedQuery(name = "TimeLine.findByDislikes", query = "SELECT t FROM TimeLine t WHERE t.dislikes = :dislikes")
    , @NamedQuery(name = "TimeLine.findByComments", query = "SELECT t FROM TimeLine t WHERE t.comments = :comments")
    , @NamedQuery(name = "TimeLine.findByShares", query = "SELECT t FROM TimeLine t WHERE t.shares = :shares")
    , @NamedQuery(name = "TimeLine.findByIsHide", query = "SELECT t FROM TimeLine t WHERE t.isHide = :isHide")
    , @NamedQuery(name = "TimeLine.findByNotificationStatus", query = "SELECT t FROM TimeLine t WHERE t.notificationStatus = :notificationStatus")})
public class TimeLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "posted_date")
    @Temporal(TemporalType.DATE)
    private Date postedDate;
    @Column(name = "posted_time")
    @Temporal(TemporalType.TIME)
    private Date postedTime;
    @Column(name = "likes")
    private Integer likes;
    @Column(name = "dislikes")
    private Integer dislikes;
    @Column(name = "comments")
    private Integer comments;
    @Column(name = "shares")
    private Integer shares;
    @Lob
    @Size(max = 65535)
    @Column(name = "text")
    private String text;
    @Column(name = "is_hide")
    private Boolean isHide;
    @Column(name = "notification_status")
    private Boolean notificationStatus;
    @JoinColumn(name = "social_media_profile_page_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaProfilePage socialMediaProfilePageId;
    @JoinColumn(name = "social_media_univarsal_post_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaUnivarsalPost socialMediaUnivarsalPostId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "social_media_publish_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaPublishType socialMediaPublishTypeId;
    @OneToMany(mappedBy = "sharedFrom")
    private Collection<TimeLine> timeLineCollection;
    @JoinColumn(name = "shared_from", referencedColumnName = "id")
    @ManyToOne
    private TimeLine sharedFrom;
    @OneToMany(mappedBy = "timeLineComments")
    private Collection<TimeLine> timeLineCollection1;
    @JoinColumn(name = "time_line_comments", referencedColumnName = "id")
    @ManyToOne
    private TimeLine timeLineComments;
    @JoinColumn(name = "time_line_published_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TimeLinePublishedType timeLinePublishedTypeId;

    public TimeLine() {
    }

    public TimeLine(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Date getPostedTime() {
        return postedTime;
    }

    public void setPostedTime(Date postedTime) {
        this.postedTime = postedTime;
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

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getShares() {
        return shares;
    }

    public void setShares(Integer shares) {
        this.shares = shares;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getIsHide() {
        return isHide;
    }

    public void setIsHide(Boolean isHide) {
        this.isHide = isHide;
    }

    public Boolean getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(Boolean notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

    public SocialMediaProfilePage getSocialMediaProfilePageId() {
        return socialMediaProfilePageId;
    }

    public void setSocialMediaProfilePageId(SocialMediaProfilePage socialMediaProfilePageId) {
        this.socialMediaProfilePageId = socialMediaProfilePageId;
    }

    public SocialMediaUnivarsalPost getSocialMediaUnivarsalPostId() {
        return socialMediaUnivarsalPostId;
    }

    public void setSocialMediaUnivarsalPostId(SocialMediaUnivarsalPost socialMediaUnivarsalPostId) {
        this.socialMediaUnivarsalPostId = socialMediaUnivarsalPostId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public SocialMediaPublishType getSocialMediaPublishTypeId() {
        return socialMediaPublishTypeId;
    }

    public void setSocialMediaPublishTypeId(SocialMediaPublishType socialMediaPublishTypeId) {
        this.socialMediaPublishTypeId = socialMediaPublishTypeId;
    }

    @XmlTransient
    public Collection<TimeLine> getTimeLineCollection() {
        return timeLineCollection;
    }

    public void setTimeLineCollection(Collection<TimeLine> timeLineCollection) {
        this.timeLineCollection = timeLineCollection;
    }

    public TimeLine getSharedFrom() {
        return sharedFrom;
    }

    public void setSharedFrom(TimeLine sharedFrom) {
        this.sharedFrom = sharedFrom;
    }

    @XmlTransient
    public Collection<TimeLine> getTimeLineCollection1() {
        return timeLineCollection1;
    }

    public void setTimeLineCollection1(Collection<TimeLine> timeLineCollection1) {
        this.timeLineCollection1 = timeLineCollection1;
    }

    public TimeLine getTimeLineComments() {
        return timeLineComments;
    }

    public void setTimeLineComments(TimeLine timeLineComments) {
        this.timeLineComments = timeLineComments;
    }

    public TimeLinePublishedType getTimeLinePublishedTypeId() {
        return timeLinePublishedTypeId;
    }

    public void setTimeLinePublishedTypeId(TimeLinePublishedType timeLinePublishedTypeId) {
        this.timeLinePublishedTypeId = timeLinePublishedTypeId;
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
        if (!(object instanceof TimeLine)) {
            return false;
        }
        TimeLine other = (TimeLine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.TimeLine[ id=" + id + " ]";
    }
    
}
