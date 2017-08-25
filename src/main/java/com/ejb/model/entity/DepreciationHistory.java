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
@Table(name = "depreciation_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DepreciationHistory.findAll", query = "SELECT d FROM DepreciationHistory d")
    , @NamedQuery(name = "DepreciationHistory.findById", query = "SELECT d FROM DepreciationHistory d WHERE d.id = :id")
    , @NamedQuery(name = "DepreciationHistory.findByCurrentValue", query = "SELECT d FROM DepreciationHistory d WHERE d.currentValue = :currentValue")
    , @NamedQuery(name = "DepreciationHistory.findByDate", query = "SELECT d FROM DepreciationHistory d WHERE d.date = :date")})
public class DepreciationHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "current_value")
    private Double currentValue;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "depreciation_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DepreciationMaster depreciationMasterId;

    public DepreciationHistory() {
    }

    public DepreciationHistory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DepreciationMaster getDepreciationMasterId() {
        return depreciationMasterId;
    }

    public void setDepreciationMasterId(DepreciationMaster depreciationMasterId) {
        this.depreciationMasterId = depreciationMasterId;
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
        if (!(object instanceof DepreciationHistory)) {
            return false;
        }
        DepreciationHistory other = (DepreciationHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.DepreciationHistory[ id=" + id + " ]";
    }
    
}
