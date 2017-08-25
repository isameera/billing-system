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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "student_group_project")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentGroupProject.findAll", query = "SELECT s FROM StudentGroupProject s")
    , @NamedQuery(name = "StudentGroupProject.findById", query = "SELECT s FROM StudentGroupProject s WHERE s.id = :id")
    , @NamedQuery(name = "StudentGroupProject.findByName", query = "SELECT s FROM StudentGroupProject s WHERE s.name = :name")
    , @NamedQuery(name = "StudentGroupProject.findByMarks", query = "SELECT s FROM StudentGroupProject s WHERE s.marks = :marks")
    , @NamedQuery(name = "StudentGroupProject.findByStartDate", query = "SELECT s FROM StudentGroupProject s WHERE s.startDate = :startDate")
    , @NamedQuery(name = "StudentGroupProject.findByEndDate", query = "SELECT s FROM StudentGroupProject s WHERE s.endDate = :endDate")
    , @NamedQuery(name = "StudentGroupProject.findByIsCloud", query = "SELECT s FROM StudentGroupProject s WHERE s.isCloud = :isCloud")
    , @NamedQuery(name = "StudentGroupProject.findByIsPaid", query = "SELECT s FROM StudentGroupProject s WHERE s.isPaid = :isPaid")})
public class StudentGroupProject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "marks")
    private String marks;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Size(max = 45)
    @Column(name = "end_date")
    private String endDate;
    @Column(name = "is_cloud")
    private Integer isCloud;
    @Column(name = "is_paid")
    private Integer isPaid;
    @JoinColumn(name = "batch_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Batch batchId;

    public StudentGroupProject() {
    }

    public StudentGroupProject(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getIsCloud() {
        return isCloud;
    }

    public void setIsCloud(Integer isCloud) {
        this.isCloud = isCloud;
    }

    public Integer getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Integer isPaid) {
        this.isPaid = isPaid;
    }

    public Batch getBatchId() {
        return batchId;
    }

    public void setBatchId(Batch batchId) {
        this.batchId = batchId;
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
        if (!(object instanceof StudentGroupProject)) {
            return false;
        }
        StudentGroupProject other = (StudentGroupProject) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.StudentGroupProject[ id=" + id + " ]";
    }
    
}
