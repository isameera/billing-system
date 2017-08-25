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
@Table(name = "supplier_savings_payment_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierSavingsPaymentManager.findAll", query = "SELECT s FROM SupplierSavingsPaymentManager s")
    , @NamedQuery(name = "SupplierSavingsPaymentManager.findById", query = "SELECT s FROM SupplierSavingsPaymentManager s WHERE s.id = :id")})
public class SupplierSavingsPaymentManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "prepare_payments_for_supplier_savings_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PreparePaymentsForSupplierSavings preparePaymentsForSupplierSavingsId;
    @JoinColumn(name = "supplier_savings_payment_history_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierSavingsPaymentHistory supplierSavingsPaymentHistoryId;

    public SupplierSavingsPaymentManager() {
    }

    public SupplierSavingsPaymentManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PreparePaymentsForSupplierSavings getPreparePaymentsForSupplierSavingsId() {
        return preparePaymentsForSupplierSavingsId;
    }

    public void setPreparePaymentsForSupplierSavingsId(PreparePaymentsForSupplierSavings preparePaymentsForSupplierSavingsId) {
        this.preparePaymentsForSupplierSavingsId = preparePaymentsForSupplierSavingsId;
    }

    public SupplierSavingsPaymentHistory getSupplierSavingsPaymentHistoryId() {
        return supplierSavingsPaymentHistoryId;
    }

    public void setSupplierSavingsPaymentHistoryId(SupplierSavingsPaymentHistory supplierSavingsPaymentHistoryId) {
        this.supplierSavingsPaymentHistoryId = supplierSavingsPaymentHistoryId;
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
        if (!(object instanceof SupplierSavingsPaymentManager)) {
            return false;
        }
        SupplierSavingsPaymentManager other = (SupplierSavingsPaymentManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierSavingsPaymentManager[ id=" + id + " ]";
    }
    
}
