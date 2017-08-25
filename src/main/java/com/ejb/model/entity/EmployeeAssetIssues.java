/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "employee_asset_issues")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeAssetIssues.findAll", query = "SELECT e FROM EmployeeAssetIssues e")
    , @NamedQuery(name = "EmployeeAssetIssues.findById", query = "SELECT e FROM EmployeeAssetIssues e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeAssetIssues.findByDate", query = "SELECT e FROM EmployeeAssetIssues e WHERE e.date = :date")
    , @NamedQuery(name = "EmployeeAssetIssues.findByItemDetails", query = "SELECT e FROM EmployeeAssetIssues e WHERE e.itemDetails = :itemDetails")
    , @NamedQuery(name = "EmployeeAssetIssues.findByIsReturned", query = "SELECT e FROM EmployeeAssetIssues e WHERE e.isReturned = :isReturned")})
public class EmployeeAssetIssues implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 450)
    @Column(name = "item_details")
    private String itemDetails;
    @Column(name = "is_returned")
    private Integer isReturned;
    @JoinColumn(name = "employee_asset_issues_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EmployeeAssetIssuesType employeeAssetIssuesTypeId;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeAssetIssuesId")
    private Collection<EmployeeAssetReturn> employeeAssetReturnCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeAssetIssuesId")
    private Collection<VatEarController> vatEarControllerCollection;

    public EmployeeAssetIssues() {
    }

    public EmployeeAssetIssues(Integer id) {
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

    public String getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(String itemDetails) {
        this.itemDetails = itemDetails;
    }

    public Integer getIsReturned() {
        return isReturned;
    }

    public void setIsReturned(Integer isReturned) {
        this.isReturned = isReturned;
    }

    public EmployeeAssetIssuesType getEmployeeAssetIssuesTypeId() {
        return employeeAssetIssuesTypeId;
    }

    public void setEmployeeAssetIssuesTypeId(EmployeeAssetIssuesType employeeAssetIssuesTypeId) {
        this.employeeAssetIssuesTypeId = employeeAssetIssuesTypeId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    @XmlTransient
    public Collection<EmployeeAssetReturn> getEmployeeAssetReturnCollection() {
        return employeeAssetReturnCollection;
    }

    public void setEmployeeAssetReturnCollection(Collection<EmployeeAssetReturn> employeeAssetReturnCollection) {
        this.employeeAssetReturnCollection = employeeAssetReturnCollection;
    }

    @XmlTransient
    public Collection<VatEarController> getVatEarControllerCollection() {
        return vatEarControllerCollection;
    }

    public void setVatEarControllerCollection(Collection<VatEarController> vatEarControllerCollection) {
        this.vatEarControllerCollection = vatEarControllerCollection;
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
        if (!(object instanceof EmployeeAssetIssues)) {
            return false;
        }
        EmployeeAssetIssues other = (EmployeeAssetIssues) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.EmployeeAssetIssues[ id=" + id + " ]";
    }
    
}
