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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "supplier_advance_transfer_request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierAdvanceTransferRequest.findAll", query = "SELECT s FROM SupplierAdvanceTransferRequest s")
    , @NamedQuery(name = "SupplierAdvanceTransferRequest.findById", query = "SELECT s FROM SupplierAdvanceTransferRequest s WHERE s.id = :id")
    , @NamedQuery(name = "SupplierAdvanceTransferRequest.findByRequestedDate", query = "SELECT s FROM SupplierAdvanceTransferRequest s WHERE s.requestedDate = :requestedDate")
    , @NamedQuery(name = "SupplierAdvanceTransferRequest.findByRequestedAmount", query = "SELECT s FROM SupplierAdvanceTransferRequest s WHERE s.requestedAmount = :requestedAmount")
    , @NamedQuery(name = "SupplierAdvanceTransferRequest.findByApprovedAmount", query = "SELECT s FROM SupplierAdvanceTransferRequest s WHERE s.approvedAmount = :approvedAmount")
    , @NamedQuery(name = "SupplierAdvanceTransferRequest.findByApprovedDate", query = "SELECT s FROM SupplierAdvanceTransferRequest s WHERE s.approvedDate = :approvedDate")})
public class SupplierAdvanceTransferRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "requested_date")
    @Temporal(TemporalType.DATE)
    private Date requestedDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "requested_amount")
    private Double requestedAmount;
    @Column(name = "approved_amount")
    private Double approvedAmount;
    @Column(name = "approved_date")
    @Temporal(TemporalType.DATE)
    private Date approvedDate;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "supplier_advance_issuing_summary_details_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierAdvanceIssuingSummaryDetails supplierAdvanceIssuingSummaryDetailsId;
    @JoinColumn(name = "exist_supplier", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierRegistration existSupplier;
    @JoinColumn(name = "new_supplier", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierRegistration newSupplier;
    @JoinColumn(name = "universal_approval_status_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalApprovalStatusManager universalApprovalStatusManagerId;

    public SupplierAdvanceTransferRequest() {
    }

    public SupplierAdvanceTransferRequest(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public Double getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(Double requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public Double getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(Double approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public SupplierAdvanceIssuingSummaryDetails getSupplierAdvanceIssuingSummaryDetailsId() {
        return supplierAdvanceIssuingSummaryDetailsId;
    }

    public void setSupplierAdvanceIssuingSummaryDetailsId(SupplierAdvanceIssuingSummaryDetails supplierAdvanceIssuingSummaryDetailsId) {
        this.supplierAdvanceIssuingSummaryDetailsId = supplierAdvanceIssuingSummaryDetailsId;
    }

    public SupplierRegistration getExistSupplier() {
        return existSupplier;
    }

    public void setExistSupplier(SupplierRegistration existSupplier) {
        this.existSupplier = existSupplier;
    }

    public SupplierRegistration getNewSupplier() {
        return newSupplier;
    }

    public void setNewSupplier(SupplierRegistration newSupplier) {
        this.newSupplier = newSupplier;
    }

    public UniversalApprovalStatusManager getUniversalApprovalStatusManagerId() {
        return universalApprovalStatusManagerId;
    }

    public void setUniversalApprovalStatusManagerId(UniversalApprovalStatusManager universalApprovalStatusManagerId) {
        this.universalApprovalStatusManagerId = universalApprovalStatusManagerId;
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
        if (!(object instanceof SupplierAdvanceTransferRequest)) {
            return false;
        }
        SupplierAdvanceTransferRequest other = (SupplierAdvanceTransferRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierAdvanceTransferRequest[ id=" + id + " ]";
    }
    
}
