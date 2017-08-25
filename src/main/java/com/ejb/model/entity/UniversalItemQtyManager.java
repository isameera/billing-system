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
@Table(name = "universal_item_qty_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniversalItemQtyManager.findAll", query = "SELECT u FROM UniversalItemQtyManager u")
    , @NamedQuery(name = "UniversalItemQtyManager.findById", query = "SELECT u FROM UniversalItemQtyManager u WHERE u.id = :id")
    , @NamedQuery(name = "UniversalItemQtyManager.findByReference", query = "SELECT u FROM UniversalItemQtyManager u WHERE u.reference = :reference")
    , @NamedQuery(name = "UniversalItemQtyManager.findByQty", query = "SELECT u FROM UniversalItemQtyManager u WHERE u.qty = :qty")
    , @NamedQuery(name = "UniversalItemQtyManager.findByBalanceQty", query = "SELECT u FROM UniversalItemQtyManager u WHERE u.balanceQty = :balanceQty")})
public class UniversalItemQtyManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "reference")
    private Integer reference;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qty")
    private Double qty;
    @Column(name = "balance_qty")
    private Double balanceQty;
    @JoinColumn(name = "item_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemMaster itemMasterId;
    @JoinColumn(name = "universal_qty_item_type_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalQtyItemTypeManager universalQtyItemTypeManagerId;

    public UniversalItemQtyManager() {
    }

    public UniversalItemQtyManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getBalanceQty() {
        return balanceQty;
    }

    public void setBalanceQty(Double balanceQty) {
        this.balanceQty = balanceQty;
    }

    public ItemMaster getItemMasterId() {
        return itemMasterId;
    }

    public void setItemMasterId(ItemMaster itemMasterId) {
        this.itemMasterId = itemMasterId;
    }

    public UniversalQtyItemTypeManager getUniversalQtyItemTypeManagerId() {
        return universalQtyItemTypeManagerId;
    }

    public void setUniversalQtyItemTypeManagerId(UniversalQtyItemTypeManager universalQtyItemTypeManagerId) {
        this.universalQtyItemTypeManagerId = universalQtyItemTypeManagerId;
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
        if (!(object instanceof UniversalItemQtyManager)) {
            return false;
        }
        UniversalItemQtyManager other = (UniversalItemQtyManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UniversalItemQtyManager[ id=" + id + " ]";
    }
    
}
