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
@Table(name = "batch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Batch.findAll", query = "SELECT b FROM Batch b")
    , @NamedQuery(name = "Batch.findById", query = "SELECT b FROM Batch b WHERE b.id = :id")
    , @NamedQuery(name = "Batch.findByTitle", query = "SELECT b FROM Batch b WHERE b.title = :title")
    , @NamedQuery(name = "Batch.findByCode", query = "SELECT b FROM Batch b WHERE b.code = :code")
    , @NamedQuery(name = "Batch.findByName", query = "SELECT b FROM Batch b WHERE b.name = :name")
    , @NamedQuery(name = "Batch.findByTotalStudent", query = "SELECT b FROM Batch b WHERE b.totalStudent = :totalStudent")
    , @NamedQuery(name = "Batch.findByTotalCollection", query = "SELECT b FROM Batch b WHERE b.totalCollection = :totalCollection")
    , @NamedQuery(name = "Batch.findByTotalExpectedAmount", query = "SELECT b FROM Batch b WHERE b.totalExpectedAmount = :totalExpectedAmount")
    , @NamedQuery(name = "Batch.findByTotalDiscount", query = "SELECT b FROM Batch b WHERE b.totalDiscount = :totalDiscount")
    , @NamedQuery(name = "Batch.findByStartingDate", query = "SELECT b FROM Batch b WHERE b.startingDate = :startingDate")
    , @NamedQuery(name = "Batch.findByStartTime", query = "SELECT b FROM Batch b WHERE b.startTime = :startTime")
    , @NamedQuery(name = "Batch.findByEndTime", query = "SELECT b FROM Batch b WHERE b.endTime = :endTime")
    , @NamedQuery(name = "Batch.findByIsStarted", query = "SELECT b FROM Batch b WHERE b.isStarted = :isStarted")
    , @NamedQuery(name = "Batch.findByIsFinished", query = "SELECT b FROM Batch b WHERE b.isFinished = :isFinished")})
public class Batch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "title")
    private String title;
    @Size(max = 45)
    @Column(name = "code")
    private String code;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "total_student")
    private Integer totalStudent;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_collection")
    private Double totalCollection;
    @Column(name = "total_expected_amount")
    private Double totalExpectedAmount;
    @Column(name = "total_discount")
    private Double totalDiscount;
    @Column(name = "starting_date")
    @Temporal(TemporalType.DATE)
    private Date startingDate;
    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Column(name = "is_started")
    private Integer isStarted;
    @Column(name = "is_finished")
    private Integer isFinished;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batchFrom")
    private Collection<BatchTransfer> batchTransferCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batchTo")
    private Collection<BatchTransfer> batchTransferCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batchId")
    private Collection<StudentBatch> studentBatchCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batchId")
    private Collection<TimeTable> timeTableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batchId")
    private Collection<StudentGroupProject> studentGroupProjectCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batchId")
    private Collection<AttendenceSheet> attendenceSheetCollection;
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Course courseId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;

    public Batch() {
    }

    public Batch(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getTotalStudent() {
        return totalStudent;
    }

    public void setTotalStudent(Integer totalStudent) {
        this.totalStudent = totalStudent;
    }

    public Double getTotalCollection() {
        return totalCollection;
    }

    public void setTotalCollection(Double totalCollection) {
        this.totalCollection = totalCollection;
    }

    public Double getTotalExpectedAmount() {
        return totalExpectedAmount;
    }

    public void setTotalExpectedAmount(Double totalExpectedAmount) {
        this.totalExpectedAmount = totalExpectedAmount;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getIsStarted() {
        return isStarted;
    }

    public void setIsStarted(Integer isStarted) {
        this.isStarted = isStarted;
    }

    public Integer getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Integer isFinished) {
        this.isFinished = isFinished;
    }

    @XmlTransient
    public Collection<BatchTransfer> getBatchTransferCollection() {
        return batchTransferCollection;
    }

    public void setBatchTransferCollection(Collection<BatchTransfer> batchTransferCollection) {
        this.batchTransferCollection = batchTransferCollection;
    }

    @XmlTransient
    public Collection<BatchTransfer> getBatchTransferCollection1() {
        return batchTransferCollection1;
    }

    public void setBatchTransferCollection1(Collection<BatchTransfer> batchTransferCollection1) {
        this.batchTransferCollection1 = batchTransferCollection1;
    }

    @XmlTransient
    public Collection<StudentBatch> getStudentBatchCollection() {
        return studentBatchCollection;
    }

    public void setStudentBatchCollection(Collection<StudentBatch> studentBatchCollection) {
        this.studentBatchCollection = studentBatchCollection;
    }

    @XmlTransient
    public Collection<TimeTable> getTimeTableCollection() {
        return timeTableCollection;
    }

    public void setTimeTableCollection(Collection<TimeTable> timeTableCollection) {
        this.timeTableCollection = timeTableCollection;
    }

    @XmlTransient
    public Collection<StudentGroupProject> getStudentGroupProjectCollection() {
        return studentGroupProjectCollection;
    }

    public void setStudentGroupProjectCollection(Collection<StudentGroupProject> studentGroupProjectCollection) {
        this.studentGroupProjectCollection = studentGroupProjectCollection;
    }

    @XmlTransient
    public Collection<AttendenceSheet> getAttendenceSheetCollection() {
        return attendenceSheetCollection;
    }

    public void setAttendenceSheetCollection(Collection<AttendenceSheet> attendenceSheetCollection) {
        this.attendenceSheetCollection = attendenceSheetCollection;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
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
        if (!(object instanceof Batch)) {
            return false;
        }
        Batch other = (Batch) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.Batch[ id=" + id + " ]";
    }
    
}
