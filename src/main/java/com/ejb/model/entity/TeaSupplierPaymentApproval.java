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
@Table(name = "tea_supplier_payment_approval")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TeaSupplierPaymentApproval.findAll", query = "SELECT t FROM TeaSupplierPaymentApproval t")
    , @NamedQuery(name = "TeaSupplierPaymentApproval.findById", query = "SELECT t FROM TeaSupplierPaymentApproval t WHERE t.id = :id")
    , @NamedQuery(name = "TeaSupplierPaymentApproval.findByDateApproved", query = "SELECT t FROM TeaSupplierPaymentApproval t WHERE t.dateApproved = :dateApproved")})
public class TeaSupplierPaymentApproval implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date_approved")
    @Temporal(TemporalType.DATE)
    private Date dateApproved;
    @JoinColumn(name = "employees_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeesId;
    @JoinColumn(name = "tea_supplier_payments_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TeaSupplierPayments teaSupplierPaymentsId;

    public TeaSupplierPaymentApproval() {
    }

    public TeaSupplierPaymentApproval(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateApproved() {
        return dateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        this.dateApproved = dateApproved;
    }

    public Employee getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(Employee employeesId) {
        this.employeesId = employeesId;
    }

    public TeaSupplierPayments getTeaSupplierPaymentsId() {
        return teaSupplierPaymentsId;
    }

    public void setTeaSupplierPaymentsId(TeaSupplierPayments teaSupplierPaymentsId) {
        this.teaSupplierPaymentsId = teaSupplierPaymentsId;
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
        if (!(object instanceof TeaSupplierPaymentApproval)) {
            return false;
        }
        TeaSupplierPaymentApproval other = (TeaSupplierPaymentApproval) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.TeaSupplierPaymentApproval[ id=" + id + " ]";
    }
    
}
