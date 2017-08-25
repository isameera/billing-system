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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "divisional_secretariat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DivisionalSecretariat.findAll", query = "SELECT d FROM DivisionalSecretariat d")
    , @NamedQuery(name = "DivisionalSecretariat.findById", query = "SELECT d FROM DivisionalSecretariat d WHERE d.id = :id")
    , @NamedQuery(name = "DivisionalSecretariat.findByName", query = "SELECT d FROM DivisionalSecretariat d WHERE d.name = :name")})
public class DivisionalSecretariat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private District districtId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "divisionalSecretariatId")
    private Collection<GnDivision> gnDivisionCollection;

    public DivisionalSecretariat() {
    }

    public DivisionalSecretariat(Integer id) {
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

    public District getDistrictId() {
        return districtId;
    }

    public void setDistrictId(District districtId) {
        this.districtId = districtId;
    }

    @XmlTransient
    public Collection<GnDivision> getGnDivisionCollection() {
        return gnDivisionCollection;
    }

    public void setGnDivisionCollection(Collection<GnDivision> gnDivisionCollection) {
        this.gnDivisionCollection = gnDivisionCollection;
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
        if (!(object instanceof DivisionalSecretariat)) {
            return false;
        }
        DivisionalSecretariat other = (DivisionalSecretariat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.DivisionalSecretariat[ id=" + id + " ]";
    }
    
}
