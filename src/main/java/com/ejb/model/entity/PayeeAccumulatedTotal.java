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
@Table(name = "payee_accumulated_total")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PayeeAccumulatedTotal.findAll", query = "SELECT p FROM PayeeAccumulatedTotal p")
    , @NamedQuery(name = "PayeeAccumulatedTotal.findById", query = "SELECT p FROM PayeeAccumulatedTotal p WHERE p.id = :id")
    , @NamedQuery(name = "PayeeAccumulatedTotal.findByReferenceId", query = "SELECT p FROM PayeeAccumulatedTotal p WHERE p.referenceId = :referenceId")
    , @NamedQuery(name = "PayeeAccumulatedTotal.findByAccumulatedTotal", query = "SELECT p FROM PayeeAccumulatedTotal p WHERE p.accumulatedTotal = :accumulatedTotal")
    , @NamedQuery(name = "PayeeAccumulatedTotal.findByAccumulatedDue", query = "SELECT p FROM PayeeAccumulatedTotal p WHERE p.accumulatedDue = :accumulatedDue")
    , @NamedQuery(name = "PayeeAccumulatedTotal.findByAccumulatedDiscount", query = "SELECT p FROM PayeeAccumulatedTotal p WHERE p.accumulatedDiscount = :accumulatedDiscount")})
public class PayeeAccumulatedTotal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "reference_id")
    private Integer referenceId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "accumulated_total")
    private Double accumulatedTotal;
    @Column(name = "accumulated_due")
    private Double accumulatedDue;
    @Column(name = "accumulated_discount")
    private Double accumulatedDiscount;
    @JoinColumn(name = "voucher_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VoucherType voucherTypeId;
    @JoinColumn(name = "universal_person_or_org_type_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId;

    public PayeeAccumulatedTotal() {
    }

    public PayeeAccumulatedTotal(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Integer referenceId) {
        this.referenceId = referenceId;
    }

    public Double getAccumulatedTotal() {
        return accumulatedTotal;
    }

    public void setAccumulatedTotal(Double accumulatedTotal) {
        this.accumulatedTotal = accumulatedTotal;
    }

    public Double getAccumulatedDue() {
        return accumulatedDue;
    }

    public void setAccumulatedDue(Double accumulatedDue) {
        this.accumulatedDue = accumulatedDue;
    }

    public Double getAccumulatedDiscount() {
        return accumulatedDiscount;
    }

    public void setAccumulatedDiscount(Double accumulatedDiscount) {
        this.accumulatedDiscount = accumulatedDiscount;
    }

    public VoucherType getVoucherTypeId() {
        return voucherTypeId;
    }

    public void setVoucherTypeId(VoucherType voucherTypeId) {
        this.voucherTypeId = voucherTypeId;
    }

    public UniversalPersonOrOrgTypeManager getUniversalPersonOrOrgTypeManagerId() {
        return universalPersonOrOrgTypeManagerId;
    }

    public void setUniversalPersonOrOrgTypeManagerId(UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId) {
        this.universalPersonOrOrgTypeManagerId = universalPersonOrOrgTypeManagerId;
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
        if (!(object instanceof PayeeAccumulatedTotal)) {
            return false;
        }
        PayeeAccumulatedTotal other = (PayeeAccumulatedTotal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.PayeeAccumulatedTotal[ id=" + id + " ]";
    }
    
}
