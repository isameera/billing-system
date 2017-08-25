/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "org_designation_grade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrgDesignationGrade.findAll", query = "SELECT o FROM OrgDesignationGrade o")
    , @NamedQuery(name = "OrgDesignationGrade.findById", query = "SELECT o FROM OrgDesignationGrade o WHERE o.id = :id")
    , @NamedQuery(name = "OrgDesignationGrade.findByAmount", query = "SELECT o FROM OrgDesignationGrade o WHERE o.amount = :amount")})
public class OrgDesignationGrade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @JoinColumn(name = "designation_grade_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DesignationGrade designationGradeId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;

    public OrgDesignationGrade() {
    }

    public OrgDesignationGrade(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public DesignationGrade getDesignationGradeId() {
        return designationGradeId;
    }

    public void setDesignationGradeId(DesignationGrade designationGradeId) {
        this.designationGradeId = designationGradeId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
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
        if (!(object instanceof OrgDesignationGrade)) {
            return false;
        }
        OrgDesignationGrade other = (OrgDesignationGrade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.OrgDesignationGrade[ id=" + id + " ]";
    }
    
}
