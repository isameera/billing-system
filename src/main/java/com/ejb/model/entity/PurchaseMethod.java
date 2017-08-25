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
@Table(name = "purchase_method")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseMethod.findAll", query = "SELECT p FROM PurchaseMethod p")
    , @NamedQuery(name = "PurchaseMethod.findById", query = "SELECT p FROM PurchaseMethod p WHERE p.id = :id")
    , @NamedQuery(name = "PurchaseMethod.findByIsQuatationRequired", query = "SELECT p FROM PurchaseMethod p WHERE p.isQuatationRequired = :isQuatationRequired")})
public class PurchaseMethod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "is_quatation_required")
    private Boolean isQuatationRequired;
    @JoinColumn(name = "com_item_approval_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ComItemApproval comItemApprovalId;
    @JoinColumn(name = "universal_payment_mode_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalPaymentMode universalPaymentModeId;

    public PurchaseMethod() {
    }

    public PurchaseMethod(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsQuatationRequired() {
        return isQuatationRequired;
    }

    public void setIsQuatationRequired(Boolean isQuatationRequired) {
        this.isQuatationRequired = isQuatationRequired;
    }

    public ComItemApproval getComItemApprovalId() {
        return comItemApprovalId;
    }

    public void setComItemApprovalId(ComItemApproval comItemApprovalId) {
        this.comItemApprovalId = comItemApprovalId;
    }

    public UniversalPaymentMode getUniversalPaymentModeId() {
        return universalPaymentModeId;
    }

    public void setUniversalPaymentModeId(UniversalPaymentMode universalPaymentModeId) {
        this.universalPaymentModeId = universalPaymentModeId;
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
        if (!(object instanceof PurchaseMethod)) {
            return false;
        }
        PurchaseMethod other = (PurchaseMethod) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.PurchaseMethod[ id=" + id + " ]";
    }
    
}
