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
@Table(name = "item_packaging")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemPackaging.findAll", query = "SELECT i FROM ItemPackaging i")
    , @NamedQuery(name = "ItemPackaging.findById", query = "SELECT i FROM ItemPackaging i WHERE i.id = :id")
    , @NamedQuery(name = "ItemPackaging.findByDate", query = "SELECT i FROM ItemPackaging i WHERE i.date = :date")
    , @NamedQuery(name = "ItemPackaging.findByNoOfPackages", query = "SELECT i FROM ItemPackaging i WHERE i.noOfPackages = :noOfPackages")
    , @NamedQuery(name = "ItemPackaging.findByWeight", query = "SELECT i FROM ItemPackaging i WHERE i.weight = :weight")})
public class ItemPackaging implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "no_of_packages")
    private Double noOfPackages;
    @Column(name = "weight")
    private Double weight;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "pack_received_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile packReceivedBy;
    @JoinColumn(name = "packed_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile packedBy;
    @JoinColumn(name = "item_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemMaster itemMasterId;
    @JoinColumn(name = "package_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PackageType packageTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemPackagingId")
    private Collection<PackageGradingManager> packageGradingManagerCollection;

    public ItemPackaging() {
    }

    public ItemPackaging(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getNoOfPackages() {
        return noOfPackages;
    }

    public void setNoOfPackages(Double noOfPackages) {
        this.noOfPackages = noOfPackages;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public GeneralOrganizationProfile getPackReceivedBy() {
        return packReceivedBy;
    }

    public void setPackReceivedBy(GeneralOrganizationProfile packReceivedBy) {
        this.packReceivedBy = packReceivedBy;
    }

    public GeneralUserProfile getPackedBy() {
        return packedBy;
    }

    public void setPackedBy(GeneralUserProfile packedBy) {
        this.packedBy = packedBy;
    }

    public ItemMaster getItemMasterId() {
        return itemMasterId;
    }

    public void setItemMasterId(ItemMaster itemMasterId) {
        this.itemMasterId = itemMasterId;
    }

    public PackageType getPackageTypeId() {
        return packageTypeId;
    }

    public void setPackageTypeId(PackageType packageTypeId) {
        this.packageTypeId = packageTypeId;
    }

    @XmlTransient
    public Collection<PackageGradingManager> getPackageGradingManagerCollection() {
        return packageGradingManagerCollection;
    }

    public void setPackageGradingManagerCollection(Collection<PackageGradingManager> packageGradingManagerCollection) {
        this.packageGradingManagerCollection = packageGradingManagerCollection;
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
        if (!(object instanceof ItemPackaging)) {
            return false;
        }
        ItemPackaging other = (ItemPackaging) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ItemPackaging[ id=" + id + " ]";
    }
    
}
