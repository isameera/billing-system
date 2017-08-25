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
@Table(name = "supplier_advance_request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierAdvanceRequest.findAll", query = "SELECT s FROM SupplierAdvanceRequest s")
    , @NamedQuery(name = "SupplierAdvanceRequest.findById", query = "SELECT s FROM SupplierAdvanceRequest s WHERE s.id = :id")
    , @NamedQuery(name = "SupplierAdvanceRequest.findByRequstedDate", query = "SELECT s FROM SupplierAdvanceRequest s WHERE s.requstedDate = :requstedDate")
    , @NamedQuery(name = "SupplierAdvanceRequest.findByAmount", query = "SELECT s FROM SupplierAdvanceRequest s WHERE s.amount = :amount")
    , @NamedQuery(name = "SupplierAdvanceRequest.findByDescription", query = "SELECT s FROM SupplierAdvanceRequest s WHERE s.description = :description")
    , @NamedQuery(name = "SupplierAdvanceRequest.findByIsTransfer", query = "SELECT s FROM SupplierAdvanceRequest s WHERE s.isTransfer = :isTransfer")})
public class SupplierAdvanceRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "requsted_date")
    @Temporal(TemporalType.DATE)
    private Date requstedDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @Size(max = 1050)
    @Column(name = "description")
    private String description;
    @Column(name = "is_transfer")
    private Integer isTransfer;
    @JoinColumn(name = "advance_request_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AdvanceRequestType advanceRequestTypeId;
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Route routeId;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierRegistration supplierRegistrationId;
    @JoinColumn(name = "universal_approval_status_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalApprovalStatusManager universalApprovalStatusManagerId;
    @JoinColumn(name = "universal_payment_mode_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalPaymentMode universalPaymentModeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierAdvanceRequestId")
    private Collection<SupplierAdvanceRequestApproval> supplierAdvanceRequestApprovalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierAdvanceRequestId")
    private Collection<SupplierAdvanceRequestIssuing> supplierAdvanceRequestIssuingCollection;

    public SupplierAdvanceRequest() {
    }

    public SupplierAdvanceRequest(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRequstedDate() {
        return requstedDate;
    }

    public void setRequstedDate(Date requstedDate) {
        this.requstedDate = requstedDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsTransfer() {
        return isTransfer;
    }

    public void setIsTransfer(Integer isTransfer) {
        this.isTransfer = isTransfer;
    }

    public AdvanceRequestType getAdvanceRequestTypeId() {
        return advanceRequestTypeId;
    }

    public void setAdvanceRequestTypeId(AdvanceRequestType advanceRequestTypeId) {
        this.advanceRequestTypeId = advanceRequestTypeId;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    public SupplierRegistration getSupplierRegistrationId() {
        return supplierRegistrationId;
    }

    public void setSupplierRegistrationId(SupplierRegistration supplierRegistrationId) {
        this.supplierRegistrationId = supplierRegistrationId;
    }

    public UniversalApprovalStatusManager getUniversalApprovalStatusManagerId() {
        return universalApprovalStatusManagerId;
    }

    public void setUniversalApprovalStatusManagerId(UniversalApprovalStatusManager universalApprovalStatusManagerId) {
        this.universalApprovalStatusManagerId = universalApprovalStatusManagerId;
    }

    public UniversalPaymentMode getUniversalPaymentModeId() {
        return universalPaymentModeId;
    }

    public void setUniversalPaymentModeId(UniversalPaymentMode universalPaymentModeId) {
        this.universalPaymentModeId = universalPaymentModeId;
    }

    @XmlTransient
    public Collection<SupplierAdvanceRequestApproval> getSupplierAdvanceRequestApprovalCollection() {
        return supplierAdvanceRequestApprovalCollection;
    }

    public void setSupplierAdvanceRequestApprovalCollection(Collection<SupplierAdvanceRequestApproval> supplierAdvanceRequestApprovalCollection) {
        this.supplierAdvanceRequestApprovalCollection = supplierAdvanceRequestApprovalCollection;
    }

    @XmlTransient
    public Collection<SupplierAdvanceRequestIssuing> getSupplierAdvanceRequestIssuingCollection() {
        return supplierAdvanceRequestIssuingCollection;
    }

    public void setSupplierAdvanceRequestIssuingCollection(Collection<SupplierAdvanceRequestIssuing> supplierAdvanceRequestIssuingCollection) {
        this.supplierAdvanceRequestIssuingCollection = supplierAdvanceRequestIssuingCollection;
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
        if (!(object instanceof SupplierAdvanceRequest)) {
            return false;
        }
        SupplierAdvanceRequest other = (SupplierAdvanceRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierAdvanceRequest[ id=" + id + " ]";
    }
    
}
