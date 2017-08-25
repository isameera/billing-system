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
@Table(name = "voucher_receipt_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VoucherReceiptManager.findAll", query = "SELECT v FROM VoucherReceiptManager v")
    , @NamedQuery(name = "VoucherReceiptManager.findById", query = "SELECT v FROM VoucherReceiptManager v WHERE v.id = :id")})
public class VoucherReceiptManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "voucher", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Voucher voucher;
    @JoinColumn(name = "receipt", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Voucher receipt;

    public VoucherReceiptManager() {
    }

    public VoucherReceiptManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }

    public Voucher getReceipt() {
        return receipt;
    }

    public void setReceipt(Voucher receipt) {
        this.receipt = receipt;
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
        if (!(object instanceof VoucherReceiptManager)) {
            return false;
        }
        VoucherReceiptManager other = (VoucherReceiptManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.VoucherReceiptManager[ id=" + id + " ]";
    }
    
}
