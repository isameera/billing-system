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
@Table(name = "order_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderMaster.findAll", query = "SELECT o FROM OrderMaster o")
    , @NamedQuery(name = "OrderMaster.findById", query = "SELECT o FROM OrderMaster o WHERE o.id = :id")
    , @NamedQuery(name = "OrderMaster.findByOrderId", query = "SELECT o FROM OrderMaster o WHERE o.orderId = :orderId")
    , @NamedQuery(name = "OrderMaster.findByStartDate", query = "SELECT o FROM OrderMaster o WHERE o.startDate = :startDate")
    , @NamedQuery(name = "OrderMaster.findByEndDate", query = "SELECT o FROM OrderMaster o WHERE o.endDate = :endDate")
    , @NamedQuery(name = "OrderMaster.findByTotalProductionCost", query = "SELECT o FROM OrderMaster o WHERE o.totalProductionCost = :totalProductionCost")
    , @NamedQuery(name = "OrderMaster.findByTotalSales", query = "SELECT o FROM OrderMaster o WHERE o.totalSales = :totalSales")
    , @NamedQuery(name = "OrderMaster.findByDate", query = "SELECT o FROM OrderMaster o WHERE o.date = :date")
    , @NamedQuery(name = "OrderMaster.findByDeliveryDate", query = "SELECT o FROM OrderMaster o WHERE o.deliveryDate = :deliveryDate")})
public class OrderMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_production_cost")
    private Double totalProductionCost;
    @Column(name = "total_sales")
    private Double totalSales;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "delivery_date")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderMasterId")
    private Collection<OrderLocation> orderLocationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderMasterId")
    private Collection<OrderProduct> orderProductCollection;
    @JoinColumn(name = "order_from", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile orderFrom;
    @JoinColumn(name = "order_to", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile orderTo;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "order_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrderStatus orderStatusId;
    @JoinColumn(name = "order_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrderType orderTypeId;

    public OrderMaster() {
    }

    public OrderMaster(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getTotalProductionCost() {
        return totalProductionCost;
    }

    public void setTotalProductionCost(Double totalProductionCost) {
        this.totalProductionCost = totalProductionCost;
    }

    public Double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Double totalSales) {
        this.totalSales = totalSales;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @XmlTransient
    public Collection<OrderLocation> getOrderLocationCollection() {
        return orderLocationCollection;
    }

    public void setOrderLocationCollection(Collection<OrderLocation> orderLocationCollection) {
        this.orderLocationCollection = orderLocationCollection;
    }

    @XmlTransient
    public Collection<OrderProduct> getOrderProductCollection() {
        return orderProductCollection;
    }

    public void setOrderProductCollection(Collection<OrderProduct> orderProductCollection) {
        this.orderProductCollection = orderProductCollection;
    }

    public GeneralOrganizationProfile getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(GeneralOrganizationProfile orderFrom) {
        this.orderFrom = orderFrom;
    }

    public GeneralOrganizationProfile getOrderTo() {
        return orderTo;
    }

    public void setOrderTo(GeneralOrganizationProfile orderTo) {
        this.orderTo = orderTo;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
    }

    public OrderStatus getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(OrderStatus orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public OrderType getOrderTypeId() {
        return orderTypeId;
    }

    public void setOrderTypeId(OrderType orderTypeId) {
        this.orderTypeId = orderTypeId;
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
        if (!(object instanceof OrderMaster)) {
            return false;
        }
        OrderMaster other = (OrderMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.OrderMaster[ id=" + id + " ]";
    }
    
}
