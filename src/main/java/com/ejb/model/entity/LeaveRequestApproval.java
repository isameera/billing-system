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
@Table(name = "leave_request_approval")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LeaveRequestApproval.findAll", query = "SELECT l FROM LeaveRequestApproval l")
    , @NamedQuery(name = "LeaveRequestApproval.findById", query = "SELECT l FROM LeaveRequestApproval l WHERE l.id = :id")
    , @NamedQuery(name = "LeaveRequestApproval.findByDate", query = "SELECT l FROM LeaveRequestApproval l WHERE l.date = :date")})
public class LeaveRequestApproval implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "approved_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee approvedBy;
    @JoinColumn(name = "leave_request_approval_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LeaveRequestApprovalType leaveRequestApprovalTypeId;
    @JoinColumn(name = "leave_request_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LeaveRequestManager leaveRequestManagerId;

    public LeaveRequestApproval() {
    }

    public LeaveRequestApproval(Integer id) {
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

    public Employee getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Employee approvedBy) {
        this.approvedBy = approvedBy;
    }

    public LeaveRequestApprovalType getLeaveRequestApprovalTypeId() {
        return leaveRequestApprovalTypeId;
    }

    public void setLeaveRequestApprovalTypeId(LeaveRequestApprovalType leaveRequestApprovalTypeId) {
        this.leaveRequestApprovalTypeId = leaveRequestApprovalTypeId;
    }

    public LeaveRequestManager getLeaveRequestManagerId() {
        return leaveRequestManagerId;
    }

    public void setLeaveRequestManagerId(LeaveRequestManager leaveRequestManagerId) {
        this.leaveRequestManagerId = leaveRequestManagerId;
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
        if (!(object instanceof LeaveRequestApproval)) {
            return false;
        }
        LeaveRequestApproval other = (LeaveRequestApproval) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.LeaveRequestApproval[ id=" + id + " ]";
    }
    
}
