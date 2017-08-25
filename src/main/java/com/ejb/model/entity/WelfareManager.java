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
@Table(name = "welfare_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WelfareManager.findAll", query = "SELECT w FROM WelfareManager w")
    , @NamedQuery(name = "WelfareManager.findById", query = "SELECT w FROM WelfareManager w WHERE w.id = :id")
    , @NamedQuery(name = "WelfareManager.findByRequstedDate", query = "SELECT w FROM WelfareManager w WHERE w.requstedDate = :requstedDate")
    , @NamedQuery(name = "WelfareManager.findByRegDate", query = "SELECT w FROM WelfareManager w WHERE w.regDate = :regDate")
    , @NamedQuery(name = "WelfareManager.findByDueAmount", query = "SELECT w FROM WelfareManager w WHERE w.dueAmount = :dueAmount")})
public class WelfareManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "requsted_date")
    @Temporal(TemporalType.DATE)
    private Date requstedDate;
    @Column(name = "reg_date")
    @Temporal(TemporalType.DATE)
    private Date regDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "due_amount")
    private Double dueAmount;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne
    private SupplierRegistration supplierRegistrationId;
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    @ManyToOne
    private Route routeId;
    @JoinColumn(name = "universal_approval_status_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalApprovalStatusManager universalApprovalStatusManagerId;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "gup_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GupType gupTypeId;
    @JoinColumn(name = "welfare_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private WelfareStatus welfareStatusId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "welfareManagerId")
    private Collection<WelfareActiveInactiveHistory> welfareActiveInactiveHistoryCollection;

    public WelfareManager() {
    }

    public WelfareManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRequstedDate() {
        return requstedDate;
    }

    public void setRequstedDate(Date requstedDate) {
        this.requstedDate = requstedDate;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public SupplierRegistration getSupplierRegistrationId() {
        return supplierRegistrationId;
    }

    public void setSupplierRegistrationId(SupplierRegistration supplierRegistrationId) {
        this.supplierRegistrationId = supplierRegistrationId;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    public UniversalApprovalStatusManager getUniversalApprovalStatusManagerId() {
        return universalApprovalStatusManagerId;
    }

    public void setUniversalApprovalStatusManagerId(UniversalApprovalStatusManager universalApprovalStatusManagerId) {
        this.universalApprovalStatusManagerId = universalApprovalStatusManagerId;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
    }

    public GupType getGupTypeId() {
        return gupTypeId;
    }

    public void setGupTypeId(GupType gupTypeId) {
        this.gupTypeId = gupTypeId;
    }

    public WelfareStatus getWelfareStatusId() {
        return welfareStatusId;
    }

    public void setWelfareStatusId(WelfareStatus welfareStatusId) {
        this.welfareStatusId = welfareStatusId;
    }

    @XmlTransient
    public Collection<WelfareActiveInactiveHistory> getWelfareActiveInactiveHistoryCollection() {
        return welfareActiveInactiveHistoryCollection;
    }

    public void setWelfareActiveInactiveHistoryCollection(Collection<WelfareActiveInactiveHistory> welfareActiveInactiveHistoryCollection) {
        this.welfareActiveInactiveHistoryCollection = welfareActiveInactiveHistoryCollection;
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
        if (!(object instanceof WelfareManager)) {
            return false;
        }
        WelfareManager other = (WelfareManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.WelfareManager[ id=" + id + " ]";
    }
    
}
