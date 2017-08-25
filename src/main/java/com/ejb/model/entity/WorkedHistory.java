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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "worked_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkedHistory.findAll", query = "SELECT w FROM WorkedHistory w")
    , @NamedQuery(name = "WorkedHistory.findById", query = "SELECT w FROM WorkedHistory w WHERE w.id = :id")
    , @NamedQuery(name = "WorkedHistory.findByDateFrom", query = "SELECT w FROM WorkedHistory w WHERE w.dateFrom = :dateFrom")
    , @NamedQuery(name = "WorkedHistory.findByDateOfPermanent", query = "SELECT w FROM WorkedHistory w WHERE w.dateOfPermanent = :dateOfPermanent")
    , @NamedQuery(name = "WorkedHistory.findByIsCurrent", query = "SELECT w FROM WorkedHistory w WHERE w.isCurrent = :isCurrent")})
public class WorkedHistory implements Serializable {

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
    @Column(name = "date_of_permanent")
    @Temporal(TemporalType.DATE)
    private Date dateOfPermanent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_current")
    private int isCurrent;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workedHistoryId")
    private Collection<EmployeePosisionManager> employeePosisionManagerCollection;
    @JoinColumn(name = "employees_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeesId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;

    public WorkedHistory() {
    }

    public WorkedHistory(Integer id) {
        this.id = id;
    }

    public WorkedHistory(Integer id, Date dateFrom, int isCurrent) {
        this.id = id;
        this.dateFrom = dateFrom;
        this.isCurrent = isCurrent;
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

    public Date getDateOfPermanent() {
        return dateOfPermanent;
    }

    public void setDateOfPermanent(Date dateOfPermanent) {
        this.dateOfPermanent = dateOfPermanent;
    }

    public int getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(int isCurrent) {
        this.isCurrent = isCurrent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<EmployeePosisionManager> getEmployeePosisionManagerCollection() {
        return employeePosisionManagerCollection;
    }

    public void setEmployeePosisionManagerCollection(Collection<EmployeePosisionManager> employeePosisionManagerCollection) {
        this.employeePosisionManagerCollection = employeePosisionManagerCollection;
    }

    public Employee getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(Employee employeesId) {
        this.employeesId = employeesId;
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
        if (!(object instanceof WorkedHistory)) {
            return false;
        }
        WorkedHistory other = (WorkedHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.WorkedHistory[ id=" + id + " ]";
    }
    
}
