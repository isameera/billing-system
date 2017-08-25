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
@Table(name = "social_media_univarsal_post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SocialMediaUnivarsalPost.findAll", query = "SELECT s FROM SocialMediaUnivarsalPost s")
    , @NamedQuery(name = "SocialMediaUnivarsalPost.findById", query = "SELECT s FROM SocialMediaUnivarsalPost s WHERE s.id = :id")
    , @NamedQuery(name = "SocialMediaUnivarsalPost.findByPostedDate", query = "SELECT s FROM SocialMediaUnivarsalPost s WHERE s.postedDate = :postedDate")
    , @NamedQuery(name = "SocialMediaUnivarsalPost.findByPostedTime", query = "SELECT s FROM SocialMediaUnivarsalPost s WHERE s.postedTime = :postedTime")
    , @NamedQuery(name = "SocialMediaUnivarsalPost.findByLikesCount", query = "SELECT s FROM SocialMediaUnivarsalPost s WHERE s.likesCount = :likesCount")
    , @NamedQuery(name = "SocialMediaUnivarsalPost.findByDislikesCount", query = "SELECT s FROM SocialMediaUnivarsalPost s WHERE s.dislikesCount = :dislikesCount")
    , @NamedQuery(name = "SocialMediaUnivarsalPost.findByCommentsCount", query = "SELECT s FROM SocialMediaUnivarsalPost s WHERE s.commentsCount = :commentsCount")
    , @NamedQuery(name = "SocialMediaUnivarsalPost.findBySharesCount", query = "SELECT s FROM SocialMediaUnivarsalPost s WHERE s.sharesCount = :sharesCount")
    , @NamedQuery(name = "SocialMediaUnivarsalPost.findByIsActive", query = "SELECT s FROM SocialMediaUnivarsalPost s WHERE s.isActive = :isActive")
    , @NamedQuery(name = "SocialMediaUnivarsalPost.findByItemOrder", query = "SELECT s FROM SocialMediaUnivarsalPost s WHERE s.itemOrder = :itemOrder")})
