/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "route_collected_leaf_removed_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RouteCollectedLeafRemovedLog.findAll", query = "SELECT r FROM RouteCollectedLeafRemovedLog r")
    , @NamedQuery(name = "RouteCollectedLeafRemovedLog.findById", query = "SELECT r FROM RouteCollectedLeafRemovedLog r WHERE r.id = :id")
    , @NamedQuery(name = "RouteCollectedLeafRemovedLog.findByRequestedDate", query = "SELECT r FROM RouteCollectedLeafRemovedLog r WHERE r.requestedDate = :requestedDate")
    , @NamedQuery(name = "RouteCollectedLeafRemovedLog.findByApprovedDate", query = "SELECT r FROM RouteCollectedLeafRemovedLog r WHERE r.approvedDate = :approvedDate")})
public class RouteCollectedLeafRemovedLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "requested_date")
    @Temporal(TemporalType.DATE)
    private Date requestedDate;
    @Column(name = "approved_date")
    @Temporal(TemporalType.DATE)
    private Date approvedDate;
    @JoinColumn(name = "requested_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee requestedBy;
    @JoinColumn(name = "approved_by", referencedColumnName = "id")
    @ManyToOne
    private Employee approvedBy;
    @JoinColumn(name = "common_approval_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalApprovalStatusManager commonApprovalStatusId;
    @JoinColumn(name = "route_collected_leaf_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RouteCollectedLeaf routeCollectedLeafId;

    public RouteCollectedLeafRemovedLog() {
    }

    public RouteCollectedLeafRemovedLog(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public Employee getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(Employee requestedBy) {
        this.requestedBy = requestedBy;
    }

    public Employee getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Employee approvedBy) {
        this.approvedBy = approvedBy;
    }

    public UniversalApprovalStatusManager getCommonApprovalStatusId() {
        return commonApprovalStatusId;
    }

    public void setCommonApprovalStatusId(UniversalApprovalStatusManager commonApprovalStatusId) {
        this.commonApprovalStatusId = commonApprovalStatusId;
    }

    public RouteCollectedLeaf getRouteCollectedLeafId() {
        return routeCollectedLeafId;
    }

    public void setRouteCollectedLeafId(RouteCollectedLeaf routeCollectedLeafId) {
        this.routeCollectedLeafId = routeCollectedLeafId;
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
        if (!(object instanceof RouteCollectedLeafRemovedLog)) {
            return false;
        }
        RouteCollectedLeafRemovedLog other = (RouteCollectedLeafRemovedLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.RouteCollectedLeafRemovedLog[ id=" + id + " ]";
    }
    
}
