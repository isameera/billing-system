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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "time_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TimeTable.findAll", query = "SELECT t FROM TimeTable t")
    , @NamedQuery(name = "TimeTable.findById", query = "SELECT t FROM TimeTable t WHERE t.id = :id")
    , @NamedQuery(name = "TimeTable.findByDate", query = "SELECT t FROM TimeTable t WHERE t.date = :date")
    , @NamedQuery(name = "TimeTable.findByStartTime", query = "SELECT t FROM TimeTable t WHERE t.startTime = :startTime")
    , @NamedQuery(name = "TimeTable.findByEndTime", query = "SELECT t FROM TimeTable t WHERE t.endTime = :endTime")
    , @NamedQuery(name = "TimeTable.findByLecturerInTime", query = "SELECT t FROM TimeTable t WHERE t.lecturerInTime = :lecturerInTime")
    , @NamedQuery(name = "TimeTable.findByLecturerOutTime", query = "SELECT t FROM TimeTable t WHERE t.lecturerOutTime = :lecturerOutTime")})
public class TimeTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Column(name = "lecturer_in_time")
    @Temporal(TemporalType.TIME)
    private Date lecturerInTime;
    @Column(name = "lecturer_out_time")
    @Temporal(TemporalType.TIME)
    private Date lecturerOutTime;
    @JoinColumn(name = "batch_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Batch batchId;
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Course courseId;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "hall_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Hall hallId;
    @JoinColumn(name = "time_slot_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TimeSlot timeSlotId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timeTableId")
    private Collection<ScheduledContent> scheduledContentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timeTableId")
    private Collection<SlotRepetitionManager> slotRepetitionManagerCollection;

    public TimeTable() {
    }

    public TimeTable(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Date getLecturerInTime() {
        return lecturerInTime;
    }

    public void setLecturerInTime(Date lecturerInTime) {
        this.lecturerInTime = lecturerInTime;
    }

    public Date getLecturerOutTime() {
        return lecturerOutTime;
    }

    public void setLecturerOutTime(Date lecturerOutTime) {
        this.lecturerOutTime = lecturerOutTime;
    }

    public Batch getBatchId() {
        return batchId;
    }

    public void setBatchId(Batch batchId) {
        this.batchId = batchId;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public Hall getHallId() {
        return hallId;
    }

    public void setHallId(Hall hallId) {
        this.hallId = hallId;
    }

    public TimeSlot getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(TimeSlot timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    @XmlTransient
    public Collection<ScheduledContent> getScheduledContentCollection() {
        return scheduledContentCollection;
    }

    public void setScheduledContentCollection(Collection<ScheduledContent> scheduledContentCollection) {
        this.scheduledContentCollection = scheduledContentCollection;
    }

    @XmlTransient
    public Collection<SlotRepetitionManager> getSlotRepetitionManagerCollection() {
        return slotRepetitionManagerCollection;
    }

    public void setSlotRepetitionManagerCollection(Collection<SlotRepetitionManager> slotRepetitionManagerCollection) {
        this.slotRepetitionManagerCollection = slotRepetitionManagerCollection;
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
        if (!(object instanceof TimeTable)) {
            return false;
        }
        TimeTable other = (TimeTable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.TimeTable[ id=" + id + " ]";
    }
    
}
