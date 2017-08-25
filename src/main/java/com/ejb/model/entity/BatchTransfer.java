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
@Table(name = "batch_transfer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BatchTransfer.findAll", query = "SELECT b FROM BatchTransfer b")
    , @NamedQuery(name = "BatchTransfer.findById", query = "SELECT b FROM BatchTransfer b WHERE b.id = :id")
    , @NamedQuery(name = "BatchTransfer.findByDate", query = "SELECT b FROM BatchTransfer b WHERE b.date = :date")
    , @NamedQuery(name = "BatchTransfer.findByFee", query = "SELECT b FROM BatchTransfer b WHERE b.fee = :fee")
    , @NamedQuery(name = "BatchTransfer.findByReson", query = "SELECT b FROM BatchTransfer b WHERE b.reson = :reson")})
public class BatchTransfer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fee")
    private Double fee;
    @Size(max = 450)
    @Column(name = "reson")
    private String reson;
    @JoinColumn(name = "batch__from", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Batch batchFrom;
    @JoinColumn(name = "batch_to", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Batch batchTo;
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Student studentId;

    public BatchTransfer() {
    }

    public BatchTransfer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getReson() {
        return reson;
    }

    public void setReson(String reson) {
        this.reson = reson;
    }

    public Batch getBatchFrom() {
        return batchFrom;
    }

    public void setBatchFrom(Batch batchFrom) {
        this.batchFrom = batchFrom;
    }

    public Batch getBatchTo() {
        return batchTo;
    }

    public void setBatchTo(Batch batchTo) {
        this.batchTo = batchTo;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
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
        if (!(object instanceof BatchTransfer)) {
            return false;
        }
        BatchTransfer other = (BatchTransfer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.BatchTransfer[ id=" + id + " ]";
    }
    
}
