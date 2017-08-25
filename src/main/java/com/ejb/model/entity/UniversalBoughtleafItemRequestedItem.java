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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "universal_boughtleaf_item_requested_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniversalBoughtleafItemRequestedItem.findAll", query = "SELECT u FROM UniversalBoughtleafItemRequestedItem u")
    , @NamedQuery(name = "UniversalBoughtleafItemRequestedItem.findById", query = "SELECT u FROM UniversalBoughtleafItemRequestedItem u WHERE u.id = :id")
    , @NamedQuery(name = "UniversalBoughtleafItemRequestedItem.findByQty", query = "SELECT u FROM UniversalBoughtleafItemRequestedItem u WHERE u.qty = :qty")
    , @NamedQuery(name = "UniversalBoughtleafItemRequestedItem.findByApprovedQty", query = "SELECT u FROM UniversalBoughtleafItemRequestedItem u WHERE u.approvedQty = :approvedQty")
    , @NamedQuery(name = "UniversalBoughtleafItemRequestedItem.findByIsCompleted", query = "SELECT u FROM UniversalBoughtleafItemRequestedItem u WHERE u.isCompleted = :isCompleted")})
public class UniversalBoughtleafItemRequestedItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qty")
    private Double qty;
    @Column(name = "approved_qty")
    private Double approvedQty;
    @Column(name = "is_completed")
    private Integer isCompleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalBoughtleafItemRequestedItemId")
    private Collection<UniversalBoughtleafItemIssue> universalBoughtleafItemIssueCollection;
    @JoinColumn(name = "universal_boughtleaf_item_request_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalBoughtleafItemRequest universalBoughtleafItemRequestId;
    @JoinColumn(name = "org_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrgItem orgItemId;

    public UniversalBoughtleafItemRequestedItem() {
    }

    public UniversalBoughtleafItemRequestedItem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getApprovedQty() {
        return approvedQty;
    }

    public void setApprovedQty(Double approvedQty) {
        this.approvedQty = approvedQty;
    }

    public Integer getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Integer isCompleted) {
        this.isCompleted = isCompleted;
    }

    @XmlTransient
    public Collection<UniversalBoughtleafItemIssue> getUniversalBoughtleafItemIssueCollection() {
        return universalBoughtleafItemIssueCollection;
    }

    public void setUniversalBoughtleafItemIssueCollection(Collection<UniversalBoughtleafItemIssue> universalBoughtleafItemIssueCollection) {
        this.universalBoughtleafItemIssueCollection = universalBoughtleafItemIssueCollection;
    }

    public UniversalBoughtleafItemRequest getUniversalBoughtleafItemRequestId() {
        return universalBoughtleafItemRequestId;
    }

    public void setUniversalBoughtleafItemRequestId(UniversalBoughtleafItemRequest universalBoughtleafItemRequestId) {
        this.universalBoughtleafItemRequestId = universalBoughtleafItemRequestId;
    }

    public OrgItem getOrgItemId() {
        return orgItemId;
    }

    public void setOrgItemId(OrgItem orgItemId) {
        this.orgItemId = orgItemId;
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
        if (!(object instanceof UniversalBoughtleafItemRequestedItem)) {
            return false;
        }
        UniversalBoughtleafItemRequestedItem other = (UniversalBoughtleafItemRequestedItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UniversalBoughtleafItemRequestedItem[ id=" + id + " ]";
    }
    
}
