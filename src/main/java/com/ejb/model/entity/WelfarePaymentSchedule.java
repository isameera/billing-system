/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "welfare_payment_schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WelfarePaymentSchedule.findAll", query = "SELECT w FROM WelfarePaymentSchedule w")
    , @NamedQuery(name = "WelfarePaymentSchedule.findById", query = "SELECT w FROM WelfarePaymentSchedule w WHERE w.id = :id")
    , @NamedQuery(name = "WelfarePaymentSchedule.findByDate", query = "SELECT w FROM WelfarePaymentSchedule w WHERE w.date = :date")
    , @NamedQuery(name = "WelfarePaymentSchedule.findByFunctionDate", query = "SELECT w FROM WelfarePaymentSchedule w WHERE w.functionDate = :functionDate")})
public class WelfarePaymentSchedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "function_date")
    @Temporal(TemporalType.DATE)
    private Date functionDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "welfarePaymentScheduleId")
    private Collection<WelfarePaymentScheduleRecord> welfarePaymentScheduleRecordCollection;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;

    public WelfarePaymentSchedule() {
    }

    public WelfarePaymentSchedule(Integer id) {
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

    public Date getFunctionDate() {
        return functionDate;
    }

    public void setFunctionDate(Date functionDate) {
        this.functionDate = functionDate;
    }

    @XmlTransient
    public Collection<WelfarePaymentScheduleRecord> getWelfarePaymentScheduleRecordCollection() {
        return welfarePaymentScheduleRecordCollection;
    }

    public void setWelfarePaymentScheduleRecordCollection(Collection<WelfarePaymentScheduleRecord> welfarePaymentScheduleRecordCollection) {
        this.welfarePaymentScheduleRecordCollection = welfarePaymentScheduleRecordCollection;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
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
        if (!(object instanceof WelfarePaymentSchedule)) {
            return false;
        }
        WelfarePaymentSchedule other = (WelfarePaymentSchedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.WelfarePaymentSchedule[ id=" + id + " ]";
    }
    
}
