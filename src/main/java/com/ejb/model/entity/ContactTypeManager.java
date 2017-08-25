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
@Table(name = "contact_type_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactTypeManager.findAll", query = "SELECT c FROM ContactTypeManager c")
    , @NamedQuery(name = "ContactTypeManager.findById", query = "SELECT c FROM ContactTypeManager c WHERE c.id = :id")})
public class ContactTypeManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "contact_person_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ContactPerson contactPersonId;
    @JoinColumn(name = "contact_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ContactType contactTypeId;

    public ContactTypeManager() {
    }

    public ContactTypeManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ContactPerson getContactPersonId() {
        return contactPersonId;
    }

    public void setContactPersonId(ContactPerson contactPersonId) {
        this.contactPersonId = contactPersonId;
    }

    public ContactType getContactTypeId() {
        return contactTypeId;
    }

    public void setContactTypeId(ContactType contactTypeId) {
        this.contactTypeId = contactTypeId;
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
        if (!(object instanceof ContactTypeManager)) {
            return false;
        }
        ContactTypeManager other = (ContactTypeManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ContactTypeManager[ id=" + id + " ]";
    }
    
}
