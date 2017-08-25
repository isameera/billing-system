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
@Table(name = "universal_boughtleaf_item_approval")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniversalBoughtleafItemApproval.findAll", query = "SELECT u FROM UniversalBoughtleafItemApproval u")
    , @NamedQuery(name = "UniversalBoughtleafItemApproval.findById", query = "SELECT u FROM UniversalBoughtleafItemApproval u WHERE u.id = :id")
    , @NamedQuery(name = "UniversalBoughtleafItemApproval.findByApprovedDate", query = "SELECT u FROM UniversalBoughtleafItemApproval u WHERE u.approvedDate = :approvedDate")})
public class UniversalBoughtleafItemApproval implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "approved_date")
    @Temporal(TemporalType.DATE)
    private Date approvedDate;
    @JoinColumn(name = "universal_boughtleaf_item_request_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalBoughtleafItemRequest universalBoughtleafItemRequestId;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;

    public UniversalBoughtleafItemApproval() {
    }

    public UniversalBoughtleafItemApproval(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public UniversalBoughtleafItemRequest getUniversalBoughtleafItemRequestId() {
        return universalBoughtleafItemRequestId;
    }

    public void setUniversalBoughtleafItemRequestId(UniversalBoughtleafItemRequest universalBoughtleafItemRequestId) {
        this.universalBoughtleafItemRequestId = universalBoughtleafItemRequestId;
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
        if (!(object instanceof UniversalBoughtleafItemApproval)) {
            return false;
        }
        UniversalBoughtleafItemApproval other = (UniversalBoughtleafItemApproval) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UniversalBoughtleafItemApproval[ id=" + id + " ]";
    }
    
}
