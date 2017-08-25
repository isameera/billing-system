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
@Table(name = "gup_gop_designation_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GupGopDesignationManager.findAll", query = "SELECT g FROM GupGopDesignationManager g")
    , @NamedQuery(name = "GupGopDesignationManager.findById", query = "SELECT g FROM GupGopDesignationManager g WHERE g.id = :id")})
public class GupGopDesignationManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "designation_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Designation designationId;
    @JoinColumn(name = "gup_gop_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GupGopManager gupGopManagerId;

    public GupGopDesignationManager() {
    }

    public GupGopDesignationManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Designation getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Designation designationId) {
        this.designationId = designationId;
    }

    public GupGopManager getGupGopManagerId() {
        return gupGopManagerId;
    }

    public void setGupGopManagerId(GupGopManager gupGopManagerId) {
        this.gupGopManagerId = gupGopManagerId;
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
        if (!(object instanceof GupGopDesignationManager)) {
            return false;
        }
        GupGopDesignationManager other = (GupGopDesignationManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.GupGopDesignationManager[ id=" + id + " ]";
    }
    
}
