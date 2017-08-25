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
import javax.persistence.Lob;
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
@Table(name = "course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
    , @NamedQuery(name = "Course.findById", query = "SELECT c FROM Course c WHERE c.id = :id")
    , @NamedQuery(name = "Course.findByCode", query = "SELECT c FROM Course c WHERE c.code = :code")
    , @NamedQuery(name = "Course.findByTitle", query = "SELECT c FROM Course c WHERE c.title = :title")
    , @NamedQuery(name = "Course.findByFullName", query = "SELECT c FROM Course c WHERE c.fullName = :fullName")
    , @NamedQuery(name = "Course.findByDuration", query = "SELECT c FROM Course c WHERE c.duration = :duration")
    , @NamedQuery(name = "Course.findByStandardFee", query = "SELECT c FROM Course c WHERE c.standardFee = :standardFee")
    , @NamedQuery(name = "Course.findByDiscountPercentage", query = "SELECT c FROM Course c WHERE c.discountPercentage = :discountPercentage")
    , @NamedQuery(name = "Course.findByTotalContactHour", query = "SELECT c FROM Course c WHERE c.totalContactHour = :totalContactHour")
    , @NamedQuery(name = "Course.findByContactHoursPerDay", query = "SELECT c FROM Course c WHERE c.contactHoursPerDay = :contactHoursPerDay")
    , @NamedQuery(name = "Course.findByNotionalHours", query = "SELECT c FROM Course c WHERE c.notionalHours = :notionalHours")
    , @NamedQuery(name = "Course.findByColor", query = "SELECT c FROM Course c WHERE c.color = :color")
    , @NamedQuery(name = "Course.findByIsActive", query = "SELECT c FROM Course c WHERE c.isActive = :isActive")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "code")
    private String code;
    @Size(max = 145)
    @Column(name = "title")
    private String title;
    @Size(max = 450)
    @Column(name = "full_name")
    private String fullName;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "duration")
    private Double duration;
    @Column(name = "standard_fee")
    private Double standardFee;
    @Column(name = "discount_percentage")
    private Double discountPercentage;
    @Column(name = "total_contact_hour")
    private Double totalContactHour;
    @Column(name = "contact_hours_per_day")
    private Double contactHoursPerDay;
    @Column(name = "notional_hours")
    private Double notionalHours;
    @Size(max = 45)
    @Column(name = "color")
    private String color;
    @Column(name = "is_active")
    private Integer isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Collection<CourseUnit> courseUnitCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId1")
    private Collection<CourseUnit> courseUnitCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Collection<CourseInstallmentManager> courseInstallmentManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Collection<TimeTable> timeTableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Collection<CenterCourseManager> centerCourseManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Collection<StudentCourseMaster> studentCourseMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Collection<StudentCourseManager> studentCourseManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Collection<CoursePackgeManager> coursePackgeManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Collection<Batch> batchCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Collection<CourseUnitManager> courseUnitManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Collection<CourseLevelManager> courseLevelManagerCollection;
    @JoinColumn(name = "course_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CourseType courseTypeId;
    @JoinColumn(name = "org_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrgItem orgItemId;
    @JoinColumn(name = "sub_chart_of_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SubChartOfAccount subChartOfAccountId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Collection<CounsellingHistory> counsellingHistoryCollection;

    public Course() {
    }

    public Course(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Double getStandardFee() {
        return standardFee;
    }

    public void setStandardFee(Double standardFee) {
        this.standardFee = standardFee;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Double getTotalContactHour() {
        return totalContactHour;
    }

    public void setTotalContactHour(Double totalContactHour) {
        this.totalContactHour = totalContactHour;
    }

    public Double getContactHoursPerDay() {
        return contactHoursPerDay;
    }

    public void setContactHoursPerDay(Double contactHoursPerDay) {
        this.contactHoursPerDay = contactHoursPerDay;
    }

    public Double getNotionalHours() {
        return notionalHours;
    }

    public void setNotionalHours(Double notionalHours) {
        this.notionalHours = notionalHours;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public Collection<CourseUnit> getCourseUnitCollection() {
        return courseUnitCollection;
    }

    public void setCourseUnitCollection(Collection<CourseUnit> courseUnitCollection) {
        this.courseUnitCollection = courseUnitCollection;
    }

    @XmlTransient
    public Collection<CourseUnit> getCourseUnitCollection1() {
        return courseUnitCollection1;
    }

    public void setCourseUnitCollection1(Collection<CourseUnit> courseUnitCollection1) {
        this.courseUnitCollection1 = courseUnitCollection1;
    }

    @XmlTransient
    public Collection<CourseInstallmentManager> getCourseInstallmentManagerCollection() {
        return courseInstallmentManagerCollection;
    }

    public void setCourseInstallmentManagerCollection(Collection<CourseInstallmentManager> courseInstallmentManagerCollection) {
        this.courseInstallmentManagerCollection = courseInstallmentManagerCollection;
    }

    @XmlTransient
    public Collection<TimeTable> getTimeTableCollection() {
        return timeTableCollection;
    }

    public void setTimeTableCollection(Collection<TimeTable> timeTableCollection) {
        this.timeTableCollection = timeTableCollection;
    }

    @XmlTransient
    public Collection<CenterCourseManager> getCenterCourseManagerCollection() {
        return centerCourseManagerCollection;
    }

    public void setCenterCourseManagerCollection(Collection<CenterCourseManager> centerCourseManagerCollection) {
        this.centerCourseManagerCollection = centerCourseManagerCollection;
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
    public Collection<CoursePackgeManager> getCoursePackgeManagerCollection() {
        return coursePackgeManagerCollection;
    }

    public void setCoursePackgeManagerCollection(Collection<CoursePackgeManager> coursePackgeManagerCollection) {
        this.coursePackgeManagerCollection = coursePackgeManagerCollection;
    }

    @XmlTransient
    public Collection<Batch> getBatchCollection() {
        return batchCollection;
    }

    public void setBatchCollection(Collection<Batch> batchCollection) {
        this.batchCollection = batchCollection;
    }

    @XmlTransient
    public Collection<CourseUnitManager> getCourseUnitManagerCollection() {
        return courseUnitManagerCollection;
    }

    public void setCourseUnitManagerCollection(Collection<CourseUnitManager> courseUnitManagerCollection) {
        this.courseUnitManagerCollection = courseUnitManagerCollection;
    }

    @XmlTransient
    public Collection<CourseLevelManager> getCourseLevelManagerCollection() {
        return courseLevelManagerCollection;
    }

    public void setCourseLevelManagerCollection(Collection<CourseLevelManager> courseLevelManagerCollection) {
        this.courseLevelManagerCollection = courseLevelManagerCollection;
    }

    public CourseType getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(CourseType courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public OrgItem getOrgItemId() {
        return orgItemId;
    }

    public void setOrgItemId(OrgItem orgItemId) {
        this.orgItemId = orgItemId;
    }

    public SubChartOfAccount getSubChartOfAccountId() {
        return subChartOfAccountId;
    }

    public void setSubChartOfAccountId(SubChartOfAccount subChartOfAccountId) {
        this.subChartOfAccountId = subChartOfAccountId;
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
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.Course[ id=" + id + " ]";
    }
    
}
