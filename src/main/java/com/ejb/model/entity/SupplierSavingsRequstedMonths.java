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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "supplier_savings_requsted_months")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierSavingsRequstedMonths.findAll", query = "SELECT s FROM SupplierSavingsRequstedMonths s")
    , @NamedQuery(name = "SupplierSavingsRequstedMonths.findById", query = "SELECT s FROM SupplierSavingsRequstedMonths s WHERE s.id = :id")
    , @NamedQuery(name = "SupplierSavingsRequstedMonths.findByYear", query = "SELECT s FROM SupplierSavingsRequstedMonths s WHERE s.year = :year")
    , @NamedQuery(name = "SupplierSavingsRequstedMonths.findByMonth", query = "SELECT s FROM SupplierSavingsRequstedMonths s WHERE s.month = :month")})
public class SupplierSavingsRequstedMonths implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "year")
    private Integer year;
    @Column(name = "month")
    private Integer month;
    @JoinColumn(name = "supplier_savings_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierSavingsAccount supplierSavingsAccountId;
    @JoinColumn(name = "supplier_savings_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierSavingsStatus supplierSavingsStatusId;

    public SupplierSavingsRequstedMonths() {
    }

    public SupplierSavingsRequstedMonths(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public SupplierSavingsStatus getSupplierSavingsStatusId() {
        return supplierSavingsStatusId;
    }

    public void setSupplierSavingsStatusId(SupplierSavingsStatus supplierSavingsStatusId) {
        this.supplierSavingsStatusId = supplierSavingsStatusId;
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
        if (!(object instanceof SupplierSavingsRequstedMonths)) {
            return false;
        }
        SupplierSavingsRequstedMonths other = (SupplierSavingsRequstedMonths) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierSavingsRequstedMonths[ id=" + id + " ]";
    }
    
}
