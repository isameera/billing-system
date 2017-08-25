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
@Table(name = "voucher_item_calculated_by")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VoucherItemCalculatedBy.findAll", query = "SELECT v FROM VoucherItemCalculatedBy v")
    , @NamedQuery(name = "VoucherItemCalculatedBy.findById", query = "SELECT v FROM VoucherItemCalculatedBy v WHERE v.id = :id")
    , @NamedQuery(name = "VoucherItemCalculatedBy.findByAmount", query = "SELECT v FROM VoucherItemCalculatedBy v WHERE v.amount = :amount")})
public class VoucherItemCalculatedBy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @JoinColumn(name = "voucher_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VoucherItem voucherItemId;
    @JoinColumn(name = "voucher_item_calculated_by_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VoucherItemCalculatedByType voucherItemCalculatedByTypeId;

    public VoucherItemCalculatedBy() {
    }

    public VoucherItemCalculatedBy(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public VoucherItem getVoucherItemId() {
        return voucherItemId;
    }

    public void setVoucherItemId(VoucherItem voucherItemId) {
        this.voucherItemId = voucherItemId;
    }

    public VoucherItemCalculatedByType getVoucherItemCalculatedByTypeId() {
        return voucherItemCalculatedByTypeId;
    }

    public void setVoucherItemCalculatedByTypeId(VoucherItemCalculatedByType voucherItemCalculatedByTypeId) {
        this.voucherItemCalculatedByTypeId = voucherItemCalculatedByTypeId;
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
        if (!(object instanceof VoucherItemCalculatedBy)) {
            return false;
        }
        VoucherItemCalculatedBy other = (VoucherItemCalculatedBy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.VoucherItemCalculatedBy[ id=" + id + " ]";
    }
    
}
