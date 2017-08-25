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
@Table(name = "story")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Story.findAll", query = "SELECT s FROM Story s")
    , @NamedQuery(name = "Story.findById", query = "SELECT s FROM Story s WHERE s.id = :id")
    , @NamedQuery(name = "Story.findByStartedDate", query = "SELECT s FROM Story s WHERE s.startedDate = :startedDate")
    , @NamedQuery(name = "Story.findByCoverImage", query = "SELECT s FROM Story s WHERE s.coverImage = :coverImage")})
public class Story implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 65535)
    @Column(name = "content")
    private String content;
    @Column(name = "started_date")
    @Temporal(TemporalType.DATE)
    private Date startedDate;
    @Size(max = 450)
    @Column(name = "cover_image")
    private String coverImage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storyId")
    private Collection<Episode> episodeCollection;
    @JoinColumn(name = "ariticle_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StoryType ariticleTypeId;
    @JoinColumn(name = "magazine_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Magazine magazineId;
    @JoinColumn(name = "editor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile editor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storyId")
    private Collection<StoryReader> storyReaderCollection;

    public Story() {
    }

    public Story(Integer id) {
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

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    @XmlTransient
    public Collection<Episode> getEpisodeCollection() {
        return episodeCollection;
    }

    public void setEpisodeCollection(Collection<Episode> episodeCollection) {
        this.episodeCollection = episodeCollection;
    }

    public StoryType getAriticleTypeId() {
        return ariticleTypeId;
    }

    public void setAriticleTypeId(StoryType ariticleTypeId) {
        this.ariticleTypeId = ariticleTypeId;
    }

    public Magazine getMagazineId() {
        return magazineId;
    }

    public void setMagazineId(Magazine magazineId) {
        this.magazineId = magazineId;
    }

    public GeneralUserProfile getEditor() {
        return editor;
    }

    public void setEditor(GeneralUserProfile editor) {
        this.editor = editor;
    }

    @XmlTransient
    public Collection<StoryReader> getStoryReaderCollection() {
        return storyReaderCollection;
    }

    public void setStoryReaderCollection(Collection<StoryReader> storyReaderCollection) {
        this.storyReaderCollection = storyReaderCollection;
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
        if (!(object instanceof Story)) {
            return false;
        }
        Story other = (Story) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.Story[ id=" + id + " ]";
    }
    
}
