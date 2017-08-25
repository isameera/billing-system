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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "contact_person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactPerson.findAll", query = "SELECT c FROM ContactPerson c")
    , @NamedQuery(name = "ContactPerson.findById", query = "SELECT c FROM ContactPerson c WHERE c.id = :id")})
public class ContactPerson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactPersonId")
    private Collection<ContactTypeManager> contactTypeManagerCollection;
    @JoinColumn(name = "general_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUser;
    @JoinColumn(name = "contact_person", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile contactPerson;
    @JoinColumn(name = "relationship_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Relationship relationshipId;

    public ContactPerson() {
    }

    public ContactPerson(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<ContactTypeManager> getContactTypeManagerCollection() {
        return contactTypeManagerCollection;
    }

    public void setContactTypeManagerCollection(Collection<ContactTypeManager> contactTypeManagerCollection) {
        this.contactTypeManagerCollection = contactTypeManagerCollection;
    }

    public GeneralUserProfile getGeneralUser() {
        return generalUser;
    }

    public void setGeneralUser(GeneralUserProfile generalUser) {
        this.generalUser = generalUser;
    }

    public GeneralUserProfile getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(GeneralUserProfile contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Relationship getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(Relationship relationshipId) {
        this.relationshipId = relationshipId;
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
        if (!(object instanceof ContactPerson)) {
            return false;
        }
        ContactPerson other = (ContactPerson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ContactPerson[ id=" + id + " ]";
    }
    
}
