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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "gup_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GupType.findAll", query = "SELECT g FROM GupType g")
    , @NamedQuery(name = "GupType.findById", query = "SELECT g FROM GupType g WHERE g.id = :id")
    , @NamedQuery(name = "GupType.findByName", query = "SELECT g FROM GupType g WHERE g.name = :name")})
public class GupType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gupTypeId")
    private Collection<WelfareManager> welfareManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gupTypeId")
    private Collection<LoanMaster> loanMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gupTypeId")
    private Collection<GupTypeManager> gupTypeManagerCollection;

    public GupType() {
    }

    public GupType(Integer id) {
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

    @XmlTransient
    public Collection<WelfareManager> getWelfareManagerCollection() {
        return welfareManagerCollection;
    }

    public void setWelfareManagerCollection(Collection<WelfareManager> welfareManagerCollection) {
        this.welfareManagerCollection = welfareManagerCollection;
    }

    @XmlTransient
    public Collection<LoanMaster> getLoanMasterCollection() {
        return loanMasterCollection;
    }

    public void setLoanMasterCollection(Collection<LoanMaster> loanMasterCollection) {
        this.loanMasterCollection = loanMasterCollection;
    }

    @XmlTransient
    public Collection<GupTypeManager> getGupTypeManagerCollection() {
        return gupTypeManagerCollection;
    }

    public void setGupTypeManagerCollection(Collection<GupTypeManager> gupTypeManagerCollection) {
        this.gupTypeManagerCollection = gupTypeManagerCollection;
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
        if (!(object instanceof GupType)) {
            return false;
        }
        GupType other = (GupType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.GupType[ id=" + id + " ]";
    }
    
}
