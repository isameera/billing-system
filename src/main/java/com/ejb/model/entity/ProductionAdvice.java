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
@Table(name = "production_advice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductionAdvice.findAll", query = "SELECT p FROM ProductionAdvice p")
    , @NamedQuery(name = "ProductionAdvice.findById", query = "SELECT p FROM ProductionAdvice p WHERE p.id = :id")
    , @NamedQuery(name = "ProductionAdvice.findByAdviceId", query = "SELECT p FROM ProductionAdvice p WHERE p.adviceId = :adviceId")
    , @NamedQuery(name = "ProductionAdvice.findByDate", query = "SELECT p FROM ProductionAdvice p WHERE p.date = :date")
    , @NamedQuery(name = "ProductionAdvice.findByStartDate", query = "SELECT p FROM ProductionAdvice p WHERE p.startDate = :startDate")
    , @NamedQuery(name = "ProductionAdvice.findByEndDate", query = "SELECT p FROM ProductionAdvice p WHERE p.endDate = :endDate")
    , @NamedQuery(name = "ProductionAdvice.findByTotalProductionCost", query = "SELECT p FROM ProductionAdvice p WHERE p.totalProductionCost = :totalProductionCost")
    , @NamedQuery(name = "ProductionAdvice.findByTotalSalesValue", query = "SELECT p FROM ProductionAdvice p WHERE p.totalSalesValue = :totalSalesValue")})
public class ProductionAdvice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "advice_id")
    private String adviceId;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_production_cost")
    private Double totalProductionCost;
    @Column(name = "total_sales_value")
    private Double totalSalesValue;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productionAdviceId")
    private Collection<ProductionAdviceManager> productionAdviceManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productionAdviceId")
    private Collection<ProductBatchManager> productBatchManagerCollection;
    @JoinColumn(name = "adviced_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee advicedBy;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;

    public ProductionAdvice() {
    }

    public ProductionAdvice(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(String adviceId) {
        this.adviceId = adviceId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Double getTotalSalesValue() {
        return totalSalesValue;
    }

    public void setTotalSalesValue(Double totalSalesValue) {
        this.totalSalesValue = totalSalesValue;
    }

    @XmlTransient
    public Collection<ProductionAdviceManager> getProductionAdviceManagerCollection() {
        return productionAdviceManagerCollection;
    }

    public void setProductionAdviceManagerCollection(Collection<ProductionAdviceManager> productionAdviceManagerCollection) {
        this.productionAdviceManagerCollection = productionAdviceManagerCollection;
    }

    @XmlTransient
    public Collection<ProductBatchManager> getProductBatchManagerCollection() {
        return productBatchManagerCollection;
    }

    public void setProductBatchManagerCollection(Collection<ProductBatchManager> productBatchManagerCollection) {
        this.productBatchManagerCollection = productBatchManagerCollection;
    }

    public Employee getAdvicedBy() {
        return advicedBy;
    }

    public void setAdvicedBy(Employee advicedBy) {
        this.advicedBy = advicedBy;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
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
        if (!(object instanceof ProductionAdvice)) {
            return false;
        }
        ProductionAdvice other = (ProductionAdvice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ProductionAdvice[ id=" + id + " ]";
    }
    
}
