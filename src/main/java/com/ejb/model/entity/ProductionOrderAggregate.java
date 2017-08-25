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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "production_order_aggregate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductionOrderAggregate.findAll", query = "SELECT p FROM ProductionOrderAggregate p")
    , @NamedQuery(name = "ProductionOrderAggregate.findById", query = "SELECT p FROM ProductionOrderAggregate p WHERE p.id = :id")
    , @NamedQuery(name = "ProductionOrderAggregate.findByLineTotalProductionCost", query = "SELECT p FROM ProductionOrderAggregate p WHERE p.lineTotalProductionCost = :lineTotalProductionCost")
    , @NamedQuery(name = "ProductionOrderAggregate.findByLineTotalSales", query = "SELECT p FROM ProductionOrderAggregate p WHERE p.lineTotalSales = :lineTotalSales")
    , @NamedQuery(name = "ProductionOrderAggregate.findByMnuQty", query = "SELECT p FROM ProductionOrderAggregate p WHERE p.mnuQty = :mnuQty")
    , @NamedQuery(name = "ProductionOrderAggregate.findByBalanceQty", query = "SELECT p FROM ProductionOrderAggregate p WHERE p.balanceQty = :balanceQty")})
public class ProductionOrderAggregate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "line_total_production_cost")
    private Double lineTotalProductionCost;
    @Column(name = "line_total_sales")
    private Double lineTotalSales;
    @Column(name = "mnu_qty")
    private Integer mnuQty;
    @Column(name = "balance_qty")
    private Integer balanceQty;
    @JoinColumn(name = "order_product_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrderProduct orderProductId;

    public ProductionOrderAggregate() {
    }

    public ProductionOrderAggregate(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLineTotalProductionCost() {
        return lineTotalProductionCost;
    }

    public void setLineTotalProductionCost(Double lineTotalProductionCost) {
        this.lineTotalProductionCost = lineTotalProductionCost;
    }

    public Double getLineTotalSales() {
        return lineTotalSales;
    }

    public void setLineTotalSales(Double lineTotalSales) {
        this.lineTotalSales = lineTotalSales;
    }

    public Integer getMnuQty() {
        return mnuQty;
    }

    public void setMnuQty(Integer mnuQty) {
        this.mnuQty = mnuQty;
    }

    public Integer getBalanceQty() {
        return balanceQty;
    }

    public void setBalanceQty(Integer balanceQty) {
        this.balanceQty = balanceQty;
    }

    public OrderProduct getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(OrderProduct orderProductId) {
        this.orderProductId = orderProductId;
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
        if (!(object instanceof ProductionOrderAggregate)) {
            return false;
        }
        ProductionOrderAggregate other = (ProductionOrderAggregate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ProductionOrderAggregate[ id=" + id + " ]";
    }
    
}
