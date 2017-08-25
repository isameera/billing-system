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
@Table(name = "qualification_level_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QualificationLevelManager.findAll", query = "SELECT q FROM QualificationLevelManager q")
    , @NamedQuery(name = "QualificationLevelManager.findById", query = "SELECT q FROM QualificationLevelManager q WHERE q.id = :id")})
public class QualificationLevelManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "qualification_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Qualification qualificationId;
    @JoinColumn(name = "qualification_level_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private QualificationLevel qualificationLevelId;

    public QualificationLevelManager() {
    }

    public QualificationLevelManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Qualification getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(Qualification qualificationId) {
        this.qualificationId = qualificationId;
    }

    public QualificationLevel getQualificationLevelId() {
        return qualificationLevelId;
    }

    public void setQualificationLevelId(QualificationLevel qualificationLevelId) {
        this.qualificationLevelId = qualificationLevelId;
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
        if (!(object instanceof QualificationLevelManager)) {
            return false;
        }
        QualificationLevelManager other = (QualificationLevelManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.QualificationLevelManager[ id=" + id + " ]";
    }
    
}
