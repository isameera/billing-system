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
@Table(name = "inventory_location_controller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventoryLocationController.findAll", query = "SELECT i FROM InventoryLocationController i")
    , @NamedQuery(name = "InventoryLocationController.findById", query = "SELECT i FROM InventoryLocationController i WHERE i.id = :id")
    , @NamedQuery(name = "InventoryLocationController.findByQty", query = "SELECT i FROM InventoryLocationController i WHERE i.qty = :qty")})
public class InventoryLocationController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qty")
    private Double qty;
    @JoinColumn(name = "inventory_controller_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InventoryController inventoryControllerId;
    @JoinColumn(name = "org_location_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrgLocation orgLocationId;

    public InventoryLocationController() {
    }

    public InventoryLocationController(Integer id) {
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

    public InventoryController getInventoryControllerId() {
        return inventoryControllerId;
    }

    public void setInventoryControllerId(InventoryController inventoryControllerId) {
        this.inventoryControllerId = inventoryControllerId;
    }

    public OrgLocation getOrgLocationId() {
        return orgLocationId;
    }

    public void setOrgLocationId(OrgLocation orgLocationId) {
        this.orgLocationId = orgLocationId;
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
        if (!(object instanceof InventoryLocationController)) {
            return false;
        }
        InventoryLocationController other = (InventoryLocationController) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.InventoryLocationController[ id=" + id + " ]";
    }
    
}
