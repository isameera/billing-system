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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "inactive_approve")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InactiveApprove.findAll", query = "SELECT i FROM InactiveApprove i")
    , @NamedQuery(name = "InactiveApprove.findByIaId", query = "SELECT i FROM InactiveApprove i WHERE i.iaId = :iaId")
    , @NamedQuery(name = "InactiveApprove.findByApproveDate", query = "SELECT i FROM InactiveApprove i WHERE i.approveDate = :approveDate")})
public class InactiveApprove implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ia_id")
    private Integer iaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "approve_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approveDate;
    @JoinColumn(name = "login_session_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LoginSession loginSessionId;
    @JoinColumn(name = "voucher_item_inactive_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VoucherItemInactive voucherItemInactiveId;

    public InactiveApprove() {
    }

    public InactiveApprove(Integer iaId) {
        this.iaId = iaId;
    }

    public InactiveApprove(Integer iaId, Date approveDate) {
        this.iaId = iaId;
        this.approveDate = approveDate;
    }

    public Integer getIaId() {
        return iaId;
    }

    public void setIaId(Integer iaId) {
        this.iaId = iaId;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public LoginSession getLoginSessionId() {
        return loginSessionId;
    }

    public void setLoginSessionId(LoginSession loginSessionId) {
        this.loginSessionId = loginSessionId;
    }

    public VoucherItemInactive getVoucherItemInactiveId() {
        return voucherItemInactiveId;
    }

    public void setVoucherItemInactiveId(VoucherItemInactive voucherItemInactiveId) {
        this.voucherItemInactiveId = voucherItemInactiveId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iaId != null ? iaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InactiveApprove)) {
            return false;
        }
        InactiveApprove other = (InactiveApprove) object;
        if ((this.iaId == null && other.iaId != null) || (this.iaId != null && !this.iaId.equals(other.iaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.InactiveApprove[ iaId=" + iaId + " ]";
    }
    
}
