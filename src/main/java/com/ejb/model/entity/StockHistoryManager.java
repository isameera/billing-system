/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "stock_history_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StockHistoryManager.findAll", query = "SELECT s FROM StockHistoryManager s")
    , @NamedQuery(name = "StockHistoryManager.findById", query = "SELECT s FROM StockHistoryManager s WHERE s.id = :id")
    , @NamedQuery(name = "StockHistoryManager.findByDate", query = "SELECT s FROM StockHistoryManager s WHERE s.date = :date")
    , @NamedQuery(name = "StockHistoryManager.findByQtyReceived", query = "SELECT s FROM StockHistoryManager s WHERE s.qtyReceived = :qtyReceived")
    , @NamedQuery(name = "StockHistoryManager.findByQtyDispatch", query = "SELECT s FROM StockHistoryManager s WHERE s.qtyDispatch = :qtyDispatch")
    , @NamedQuery(name = "StockHistoryManager.findByStockRemain", query = "SELECT s FROM StockHistoryManager s WHERE s.stockRemain = :stockRemain")
    , @NamedQuery(name = "StockHistoryManager.findByQtyReconcilled", query = "SELECT s FROM StockHistoryManager s WHERE s.qtyReconcilled = :qtyReconcilled")
    , @NamedQuery(name = "StockHistoryManager.findByOpenStock", query = "SELECT s FROM StockHistoryManager s WHERE s.openStock = :openStock")
    , @NamedQuery(name = "StockHistoryManager.findByIsStockUpdated", query = "SELECT s FROM StockHistoryManager s WHERE s.isStockUpdated = :isStockUpdated")})
public class StockHistoryManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qty_received")
    private Double qtyReceived;
    @Column(name = "qty_dispatch")
    private Double qtyDispatch;
    @Column(name = "stock_remain")
    private Double stockRemain;
    @Column(name = "qty_reconcilled")
    private Double qtyReconcilled;
    @Column(name = "open_stock")
    private Double openStock;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "is_stock_updated")
    private Integer isStockUpdated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stockHistoryManagerId")
    private Collection<StockReconciliation> stockReconciliationCollection;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "inventory_controller_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InventoryController inventoryControllerId;

    public StockHistoryManager() {
    }

    public StockHistoryManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getQtyReceived() {
        return qtyReceived;
    }

    public void setQtyReceived(Double qtyReceived) {
        this.qtyReceived = qtyReceived;
    }

    public Double getQtyDispatch() {
        return qtyDispatch;
    }

    public void setQtyDispatch(Double qtyDispatch) {
        this.qtyDispatch = qtyDispatch;
    }

    public Double getStockRemain() {
        return stockRemain;
    }

    public void setStockRemain(Double stockRemain) {
        this.stockRemain = stockRemain;
    }

    public Double getQtyReconcilled() {
        return qtyReconcilled;
    }

    public void setQtyReconcilled(Double qtyReconcilled) {
        this.qtyReconcilled = qtyReconcilled;
    }

    public Double getOpenStock() {
        return openStock;
    }

    public void setOpenStock(Double openStock) {
        this.openStock = openStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsStockUpdated() {
        return isStockUpdated;
    }

    public void setIsStockUpdated(Integer isStockUpdated) {
        this.isStockUpdated = isStockUpdated;
    }

    @XmlTransient
    public Collection<StockReconciliation> getStockReconciliationCollection() {
        return stockReconciliationCollection;
    }

    public void setStockReconciliationCollection(Collection<StockReconciliation> stockReconciliationCollection) {
        this.stockReconciliationCollection = stockReconciliationCollection;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public InventoryController getInventoryControllerId() {
        return inventoryControllerId;
    }

    public void setInventoryControllerId(InventoryController inventoryControllerId) {
        this.inventoryControllerId = inventoryControllerId;
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
        if (!(object instanceof StockHistoryManager)) {
            return false;
        }
        StockHistoryManager other = (StockHistoryManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.StockHistoryManager[ id=" + id + " ]";
    }
    
}
