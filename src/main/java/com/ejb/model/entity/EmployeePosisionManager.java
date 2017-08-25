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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "employee_posision_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeePosisionManager.findAll", query = "SELECT e FROM EmployeePosisionManager e")
    , @NamedQuery(name = "EmployeePosisionManager.findById", query = "SELECT e FROM EmployeePosisionManager e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeePosisionManager.findByDateFrom", query = "SELECT e FROM EmployeePosisionManager e WHERE e.dateFrom = :dateFrom")
    , @NamedQuery(name = "EmployeePosisionManager.findByDateTo", query = "SELECT e FROM EmployeePosisionManager e WHERE e.dateTo = :dateTo")})
public class EmployeePosisionManager implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_to")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "designation_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Designation designationId;
    @JoinColumn(name = "employee_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EmployeeType employeeTypeId;
    @JoinColumn(name = "worked_history_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private WorkedHistory workedHistoryId;

    public EmployeePosisionManager() {
    }

    public EmployeePosisionManager(Integer id) {
        this.id = id;
    }

    public EmployeePosisionManager(Integer id, Date dateFrom, Date dateTo) {
        this.id = id;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Designation getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Designation designationId) {
        this.designationId = designationId;
    }

    public EmployeeType getEmployeeTypeId() {
        return employeeTypeId;
    }

    public void setEmployeeTypeId(EmployeeType employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
    }

    public WorkedHistory getWorkedHistoryId() {
        return workedHistoryId;
    }

    public void setWorkedHistoryId(WorkedHistory workedHistoryId) {
        this.workedHistoryId = workedHistoryId;
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
        if (!(object instanceof EmployeePosisionManager)) {
            return false;
        }
        EmployeePosisionManager other = (EmployeePosisionManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.EmployeePosisionManager[ id=" + id + " ]";
    }
    
}
