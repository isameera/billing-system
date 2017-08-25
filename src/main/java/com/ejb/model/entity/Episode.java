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
@Table(name = "episode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Episode.findAll", query = "SELECT e FROM Episode e")
    , @NamedQuery(name = "Episode.findById", query = "SELECT e FROM Episode e WHERE e.id = :id")
    , @NamedQuery(name = "Episode.findByVolumeNumber", query = "SELECT e FROM Episode e WHERE e.volumeNumber = :volumeNumber")
    , @NamedQuery(name = "Episode.findByCoverImage", query = "SELECT e FROM Episode e WHERE e.coverImage = :coverImage")
    , @NamedQuery(name = "Episode.findByPublishedDate", query = "SELECT e FROM Episode e WHERE e.publishedDate = :publishedDate")})
public class Episode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "volume_number")
    private Integer volumeNumber;
    @Size(max = 105)
    @Column(name = "cover_image")
    private String coverImage;
    @Column(name = "published_date")
    @Temporal(TemporalType.DATE)
    private Date publishedDate;
    @JoinColumn(name = "magazine_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Magazine magazineId;
    @JoinColumn(name = "story_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Story storyId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "episodeId")
    private Collection<EpisodeContent> episodeContentCollection;

    public Episode() {
    }

    public Episode(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVolumeNumber() {
        return volumeNumber;
    }

    public void setVolumeNumber(Integer volumeNumber) {
        this.volumeNumber = volumeNumber;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Magazine getMagazineId() {
        return magazineId;
    }

    public void setMagazineId(Magazine magazineId) {
        this.magazineId = magazineId;
    }

    public Story getStoryId() {
        return storyId;
    }

    public void setStoryId(Story storyId) {
        this.storyId = storyId;
    }

    @XmlTransient
    public Collection<EpisodeContent> getEpisodeContentCollection() {
        return episodeContentCollection;
    }

    public void setEpisodeContentCollection(Collection<EpisodeContent> episodeContentCollection) {
        this.episodeContentCollection = episodeContentCollection;
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
        if (!(object instanceof Episode)) {
            return false;
        }
        Episode other = (Episode) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.Episode[ id=" + id + " ]";
    }
    
}
