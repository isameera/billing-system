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
@Table(name = "factory_collected_leaf_confirmation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FactoryCollectedLeafConfirmation.findAll", query = "SELECT f FROM FactoryCollectedLeafConfirmation f")
    , @NamedQuery(name = "FactoryCollectedLeafConfirmation.findById", query = "SELECT f FROM FactoryCollectedLeafConfirmation f WHERE f.id = :id")
    , @NamedQuery(name = "FactoryCollectedLeafConfirmation.findByConfirmedDate", query = "SELECT f FROM FactoryCollectedLeafConfirmation f WHERE f.confirmedDate = :confirmedDate")
    , @NamedQuery(name = "FactoryCollectedLeafConfirmation.findByConfirmedTime", query = "SELECT f FROM FactoryCollectedLeafConfirmation f WHERE f.confirmedTime = :confirmedTime")})
public class FactoryCollectedLeafConfirmation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "confirmed_date")
    @Temporal(TemporalType.DATE)
    private Date confirmedDate;
    @Column(name = "confirmed_time")
    @Temporal(TemporalType.TIME)
    private Date confirmedTime;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "factory_collected_leaf_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FactoryCollectedLeaf factoryCollectedLeafId;
    @JoinColumn(name = "factory_collected_leaf_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FactoryCollectedLeafStatus factoryCollectedLeafStatusId;

    public FactoryCollectedLeafConfirmation() {
    }

    public FactoryCollectedLeafConfirmation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getConfirmedDate() {
        return confirmedDate;
    }

    public void setConfirmedDate(Date confirmedDate) {
        this.confirmedDate = confirmedDate;
    }

    public Date getConfirmedTime() {
        return confirmedTime;
    }

    public void setConfirmedTime(Date confirmedTime) {
        this.confirmedTime = confirmedTime;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public FactoryCollectedLeaf getFactoryCollectedLeafId() {
        return factoryCollectedLeafId;
    }

    public void setFactoryCollectedLeafId(FactoryCollectedLeaf factoryCollectedLeafId) {
        this.factoryCollectedLeafId = factoryCollectedLeafId;
    }

    public FactoryCollectedLeafStatus getFactoryCollectedLeafStatusId() {
        return factoryCollectedLeafStatusId;
    }

    public void setFactoryCollectedLeafStatusId(FactoryCollectedLeafStatus factoryCollectedLeafStatusId) {
        this.factoryCollectedLeafStatusId = factoryCollectedLeafStatusId;
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
        if (!(object instanceof FactoryCollectedLeafConfirmation)) {
            return false;
        }
        FactoryCollectedLeafConfirmation other = (FactoryCollectedLeafConfirmation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.FactoryCollectedLeafConfirmation[ id=" + id + " ]";
    }
    
}
