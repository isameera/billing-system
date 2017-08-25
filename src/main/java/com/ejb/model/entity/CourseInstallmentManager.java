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
@Table(name = "course_installment_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CourseInstallmentManager.findAll", query = "SELECT c FROM CourseInstallmentManager c")
    , @NamedQuery(name = "CourseInstallmentManager.findById", query = "SELECT c FROM CourseInstallmentManager c WHERE c.id = :id")
    , @NamedQuery(name = "CourseInstallmentManager.findByAmount", query = "SELECT c FROM CourseInstallmentManager c WHERE c.amount = :amount")})
public class CourseInstallmentManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Course courseId;
    @JoinColumn(name = "course_installment_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CourseInstallment courseInstallmentId;

    public CourseInstallmentManager() {
    }

    public CourseInstallmentManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public CourseInstallment getCourseInstallmentId() {
        return courseInstallmentId;
    }

    public void setCourseInstallmentId(CourseInstallment courseInstallmentId) {
        this.courseInstallmentId = courseInstallmentId;
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
        if (!(object instanceof CourseInstallmentManager)) {
            return false;
        }
        CourseInstallmentManager other = (CourseInstallmentManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.CourseInstallmentManager[ id=" + id + " ]";
    }
    
}
