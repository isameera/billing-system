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
@Table(name = "social_media_feelings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SocialMediaFeelings.findAll", query = "SELECT s FROM SocialMediaFeelings s")
    , @NamedQuery(name = "SocialMediaFeelings.findByInt1", query = "SELECT s FROM SocialMediaFeelings s WHERE s.int1 = :int1")
    , @NamedQuery(name = "SocialMediaFeelings.findByName", query = "SELECT s FROM SocialMediaFeelings s WHERE s.name = :name")})
public class SocialMediaFeelings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "int")
    private Integer int1;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaFeelingsInt")
    private Collection<SocialMediaUnivarsalPostFeelings> socialMediaUnivarsalPostFeelingsCollection;

    public SocialMediaFeelings() {
    }

    public SocialMediaFeelings(Integer int1) {
        this.int1 = int1;
    }

    public Integer getInt1() {
        return int1;
    }

    public void setInt1(Integer int1) {
        this.int1 = int1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<SocialMediaUnivarsalPostFeelings> getSocialMediaUnivarsalPostFeelingsCollection() {
        return socialMediaUnivarsalPostFeelingsCollection;
    }

    public void setSocialMediaUnivarsalPostFeelingsCollection(Collection<SocialMediaUnivarsalPostFeelings> socialMediaUnivarsalPostFeelingsCollection) {
        this.socialMediaUnivarsalPostFeelingsCollection = socialMediaUnivarsalPostFeelingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int1 != null ? int1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SocialMediaFeelings)) {
            return false;
        }
        SocialMediaFeelings other = (SocialMediaFeelings) object;
        if ((this.int1 == null && other.int1 != null) || (this.int1 != null && !this.int1.equals(other.int1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SocialMediaFeelings[ int1=" + int1 + " ]";
    }
    
}
