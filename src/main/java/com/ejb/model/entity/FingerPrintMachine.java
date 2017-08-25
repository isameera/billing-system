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
@Table(name = "finger_print_machine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FingerPrintMachine.findAll", query = "SELECT f FROM FingerPrintMachine f")
    , @NamedQuery(name = "FingerPrintMachine.findById", query = "SELECT f FROM FingerPrintMachine f WHERE f.id = :id")
    , @NamedQuery(name = "FingerPrintMachine.findBySn", query = "SELECT f FROM FingerPrintMachine f WHERE f.sn = :sn")})
public class FingerPrintMachine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "sn")
    private String sn;
    @JoinColumn(name = "finger_print_machine_model_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FingerPrintMachineModel fingerPrintMachineModelId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fingerPrintMachineId")
    private Collection<FingerPrintMachineUser> fingerPrintMachineUserCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fingerPrintMachineId")
    private Collection<FingerPrintAttendanceData> fingerPrintAttendanceDataCollection;

    public FingerPrintMachine() {
    }

    public FingerPrintMachine(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public FingerPrintMachineModel getFingerPrintMachineModelId() {
        return fingerPrintMachineModelId;
    }

    public void setFingerPrintMachineModelId(FingerPrintMachineModel fingerPrintMachineModelId) {
        this.fingerPrintMachineModelId = fingerPrintMachineModelId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    @XmlTransient
    public Collection<FingerPrintMachineUser> getFingerPrintMachineUserCollection() {
        return fingerPrintMachineUserCollection;
    }

    public void setFingerPrintMachineUserCollection(Collection<FingerPrintMachineUser> fingerPrintMachineUserCollection) {
        this.fingerPrintMachineUserCollection = fingerPrintMachineUserCollection;
    }

    @XmlTransient
    public Collection<FingerPrintAttendanceData> getFingerPrintAttendanceDataCollection() {
        return fingerPrintAttendanceDataCollection;
    }

    public void setFingerPrintAttendanceDataCollection(Collection<FingerPrintAttendanceData> fingerPrintAttendanceDataCollection) {
        this.fingerPrintAttendanceDataCollection = fingerPrintAttendanceDataCollection;
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
        if (!(object instanceof FingerPrintMachine)) {
            return false;
        }
        FingerPrintMachine other = (FingerPrintMachine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.FingerPrintMachine[ id=" + id + " ]";
    }
    
}
