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
@Table(name = "supplier_payment_controller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierPaymentController.findAll", query = "SELECT s FROM SupplierPaymentController s")
    , @NamedQuery(name = "SupplierPaymentController.findById", query = "SELECT s FROM SupplierPaymentController s WHERE s.id = :id")
    , @NamedQuery(name = "SupplierPaymentController.findByRegDate", query = "SELECT s FROM SupplierPaymentController s WHERE s.regDate = :regDate")})
public class SupplierPaymentController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "reg_date")
    @Temporal(TemporalType.DATE)
    private Date regDate;
    @JoinColumn(name = "bank_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BankAccount bankAccountId;
    @JoinColumn(name = "suppler_payment_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplerPaymentType supplerPaymentTypeId;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierRegistration supplierRegistrationId;

    public SupplierPaymentController() {
    }

    public SupplierPaymentController(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public BankAccount getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(BankAccount bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public SupplerPaymentType getSupplerPaymentTypeId() {
        return supplerPaymentTypeId;
    }

    public void setSupplerPaymentTypeId(SupplerPaymentType supplerPaymentTypeId) {
        this.supplerPaymentTypeId = supplerPaymentTypeId;
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
        if (!(object instanceof SupplierPaymentController)) {
            return false;
        }
        SupplierPaymentController other = (SupplierPaymentController) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierPaymentController[ id=" + id + " ]";
    }
    
}
