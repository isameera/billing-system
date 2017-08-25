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
@Table(name = "login_session")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoginSession.findAll", query = "SELECT l FROM LoginSession l")
    , @NamedQuery(name = "LoginSession.findById", query = "SELECT l FROM LoginSession l WHERE l.id = :id")
    , @NamedQuery(name = "LoginSession.findByIp", query = "SELECT l FROM LoginSession l WHERE l.ip = :ip")
    , @NamedQuery(name = "LoginSession.findByStartTime", query = "SELECT l FROM LoginSession l WHERE l.startTime = :startTime")
    , @NamedQuery(name = "LoginSession.findByEndTime", query = "SELECT l FROM LoginSession l WHERE l.endTime = :endTime")})
public class LoginSession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "ip")
    private String ip;
    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loginSessionId")
    private Collection<InactiveApprove> inactiveApproveCollection;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "user_login_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserLogin userLoginId;
    @JoinColumn(name = "user_login_group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserLoginGroup userLoginGroupId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loginSessionId")
    private Collection<Voucher> voucherCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loginSessionId")
    private Collection<GeneralJournalEntry> generalJournalEntryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loginSessionId")
    private Collection<VoucherItemInactive> voucherItemInactiveCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loginSessionId")
    private Collection<AttendenceSheet> attendenceSheetCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loginSessionId")
    private Collection<VoucherItem> voucherItemCollection;

    public LoginSession() {
    }

    public LoginSession(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

    @XmlTransient
    public Collection<InactiveApprove> getInactiveApproveCollection() {
        return inactiveApproveCollection;
    }

    public void setInactiveApproveCollection(Collection<InactiveApprove> inactiveApproveCollection) {
        this.inactiveApproveCollection = inactiveApproveCollection;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public UserLogin getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(UserLogin userLoginId) {
        this.userLoginId = userLoginId;
    }

    public UserLoginGroup getUserLoginGroupId() {
        return userLoginGroupId;
    }

    public void setUserLoginGroupId(UserLoginGroup userLoginGroupId) {
        this.userLoginGroupId = userLoginGroupId;
    }

    @XmlTransient
    public Collection<Voucher> getVoucherCollection() {
        return voucherCollection;
    }

    public void setVoucherCollection(Collection<Voucher> voucherCollection) {
        this.voucherCollection = voucherCollection;
    }

    @XmlTransient
    public Collection<GeneralJournalEntry> getGeneralJournalEntryCollection() {
        return generalJournalEntryCollection;
    }

    public void setGeneralJournalEntryCollection(Collection<GeneralJournalEntry> generalJournalEntryCollection) {
        this.generalJournalEntryCollection = generalJournalEntryCollection;
    }

    @XmlTransient
    public Collection<VoucherItemInactive> getVoucherItemInactiveCollection() {
        return voucherItemInactiveCollection;
    }

    public void setVoucherItemInactiveCollection(Collection<VoucherItemInactive> voucherItemInactiveCollection) {
        this.voucherItemInactiveCollection = voucherItemInactiveCollection;
    }

    @XmlTransient
    public Collection<AttendenceSheet> getAttendenceSheetCollection() {
        return attendenceSheetCollection;
    }

    public void setAttendenceSheetCollection(Collection<AttendenceSheet> attendenceSheetCollection) {
        this.attendenceSheetCollection = attendenceSheetCollection;
    }

    @XmlTransient
    public Collection<VoucherItem> getVoucherItemCollection() {
        return voucherItemCollection;
    }

    public void setVoucherItemCollection(Collection<VoucherItem> voucherItemCollection) {
        this.voucherItemCollection = voucherItemCollection;
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
        if (!(object instanceof LoginSession)) {
            return false;
        }
        LoginSession other = (LoginSession) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.LoginSession[ id=" + id + " ]";
    }
    
}
