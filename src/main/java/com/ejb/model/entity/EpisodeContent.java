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
@Table(name = "episode_content")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EpisodeContent.findAll", query = "SELECT e FROM EpisodeContent e")
    , @NamedQuery(name = "EpisodeContent.findById", query = "SELECT e FROM EpisodeContent e WHERE e.id = :id")
    , @NamedQuery(name = "EpisodeContent.findByUploadedDate", query = "SELECT e FROM EpisodeContent e WHERE e.uploadedDate = :uploadedDate")
    , @NamedQuery(name = "EpisodeContent.findByImageUrl", query = "SELECT e FROM EpisodeContent e WHERE e.imageUrl = :imageUrl")})
public class EpisodeContent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "title")
    private String title;
    @Lob
    @Size(max = 65535)
    @Column(name = "content")
    private String content;
    @Column(name = "uploaded_date")
    @Temporal(TemporalType.DATE)
    private Date uploadedDate;
    @Size(max = 100)
    @Column(name = "image_url")
    private String imageUrl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "episodeContentId")
    private Collection<StoryReader> storyReaderCollection;
    @JoinColumn(name = "episode_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Episode episodeId;

    public EpisodeContent() {
    }

    public EpisodeContent(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(Date uploadedDate) {
        this.uploadedDate = uploadedDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @XmlTransient
    public Collection<StoryReader> getStoryReaderCollection() {
        return storyReaderCollection;
    }

    public void setStoryReaderCollection(Collection<StoryReader> storyReaderCollection) {
        this.storyReaderCollection = storyReaderCollection;
    }

    public Episode getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(Episode episodeId) {
        this.episodeId = episodeId;
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
        if (!(object instanceof EpisodeContent)) {
            return false;
        }
        EpisodeContent other = (EpisodeContent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.EpisodeContent[ id=" + id + " ]";
    }
    
}
