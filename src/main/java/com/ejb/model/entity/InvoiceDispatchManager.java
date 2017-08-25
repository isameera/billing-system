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
@Table(name = "invoice_dispatch_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvoiceDispatchManager.findAll", query = "SELECT i FROM InvoiceDispatchManager i")
    , @NamedQuery(name = "InvoiceDispatchManager.findById", query = "SELECT i FROM InvoiceDispatchManager i WHERE i.id = :id")})
public class InvoiceDispatchManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "delivery_note_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DeliveryNote deliveryNoteId;
    @JoinColumn(name = "voucher_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Voucher voucherId;

    public InvoiceDispatchManager() {
    }

    public InvoiceDispatchManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DeliveryNote getDeliveryNoteId() {
        return deliveryNoteId;
    }

    public void setDeliveryNoteId(DeliveryNote deliveryNoteId) {
        this.deliveryNoteId = deliveryNoteId;
    }

    public Voucher getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Voucher voucherId) {
        this.voucherId = voucherId;
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
        if (!(object instanceof InvoiceDispatchManager)) {
            return false;
        }
        InvoiceDispatchManager other = (InvoiceDispatchManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.InvoiceDispatchManager[ id=" + id + " ]";
    }
    
}
