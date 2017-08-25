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
@Table(name = "relationship")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relationship.findAll", query = "SELECT r FROM Relationship r")
    , @NamedQuery(name = "Relationship.findById", query = "SELECT r FROM Relationship r WHERE r.id = :id")
    , @NamedQuery(name = "Relationship.findByName", query = "SELECT r FROM Relationship r WHERE r.name = :name")})
public class Relationship implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 450)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "relationshipId")
    private Collection<ContactPerson> contactPersonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "relationshipId")
    private Collection<FamilyMembers> familyMembersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "familyMemberRelationshipId")
    private Collection<FamilyMemberDetails> familyMemberDetailsCollection;

    public Relationship() {
    }

    public Relationship(Integer id) {
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
    public Collection<ContactPerson> getContactPersonCollection() {
        return contactPersonCollection;
    }

    public void setContactPersonCollection(Collection<ContactPerson> contactPersonCollection) {
        this.contactPersonCollection = contactPersonCollection;
    }

    @XmlTransient
    public Collection<FamilyMembers> getFamilyMembersCollection() {
        return familyMembersCollection;
    }

    public void setFamilyMembersCollection(Collection<FamilyMembers> familyMembersCollection) {
        this.familyMembersCollection = familyMembersCollection;
    }

    @XmlTransient
    public Collection<FamilyMemberDetails> getFamilyMemberDetailsCollection() {
        return familyMemberDetailsCollection;
    }

    public void setFamilyMemberDetailsCollection(Collection<FamilyMemberDetails> familyMemberDetailsCollection) {
        this.familyMemberDetailsCollection = familyMemberDetailsCollection;
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
        if (!(object instanceof Relationship)) {
            return false;
        }
        Relationship other = (Relationship) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.Relationship[ id=" + id + " ]";
    }
    
}
