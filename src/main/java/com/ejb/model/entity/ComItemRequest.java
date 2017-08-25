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
@Table(name = "com_item_request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComItemRequest.findAll", query = "SELECT c FROM ComItemRequest c")
    , @NamedQuery(name = "ComItemRequest.findById", query = "SELECT c FROM ComItemRequest c WHERE c.id = :id")
    , @NamedQuery(name = "ComItemRequest.findByDate", query = "SELECT c FROM ComItemRequest c WHERE c.date = :date")
    , @NamedQuery(name = "ComItemRequest.findByIsCompleted", query = "SELECT c FROM ComItemRequest c WHERE c.isCompleted = :isCompleted")})
public class ComItemRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "is_completed")
    private Boolean isCompleted;
    @Lob
    @Size(max = 65535)
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "com_item_requested_by_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ComItemRequestedBy comItemRequestedById;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "site_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile siteId;
    @JoinColumn(name = "requested_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile requestedBy;
    @JoinColumn(name = "item_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemCategory itemCategoryId;
    @JoinColumn(name = "universal_approval_status_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalApprovalStatusManager universalApprovalStatusManagerId;
    @JoinColumn(name = "voucher_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Voucher voucherId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comItemRequestId")
    private Collection<ComItemRequestLocation> comItemRequestLocationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comItemRequestId")
    private Collection<ComRequestedItem> comRequestedItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comItemRequestId")
    private Collection<RequestPurchaseOrderSiteManager> requestPurchaseOrderSiteManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comItemRequestId")
    private Collection<ComItemApproval> comItemApprovalCollection;

    public ComItemRequest() {
    }

    public ComItemRequest(Integer id) {
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

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ComItemRequestedBy getComItemRequestedById() {
        return comItemRequestedById;
    }

    public void setComItemRequestedById(ComItemRequestedBy comItemRequestedById) {
        this.comItemRequestedById = comItemRequestedById;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public GeneralOrganizationProfile getSiteId() {
        return siteId;
    }

    public void setSiteId(GeneralOrganizationProfile siteId) {
        this.siteId = siteId;
    }

    public GeneralUserProfile getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(GeneralUserProfile requestedBy) {
        this.requestedBy = requestedBy;
    }

    public ItemCategory getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(ItemCategory itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    public UniversalApprovalStatusManager getUniversalApprovalStatusManagerId() {
        return universalApprovalStatusManagerId;
    }

    public void setUniversalApprovalStatusManagerId(UniversalApprovalStatusManager universalApprovalStatusManagerId) {
        this.universalApprovalStatusManagerId = universalApprovalStatusManagerId;
    }

    public Voucher getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Voucher voucherId) {
        this.voucherId = voucherId;
    }

    @XmlTransient
    public Collection<ComItemRequestLocation> getComItemRequestLocationCollection() {
        return comItemRequestLocationCollection;
    }

    public void setComItemRequestLocationCollection(Collection<ComItemRequestLocation> comItemRequestLocationCollection) {
        this.comItemRequestLocationCollection = comItemRequestLocationCollection;
    }

    @XmlTransient
    public Collection<ComRequestedItem> getComRequestedItemCollection() {
        return comRequestedItemCollection;
    }

    public void setComRequestedItemCollection(Collection<ComRequestedItem> comRequestedItemCollection) {
        this.comRequestedItemCollection = comRequestedItemCollection;
    }

    @XmlTransient
    public Collection<RequestPurchaseOrderSiteManager> getRequestPurchaseOrderSiteManagerCollection() {
        return requestPurchaseOrderSiteManagerCollection;
    }

    public void setRequestPurchaseOrderSiteManagerCollection(Collection<RequestPurchaseOrderSiteManager> requestPurchaseOrderSiteManagerCollection) {
        this.requestPurchaseOrderSiteManagerCollection = requestPurchaseOrderSiteManagerCollection;
    }

    @XmlTransient
    public Collection<ComItemApproval> getComItemApprovalCollection() {
        return comItemApprovalCollection;
    }

    public void setComItemApprovalCollection(Collection<ComItemApproval> comItemApprovalCollection) {
        this.comItemApprovalCollection = comItemApprovalCollection;
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
        if (!(object instanceof ComItemRequest)) {
            return false;
        }
        ComItemRequest other = (ComItemRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ComItemRequest[ id=" + id + " ]";
    }
    
}
