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
@Table(name = "basic_salary_controller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BasicSalaryController.findAll", query = "SELECT b FROM BasicSalaryController b")
    , @NamedQuery(name = "BasicSalaryController.findById", query = "SELECT b FROM BasicSalaryController b WHERE b.id = :id")})
public class BasicSalaryController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "age_group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AgeGroup ageGroupId;
    @JoinColumn(name = "job_hierarchy_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private JobHierarchy jobHierarchyId;
    @JoinColumn(name = "job_level_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private JobLevel jobLevelId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "basicSalaryControllerId")
    private Collection<UniversalBasicSalaryCalculation> universalBasicSalaryCalculationCollection;

    public BasicSalaryController() {
    }

    public BasicSalaryController(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AgeGroup getAgeGroupId() {
        return ageGroupId;
    }

    public void setAgeGroupId(AgeGroup ageGroupId) {
        this.ageGroupId = ageGroupId;
    }

    public JobHierarchy getJobHierarchyId() {
        return jobHierarchyId;
    }

    public void setJobHierarchyId(JobHierarchy jobHierarchyId) {
        this.jobHierarchyId = jobHierarchyId;
    }

    public JobLevel getJobLevelId() {
        return jobLevelId;
    }

    public void setJobLevelId(JobLevel jobLevelId) {
        this.jobLevelId = jobLevelId;
    }

    @XmlTransient
    public Collection<UniversalBasicSalaryCalculation> getUniversalBasicSalaryCalculationCollection() {
        return universalBasicSalaryCalculationCollection;
    }

    public void setUniversalBasicSalaryCalculationCollection(Collection<UniversalBasicSalaryCalculation> universalBasicSalaryCalculationCollection) {
        this.universalBasicSalaryCalculationCollection = universalBasicSalaryCalculationCollection;
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
        if (!(object instanceof BasicSalaryController)) {
            return false;
        }
        BasicSalaryController other = (BasicSalaryController) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.BasicSalaryController[ id=" + id + " ]";
    }
    
}