public class SocialMediaUnivarsalPost implements Serializable {

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
    @Column(name = "likes_count")
    private Integer likesCount;
    @Column(name = "dislikes_count")
    private Integer dislikesCount;
    @Column(name = "comments_count")
    private Integer commentsCount;
    @Column(name = "shares_count")
    private Integer sharesCount;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "is_active")
    private Boolean isActive;
    @Lob
    @Size(max = 65535)
    @Column(name = "url")
    private String url;
    @Column(name = "item_order")
    private Integer itemOrder;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaUnivarsalPostId")
    private Collection<TimeLine> timeLineCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaUnivarsalPostId")
    private Collection<SocialMediaEventsController> socialMediaEventsControllerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaUnivarsalPostId")
    private Collection<SocialMediaUnivarsalPostFeelings> socialMediaUnivarsalPostFeelingsCollection;
    @JoinColumn(name = "social_media_group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaGroup socialMediaGroupId;
    @JoinColumn(name = "social_media_profile_page_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaProfilePage socialMediaProfilePageId;
    @JoinColumn(name = "social_media_publish_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaPublishType socialMediaPublishTypeId;
    @OneToMany(mappedBy = "superPostId")
    private Collection<SocialMediaUnivarsalPost> socialMediaUnivarsalPostCollection;
    @JoinColumn(name = "super_post_id", referencedColumnName = "id")
    @ManyToOne
    private SocialMediaUnivarsalPost superPostId;
    @JoinColumn(name = "social_media_universal_post_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaUniversalPostType socialMediaUniversalPostTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaUnivarsalPostId")
    private Collection<SocialMediaPostReaction> socialMediaPostReactionCollection;

    public SocialMediaUnivarsalPost() {
    }

    public SocialMediaUnivarsalPost(Integer id) {
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

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public Integer getDislikesCount() {
        return dislikesCount;
    }

    public void setDislikesCount(Integer dislikesCount) {
        this.dislikesCount = dislikesCount;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public Integer getSharesCount() {
        return sharesCount;
    }

    public void setSharesCount(Integer sharesCount) {
        this.sharesCount = sharesCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(Integer itemOrder) {
        this.itemOrder = itemOrder;
    }

    @XmlTransient
    public Collection<TimeLine> getTimeLineCollection() {
        return timeLineCollection;
    }

    public void setTimeLineCollection(Collection<TimeLine> timeLineCollection) {
        this.timeLineCollection = timeLineCollection;
    }

    @XmlTransient
    public Collection<SocialMediaEventsController> getSocialMediaEventsControllerCollection() {
        return socialMediaEventsControllerCollection;
    }

    public void setSocialMediaEventsControllerCollection(Collection<SocialMediaEventsController> socialMediaEventsControllerCollection) {
        this.socialMediaEventsControllerCollection = socialMediaEventsControllerCollection;
    }

    @XmlTransient
    public Collection<SocialMediaUnivarsalPostFeelings> getSocialMediaUnivarsalPostFeelingsCollection() {
        return socialMediaUnivarsalPostFeelingsCollection;
    }

    public void setSocialMediaUnivarsalPostFeelingsCollection(Collection<SocialMediaUnivarsalPostFeelings> socialMediaUnivarsalPostFeelingsCollection) {
        this.socialMediaUnivarsalPostFeelingsCollection = socialMediaUnivarsalPostFeelingsCollection;
    }

    public SocialMediaGroup getSocialMediaGroupId() {
        return socialMediaGroupId;
    }

    public void setSocialMediaGroupId(SocialMediaGroup socialMediaGroupId) {
        this.socialMediaGroupId = socialMediaGroupId;
    }

    public SocialMediaProfilePage getSocialMediaProfilePageId() {
        return socialMediaProfilePageId;
    }

    public void setSocialMediaProfilePageId(SocialMediaProfilePage socialMediaProfilePageId) {
        this.socialMediaProfilePageId = socialMediaProfilePageId;
    }

    public SocialMediaPublishType getSocialMediaPublishTypeId() {
        return socialMediaPublishTypeId;
    }

    public void setSocialMediaPublishTypeId(SocialMediaPublishType socialMediaPublishTypeId) {
        this.socialMediaPublishTypeId = socialMediaPublishTypeId;
    }

    @XmlTransient
    public Collection<SocialMediaUnivarsalPost> getSocialMediaUnivarsalPostCollection() {
        return socialMediaUnivarsalPostCollection;
    }

    public void setSocialMediaUnivarsalPostCollection(Collection<SocialMediaUnivarsalPost> socialMediaUnivarsalPostCollection) {
        this.socialMediaUnivarsalPostCollection = socialMediaUnivarsalPostCollection;
    }

    public SocialMediaUnivarsalPost getSuperPostId() {
        return superPostId;
    }

    public void setSuperPostId(SocialMediaUnivarsalPost superPostId) {
        this.superPostId = superPostId;
    }

    public SocialMediaUniversalPostType getSocialMediaUniversalPostTypeId() {
        return socialMediaUniversalPostTypeId;
    }

    public void setSocialMediaUniversalPostTypeId(SocialMediaUniversalPostType socialMediaUniversalPostTypeId) {
        this.socialMediaUniversalPostTypeId = socialMediaUniversalPostTypeId;
    }

    @XmlTransient
    public Collection<SocialMediaPostReaction> getSocialMediaPostReactionCollection() {
        return socialMediaPostReactionCollection;
    }

    public void setSocialMediaPostReactionCollection(Collection<SocialMediaPostReaction> socialMediaPostReactionCollection) {
        this.socialMediaPostReactionCollection = socialMediaPostReactionCollection;
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
        if (!(object instanceof SocialMediaUnivarsalPost)) {
            return false;
        }
        SocialMediaUnivarsalPost other = (SocialMediaUnivarsalPost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SocialMediaUnivarsalPost[ id=" + id + " ]";
    }
    
}
