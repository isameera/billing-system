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
@Table(name = "employee_asset_return")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeAssetReturn.findAll", query = "SELECT e FROM EmployeeAssetReturn e")
    , @NamedQuery(name = "EmployeeAssetReturn.findById", query = "SELECT e FROM EmployeeAssetReturn e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeAssetReturn.findByDate", query = "SELECT e FROM EmployeeAssetReturn e WHERE e.date = :date")})
public class EmployeeAssetReturn implements Serializable {

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
    @JoinColumn(name = "employee_asset_issues_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EmployeeAssetIssues employeeAssetIssuesId;

    public EmployeeAssetReturn() {
    }

    public EmployeeAssetReturn(Integer id) {
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

    public EmployeeAssetIssues getEmployeeAssetIssuesId() {
        return employeeAssetIssuesId;
    }

    public void setEmployeeAssetIssuesId(EmployeeAssetIssues employeeAssetIssuesId) {
        this.employeeAssetIssuesId = employeeAssetIssuesId;
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
        if (!(object instanceof EmployeeAssetReturn)) {
            return false;
        }
        EmployeeAssetReturn other = (EmployeeAssetReturn) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.EmployeeAssetReturn[ id=" + id + " ]";
    }
    
}
