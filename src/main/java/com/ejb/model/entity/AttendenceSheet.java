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
@Table(name = "attendence_sheet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AttendenceSheet.findAll", query = "SELECT a FROM AttendenceSheet a")
    , @NamedQuery(name = "AttendenceSheet.findById", query = "SELECT a FROM AttendenceSheet a WHERE a.id = :id")
    , @NamedQuery(name = "AttendenceSheet.findByDate", query = "SELECT a FROM AttendenceSheet a WHERE a.date = :date")
    , @NamedQuery(name = "AttendenceSheet.findByTotalStudents", query = "SELECT a FROM AttendenceSheet a WHERE a.totalStudents = :totalStudents")
    , @NamedQuery(name = "AttendenceSheet.findByTotalAbsent", query = "SELECT a FROM AttendenceSheet a WHERE a.totalAbsent = :totalAbsent")})
public class AttendenceSheet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "total_students")
    private Integer totalStudents;
    @Column(name = "total_absent")
    private Integer totalAbsent;
    @JoinColumn(name = "batch_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Batch batchId;
    @JoinColumn(name = "login_session_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LoginSession loginSessionId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attendenceSheetId")
    private Collection<StudentAttendence> studentAttendenceCollection;

    public AttendenceSheet() {
    }

    public AttendenceSheet(Integer id) {
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

    public Integer getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(Integer totalStudents) {
        this.totalStudents = totalStudents;
    }

    public Integer getTotalAbsent() {
        return totalAbsent;
    }

    public void setTotalAbsent(Integer totalAbsent) {
        this.totalAbsent = totalAbsent;
    }

    public Batch getBatchId() {
        return batchId;
    }

    public void setBatchId(Batch batchId) {
        this.batchId = batchId;
    }

    public LoginSession getLoginSessionId() {
        return loginSessionId;
    }

    public void setLoginSessionId(LoginSession loginSessionId) {
        this.loginSessionId = loginSessionId;
    }

    @XmlTransient
    public Collection<StudentAttendence> getStudentAttendenceCollection() {
        return studentAttendenceCollection;
    }

    public void setStudentAttendenceCollection(Collection<StudentAttendence> studentAttendenceCollection) {
        this.studentAttendenceCollection = studentAttendenceCollection;
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
        if (!(object instanceof AttendenceSheet)) {
            return false;
        }
        AttendenceSheet other = (AttendenceSheet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.AttendenceSheet[ id=" + id + " ]";
    }
    
}
