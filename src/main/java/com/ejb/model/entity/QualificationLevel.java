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
@Table(name = "qualification_level")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QualificationLevel.findAll", query = "SELECT q FROM QualificationLevel q")
    , @NamedQuery(name = "QualificationLevel.findById", query = "SELECT q FROM QualificationLevel q WHERE q.id = :id")
    , @NamedQuery(name = "QualificationLevel.findByName", query = "SELECT q FROM QualificationLevel q WHERE q.name = :name")})
public class QualificationLevel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qualificationLevelId")
    private Collection<QualificationContentManager> qualificationContentManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qualificationLevelId")
    private Collection<QualificationLevelManager> qualificationLevelManagerCollection;

    public QualificationLevel() {
    }

    public QualificationLevel(Integer id) {
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
    public Collection<QualificationContentManager> getQualificationContentManagerCollection() {
        return qualificationContentManagerCollection;
    }

    public void setQualificationContentManagerCollection(Collection<QualificationContentManager> qualificationContentManagerCollection) {
        this.qualificationContentManagerCollection = qualificationContentManagerCollection;
    }

    @XmlTransient
    public Collection<QualificationLevelManager> getQualificationLevelManagerCollection() {
        return qualificationLevelManagerCollection;
    }

    public void setQualificationLevelManagerCollection(Collection<QualificationLevelManager> qualificationLevelManagerCollection) {
        this.qualificationLevelManagerCollection = qualificationLevelManagerCollection;
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
        if (!(object instanceof QualificationLevel)) {
            return false;
        }
        QualificationLevel other = (QualificationLevel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.QualificationLevel[ id=" + id + " ]";
    }
    
}
