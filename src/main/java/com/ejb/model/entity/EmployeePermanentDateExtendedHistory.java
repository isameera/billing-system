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
@Table(name = "employee_permanent_date_extended_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeePermanentDateExtendedHistory.findAll", query = "SELECT e FROM EmployeePermanentDateExtendedHistory e")
    , @NamedQuery(name = "EmployeePermanentDateExtendedHistory.findById", query = "SELECT e FROM EmployeePermanentDateExtendedHistory e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeePermanentDateExtendedHistory.findByDateOfChanged", query = "SELECT e FROM EmployeePermanentDateExtendedHistory e WHERE e.dateOfChanged = :dateOfChanged")
    , @NamedQuery(name = "EmployeePermanentDateExtendedHistory.findByNextPermanentDate", query = "SELECT e FROM EmployeePermanentDateExtendedHistory e WHERE e.nextPermanentDate = :nextPermanentDate")})
public class EmployeePermanentDateExtendedHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date_of_changed")
    @Temporal(TemporalType.DATE)
    private Date dateOfChanged;
    @Column(name = "next_permanent_date")
    @Temporal(TemporalType.DATE)
    private Date nextPermanentDate;
    @JoinColumn(name = "extended_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee extendedBy;
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employee;

    public EmployeePermanentDateExtendedHistory() {
    }

    public EmployeePermanentDateExtendedHistory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateOfChanged() {
        return dateOfChanged;
    }

    public void setDateOfChanged(Date dateOfChanged) {
        this.dateOfChanged = dateOfChanged;
    }

    public Date getNextPermanentDate() {
        return nextPermanentDate;
    }

    public void setNextPermanentDate(Date nextPermanentDate) {
        this.nextPermanentDate = nextPermanentDate;
    }

    public Employee getExtendedBy() {
        return extendedBy;
    }

    public void setExtendedBy(Employee extendedBy) {
        this.extendedBy = extendedBy;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        if (!(object instanceof EmployeePermanentDateExtendedHistory)) {
            return false;
        }
        EmployeePermanentDateExtendedHistory other = (EmployeePermanentDateExtendedHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.EmployeePermanentDateExtendedHistory[ id=" + id + " ]";
    }
    
}
