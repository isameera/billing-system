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
@Table(name = "construction_site_employee_attendance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConstructionSiteEmployeeAttendance.findAll", query = "SELECT c FROM ConstructionSiteEmployeeAttendance c")
    , @NamedQuery(name = "ConstructionSiteEmployeeAttendance.findById", query = "SELECT c FROM ConstructionSiteEmployeeAttendance c WHERE c.id = :id")})
public class ConstructionSiteEmployeeAttendance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "atendence_registry_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AtendenceRegistry atendenceRegistryId;
    @JoinColumn(name = "construction_contract_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ConstructionContract constructionContractId;

    public ConstructionSiteEmployeeAttendance() {
    }

    public ConstructionSiteEmployeeAttendance(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AtendenceRegistry getAtendenceRegistryId() {
        return atendenceRegistryId;
    }

    public void setAtendenceRegistryId(AtendenceRegistry atendenceRegistryId) {
        this.atendenceRegistryId = atendenceRegistryId;
    }

    public ConstructionContract getConstructionContractId() {
        return constructionContractId;
    }

    public void setConstructionContractId(ConstructionContract constructionContractId) {
        this.constructionContractId = constructionContractId;
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
        if (!(object instanceof ConstructionSiteEmployeeAttendance)) {
            return false;
        }
        ConstructionSiteEmployeeAttendance other = (ConstructionSiteEmployeeAttendance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ConstructionSiteEmployeeAttendance[ id=" + id + " ]";
    }
    
}
