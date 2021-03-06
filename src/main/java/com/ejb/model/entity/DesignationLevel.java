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
@Table(name = "designation_level")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DesignationLevel.findAll", query = "SELECT d FROM DesignationLevel d")
    , @NamedQuery(name = "DesignationLevel.findById", query = "SELECT d FROM DesignationLevel d WHERE d.id = :id")
    , @NamedQuery(name = "DesignationLevel.findByName", query = "SELECT d FROM DesignationLevel d WHERE d.name = :name")})
public class DesignationLevel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "designationLevelId")
    private Collection<DesignationGrade> designationGradeCollection;
    @OneToMany(mappedBy = "designationLevelIdDl")
    private Collection<Designation> designationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "designationLevelId")
    private Collection<DesignationLevelManager> designationLevelManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "designationLevelId")
    private Collection<OrgDesignationLevel> orgDesignationLevelCollection;

    public DesignationLevel() {
    }

    public DesignationLevel(Integer id) {
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
    public Collection<DesignationGrade> getDesignationGradeCollection() {
        return designationGradeCollection;
    }

    public void setDesignationGradeCollection(Collection<DesignationGrade> designationGradeCollection) {
        this.designationGradeCollection = designationGradeCollection;
    }

    @XmlTransient
    public Collection<Designation> getDesignationCollection() {
        return designationCollection;
    }

    public void setDesignationCollection(Collection<Designation> designationCollection) {
        this.designationCollection = designationCollection;
    }

    @XmlTransient
    public Collection<DesignationLevelManager> getDesignationLevelManagerCollection() {
        return designationLevelManagerCollection;
    }

    public void setDesignationLevelManagerCollection(Collection<DesignationLevelManager> designationLevelManagerCollection) {
        this.designationLevelManagerCollection = designationLevelManagerCollection;
    }

    @XmlTransient
    public Collection<OrgDesignationLevel> getOrgDesignationLevelCollection() {
        return orgDesignationLevelCollection;
    }

    public void setOrgDesignationLevelCollection(Collection<OrgDesignationLevel> orgDesignationLevelCollection) {
        this.orgDesignationLevelCollection = orgDesignationLevelCollection;
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
        if (!(object instanceof DesignationLevel)) {
            return false;
        }
        DesignationLevel other = (DesignationLevel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.DesignationLevel[ id=" + id + " ]";
    }
    
}
