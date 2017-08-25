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
@Table(name = "supplier_advance_request_approval")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierAdvanceRequestApproval.findAll", query = "SELECT s FROM SupplierAdvanceRequestApproval s")
    , @NamedQuery(name = "SupplierAdvanceRequestApproval.findById", query = "SELECT s FROM SupplierAdvanceRequestApproval s WHERE s.id = :id")
    , @NamedQuery(name = "SupplierAdvanceRequestApproval.findByApprovalDate", query = "SELECT s FROM SupplierAdvanceRequestApproval s WHERE s.approvalDate = :approvalDate")
    , @NamedQuery(name = "SupplierAdvanceRequestApproval.findByApprovedAmount", query = "SELECT s FROM SupplierAdvanceRequestApproval s WHERE s.approvedAmount = :approvedAmount")})
public class SupplierAdvanceRequestApproval implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "approval_date")
    @Temporal(TemporalType.DATE)
    private Date approvalDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "approved_amount")
    private Double approvedAmount;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "supplier_advance_request_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierAdvanceRequest supplierAdvanceRequestId;

    public SupplierAdvanceRequestApproval() {
    }

    public SupplierAdvanceRequestApproval(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public Double getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(Double approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
    }

    public SupplierAdvanceRequest getSupplierAdvanceRequestId() {
        return supplierAdvanceRequestId;
    }

    public void setSupplierAdvanceRequestId(SupplierAdvanceRequest supplierAdvanceRequestId) {
        this.supplierAdvanceRequestId = supplierAdvanceRequestId;
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
        if (!(object instanceof SupplierAdvanceRequestApproval)) {
            return false;
        }
        SupplierAdvanceRequestApproval other = (SupplierAdvanceRequestApproval) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierAdvanceRequestApproval[ id=" + id + " ]";
    }
    
}
