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
@Table(name = "user_document_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserDocumentCategory.findAll", query = "SELECT u FROM UserDocumentCategory u")
    , @NamedQuery(name = "UserDocumentCategory.findById", query = "SELECT u FROM UserDocumentCategory u WHERE u.id = :id")
    , @NamedQuery(name = "UserDocumentCategory.findByName", query = "SELECT u FROM UserDocumentCategory u WHERE u.name = :name")})
public class UserDocumentCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "user_document_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserDocumentType userDocumentTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userDocumentCategoryId")
    private Collection<UserDocument> userDocumentCollection;

    public UserDocumentCategory() {
    }

    public UserDocumentCategory(Integer id) {
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

    public UserDocumentType getUserDocumentTypeId() {
        return userDocumentTypeId;
    }

    public void setUserDocumentTypeId(UserDocumentType userDocumentTypeId) {
        this.userDocumentTypeId = userDocumentTypeId;
    }

    @XmlTransient
    public Collection<UserDocument> getUserDocumentCollection() {
        return userDocumentCollection;
    }

    public void setUserDocumentCollection(Collection<UserDocument> userDocumentCollection) {
        this.userDocumentCollection = userDocumentCollection;
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
        if (!(object instanceof UserDocumentCategory)) {
            return false;
        }
        UserDocumentCategory other = (UserDocumentCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UserDocumentCategory[ id=" + id + " ]";
    }
    
}
