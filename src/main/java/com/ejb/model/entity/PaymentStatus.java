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
@Table(name = "payment_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentStatus.findAll", query = "SELECT p FROM PaymentStatus p")
    , @NamedQuery(name = "PaymentStatus.findById", query = "SELECT p FROM PaymentStatus p WHERE p.id = :id")
    , @NamedQuery(name = "PaymentStatus.findByName", query = "SELECT p FROM PaymentStatus p WHERE p.name = :name")})
public class PaymentStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentStatusId")
    private Collection<TeaSupplierPayments> teaSupplierPaymentsCollection;

    public PaymentStatus() {
    }

    public PaymentStatus(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<TeaSupplierPayments> getTeaSupplierPaymentsCollection() {
        return teaSupplierPaymentsCollection;
    }

    public void setTeaSupplierPaymentsCollection(Collection<TeaSupplierPayments> teaSupplierPaymentsCollection) {
        this.teaSupplierPaymentsCollection = teaSupplierPaymentsCollection;
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
        if (!(object instanceof PaymentStatus)) {
            return false;
        }
        PaymentStatus other = (PaymentStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.PaymentStatus[ id=" + id + " ]";
    }
    
}
