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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "tea_supplier_payments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TeaSupplierPayments.findAll", query = "SELECT t FROM TeaSupplierPayments t")
    , @NamedQuery(name = "TeaSupplierPayments.findById", query = "SELECT t FROM TeaSupplierPayments t WHERE t.id = :id")
    , @NamedQuery(name = "TeaSupplierPayments.findByTrId", query = "SELECT t FROM TeaSupplierPayments t WHERE t.trId = :trId")})
public class TeaSupplierPayments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "tr_id")
    private Integer trId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teaSupplierPaymentsId")
    private Collection<TeaSupplierPaymentApproval> teaSupplierPaymentApprovalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teaSupplierPaymentsId")
    private Collection<TeaSupplierPaymentVouchers> teaSupplierPaymentVouchersCollection;
    @JoinColumn(name = "payment_mode_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalPaymentMode paymentModeId;
    @JoinColumn(name = "payment_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PaymentStatus paymentStatusId;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierRegistration supplierRegistrationId;

    public TeaSupplierPayments() {
    }

    public TeaSupplierPayments(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrId() {
        return trId;
    }

    public void setTrId(Integer trId) {
        this.trId = trId;
    }

    @XmlTransient
    public Collection<TeaSupplierPaymentApproval> getTeaSupplierPaymentApprovalCollection() {
        return teaSupplierPaymentApprovalCollection;
    }

    public void setTeaSupplierPaymentApprovalCollection(Collection<TeaSupplierPaymentApproval> teaSupplierPaymentApprovalCollection) {
        this.teaSupplierPaymentApprovalCollection = teaSupplierPaymentApprovalCollection;
    }

    @XmlTransient
    public Collection<TeaSupplierPaymentVouchers> getTeaSupplierPaymentVouchersCollection() {
        return teaSupplierPaymentVouchersCollection;
    }

    public void setTeaSupplierPaymentVouchersCollection(Collection<TeaSupplierPaymentVouchers> teaSupplierPaymentVouchersCollection) {
        this.teaSupplierPaymentVouchersCollection = teaSupplierPaymentVouchersCollection;
    }

    public UniversalPaymentMode getPaymentModeId() {
        return paymentModeId;
    }

    public void setPaymentModeId(UniversalPaymentMode paymentModeId) {
        this.paymentModeId = paymentModeId;
    }

    public PaymentStatus getPaymentStatusId() {
        return paymentStatusId;
    }

    public void setPaymentStatusId(PaymentStatus paymentStatusId) {
        this.paymentStatusId = paymentStatusId;
    }

    public SupplierRegistration getSupplierRegistrationId() {
        return supplierRegistrationId;
    }

    public void setSupplierRegistrationId(SupplierRegistration supplierRegistrationId) {
        this.supplierRegistrationId = supplierRegistrationId;
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
        if (!(object instanceof TeaSupplierPayments)) {
            return false;
        }
        TeaSupplierPayments other = (TeaSupplierPayments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.TeaSupplierPayments[ id=" + id + " ]";
    }
    
}
