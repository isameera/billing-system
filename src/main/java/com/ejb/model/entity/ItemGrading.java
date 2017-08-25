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
@Table(name = "item_grading")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemGrading.findAll", query = "SELECT i FROM ItemGrading i")
    , @NamedQuery(name = "ItemGrading.findById", query = "SELECT i FROM ItemGrading i WHERE i.id = :id")
    , @NamedQuery(name = "ItemGrading.findByDate", query = "SELECT i FROM ItemGrading i WHERE i.date = :date")})
public class ItemGrading implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemGradingId")
    private Collection<PackageGradingManager> packageGradingManagerCollection;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "grading_officer", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile gradingOfficer;
    @JoinColumn(name = "inked_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile inkedBy;
    @JoinColumn(name = "incharge", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile incharge;
    @JoinColumn(name = "item_grading_registration_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemGradingRegistration itemGradingRegistrationId;

    public ItemGrading() {
    }

    public ItemGrading(Integer id) {
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

    @XmlTransient
    public Collection<PackageGradingManager> getPackageGradingManagerCollection() {
        return packageGradingManagerCollection;
    }

    public void setPackageGradingManagerCollection(Collection<PackageGradingManager> packageGradingManagerCollection) {
        this.packageGradingManagerCollection = packageGradingManagerCollection;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public GeneralUserProfile getGradingOfficer() {
        return gradingOfficer;
    }

    public void setGradingOfficer(GeneralUserProfile gradingOfficer) {
        this.gradingOfficer = gradingOfficer;
    }

    public GeneralUserProfile getInkedBy() {
        return inkedBy;
    }

    public void setInkedBy(GeneralUserProfile inkedBy) {
        this.inkedBy = inkedBy;
    }

    public GeneralUserProfile getIncharge() {
        return incharge;
    }

    public void setIncharge(GeneralUserProfile incharge) {
        this.incharge = incharge;
    }

    public ItemGradingRegistration getItemGradingRegistrationId() {
        return itemGradingRegistrationId;
    }

    public void setItemGradingRegistrationId(ItemGradingRegistration itemGradingRegistrationId) {
        this.itemGradingRegistrationId = itemGradingRegistrationId;
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
        if (!(object instanceof ItemGrading)) {
            return false;
        }
        ItemGrading other = (ItemGrading) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ItemGrading[ id=" + id + " ]";
    }
    
}
