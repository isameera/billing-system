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
@Table(name = "job_card")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobCard.findAll", query = "SELECT j FROM JobCard j")
    , @NamedQuery(name = "JobCard.findById", query = "SELECT j FROM JobCard j WHERE j.id = :id")
    , @NamedQuery(name = "JobCard.findByReference", query = "SELECT j FROM JobCard j WHERE j.reference = :reference")
    , @NamedQuery(name = "JobCard.findByJobNo", query = "SELECT j FROM JobCard j WHERE j.jobNo = :jobNo")
    , @NamedQuery(name = "JobCard.findByJobNoManual", query = "SELECT j FROM JobCard j WHERE j.jobNoManual = :jobNoManual")
    , @NamedQuery(name = "JobCard.findByJobCreatedDate", query = "SELECT j FROM JobCard j WHERE j.jobCreatedDate = :jobCreatedDate")
    , @NamedQuery(name = "JobCard.findByExpectedDateToComplete", query = "SELECT j FROM JobCard j WHERE j.expectedDateToComplete = :expectedDateToComplete")
    , @NamedQuery(name = "JobCard.findByCompletedDate", query = "SELECT j FROM JobCard j WHERE j.completedDate = :completedDate")
    , @NamedQuery(name = "JobCard.findByJobTotal", query = "SELECT j FROM JobCard j WHERE j.jobTotal = :jobTotal")
    , @NamedQuery(name = "JobCard.findByTotalPaid", query = "SELECT j FROM JobCard j WHERE j.totalPaid = :totalPaid")
    , @NamedQuery(name = "JobCard.findByDueAmount", query = "SELECT j FROM JobCard j WHERE j.dueAmount = :dueAmount")
    , @NamedQuery(name = "JobCard.findByDeliveryLocation", query = "SELECT j FROM JobCard j WHERE j.deliveryLocation = :deliveryLocation")
    , @NamedQuery(name = "JobCard.findByIsFinished", query = "SELECT j FROM JobCard j WHERE j.isFinished = :isFinished")})
public class JobCard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "reference")
    private Integer reference;
    @Size(max = 45)
    @Column(name = "job_no")
    private String jobNo;
    @Size(max = 45)
    @Column(name = "job_no_manual")
    private String jobNoManual;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "job_created_date")
    @Temporal(TemporalType.DATE)
    private Date jobCreatedDate;
    @Column(name = "expected_date_to_complete")
    @Temporal(TemporalType.DATE)
    private Date expectedDateToComplete;
    @Column(name = "completed_date")
    @Temporal(TemporalType.DATE)
    private Date completedDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "job_total")
    private Double jobTotal;
    @Column(name = "total_paid")
    private Double totalPaid;
    @Column(name = "due_amount")
    private Double dueAmount;
    @Size(max = 345)
    @Column(name = "delivery_location")
    private String deliveryLocation;
    @Column(name = "is_finished")
    private Boolean isFinished;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "temporary_job_id", referencedColumnName = "id")
    @ManyToOne
    private TemporaryJob temporaryJobId;
    @JoinColumn(name = "universal_person_or_org_type_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobCardId")
    private Collection<JobItems> jobItemsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobCardId")
    private Collection<VoucherJobManager> voucherJobManagerCollection;

    public JobCard() {
    }

    public JobCard(Integer id) {
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

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    public String getJobNoManual() {
        return jobNoManual;
    }

    public void setJobNoManual(String jobNoManual) {
        this.jobNoManual = jobNoManual;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getJobCreatedDate() {
        return jobCreatedDate;
    }

    public void setJobCreatedDate(Date jobCreatedDate) {
        this.jobCreatedDate = jobCreatedDate;
    }

    public Date getExpectedDateToComplete() {
        return expectedDateToComplete;
    }

    public void setExpectedDateToComplete(Date expectedDateToComplete) {
        this.expectedDateToComplete = expectedDateToComplete;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    public Double getJobTotal() {
        return jobTotal;
    }

    public void setJobTotal(Double jobTotal) {
        this.jobTotal = jobTotal;
    }

    public Double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(Double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public Double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public Boolean getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Boolean isFinished) {
        this.isFinished = isFinished;
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

    public TemporaryJob getTemporaryJobId() {
        return temporaryJobId;
    }

    public void setTemporaryJobId(TemporaryJob temporaryJobId) {
        this.temporaryJobId = temporaryJobId;
    }

    public UniversalPersonOrOrgTypeManager getUniversalPersonOrOrgTypeManagerId() {
        return universalPersonOrOrgTypeManagerId;
    }

    public void setUniversalPersonOrOrgTypeManagerId(UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId) {
        this.universalPersonOrOrgTypeManagerId = universalPersonOrOrgTypeManagerId;
    }

    @XmlTransient
    public Collection<JobItems> getJobItemsCollection() {
        return jobItemsCollection;
    }

    public void setJobItemsCollection(Collection<JobItems> jobItemsCollection) {
        this.jobItemsCollection = jobItemsCollection;
    }

    @XmlTransient
    public Collection<VoucherJobManager> getVoucherJobManagerCollection() {
        return voucherJobManagerCollection;
    }

    public void setVoucherJobManagerCollection(Collection<VoucherJobManager> voucherJobManagerCollection) {
        this.voucherJobManagerCollection = voucherJobManagerCollection;
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
        if (!(object instanceof JobCard)) {
            return false;
        }
        JobCard other = (JobCard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.JobCard[ id=" + id + " ]";
    }
    
}
