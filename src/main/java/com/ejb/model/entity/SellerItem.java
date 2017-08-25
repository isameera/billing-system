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
@Table(name = "seller_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SellerItem.findAll", query = "SELECT s FROM SellerItem s")
    , @NamedQuery(name = "SellerItem.findById", query = "SELECT s FROM SellerItem s WHERE s.id = :id")
    , @NamedQuery(name = "SellerItem.findByRate", query = "SELECT s FROM SellerItem s WHERE s.rate = :rate")})
public class SellerItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rate")
    private Double rate;
    @JoinColumn(name = "org_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrgItem orgItemId;
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Seller sellerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellerItemId")
    private Collection<SellerPriceChangedHistory> sellerPriceChangedHistoryCollection;

    public SellerItem() {
    }

    public SellerItem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public OrgItem getOrgItemId() {
        return orgItemId;
    }

    public void setOrgItemId(OrgItem orgItemId) {
        this.orgItemId = orgItemId;
    }

    public Seller getSellerId() {
        return sellerId;
    }

    public void setSellerId(Seller sellerId) {
        this.sellerId = sellerId;
    }

    @XmlTransient
    public Collection<SellerPriceChangedHistory> getSellerPriceChangedHistoryCollection() {
        return sellerPriceChangedHistoryCollection;
    }

    public void setSellerPriceChangedHistoryCollection(Collection<SellerPriceChangedHistory> sellerPriceChangedHistoryCollection) {
        this.sellerPriceChangedHistoryCollection = sellerPriceChangedHistoryCollection;
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
        if (!(object instanceof SellerItem)) {
            return false;
        }
        SellerItem other = (SellerItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SellerItem[ id=" + id + " ]";
    }
    
}
