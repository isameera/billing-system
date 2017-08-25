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
@Table(name = "universal_boughtleaf_item_controller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniversalBoughtleafItemController.findAll", query = "SELECT u FROM UniversalBoughtleafItemController u")
    , @NamedQuery(name = "UniversalBoughtleafItemController.findById", query = "SELECT u FROM UniversalBoughtleafItemController u WHERE u.id = :id")
    , @NamedQuery(name = "UniversalBoughtleafItemController.findByRequstedQty", query = "SELECT u FROM UniversalBoughtleafItemController u WHERE u.requstedQty = :requstedQty")
    , @NamedQuery(name = "UniversalBoughtleafItemController.findByIssuedQty", query = "SELECT u FROM UniversalBoughtleafItemController u WHERE u.issuedQty = :issuedQty")
    , @NamedQuery(name = "UniversalBoughtleafItemController.findByTotalValue", query = "SELECT u FROM UniversalBoughtleafItemController u WHERE u.totalValue = :totalValue")
    , @NamedQuery(name = "UniversalBoughtleafItemController.findByTotalPaid", query = "SELECT u FROM UniversalBoughtleafItemController u WHERE u.totalPaid = :totalPaid")
    , @NamedQuery(name = "UniversalBoughtleafItemController.findByDueAmount", query = "SELECT u FROM UniversalBoughtleafItemController u WHERE u.dueAmount = :dueAmount")})
public class UniversalBoughtleafItemController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "requsted_qty")
    private Double requstedQty;
    @Column(name = "issued_qty")
    private Double issuedQty;
    @Column(name = "total_value")
    private Double totalValue;
    @Column(name = "total_paid")
    private Double totalPaid;
    @Column(name = "due_amount")
    private Double dueAmount;
    @JoinColumn(name = "org_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrgItem orgItemId;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierRegistration supplierRegistrationId;

    public UniversalBoughtleafItemController() {
    }

    public UniversalBoughtleafItemController(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getRequstedQty() {
        return requstedQty;
    }

    public void setRequstedQty(Double requstedQty) {
        this.requstedQty = requstedQty;
    }

    public Double getIssuedQty() {
        return issuedQty;
    }

    public void setIssuedQty(Double issuedQty) {
        this.issuedQty = issuedQty;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(Double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public Double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public OrgItem getOrgItemId() {
        return orgItemId;
    }

    public void setOrgItemId(OrgItem orgItemId) {
        this.orgItemId = orgItemId;
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
        if (!(object instanceof UniversalBoughtleafItemController)) {
            return false;
        }
        UniversalBoughtleafItemController other = (UniversalBoughtleafItemController) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UniversalBoughtleafItemController[ id=" + id + " ]";
    }
    
}
