/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "finger_print_attendance_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FingerPrintAttendanceData.findAll", query = "SELECT f FROM FingerPrintAttendanceData f")
    , @NamedQuery(name = "FingerPrintAttendanceData.findById", query = "SELECT f FROM FingerPrintAttendanceData f WHERE f.id = :id")
    , @NamedQuery(name = "FingerPrintAttendanceData.findByCheckout", query = "SELECT f FROM FingerPrintAttendanceData f WHERE f.checkout = :checkout")
    , @NamedQuery(name = "FingerPrintAttendanceData.findByIsSynced", query = "SELECT f FROM FingerPrintAttendanceData f WHERE f.isSynced = :isSynced")
    , @NamedQuery(name = "FingerPrintAttendanceData.findByIsSmsSent", query = "SELECT f FROM FingerPrintAttendanceData f WHERE f.isSmsSent = :isSmsSent")})
public class FingerPrintAttendanceData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "checkout")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkout;
    @Column(name = "is_synced")
    private Boolean isSynced;
    @Column(name = "is_sms_sent")
    private Boolean isSmsSent;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fingerPrintAttendanceDataId")
    private Collection<FingerPrintEmployeeAttendance> fingerPrintEmployeeAttendanceCollection;
    @JoinColumn(name = "finger_print_machine_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FingerPrintMachine fingerPrintMachineId;

    public FingerPrintAttendanceData() {
    }

    public FingerPrintAttendanceData(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Boolean getIsSynced() {
        return isSynced;
    }

    public void setIsSynced(Boolean isSynced) {
        this.isSynced = isSynced;
    }

    public Boolean getIsSmsSent() {
        return isSmsSent;
    }

    public void setIsSmsSent(Boolean isSmsSent) {
        this.isSmsSent = isSmsSent;
    }

    @XmlTransient
    public Collection<FingerPrintEmployeeAttendance> getFingerPrintEmployeeAttendanceCollection() {
        return fingerPrintEmployeeAttendanceCollection;
    }

    public void setFingerPrintEmployeeAttendanceCollection(Collection<FingerPrintEmployeeAttendance> fingerPrintEmployeeAttendanceCollection) {
        this.fingerPrintEmployeeAttendanceCollection = fingerPrintEmployeeAttendanceCollection;
    }

    public FingerPrintMachine getFingerPrintMachineId() {
        return fingerPrintMachineId;
    }

    public void setFingerPrintMachineId(FingerPrintMachine fingerPrintMachineId) {
        this.fingerPrintMachineId = fingerPrintMachineId;
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
        if (!(object instanceof FingerPrintAttendanceData)) {
            return false;
        }
        FingerPrintAttendanceData other = (FingerPrintAttendanceData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.FingerPrintAttendanceData[ id=" + id + " ]";
    }
    
}
