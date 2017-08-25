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
@Table(name = "work_shift_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkShiftManager.findAll", query = "SELECT w FROM WorkShiftManager w")
    , @NamedQuery(name = "WorkShiftManager.findById", query = "SELECT w FROM WorkShiftManager w WHERE w.id = :id")
    , @NamedQuery(name = "WorkShiftManager.findByDate", query = "SELECT w FROM WorkShiftManager w WHERE w.date = :date")})
public class WorkShiftManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "work_shift_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private WorkShift workShiftId;
    @JoinColumn(name = "working_section_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private WorkingSection workingSectionId;
    @OneToMany(mappedBy = "workShiftManagerId")
    private Collection<AtendenceRegistry> atendenceRegistryCollection;

    public WorkShiftManager() {
    }

    public WorkShiftManager(Integer id) {
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

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public WorkShift getWorkShiftId() {
        return workShiftId;
    }

    public void setWorkShiftId(WorkShift workShiftId) {
        this.workShiftId = workShiftId;
    }

    public WorkingSection getWorkingSectionId() {
        return workingSectionId;
    }

    public void setWorkingSectionId(WorkingSection workingSectionId) {
        this.workingSectionId = workingSectionId;
    }

    @XmlTransient
    public Collection<AtendenceRegistry> getAtendenceRegistryCollection() {
        return atendenceRegistryCollection;
    }

    public void setAtendenceRegistryCollection(Collection<AtendenceRegistry> atendenceRegistryCollection) {
        this.atendenceRegistryCollection = atendenceRegistryCollection;
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
        if (!(object instanceof WorkShiftManager)) {
            return false;
        }
        WorkShiftManager other = (WorkShiftManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.WorkShiftManager[ id=" + id + " ]";
    }
    
}
