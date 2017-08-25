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
@Table(name = "tax_type_product_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaxTypeProductManager.findAll", query = "SELECT t FROM TaxTypeProductManager t")
    , @NamedQuery(name = "TaxTypeProductManager.findById", query = "SELECT t FROM TaxTypeProductManager t WHERE t.id = :id")})
public class TaxTypeProductManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "percentag_for_tax_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PercentagForTaxCategory percentagForTaxCategoryId;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemMaster productId;
    @JoinColumn(name = "tax_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TaxType taxTypeId;

    public TaxTypeProductManager() {
    }

    public TaxTypeProductManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PercentagForTaxCategory getPercentagForTaxCategoryId() {
        return percentagForTaxCategoryId;
    }

    public void setPercentagForTaxCategoryId(PercentagForTaxCategory percentagForTaxCategoryId) {
        this.percentagForTaxCategoryId = percentagForTaxCategoryId;
    }

    public ItemMaster getProductId() {
        return productId;
    }

    public void setProductId(ItemMaster productId) {
        this.productId = productId;
    }

    public TaxType getTaxTypeId() {
        return taxTypeId;
    }

    public void setTaxTypeId(TaxType taxTypeId) {
        this.taxTypeId = taxTypeId;
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
        if (!(object instanceof TaxTypeProductManager)) {
            return false;
        }
        TaxTypeProductManager other = (TaxTypeProductManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.TaxTypeProductManager[ id=" + id + " ]";
    }
    
}
