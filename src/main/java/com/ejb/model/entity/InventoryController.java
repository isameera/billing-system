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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "inventory_controller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventoryController.findAll", query = "SELECT i FROM InventoryController i")
    , @NamedQuery(name = "InventoryController.findById", query = "SELECT i FROM InventoryController i WHERE i.id = :id")
    , @NamedQuery(name = "InventoryController.findByQty", query = "SELECT i FROM InventoryController i WHERE i.qty = :qty")})
public class InventoryController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qty")
    private Double qty;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "item_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemMaster itemMasterId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventoryControllerId")
    private Collection<InventoryLocationController> inventoryLocationControllerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventoryControllerId")
    private Collection<StockHistoryManager> stockHistoryManagerCollection;

    public InventoryController() {
    }

    public InventoryController(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public ItemMaster getItemMasterId() {
        return itemMasterId;
    }

    public void setItemMasterId(ItemMaster itemMasterId) {
        this.itemMasterId = itemMasterId;
    }

    @XmlTransient
    public Collection<InventoryLocationController> getInventoryLocationControllerCollection() {
        return inventoryLocationControllerCollection;
    }

    public void setInventoryLocationControllerCollection(Collection<InventoryLocationController> inventoryLocationControllerCollection) {
        this.inventoryLocationControllerCollection = inventoryLocationControllerCollection;
    }

    @XmlTransient
    public Collection<StockHistoryManager> getStockHistoryManagerCollection() {
        return stockHistoryManagerCollection;
    }

    public void setStockHistoryManagerCollection(Collection<StockHistoryManager> stockHistoryManagerCollection) {
        this.stockHistoryManagerCollection = stockHistoryManagerCollection;
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
        if (!(object instanceof InventoryController)) {
            return false;
        }
        InventoryController other = (InventoryController) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.InventoryController[ id=" + id + " ]";
    }
    
}
