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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "voucher_item_inactive")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VoucherItemInactive.findAll", query = "SELECT v FROM VoucherItemInactive v")
    , @NamedQuery(name = "VoucherItemInactive.findById", query = "SELECT v FROM VoucherItemInactive v WHERE v.id = :id")
    , @NamedQuery(name = "VoucherItemInactive.findByDescription", query = "SELECT v FROM VoucherItemInactive v WHERE v.description = :description")
    , @NamedQuery(name = "VoucherItemInactive.findByIsApproved", query = "SELECT v FROM VoucherItemInactive v WHERE v.isApproved = :isApproved")
    , @NamedQuery(name = "VoucherItemInactive.findByRequestDate", query = "SELECT v FROM VoucherItemInactive v WHERE v.requestDate = :requestDate")})
public class VoucherItemInactive implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "is_approved")
    private Integer isApproved;
    @Basic(optional = false)
    @NotNull
    @Column(name = "request_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherItemInactiveId")
    private Collection<InactiveApprove> inactiveApproveCollection;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "login_session_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LoginSession loginSessionId;
    @JoinColumn(name = "voucher_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VoucherItem voucherItemId;

    public VoucherItemInactive() {
    }

    public VoucherItemInactive(Integer id) {
        this.id = id;
    }

    public VoucherItemInactive(Integer id, Date requestDate) {
        this.id = id;
        this.requestDate = requestDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Integer isApproved) {
        this.isApproved = isApproved;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
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

    public LoginSession getLoginSessionId() {
        return loginSessionId;
    }

    public void setLoginSessionId(LoginSession loginSessionId) {
        this.loginSessionId = loginSessionId;
    }

    public VoucherItem getVoucherItemId() {
        return voucherItemId;
    }

    public void setVoucherItemId(VoucherItem voucherItemId) {
        this.voucherItemId = voucherItemId;
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
        if (!(object instanceof VoucherItemInactive)) {
            return false;
        }
        VoucherItemInactive other = (VoucherItemInactive) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.VoucherItemInactive[ id=" + id + " ]";
    }
    
}
