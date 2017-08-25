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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "price_level")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PriceLevel.findAll", query = "SELECT p FROM PriceLevel p")
    , @NamedQuery(name = "PriceLevel.findById", query = "SELECT p FROM PriceLevel p WHERE p.id = :id")
    , @NamedQuery(name = "PriceLevel.findByName", query = "SELECT p FROM PriceLevel p WHERE p.name = :name")
    , @NamedQuery(name = "PriceLevel.findByPrice", query = "SELECT p FROM PriceLevel p WHERE p.price = :price")
    , @NamedQuery(name = "PriceLevel.findByIsDefault", query = "SELECT p FROM PriceLevel p WHERE p.isDefault = :isDefault")})
public class PriceLevel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Column(name = "is_default")
    private Integer isDefault;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "priceLevelId")
    private Collection<ItemUomPrice> itemUomPriceCollection;
    @JoinColumn(name = "org_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrgItem orgItemId;

    public PriceLevel() {
    }

    public PriceLevel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    @XmlTransient
    public Collection<ItemUomPrice> getItemUomPriceCollection() {
        return itemUomPriceCollection;
    }

    public void setItemUomPriceCollection(Collection<ItemUomPrice> itemUomPriceCollection) {
        this.itemUomPriceCollection = itemUomPriceCollection;
    }

    public OrgItem getOrgItemId() {
        return orgItemId;
    }

    public void setOrgItemId(OrgItem orgItemId) {
        this.orgItemId = orgItemId;
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
        if (!(object instanceof PriceLevel)) {
            return false;
        }
        PriceLevel other = (PriceLevel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.PriceLevel[ id=" + id + " ]";
    }
    
}
