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
@Table(name = "annual_general_holiday_chart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnnualGeneralHolidayChart.findAll", query = "SELECT a FROM AnnualGeneralHolidayChart a")
    , @NamedQuery(name = "AnnualGeneralHolidayChart.findById", query = "SELECT a FROM AnnualGeneralHolidayChart a WHERE a.id = :id")
    , @NamedQuery(name = "AnnualGeneralHolidayChart.findByDate", query = "SELECT a FROM AnnualGeneralHolidayChart a WHERE a.date = :date")})
public class AnnualGeneralHolidayChart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "holiday_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private HolidayType holidayTypeId;

    public AnnualGeneralHolidayChart() {
    }

    public AnnualGeneralHolidayChart(Integer id) {
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

    public HolidayType getHolidayTypeId() {
        return holidayTypeId;
    }

    public void setHolidayTypeId(HolidayType holidayTypeId) {
        this.holidayTypeId = holidayTypeId;
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
        if (!(object instanceof AnnualGeneralHolidayChart)) {
            return false;
        }
        AnnualGeneralHolidayChart other = (AnnualGeneralHolidayChart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.AnnualGeneralHolidayChart[ id=" + id + " ]";
    }
    
}
