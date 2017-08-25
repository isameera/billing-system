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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "employee_payment_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeePaymentDetails.findAll", query = "SELECT e FROM EmployeePaymentDetails e")
    , @NamedQuery(name = "EmployeePaymentDetails.findById", query = "SELECT e FROM EmployeePaymentDetails e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeePaymentDetails.findByFixRate", query = "SELECT e FROM EmployeePaymentDetails e WHERE e.fixRate = :fixRate")
    , @NamedQuery(name = "EmployeePaymentDetails.findByPriorityOrder", query = "SELECT e FROM EmployeePaymentDetails e WHERE e.priorityOrder = :priorityOrder")})
public class EmployeePaymentDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fix_rate")
    private Double fixRate;
    @Column(name = "priority_order")
    private Integer priorityOrder;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeePaymentDetailsId")
    private Collection<EmployeeBankAccount> employeeBankAccountCollection;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "universal_payment_mode_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalPaymentMode universalPaymentModeId;

    public EmployeePaymentDetails() {
    }

    public EmployeePaymentDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getFixRate() {
        return fixRate;
    }

    public void setFixRate(Double fixRate) {
        this.fixRate = fixRate;
    }

    public Integer getPriorityOrder() {
        return priorityOrder;
    }

    public void setPriorityOrder(Integer priorityOrder) {
        this.priorityOrder = priorityOrder;
    }

    @XmlTransient
    public Collection<EmployeeBankAccount> getEmployeeBankAccountCollection() {
        return employeeBankAccountCollection;
    }

    public void setEmployeeBankAccountCollection(Collection<EmployeeBankAccount> employeeBankAccountCollection) {
        this.employeeBankAccountCollection = employeeBankAccountCollection;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public UniversalPaymentMode getUniversalPaymentModeId() {
        return universalPaymentModeId;
    }

    public void setUniversalPaymentModeId(UniversalPaymentMode universalPaymentModeId) {
        this.universalPaymentModeId = universalPaymentModeId;
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
        if (!(object instanceof EmployeePaymentDetails)) {
            return false;
        }
        EmployeePaymentDetails other = (EmployeePaymentDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.EmployeePaymentDetails[ id=" + id + " ]";
    }
    
}
