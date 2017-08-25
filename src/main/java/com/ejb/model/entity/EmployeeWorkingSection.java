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
@Table(name = "employee_working_section")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeWorkingSection.findAll", query = "SELECT e FROM EmployeeWorkingSection e")
    , @NamedQuery(name = "EmployeeWorkingSection.findById", query = "SELECT e FROM EmployeeWorkingSection e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeWorkingSection.findByIsCurrent", query = "SELECT e FROM EmployeeWorkingSection e WHERE e.isCurrent = :isCurrent")})
public class EmployeeWorkingSection implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "is_current")
    private Integer isCurrent;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "working_section_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private WorkingSection workingSectionId;

    public EmployeeWorkingSection() {
    }

    public EmployeeWorkingSection(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(Integer isCurrent) {
        this.isCurrent = isCurrent;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public WorkingSection getWorkingSectionId() {
        return workingSectionId;
    }

    public void setWorkingSectionId(WorkingSection workingSectionId) {
        this.workingSectionId = workingSectionId;
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
        if (!(object instanceof EmployeeWorkingSection)) {
            return false;
        }
        EmployeeWorkingSection other = (EmployeeWorkingSection) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.EmployeeWorkingSection[ id=" + id + " ]";
    }
    
}
