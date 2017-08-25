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
@Table(name = "product_batch_line_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductBatchLineManager.findAll", query = "SELECT p FROM ProductBatchLineManager p")
    , @NamedQuery(name = "ProductBatchLineManager.findById", query = "SELECT p FROM ProductBatchLineManager p WHERE p.id = :id")})
public class ProductBatchLineManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "product_batch_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductBatchManager productBatchManagerId;
    @JoinColumn(name = "production_line_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductionLine productionLineId;

    public ProductBatchLineManager() {
    }

    public ProductBatchLineManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductBatchManager getProductBatchManagerId() {
        return productBatchManagerId;
    }

    public void setProductBatchManagerId(ProductBatchManager productBatchManagerId) {
        this.productBatchManagerId = productBatchManagerId;
    }

    public ProductionLine getProductionLineId() {
        return productionLineId;
    }

    public void setProductionLineId(ProductionLine productionLineId) {
        this.productionLineId = productionLineId;
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
        if (!(object instanceof ProductBatchLineManager)) {
            return false;
        }
        ProductBatchLineManager other = (ProductBatchLineManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ProductBatchLineManager[ id=" + id + " ]";
    }
    
}
