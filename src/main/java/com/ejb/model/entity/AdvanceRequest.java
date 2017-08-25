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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "advance_request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdvanceRequest.findAll", query = "SELECT a FROM AdvanceRequest a")
    , @NamedQuery(name = "AdvanceRequest.findById", query = "SELECT a FROM AdvanceRequest a WHERE a.id = :id")
    , @NamedQuery(name = "AdvanceRequest.findByDate", query = "SELECT a FROM AdvanceRequest a WHERE a.date = :date")
    , @NamedQuery(name = "AdvanceRequest.findByTotalAmount", query = "SELECT a FROM AdvanceRequest a WHERE a.totalAmount = :totalAmount")
    , @NamedQuery(name = "AdvanceRequest.findByConstructionSiteLocationId", query = "SELECT a FROM AdvanceRequest a WHERE a.constructionSiteLocationId = :constructionSiteLocationId")})
public class AdvanceRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_amount")
    private Double totalAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "construction_site_location_id")
    private int constructionSiteLocationId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "advanceRequestId")
    private Collection<AdvanceRequestItem> advanceRequestItemCollection;
    @JoinColumn(name = "advance_request_division_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AdvanceRequestDivision advanceRequestDivisionId;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;

    public AdvanceRequest() {
    }

    public AdvanceRequest(Integer id) {
        this.id = id;
    }

    public AdvanceRequest(Integer id, int constructionSiteLocationId) {
        this.id = id;
        this.constructionSiteLocationId = constructionSiteLocationId;
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

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getConstructionSiteLocationId() {
        return constructionSiteLocationId;
    }

    public void setConstructionSiteLocationId(int constructionSiteLocationId) {
        this.constructionSiteLocationId = constructionSiteLocationId;
    }

    @XmlTransient
    public Collection<AdvanceRequestItem> getAdvanceRequestItemCollection() {
        return advanceRequestItemCollection;
    }

    public void setAdvanceRequestItemCollection(Collection<AdvanceRequestItem> advanceRequestItemCollection) {
        this.advanceRequestItemCollection = advanceRequestItemCollection;
    }

    public AdvanceRequestDivision getAdvanceRequestDivisionId() {
        return advanceRequestDivisionId;
    }

    public void setAdvanceRequestDivisionId(AdvanceRequestDivision advanceRequestDivisionId) {
        this.advanceRequestDivisionId = advanceRequestDivisionId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
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
        if (!(object instanceof AdvanceRequest)) {
            return false;
        }
        AdvanceRequest other = (AdvanceRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.AdvanceRequest[ id=" + id + " ]";
    }
    
}
