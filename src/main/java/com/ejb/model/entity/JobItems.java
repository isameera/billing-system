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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "job_items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobItems.findAll", query = "SELECT j FROM JobItems j")
    , @NamedQuery(name = "JobItems.findById", query = "SELECT j FROM JobItems j WHERE j.id = :id")
    , @NamedQuery(name = "JobItems.findByQuantity", query = "SELECT j FROM JobItems j WHERE j.quantity = :quantity")
    , @NamedQuery(name = "JobItems.findByUnitPrice", query = "SELECT j FROM JobItems j WHERE j.unitPrice = :unitPrice")
    , @NamedQuery(name = "JobItems.findByDiscount", query = "SELECT j FROM JobItems j WHERE j.discount = :discount")
    , @NamedQuery(name = "JobItems.findByLineTotal", query = "SELECT j FROM JobItems j WHERE j.lineTotal = :lineTotal")
    , @NamedQuery(name = "JobItems.findByIsFinished", query = "SELECT j FROM JobItems j WHERE j.isFinished = :isFinished")})
public class JobItems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "unit_price")
    private Double unitPrice;
    @Column(name = "discount")
    private Double discount;
    @Column(name = "line_total")
    private Double lineTotal;
    @Column(name = "is_finished")
    private Boolean isFinished;
    @JoinColumn(name = "item_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemCategory itemCategoryId;
    @JoinColumn(name = "job_card_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private JobCard jobCardId;
    @JoinColumn(name = "org_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrgItem orgItemId;

    public JobItems() {
    }

    public JobItems(Integer id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(Double lineTotal) {
        this.lineTotal = lineTotal;
    }

    public Boolean getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Boolean isFinished) {
        this.isFinished = isFinished;
    }

    public ItemCategory getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(ItemCategory itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    public JobCard getJobCardId() {
        return jobCardId;
    }

    public void setJobCardId(JobCard jobCardId) {
        this.jobCardId = jobCardId;
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
        if (!(object instanceof JobItems)) {
            return false;
        }
        JobItems other = (JobItems) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.JobItems[ id=" + id + " ]";
    }
    
}
