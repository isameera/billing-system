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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "loan_transfer_for_approval")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoanTransferForApproval.findAll", query = "SELECT l FROM LoanTransferForApproval l")
    , @NamedQuery(name = "LoanTransferForApproval.findById", query = "SELECT l FROM LoanTransferForApproval l WHERE l.id = :id")
    , @NamedQuery(name = "LoanTransferForApproval.findByDate", query = "SELECT l FROM LoanTransferForApproval l WHERE l.date = :date")
    , @NamedQuery(name = "LoanTransferForApproval.findByDescription", query = "SELECT l FROM LoanTransferForApproval l WHERE l.description = :description")})
public class LoanTransferForApproval implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 1000)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "loan_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LoanMaster loanMasterId;
    @JoinColumn(name = "user_role_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserRole userRoleId;

    public LoanTransferForApproval() {
    }

    public LoanTransferForApproval(Integer id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public LoanMaster getLoanMasterId() {
        return loanMasterId;
    }

    public void setLoanMasterId(LoanMaster loanMasterId) {
        this.loanMasterId = loanMasterId;
    }

    public UserRole getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(UserRole userRoleId) {
        this.userRoleId = userRoleId;
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
        if (!(object instanceof LoanTransferForApproval)) {
            return false;
        }
        LoanTransferForApproval other = (LoanTransferForApproval) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.LoanTransferForApproval[ id=" + id + " ]";
    }
    
}
