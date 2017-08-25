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
@Table(name = "social_media_universal_post_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SocialMediaUniversalPostType.findAll", query = "SELECT s FROM SocialMediaUniversalPostType s")
    , @NamedQuery(name = "SocialMediaUniversalPostType.findById", query = "SELECT s FROM SocialMediaUniversalPostType s WHERE s.id = :id")
    , @NamedQuery(name = "SocialMediaUniversalPostType.findByName", query = "SELECT s FROM SocialMediaUniversalPostType s WHERE s.name = :name")})
public class SocialMediaUniversalPostType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaUniversalPostTypeId")
    private Collection<SocialMediaUnivarsalPost> socialMediaUnivarsalPostCollection;

    public SocialMediaUniversalPostType() {
    }

    public SocialMediaUniversalPostType(Integer id) {
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
    public Collection<SocialMediaUnivarsalPost> getSocialMediaUnivarsalPostCollection() {
        return socialMediaUnivarsalPostCollection;
    }

    public void setSocialMediaUnivarsalPostCollection(Collection<SocialMediaUnivarsalPost> socialMediaUnivarsalPostCollection) {
        this.socialMediaUnivarsalPostCollection = socialMediaUnivarsalPostCollection;
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
        if (!(object instanceof SocialMediaUniversalPostType)) {
            return false;
        }
        SocialMediaUniversalPostType other = (SocialMediaUniversalPostType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SocialMediaUniversalPostType[ id=" + id + " ]";
    }
    
}
