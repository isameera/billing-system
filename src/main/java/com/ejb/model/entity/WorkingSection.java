/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "working_section")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkingSection.findAll", query = "SELECT w FROM WorkingSection w")
    , @NamedQuery(name = "WorkingSection.findById", query = "SELECT w FROM WorkingSection w WHERE w.id = :id")
    , @NamedQuery(name = "WorkingSection.findByName", query = "SELECT w FROM WorkingSection w WHERE w.name = :name")
    , @NamedQuery(name = "WorkingSection.findByCode", query = "SELECT w FROM WorkingSection w WHERE w.code = :code")})
public class WorkingSection implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "code")
    private String code;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workingSectionId")
    private Collection<LabourDistribution> labourDistributionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workingSectionId")
    private Collection<WorkShiftManagerIso> workShiftManagerIsoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workingSectionId")
    private Collection<EmployeeWorkingSection> employeeWorkingSectionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workingSectionId")
    private Collection<WorkShiftManager> workShiftManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workingSectionId")
    private Collection<OrgWorkingSection> orgWorkingSectionCollection;

    public WorkingSection() {
    }

    public WorkingSection(Integer id) {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlTransient
    public Collection<LabourDistribution> getLabourDistributionCollection() {
        return labourDistributionCollection;
    }

    public void setLabourDistributionCollection(Collection<LabourDistribution> labourDistributionCollection) {
        this.labourDistributionCollection = labourDistributionCollection;
    }

    @XmlTransient
    public Collection<WorkShiftManagerIso> getWorkShiftManagerIsoCollection() {
        return workShiftManagerIsoCollection;
    }

    public void setWorkShiftManagerIsoCollection(Collection<WorkShiftManagerIso> workShiftManagerIsoCollection) {
        this.workShiftManagerIsoCollection = workShiftManagerIsoCollection;
    }

    @XmlTransient
    public Collection<EmployeeWorkingSection> getEmployeeWorkingSectionCollection() {
        return employeeWorkingSectionCollection;
    }

    public void setEmployeeWorkingSectionCollection(Collection<EmployeeWorkingSection> employeeWorkingSectionCollection) {
        this.employeeWorkingSectionCollection = employeeWorkingSectionCollection;
    }

    @XmlTransient
    public Collection<WorkShiftManager> getWorkShiftManagerCollection() {
        return workShiftManagerCollection;
    }

    public void setWorkShiftManagerCollection(Collection<WorkShiftManager> workShiftManagerCollection) {
        this.workShiftManagerCollection = workShiftManagerCollection;
    }

    @XmlTransient
    public Collection<OrgWorkingSection> getOrgWorkingSectionCollection() {
        return orgWorkingSectionCollection;
    }

    public void setOrgWorkingSectionCollection(Collection<OrgWorkingSection> orgWorkingSectionCollection) {
        this.orgWorkingSectionCollection = orgWorkingSectionCollection;
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
        if (!(object instanceof WorkingSection)) {
            return false;
        }
        WorkingSection other = (WorkingSection) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.WorkingSection[ id=" + id + " ]";
    }
    
}
