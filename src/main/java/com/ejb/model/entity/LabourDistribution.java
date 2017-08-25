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
@Table(name = "labour_distribution")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LabourDistribution.findAll", query = "SELECT l FROM LabourDistribution l")
    , @NamedQuery(name = "LabourDistribution.findById", query = "SELECT l FROM LabourDistribution l WHERE l.id = :id")
    , @NamedQuery(name = "LabourDistribution.findByYear", query = "SELECT l FROM LabourDistribution l WHERE l.year = :year")
    , @NamedQuery(name = "LabourDistribution.findByMonth", query = "SELECT l FROM LabourDistribution l WHERE l.month = :month")
    , @NamedQuery(name = "LabourDistribution.findByLabours", query = "SELECT l FROM LabourDistribution l WHERE l.labours = :labours")
    , @NamedQuery(name = "LabourDistribution.findByHolidays", query = "SELECT l FROM LabourDistribution l WHERE l.holidays = :holidays")
    , @NamedQuery(name = "LabourDistribution.findByHolidayAmount", query = "SELECT l FROM LabourDistribution l WHERE l.holidayAmount = :holidayAmount")
    , @NamedQuery(name = "LabourDistribution.findByDayOtHours", query = "SELECT l FROM LabourDistribution l WHERE l.dayOtHours = :dayOtHours")
    , @NamedQuery(name = "LabourDistribution.findByOtAmount", query = "SELECT l FROM LabourDistribution l WHERE l.otAmount = :otAmount")
    , @NamedQuery(name = "LabourDistribution.findByNightOtHours", query = "SELECT l FROM LabourDistribution l WHERE l.nightOtHours = :nightOtHours")
    , @NamedQuery(name = "LabourDistribution.findByDayOtAmount", query = "SELECT l FROM LabourDistribution l WHERE l.dayOtAmount = :dayOtAmount")
    , @NamedQuery(name = "LabourDistribution.findByNightOtAmount", query = "SELECT l FROM LabourDistribution l WHERE l.nightOtAmount = :nightOtAmount")
    , @NamedQuery(name = "LabourDistribution.findByPss", query = "SELECT l FROM LabourDistribution l WHERE l.pss = :pss")
    , @NamedQuery(name = "LabourDistribution.findByIncentive", query = "SELECT l FROM LabourDistribution l WHERE l.incentive = :incentive")})
public class LabourDistribution implements Serializable {

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
    @Column(name = "labours")
    private Double labours;
    @Column(name = "holidays")
    private Double holidays;
    @Column(name = "holiday_amount")
    private Double holidayAmount;
    @Column(name = "day_ot_hours")
    private Double dayOtHours;
    @Column(name = "ot_amount")
    private Double otAmount;
    @Column(name = "night_ot_hours")
    private Double nightOtHours;
    @Column(name = "day_ot_amount")
    private Double dayOtAmount;
    @Column(name = "night_ot_amount")
    private Double nightOtAmount;
    @Column(name = "pss")
    private Double pss;
    @Column(name = "incentive")
    private Double incentive;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "working_section_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private WorkingSection workingSectionId;

    public LabourDistribution() {
    }

    public LabourDistribution(Integer id) {
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

    public Double getLabours() {
        return labours;
    }

    public void setLabours(Double labours) {
        this.labours = labours;
    }

    public Double getHolidays() {
        return holidays;
    }

    public void setHolidays(Double holidays) {
        this.holidays = holidays;
    }

    public Double getHolidayAmount() {
        return holidayAmount;
    }

    public void setHolidayAmount(Double holidayAmount) {
        this.holidayAmount = holidayAmount;
    }

    public Double getDayOtHours() {
        return dayOtHours;
    }

    public void setDayOtHours(Double dayOtHours) {
        this.dayOtHours = dayOtHours;
    }

    public Double getOtAmount() {
        return otAmount;
    }

    public void setOtAmount(Double otAmount) {
        this.otAmount = otAmount;
    }

    public Double getNightOtHours() {
        return nightOtHours;
    }

    public void setNightOtHours(Double nightOtHours) {
        this.nightOtHours = nightOtHours;
    }

    public Double getDayOtAmount() {
        return dayOtAmount;
    }

    public void setDayOtAmount(Double dayOtAmount) {
        this.dayOtAmount = dayOtAmount;
    }

    public Double getNightOtAmount() {
        return nightOtAmount;
    }

    public void setNightOtAmount(Double nightOtAmount) {
        this.nightOtAmount = nightOtAmount;
    }

    public Double getPss() {
        return pss;
    }

    public void setPss(Double pss) {
        this.pss = pss;
    }

    public Double getIncentive() {
        return incentive;
    }

    public void setIncentive(Double incentive) {
        this.incentive = incentive;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public WorkingSection getWorkingSectionId() {
        return workingSectionId;
    }

    public void setWorkingSectionId(WorkingSection workingSectionId) {
        this.workingSectionId = workingSectionId;
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
        if (!(object instanceof LabourDistribution)) {
            return false;
        }
        LabourDistribution other = (LabourDistribution) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.LabourDistribution[ id=" + id + " ]";
    }
    
}
