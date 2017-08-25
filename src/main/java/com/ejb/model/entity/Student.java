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
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = :id")
    , @NamedQuery(name = "Student.findByStudentId", query = "SELECT s FROM Student s WHERE s.studentId = :studentId")
    , @NamedQuery(name = "Student.findByCurrentStudy", query = "SELECT s FROM Student s WHERE s.currentStudy = :currentStudy")
    , @NamedQuery(name = "Student.findByIqMarks", query = "SELECT s FROM Student s WHERE s.iqMarks = :iqMarks")
    , @NamedQuery(name = "Student.findBySchool", query = "SELECT s FROM Student s WHERE s.school = :school")
    , @NamedQuery(name = "Student.findByNameOnCcertificate", query = "SELECT s FROM Student s WHERE s.nameOnCcertificate = :nameOnCcertificate")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "student_id")
    private String studentId;
    @Size(max = 45)
    @Column(name = "current_study")
    private String currentStudy;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "iq_marks")
    private Double iqMarks;
    @Size(max = 45)
    @Column(name = "school")
    private String school;
    @Size(max = 450)
    @Column(name = "name_on_ccertificate")
    private String nameOnCcertificate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
    private Collection<BatchTransfer> batchTransferCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
    private Collection<StudentBatch> studentBatchCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
    private Collection<StudentStatusManager> studentStatusManagerCollection;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "introduction_media_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private IntroductionMedia introductionMediaId;
    @JoinColumn(name = "student_interview_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StudentInterviewStatus studentInterviewStatusId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
    private Collection<StudentCourseMaster> studentCourseMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
    private Collection<StudentCourseManager> studentCourseManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
    private Collection<StudentInterviewStatusManager> studentInterviewStatusManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
    private Collection<StudentGuardian> studentGuardianCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
    private Collection<CounsellingHistory> counsellingHistoryCollection;

    public Student() {
    }

    public Student(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCurrentStudy() {
        return currentStudy;
    }

    public void setCurrentStudy(String currentStudy) {
        this.currentStudy = currentStudy;
    }

    public Double getIqMarks() {
        return iqMarks;
    }

    public void setIqMarks(Double iqMarks) {
        this.iqMarks = iqMarks;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getNameOnCcertificate() {
        return nameOnCcertificate;
    }

    public void setNameOnCcertificate(String nameOnCcertificate) {
        this.nameOnCcertificate = nameOnCcertificate;
    }

    @XmlTransient
    public Collection<BatchTransfer> getBatchTransferCollection() {
        return batchTransferCollection;
    }

    public void setBatchTransferCollection(Collection<BatchTransfer> batchTransferCollection) {
        this.batchTransferCollection = batchTransferCollection;
    }

    @XmlTransient
    public Collection<StudentBatch> getStudentBatchCollection() {
        return studentBatchCollection;
    }

    public void setStudentBatchCollection(Collection<StudentBatch> studentBatchCollection) {
        this.studentBatchCollection = studentBatchCollection;
    }

    @XmlTransient
    public Collection<StudentStatusManager> getStudentStatusManagerCollection() {
        return studentStatusManagerCollection;
    }

    public void setStudentStatusManagerCollection(Collection<StudentStatusManager> studentStatusManagerCollection) {
        this.studentStatusManagerCollection = studentStatusManagerCollection;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
    }

    public IntroductionMedia getIntroductionMediaId() {
        return introductionMediaId;
    }

    public void setIntroductionMediaId(IntroductionMedia introductionMediaId) {
        this.introductionMediaId = introductionMediaId;
    }

    public StudentInterviewStatus getStudentInterviewStatusId() {
        return studentInterviewStatusId;
    }

    public void setStudentInterviewStatusId(StudentInterviewStatus studentInterviewStatusId) {
        this.studentInterviewStatusId = studentInterviewStatusId;
    }

    @XmlTransient
    public Collection<StudentCourseMaster> getStudentCourseMasterCollection() {
        return studentCourseMasterCollection;
    }

    public void setStudentCourseMasterCollection(Collection<StudentCourseMaster> studentCourseMasterCollection) {
        this.studentCourseMasterCollection = studentCourseMasterCollection;
    }

    @XmlTransient
    public Collection<StudentCourseManager> getStudentCourseManagerCollection() {
        return studentCourseManagerCollection;
    }

    public void setStudentCourseManagerCollection(Collection<StudentCourseManager> studentCourseManagerCollection) {
        this.studentCourseManagerCollection = studentCourseManagerCollection;
    }

    @XmlTransient
    public Collection<StudentInterviewStatusManager> getStudentInterviewStatusManagerCollection() {
        return studentInterviewStatusManagerCollection;
    }

    public void setStudentInterviewStatusManagerCollection(Collection<StudentInterviewStatusManager> studentInterviewStatusManagerCollection) {
        this.studentInterviewStatusManagerCollection = studentInterviewStatusManagerCollection;
    }

    @XmlTransient
    public Collection<StudentGuardian> getStudentGuardianCollection() {
        return studentGuardianCollection;
    }

    public void setStudentGuardianCollection(Collection<StudentGuardian> studentGuardianCollection) {
        this.studentGuardianCollection = studentGuardianCollection;
    }

    @XmlTransient
    public Collection<CounsellingHistory> getCounsellingHistoryCollection() {
        return counsellingHistoryCollection;
    }

    public void setCounsellingHistoryCollection(Collection<CounsellingHistory> counsellingHistoryCollection) {
        this.counsellingHistoryCollection = counsellingHistoryCollection;
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.Student[ id=" + id + " ]";
    }
    
}
