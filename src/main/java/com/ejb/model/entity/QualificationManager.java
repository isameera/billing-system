/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "qualification_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QualificationManager.findAll", query = "SELECT q FROM QualificationManager q")
    , @NamedQuery(name = "QualificationManager.findById", query = "SELECT q FROM QualificationManager q WHERE q.id = :id")
    , @NamedQuery(name = "QualificationManager.findByDateOfReceived", query = "SELECT q FROM QualificationManager q WHERE q.dateOfReceived = :dateOfReceived")
    , @NamedQuery(name = "QualificationManager.findByUploadedTranscript", query = "SELECT q FROM QualificationManager q WHERE q.uploadedTranscript = :uploadedTranscript")
    , @NamedQuery(name = "QualificationManager.findByUploadedCertificate", query = "SELECT q FROM QualificationManager q WHERE q.uploadedCertificate = :uploadedCertificate")})
public class QualificationManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date_of_received")
    @Temporal(TemporalType.DATE)
    private Date dateOfReceived;
    @Size(max = 45)
    @Column(name = "uploaded_transcript")
    private String uploadedTranscript;
    @Size(max = 45)
    @Column(name = "uploaded_certificate")
    private String uploadedCertificate;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qualificationManagerId")
    private Collection<Gpa> gpaCollection;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "grade_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Grade gradeId;
    @JoinColumn(name = "qualification_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Qualification qualificationId;

    public QualificationManager() {
    }

    public QualificationManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateOfReceived() {
        return dateOfReceived;
    }

    public void setDateOfReceived(Date dateOfReceived) {
        this.dateOfReceived = dateOfReceived;
    }

    public String getUploadedTranscript() {
        return uploadedTranscript;
    }

    public void setUploadedTranscript(String uploadedTranscript) {
        this.uploadedTranscript = uploadedTranscript;
    }

    public String getUploadedCertificate() {
        return uploadedCertificate;
    }

    public void setUploadedCertificate(String uploadedCertificate) {
        this.uploadedCertificate = uploadedCertificate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Gpa> getGpaCollection() {
        return gpaCollection;
    }

    public void setGpaCollection(Collection<Gpa> gpaCollection) {
        this.gpaCollection = gpaCollection;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QualificationManager)) {
            return false;
        }
        QualificationManager other = (QualificationManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.QualificationManager[ id=" + id + " ]";
    }
    
}
