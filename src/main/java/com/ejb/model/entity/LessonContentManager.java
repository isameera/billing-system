/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "lesson_content_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LessonContentManager.findAll", query = "SELECT l FROM LessonContentManager l")
    , @NamedQuery(name = "LessonContentManager.findById", query = "SELECT l FROM LessonContentManager l WHERE l.id = :id")})
public class LessonContentManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lessonContentManagerId")
    private Collection<ScheduledContent> scheduledContentCollection;
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Lesson lessonId;
    @JoinColumn(name = "lesson_content_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LessonContent lessonContentId;

    public LessonContentManager() {
    }

    public LessonContentManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<ScheduledContent> getScheduledContentCollection() {
        return scheduledContentCollection;
    }

    public void setScheduledContentCollection(Collection<ScheduledContent> scheduledContentCollection) {
        this.scheduledContentCollection = scheduledContentCollection;
    }

    public Lesson getLessonId() {
        return lessonId;
    }

    public void setLessonId(Lesson lessonId) {
        this.lessonId = lessonId;
    }

    public LessonContent getLessonContentId() {
        return lessonContentId;
    }

    public void setLessonContentId(LessonContent lessonContentId) {
        this.lessonContentId = lessonContentId;
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
        if (!(object instanceof LessonContentManager)) {
            return false;
        }
        LessonContentManager other = (LessonContentManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.LessonContentManager[ id=" + id + " ]";
    }
    
}
