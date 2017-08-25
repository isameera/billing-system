/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "advance_request_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdvanceRequestItem.findAll", query = "SELECT a FROM AdvanceRequestItem a")
    , @NamedQuery(name = "AdvanceRequestItem.findById", query = "SELECT a FROM AdvanceRequestItem a WHERE a.id = :id")
    , @NamedQuery(name = "AdvanceRequestItem.findByName", query = "SELECT a FROM AdvanceRequestItem a WHERE a.name = :name")
    , @NamedQuery(name = "AdvanceRequestItem.findByQty", query = "SELECT a FROM AdvanceRequestItem a WHERE a.qty = :qty")
    , @NamedQuery(name = "AdvanceRequestItem.findByRate", query = "SELECT a FROM AdvanceRequestItem a WHERE a.rate = :rate")
    , @NamedQuery(name = "AdvanceRequestItem.findByLineTotal", query = "SELECT a FROM AdvanceRequestItem a WHERE a.lineTotal = :lineTotal")})
public class AdvanceRequestItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qty")
    private Double qty;
    @Column(name = "rate")
    private Double rate;
    @Column(name = "line_total")
    private Double lineTotal;
    @JoinColumn(name = "advance_request_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AdvanceRequest advanceRequestId;
    @JoinColumn(name = "advance_request_item_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AdvanceRequestItemType advanceRequestItemTypeId;
    @JoinColumn(name = "org_unit_of_measure_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrgUnitOfMeasure orgUnitOfMeasureId;

    public AdvanceRequestItem() {
    }

    public AdvanceRequestItem(Integer id) {
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

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(Double lineTotal) {
        this.lineTotal = lineTotal;
    }

    public AdvanceRequest getAdvanceRequestId() {
        return advanceRequestId;
    }

    public void setAdvanceRequestId(AdvanceRequest advanceRequestId) {
        this.advanceRequestId = advanceRequestId;
    }

    public AdvanceRequestItemType getAdvanceRequestItemTypeId() {
        return advanceRequestItemTypeId;
    }

    public void setAdvanceRequestItemTypeId(AdvanceRequestItemType advanceRequestItemTypeId) {
        this.advanceRequestItemTypeId = advanceRequestItemTypeId;
    }

    public OrgUnitOfMeasure getOrgUnitOfMeasureId() {
        return orgUnitOfMeasureId;
    }

    public void setOrgUnitOfMeasureId(OrgUnitOfMeasure orgUnitOfMeasureId) {
        this.orgUnitOfMeasureId = orgUnitOfMeasureId;
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
        if (!(object instanceof AdvanceRequestItem)) {
            return false;
        }
        AdvanceRequestItem other = (AdvanceRequestItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.AdvanceRequestItem[ id=" + id + " ]";
    }
    
}
