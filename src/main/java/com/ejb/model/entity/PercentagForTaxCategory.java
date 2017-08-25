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
@Table(name = "percentag_for_tax_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PercentagForTaxCategory.findAll", query = "SELECT p FROM PercentagForTaxCategory p")
    , @NamedQuery(name = "PercentagForTaxCategory.findById", query = "SELECT p FROM PercentagForTaxCategory p WHERE p.id = :id")
    , @NamedQuery(name = "PercentagForTaxCategory.findByPercentage", query = "SELECT p FROM PercentagForTaxCategory p WHERE p.percentage = :percentage")})
public class PercentagForTaxCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "percentage")
    private Double percentage;
    @JoinColumn(name = "tax_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TaxCategory taxCategoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "percentagForTaxCategoryId")
    private Collection<TaxTypeProductManager> taxTypeProductManagerCollection;

    public PercentagForTaxCategory() {
    }

    public PercentagForTaxCategory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public TaxCategory getTaxCategoryId() {
        return taxCategoryId;
    }

    public void setTaxCategoryId(TaxCategory taxCategoryId) {
        this.taxCategoryId = taxCategoryId;
    }

    @XmlTransient
    public Collection<TaxTypeProductManager> getTaxTypeProductManagerCollection() {
        return taxTypeProductManagerCollection;
    }

    public void setTaxTypeProductManagerCollection(Collection<TaxTypeProductManager> taxTypeProductManagerCollection) {
        this.taxTypeProductManagerCollection = taxTypeProductManagerCollection;
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
        if (!(object instanceof PercentagForTaxCategory)) {
            return false;
        }
        PercentagForTaxCategory other = (PercentagForTaxCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.PercentagForTaxCategory[ id=" + id + " ]";
    }
    
}
