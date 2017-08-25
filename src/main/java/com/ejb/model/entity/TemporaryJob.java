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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "temporary_job")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TemporaryJob.findAll", query = "SELECT t FROM TemporaryJob t")
    , @NamedQuery(name = "TemporaryJob.findById", query = "SELECT t FROM TemporaryJob t WHERE t.id = :id")
    , @NamedQuery(name = "TemporaryJob.findByReference", query = "SELECT t FROM TemporaryJob t WHERE t.reference = :reference")
    , @NamedQuery(name = "TemporaryJob.findByPaidAmount", query = "SELECT t FROM TemporaryJob t WHERE t.paidAmount = :paidAmount")
    , @NamedQuery(name = "TemporaryJob.findByJobCreatedDate", query = "SELECT t FROM TemporaryJob t WHERE t.jobCreatedDate = :jobCreatedDate")
    , @NamedQuery(name = "TemporaryJob.findByRequestedDate", query = "SELECT t FROM TemporaryJob t WHERE t.requestedDate = :requestedDate")
    , @NamedQuery(name = "TemporaryJob.findByDeliveryLocation", query = "SELECT t FROM TemporaryJob t WHERE t.deliveryLocation = :deliveryLocation")
    , @NamedQuery(name = "TemporaryJob.findByIsActive", query = "SELECT t FROM TemporaryJob t WHERE t.isActive = :isActive")})
public class TemporaryJob implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "reference")
    private Integer reference;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "paid_amount")
    private Double paidAmount;
    @Column(name = "job_created_date")
    @Temporal(TemporalType.DATE)
    private Date jobCreatedDate;
    @Column(name = "requested_date")
    @Temporal(TemporalType.DATE)
    private Date requestedDate;
    @Lob
    @Size(max = 65535)
    @Column(name = "reason")
    private String reason;
    @Size(max = 345)
    @Column(name = "delivery_location")
    private String deliveryLocation;
    @Column(name = "is_active")
    private Boolean isActive;
    @OneToMany(mappedBy = "temporaryJobId")
    private Collection<JobCard> jobCardCollection;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "universal_person_or_org_type_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId;

    public TemporaryJob() {
    }

    public TemporaryJob(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Date getJobCreatedDate() {
        return jobCreatedDate;
    }

    public void setJobCreatedDate(Date jobCreatedDate) {
        this.jobCreatedDate = jobCreatedDate;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public Collection<JobCard> getJobCardCollection() {
        return jobCardCollection;
    }

    public void setJobCardCollection(Collection<JobCard> jobCardCollection) {
        this.jobCardCollection = jobCardCollection;
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

    public UniversalPersonOrOrgTypeManager getUniversalPersonOrOrgTypeManagerId() {
        return universalPersonOrOrgTypeManagerId;
    }

    public void setUniversalPersonOrOrgTypeManagerId(UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId) {
        this.universalPersonOrOrgTypeManagerId = universalPersonOrOrgTypeManagerId;
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
        if (!(object instanceof TemporaryJob)) {
            return false;
        }
        TemporaryJob other = (TemporaryJob) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.TemporaryJob[ id=" + id + " ]";
    }
    
}
