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
@Table(name = "work_shift_manager_iso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkShiftManagerIso.findAll", query = "SELECT w FROM WorkShiftManagerIso w")
    , @NamedQuery(name = "WorkShiftManagerIso.findById", query = "SELECT w FROM WorkShiftManagerIso w WHERE w.id = :id")
    , @NamedQuery(name = "WorkShiftManagerIso.findByDate", query = "SELECT w FROM WorkShiftManagerIso w WHERE w.date = :date")
    , @NamedQuery(name = "WorkShiftManagerIso.findByName", query = "SELECT w FROM WorkShiftManagerIso w WHERE w.name = :name")
    , @NamedQuery(name = "WorkShiftManagerIso.findByDayOt", query = "SELECT w FROM WorkShiftManagerIso w WHERE w.dayOt = :dayOt")
    , @NamedQuery(name = "WorkShiftManagerIso.findByNightOt", query = "SELECT w FROM WorkShiftManagerIso w WHERE w.nightOt = :nightOt")})
public class WorkShiftManagerIso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "name")
    private Double name;
    @Column(name = "day_ot")
    private Double dayOt;
    @Column(name = "night_ot")
    private Double nightOt;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "employee_final_payment_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EmployeeFinalPaymentType employeeFinalPaymentTypeId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "working_section_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private WorkingSection workingSectionId;

    public WorkShiftManagerIso() {
    }

    public WorkShiftManagerIso(Integer id) {
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

    public Double getName() {
        return name;
    }

    public void setName(Double name) {
        this.name = name;
    }

    public Double getDayOt() {
        return dayOt;
    }

    public void setDayOt(Double dayOt) {
        this.dayOt = dayOt;
    }

    public Double getNightOt() {
        return nightOt;
    }

    public void setNightOt(Double nightOt) {
        this.nightOt = nightOt;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public EmployeeFinalPaymentType getEmployeeFinalPaymentTypeId() {
        return employeeFinalPaymentTypeId;
    }

    public void setEmployeeFinalPaymentTypeId(EmployeeFinalPaymentType employeeFinalPaymentTypeId) {
        this.employeeFinalPaymentTypeId = employeeFinalPaymentTypeId;
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
        if (!(object instanceof WorkShiftManagerIso)) {
            return false;
        }
        WorkShiftManagerIso other = (WorkShiftManagerIso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.WorkShiftManagerIso[ id=" + id + " ]";
    }
    
}
