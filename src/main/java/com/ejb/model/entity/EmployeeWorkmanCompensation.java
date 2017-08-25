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
@Table(name = "employee_workman_compensation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeWorkmanCompensation.findAll", query = "SELECT e FROM EmployeeWorkmanCompensation e")
    , @NamedQuery(name = "EmployeeWorkmanCompensation.findById", query = "SELECT e FROM EmployeeWorkmanCompensation e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeWorkmanCompensation.findByDays", query = "SELECT e FROM EmployeeWorkmanCompensation e WHERE e.days = :days")
    , @NamedQuery(name = "EmployeeWorkmanCompensation.findByYear", query = "SELECT e FROM EmployeeWorkmanCompensation e WHERE e.year = :year")})
public class EmployeeWorkmanCompensation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "days")
    private Double days;
    @Column(name = "year")
    private Integer year;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;

    public EmployeeWorkmanCompensation() {
    }

    public EmployeeWorkmanCompensation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getDays() {
        return days;
    }

    public void setDays(Double days) {
        this.days = days;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
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
        if (!(object instanceof EmployeeWorkmanCompensation)) {
            return false;
        }
        EmployeeWorkmanCompensation other = (EmployeeWorkmanCompensation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.EmployeeWorkmanCompensation[ id=" + id + " ]";
    }
    
}
