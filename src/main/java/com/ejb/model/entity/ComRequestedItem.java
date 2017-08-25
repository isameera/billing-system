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
@Table(name = "com_requested_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComRequestedItem.findAll", query = "SELECT c FROM ComRequestedItem c")
    , @NamedQuery(name = "ComRequestedItem.findById", query = "SELECT c FROM ComRequestedItem c WHERE c.id = :id")
    , @NamedQuery(name = "ComRequestedItem.findByQty", query = "SELECT c FROM ComRequestedItem c WHERE c.qty = :qty")
    , @NamedQuery(name = "ComRequestedItem.findByApprovedQty", query = "SELECT c FROM ComRequestedItem c WHERE c.approvedQty = :approvedQty")
    , @NamedQuery(name = "ComRequestedItem.findByIsCompleted", query = "SELECT c FROM ComRequestedItem c WHERE c.isCompleted = :isCompleted")})
public class ComRequestedItem implements Serializable {

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
    private Boolean isCompleted;
    @JoinColumn(name = "com_item_request_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ComItemRequest comItemRequestId;
    @JoinColumn(name = "org_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrgItem orgItemId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comRequestedItemId")
    private Collection<ComRequistedItemIssue> comRequistedItemIssueCollection;

    public ComRequestedItem() {
    }

    public ComRequestedItem(Integer id) {
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

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public ComItemRequest getComItemRequestId() {
        return comItemRequestId;
    }

    public void setComItemRequestId(ComItemRequest comItemRequestId) {
        this.comItemRequestId = comItemRequestId;
    }

    public OrgItem getOrgItemId() {
        return orgItemId;
    }

    public void setOrgItemId(OrgItem orgItemId) {
        this.orgItemId = orgItemId;
    }

    @XmlTransient
    public Collection<ComRequistedItemIssue> getComRequistedItemIssueCollection() {
        return comRequistedItemIssueCollection;
    }

    public void setComRequistedItemIssueCollection(Collection<ComRequistedItemIssue> comRequistedItemIssueCollection) {
        this.comRequistedItemIssueCollection = comRequistedItemIssueCollection;
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
        if (!(object instanceof ComRequestedItem)) {
            return false;
        }
        ComRequestedItem other = (ComRequestedItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ComRequestedItem[ id=" + id + " ]";
    }
    
}
