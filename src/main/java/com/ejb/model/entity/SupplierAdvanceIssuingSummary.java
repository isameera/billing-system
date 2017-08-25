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
@Table(name = "supplier_advance_issuing_summary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierAdvanceIssuingSummary.findAll", query = "SELECT s FROM SupplierAdvanceIssuingSummary s")
    , @NamedQuery(name = "SupplierAdvanceIssuingSummary.findById", query = "SELECT s FROM SupplierAdvanceIssuingSummary s WHERE s.id = :id")
    , @NamedQuery(name = "SupplierAdvanceIssuingSummary.findByDate", query = "SELECT s FROM SupplierAdvanceIssuingSummary s WHERE s.date = :date")
    , @NamedQuery(name = "SupplierAdvanceIssuingSummary.findByListId", query = "SELECT s FROM SupplierAdvanceIssuingSummary s WHERE s.listId = :listId")
    , @NamedQuery(name = "SupplierAdvanceIssuingSummary.findByHandOverTo", query = "SELECT s FROM SupplierAdvanceIssuingSummary s WHERE s.handOverTo = :handOverTo")
    , @NamedQuery(name = "SupplierAdvanceIssuingSummary.findByYear", query = "SELECT s FROM SupplierAdvanceIssuingSummary s WHERE s.year = :year")
    , @NamedQuery(name = "SupplierAdvanceIssuingSummary.findByMonth", query = "SELECT s FROM SupplierAdvanceIssuingSummary s WHERE s.month = :month")})
public class SupplierAdvanceIssuingSummary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 45)
    @Column(name = "list_id")
    private String listId;
    @Size(max = 255)
    @Column(name = "hand_over_to")
    private String handOverTo;
    @Column(name = "year")
    private Integer year;
    @Column(name = "month")
    private Integer month;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierAdvanceIssuingSummaryId")
    private Collection<SupplierAdvanceIssuingSummaryDetails> supplierAdvanceIssuingSummaryDetailsCollection;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Route routeId;
    @JoinColumn(name = "sub_chart_of_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SubChartOfAccount subChartOfAccountId;
    @JoinColumn(name = "universal_payment_mode_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalPaymentMode universalPaymentModeId;

    public SupplierAdvanceIssuingSummary() {
    }

    public SupplierAdvanceIssuingSummary(Integer id) {
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

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getHandOverTo() {
        return handOverTo;
    }

    public void setHandOverTo(String handOverTo) {
        this.handOverTo = handOverTo;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @XmlTransient
    public Collection<SupplierAdvanceIssuingSummaryDetails> getSupplierAdvanceIssuingSummaryDetailsCollection() {
        return supplierAdvanceIssuingSummaryDetailsCollection;
    }

    public void setSupplierAdvanceIssuingSummaryDetailsCollection(Collection<SupplierAdvanceIssuingSummaryDetails> supplierAdvanceIssuingSummaryDetailsCollection) {
        this.supplierAdvanceIssuingSummaryDetailsCollection = supplierAdvanceIssuingSummaryDetailsCollection;
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

    public SubChartOfAccount getSubChartOfAccountId() {
        return subChartOfAccountId;
    }

    public void setSubChartOfAccountId(SubChartOfAccount subChartOfAccountId) {
        this.subChartOfAccountId = subChartOfAccountId;
    }

    public UniversalPaymentMode getUniversalPaymentModeId() {
        return universalPaymentModeId;
    }

    public void setUniversalPaymentModeId(UniversalPaymentMode universalPaymentModeId) {
        this.universalPaymentModeId = universalPaymentModeId;
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
        if (!(object instanceof SupplierAdvanceIssuingSummary)) {
            return false;
        }
        SupplierAdvanceIssuingSummary other = (SupplierAdvanceIssuingSummary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierAdvanceIssuingSummary[ id=" + id + " ]";
    }
    
}
