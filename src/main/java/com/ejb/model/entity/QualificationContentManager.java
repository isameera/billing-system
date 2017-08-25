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
@Table(name = "qualification_content_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QualificationContentManager.findAll", query = "SELECT q FROM QualificationContentManager q")
    , @NamedQuery(name = "QualificationContentManager.findById", query = "SELECT q FROM QualificationContentManager q WHERE q.id = :id")})
public class QualificationContentManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "grade_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Grade gradeId;
    @JoinColumn(name = "qualification_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Qualification qualificationId;
    @JoinColumn(name = "qualification_content_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private QualificationContent qualificationContentId;
    @JoinColumn(name = "qualification_level_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private QualificationLevel qualificationLevelId;
    @JoinColumn(name = "qulification_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private QulificationType qulificationTypeId;

    public QualificationContentManager() {
    }

    public QualificationContentManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Grade getGradeId() {
        return gradeId;
    }

    public void setGradeId(Grade gradeId) {
        this.gradeId = gradeId;
    }

    public Qualification getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(Qualification qualificationId) {
        this.qualificationId = qualificationId;
    }

    public QualificationContent getQualificationContentId() {
        return qualificationContentId;
    }

    public void setQualificationContentId(QualificationContent qualificationContentId) {
        this.qualificationContentId = qualificationContentId;
    }

    public QualificationLevel getQualificationLevelId() {
        return qualificationLevelId;
    }

    public void setQualificationLevelId(QualificationLevel qualificationLevelId) {
        this.qualificationLevelId = qualificationLevelId;
    }

    public QulificationType getQulificationTypeId() {
        return qulificationTypeId;
    }

    public void setQulificationTypeId(QulificationType qulificationTypeId) {
        this.qulificationTypeId = qulificationTypeId;
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
        if (!(object instanceof QualificationContentManager)) {
            return false;
        }
        QualificationContentManager other = (QualificationContentManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.QualificationContentManager[ id=" + id + " ]";
    }
    
}
