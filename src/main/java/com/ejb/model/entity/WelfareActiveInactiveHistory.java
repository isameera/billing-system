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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "welfare_active_inactive_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WelfareActiveInactiveHistory.findAll", query = "SELECT w FROM WelfareActiveInactiveHistory w")
    , @NamedQuery(name = "WelfareActiveInactiveHistory.findById", query = "SELECT w FROM WelfareActiveInactiveHistory w WHERE w.id = :id")
    , @NamedQuery(name = "WelfareActiveInactiveHistory.findByDate", query = "SELECT w FROM WelfareActiveInactiveHistory w WHERE w.date = :date")})
public class WelfareActiveInactiveHistory implements Serializable {

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
    @JoinColumn(name = "welfare_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private WelfareManager welfareManagerId;
    @JoinColumn(name = "welfare_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private WelfareStatus welfareStatusId;

    public WelfareActiveInactiveHistory() {
    }

    public WelfareActiveInactiveHistory(Integer id) {
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

    public WelfareManager getWelfareManagerId() {
        return welfareManagerId;
    }

    public void setWelfareManagerId(WelfareManager welfareManagerId) {
        this.welfareManagerId = welfareManagerId;
    }

    public WelfareStatus getWelfareStatusId() {
        return welfareStatusId;
    }

    public void setWelfareStatusId(WelfareStatus welfareStatusId) {
        this.welfareStatusId = welfareStatusId;
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
        if (!(object instanceof WelfareActiveInactiveHistory)) {
            return false;
        }
        WelfareActiveInactiveHistory other = (WelfareActiveInactiveHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.WelfareActiveInactiveHistory[ id=" + id + " ]";
    }
    
}
