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
@Table(name = "post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p")
    , @NamedQuery(name = "Post.findById", query = "SELECT p FROM Post p WHERE p.id = :id")
    , @NamedQuery(name = "Post.findByName", query = "SELECT p FROM Post p WHERE p.name = :name")
    , @NamedQuery(name = "Post.findByDescription", query = "SELECT p FROM Post p WHERE p.description = :description")
    , @NamedQuery(name = "Post.findByDate", query = "SELECT p FROM Post p WHERE p.date = :date")
    , @NamedQuery(name = "Post.findByTime", query = "SELECT p FROM Post p WHERE p.time = :time")
    , @NamedQuery(name = "Post.findByCoverImage", query = "SELECT p FROM Post p WHERE p.coverImage = :coverImage")
    , @NamedQuery(name = "Post.findByViews", query = "SELECT p FROM Post p WHERE p.views = :views")
    , @NamedQuery(name = "Post.findByLiks", query = "SELECT p FROM Post p WHERE p.liks = :liks")
    , @NamedQuery(name = "Post.findByIsActive", query = "SELECT p FROM Post p WHERE p.isActive = :isActive")})
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2500)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 65535)
    @Column(name = "content")
    private String content;
    @Size(max = 2000)
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Size(max = 445)
    @Column(name = "cover_image")
    private String coverImage;
    @Column(name = "views")
    private Integer views;
    @Column(name = "liks")
    private Integer liks;
    @Column(name = "is_active")
    private Integer isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postId")
    private Collection<RowColumnPage> rowColumnPageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postId")
    private Collection<PostItem> postItemCollection;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "post_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PostCategory postCategoryId;
    @JoinColumn(name = "post_category_id1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PostCategory postCategoryId1;
    @JoinColumn(name = "post_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PostType postTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postId")
    private Collection<ArticleKeywords> articleKeywordsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postId")
    private Collection<PostReport> postReportCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postId")
    private Collection<Interaction> interactionCollection;

    public Post() {
    }

    public Post(Integer id) {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getLiks() {
        return liks;
    }

    public void setLiks(Integer liks) {
        this.liks = liks;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public Collection<RowColumnPage> getRowColumnPageCollection() {
        return rowColumnPageCollection;
    }

    public void setRowColumnPageCollection(Collection<RowColumnPage> rowColumnPageCollection) {
        this.rowColumnPageCollection = rowColumnPageCollection;
    }

    @XmlTransient
    public Collection<PostItem> getPostItemCollection() {
        return postItemCollection;
    }

    public void setPostItemCollection(Collection<PostItem> postItemCollection) {
        this.postItemCollection = postItemCollection;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
    }

    public PostCategory getPostCategoryId() {
        return postCategoryId;
    }

    public void setPostCategoryId(PostCategory postCategoryId) {
        this.postCategoryId = postCategoryId;
    }

    public PostCategory getPostCategoryId1() {
        return postCategoryId1;
    }

    public void setPostCategoryId1(PostCategory postCategoryId1) {
        this.postCategoryId1 = postCategoryId1;
    }

    public PostType getPostTypeId() {
        return postTypeId;
    }

    public void setPostTypeId(PostType postTypeId) {
        this.postTypeId = postTypeId;
    }

    @XmlTransient
    public Collection<ArticleKeywords> getArticleKeywordsCollection() {
        return articleKeywordsCollection;
    }

    public void setArticleKeywordsCollection(Collection<ArticleKeywords> articleKeywordsCollection) {
        this.articleKeywordsCollection = articleKeywordsCollection;
    }

    @XmlTransient
    public Collection<PostReport> getPostReportCollection() {
        return postReportCollection;
    }

    public void setPostReportCollection(Collection<PostReport> postReportCollection) {
        this.postReportCollection = postReportCollection;
    }

    @XmlTransient
    public Collection<Interaction> getInteractionCollection() {
        return interactionCollection;
    }

    public void setInteractionCollection(Collection<Interaction> interactionCollection) {
        this.interactionCollection = interactionCollection;
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
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.Post[ id=" + id + " ]";
    }
    
}
