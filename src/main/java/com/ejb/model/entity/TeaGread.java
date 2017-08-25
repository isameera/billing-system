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
import javax.persistence.Lob;
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
@Table(name = "tea_gread")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TeaGread.findAll", query = "SELECT t FROM TeaGread t")
    , @NamedQuery(name = "TeaGread.findById", query = "SELECT t FROM TeaGread t WHERE t.id = :id")
    , @NamedQuery(name = "TeaGread.findByName", query = "SELECT t FROM TeaGread t WHERE t.name = :name")
    , @NamedQuery(name = "TeaGread.findByRate", query = "SELECT t FROM TeaGread t WHERE t.rate = :rate")})
public class TeaGread implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rate")
    private Double rate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teaGreadId")
    private Collection<TeaGreadHistory> teaGreadHistoryCollection;

    public TeaGread() {
    }

    public TeaGread(Integer id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @XmlTransient
    public Collection<TeaGreadHistory> getTeaGreadHistoryCollection() {
        return teaGreadHistoryCollection;
    }

    public void setTeaGreadHistoryCollection(Collection<TeaGreadHistory> teaGreadHistoryCollection) {
        this.teaGreadHistoryCollection = teaGreadHistoryCollection;
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
        if (!(object instanceof TeaGread)) {
            return false;
        }
        TeaGread other = (TeaGread) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.TeaGread[ id=" + id + " ]";
    }
    
}
