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
@Table(name = "production_advice_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductionAdviceManager.findAll", query = "SELECT p FROM ProductionAdviceManager p")
    , @NamedQuery(name = "ProductionAdviceManager.findById", query = "SELECT p FROM ProductionAdviceManager p WHERE p.id = :id")})
public class ProductionAdviceManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "production_advice_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductionAdvice productionAdviceId;
    @JoinColumn(name = "production_request_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductionRequest productionRequestId;

    public ProductionAdviceManager() {
    }

    public ProductionAdviceManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductionAdvice getProductionAdviceId() {
        return productionAdviceId;
    }

    public void setProductionAdviceId(ProductionAdvice productionAdviceId) {
        this.productionAdviceId = productionAdviceId;
    }

    public ProductionRequest getProductionRequestId() {
        return productionRequestId;
    }

    public void setProductionRequestId(ProductionRequest productionRequestId) {
        this.productionRequestId = productionRequestId;
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
        if (!(object instanceof ProductionAdviceManager)) {
            return false;
        }
        ProductionAdviceManager other = (ProductionAdviceManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ProductionAdviceManager[ id=" + id + " ]";
    }
    
}
