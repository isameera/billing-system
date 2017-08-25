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
@Table(name = "org_location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrgLocation.findAll", query = "SELECT o FROM OrgLocation o")
    , @NamedQuery(name = "OrgLocation.findById", query = "SELECT o FROM OrgLocation o WHERE o.id = :id")
    , @NamedQuery(name = "OrgLocation.findByName", query = "SELECT o FROM OrgLocation o WHERE o.name = :name")})
public class OrgLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 450)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgLocationId")
    private Collection<OrgItemLocation> orgItemLocationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgItemLocationId")
    private Collection<OrderLocation> orderLocationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgLocationId")
    private Collection<VoucherItemLocationManager> voucherItemLocationManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgLocationId")
    private Collection<EmployeeItemLocation> employeeItemLocationCollection;
    @OneToMany(mappedBy = "orgLocationId")
    private Collection<OrgLocation> orgLocationCollection;
    @JoinColumn(name = "org_location_id", referencedColumnName = "id")
    @ManyToOne
    private OrgLocation orgLocationId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "org_location_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrgLocationType orgLocationTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgLocationId")
    private Collection<InventoryLocationController> inventoryLocationControllerCollection;

    public OrgLocation() {
    }

    public OrgLocation(Integer id) {
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

    @XmlTransient
    public Collection<OrgItemLocation> getOrgItemLocationCollection() {
        return orgItemLocationCollection;
    }

    public void setOrgItemLocationCollection(Collection<OrgItemLocation> orgItemLocationCollection) {
        this.orgItemLocationCollection = orgItemLocationCollection;
    }

    @XmlTransient
    public Collection<OrderLocation> getOrderLocationCollection() {
        return orderLocationCollection;
    }

    public void setOrderLocationCollection(Collection<OrderLocation> orderLocationCollection) {
        this.orderLocationCollection = orderLocationCollection;
    }

    @XmlTransient
    public Collection<VoucherItemLocationManager> getVoucherItemLocationManagerCollection() {
        return voucherItemLocationManagerCollection;
    }

    public void setVoucherItemLocationManagerCollection(Collection<VoucherItemLocationManager> voucherItemLocationManagerCollection) {
        this.voucherItemLocationManagerCollection = voucherItemLocationManagerCollection;
    }

    @XmlTransient
    public Collection<EmployeeItemLocation> getEmployeeItemLocationCollection() {
        return employeeItemLocationCollection;
    }

    public void setEmployeeItemLocationCollection(Collection<EmployeeItemLocation> employeeItemLocationCollection) {
        this.employeeItemLocationCollection = employeeItemLocationCollection;
    }

    @XmlTransient
    public Collection<OrgLocation> getOrgLocationCollection() {
        return orgLocationCollection;
    }

    public void setOrgLocationCollection(Collection<OrgLocation> orgLocationCollection) {
        this.orgLocationCollection = orgLocationCollection;
    }

    public OrgLocation getOrgLocationId() {
        return orgLocationId;
    }

    public void setOrgLocationId(OrgLocation orgLocationId) {
        this.orgLocationId = orgLocationId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public OrgLocationType getOrgLocationTypeId() {
        return orgLocationTypeId;
    }

    public void setOrgLocationTypeId(OrgLocationType orgLocationTypeId) {
        this.orgLocationTypeId = orgLocationTypeId;
    }

    @XmlTransient
    public Collection<InventoryLocationController> getInventoryLocationControllerCollection() {
        return inventoryLocationControllerCollection;
    }

    public void setInventoryLocationControllerCollection(Collection<InventoryLocationController> inventoryLocationControllerCollection) {
        this.inventoryLocationControllerCollection = inventoryLocationControllerCollection;
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
        if (!(object instanceof OrgLocation)) {
            return false;
        }
        OrgLocation other = (OrgLocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.OrgLocation[ id=" + id + " ]";
    }
    
}
