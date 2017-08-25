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
@Table(name = "leave_request_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LeaveRequestManager.findAll", query = "SELECT l FROM LeaveRequestManager l")
    , @NamedQuery(name = "LeaveRequestManager.findById", query = "SELECT l FROM LeaveRequestManager l WHERE l.id = :id")
    , @NamedQuery(name = "LeaveRequestManager.findByRequestedDate", query = "SELECT l FROM LeaveRequestManager l WHERE l.requestedDate = :requestedDate")
    , @NamedQuery(name = "LeaveRequestManager.findByApproveRejectDate", query = "SELECT l FROM LeaveRequestManager l WHERE l.approveRejectDate = :approveRejectDate")
    , @NamedQuery(name = "LeaveRequestManager.findByDateFrom", query = "SELECT l FROM LeaveRequestManager l WHERE l.dateFrom = :dateFrom")
    , @NamedQuery(name = "LeaveRequestManager.findByDateTo", query = "SELECT l FROM LeaveRequestManager l WHERE l.dateTo = :dateTo")
    , @NamedQuery(name = "LeaveRequestManager.findByTimeFrom", query = "SELECT l FROM LeaveRequestManager l WHERE l.timeFrom = :timeFrom")
    , @NamedQuery(name = "LeaveRequestManager.findByTimeTo", query = "SELECT l FROM LeaveRequestManager l WHERE l.timeTo = :timeTo")
    , @NamedQuery(name = "LeaveRequestManager.findByReason", query = "SELECT l FROM LeaveRequestManager l WHERE l.reason = :reason")
    , @NamedQuery(name = "LeaveRequestManager.findByIsTakenLeave", query = "SELECT l FROM LeaveRequestManager l WHERE l.isTakenLeave = :isTakenLeave")})
public class LeaveRequestManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "requested_date")
    @Temporal(TemporalType.DATE)
    private Date requestedDate;
    @Column(name = "approve_reject_date")
    @Temporal(TemporalType.DATE)
    private Date approveRejectDate;
    @Column(name = "date_from")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Column(name = "date_to")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    @Column(name = "time_from")
    @Temporal(TemporalType.TIME)
    private Date timeFrom;
    @Column(name = "time_to")
    @Temporal(TemporalType.TIME)
    private Date timeTo;
    @Size(max = 750)
    @Column(name = "reason")
    private String reason;
    @Column(name = "is_taken_leave")
    private Integer isTakenLeave;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaveRequestManagerId")
    private Collection<LeaveRequestApproval> leaveRequestApprovalCollection;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "universal_approval_status_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalApprovalStatusManager universalApprovalStatusManagerId;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne
    private Employee employeeId;
    @JoinColumn(name = "leave_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LeaveType leaveTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaveRequestManagerId")
    private Collection<LeaveCoveredBy> leaveCoveredByCollection;

    public LeaveRequestManager() {
    }

    public LeaveRequestManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public Date getApproveRejectDate() {
        return approveRejectDate;
    }

    public void setApproveRejectDate(Date approveRejectDate) {
        this.approveRejectDate = approveRejectDate;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Date getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Date timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Date getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Date timeTo) {
        this.timeTo = timeTo;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getIsTakenLeave() {
        return isTakenLeave;
    }

    public void setIsTakenLeave(Integer isTakenLeave) {
        this.isTakenLeave = isTakenLeave;
    }

    @XmlTransient
    public Collection<LeaveRequestApproval> getLeaveRequestApprovalCollection() {
        return leaveRequestApprovalCollection;
    }

    public void setLeaveRequestApprovalCollection(Collection<LeaveRequestApproval> leaveRequestApprovalCollection) {
        this.leaveRequestApprovalCollection = leaveRequestApprovalCollection;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
    }

    public UniversalApprovalStatusManager getUniversalApprovalStatusManagerId() {
        return universalApprovalStatusManagerId;
    }

    public void setUniversalApprovalStatusManagerId(UniversalApprovalStatusManager universalApprovalStatusManagerId) {
        this.universalApprovalStatusManagerId = universalApprovalStatusManagerId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public LeaveType getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(LeaveType leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    @XmlTransient
    public Collection<LeaveCoveredBy> getLeaveCoveredByCollection() {
        return leaveCoveredByCollection;
    }

    public void setLeaveCoveredByCollection(Collection<LeaveCoveredBy> leaveCoveredByCollection) {
        this.leaveCoveredByCollection = leaveCoveredByCollection;
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
        if (!(object instanceof LeaveRequestManager)) {
            return false;
        }
        LeaveRequestManager other = (LeaveRequestManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.LeaveRequestManager[ id=" + id + " ]";
    }
    
}
