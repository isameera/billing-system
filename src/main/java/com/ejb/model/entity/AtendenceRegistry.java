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
@Table(name = "atendence_registry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtendenceRegistry.findAll", query = "SELECT a FROM AtendenceRegistry a")
    , @NamedQuery(name = "AtendenceRegistry.findById", query = "SELECT a FROM AtendenceRegistry a WHERE a.id = :id")
    , @NamedQuery(name = "AtendenceRegistry.findByDate", query = "SELECT a FROM AtendenceRegistry a WHERE a.date = :date")
    , @NamedQuery(name = "AtendenceRegistry.findByTimeIn", query = "SELECT a FROM AtendenceRegistry a WHERE a.timeIn = :timeIn")
    , @NamedQuery(name = "AtendenceRegistry.findByTimeOut", query = "SELECT a FROM AtendenceRegistry a WHERE a.timeOut = :timeOut")
    , @NamedQuery(name = "AtendenceRegistry.findByIsAbsent", query = "SELECT a FROM AtendenceRegistry a WHERE a.isAbsent = :isAbsent")
    , @NamedQuery(name = "AtendenceRegistry.findByWorkingHours", query = "SELECT a FROM AtendenceRegistry a WHERE a.workingHours = :workingHours")
    , @NamedQuery(name = "AtendenceRegistry.findByOtHours", query = "SELECT a FROM AtendenceRegistry a WHERE a.otHours = :otHours")
    , @NamedQuery(name = "AtendenceRegistry.findByMachineId", query = "SELECT a FROM AtendenceRegistry a WHERE a.machineId = :machineId")
    , @NamedQuery(name = "AtendenceRegistry.findByNameCount", query = "SELECT a FROM AtendenceRegistry a WHERE a.nameCount = :nameCount")
    , @NamedQuery(name = "AtendenceRegistry.findByIsWornUniform", query = "SELECT a FROM AtendenceRegistry a WHERE a.isWornUniform = :isWornUniform")
    , @NamedQuery(name = "AtendenceRegistry.findByIsOfficial", query = "SELECT a FROM AtendenceRegistry a WHERE a.isOfficial = :isOfficial")})
public class AtendenceRegistry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "time_in")
    @Temporal(TemporalType.TIME)
    private Date timeIn;
    @Column(name = "time_out")
    @Temporal(TemporalType.TIME)
    private Date timeOut;
    @Column(name = "is_absent")
    private Integer isAbsent;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "working_hours")
    private Double workingHours;
    @Column(name = "ot_hours")
    private Double otHours;
    @Size(max = 45)
    @Column(name = "machine_id")
    private String machineId;
    @Column(name = "name_count")
    private Double nameCount;
    @Column(name = "is_worn_uniform")
    private Boolean isWornUniform;
    @Column(name = "is_official")
    private Boolean isOfficial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atendenceRegistryId")
    private Collection<AttendenceLeaveCounter> attendenceLeaveCounterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atendenceRegistryId")
    private Collection<ConstructionSiteEmployeeSafty> constructionSiteEmployeeSaftyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atendenceRegistryId")
    private Collection<ConstructionSiteEmployeeAttendance> constructionSiteEmployeeAttendanceCollection;
    @JoinColumn(name = "attendance_collection_location_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AttendanceCollectionLocation attendanceCollectionLocationId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "work_shift_manager_id", referencedColumnName = "id")
    @ManyToOne
    private WorkShiftManager workShiftManagerId;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;

    public AtendenceRegistry() {
    }

    public AtendenceRegistry(Integer id) {
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

    public Date getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Date timeIn) {
        this.timeIn = timeIn;
    }

    public Date getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
    }

    public Integer getIsAbsent() {
        return isAbsent;
    }

    public void setIsAbsent(Integer isAbsent) {
        this.isAbsent = isAbsent;
    }

    public Double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Double workingHours) {
        this.workingHours = workingHours;
    }

    public Double getOtHours() {
        return otHours;
    }

    public void setOtHours(Double otHours) {
        this.otHours = otHours;
    }

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public Double getNameCount() {
        return nameCount;
    }

    public void setNameCount(Double nameCount) {
        this.nameCount = nameCount;
    }

    public Boolean getIsWornUniform() {
        return isWornUniform;
    }

    public void setIsWornUniform(Boolean isWornUniform) {
        this.isWornUniform = isWornUniform;
    }

    public Boolean getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(Boolean isOfficial) {
        this.isOfficial = isOfficial;
    }

    @XmlTransient
    public Collection<AttendenceLeaveCounter> getAttendenceLeaveCounterCollection() {
        return attendenceLeaveCounterCollection;
    }

    public void setAttendenceLeaveCounterCollection(Collection<AttendenceLeaveCounter> attendenceLeaveCounterCollection) {
        this.attendenceLeaveCounterCollection = attendenceLeaveCounterCollection;
    }

    @XmlTransient
    public Collection<ConstructionSiteEmployeeSafty> getConstructionSiteEmployeeSaftyCollection() {
        return constructionSiteEmployeeSaftyCollection;
    }

    public void setConstructionSiteEmployeeSaftyCollection(Collection<ConstructionSiteEmployeeSafty> constructionSiteEmployeeSaftyCollection) {
        this.constructionSiteEmployeeSaftyCollection = constructionSiteEmployeeSaftyCollection;
    }

    @XmlTransient
    public Collection<ConstructionSiteEmployeeAttendance> getConstructionSiteEmployeeAttendanceCollection() {
        return constructionSiteEmployeeAttendanceCollection;
    }

    public void setConstructionSiteEmployeeAttendanceCollection(Collection<ConstructionSiteEmployeeAttendance> constructionSiteEmployeeAttendanceCollection) {
        this.constructionSiteEmployeeAttendanceCollection = constructionSiteEmployeeAttendanceCollection;
    }

    public AttendanceCollectionLocation getAttendanceCollectionLocationId() {
        return attendanceCollectionLocationId;
    }

    public void setAttendanceCollectionLocationId(AttendanceCollectionLocation attendanceCollectionLocationId) {
        this.attendanceCollectionLocationId = attendanceCollectionLocationId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public WorkShiftManager getWorkShiftManagerId() {
        return workShiftManagerId;
    }

    public void setWorkShiftManagerId(WorkShiftManager workShiftManagerId) {
        this.workShiftManagerId = workShiftManagerId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
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
        if (!(object instanceof AtendenceRegistry)) {
            return false;
        }
        AtendenceRegistry other = (AtendenceRegistry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.AtendenceRegistry[ id=" + id + " ]";
    }
    
}
