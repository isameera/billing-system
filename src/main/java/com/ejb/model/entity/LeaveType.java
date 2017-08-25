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
@Table(name = "leave_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LeaveType.findAll", query = "SELECT l FROM LeaveType l")
    , @NamedQuery(name = "LeaveType.findById", query = "SELECT l FROM LeaveType l WHERE l.id = :id")
    , @NamedQuery(name = "LeaveType.findByName", query = "SELECT l FROM LeaveType l WHERE l.name = :name")
    , @NamedQuery(name = "LeaveType.findByStartTime", query = "SELECT l FROM LeaveType l WHERE l.startTime = :startTime")
    , @NamedQuery(name = "LeaveType.findByEndTime", query = "SELECT l FROM LeaveType l WHERE l.endTime = :endTime")
    , @NamedQuery(name = "LeaveType.findByNoOfLeavesAllowed", query = "SELECT l FROM LeaveType l WHERE l.noOfLeavesAllowed = :noOfLeavesAllowed")
    , @NamedQuery(name = "LeaveType.findByDeductionAmount", query = "SELECT l FROM LeaveType l WHERE l.deductionAmount = :deductionAmount")
    , @NamedQuery(name = "LeaveType.findByBonusAmount", query = "SELECT l FROM LeaveType l WHERE l.bonusAmount = :bonusAmount")})
public class LeaveType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "no_of_leaves_allowed")
    private Double noOfLeavesAllowed;
    @Column(name = "deduction_amount")
    private Double deductionAmount;
    @Column(name = "bonus_amount")
    private Double bonusAmount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaveTypeId")
    private Collection<AttendenceLeaveCounter> attendenceLeaveCounterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaveTypeId")
    private Collection<BalanceAnnualLeaveCounter> balanceAnnualLeaveCounterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaveTypeId")
    private Collection<LeaveRequestManager> leaveRequestManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaveTypeId")
    private Collection<LeaveCounter> leaveCounterCollection;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;

    public LeaveType() {
    }

    public LeaveType(Integer id) {
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getNoOfLeavesAllowed() {
        return noOfLeavesAllowed;
    }

    public void setNoOfLeavesAllowed(Double noOfLeavesAllowed) {
        this.noOfLeavesAllowed = noOfLeavesAllowed;
    }

    public Double getDeductionAmount() {
        return deductionAmount;
    }

    public void setDeductionAmount(Double deductionAmount) {
        this.deductionAmount = deductionAmount;
    }

    public Double getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(Double bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    @XmlTransient
    public Collection<AttendenceLeaveCounter> getAttendenceLeaveCounterCollection() {
        return attendenceLeaveCounterCollection;
    }

    public void setAttendenceLeaveCounterCollection(Collection<AttendenceLeaveCounter> attendenceLeaveCounterCollection) {
        this.attendenceLeaveCounterCollection = attendenceLeaveCounterCollection;
    }

    @XmlTransient
    public Collection<BalanceAnnualLeaveCounter> getBalanceAnnualLeaveCounterCollection() {
        return balanceAnnualLeaveCounterCollection;
    }

    public void setBalanceAnnualLeaveCounterCollection(Collection<BalanceAnnualLeaveCounter> balanceAnnualLeaveCounterCollection) {
        this.balanceAnnualLeaveCounterCollection = balanceAnnualLeaveCounterCollection;
    }

    @XmlTransient
    public Collection<LeaveRequestManager> getLeaveRequestManagerCollection() {
        return leaveRequestManagerCollection;
    }

    public void setLeaveRequestManagerCollection(Collection<LeaveRequestManager> leaveRequestManagerCollection) {
        this.leaveRequestManagerCollection = leaveRequestManagerCollection;
    }

    @XmlTransient
    public Collection<LeaveCounter> getLeaveCounterCollection() {
        return leaveCounterCollection;
    }

    public void setLeaveCounterCollection(Collection<LeaveCounter> leaveCounterCollection) {
        this.leaveCounterCollection = leaveCounterCollection;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
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
        if (!(object instanceof LeaveType)) {
            return false;
        }
        LeaveType other = (LeaveType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.LeaveType[ id=" + id + " ]";
    }
    
}
