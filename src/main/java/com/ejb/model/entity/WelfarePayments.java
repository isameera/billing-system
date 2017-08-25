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
@Table(name = "welfare_payments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WelfarePayments.findAll", query = "SELECT w FROM WelfarePayments w")
    , @NamedQuery(name = "WelfarePayments.findById", query = "SELECT w FROM WelfarePayments w WHERE w.id = :id")
    , @NamedQuery(name = "WelfarePayments.findByPaymentId", query = "SELECT w FROM WelfarePayments w WHERE w.paymentId = :paymentId")
    , @NamedQuery(name = "WelfarePayments.findByDate", query = "SELECT w FROM WelfarePayments w WHERE w.date = :date")
    , @NamedQuery(name = "WelfarePayments.findByAmount", query = "SELECT w FROM WelfarePayments w WHERE w.amount = :amount")})
public class WelfarePayments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "payment_id")
    private String paymentId;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @Lob
    @Size(max = 65535)
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne
    private SupplierRegistration supplierRegistrationId;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "welfare_payment_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private WelfarePaymentType welfarePaymentTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "welfarePaymentsId")
    private Collection<SupplierWelfareMemberPayment> supplierWelfareMemberPaymentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "welfarePaymentsId")
    private Collection<WelfareMemberPayments> welfareMemberPaymentsCollection;

    public WelfarePayments() {
    }

    public WelfarePayments(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public SupplierRegistration getSupplierRegistrationId() {
        return supplierRegistrationId;
    }

    public void setSupplierRegistrationId(SupplierRegistration supplierRegistrationId) {
        this.supplierRegistrationId = supplierRegistrationId;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
    }

    public WelfarePaymentType getWelfarePaymentTypeId() {
        return welfarePaymentTypeId;
    }

    public void setWelfarePaymentTypeId(WelfarePaymentType welfarePaymentTypeId) {
        this.welfarePaymentTypeId = welfarePaymentTypeId;
    }

    @XmlTransient
    public Collection<SupplierWelfareMemberPayment> getSupplierWelfareMemberPaymentCollection() {
        return supplierWelfareMemberPaymentCollection;
    }

    public void setSupplierWelfareMemberPaymentCollection(Collection<SupplierWelfareMemberPayment> supplierWelfareMemberPaymentCollection) {
        this.supplierWelfareMemberPaymentCollection = supplierWelfareMemberPaymentCollection;
    }

    @XmlTransient
    public Collection<WelfareMemberPayments> getWelfareMemberPaymentsCollection() {
        return welfareMemberPaymentsCollection;
    }

    public void setWelfareMemberPaymentsCollection(Collection<WelfareMemberPayments> welfareMemberPaymentsCollection) {
        this.welfareMemberPaymentsCollection = welfareMemberPaymentsCollection;
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
        if (!(object instanceof WelfarePayments)) {
            return false;
        }
        WelfarePayments other = (WelfarePayments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.WelfarePayments[ id=" + id + " ]";
    }
    
}
