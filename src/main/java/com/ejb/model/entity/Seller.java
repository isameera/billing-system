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
@Table(name = "seller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seller.findAll", query = "SELECT s FROM Seller s")
    , @NamedQuery(name = "Seller.findById", query = "SELECT s FROM Seller s WHERE s.id = :id")
    , @NamedQuery(name = "Seller.findByReference", query = "SELECT s FROM Seller s WHERE s.reference = :reference")
    , @NamedQuery(name = "Seller.findByRegDate", query = "SELECT s FROM Seller s WHERE s.regDate = :regDate")
    , @NamedQuery(name = "Seller.findByCode", query = "SELECT s FROM Seller s WHERE s.code = :code")})
public class Seller implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "reference")
    private Integer reference;
    @Column(name = "reg_date")
    @Temporal(TemporalType.DATE)
    private Date regDate;
    @Size(max = 255)
    @Column(name = "code")
    private String code;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellerId")
    private Collection<SellerItem> sellerItemCollection;
    @JoinColumn(name = "executive", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee executive;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @OneToMany(mappedBy = "sellerId")
    private Collection<Seller> sellerCollection;
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    @ManyToOne
    private Seller sellerId;
    @JoinColumn(name = "seller_area_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SellerArea sellerAreaId;
    @JoinColumn(name = "seller_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SellerType sellerTypeId;
    @JoinColumn(name = "universal_person_or_org_type_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId;

    public Seller() {
    }

    public Seller(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlTransient
    public Collection<SellerItem> getSellerItemCollection() {
        return sellerItemCollection;
    }

    public void setSellerItemCollection(Collection<SellerItem> sellerItemCollection) {
        this.sellerItemCollection = sellerItemCollection;
    }

    public Employee getExecutive() {
        return executive;
    }

    public void setExecutive(Employee executive) {
        this.executive = executive;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    @XmlTransient
    public Collection<Seller> getSellerCollection() {
        return sellerCollection;
    }

    public void setSellerCollection(Collection<Seller> sellerCollection) {
        this.sellerCollection = sellerCollection;
    }

    public Seller getSellerId() {
        return sellerId;
    }

    public void setSellerId(Seller sellerId) {
        this.sellerId = sellerId;
    }

    public SellerArea getSellerAreaId() {
        return sellerAreaId;
    }

    public void setSellerAreaId(SellerArea sellerAreaId) {
        this.sellerAreaId = sellerAreaId;
    }

    public SellerType getSellerTypeId() {
        return sellerTypeId;
    }

    public void setSellerTypeId(SellerType sellerTypeId) {
        this.sellerTypeId = sellerTypeId;
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
        if (!(object instanceof Seller)) {
            return false;
        }
        Seller other = (Seller) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.Seller[ id=" + id + " ]";
    }
    
}
