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
import javax.persistence.Lob;
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
@Table(name = "entity_attributes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntityAttributes.findAll", query = "SELECT e FROM EntityAttributes e")
    , @NamedQuery(name = "EntityAttributes.findById", query = "SELECT e FROM EntityAttributes e WHERE e.id = :id")
    , @NamedQuery(name = "EntityAttributes.findByName", query = "SELECT e FROM EntityAttributes e WHERE e.name = :name")
    , @NamedQuery(name = "EntityAttributes.findByIsCompalsary", query = "SELECT e FROM EntityAttributes e WHERE e.isCompalsary = :isCompalsary")})
public class EntityAttributes implements Serializable {

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
    @Column(name = "is_compalsary")
    private Boolean isCompalsary;
    @JoinColumn(name = "entity_detail_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EntityDetail entityDetailId;

    public EntityAttributes() {
    }

    public EntityAttributes(Integer id) {
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

    public Boolean getIsCompalsary() {
        return isCompalsary;
    }

    public void setIsCompalsary(Boolean isCompalsary) {
        this.isCompalsary = isCompalsary;
    }

    public EntityDetail getEntityDetailId() {
        return entityDetailId;
    }

    public void setEntityDetailId(EntityDetail entityDetailId) {
        this.entityDetailId = entityDetailId;
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
        if (!(object instanceof EntityAttributes)) {
            return false;
        }
        EntityAttributes other = (EntityAttributes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.EntityAttributes[ id=" + id + " ]";
    }
    
}
