/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "request_purchase_order_site_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequestPurchaseOrderSiteManager.findAll", query = "SELECT r FROM RequestPurchaseOrderSiteManager r")
    , @NamedQuery(name = "RequestPurchaseOrderSiteManager.findById", query = "SELECT r FROM RequestPurchaseOrderSiteManager r WHERE r.id = :id")})
public class RequestPurchaseOrderSiteManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "com_item_request_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ComItemRequest comItemRequestId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "voucher_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Voucher voucherId;

    public RequestPurchaseOrderSiteManager() {
    }

    public RequestPurchaseOrderSiteManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ComItemRequest getComItemRequestId() {
        return comItemRequestId;
    }

    public void setComItemRequestId(ComItemRequest comItemRequestId) {
        this.comItemRequestId = comItemRequestId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public Voucher getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Voucher voucherId) {
        this.voucherId = voucherId;
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
        if (!(object instanceof RequestPurchaseOrderSiteManager)) {
            return false;
        }
        RequestPurchaseOrderSiteManager other = (RequestPurchaseOrderSiteManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.RequestPurchaseOrderSiteManager[ id=" + id + " ]";
    }
    
}
