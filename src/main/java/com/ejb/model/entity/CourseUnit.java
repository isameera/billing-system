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
@Table(name = "course_unit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CourseUnit.findAll", query = "SELECT c FROM CourseUnit c")
    , @NamedQuery(name = "CourseUnit.findById", query = "SELECT c FROM CourseUnit c WHERE c.id = :id")})
public class CourseUnit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Course courseId;
    @JoinColumn(name = "course_id1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Course courseId1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseUnitId")
    private Collection<CourseModule> courseModuleCollection;

    public CourseUnit() {
    }

    public CourseUnit(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public Course getCourseId1() {
        return courseId1;
    }

    public void setCourseId1(Course courseId1) {
        this.courseId1 = courseId1;
    }

    @XmlTransient
    public Collection<CourseModule> getCourseModuleCollection() {
        return courseModuleCollection;
    }

    public void setCourseModuleCollection(Collection<CourseModule> courseModuleCollection) {
        this.courseModuleCollection = courseModuleCollection;
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
        if (!(object instanceof CourseUnit)) {
            return false;
        }
        CourseUnit other = (CourseUnit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.CourseUnit[ id=" + id + " ]";
    }
    
}
