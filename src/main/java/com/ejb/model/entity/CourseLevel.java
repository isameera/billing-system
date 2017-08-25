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
@Table(name = "course_level")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CourseLevel.findAll", query = "SELECT c FROM CourseLevel c")
    , @NamedQuery(name = "CourseLevel.findById", query = "SELECT c FROM CourseLevel c WHERE c.id = :id")
    , @NamedQuery(name = "CourseLevel.findByName", query = "SELECT c FROM CourseLevel c WHERE c.name = :name")})
public class CourseLevel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseLevelId")
    private Collection<CourseLevelManager> courseLevelManagerCollection;

    public CourseLevel() {
    }

    public CourseLevel(Integer id) {
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

    @XmlTransient
    public Collection<CourseLevelManager> getCourseLevelManagerCollection() {
        return courseLevelManagerCollection;
    }

    public void setCourseLevelManagerCollection(Collection<CourseLevelManager> courseLevelManagerCollection) {
        this.courseLevelManagerCollection = courseLevelManagerCollection;
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
        if (!(object instanceof CourseLevel)) {
            return false;
        }
        CourseLevel other = (CourseLevel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.CourseLevel[ id=" + id + " ]";
    }
    
}
