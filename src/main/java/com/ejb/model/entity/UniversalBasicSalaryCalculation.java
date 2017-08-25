/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "universal_basic_salary_calculation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniversalBasicSalaryCalculation.findAll", query = "SELECT u FROM UniversalBasicSalaryCalculation u")
    , @NamedQuery(name = "UniversalBasicSalaryCalculation.findById", query = "SELECT u FROM UniversalBasicSalaryCalculation u WHERE u.id = :id")
    , @NamedQuery(name = "UniversalBasicSalaryCalculation.findBySalary", query = "SELECT u FROM UniversalBasicSalaryCalculation u WHERE u.salary = :salary")})
public class UniversalBasicSalaryCalculation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salary")
    private Double salary;
    @OneToMany(mappedBy = "universalBasicSalaryCalculationId")
    private Collection<Employee> employeeCollection;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "job_experience_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private JobExperience jobExperienceId;
    @JoinColumn(name = "basic_salary_controller_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BasicSalaryController basicSalaryControllerId;

    public UniversalBasicSalaryCalculation() {
    }

    public UniversalBasicSalaryCalculation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public JobExperience getJobExperienceId() {
        return jobExperienceId;
    }

    public void setJobExperienceId(JobExperience jobExperienceId) {
        this.jobExperienceId = jobExperienceId;
    }

    public BasicSalaryController getBasicSalaryControllerId() {
        return basicSalaryControllerId;
    }

    public void setBasicSalaryControllerId(BasicSalaryController basicSalaryControllerId) {
        this.basicSalaryControllerId = basicSalaryControllerId;
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
        if (!(object instanceof UniversalBasicSalaryCalculation)) {
            return false;
        }
        UniversalBasicSalaryCalculation other = (UniversalBasicSalaryCalculation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UniversalBasicSalaryCalculation[ id=" + id + " ]";
    }
    
}
