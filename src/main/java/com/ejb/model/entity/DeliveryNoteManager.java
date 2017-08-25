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
@Table(name = "delivery_note_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeliveryNoteManager.findAll", query = "SELECT d FROM DeliveryNoteManager d")
    , @NamedQuery(name = "DeliveryNoteManager.findById", query = "SELECT d FROM DeliveryNoteManager d WHERE d.id = :id")})
public class DeliveryNoteManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "delivery_note_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DeliveryNote deliveryNoteId;
    @JoinColumn(name = "production_request_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductionRequest productionRequestId;

    public DeliveryNoteManager() {
    }

    public DeliveryNoteManager(Integer id) {
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

    public ProductionRequest getProductionRequestId() {
        return productionRequestId;
    }

    public void setProductionRequestId(ProductionRequest productionRequestId) {
        this.productionRequestId = productionRequestId;
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
        if (!(object instanceof DeliveryNoteManager)) {
            return false;
        }
        DeliveryNoteManager other = (DeliveryNoteManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.DeliveryNoteManager[ id=" + id + " ]";
    }
    
}
