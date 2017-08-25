/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "employee_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeType.findAll", query = "SELECT e FROM EmployeeType e")
    , @NamedQuery(name = "EmployeeType.findById", query = "SELECT e FROM EmployeeType e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeType.findByName", query = "SELECT e FROM EmployeeType e WHERE e.name = :name")})
public class EmployeeType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeTypeId")
    private Collection<EmployeeTypeDeductionRate> employeeTypeDeductionRateCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeTypeId")
    private Collection<EmployeePosisionManager> employeePosisionManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeTypeId")
    private Collection<OrgEmployeeType> orgEmployeeTypeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeTypeId")
    private Collection<EmployeeTypeManager> employeeTypeManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeTypeId")
    private Collection<Employee> employeeCollection;

    public EmployeeType() {
    }

    public EmployeeType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<EmployeeTypeDeductionRate> getEmployeeTypeDeductionRateCollection() {
        return employeeTypeDeductionRateCollection;
    }

    public void setEmployeeTypeDeductionRateCollection(Collection<EmployeeTypeDeductionRate> employeeTypeDeductionRateCollection) {
        this.employeeTypeDeductionRateCollection = employeeTypeDeductionRateCollection;
    }

    @XmlTransient
    public Collection<EmployeePosisionManager> getEmployeePosisionManagerCollection() {
        return employeePosisionManagerCollection;
    }

    public void setEmployeePosisionManagerCollection(Collection<EmployeePosisionManager> employeePosisionManagerCollection) {
        this.employeePosisionManagerCollection = employeePosisionManagerCollection;
    }

    @XmlTransient
    public Collection<OrgEmployeeType> getOrgEmployeeTypeCollection() {
        return orgEmployeeTypeCollection;
    }

    public void setOrgEmployeeTypeCollection(Collection<OrgEmployeeType> orgEmployeeTypeCollection) {
        this.orgEmployeeTypeCollection = orgEmployeeTypeCollection;
    }

    @XmlTransient
    public Collection<EmployeeTypeManager> getEmployeeTypeManagerCollection() {
        return employeeTypeManagerCollection;
    }

    public void setEmployeeTypeManagerCollection(Collection<EmployeeTypeManager> employeeTypeManagerCollection) {
        this.employeeTypeManagerCollection = employeeTypeManagerCollection;
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
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
        if (!(object instanceof EmployeeType)) {
            return false;
        }
        EmployeeType other = (EmployeeType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.EmployeeType[ id=" + id + " ]";
    }
    
}
