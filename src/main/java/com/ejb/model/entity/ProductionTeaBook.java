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
@Table(name = "production_tea_book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductionTeaBook.findAll", query = "SELECT p FROM ProductionTeaBook p")
    , @NamedQuery(name = "ProductionTeaBook.findById", query = "SELECT p FROM ProductionTeaBook p WHERE p.id = :id")
    , @NamedQuery(name = "ProductionTeaBook.findByDate", query = "SELECT p FROM ProductionTeaBook p WHERE p.date = :date")
    , @NamedQuery(name = "ProductionTeaBook.findByGreenLeafQty", query = "SELECT p FROM ProductionTeaBook p WHERE p.greenLeafQty = :greenLeafQty")
    , @NamedQuery(name = "ProductionTeaBook.findByFireTeaQty", query = "SELECT p FROM ProductionTeaBook p WHERE p.fireTeaQty = :fireTeaQty")
    , @NamedQuery(name = "ProductionTeaBook.findByRefusedTeaQty", query = "SELECT p FROM ProductionTeaBook p WHERE p.refusedTeaQty = :refusedTeaQty")
    , @NamedQuery(name = "ProductionTeaBook.findByMadeTeaQty", query = "SELECT p FROM ProductionTeaBook p WHERE p.madeTeaQty = :madeTeaQty")
    , @NamedQuery(name = "ProductionTeaBook.findByDispatchQty", query = "SELECT p FROM ProductionTeaBook p WHERE p.dispatchQty = :dispatchQty")
    , @NamedQuery(name = "ProductionTeaBook.findByLocalSale", query = "SELECT p FROM ProductionTeaBook p WHERE p.localSale = :localSale")
    , @NamedQuery(name = "ProductionTeaBook.findByLossExes", query = "SELECT p FROM ProductionTeaBook p WHERE p.lossExes = :lossExes")
    , @NamedQuery(name = "ProductionTeaBook.findByReceivedTeaQty", query = "SELECT p FROM ProductionTeaBook p WHERE p.receivedTeaQty = :receivedTeaQty")
    , @NamedQuery(name = "ProductionTeaBook.findByBalanceTodate", query = "SELECT p FROM ProductionTeaBook p WHERE p.balanceTodate = :balanceTodate")
    , @NamedQuery(name = "ProductionTeaBook.findByTodateRefusedTea", query = "SELECT p FROM ProductionTeaBook p WHERE p.todateRefusedTea = :todateRefusedTea")
    , @NamedQuery(name = "ProductionTeaBook.findByDisposalQty", query = "SELECT p FROM ProductionTeaBook p WHERE p.disposalQty = :disposalQty")
    , @NamedQuery(name = "ProductionTeaBook.findByEvolution", query = "SELECT p FROM ProductionTeaBook p WHERE p.evolution = :evolution")
    , @NamedQuery(name = "ProductionTeaBook.findByRefusedTeaSoldQty", query = "SELECT p FROM ProductionTeaBook p WHERE p.refusedTeaSoldQty = :refusedTeaSoldQty")})
public class ProductionTeaBook implements Serializable {

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
    @Column(name = "green_leaf_qty")
    private Double greenLeafQty;
    @Column(name = "fire_tea_qty")
    private Double fireTeaQty;
    @Column(name = "refused_tea_qty")
    private Double refusedTeaQty;
    @Column(name = "made_tea_qty")
    private Double madeTeaQty;
    @Column(name = "dispatch_qty")
    private Double dispatchQty;
    @Column(name = "local_sale")
    private Double localSale;
    @Column(name = "loss_exes")
    private Double lossExes;
    @Column(name = "received_tea_qty")
    private Double receivedTeaQty;
    @Column(name = "balance_todate")
    private Double balanceTodate;
    @Column(name = "todate_refused_tea")
    private Double todateRefusedTea;
    @Column(name = "disposal_qty")
    private Double disposalQty;
    @Column(name = "evolution")
    private Double evolution;
    @Column(name = "refused_tea_sold_qty")
    private Double refusedTeaSoldQty;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;

    public ProductionTeaBook() {
    }

    public ProductionTeaBook(Integer id) {
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

    public Double getGreenLeafQty() {
        return greenLeafQty;
    }

    public void setGreenLeafQty(Double greenLeafQty) {
        this.greenLeafQty = greenLeafQty;
    }

    public Double getFireTeaQty() {
        return fireTeaQty;
    }

    public void setFireTeaQty(Double fireTeaQty) {
        this.fireTeaQty = fireTeaQty;
    }

    public Double getRefusedTeaQty() {
        return refusedTeaQty;
    }

    public void setRefusedTeaQty(Double refusedTeaQty) {
        this.refusedTeaQty = refusedTeaQty;
    }

    public Double getMadeTeaQty() {
        return madeTeaQty;
    }

    public void setMadeTeaQty(Double madeTeaQty) {
        this.madeTeaQty = madeTeaQty;
    }

    public Double getDispatchQty() {
        return dispatchQty;
    }

    public void setDispatchQty(Double dispatchQty) {
        this.dispatchQty = dispatchQty;
    }

    public Double getLocalSale() {
        return localSale;
    }

    public void setLocalSale(Double localSale) {
        this.localSale = localSale;
    }

    public Double getLossExes() {
        return lossExes;
    }

    public void setLossExes(Double lossExes) {
        this.lossExes = lossExes;
    }

    public Double getReceivedTeaQty() {
        return receivedTeaQty;
    }

    public void setReceivedTeaQty(Double receivedTeaQty) {
        this.receivedTeaQty = receivedTeaQty;
    }

    public Double getBalanceTodate() {
        return balanceTodate;
    }

    public void setBalanceTodate(Double balanceTodate) {
        this.balanceTodate = balanceTodate;
    }

    public Double getTodateRefusedTea() {
        return todateRefusedTea;
    }

    public void setTodateRefusedTea(Double todateRefusedTea) {
        this.todateRefusedTea = todateRefusedTea;
    }

    public Double getDisposalQty() {
        return disposalQty;
    }

    public void setDisposalQty(Double disposalQty) {
        this.disposalQty = disposalQty;
    }

    public Double getEvolution() {
        return evolution;
    }

    public void setEvolution(Double evolution) {
        this.evolution = evolution;
    }

    public Double getRefusedTeaSoldQty() {
        return refusedTeaSoldQty;
    }

    public void setRefusedTeaSoldQty(Double refusedTeaSoldQty) {
        this.refusedTeaSoldQty = refusedTeaSoldQty;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
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
        if (!(object instanceof ProductionTeaBook)) {
            return false;
        }
        ProductionTeaBook other = (ProductionTeaBook) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ProductionTeaBook[ id=" + id + " ]";
    }
    
}
