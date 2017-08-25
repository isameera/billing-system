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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "item_supplier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemSupplier.findAll", query = "SELECT i FROM ItemSupplier i")
    , @NamedQuery(name = "ItemSupplier.findById", query = "SELECT i FROM ItemSupplier i WHERE i.id = :id")
    , @NamedQuery(name = "ItemSupplier.findByReferenceId", query = "SELECT i FROM ItemSupplier i WHERE i.referenceId = :referenceId")
    , @NamedQuery(name = "ItemSupplier.findByRegDate", query = "SELECT i FROM ItemSupplier i WHERE i.regDate = :regDate")
    , @NamedQuery(name = "ItemSupplier.findByDiscountRate", query = "SELECT i FROM ItemSupplier i WHERE i.discountRate = :discountRate")
    , @NamedQuery(name = "ItemSupplier.findByLeadTime", query = "SELECT i FROM ItemSupplier i WHERE i.leadTime = :leadTime")
    , @NamedQuery(name = "ItemSupplier.findByMaximumCreditPeriod", query = "SELECT i FROM ItemSupplier i WHERE i.maximumCreditPeriod = :maximumCreditPeriod")
    , @NamedQuery(name = "ItemSupplier.findByInitialCreditPeriod", query = "SELECT i FROM ItemSupplier i WHERE i.initialCreditPeriod = :initialCreditPeriod")
    , @NamedQuery(name = "ItemSupplier.findBySecondCreditPeriod", query = "SELECT i FROM ItemSupplier i WHERE i.secondCreditPeriod = :secondCreditPeriod")
    , @NamedQuery(name = "ItemSupplier.findByCreditPricePercentage", query = "SELECT i FROM ItemSupplier i WHERE i.creditPricePercentage = :creditPricePercentage")
    , @NamedQuery(name = "ItemSupplier.findByCashPricePercentage", query = "SELECT i FROM ItemSupplier i WHERE i.cashPricePercentage = :cashPricePercentage")})
public class ItemSupplier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "reference_id")
    private Integer referenceId;
    @Column(name = "reg_date")
    @Temporal(TemporalType.DATE)
    private Date regDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "discount_rate")
    private Double discountRate;
    @Column(name = "lead_time")
    private Integer leadTime;
    @Column(name = "maximum_credit_period")
    private Integer maximumCreditPeriod;
    @Column(name = "initial_ credit_period")
    private Integer initialCreditPeriod;
    @Column(name = "second_ credit_period")
    private Integer secondCreditPeriod;
    @Column(name = "credit_price_percentage")
    private Double creditPricePercentage;
    @Column(name = "cash_price_percentage")
    private Double cashPricePercentage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemSupplierId")
    private Collection<ItemSupplierTypes> itemSupplierTypesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemSupplierId")
    private Collection<SupplierItemManager> supplierItemManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemSupplierId")
    private Collection<OrgItemPurchsedDetail> orgItemPurchsedDetailCollection;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "item_supplier_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemSupplierType itemSupplierTypeId;
    @JoinColumn(name = "universal_person_or_org_type_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId;

    public ItemSupplier() {
    }

    public ItemSupplier(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Integer referenceId) {
        this.referenceId = referenceId;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    public Integer getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(Integer leadTime) {
        this.leadTime = leadTime;
    }

    public Integer getMaximumCreditPeriod() {
        return maximumCreditPeriod;
    }

    public void setMaximumCreditPeriod(Integer maximumCreditPeriod) {
        this.maximumCreditPeriod = maximumCreditPeriod;
    }

    public Integer getInitialCreditPeriod() {
        return initialCreditPeriod;
    }

    public void setInitialCreditPeriod(Integer initialCreditPeriod) {
        this.initialCreditPeriod = initialCreditPeriod;
    }

    public Integer getSecondCreditPeriod() {
        return secondCreditPeriod;
    }

    public void setSecondCreditPeriod(Integer secondCreditPeriod) {
        this.secondCreditPeriod = secondCreditPeriod;
    }

    public Double getCreditPricePercentage() {
        return creditPricePercentage;
    }

    public void setCreditPricePercentage(Double creditPricePercentage) {
        this.creditPricePercentage = creditPricePercentage;
    }

    public Double getCashPricePercentage() {
        return cashPricePercentage;
    }

    public void setCashPricePercentage(Double cashPricePercentage) {
        this.cashPricePercentage = cashPricePercentage;
    }

    @XmlTransient
    public Collection<ItemSupplierTypes> getItemSupplierTypesCollection() {
        return itemSupplierTypesCollection;
    }

    public void setItemSupplierTypesCollection(Collection<ItemSupplierTypes> itemSupplierTypesCollection) {
        this.itemSupplierTypesCollection = itemSupplierTypesCollection;
    }

    @XmlTransient
    public Collection<SupplierItemManager> getSupplierItemManagerCollection() {
        return supplierItemManagerCollection;
    }

    public void setSupplierItemManagerCollection(Collection<SupplierItemManager> supplierItemManagerCollection) {
        this.supplierItemManagerCollection = supplierItemManagerCollection;
    }

    @XmlTransient
    public Collection<OrgItemPurchsedDetail> getOrgItemPurchsedDetailCollection() {
        return orgItemPurchsedDetailCollection;
    }

    public void setOrgItemPurchsedDetailCollection(Collection<OrgItemPurchsedDetail> orgItemPurchsedDetailCollection) {
        this.orgItemPurchsedDetailCollection = orgItemPurchsedDetailCollection;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public ItemSupplierType getItemSupplierTypeId() {
        return itemSupplierTypeId;
    }

    public void setItemSupplierTypeId(ItemSupplierType itemSupplierTypeId) {
        this.itemSupplierTypeId = itemSupplierTypeId;
    }

    public UniversalPersonOrOrgTypeManager getUniversalPersonOrOrgTypeManagerId() {
        return universalPersonOrOrgTypeManagerId;
    }

    public void setUniversalPersonOrOrgTypeManagerId(UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId) {
        this.universalPersonOrOrgTypeManagerId = universalPersonOrOrgTypeManagerId;
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
        if (!(object instanceof ItemSupplier)) {
            return false;
        }
        ItemSupplier other = (ItemSupplier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ItemSupplier[ id=" + id + " ]";
    }
    
}
