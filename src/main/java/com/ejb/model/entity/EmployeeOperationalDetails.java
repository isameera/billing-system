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
@Table(name = "employee_operational _details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeOperationalDetails.findAll", query = "SELECT e FROM EmployeeOperationalDetails e")
    , @NamedQuery(name = "EmployeeOperationalDetails.findById", query = "SELECT e FROM EmployeeOperationalDetails e WHERE e.id = :id")})
public class EmployeeOperationalDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "employees_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeesId;
    @JoinColumn(name = "operational_details_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OperationalDetails operationalDetailsId;

    public EmployeeOperationalDetails() {
    }

    public EmployeeOperationalDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(Employee employeesId) {
        this.employeesId = employeesId;
    }

    public OperationalDetails getOperationalDetailsId() {
        return operationalDetailsId;
    }

    public void setOperationalDetailsId(OperationalDetails operationalDetailsId) {
        this.operationalDetailsId = operationalDetailsId;
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
        if (!(object instanceof EmployeeOperationalDetails)) {
            return false;
        }
        EmployeeOperationalDetails other = (EmployeeOperationalDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.EmployeeOperationalDetails[ id=" + id + " ]";
    }
    
}
