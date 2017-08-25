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
@Table(name = "advance_request_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdvanceRequestManager.findAll", query = "SELECT a FROM AdvanceRequestManager a")
    , @NamedQuery(name = "AdvanceRequestManager.findById", query = "SELECT a FROM AdvanceRequestManager a WHERE a.id = :id")
    , @NamedQuery(name = "AdvanceRequestManager.findByReference", query = "SELECT a FROM AdvanceRequestManager a WHERE a.reference = :reference")})
public class AdvanceRequestManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "reference")
    private Integer reference;
    @JoinColumn(name = "departments_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Departments departmentsId;
    @JoinColumn(name = "org_or_contract_selector_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrgOrContractSelector orgOrContractSelectorId;
    @JoinColumn(name = "voucher_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Voucher voucherId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "advanceRequestManagerId")
    private Collection<AdvanceRequestDocuments> advanceRequestDocumentsCollection;

    public AdvanceRequestManager() {
    }

    public AdvanceRequestManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public Departments getDepartmentsId() {
        return departmentsId;
    }

    public void setDepartmentsId(Departments departmentsId) {
        this.departmentsId = departmentsId;
    }

    public OrgOrContractSelector getOrgOrContractSelectorId() {
        return orgOrContractSelectorId;
    }

    public void setOrgOrContractSelectorId(OrgOrContractSelector orgOrContractSelectorId) {
        this.orgOrContractSelectorId = orgOrContractSelectorId;
    }

    public Voucher getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Voucher voucherId) {
        this.voucherId = voucherId;
    }

    @XmlTransient
    public Collection<AdvanceRequestDocuments> getAdvanceRequestDocumentsCollection() {
        return advanceRequestDocumentsCollection;
    }

    public void setAdvanceRequestDocumentsCollection(Collection<AdvanceRequestDocuments> advanceRequestDocumentsCollection) {
        this.advanceRequestDocumentsCollection = advanceRequestDocumentsCollection;
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
        if (!(object instanceof AdvanceRequestManager)) {
            return false;
        }
        AdvanceRequestManager other = (AdvanceRequestManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.AdvanceRequestManager[ id=" + id + " ]";
    }
    
}
