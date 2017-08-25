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
@Table(name = "qualification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Qualification.findAll", query = "SELECT q FROM Qualification q")
    , @NamedQuery(name = "Qualification.findById", query = "SELECT q FROM Qualification q WHERE q.id = :id")
    , @NamedQuery(name = "Qualification.findByName", query = "SELECT q FROM Qualification q WHERE q.name = :name")
    , @NamedQuery(name = "Qualification.findByTitle", query = "SELECT q FROM Qualification q WHERE q.title = :title")
    , @NamedQuery(name = "Qualification.findByDescription", query = "SELECT q FROM Qualification q WHERE q.description = :description")})
public class Qualification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 450)
    @Column(name = "name")
    private String name;
    @Size(max = 450)
    @Column(name = "title")
    private String title;
    @Size(max = 450)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qualificationId")
    private Collection<QualificationContentManager> qualificationContentManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qualificationId")
    private Collection<AwardingBody> awardingBodyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qualificationId")
    private Collection<QualificationLevelManager> qualificationLevelManagerCollection;
    @JoinColumn(name = "qulification_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private QulificationType qulificationTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qualificationId")
    private Collection<QualificationManager> qualificationManagerCollection;

    public Qualification() {
    }

    public Qualification(Integer id) {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<QualificationContentManager> getQualificationContentManagerCollection() {
        return qualificationContentManagerCollection;
    }

    public void setQualificationContentManagerCollection(Collection<QualificationContentManager> qualificationContentManagerCollection) {
        this.qualificationContentManagerCollection = qualificationContentManagerCollection;
    }

    @XmlTransient
    public Collection<AwardingBody> getAwardingBodyCollection() {
        return awardingBodyCollection;
    }

    public void setAwardingBodyCollection(Collection<AwardingBody> awardingBodyCollection) {
        this.awardingBodyCollection = awardingBodyCollection;
    }

    @XmlTransient
    public Collection<QualificationLevelManager> getQualificationLevelManagerCollection() {
        return qualificationLevelManagerCollection;
    }

    public void setQualificationLevelManagerCollection(Collection<QualificationLevelManager> qualificationLevelManagerCollection) {
        this.qualificationLevelManagerCollection = qualificationLevelManagerCollection;
    }

    public QulificationType getQulificationTypeId() {
        return qulificationTypeId;
    }

    public void setQulificationTypeId(QulificationType qulificationTypeId) {
        this.qulificationTypeId = qulificationTypeId;
    }

    @XmlTransient
    public Collection<QualificationManager> getQualificationManagerCollection() {
        return qualificationManagerCollection;
    }

    public void setQualificationManagerCollection(Collection<QualificationManager> qualificationManagerCollection) {
        this.qualificationManagerCollection = qualificationManagerCollection;
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
        if (!(object instanceof Qualification)) {
            return false;
        }
        Qualification other = (Qualification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.Qualification[ id=" + id + " ]";
    }
    
}
