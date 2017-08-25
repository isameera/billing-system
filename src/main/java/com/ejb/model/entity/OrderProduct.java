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
@Table(name = "order_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderProduct.findAll", query = "SELECT o FROM OrderProduct o")
    , @NamedQuery(name = "OrderProduct.findById", query = "SELECT o FROM OrderProduct o WHERE o.id = :id")
    , @NamedQuery(name = "OrderProduct.findByQty", query = "SELECT o FROM OrderProduct o WHERE o.qty = :qty")
    , @NamedQuery(name = "OrderProduct.findByIsCompleted", query = "SELECT o FROM OrderProduct o WHERE o.isCompleted = :isCompleted")})
public class OrderProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "qty")
    private Integer qty;
    @Column(name = "is_completed")
    private Integer isCompleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderProductId")
    private Collection<ProductionOrderAggregate> productionOrderAggregateCollection;
    @JoinColumn(name = "item_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemMaster itemMasterId;
    @JoinColumn(name = "order_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrderMaster orderMasterId;

    public OrderProduct() {
    }

    public OrderProduct(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Integer isCompleted) {
        this.isCompleted = isCompleted;
    }

    @XmlTransient
    public Collection<ProductionOrderAggregate> getProductionOrderAggregateCollection() {
        return productionOrderAggregateCollection;
    }

    public void setProductionOrderAggregateCollection(Collection<ProductionOrderAggregate> productionOrderAggregateCollection) {
        this.productionOrderAggregateCollection = productionOrderAggregateCollection;
    }

    public ItemMaster getItemMasterId() {
        return itemMasterId;
    }

    public void setItemMasterId(ItemMaster itemMasterId) {
        this.itemMasterId = itemMasterId;
    }

    public OrderMaster getOrderMasterId() {
        return orderMasterId;
    }

    public void setOrderMasterId(OrderMaster orderMasterId) {
        this.orderMasterId = orderMasterId;
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
        if (!(object instanceof OrderProduct)) {
            return false;
        }
        OrderProduct other = (OrderProduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.OrderProduct[ id=" + id + " ]";
    }
    
}
