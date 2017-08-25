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
@Table(name = "universal_approval_status_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniversalApprovalStatusManager.findAll", query = "SELECT u FROM UniversalApprovalStatusManager u")
    , @NamedQuery(name = "UniversalApprovalStatusManager.findById", query = "SELECT u FROM UniversalApprovalStatusManager u WHERE u.id = :id")
    , @NamedQuery(name = "UniversalApprovalStatusManager.findByName", query = "SELECT u FROM UniversalApprovalStatusManager u WHERE u.name = :name")})
public class UniversalApprovalStatusManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalApprovalStatusManagerId")
    private Collection<SupplierSavingsAccount> supplierSavingsAccountCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalApprovalStatusManagerId")
    private Collection<ComItemRequest> comItemRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalApprovalStatusManagerId")
    private Collection<WelfareManager> welfareManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalApprovalStatusManagerId")
    private Collection<UniversalBoughtleafItemRequest> universalBoughtleafItemRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalApprovalStatusManagerId")
    private Collection<LeaveRequestManager> leaveRequestManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalApprovalStatusManagerId")
    private Collection<SupplierAdvanceRequest> supplierAdvanceRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalApprovalStatusManagerId")
    private Collection<SupplierAdvanceTransferRequest> supplierAdvanceTransferRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commonApprovalStatusId")
    private Collection<RouteCollectedLeafRemovedLog> routeCollectedLeafRemovedLogCollection;

    public UniversalApprovalStatusManager() {
    }

    public UniversalApprovalStatusManager(Integer id) {
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
    public Collection<SupplierSavingsAccount> getSupplierSavingsAccountCollection() {
        return supplierSavingsAccountCollection;
    }

    public void setSupplierSavingsAccountCollection(Collection<SupplierSavingsAccount> supplierSavingsAccountCollection) {
        this.supplierSavingsAccountCollection = supplierSavingsAccountCollection;
    }

    @XmlTransient
    public Collection<ComItemRequest> getComItemRequestCollection() {
        return comItemRequestCollection;
    }

    public void setComItemRequestCollection(Collection<ComItemRequest> comItemRequestCollection) {
        this.comItemRequestCollection = comItemRequestCollection;
    }

    @XmlTransient
    public Collection<WelfareManager> getWelfareManagerCollection() {
        return welfareManagerCollection;
    }

    public void setWelfareManagerCollection(Collection<WelfareManager> welfareManagerCollection) {
        this.welfareManagerCollection = welfareManagerCollection;
    }

    @XmlTransient
    public Collection<UniversalBoughtleafItemRequest> getUniversalBoughtleafItemRequestCollection() {
        return universalBoughtleafItemRequestCollection;
    }

    public void setUniversalBoughtleafItemRequestCollection(Collection<UniversalBoughtleafItemRequest> universalBoughtleafItemRequestCollection) {
        this.universalBoughtleafItemRequestCollection = universalBoughtleafItemRequestCollection;
    }

    @XmlTransient
    public Collection<LeaveRequestManager> getLeaveRequestManagerCollection() {
        return leaveRequestManagerCollection;
    }

    public void setLeaveRequestManagerCollection(Collection<LeaveRequestManager> leaveRequestManagerCollection) {
        this.leaveRequestManagerCollection = leaveRequestManagerCollection;
    }

    @XmlTransient
    public Collection<SupplierAdvanceRequest> getSupplierAdvanceRequestCollection() {
        return supplierAdvanceRequestCollection;
    }

    public void setSupplierAdvanceRequestCollection(Collection<SupplierAdvanceRequest> supplierAdvanceRequestCollection) {
        this.supplierAdvanceRequestCollection = supplierAdvanceRequestCollection;
    }

    @XmlTransient
    public Collection<SupplierAdvanceTransferRequest> getSupplierAdvanceTransferRequestCollection() {
        return supplierAdvanceTransferRequestCollection;
    }

    public void setSupplierAdvanceTransferRequestCollection(Collection<SupplierAdvanceTransferRequest> supplierAdvanceTransferRequestCollection) {
        this.supplierAdvanceTransferRequestCollection = supplierAdvanceTransferRequestCollection;
    }

    @XmlTransient
    public Collection<RouteCollectedLeafRemovedLog> getRouteCollectedLeafRemovedLogCollection() {
        return routeCollectedLeafRemovedLogCollection;
    }

    public void setRouteCollectedLeafRemovedLogCollection(Collection<RouteCollectedLeafRemovedLog> routeCollectedLeafRemovedLogCollection) {
        this.routeCollectedLeafRemovedLogCollection = routeCollectedLeafRemovedLogCollection;
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
        if (!(object instanceof UniversalApprovalStatusManager)) {
            return false;
        }
        UniversalApprovalStatusManager other = (UniversalApprovalStatusManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UniversalApprovalStatusManager[ id=" + id + " ]";
    }
    
}
