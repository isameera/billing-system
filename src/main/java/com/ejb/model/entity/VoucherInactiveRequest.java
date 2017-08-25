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
import javax.persistence.Lob;
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
@Table(name = "voucher_inactive_request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VoucherInactiveRequest.findAll", query = "SELECT v FROM VoucherInactiveRequest v")
    , @NamedQuery(name = "VoucherInactiveRequest.findById", query = "SELECT v FROM VoucherInactiveRequest v WHERE v.id = :id")
    , @NamedQuery(name = "VoucherInactiveRequest.findByDate", query = "SELECT v FROM VoucherInactiveRequest v WHERE v.date = :date")
    , @NamedQuery(name = "VoucherInactiveRequest.findByTime", query = "SELECT v FROM VoucherInactiveRequest v WHERE v.time = :time")
    , @NamedQuery(name = "VoucherInactiveRequest.findByIpAddress", query = "SELECT v FROM VoucherInactiveRequest v WHERE v.ipAddress = :ipAddress")})
public class VoucherInactiveRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Size(max = 45)
    @Column(name = "ip_address")
    private String ipAddress;
    @Lob
    @Size(max = 16777215)
    @Column(name = "reason")
    private String reason;
    @JoinColumn(name = "requested_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee requestedBy;
    @JoinColumn(name = "voucher_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Voucher voucherId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherInactiveRequestId")
    private Collection<VoucherInactiveApprove> voucherInactiveApproveCollection;

    public VoucherInactiveRequest() {
    }

    public VoucherInactiveRequest(Integer id) {
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Employee getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(Employee requestedBy) {
        this.requestedBy = requestedBy;
    }

    public Voucher getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Voucher voucherId) {
        this.voucherId = voucherId;
    }

    @XmlTransient
    public Collection<VoucherInactiveApprove> getVoucherInactiveApproveCollection() {
        return voucherInactiveApproveCollection;
    }

    public void setVoucherInactiveApproveCollection(Collection<VoucherInactiveApprove> voucherInactiveApproveCollection) {
        this.voucherInactiveApproveCollection = voucherInactiveApproveCollection;
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
        if (!(object instanceof VoucherInactiveRequest)) {
            return false;
        }
        VoucherInactiveRequest other = (VoucherInactiveRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.VoucherInactiveRequest[ id=" + id + " ]";
    }
    
}
