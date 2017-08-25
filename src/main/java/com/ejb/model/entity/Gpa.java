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
@Table(name = "gpa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gpa.findAll", query = "SELECT g FROM Gpa g")
    , @NamedQuery(name = "Gpa.findById", query = "SELECT g FROM Gpa g WHERE g.id = :id")
    , @NamedQuery(name = "Gpa.findByValue", query = "SELECT g FROM Gpa g WHERE g.value = :value")})
public class Gpa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "value")
    private Double value;
    @JoinColumn(name = "qualification_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private QualificationManager qualificationManagerId;

    public Gpa() {
    }

    public Gpa(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public QualificationManager getQualificationManagerId() {
        return qualificationManagerId;
    }

    public void setQualificationManagerId(QualificationManager qualificationManagerId) {
        this.qualificationManagerId = qualificationManagerId;
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
        if (!(object instanceof Gpa)) {
            return false;
        }
        Gpa other = (Gpa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.Gpa[ id=" + id + " ]";
    }
    
}
