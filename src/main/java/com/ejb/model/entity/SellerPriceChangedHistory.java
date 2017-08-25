/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "seller_price_changed_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SellerPriceChangedHistory.findAll", query = "SELECT s FROM SellerPriceChangedHistory s")
    , @NamedQuery(name = "SellerPriceChangedHistory.findById", query = "SELECT s FROM SellerPriceChangedHistory s WHERE s.id = :id")
    , @NamedQuery(name = "SellerPriceChangedHistory.findByDate", query = "SELECT s FROM SellerPriceChangedHistory s WHERE s.date = :date")
    , @NamedQuery(name = "SellerPriceChangedHistory.findByPrice", query = "SELECT s FROM SellerPriceChangedHistory s WHERE s.price = :price")})
public class SellerPriceChangedHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "seller_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SellerItem sellerItemId;

    public SellerPriceChangedHistory() {
    }

    public SellerPriceChangedHistory(Integer id) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public SellerItem getSellerItemId() {
        return sellerItemId;
    }

    public void setSellerItemId(SellerItem sellerItemId) {
        this.sellerItemId = sellerItemId;
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
        if (!(object instanceof SellerPriceChangedHistory)) {
            return false;
        }
        SellerPriceChangedHistory other = (SellerPriceChangedHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SellerPriceChangedHistory[ id=" + id + " ]";
    }
    
}
