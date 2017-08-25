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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "construction_contract")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConstructionContract.findAll", query = "SELECT c FROM ConstructionContract c")
    , @NamedQuery(name = "ConstructionContract.findById", query = "SELECT c FROM ConstructionContract c WHERE c.id = :id")
    , @NamedQuery(name = "ConstructionContract.findByName", query = "SELECT c FROM ConstructionContract c WHERE c.name = :name")
    , @NamedQuery(name = "ConstructionContract.findByContractNo", query = "SELECT c FROM ConstructionContract c WHERE c.contractNo = :contractNo")
    , @NamedQuery(name = "ConstructionContract.findByStartDate", query = "SELECT c FROM ConstructionContract c WHERE c.startDate = :startDate")
    , @NamedQuery(name = "ConstructionContract.findByEndDate", query = "SELECT c FROM ConstructionContract c WHERE c.endDate = :endDate")
    , @NamedQuery(name = "ConstructionContract.findByValue", query = "SELECT c FROM ConstructionContract c WHERE c.value = :value")
    , @NamedQuery(name = "ConstructionContract.findByNo", query = "SELECT c FROM ConstructionContract c WHERE c.no = :no")
    , @NamedQuery(name = "ConstructionContract.findByStreet", query = "SELECT c FROM ConstructionContract c WHERE c.street = :street")
    , @NamedQuery(name = "ConstructionContract.findByCity", query = "SELECT c FROM ConstructionContract c WHERE c.city = :city")})
public class ConstructionContract implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 450)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "contract_no")
    private String contractNo;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "value")
    private Double value;
    @Size(max = 255)
    @Column(name = "no")
    private String no;
    @Size(max = 255)
    @Column(name = "street")
    private String street;
    @Size(max = 255)
    @Column(name = "city")
    private String city;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "constructionContractId")
    private Collection<ConstructionSiteClients> constructionSiteClientsCollection;
    @OneToMany(mappedBy = "constructionContractId")
    private Collection<ConstructionContract> constructionContractCollection;
    @JoinColumn(name = "construction_contract_id", referencedColumnName = "id")
    @ManyToOne
    private ConstructionContract constructionContractId;
    @JoinColumn(name = "construction_contract_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ConstructionContractType constructionContractTypeId;
    @JoinColumn(name = "site_incharge", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee siteIncharge;
    @JoinColumn(name = "construction_project_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ConstructionProjectType constructionProjectTypeId;
    @JoinColumn(name = "project_manager", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee projectManager;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "constructionContractId")
    private Collection<ConstructionSiteEmployeeAttendance> constructionSiteEmployeeAttendanceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "constructionContractId")
    private Collection<ConstructionContractVoucherManager> constructionContractVoucherManagerCollection;

    public ConstructionContract() {
    }

    public ConstructionContract(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlTransient
    public Collection<ConstructionSiteClients> getConstructionSiteClientsCollection() {
        return constructionSiteClientsCollection;
    }

    public void setConstructionSiteClientsCollection(Collection<ConstructionSiteClients> constructionSiteClientsCollection) {
        this.constructionSiteClientsCollection = constructionSiteClientsCollection;
    }

    @XmlTransient
    public Collection<ConstructionContract> getConstructionContractCollection() {
        return constructionContractCollection;
    }

    public void setConstructionContractCollection(Collection<ConstructionContract> constructionContractCollection) {
        this.constructionContractCollection = constructionContractCollection;
    }

    public ConstructionContract getConstructionContractId() {
        return constructionContractId;
    }

    public void setConstructionContractId(ConstructionContract constructionContractId) {
        this.constructionContractId = constructionContractId;
    }

    public ConstructionContractType getConstructionContractTypeId() {
        return constructionContractTypeId;
    }

    public void setConstructionContractTypeId(ConstructionContractType constructionContractTypeId) {
        this.constructionContractTypeId = constructionContractTypeId;
    }

    public Employee getSiteIncharge() {
        return siteIncharge;
    }

    public void setSiteIncharge(Employee siteIncharge) {
        this.siteIncharge = siteIncharge;
    }

    public ConstructionProjectType getConstructionProjectTypeId() {
        return constructionProjectTypeId;
    }

    public void setConstructionProjectTypeId(ConstructionProjectType constructionProjectTypeId) {
        this.constructionProjectTypeId = constructionProjectTypeId;
    }

    public Employee getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(Employee projectManager) {
        this.projectManager = projectManager;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    @XmlTransient
    public Collection<ConstructionSiteEmployeeAttendance> getConstructionSiteEmployeeAttendanceCollection() {
        return constructionSiteEmployeeAttendanceCollection;
    }

    public void setConstructionSiteEmployeeAttendanceCollection(Collection<ConstructionSiteEmployeeAttendance> constructionSiteEmployeeAttendanceCollection) {
        this.constructionSiteEmployeeAttendanceCollection = constructionSiteEmployeeAttendanceCollection;
    }

    @XmlTransient
    public Collection<ConstructionContractVoucherManager> getConstructionContractVoucherManagerCollection() {
        return constructionContractVoucherManagerCollection;
    }

    public void setConstructionContractVoucherManagerCollection(Collection<ConstructionContractVoucherManager> constructionContractVoucherManagerCollection) {
        this.constructionContractVoucherManagerCollection = constructionContractVoucherManagerCollection;
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
        if (!(object instanceof ConstructionContract)) {
            return false;
        }
        ConstructionContract other = (ConstructionContract) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ConstructionContract[ id=" + id + " ]";
    }
    
}
