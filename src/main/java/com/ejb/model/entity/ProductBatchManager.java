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
@Table(name = "product_batch_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductBatchManager.findAll", query = "SELECT p FROM ProductBatchManager p")
    , @NamedQuery(name = "ProductBatchManager.findById", query = "SELECT p FROM ProductBatchManager p WHERE p.id = :id")
    , @NamedQuery(name = "ProductBatchManager.findByBatchId", query = "SELECT p FROM ProductBatchManager p WHERE p.batchId = :batchId")
    , @NamedQuery(name = "ProductBatchManager.findByBatchCompletedDate", query = "SELECT p FROM ProductBatchManager p WHERE p.batchCompletedDate = :batchCompletedDate")
    , @NamedQuery(name = "ProductBatchManager.findByQty", query = "SELECT p FROM ProductBatchManager p WHERE p.qty = :qty")
    , @NamedQuery(name = "ProductBatchManager.findBySerialNoFrom", query = "SELECT p FROM ProductBatchManager p WHERE p.serialNoFrom = :serialNoFrom")
    , @NamedQuery(name = "ProductBatchManager.findBySerialNoTo", query = "SELECT p FROM ProductBatchManager p WHERE p.serialNoTo = :serialNoTo")})
public class ProductBatchManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "batch_id")
    private String batchId;
    @Column(name = "batch_completed_date")
    @Temporal(TemporalType.DATE)
    private Date batchCompletedDate;
    @Column(name = "qty")
    private Integer qty;
    @Size(max = 45)
    @Column(name = "serial_no_from")
    private String serialNoFrom;
    @Size(max = 45)
    @Column(name = "serial_no_to")
    private String serialNoTo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productBatchManagerId")
    private Collection<SerialNo> serialNoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productBatchManagerId")
    private Collection<ProductBatchLineManager> productBatchLineManagerCollection;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "item_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemMaster itemMasterId;
    @JoinColumn(name = "production_advice_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductionAdvice productionAdviceId;

    public ProductBatchManager() {
    }

    public ProductBatchManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public Date getBatchCompletedDate() {
        return batchCompletedDate;
    }

    public void setBatchCompletedDate(Date batchCompletedDate) {
        this.batchCompletedDate = batchCompletedDate;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getSerialNoFrom() {
        return serialNoFrom;
    }

    public void setSerialNoFrom(String serialNoFrom) {
        this.serialNoFrom = serialNoFrom;
    }

    public String getSerialNoTo() {
        return serialNoTo;
    }

    public void setSerialNoTo(String serialNoTo) {
        this.serialNoTo = serialNoTo;
    }

    @XmlTransient
    public Collection<SerialNo> getSerialNoCollection() {
        return serialNoCollection;
    }

    public void setSerialNoCollection(Collection<SerialNo> serialNoCollection) {
        this.serialNoCollection = serialNoCollection;
    }

    @XmlTransient
    public Collection<ProductBatchLineManager> getProductBatchLineManagerCollection() {
        return productBatchLineManagerCollection;
    }

    public void setProductBatchLineManagerCollection(Collection<ProductBatchLineManager> productBatchLineManagerCollection) {
        this.productBatchLineManagerCollection = productBatchLineManagerCollection;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public ItemMaster getItemMasterId() {
        return itemMasterId;
    }

    public void setItemMasterId(ItemMaster itemMasterId) {
        this.itemMasterId = itemMasterId;
    }

    public ProductionAdvice getProductionAdviceId() {
        return productionAdviceId;
    }

    public void setProductionAdviceId(ProductionAdvice productionAdviceId) {
        this.productionAdviceId = productionAdviceId;
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
        if (!(object instanceof ProductBatchManager)) {
            return false;
        }
        ProductBatchManager other = (ProductBatchManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ProductBatchManager[ id=" + id + " ]";
    }
    
}
