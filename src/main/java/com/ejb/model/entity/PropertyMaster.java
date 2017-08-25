/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "property_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PropertyMaster.findAll", query = "SELECT p FROM PropertyMaster p")
    , @NamedQuery(name = "PropertyMaster.findById", query = "SELECT p FROM PropertyMaster p WHERE p.id = :id")
    , @NamedQuery(name = "PropertyMaster.findByRegistrationNo", query = "SELECT p FROM PropertyMaster p WHERE p.registrationNo = :registrationNo")
    , @NamedQuery(name = "PropertyMaster.findByDeedNo", query = "SELECT p FROM PropertyMaster p WHERE p.deedNo = :deedNo")
    , @NamedQuery(name = "PropertyMaster.findByCurrentOwener", query = "SELECT p FROM PropertyMaster p WHERE p.currentOwener = :currentOwener")
    , @NamedQuery(name = "PropertyMaster.findByName", query = "SELECT p FROM PropertyMaster p WHERE p.name = :name")
    , @NamedQuery(name = "PropertyMaster.findByDescription", query = "SELECT p FROM PropertyMaster p WHERE p.description = :description")
    , @NamedQuery(name = "PropertyMaster.findBySize", query = "SELECT p FROM PropertyMaster p WHERE p.size = :size")
    , @NamedQuery(name = "PropertyMaster.findByValue", query = "SELECT p FROM PropertyMaster p WHERE p.value = :value")
    , @NamedQuery(name = "PropertyMaster.findByTotalPropertyIncome", query = "SELECT p FROM PropertyMaster p WHERE p.totalPropertyIncome = :totalPropertyIncome")
    , @NamedQuery(name = "PropertyMaster.findByNo", query = "SELECT p FROM PropertyMaster p WHERE p.no = :no")
    , @NamedQuery(name = "PropertyMaster.findByStreet", query = "SELECT p FROM PropertyMaster p WHERE p.street = :street")
    , @NamedQuery(name = "PropertyMaster.findByCity", query = "SELECT p FROM PropertyMaster p WHERE p.city = :city")})
