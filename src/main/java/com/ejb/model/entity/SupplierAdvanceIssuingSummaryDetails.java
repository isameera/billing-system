/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "supplier_advance_issuing_summary_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierAdvanceIssuingSummaryDetails.findAll", query = "SELECT s FROM SupplierAdvanceIssuingSummaryDetails s")
    , @NamedQuery(name = "SupplierAdvanceIssuingSummaryDetails.findById", query = "SELECT s FROM SupplierAdvanceIssuingSummaryDetails s WHERE s.id = :id")
    , @NamedQuery(name = "SupplierAdvanceIssuingSummaryDetails.findByVoucherId", query = "SELECT s FROM SupplierAdvanceIssuingSummaryDetails s WHERE s.voucherId = :voucherId")
    , @NamedQuery(name = "SupplierAdvanceIssuingSummaryDetails.findByChequeNo", query = "SELECT s FROM SupplierAdvanceIssuingSummaryDetails s WHERE s.chequeNo = :chequeNo")})
public class SupplierAdvanceIssuingSummaryDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "voucher_id")
    private String voucherId;
    @Size(max = 45)
    @Column(name = "cheque_no")
    private String chequeNo;
    @JoinColumn(name = "supplier_advance_issuing_summary_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierAdvanceIssuingSummary supplierAdvanceIssuingSummaryId;
    @JoinColumn(name = "supplier_advance_request_issuing_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierAdvanceRequestIssuing supplierAdvanceRequestIssuingId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierAdvanceIssuingSummaryDetailsId")
    private Collection<SupplierAdvanceTransferRequest> supplierAdvanceTransferRequestCollection;

    public SupplierAdvanceIssuingSummaryDetails() {
    }

    public SupplierAdvanceIssuingSummaryDetails(Integer id) {
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

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public SupplierAdvanceIssuingSummary getSupplierAdvanceIssuingSummaryId() {
        return supplierAdvanceIssuingSummaryId;
    }

    public void setSupplierAdvanceIssuingSummaryId(SupplierAdvanceIssuingSummary supplierAdvanceIssuingSummaryId) {
        this.supplierAdvanceIssuingSummaryId = supplierAdvanceIssuingSummaryId;
    }

    public SupplierAdvanceRequestIssuing getSupplierAdvanceRequestIssuingId() {
        return supplierAdvanceRequestIssuingId;
    }

    public void setSupplierAdvanceRequestIssuingId(SupplierAdvanceRequestIssuing supplierAdvanceRequestIssuingId) {
        this.supplierAdvanceRequestIssuingId = supplierAdvanceRequestIssuingId;
    }

    @XmlTransient
    public Collection<SupplierAdvanceTransferRequest> getSupplierAdvanceTransferRequestCollection() {
        return supplierAdvanceTransferRequestCollection;
    }

    public void setSupplierAdvanceTransferRequestCollection(Collection<SupplierAdvanceTransferRequest> supplierAdvanceTransferRequestCollection) {
        this.supplierAdvanceTransferRequestCollection = supplierAdvanceTransferRequestCollection;
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
        if (!(object instanceof SupplierAdvanceIssuingSummaryDetails)) {
            return false;
        }
        SupplierAdvanceIssuingSummaryDetails other = (SupplierAdvanceIssuingSummaryDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierAdvanceIssuingSummaryDetails[ id=" + id + " ]";
    }
    
}
