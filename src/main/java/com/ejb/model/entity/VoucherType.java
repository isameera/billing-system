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
@Table(name = "voucher_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VoucherType.findAll", query = "SELECT v FROM VoucherType v")
    , @NamedQuery(name = "VoucherType.findById", query = "SELECT v FROM VoucherType v WHERE v.id = :id")
    , @NamedQuery(name = "VoucherType.findByName", query = "SELECT v FROM VoucherType v WHERE v.name = :name")
    , @NamedQuery(name = "VoucherType.findByIdAbbreviation", query = "SELECT v FROM VoucherType v WHERE v.idAbbreviation = :idAbbreviation")})
public class VoucherType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "id_abbreviation")
    private String idAbbreviation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherTypeId")
    private Collection<VoucherItemManager> voucherItemManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherTypeId")
    private Collection<VoucherTotalManager> voucherTotalManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherTypeId")
    private Collection<Voucher> voucherCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherTypeId")
    private Collection<UniversalOrgPersonFinancialHistory> universalOrgPersonFinancialHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherTypeId")
    private Collection<VoucherItem> voucherItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherTypeId")
    private Collection<PaymentHistory> paymentHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherTypeId")
    private Collection<PayeeAccumulatedTotal> payeeAccumulatedTotalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherTypeId")
    private Collection<VoucherJobManager> voucherJobManagerCollection;

    public VoucherType() {
    }

    public VoucherType(Integer id) {
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

    public String getIdAbbreviation() {
        return idAbbreviation;
    }

    public void setIdAbbreviation(String idAbbreviation) {
        this.idAbbreviation = idAbbreviation;
    }

    @XmlTransient
    public Collection<VoucherItemManager> getVoucherItemManagerCollection() {
        return voucherItemManagerCollection;
    }

    public void setVoucherItemManagerCollection(Collection<VoucherItemManager> voucherItemManagerCollection) {
        this.voucherItemManagerCollection = voucherItemManagerCollection;
    }

    @XmlTransient
    public Collection<VoucherTotalManager> getVoucherTotalManagerCollection() {
        return voucherTotalManagerCollection;
    }

    public void setVoucherTotalManagerCollection(Collection<VoucherTotalManager> voucherTotalManagerCollection) {
        this.voucherTotalManagerCollection = voucherTotalManagerCollection;
    }

    @XmlTransient
    public Collection<Voucher> getVoucherCollection() {
        return voucherCollection;
    }

    public void setVoucherCollection(Collection<Voucher> voucherCollection) {
        this.voucherCollection = voucherCollection;
    }

    @XmlTransient
    public Collection<UniversalOrgPersonFinancialHistory> getUniversalOrgPersonFinancialHistoryCollection() {
        return universalOrgPersonFinancialHistoryCollection;
    }

    public void setUniversalOrgPersonFinancialHistoryCollection(Collection<UniversalOrgPersonFinancialHistory> universalOrgPersonFinancialHistoryCollection) {
        this.universalOrgPersonFinancialHistoryCollection = universalOrgPersonFinancialHistoryCollection;
    }

    @XmlTransient
    public Collection<VoucherItem> getVoucherItemCollection() {
        return voucherItemCollection;
    }

    public void setVoucherItemCollection(Collection<VoucherItem> voucherItemCollection) {
        this.voucherItemCollection = voucherItemCollection;
    }

    @XmlTransient
    public Collection<PaymentHistory> getPaymentHistoryCollection() {
        return paymentHistoryCollection;
    }

    public void setPaymentHistoryCollection(Collection<PaymentHistory> paymentHistoryCollection) {
        this.paymentHistoryCollection = paymentHistoryCollection;
    }

    @XmlTransient
    public Collection<PayeeAccumulatedTotal> getPayeeAccumulatedTotalCollection() {
        return payeeAccumulatedTotalCollection;
    }

    public void setPayeeAccumulatedTotalCollection(Collection<PayeeAccumulatedTotal> payeeAccumulatedTotalCollection) {
        this.payeeAccumulatedTotalCollection = payeeAccumulatedTotalCollection;
    }

    @XmlTransient
    public Collection<VoucherJobManager> getVoucherJobManagerCollection() {
        return voucherJobManagerCollection;
    }

    public void setVoucherJobManagerCollection(Collection<VoucherJobManager> voucherJobManagerCollection) {
        this.voucherJobManagerCollection = voucherJobManagerCollection;
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
        if (!(object instanceof VoucherType)) {
            return false;
        }
        VoucherType other = (VoucherType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.VoucherType[ id=" + id + " ]";
    }
    
}
