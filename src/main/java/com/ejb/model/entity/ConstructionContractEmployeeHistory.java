/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "construction_contract_employee_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConstructionContractEmployeeHistory.findAll", query = "SELECT c FROM ConstructionContractEmployeeHistory c")
    , @NamedQuery(name = "ConstructionContractEmployeeHistory.findById", query = "SELECT c FROM ConstructionContractEmployeeHistory c WHERE c.id = :id")
    , @NamedQuery(name = "ConstructionContractEmployeeHistory.findByDateFrom", query = "SELECT c FROM ConstructionContractEmployeeHistory c WHERE c.dateFrom = :dateFrom")
    , @NamedQuery(name = "ConstructionContractEmployeeHistory.findByDateTo", query = "SELECT c FROM ConstructionContractEmployeeHistory c WHERE c.dateTo = :dateTo")
    , @NamedQuery(name = "ConstructionContractEmployeeHistory.findByReference", query = "SELECT c FROM ConstructionContractEmployeeHistory c WHERE c.reference = :reference")})
public class ConstructionContractEmployeeHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_from")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Column(name = "date_to")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    @Column(name = "reference")
    private Integer reference;
    @JoinColumn(name = "entered_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee enteredBy;
    @JoinColumn(name = "org_or_contract_selector_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrgOrContractSelector orgOrContractSelectorId;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;

    public ConstructionContractEmployeeHistory() {
    }

    public ConstructionContractEmployeeHistory(Integer id) {
        this.id = id;
    }

    public ConstructionContractEmployeeHistory(Integer id, Date dateFrom) {
        this.id = id;
        this.dateFrom = dateFrom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public Employee getEnteredBy() {
        return enteredBy;
    }

    public void setEnteredBy(Employee enteredBy) {
        this.enteredBy = enteredBy;
    }

    public OrgOrContractSelector getOrgOrContractSelectorId() {
        return orgOrContractSelectorId;
    }

    public void setOrgOrContractSelectorId(OrgOrContractSelector orgOrContractSelectorId) {
        this.orgOrContractSelectorId = orgOrContractSelectorId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
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
        if (!(object instanceof ConstructionContractEmployeeHistory)) {
            return false;
        }
        ConstructionContractEmployeeHistory other = (ConstructionContractEmployeeHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ConstructionContractEmployeeHistory[ id=" + id + " ]";
    }
    
}
