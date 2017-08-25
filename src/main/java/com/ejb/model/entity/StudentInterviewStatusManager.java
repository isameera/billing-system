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
@Table(name = "student_interview_status_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentInterviewStatusManager.findAll", query = "SELECT s FROM StudentInterviewStatusManager s")
    , @NamedQuery(name = "StudentInterviewStatusManager.findById", query = "SELECT s FROM StudentInterviewStatusManager s WHERE s.id = :id")})
public class StudentInterviewStatusManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Student studentId;
    @JoinColumn(name = "student_interview_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StudentInterviewStatus studentInterviewStatusId;

    public StudentInterviewStatusManager() {
    }

    public StudentInterviewStatusManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public StudentInterviewStatus getStudentInterviewStatusId() {
        return studentInterviewStatusId;
    }

    public void setStudentInterviewStatusId(StudentInterviewStatus studentInterviewStatusId) {
        this.studentInterviewStatusId = studentInterviewStatusId;
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
        if (!(object instanceof StudentInterviewStatusManager)) {
            return false;
        }
        StudentInterviewStatusManager other = (StudentInterviewStatusManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.StudentInterviewStatusManager[ id=" + id + " ]";
    }
    
}
