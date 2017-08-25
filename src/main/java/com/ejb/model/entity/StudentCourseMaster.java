/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "student_course_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentCourseMaster.findAll", query = "SELECT s FROM StudentCourseMaster s")
    , @NamedQuery(name = "StudentCourseMaster.findById", query = "SELECT s FROM StudentCourseMaster s WHERE s.id = :id")
    , @NamedQuery(name = "StudentCourseMaster.findByRegisteredDate", query = "SELECT s FROM StudentCourseMaster s WHERE s.registeredDate = :registeredDate")
    , @NamedQuery(name = "StudentCourseMaster.findByPayment", query = "SELECT s FROM StudentCourseMaster s WHERE s.payment = :payment")
    , @NamedQuery(name = "StudentCourseMaster.findByPaidAmount", query = "SELECT s FROM StudentCourseMaster s WHERE s.paidAmount = :paidAmount")
    , @NamedQuery(name = "StudentCourseMaster.findByDue", query = "SELECT s FROM StudentCourseMaster s WHERE s.due = :due")
    , @NamedQuery(name = "StudentCourseMaster.findByDiscount", query = "SELECT s FROM StudentCourseMaster s WHERE s.discount = :discount")
    , @NamedQuery(name = "StudentCourseMaster.findByDescription", query = "SELECT s FROM StudentCourseMaster s WHERE s.description = :description")})
public class StudentCourseMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "registered_date")
    @Temporal(TemporalType.DATE)
    private Date registeredDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "payment")
    private Double payment;
    @Column(name = "paid_amount")
    private Double paidAmount;
    @Column(name = "due")
    private Double due;
    @Column(name = "discount")
    private Double discount;
    @Size(max = 1000)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Course courseId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "student_course_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StudentCourseStatus studentCourseStatusId;
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Student studentId;

    public StudentCourseMaster() {
    }

    public StudentCourseMaster(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Double getDue() {
        return due;
    }

    public void setDue(Double due) {
        this.due = due;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public StudentCourseStatus getStudentCourseStatusId() {
        return studentCourseStatusId;
    }

    public void setStudentCourseStatusId(StudentCourseStatus studentCourseStatusId) {
        this.studentCourseStatusId = studentCourseStatusId;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
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
        if (!(object instanceof StudentCourseMaster)) {
            return false;
        }
        StudentCourseMaster other = (StudentCourseMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.StudentCourseMaster[ id=" + id + " ]";
    }
    
}
