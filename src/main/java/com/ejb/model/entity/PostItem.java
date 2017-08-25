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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "post_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PostItem.findAll", query = "SELECT p FROM PostItem p")
    , @NamedQuery(name = "PostItem.findById", query = "SELECT p FROM PostItem p WHERE p.id = :id")
    , @NamedQuery(name = "PostItem.findByUrl", query = "SELECT p FROM PostItem p WHERE p.url = :url")
    , @NamedQuery(name = "PostItem.findByIsCoverItem", query = "SELECT p FROM PostItem p WHERE p.isCoverItem = :isCoverItem")
    , @NamedQuery(name = "PostItem.findByOder", query = "SELECT p FROM PostItem p WHERE p.oder = :oder")})
public class PostItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 300)
    @Column(name = "url")
    private String url;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "is_cover_item")
    private Integer isCoverItem;
    @Column(name = "oder")
    private Integer oder;
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Post postId;
    @JoinColumn(name = "post_item_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PostItemPlacement postItemCategoryId;
    @JoinColumn(name = "post_item_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PostItemType postItemTypeId;

    public PostItem() {
    }

    public PostItem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsCoverItem() {
        return isCoverItem;
    }

    public void setIsCoverItem(Integer isCoverItem) {
        this.isCoverItem = isCoverItem;
    }

    public Integer getOder() {
        return oder;
    }

    public void setOder(Integer oder) {
        this.oder = oder;
    }

    public Post getPostId() {
        return postId;
    }

    public void setPostId(Post postId) {
        this.postId = postId;
    }

    public PostItemPlacement getPostItemCategoryId() {
        return postItemCategoryId;
    }

    public void setPostItemCategoryId(PostItemPlacement postItemCategoryId) {
        this.postItemCategoryId = postItemCategoryId;
    }

    public PostItemType getPostItemTypeId() {
        return postItemTypeId;
    }

    public void setPostItemTypeId(PostItemType postItemTypeId) {
        this.postItemTypeId = postItemTypeId;
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
        if (!(object instanceof PostItem)) {
            return false;
        }
        PostItem other = (PostItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.PostItem[ id=" + id + " ]";
    }
    
}
