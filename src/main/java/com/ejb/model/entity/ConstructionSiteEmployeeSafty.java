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
@Table(name = "construction_site_employee_safty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConstructionSiteEmployeeSafty.findAll", query = "SELECT c FROM ConstructionSiteEmployeeSafty c")
    , @NamedQuery(name = "ConstructionSiteEmployeeSafty.findById", query = "SELECT c FROM ConstructionSiteEmployeeSafty c WHERE c.id = :id")
    , @NamedQuery(name = "ConstructionSiteEmployeeSafty.findByUniform", query = "SELECT c FROM ConstructionSiteEmployeeSafty c WHERE c.uniform = :uniform")
    , @NamedQuery(name = "ConstructionSiteEmployeeSafty.findByDust", query = "SELECT c FROM ConstructionSiteEmployeeSafty c WHERE c.dust = :dust")})
public class ConstructionSiteEmployeeSafty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "uniform")
    private Boolean uniform;
    @Column(name = "dust")
    private Boolean dust;
    @JoinColumn(name = "atendence_registry_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AtendenceRegistry atendenceRegistryId;
    @JoinColumn(name = "supervisor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee supervisor;

    public ConstructionSiteEmployeeSafty() {
    }

    public ConstructionSiteEmployeeSafty(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getUniform() {
        return uniform;
    }

    public void setUniform(Boolean uniform) {
        this.uniform = uniform;
    }

    public Boolean getDust() {
        return dust;
    }

    public void setDust(Boolean dust) {
        this.dust = dust;
    }

    public AtendenceRegistry getAtendenceRegistryId() {
        return atendenceRegistryId;
    }

    public void setAtendenceRegistryId(AtendenceRegistry atendenceRegistryId) {
        this.atendenceRegistryId = atendenceRegistryId;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
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
        if (!(object instanceof ConstructionSiteEmployeeSafty)) {
            return false;
        }
        ConstructionSiteEmployeeSafty other = (ConstructionSiteEmployeeSafty) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ConstructionSiteEmployeeSafty[ id=" + id + " ]";
    }
    
}
