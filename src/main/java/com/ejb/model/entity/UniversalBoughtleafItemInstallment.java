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
@Table(name = "universal_boughtleaf_item_installment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniversalBoughtleafItemInstallment.findAll", query = "SELECT u FROM UniversalBoughtleafItemInstallment u")
    , @NamedQuery(name = "UniversalBoughtleafItemInstallment.findById", query = "SELECT u FROM UniversalBoughtleafItemInstallment u WHERE u.id = :id")
    , @NamedQuery(name = "UniversalBoughtleafItemInstallment.findByYear", query = "SELECT u FROM UniversalBoughtleafItemInstallment u WHERE u.year = :year")
    , @NamedQuery(name = "UniversalBoughtleafItemInstallment.findByMonth", query = "SELECT u FROM UniversalBoughtleafItemInstallment u WHERE u.month = :month")
    , @NamedQuery(name = "UniversalBoughtleafItemInstallment.findByAmount", query = "SELECT u FROM UniversalBoughtleafItemInstallment u WHERE u.amount = :amount")
    , @NamedQuery(name = "UniversalBoughtleafItemInstallment.findByIsPaid", query = "SELECT u FROM UniversalBoughtleafItemInstallment u WHERE u.isPaid = :isPaid")})
public class UniversalBoughtleafItemInstallment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "year")
    private Integer year;
    @Column(name = "month")
    private Integer month;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @Column(name = "is_paid")
    private Integer isPaid;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierRegistration supplierRegistrationId;
    @JoinColumn(name = "universal_boughtleaf_item_issue_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalBoughtleafItemIssue universalBoughtleafItemIssueId;

    public UniversalBoughtleafItemInstallment() {
    }

    public UniversalBoughtleafItemInstallment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Integer isPaid) {
        this.isPaid = isPaid;
    }

    public SupplierRegistration getSupplierRegistrationId() {
        return supplierRegistrationId;
    }

    public void setSupplierRegistrationId(SupplierRegistration supplierRegistrationId) {
        this.supplierRegistrationId = supplierRegistrationId;
    }

    public UniversalBoughtleafItemIssue getUniversalBoughtleafItemIssueId() {
        return universalBoughtleafItemIssueId;
    }

    public void setUniversalBoughtleafItemIssueId(UniversalBoughtleafItemIssue universalBoughtleafItemIssueId) {
        this.universalBoughtleafItemIssueId = universalBoughtleafItemIssueId;
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
        if (!(object instanceof UniversalBoughtleafItemInstallment)) {
            return false;
        }
        UniversalBoughtleafItemInstallment other = (UniversalBoughtleafItemInstallment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UniversalBoughtleafItemInstallment[ id=" + id + " ]";
    }
    
}
