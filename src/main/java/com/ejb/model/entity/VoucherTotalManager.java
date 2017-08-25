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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "voucher_total_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VoucherTotalManager.findAll", query = "SELECT v FROM VoucherTotalManager v")
    , @NamedQuery(name = "VoucherTotalManager.findById", query = "SELECT v FROM VoucherTotalManager v WHERE v.id = :id")
    , @NamedQuery(name = "VoucherTotalManager.findByAccumulatedTotal", query = "SELECT v FROM VoucherTotalManager v WHERE v.accumulatedTotal = :accumulatedTotal")
    , @NamedQuery(name = "VoucherTotalManager.findByAccumulatedDiscount", query = "SELECT v FROM VoucherTotalManager v WHERE v.accumulatedDiscount = :accumulatedDiscount")
    , @NamedQuery(name = "VoucherTotalManager.findByAccumulatedDue", query = "SELECT v FROM VoucherTotalManager v WHERE v.accumulatedDue = :accumulatedDue")
    , @NamedQuery(name = "VoucherTotalManager.findByHeaderImageUrl", query = "SELECT v FROM VoucherTotalManager v WHERE v.headerImageUrl = :headerImageUrl")
    , @NamedQuery(name = "VoucherTotalManager.findByFooterImageUrl", query = "SELECT v FROM VoucherTotalManager v WHERE v.footerImageUrl = :footerImageUrl")})
public class VoucherTotalManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accumulated_total")
    private double accumulatedTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accumulated_discount")
    private double accumulatedDiscount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accumulated_due")
    private double accumulatedDue;
    @Size(max = 105)
    @Column(name = "header_image_url")
    private String headerImageUrl;
    @Size(max = 105)
    @Column(name = "footer_image_url")
    private String footerImageUrl;
    @JoinColumn(name = "voucher_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VoucherType voucherTypeId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherMasterId")
    private Collection<Voucher> voucherCollection;

    public VoucherTotalManager() {
    }

    public VoucherTotalManager(Integer id) {
        this.id = id;
    }

    public VoucherTotalManager(Integer id, double accumulatedTotal, double accumulatedDiscount, double accumulatedDue) {
        this.id = id;
        this.accumulatedTotal = accumulatedTotal;
        this.accumulatedDiscount = accumulatedDiscount;
        this.accumulatedDue = accumulatedDue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getAccumulatedTotal() {
        return accumulatedTotal;
    }

    public void setAccumulatedTotal(double accumulatedTotal) {
        this.accumulatedTotal = accumulatedTotal;
    }

    public double getAccumulatedDiscount() {
        return accumulatedDiscount;
    }

    public void setAccumulatedDiscount(double accumulatedDiscount) {
        this.accumulatedDiscount = accumulatedDiscount;
    }

    public double getAccumulatedDue() {
        return accumulatedDue;
    }

    public void setAccumulatedDue(double accumulatedDue) {
        this.accumulatedDue = accumulatedDue;
    }

    public String getHeaderImageUrl() {
        return headerImageUrl;
    }

    public void setHeaderImageUrl(String headerImageUrl) {
        this.headerImageUrl = headerImageUrl;
    }

    public String getFooterImageUrl() {
        return footerImageUrl;
    }

    public void setFooterImageUrl(String footerImageUrl) {
        this.footerImageUrl = footerImageUrl;
    }

    public VoucherType getVoucherTypeId() {
        return voucherTypeId;
    }

    public void setVoucherTypeId(VoucherType voucherTypeId) {
        this.voucherTypeId = voucherTypeId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    @XmlTransient
    public Collection<Voucher> getVoucherCollection() {
        return voucherCollection;
    }

    public void setVoucherCollection(Collection<Voucher> voucherCollection) {
        this.voucherCollection = voucherCollection;
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
        if (!(object instanceof VoucherTotalManager)) {
            return false;
        }
        VoucherTotalManager other = (VoucherTotalManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.VoucherTotalManager[ id=" + id + " ]";
    }
    
}
