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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "designation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Designation.findAll", query = "SELECT d FROM Designation d")
    , @NamedQuery(name = "Designation.findById", query = "SELECT d FROM Designation d WHERE d.id = :id")
    , @NamedQuery(name = "Designation.findByName", query = "SELECT d FROM Designation d WHERE d.name = :name")})
public class Designation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 450)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "designationId")
    private Collection<EmployeePosisionManager> employeePosisionManagerCollection;
    @OneToMany(mappedBy = "designationId")
    private Collection<Employee> employeeCollection;
    @JoinColumn(name = "designation_grade_id", referencedColumnName = "id")
    @ManyToOne
    private DesignationGrade designationGradeId;
    @JoinColumn(name = "designation_level_id_dl", referencedColumnName = "id")
    @ManyToOne
    private DesignationLevel designationLevelIdDl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "designationId")
    private Collection<OrgDesignation> orgDesignationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "designationId")
    private Collection<DesignationLevelManager> designationLevelManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "designationId")
    private Collection<GupGopDesignationManager> gupGopDesignationManagerCollection;

    public Designation() {
    }

    public Designation(Integer id) {
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

    @XmlTransient
    public Collection<EmployeePosisionManager> getEmployeePosisionManagerCollection() {
        return employeePosisionManagerCollection;
    }

    public void setEmployeePosisionManagerCollection(Collection<EmployeePosisionManager> employeePosisionManagerCollection) {
        this.employeePosisionManagerCollection = employeePosisionManagerCollection;
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    public DesignationGrade getDesignationGradeId() {
        return designationGradeId;
    }

    public void setDesignationGradeId(DesignationGrade designationGradeId) {
        this.designationGradeId = designationGradeId;
    }

    public DesignationLevel getDesignationLevelIdDl() {
        return designationLevelIdDl;
    }

    public void setDesignationLevelIdDl(DesignationLevel designationLevelIdDl) {
        this.designationLevelIdDl = designationLevelIdDl;
    }

    @XmlTransient
    public Collection<OrgDesignation> getOrgDesignationCollection() {
        return orgDesignationCollection;
    }

    public void setOrgDesignationCollection(Collection<OrgDesignation> orgDesignationCollection) {
        this.orgDesignationCollection = orgDesignationCollection;
    }

    @XmlTransient
    public Collection<DesignationLevelManager> getDesignationLevelManagerCollection() {
        return designationLevelManagerCollection;
    }

    public void setDesignationLevelManagerCollection(Collection<DesignationLevelManager> designationLevelManagerCollection) {
        this.designationLevelManagerCollection = designationLevelManagerCollection;
    }

    @XmlTransient
    public Collection<GupGopDesignationManager> getGupGopDesignationManagerCollection() {
        return gupGopDesignationManagerCollection;
    }

    public void setGupGopDesignationManagerCollection(Collection<GupGopDesignationManager> gupGopDesignationManagerCollection) {
        this.gupGopDesignationManagerCollection = gupGopDesignationManagerCollection;
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
        if (!(object instanceof Designation)) {
            return false;
        }
        Designation other = (Designation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.Designation[ id=" + id + " ]";
    }
    
}
