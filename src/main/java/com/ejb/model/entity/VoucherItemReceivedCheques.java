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
@Table(name = "voucher_item_received_cheques")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VoucherItemReceivedCheques.findAll", query = "SELECT v FROM VoucherItemReceivedCheques v")
    , @NamedQuery(name = "VoucherItemReceivedCheques.findById", query = "SELECT v FROM VoucherItemReceivedCheques v WHERE v.id = :id")})
public class VoucherItemReceivedCheques implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "received_cheques_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ReceivedCheques receivedChequesId;
    @JoinColumn(name = "voucher_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VoucherItem voucherItemId;

    public VoucherItemReceivedCheques() {
    }

    public VoucherItemReceivedCheques(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ReceivedCheques getReceivedChequesId() {
        return receivedChequesId;
    }

    public void setReceivedChequesId(ReceivedCheques receivedChequesId) {
        this.receivedChequesId = receivedChequesId;
    }

    public VoucherItem getVoucherItemId() {
        return voucherItemId;
    }

    public void setVoucherItemId(VoucherItem voucherItemId) {
        this.voucherItemId = voucherItemId;
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
        if (!(object instanceof VoucherItemReceivedCheques)) {
            return false;
        }
        VoucherItemReceivedCheques other = (VoucherItemReceivedCheques) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.VoucherItemReceivedCheques[ id=" + id + " ]";
    }
    
}
