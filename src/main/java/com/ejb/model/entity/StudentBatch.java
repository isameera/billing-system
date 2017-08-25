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
@Table(name = "student_batch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentBatch.findAll", query = "SELECT s FROM StudentBatch s")
    , @NamedQuery(name = "StudentBatch.findById", query = "SELECT s FROM StudentBatch s WHERE s.id = :id")
    , @NamedQuery(name = "StudentBatch.findByTotalDiscount", query = "SELECT s FROM StudentBatch s WHERE s.totalDiscount = :totalDiscount")
    , @NamedQuery(name = "StudentBatch.findByTotalDueFee", query = "SELECT s FROM StudentBatch s WHERE s.totalDueFee = :totalDueFee")
    , @NamedQuery(name = "StudentBatch.findByCourseFee", query = "SELECT s FROM StudentBatch s WHERE s.courseFee = :courseFee")
    , @NamedQuery(name = "StudentBatch.findByTotalPaidAmount", query = "SELECT s FROM StudentBatch s WHERE s.totalPaidAmount = :totalPaidAmount")
    , @NamedQuery(name = "StudentBatch.findByIsExamCompleted", query = "SELECT s FROM StudentBatch s WHERE s.isExamCompleted = :isExamCompleted")
    , @NamedQuery(name = "StudentBatch.findByIsActive", query = "SELECT s FROM StudentBatch s WHERE s.isActive = :isActive")})
public class StudentBatch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_discount")
    private Double totalDiscount;
    @Column(name = "total_due_fee")
    private Double totalDueFee;
    @Column(name = "course_fee")
    private Double courseFee;
    @Column(name = "total_paid_amount")
    private Double totalPaidAmount;
    @Column(name = "is_exam_completed")
    private Integer isExamCompleted;
    @Column(name = "is_active")
    private Integer isActive;
    @JoinColumn(name = "batch_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Batch batchId;
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Student studentId;

    public StudentBatch() {
    }

    public StudentBatch(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Double getTotalDueFee() {
        return totalDueFee;
    }

    public void setTotalDueFee(Double totalDueFee) {
        this.totalDueFee = totalDueFee;
    }

    public Double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(Double courseFee) {
        this.courseFee = courseFee;
    }

    public Double getTotalPaidAmount() {
        return totalPaidAmount;
    }

    public void setTotalPaidAmount(Double totalPaidAmount) {
        this.totalPaidAmount = totalPaidAmount;
    }

    public Integer getIsExamCompleted() {
        return isExamCompleted;
    }

    public void setIsExamCompleted(Integer isExamCompleted) {
        this.isExamCompleted = isExamCompleted;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Batch getBatchId() {
        return batchId;
    }

    public void setBatchId(Batch batchId) {
        this.batchId = batchId;
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
        if (!(object instanceof StudentBatch)) {
            return false;
        }
        StudentBatch other = (StudentBatch) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.StudentBatch[ id=" + id + " ]";
    }
    
}
