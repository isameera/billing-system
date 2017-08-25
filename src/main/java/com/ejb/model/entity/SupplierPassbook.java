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
@Table(name = "supplier_passbook")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierPassbook.findAll", query = "SELECT s FROM SupplierPassbook s")
    , @NamedQuery(name = "SupplierPassbook.findById", query = "SELECT s FROM SupplierPassbook s WHERE s.id = :id")
    , @NamedQuery(name = "SupplierPassbook.findByBookNo", query = "SELECT s FROM SupplierPassbook s WHERE s.bookNo = :bookNo")
    , @NamedQuery(name = "SupplierPassbook.findByIssuedDate", query = "SELECT s FROM SupplierPassbook s WHERE s.issuedDate = :issuedDate")
    , @NamedQuery(name = "SupplierPassbook.findByEndDate", query = "SELECT s FROM SupplierPassbook s WHERE s.endDate = :endDate")})
public class SupplierPassbook implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "book_no")
    private String bookNo;
    @Column(name = "issued_date")
    @Temporal(TemporalType.DATE)
    private Date issuedDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Route routeId;
    @JoinColumn(name = "supplier_passbook_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierPassbookStatus supplierPassbookStatusId;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierRegistration supplierRegistrationId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierPassbookId")
    private Collection<RouteCollectedLeaf> routeCollectedLeafCollection;

    public SupplierPassbook() {
    }

    public SupplierPassbook(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    public SupplierPassbookStatus getSupplierPassbookStatusId() {
        return supplierPassbookStatusId;
    }

    public void setSupplierPassbookStatusId(SupplierPassbookStatus supplierPassbookStatusId) {
        this.supplierPassbookStatusId = supplierPassbookStatusId;
    }

    public SupplierRegistration getSupplierRegistrationId() {
        return supplierRegistrationId;
    }

    public void setSupplierRegistrationId(SupplierRegistration supplierRegistrationId) {
        this.supplierRegistrationId = supplierRegistrationId;
    }

    @XmlTransient
    public Collection<RouteCollectedLeaf> getRouteCollectedLeafCollection() {
        return routeCollectedLeafCollection;
    }

    public void setRouteCollectedLeafCollection(Collection<RouteCollectedLeaf> routeCollectedLeafCollection) {
        this.routeCollectedLeafCollection = routeCollectedLeafCollection;
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
        if (!(object instanceof SupplierPassbook)) {
            return false;
        }
        SupplierPassbook other = (SupplierPassbook) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierPassbook[ id=" + id + " ]";
    }
    
}
