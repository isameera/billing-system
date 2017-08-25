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
@Table(name = "supplier_collected_leaf_controller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierCollectedLeafController.findAll", query = "SELECT s FROM SupplierCollectedLeafController s")
    , @NamedQuery(name = "SupplierCollectedLeafController.findById", query = "SELECT s FROM SupplierCollectedLeafController s WHERE s.id = :id")
    , @NamedQuery(name = "SupplierCollectedLeafController.findByYear", query = "SELECT s FROM SupplierCollectedLeafController s WHERE s.year = :year")
    , @NamedQuery(name = "SupplierCollectedLeafController.findByMonth", query = "SELECT s FROM SupplierCollectedLeafController s WHERE s.month = :month")
    , @NamedQuery(name = "SupplierCollectedLeafController.findBySupperLeafQty", query = "SELECT s FROM SupplierCollectedLeafController s WHERE s.supperLeafQty = :supperLeafQty")
    , @NamedQuery(name = "SupplierCollectedLeafController.findByNormalLeafQty", query = "SELECT s FROM SupplierCollectedLeafController s WHERE s.normalLeafQty = :normalLeafQty")})
public class SupplierCollectedLeafController implements Serializable {

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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "supper_leaf_qty")
    private Double supperLeafQty;
    @Column(name = "normal_leaf_qty")
    private Double normalLeafQty;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierRegistration supplierRegistrationId;

    public SupplierCollectedLeafController() {
    }

    public SupplierCollectedLeafController(Integer id) {
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

    public Double getSupperLeafQty() {
        return supperLeafQty;
    }

    public void setSupperLeafQty(Double supperLeafQty) {
        this.supperLeafQty = supperLeafQty;
    }

    public Double getNormalLeafQty() {
        return normalLeafQty;
    }

    public void setNormalLeafQty(Double normalLeafQty) {
        this.normalLeafQty = normalLeafQty;
    }

    public SupplierRegistration getSupplierRegistrationId() {
        return supplierRegistrationId;
    }

    public void setSupplierRegistrationId(SupplierRegistration supplierRegistrationId) {
        this.supplierRegistrationId = supplierRegistrationId;
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
        if (!(object instanceof SupplierCollectedLeafController)) {
            return false;
        }
        SupplierCollectedLeafController other = (SupplierCollectedLeafController) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierCollectedLeafController[ id=" + id + " ]";
    }
    
}
