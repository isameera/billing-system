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
@Table(name = "universal_boughtleaf_item_request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniversalBoughtleafItemRequest.findAll", query = "SELECT u FROM UniversalBoughtleafItemRequest u")
    , @NamedQuery(name = "UniversalBoughtleafItemRequest.findById", query = "SELECT u FROM UniversalBoughtleafItemRequest u WHERE u.id = :id")
    , @NamedQuery(name = "UniversalBoughtleafItemRequest.findByVoucherId", query = "SELECT u FROM UniversalBoughtleafItemRequest u WHERE u.voucherId = :voucherId")
    , @NamedQuery(name = "UniversalBoughtleafItemRequest.findByRequestedDate", query = "SELECT u FROM UniversalBoughtleafItemRequest u WHERE u.requestedDate = :requestedDate")
    , @NamedQuery(name = "UniversalBoughtleafItemRequest.findByIsCompleted", query = "SELECT u FROM UniversalBoughtleafItemRequest u WHERE u.isCompleted = :isCompleted")})
public class UniversalBoughtleafItemRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "voucher_id")
    private String voucherId;
    @Column(name = "requested_date")
    @Temporal(TemporalType.DATE)
    private Date requestedDate;
    @Column(name = "is_completed")
    private Integer isCompleted;
    @JoinColumn(name = "universal_boughtleaf_item_requested_by_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalBoughtleafItemRequestedBy universalBoughtleafItemRequestedById;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Route routeId;
    @JoinColumn(name = "universal_approval_status_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalApprovalStatusManager universalApprovalStatusManagerId;
    @JoinColumn(name = "universal_qty_item_type_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalQtyItemTypeManager universalQtyItemTypeManagerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalBoughtleafItemRequestId")
    private Collection<UniversalBoughtleafItemApproval> universalBoughtleafItemApprovalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalBoughtleafItemRequestId")
    private Collection<GatePassItem> gatePassItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalBoughtleafItemRequestId")
    private Collection<UniversalBoughtleafItemRequestedItem> universalBoughtleafItemRequestedItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalBoughtleafItemRequestId")
    private Collection<UniversalBoughtleafItemRequestVoucher> universalBoughtleafItemRequestVoucherCollection;

    public UniversalBoughtleafItemRequest() {
    }

    public UniversalBoughtleafItemRequest(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(String voucherId) {
        this.voucherId = voucherId;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public Integer getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Integer isCompleted) {
        this.isCompleted = isCompleted;
    }

    public UniversalBoughtleafItemRequestedBy getUniversalBoughtleafItemRequestedById() {
        return universalBoughtleafItemRequestedById;
    }

    public void setUniversalBoughtleafItemRequestedById(UniversalBoughtleafItemRequestedBy universalBoughtleafItemRequestedById) {
        this.universalBoughtleafItemRequestedById = universalBoughtleafItemRequestedById;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    public UniversalApprovalStatusManager getUniversalApprovalStatusManagerId() {
        return universalApprovalStatusManagerId;
    }

    public void setUniversalApprovalStatusManagerId(UniversalApprovalStatusManager universalApprovalStatusManagerId) {
        this.universalApprovalStatusManagerId = universalApprovalStatusManagerId;
    }

    public UniversalQtyItemTypeManager getUniversalQtyItemTypeManagerId() {
        return universalQtyItemTypeManagerId;
    }

    public void setUniversalQtyItemTypeManagerId(UniversalQtyItemTypeManager universalQtyItemTypeManagerId) {
        this.universalQtyItemTypeManagerId = universalQtyItemTypeManagerId;
    }

    @XmlTransient
    public Collection<UniversalBoughtleafItemApproval> getUniversalBoughtleafItemApprovalCollection() {
        return universalBoughtleafItemApprovalCollection;
    }

    public void setUniversalBoughtleafItemApprovalCollection(Collection<UniversalBoughtleafItemApproval> universalBoughtleafItemApprovalCollection) {
        this.universalBoughtleafItemApprovalCollection = universalBoughtleafItemApprovalCollection;
    }

    @XmlTransient
    public Collection<GatePassItem> getGatePassItemCollection() {
        return gatePassItemCollection;
    }

    public void setGatePassItemCollection(Collection<GatePassItem> gatePassItemCollection) {
        this.gatePassItemCollection = gatePassItemCollection;
    }

    @XmlTransient
    public Collection<UniversalBoughtleafItemRequestedItem> getUniversalBoughtleafItemRequestedItemCollection() {
        return universalBoughtleafItemRequestedItemCollection;
    }

    public void setUniversalBoughtleafItemRequestedItemCollection(Collection<UniversalBoughtleafItemRequestedItem> universalBoughtleafItemRequestedItemCollection) {
        this.universalBoughtleafItemRequestedItemCollection = universalBoughtleafItemRequestedItemCollection;
    }

    @XmlTransient
    public Collection<UniversalBoughtleafItemRequestVoucher> getUniversalBoughtleafItemRequestVoucherCollection() {
        return universalBoughtleafItemRequestVoucherCollection;
    }

    public void setUniversalBoughtleafItemRequestVoucherCollection(Collection<UniversalBoughtleafItemRequestVoucher> universalBoughtleafItemRequestVoucherCollection) {
        this.universalBoughtleafItemRequestVoucherCollection = universalBoughtleafItemRequestVoucherCollection;
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
        if (!(object instanceof UniversalBoughtleafItemRequest)) {
            return false;
        }
        UniversalBoughtleafItemRequest other = (UniversalBoughtleafItemRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UniversalBoughtleafItemRequest[ id=" + id + " ]";
    }
    
}
