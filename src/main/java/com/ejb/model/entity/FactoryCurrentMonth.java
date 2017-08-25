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
@Table(name = "factory_current_month")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FactoryCurrentMonth.findAll", query = "SELECT f FROM FactoryCurrentMonth f")
    , @NamedQuery(name = "FactoryCurrentMonth.findById", query = "SELECT f FROM FactoryCurrentMonth f WHERE f.id = :id")
    , @NamedQuery(name = "FactoryCurrentMonth.findByYear", query = "SELECT f FROM FactoryCurrentMonth f WHERE f.year = :year")
    , @NamedQuery(name = "FactoryCurrentMonth.findByMonth", query = "SELECT f FROM FactoryCurrentMonth f WHERE f.month = :month")
    , @NamedQuery(name = "FactoryCurrentMonth.findByIsPaid", query = "SELECT f FROM FactoryCurrentMonth f WHERE f.isPaid = :isPaid")})
public class FactoryCurrentMonth implements Serializable {

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
    @Column(name = "is_paid")
    private Integer isPaid;
    @JoinColumn(name = "factory_current_month_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FactoryCurrentMonthType factoryCurrentMonthTypeId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;

    public FactoryCurrentMonth() {
    }

    public FactoryCurrentMonth(Integer id) {
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

    public Integer getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Integer isPaid) {
        this.isPaid = isPaid;
    }

    public FactoryCurrentMonthType getFactoryCurrentMonthTypeId() {
        return factoryCurrentMonthTypeId;
    }

    public void setFactoryCurrentMonthTypeId(FactoryCurrentMonthType factoryCurrentMonthTypeId) {
        this.factoryCurrentMonthTypeId = factoryCurrentMonthTypeId;
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
        if (!(object instanceof FactoryCurrentMonth)) {
            return false;
        }
        FactoryCurrentMonth other = (FactoryCurrentMonth) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.FactoryCurrentMonth[ id=" + id + " ]";
    }
    
}
