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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "story_reader")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoryReader.findAll", query = "SELECT s FROM StoryReader s")
    , @NamedQuery(name = "StoryReader.findById", query = "SELECT s FROM StoryReader s WHERE s.id = :id")
    , @NamedQuery(name = "StoryReader.findByReadDate", query = "SELECT s FROM StoryReader s WHERE s.readDate = :readDate")})
public class StoryReader implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "read_date")
    @Temporal(TemporalType.DATE)
    private Date readDate;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "episode_content_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EpisodeContent episodeContentId;
    @JoinColumn(name = "magazine_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Magazine magazineId;
    @JoinColumn(name = "story_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Story storyId;

    public StoryReader() {
    }

    public StoryReader(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReadDate() {
        return readDate;
    }

    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
    }

    public EpisodeContent getEpisodeContentId() {
        return episodeContentId;
    }

    public void setEpisodeContentId(EpisodeContent episodeContentId) {
        this.episodeContentId = episodeContentId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StoryReader)) {
            return false;
        }
        StoryReader other = (StoryReader) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.StoryReader[ id=" + id + " ]";
    }
    
}
