/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "social_media_user_network")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SocialMediaUserNetwork.findAll", query = "SELECT s FROM SocialMediaUserNetwork s")
    , @NamedQuery(name = "SocialMediaUserNetwork.findById", query = "SELECT s FROM SocialMediaUserNetwork s WHERE s.id = :id")
    , @NamedQuery(name = "SocialMediaUserNetwork.findByDate", query = "SELECT s FROM SocialMediaUserNetwork s WHERE s.date = :date")})
public class SocialMediaUserNetwork implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "introduced_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaUserGroups introducedBy;
    @JoinColumn(name = "introducee", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaUserGroups introducee;

    public SocialMediaUserNetwork() {
    }

    public SocialMediaUserNetwork(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SocialMediaUserGroups getIntroducedBy() {
        return introducedBy;
    }

    public void setIntroducedBy(SocialMediaUserGroups introducedBy) {
        this.introducedBy = introducedBy;
    }

    public SocialMediaUserGroups getIntroducee() {
        return introducee;
    }

    public void setIntroducee(SocialMediaUserGroups introducee) {
        this.introducee = introducee;
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
        if (!(object instanceof SocialMediaUserNetwork)) {
            return false;
        }
        SocialMediaUserNetwork other = (SocialMediaUserNetwork) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SocialMediaUserNetwork[ id=" + id + " ]";
    }
    
}
