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
@Table(name = "company_holiday_scheduler")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompanyHolidayScheduler.findAll", query = "SELECT c FROM CompanyHolidayScheduler c")
    , @NamedQuery(name = "CompanyHolidayScheduler.findById", query = "SELECT c FROM CompanyHolidayScheduler c WHERE c.id = :id")
    , @NamedQuery(name = "CompanyHolidayScheduler.findByDate", query = "SELECT c FROM CompanyHolidayScheduler c WHERE c.date = :date")
    , @NamedQuery(name = "CompanyHolidayScheduler.findByReason", query = "SELECT c FROM CompanyHolidayScheduler c WHERE c.reason = :reason")})
public class CompanyHolidayScheduler implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 145)
    @Column(name = "reason")
    private String reason;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "holiday_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private HolidayType holidayTypeId;

    public CompanyHolidayScheduler() {
    }

    public CompanyHolidayScheduler(Integer id) {
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
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
        if (!(object instanceof CompanyHolidayScheduler)) {
            return false;
        }
        CompanyHolidayScheduler other = (CompanyHolidayScheduler) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.CompanyHolidayScheduler[ id=" + id + " ]";
    }
    
}
