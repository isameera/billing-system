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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "employee_contract_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeContractDetails.findAll", query = "SELECT e FROM EmployeeContractDetails e")
    , @NamedQuery(name = "EmployeeContractDetails.findById", query = "SELECT e FROM EmployeeContractDetails e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeContractDetails.findByPeriod", query = "SELECT e FROM EmployeeContractDetails e WHERE e.period = :period")
    , @NamedQuery(name = "EmployeeContractDetails.findByDateFrom", query = "SELECT e FROM EmployeeContractDetails e WHERE e.dateFrom = :dateFrom")
    , @NamedQuery(name = "EmployeeContractDetails.findByDateTo", query = "SELECT e FROM EmployeeContractDetails e WHERE e.dateTo = :dateTo")})
public class EmployeeContractDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "period")
    private Integer period;
    @Size(max = 45)
    @Column(name = "date_from")
    private String dateFrom;
    @Size(max = 45)
    @Column(name = "date_to")
    private String dateTo;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;

    public EmployeeContractDetails() {
    }

    public EmployeeContractDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
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
        if (!(object instanceof EmployeeContractDetails)) {
            return false;
        }
        EmployeeContractDetails other = (EmployeeContractDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.EmployeeContractDetails[ id=" + id + " ]";
    }
    
}
