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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "tea_gread_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TeaGreadHistory.findAll", query = "SELECT t FROM TeaGreadHistory t")
    , @NamedQuery(name = "TeaGreadHistory.findById", query = "SELECT t FROM TeaGreadHistory t WHERE t.id = :id")
    , @NamedQuery(name = "TeaGreadHistory.findByCurrentRate", query = "SELECT t FROM TeaGreadHistory t WHERE t.currentRate = :currentRate")
    , @NamedQuery(name = "TeaGreadHistory.findByAssignedDate", query = "SELECT t FROM TeaGreadHistory t WHERE t.assignedDate = :assignedDate")
    , @NamedQuery(name = "TeaGreadHistory.findByAlteredRate", query = "SELECT t FROM TeaGreadHistory t WHERE t.alteredRate = :alteredRate")
    , @NamedQuery(name = "TeaGreadHistory.findByAlteredDate", query = "SELECT t FROM TeaGreadHistory t WHERE t.alteredDate = :alteredDate")})
public class TeaGreadHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "current_rate")
    private Double currentRate;
    @Column(name = "assigned_date")
    @Temporal(TemporalType.DATE)
    private Date assignedDate;
    @Column(name = "altered_rate")
    private Double alteredRate;
    @Column(name = "altered_date")
    @Temporal(TemporalType.DATE)
    private Date alteredDate;
    @JoinColumn(name = "tea_gread_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TeaGread teaGreadId;

    public TeaGreadHistory() {
    }

    public TeaGreadHistory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(Double currentRate) {
        this.currentRate = currentRate;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    public Double getAlteredRate() {
        return alteredRate;
    }

    public void setAlteredRate(Double alteredRate) {
        this.alteredRate = alteredRate;
    }

    public Date getAlteredDate() {
        return alteredDate;
    }

    public void setAlteredDate(Date alteredDate) {
        this.alteredDate = alteredDate;
    }

    public TeaGread getTeaGreadId() {
        return teaGreadId;
    }

    public void setTeaGreadId(TeaGread teaGreadId) {
        this.teaGreadId = teaGreadId;
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
        if (!(object instanceof TeaGreadHistory)) {
            return false;
        }
        TeaGreadHistory other = (TeaGreadHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.TeaGreadHistory[ id=" + id + " ]";
    }
    
}
