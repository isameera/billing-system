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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "gn_division")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GnDivision.findAll", query = "SELECT g FROM GnDivision g")
    , @NamedQuery(name = "GnDivision.findById", query = "SELECT g FROM GnDivision g WHERE g.id = :id")
    , @NamedQuery(name = "GnDivision.findByName", query = "SELECT g FROM GnDivision g WHERE g.name = :name")})
public class GnDivision implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "divisional_secretariat_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DivisionalSecretariat divisionalSecretariatId;

    public GnDivision() {
    }

    public GnDivision(Integer id) {
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

    public DivisionalSecretariat getDivisionalSecretariatId() {
        return divisionalSecretariatId;
    }

    public void setDivisionalSecretariatId(DivisionalSecretariat divisionalSecretariatId) {
        this.divisionalSecretariatId = divisionalSecretariatId;
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
        if (!(object instanceof GnDivision)) {
            return false;
        }
        GnDivision other = (GnDivision) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.GnDivision[ id=" + id + " ]";
    }
    
}
