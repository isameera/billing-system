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
@Table(name = "production_request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductionRequest.findAll", query = "SELECT p FROM ProductionRequest p")
    , @NamedQuery(name = "ProductionRequest.findById", query = "SELECT p FROM ProductionRequest p WHERE p.id = :id")
    , @NamedQuery(name = "ProductionRequest.findByRequstId", query = "SELECT p FROM ProductionRequest p WHERE p.requstId = :requstId")
    , @NamedQuery(name = "ProductionRequest.findByReference", query = "SELECT p FROM ProductionRequest p WHERE p.reference = :reference")
    , @NamedQuery(name = "ProductionRequest.findByDate", query = "SELECT p FROM ProductionRequest p WHERE p.date = :date")
    , @NamedQuery(name = "ProductionRequest.findByExpectedDate", query = "SELECT p FROM ProductionRequest p WHERE p.expectedDate = :expectedDate")
    , @NamedQuery(name = "ProductionRequest.findByIsCompleted", query = "SELECT p FROM ProductionRequest p WHERE p.isCompleted = :isCompleted")})
public class ProductionRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "requst_id")
    private String requstId;
    @Column(name = "reference")
    private Integer reference;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "expected_date")
    @Temporal(TemporalType.DATE)
    private Date expectedDate;
    @Column(name = "is_completed")
    private Integer isCompleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productionRequestId")
    private Collection<ProductionAdviceManager> productionAdviceManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productionRequestId")
    private Collection<DeliveryNoteManager> deliveryNoteManagerCollection;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "universal_person_or_org_type_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId;
    @JoinColumn(name = "user_login_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserLogin userLoginId;

    public ProductionRequest() {
    }

    public ProductionRequest(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequstId() {
        return requstId;
    }

    public void setRequstId(String requstId) {
        this.requstId = requstId;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public Integer getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Integer isCompleted) {
        this.isCompleted = isCompleted;
    }

    @XmlTransient
    public Collection<ProductionAdviceManager> getProductionAdviceManagerCollection() {
        return productionAdviceManagerCollection;
    }

    public void setProductionAdviceManagerCollection(Collection<ProductionAdviceManager> productionAdviceManagerCollection) {
        this.productionAdviceManagerCollection = productionAdviceManagerCollection;
    }

    @XmlTransient
    public Collection<DeliveryNoteManager> getDeliveryNoteManagerCollection() {
        return deliveryNoteManagerCollection;
    }

    public void setDeliveryNoteManagerCollection(Collection<DeliveryNoteManager> deliveryNoteManagerCollection) {
        this.deliveryNoteManagerCollection = deliveryNoteManagerCollection;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public UniversalPersonOrOrgTypeManager getUniversalPersonOrOrgTypeManagerId() {
        return universalPersonOrOrgTypeManagerId;
    }

    public void setUniversalPersonOrOrgTypeManagerId(UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId) {
        this.universalPersonOrOrgTypeManagerId = universalPersonOrOrgTypeManagerId;
    }

    public UserLogin getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(UserLogin userLoginId) {
        this.userLoginId = userLoginId;
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
        if (!(object instanceof ProductionRequest)) {
            return false;
        }
        ProductionRequest other = (ProductionRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ProductionRequest[ id=" + id + " ]";
    }
    
}
