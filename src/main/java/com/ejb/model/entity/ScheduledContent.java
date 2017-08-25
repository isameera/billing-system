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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "scheduled_content")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScheduledContent.findAll", query = "SELECT s FROM ScheduledContent s")
    , @NamedQuery(name = "ScheduledContent.findById", query = "SELECT s FROM ScheduledContent s WHERE s.id = :id")
    , @NamedQuery(name = "ScheduledContent.findByIsCompleted", query = "SELECT s FROM ScheduledContent s WHERE s.isCompleted = :isCompleted")})
public class ScheduledContent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "is_completed")
    private Integer isCompleted;
    @JoinColumn(name = "lesson_content_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LessonContentManager lessonContentManagerId;
    @JoinColumn(name = "time_table_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TimeTable timeTableId;

    public ScheduledContent() {
    }

    public ScheduledContent(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Integer isCompleted) {
        this.isCompleted = isCompleted;
    }

    public LessonContentManager getLessonContentManagerId() {
        return lessonContentManagerId;
    }

    public void setLessonContentManagerId(LessonContentManager lessonContentManagerId) {
        this.lessonContentManagerId = lessonContentManagerId;
    }

    public TimeTable getTimeTableId() {
        return timeTableId;
    }

    public void setTimeTableId(TimeTable timeTableId) {
        this.timeTableId = timeTableId;
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
        if (!(object instanceof ScheduledContent)) {
            return false;
        }
        ScheduledContent other = (ScheduledContent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ScheduledContent[ id=" + id + " ]";
    }
    
}
