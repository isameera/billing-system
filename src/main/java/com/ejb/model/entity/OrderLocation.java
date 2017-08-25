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
@Table(name = "order_location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderLocation.findAll", query = "SELECT o FROM OrderLocation o")
    , @NamedQuery(name = "OrderLocation.findById", query = "SELECT o FROM OrderLocation o WHERE o.id = :id")})
public class OrderLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "order_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrderMaster orderMasterId;
    @JoinColumn(name = "org_item_location_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrgLocation orgItemLocationId;

    public OrderLocation() {
    }

    public OrderLocation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderMaster getOrderMasterId() {
        return orderMasterId;
    }

    public void setOrderMasterId(OrderMaster orderMasterId) {
        this.orderMasterId = orderMasterId;
    }

    public OrgLocation getOrgItemLocationId() {
        return orgItemLocationId;
    }

    public void setOrgItemLocationId(OrgLocation orgItemLocationId) {
        this.orgItemLocationId = orgItemLocationId;
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
        if (!(object instanceof OrderLocation)) {
            return false;
        }
        OrderLocation other = (OrderLocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.OrderLocation[ id=" + id + " ]";
    }
    
}
