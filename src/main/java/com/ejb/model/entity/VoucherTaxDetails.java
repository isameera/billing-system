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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "voucher_tax_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VoucherTaxDetails.findAll", query = "SELECT v FROM VoucherTaxDetails v")
    , @NamedQuery(name = "VoucherTaxDetails.findById", query = "SELECT v FROM VoucherTaxDetails v WHERE v.id = :id")
    , @NamedQuery(name = "VoucherTaxDetails.findByTaxNo", query = "SELECT v FROM VoucherTaxDetails v WHERE v.taxNo = :taxNo")
    , @NamedQuery(name = "VoucherTaxDetails.findByValue", query = "SELECT v FROM VoucherTaxDetails v WHERE v.value = :value")})
public class VoucherTaxDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "tax_no")
    private String taxNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "value")
    private Double value;
    @JoinColumn(name = "voucher_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Voucher voucherId;
    @JoinColumn(name = "voucher_tax_details_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VoucherTaxDetailsType voucherTaxDetailsTypeId;

    public VoucherTaxDetails() {
    }

    public VoucherTaxDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Voucher getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Voucher voucherId) {
        this.voucherId = voucherId;
    }

    public VoucherTaxDetailsType getVoucherTaxDetailsTypeId() {
        return voucherTaxDetailsTypeId;
    }

    public void setVoucherTaxDetailsTypeId(VoucherTaxDetailsType voucherTaxDetailsTypeId) {
        this.voucherTaxDetailsTypeId = voucherTaxDetailsTypeId;
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
        if (!(object instanceof VoucherTaxDetails)) {
            return false;
        }
        VoucherTaxDetails other = (VoucherTaxDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.VoucherTaxDetails[ id=" + id + " ]";
    }
    
}
