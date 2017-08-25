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
@Table(name = "leave_counter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LeaveCounter.findAll", query = "SELECT l FROM LeaveCounter l")
    , @NamedQuery(name = "LeaveCounter.findById", query = "SELECT l FROM LeaveCounter l WHERE l.id = :id")
    , @NamedQuery(name = "LeaveCounter.findByCount", query = "SELECT l FROM LeaveCounter l WHERE l.count = :count")})
public class LeaveCounter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "count")
    private Integer count;
    @JoinColumn(name = "employee_monthly_salary_history_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EmployeeMonthlySalaryHistory employeeMonthlySalaryHistoryId;
    @JoinColumn(name = "leave_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LeaveType leaveTypeId;

    public LeaveCounter() {
    }

    public LeaveCounter(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public EmployeeMonthlySalaryHistory getEmployeeMonthlySalaryHistoryId() {
        return employeeMonthlySalaryHistoryId;
    }

    public void setEmployeeMonthlySalaryHistoryId(EmployeeMonthlySalaryHistory employeeMonthlySalaryHistoryId) {
        this.employeeMonthlySalaryHistoryId = employeeMonthlySalaryHistoryId;
    }

    public LeaveType getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(LeaveType leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
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
        if (!(object instanceof LeaveCounter)) {
            return false;
        }
        LeaveCounter other = (LeaveCounter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.LeaveCounter[ id=" + id + " ]";
    }
    
}
