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
@Table(name = "user_document_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserDocumentType.findAll", query = "SELECT u FROM UserDocumentType u")
    , @NamedQuery(name = "UserDocumentType.findById", query = "SELECT u FROM UserDocumentType u WHERE u.id = :id")
    , @NamedQuery(name = "UserDocumentType.findByName", query = "SELECT u FROM UserDocumentType u WHERE u.name = :name")})
public class UserDocumentType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userDocumentTypeId")
    private Collection<UserDocumentCategory> userDocumentCategoryCollection;

    public UserDocumentType() {
    }

    public UserDocumentType(Integer id) {
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
    public Collection<UserDocumentCategory> getUserDocumentCategoryCollection() {
        return userDocumentCategoryCollection;
    }

    public void setUserDocumentCategoryCollection(Collection<UserDocumentCategory> userDocumentCategoryCollection) {
        this.userDocumentCategoryCollection = userDocumentCategoryCollection;
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
        if (!(object instanceof UserDocumentType)) {
            return false;
        }
        UserDocumentType other = (UserDocumentType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UserDocumentType[ id=" + id + " ]";
    }
    
}
