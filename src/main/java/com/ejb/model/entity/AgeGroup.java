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
@Table(name = "age_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AgeGroup.findAll", query = "SELECT a FROM AgeGroup a")
    , @NamedQuery(name = "AgeGroup.findById", query = "SELECT a FROM AgeGroup a WHERE a.id = :id")
    , @NamedQuery(name = "AgeGroup.findByName", query = "SELECT a FROM AgeGroup a WHERE a.name = :name")
    , @NamedQuery(name = "AgeGroup.findByStartAge", query = "SELECT a FROM AgeGroup a WHERE a.startAge = :startAge")
    , @NamedQuery(name = "AgeGroup.findByEndAge", query = "SELECT a FROM AgeGroup a WHERE a.endAge = :endAge")})
public class AgeGroup implements Serializable {

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
    @Column(name = "start_age")
    private Double startAge;
    @Column(name = "end_age")
    private Double endAge;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ageGroupId")
    private Collection<BasicSalaryController> basicSalaryControllerCollection;

    public AgeGroup() {
    }

    public AgeGroup(Integer id) {
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

    public Double getStartAge() {
        return startAge;
    }

    public void setStartAge(Double startAge) {
        this.startAge = startAge;
    }

    public Double getEndAge() {
        return endAge;
    }

    public void setEndAge(Double endAge) {
        this.endAge = endAge;
    }

    @XmlTransient
    public Collection<BasicSalaryController> getBasicSalaryControllerCollection() {
        return basicSalaryControllerCollection;
    }

    public void setBasicSalaryControllerCollection(Collection<BasicSalaryController> basicSalaryControllerCollection) {
        this.basicSalaryControllerCollection = basicSalaryControllerCollection;
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
        if (!(object instanceof AgeGroup)) {
            return false;
        }
        AgeGroup other = (AgeGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.AgeGroup[ id=" + id + " ]";
    }
    
}
