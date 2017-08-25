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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "universal_boughtleaf_item_issue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniversalBoughtleafItemIssue.findAll", query = "SELECT u FROM UniversalBoughtleafItemIssue u")
    , @NamedQuery(name = "UniversalBoughtleafItemIssue.findById", query = "SELECT u FROM UniversalBoughtleafItemIssue u WHERE u.id = :id")
    , @NamedQuery(name = "UniversalBoughtleafItemIssue.findByQty", query = "SELECT u FROM UniversalBoughtleafItemIssue u WHERE u.qty = :qty")
    , @NamedQuery(name = "UniversalBoughtleafItemIssue.findByDate", query = "SELECT u FROM UniversalBoughtleafItemIssue u WHERE u.date = :date")
    , @NamedQuery(name = "UniversalBoughtleafItemIssue.findByValue", query = "SELECT u FROM UniversalBoughtleafItemIssue u WHERE u.value = :value")
    , @NamedQuery(name = "UniversalBoughtleafItemIssue.findByInstallment", query = "SELECT u FROM UniversalBoughtleafItemIssue u WHERE u.installment = :installment")})
public class UniversalBoughtleafItemIssue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qty")
    private Double qty;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "value")
    private Double value;
    @Column(name = "installment")
    private Integer installment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalBoughtleafItemIssueId")
    private Collection<UniversalBoughtleafItemInstallment> universalBoughtleafItemInstallmentCollection;
    @JoinColumn(name = "universal_boughtleaf_item_requested_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalBoughtleafItemRequestedItem universalBoughtleafItemRequestedItemId;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalTeaItemIssueId")
    private Collection<UniversalBoughtleafItemDeliveryDetails> universalBoughtleafItemDeliveryDetailsCollection;

    public UniversalBoughtleafItemIssue() {
    }

    public UniversalBoughtleafItemIssue(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getInstallment() {
        return installment;
    }

    public void setInstallment(Integer installment) {
        this.installment = installment;
    }

    @XmlTransient
    public Collection<UniversalBoughtleafItemInstallment> getUniversalBoughtleafItemInstallmentCollection() {
        return universalBoughtleafItemInstallmentCollection;
    }

    public void setUniversalBoughtleafItemInstallmentCollection(Collection<UniversalBoughtleafItemInstallment> universalBoughtleafItemInstallmentCollection) {
        this.universalBoughtleafItemInstallmentCollection = universalBoughtleafItemInstallmentCollection;
    }

    public UniversalBoughtleafItemRequestedItem getUniversalBoughtleafItemRequestedItemId() {
        return universalBoughtleafItemRequestedItemId;
    }

    public void setUniversalBoughtleafItemRequestedItemId(UniversalBoughtleafItemRequestedItem universalBoughtleafItemRequestedItemId) {
        this.universalBoughtleafItemRequestedItemId = universalBoughtleafItemRequestedItemId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    @XmlTransient
    public Collection<UniversalBoughtleafItemDeliveryDetails> getUniversalBoughtleafItemDeliveryDetailsCollection() {
        return universalBoughtleafItemDeliveryDetailsCollection;
    }

    public void setUniversalBoughtleafItemDeliveryDetailsCollection(Collection<UniversalBoughtleafItemDeliveryDetails> universalBoughtleafItemDeliveryDetailsCollection) {
        this.universalBoughtleafItemDeliveryDetailsCollection = universalBoughtleafItemDeliveryDetailsCollection;
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
        if (!(object instanceof UniversalBoughtleafItemIssue)) {
            return false;
        }
        UniversalBoughtleafItemIssue other = (UniversalBoughtleafItemIssue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UniversalBoughtleafItemIssue[ id=" + id + " ]";
    }
    
}
