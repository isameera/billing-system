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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "course_module")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CourseModule.findAll", query = "SELECT c FROM CourseModule c")
    , @NamedQuery(name = "CourseModule.findById", query = "SELECT c FROM CourseModule c WHERE c.id = :id")
    , @NamedQuery(name = "CourseModule.findByCode", query = "SELECT c FROM CourseModule c WHERE c.code = :code")
    , @NamedQuery(name = "CourseModule.findByName", query = "SELECT c FROM CourseModule c WHERE c.name = :name")
    , @NamedQuery(name = "CourseModule.findByDescription", query = "SELECT c FROM CourseModule c WHERE c.description = :description")
    , @NamedQuery(name = "CourseModule.findByUrl", query = "SELECT c FROM CourseModule c WHERE c.url = :url")})
public class CourseModule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "code")
    private String code;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Size(max = 45)
    @Column(name = "url")
    private String url;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseModuleId")
    private Collection<CourseModuleManager> courseModuleManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseModuleId")
    private Collection<Lesson> lessonCollection;
    @JoinColumn(name = "course_unit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CourseUnit courseUnitId;

    public CourseModule() {
    }

    public CourseModule(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlTransient
    public Collection<CourseModuleManager> getCourseModuleManagerCollection() {
        return courseModuleManagerCollection;
    }

    public void setCourseModuleManagerCollection(Collection<CourseModuleManager> courseModuleManagerCollection) {
        this.courseModuleManagerCollection = courseModuleManagerCollection;
    }

    @XmlTransient
    public Collection<Lesson> getLessonCollection() {
        return lessonCollection;
    }

    public void setLessonCollection(Collection<Lesson> lessonCollection) {
        this.lessonCollection = lessonCollection;
    }

    public CourseUnit getCourseUnitId() {
        return courseUnitId;
    }

    public void setCourseUnitId(CourseUnit courseUnitId) {
        this.courseUnitId = courseUnitId;
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
        if (!(object instanceof CourseModule)) {
            return false;
        }
        CourseModule other = (CourseModule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.CourseModule[ id=" + id + " ]";
    }
    
}
