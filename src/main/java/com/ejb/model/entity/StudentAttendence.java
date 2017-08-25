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
@Table(name = "student_attendence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentAttendence.findAll", query = "SELECT s FROM StudentAttendence s")
    , @NamedQuery(name = "StudentAttendence.findById", query = "SELECT s FROM StudentAttendence s WHERE s.id = :id")
    , @NamedQuery(name = "StudentAttendence.findByIsPrecent", query = "SELECT s FROM StudentAttendence s WHERE s.isPrecent = :isPrecent")})
public class StudentAttendence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "is_precent")
    private Integer isPrecent;
    @JoinColumn(name = "attendence_sheet_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AttendenceSheet attendenceSheetId;

    public StudentAttendence() {
    }

    public StudentAttendence(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsPrecent() {
        return isPrecent;
    }

    public void setIsPrecent(Integer isPrecent) {
        this.isPrecent = isPrecent;
    }

    public AttendenceSheet getAttendenceSheetId() {
        return attendenceSheetId;
    }

    public void setAttendenceSheetId(AttendenceSheet attendenceSheetId) {
        this.attendenceSheetId = attendenceSheetId;
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
        if (!(object instanceof StudentAttendence)) {
            return false;
        }
        StudentAttendence other = (StudentAttendence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.StudentAttendence[ id=" + id + " ]";
    }
    
}
