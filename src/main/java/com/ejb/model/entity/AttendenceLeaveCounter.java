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
@Table(name = "attendence_leave_counter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AttendenceLeaveCounter.findAll", query = "SELECT a FROM AttendenceLeaveCounter a")
    , @NamedQuery(name = "AttendenceLeaveCounter.findById", query = "SELECT a FROM AttendenceLeaveCounter a WHERE a.id = :id")})
public class AttendenceLeaveCounter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "leave_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LeaveType leaveTypeId;
    @JoinColumn(name = "atendence_registry_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AtendenceRegistry atendenceRegistryId;

    public AttendenceLeaveCounter() {
    }

    public AttendenceLeaveCounter(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LeaveType getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(LeaveType leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public AtendenceRegistry getAtendenceRegistryId() {
        return atendenceRegistryId;
    }

    public void setAtendenceRegistryId(AtendenceRegistry atendenceRegistryId) {
        this.atendenceRegistryId = atendenceRegistryId;
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
        if (!(object instanceof AttendenceLeaveCounter)) {
            return false;
        }
        AttendenceLeaveCounter other = (AttendenceLeaveCounter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.AttendenceLeaveCounter[ id=" + id + " ]";
    }
    
}
