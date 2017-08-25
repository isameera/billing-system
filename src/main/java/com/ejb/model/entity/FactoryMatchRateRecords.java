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
@Table(name = "factory_match_rate_records")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FactoryMatchRateRecords.findAll", query = "SELECT f FROM FactoryMatchRateRecords f")
    , @NamedQuery(name = "FactoryMatchRateRecords.findById", query = "SELECT f FROM FactoryMatchRateRecords f WHERE f.id = :id")
    , @NamedQuery(name = "FactoryMatchRateRecords.findByRate", query = "SELECT f FROM FactoryMatchRateRecords f WHERE f.rate = :rate")
    , @NamedQuery(name = "FactoryMatchRateRecords.findByYear", query = "SELECT f FROM FactoryMatchRateRecords f WHERE f.year = :year")
    , @NamedQuery(name = "FactoryMatchRateRecords.findByMonth", query = "SELECT f FROM FactoryMatchRateRecords f WHERE f.month = :month")})
public class FactoryMatchRateRecords implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rate")
    private Double rate;
    @Column(name = "year")
    private Integer year;
    @Column(name = "month")
    private Integer month;
    @JoinColumn(name = "facory_match_rate_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FactoryMatchRate facoryMatchRateId;

    public FactoryMatchRateRecords() {
    }

    public FactoryMatchRateRecords(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
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

    public FactoryMatchRate getFacoryMatchRateId() {
        return facoryMatchRateId;
    }

    public void setFacoryMatchRateId(FactoryMatchRate facoryMatchRateId) {
        this.facoryMatchRateId = facoryMatchRateId;
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
        if (!(object instanceof FactoryMatchRateRecords)) {
            return false;
        }
        FactoryMatchRateRecords other = (FactoryMatchRateRecords) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.FactoryMatchRateRecords[ id=" + id + " ]";
    }
    
}
