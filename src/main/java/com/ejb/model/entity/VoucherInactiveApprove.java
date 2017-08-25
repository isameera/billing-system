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
@Table(name = "voucher_inactive_approve")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VoucherInactiveApprove.findAll", query = "SELECT v FROM VoucherInactiveApprove v")
    , @NamedQuery(name = "VoucherInactiveApprove.findById", query = "SELECT v FROM VoucherInactiveApprove v WHERE v.id = :id")
    , @NamedQuery(name = "VoucherInactiveApprove.findByDate", query = "SELECT v FROM VoucherInactiveApprove v WHERE v.date = :date")
    , @NamedQuery(name = "VoucherInactiveApprove.findByTime", query = "SELECT v FROM VoucherInactiveApprove v WHERE v.time = :time")
    , @NamedQuery(name = "VoucherInactiveApprove.findByIpAddress", query = "SELECT v FROM VoucherInactiveApprove v WHERE v.ipAddress = :ipAddress")})
public class VoucherInactiveApprove implements Serializable {

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
    @JoinColumn(name = "approved_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee approvedBy;
    @JoinColumn(name = "voucher_inactive_request_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VoucherInactiveRequest voucherInactiveRequestId;

    public VoucherInactiveApprove() {
    }

    public VoucherInactiveApprove(Integer id) {
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

    public Employee getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Employee approvedBy) {
        this.approvedBy = approvedBy;
    }

    public VoucherInactiveRequest getVoucherInactiveRequestId() {
        return voucherInactiveRequestId;
    }

    public void setVoucherInactiveRequestId(VoucherInactiveRequest voucherInactiveRequestId) {
        this.voucherInactiveRequestId = voucherInactiveRequestId;
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
        if (!(object instanceof VoucherInactiveApprove)) {
            return false;
        }
        VoucherInactiveApprove other = (VoucherInactiveApprove) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.VoucherInactiveApprove[ id=" + id + " ]";
    }
    
}
