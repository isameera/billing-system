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
@Table(name = "allowance_or_deduction_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AllowanceOrDeductionType.findAll", query = "SELECT a FROM AllowanceOrDeductionType a")
    , @NamedQuery(name = "AllowanceOrDeductionType.findById", query = "SELECT a FROM AllowanceOrDeductionType a WHERE a.id = :id")
    , @NamedQuery(name = "AllowanceOrDeductionType.findByName", query = "SELECT a FROM AllowanceOrDeductionType a WHERE a.name = :name")})
public class AllowanceOrDeductionType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salaryAllowanceOrDeductionsId")
    private Collection<EmployeeAllowanceManager> employeeAllowanceManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "allowanceOrDeductionTypeId")
    private Collection<AllowanceOrDeduction> allowanceOrDeductionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "allowanceOrDeductionTypeId")
    private Collection<EmployeeAllowanceDeductionHistoryManager> employeeAllowanceDeductionHistoryManagerCollection;

    public AllowanceOrDeductionType() {
    }

    public AllowanceOrDeductionType(Integer id) {
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
    public Collection<EmployeeAllowanceManager> getEmployeeAllowanceManagerCollection() {
        return employeeAllowanceManagerCollection;
    }

    public void setEmployeeAllowanceManagerCollection(Collection<EmployeeAllowanceManager> employeeAllowanceManagerCollection) {
        this.employeeAllowanceManagerCollection = employeeAllowanceManagerCollection;
    }

    @XmlTransient
    public Collection<AllowanceOrDeduction> getAllowanceOrDeductionCollection() {
        return allowanceOrDeductionCollection;
    }

    public void setAllowanceOrDeductionCollection(Collection<AllowanceOrDeduction> allowanceOrDeductionCollection) {
        this.allowanceOrDeductionCollection = allowanceOrDeductionCollection;
    }

    @XmlTransient
    public Collection<EmployeeAllowanceDeductionHistoryManager> getEmployeeAllowanceDeductionHistoryManagerCollection() {
        return employeeAllowanceDeductionHistoryManagerCollection;
    }

    public void setEmployeeAllowanceDeductionHistoryManagerCollection(Collection<EmployeeAllowanceDeductionHistoryManager> employeeAllowanceDeductionHistoryManagerCollection) {
        this.employeeAllowanceDeductionHistoryManagerCollection = employeeAllowanceDeductionHistoryManagerCollection;
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
        if (!(object instanceof AllowanceOrDeductionType)) {
            return false;
        }
        AllowanceOrDeductionType other = (AllowanceOrDeductionType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.AllowanceOrDeductionType[ id=" + id + " ]";
    }
    
}