public class PropertyMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "registration_no")
    private String registrationNo;
    @Size(max = 45)
    @Column(name = "deed_no")
    private String deedNo;
    @Column(name = "current_owener")
    private Integer currentOwener;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 1500)
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "size")
    private Double size;
    @Column(name = "value")
    private Double value;
    @Column(name = "total_property_income")
    private Double totalPropertyIncome;
    @Size(max = 45)
    @Column(name = "no")
    private String no;
    @Size(max = 45)
    @Column(name = "street")
    private String street;
    @Size(max = 45)
    @Column(name = "city")
    private String city;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyMasterId")
    private Collection<PropertyCrop> propertyCropCollection;
    @OneToMany(mappedBy = "parentDeedNo")
    private Collection<PropertyMaster> propertyMasterCollection;
    @JoinColumn(name = "parent_deed_no", referencedColumnName = "id")
    @ManyToOne
    private PropertyMaster parentDeedNo;
    @JoinColumn(name = "property_extend_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PropertyExtendType propertyExtendTypeId;
    @JoinColumn(name = "property_owenership_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PropertyOwenershipType propertyOwenershipTypeId;
    @JoinColumn(name = "property_status_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PropertyStatusType propertyStatusTypeId;
    @JoinColumn(name = "property_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PropertyType propertyTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyMasterId")
    private Collection<OrgPropertyStatus> orgPropertyStatusCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyMasterId")
    private Collection<PropertyOwenershipManager> propertyOwenershipManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyMasterId")
    private Collection<GupProperty> gupPropertyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyMasterId")
    private Collection<SuplierAreaProperty> suplierAreaPropertyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyMasterId")
    private Collection<LoanGuarantorLandDetails> loanGuarantorLandDetailsCollection;

    public PropertyMaster() {
    }

    public PropertyMaster(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getDeedNo() {
        return deedNo;
    }

    public void setDeedNo(String deedNo) {
        this.deedNo = deedNo;
    }

    public Integer getCurrentOwener() {
        return currentOwener;
    }

    public void setCurrentOwener(Integer currentOwener) {
        this.currentOwener = currentOwener;
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

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getTotalPropertyIncome() {
        return totalPropertyIncome;
    }

    public void setTotalPropertyIncome(Double totalPropertyIncome) {
        this.totalPropertyIncome = totalPropertyIncome;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlTransient
    public Collection<PropertyCrop> getPropertyCropCollection() {
        return propertyCropCollection;
    }

    public void setPropertyCropCollection(Collection<PropertyCrop> propertyCropCollection) {
        this.propertyCropCollection = propertyCropCollection;
    }

    @XmlTransient
    public Collection<PropertyMaster> getPropertyMasterCollection() {
        return propertyMasterCollection;
    }

    public void setPropertyMasterCollection(Collection<PropertyMaster> propertyMasterCollection) {
        this.propertyMasterCollection = propertyMasterCollection;
    }

    public PropertyMaster getParentDeedNo() {
        return parentDeedNo;
    }

    public void setParentDeedNo(PropertyMaster parentDeedNo) {
        this.parentDeedNo = parentDeedNo;
    }

    public PropertyExtendType getPropertyExtendTypeId() {
        return propertyExtendTypeId;
    }

    public void setPropertyExtendTypeId(PropertyExtendType propertyExtendTypeId) {
        this.propertyExtendTypeId = propertyExtendTypeId;
    }

    public PropertyOwenershipType getPropertyOwenershipTypeId() {
        return propertyOwenershipTypeId;
    }

    public void setPropertyOwenershipTypeId(PropertyOwenershipType propertyOwenershipTypeId) {
        this.propertyOwenershipTypeId = propertyOwenershipTypeId;
    }

    public PropertyStatusType getPropertyStatusTypeId() {
        return propertyStatusTypeId;
    }

    public void setPropertyStatusTypeId(PropertyStatusType propertyStatusTypeId) {
        this.propertyStatusTypeId = propertyStatusTypeId;
    }

    public PropertyType getPropertyTypeId() {
        return propertyTypeId;
    }

    public void setPropertyTypeId(PropertyType propertyTypeId) {
        this.propertyTypeId = propertyTypeId;
    }

    @XmlTransient
    public Collection<OrgPropertyStatus> getOrgPropertyStatusCollection() {
        return orgPropertyStatusCollection;
    }

    public void setOrgPropertyStatusCollection(Collection<OrgPropertyStatus> orgPropertyStatusCollection) {
        this.orgPropertyStatusCollection = orgPropertyStatusCollection;
    }

    @XmlTransient
    public Collection<PropertyOwenershipManager> getPropertyOwenershipManagerCollection() {
        return propertyOwenershipManagerCollection;
    }

    public void setPropertyOwenershipManagerCollection(Collection<PropertyOwenershipManager> propertyOwenershipManagerCollection) {
        this.propertyOwenershipManagerCollection = propertyOwenershipManagerCollection;
    }

    @XmlTransient
    public Collection<GupProperty> getGupPropertyCollection() {
        return gupPropertyCollection;
    }

    public void setGupPropertyCollection(Collection<GupProperty> gupPropertyCollection) {
        this.gupPropertyCollection = gupPropertyCollection;
    }

    @XmlTransient
    public Collection<SuplierAreaProperty> getSuplierAreaPropertyCollection() {
        return suplierAreaPropertyCollection;
    }

    public void setSuplierAreaPropertyCollection(Collection<SuplierAreaProperty> suplierAreaPropertyCollection) {
        this.suplierAreaPropertyCollection = suplierAreaPropertyCollection;
    }

    @XmlTransient
    public Collection<LoanGuarantorLandDetails> getLoanGuarantorLandDetailsCollection() {
        return loanGuarantorLandDetailsCollection;
    }

    public void setLoanGuarantorLandDetailsCollection(Collection<LoanGuarantorLandDetails> loanGuarantorLandDetailsCollection) {
        this.loanGuarantorLandDetailsCollection = loanGuarantorLandDetailsCollection;
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
        if (!(object instanceof PropertyMaster)) {
            return false;
        }
        PropertyMaster other = (PropertyMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.PropertyMaster[ id=" + id + " ]";
    }
    
}
