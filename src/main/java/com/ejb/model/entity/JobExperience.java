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
@Table(name = "job_experience")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobExperience.findAll", query = "SELECT j FROM JobExperience j")
    , @NamedQuery(name = "JobExperience.findById", query = "SELECT j FROM JobExperience j WHERE j.id = :id")
    , @NamedQuery(name = "JobExperience.findByName", query = "SELECT j FROM JobExperience j WHERE j.name = :name")
    , @NamedQuery(name = "JobExperience.findByValue", query = "SELECT j FROM JobExperience j WHERE j.value = :value")})
public class JobExperience implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "value")
    private Double value;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobExperienceId")
    private Collection<UniversalBasicSalaryCalculation> universalBasicSalaryCalculationCollection;

    public JobExperience() {
    }

    public JobExperience(Integer id) {
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
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
        if (!(object instanceof JobExperience)) {
            return false;
        }
        JobExperience other = (JobExperience) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.JobExperience[ id=" + id + " ]";
    }
    
}
