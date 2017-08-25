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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "supplier_savings_active_inactive_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierSavingsActiveInactiveHistory.findAll", query = "SELECT s FROM SupplierSavingsActiveInactiveHistory s")
    , @NamedQuery(name = "SupplierSavingsActiveInactiveHistory.findById", query = "SELECT s FROM SupplierSavingsActiveInactiveHistory s WHERE s.id = :id")
    , @NamedQuery(name = "SupplierSavingsActiveInactiveHistory.findByDate", query = "SELECT s FROM SupplierSavingsActiveInactiveHistory s WHERE s.date = :date")
    , @NamedQuery(name = "SupplierSavingsActiveInactiveHistory.findByStatus", query = "SELECT s FROM SupplierSavingsActiveInactiveHistory s WHERE s.status = :status")
    , @NamedQuery(name = "SupplierSavingsActiveInactiveHistory.findByYear", query = "SELECT s FROM SupplierSavingsActiveInactiveHistory s WHERE s.year = :year")
    , @NamedQuery(name = "SupplierSavingsActiveInactiveHistory.findByMonth", query = "SELECT s FROM SupplierSavingsActiveInactiveHistory s WHERE s.month = :month")})
public class SupplierSavingsActiveInactiveHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 20)
    @Column(name = "status")
    private String status;
    @Column(name = "year")
    private Integer year;
    @Column(name = "month")
    private Integer month;
    @JoinColumn(name = "supplier_savings_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierSavingsAccount supplierSavingsAccountId;

    public SupplierSavingsActiveInactiveHistory() {
    }

    public SupplierSavingsActiveInactiveHistory(Integer id) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public SupplierSavingsAccount getSupplierSavingsAccountId() {
        return supplierSavingsAccountId;
    }

    public void setSupplierSavingsAccountId(SupplierSavingsAccount supplierSavingsAccountId) {
        this.supplierSavingsAccountId = supplierSavingsAccountId;
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
        if (!(object instanceof SupplierSavingsActiveInactiveHistory)) {
            return false;
        }
        SupplierSavingsActiveInactiveHistory other = (SupplierSavingsActiveInactiveHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierSavingsActiveInactiveHistory[ id=" + id + " ]";
    }
    
}
