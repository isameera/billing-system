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
@Table(name = "finger_print_machine_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FingerPrintMachineUser.findAll", query = "SELECT f FROM FingerPrintMachineUser f")
    , @NamedQuery(name = "FingerPrintMachineUser.findById", query = "SELECT f FROM FingerPrintMachineUser f WHERE f.id = :id")})
public class FingerPrintMachineUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "finger_print_machine_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FingerPrintMachine fingerPrintMachineId;
    @JoinColumn(name = "finger_print_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FingerPrintUser fingerPrintUserId;

    public FingerPrintMachineUser() {
    }

    public FingerPrintMachineUser(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FingerPrintMachine getFingerPrintMachineId() {
        return fingerPrintMachineId;
    }

    public void setFingerPrintMachineId(FingerPrintMachine fingerPrintMachineId) {
        this.fingerPrintMachineId = fingerPrintMachineId;
    }

    public FingerPrintUser getFingerPrintUserId() {
        return fingerPrintUserId;
    }

    public void setFingerPrintUserId(FingerPrintUser fingerPrintUserId) {
        this.fingerPrintUserId = fingerPrintUserId;
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
        if (!(object instanceof FingerPrintMachineUser)) {
            return false;
        }
        FingerPrintMachineUser other = (FingerPrintMachineUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.FingerPrintMachineUser[ id=" + id + " ]";
    }
    
}
