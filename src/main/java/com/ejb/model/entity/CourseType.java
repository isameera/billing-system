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
@Table(name = "course_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CourseType.findAll", query = "SELECT c FROM CourseType c")
    , @NamedQuery(name = "CourseType.findById", query = "SELECT c FROM CourseType c WHERE c.id = :id")
    , @NamedQuery(name = "CourseType.findByName", query = "SELECT c FROM CourseType c WHERE c.name = :name")
    , @NamedQuery(name = "CourseType.findByIsActive", query = "SELECT c FROM CourseType c WHERE c.isActive = :isActive")})
public class CourseType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "is_active")
    private Integer isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseTypeId")
    private Collection<CourseUnitManager> courseUnitManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseTypeId")
    private Collection<Course> courseCollection;

    public CourseType() {
    }

    public CourseType(Integer id) {
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

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public Collection<CourseUnitManager> getCourseUnitManagerCollection() {
        return courseUnitManagerCollection;
    }

    public void setCourseUnitManagerCollection(Collection<CourseUnitManager> courseUnitManagerCollection) {
        this.courseUnitManagerCollection = courseUnitManagerCollection;
    }

    @XmlTransient
    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
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
        if (!(object instanceof CourseType)) {
            return false;
        }
        CourseType other = (CourseType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.CourseType[ id=" + id + " ]";
    }
    
}
