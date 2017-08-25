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
@Table(name = "factory_collected_leaf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FactoryCollectedLeaf.findAll", query = "SELECT f FROM FactoryCollectedLeaf f")
    , @NamedQuery(name = "FactoryCollectedLeaf.findById", query = "SELECT f FROM FactoryCollectedLeaf f WHERE f.id = :id")
    , @NamedQuery(name = "FactoryCollectedLeaf.findByCollectedDate", query = "SELECT f FROM FactoryCollectedLeaf f WHERE f.collectedDate = :collectedDate")
    , @NamedQuery(name = "FactoryCollectedLeaf.findByOtherWeight", query = "SELECT f FROM FactoryCollectedLeaf f WHERE f.otherWeight = :otherWeight")
    , @NamedQuery(name = "FactoryCollectedLeaf.findByReturnPackgeCount", query = "SELECT f FROM FactoryCollectedLeaf f WHERE f.returnPackgeCount = :returnPackgeCount")})
public class FactoryCollectedLeaf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "collected_date")
    @Temporal(TemporalType.DATE)
    private Date collectedDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "other_weight")
    private Double otherWeight;
    @Column(name = "return_packge_count")
    private Integer returnPackgeCount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factoryCollectedLeafId")
    private Collection<FactoryCollectedLeafConfirmation> factoryCollectedLeafConfirmationCollection;
    @JoinColumn(name = "collected_leaf_confirmation_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FactoryCollectedLeafStatus collectedLeafConfirmationStatusId;
    @JoinColumn(name = "leaf_received_from_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LeafReceivedFrom leafReceivedFromId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "leaf_collection_common_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LeafCollectionCommon leafCollectionCommonId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factoryCollectedLeafId")
    private Collection<FactoryCollectedLeafByRoute> factoryCollectedLeafByRouteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factoryCollectedLeafId")
    private Collection<FactoryCollectedLeafBySupplier> factoryCollectedLeafBySupplierCollection;

    public FactoryCollectedLeaf() {
    }

    public FactoryCollectedLeaf(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCollectedDate() {
        return collectedDate;
    }

    public void setCollectedDate(Date collectedDate) {
        this.collectedDate = collectedDate;
    }

    public Double getOtherWeight() {
        return otherWeight;
    }

    public void setOtherWeight(Double otherWeight) {
        this.otherWeight = otherWeight;
    }

    public Integer getReturnPackgeCount() {
        return returnPackgeCount;
    }

    public void setReturnPackgeCount(Integer returnPackgeCount) {
        this.returnPackgeCount = returnPackgeCount;
    }

    @XmlTransient
    public Collection<FactoryCollectedLeafConfirmation> getFactoryCollectedLeafConfirmationCollection() {
        return factoryCollectedLeafConfirmationCollection;
    }

    public void setFactoryCollectedLeafConfirmationCollection(Collection<FactoryCollectedLeafConfirmation> factoryCollectedLeafConfirmationCollection) {
        this.factoryCollectedLeafConfirmationCollection = factoryCollectedLeafConfirmationCollection;
    }

    public FactoryCollectedLeafStatus getCollectedLeafConfirmationStatusId() {
        return collectedLeafConfirmationStatusId;
    }

    public void setCollectedLeafConfirmationStatusId(FactoryCollectedLeafStatus collectedLeafConfirmationStatusId) {
        this.collectedLeafConfirmationStatusId = collectedLeafConfirmationStatusId;
    }

    public LeafReceivedFrom getLeafReceivedFromId() {
        return leafReceivedFromId;
    }

    public void setLeafReceivedFromId(LeafReceivedFrom leafReceivedFromId) {
        this.leafReceivedFromId = leafReceivedFromId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public LeafCollectionCommon getLeafCollectionCommonId() {
        return leafCollectionCommonId;
    }

    public void setLeafCollectionCommonId(LeafCollectionCommon leafCollectionCommonId) {
        this.leafCollectionCommonId = leafCollectionCommonId;
    }

    @XmlTransient
    public Collection<FactoryCollectedLeafByRoute> getFactoryCollectedLeafByRouteCollection() {
        return factoryCollectedLeafByRouteCollection;
    }

    public void setFactoryCollectedLeafByRouteCollection(Collection<FactoryCollectedLeafByRoute> factoryCollectedLeafByRouteCollection) {
        this.factoryCollectedLeafByRouteCollection = factoryCollectedLeafByRouteCollection;
    }

    @XmlTransient
    public Collection<FactoryCollectedLeafBySupplier> getFactoryCollectedLeafBySupplierCollection() {
        return factoryCollectedLeafBySupplierCollection;
    }

    public void setFactoryCollectedLeafBySupplierCollection(Collection<FactoryCollectedLeafBySupplier> factoryCollectedLeafBySupplierCollection) {
        this.factoryCollectedLeafBySupplierCollection = factoryCollectedLeafBySupplierCollection;
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
        if (!(object instanceof FactoryCollectedLeaf)) {
            return false;
        }
        FactoryCollectedLeaf other = (FactoryCollectedLeaf) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.FactoryCollectedLeaf[ id=" + id + " ]";
    }
    
}
