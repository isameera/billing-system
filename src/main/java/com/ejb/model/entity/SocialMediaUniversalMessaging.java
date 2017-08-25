/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "social_media_universal_messaging")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SocialMediaUniversalMessaging.findAll", query = "SELECT s FROM SocialMediaUniversalMessaging s")
    , @NamedQuery(name = "SocialMediaUniversalMessaging.findById", query = "SELECT s FROM SocialMediaUniversalMessaging s WHERE s.id = :id")
    , @NamedQuery(name = "SocialMediaUniversalMessaging.findByDate", query = "SELECT s FROM SocialMediaUniversalMessaging s WHERE s.date = :date")
    , @NamedQuery(name = "SocialMediaUniversalMessaging.findByTime", query = "SELECT s FROM SocialMediaUniversalMessaging s WHERE s.time = :time")})
public class SocialMediaUniversalMessaging implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Lob
    @Size(max = 65535)
    @Column(name = "text")
    private String text;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaUniversalMessagingId")
    private Collection<SocialMediaUniversalUsersMessaging> socialMediaUniversalUsersMessagingCollection;
    @JoinColumn(name = "message_from", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaProfilePage messageFrom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaUniversalMessagingId")
    private Collection<SocialMediaUniversalGroupMessaging> socialMediaUniversalGroupMessagingCollection;

    public SocialMediaUniversalMessaging() {
    }

    public SocialMediaUniversalMessaging(Integer id) {
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @XmlTransient
    public Collection<SocialMediaUniversalUsersMessaging> getSocialMediaUniversalUsersMessagingCollection() {
        return socialMediaUniversalUsersMessagingCollection;
    }

    public void setSocialMediaUniversalUsersMessagingCollection(Collection<SocialMediaUniversalUsersMessaging> socialMediaUniversalUsersMessagingCollection) {
        this.socialMediaUniversalUsersMessagingCollection = socialMediaUniversalUsersMessagingCollection;
    }

    public SocialMediaProfilePage getMessageFrom() {
        return messageFrom;
    }

    public void setMessageFrom(SocialMediaProfilePage messageFrom) {
        this.messageFrom = messageFrom;
    }

    @XmlTransient
    public Collection<SocialMediaUniversalGroupMessaging> getSocialMediaUniversalGroupMessagingCollection() {
        return socialMediaUniversalGroupMessagingCollection;
    }

    public void setSocialMediaUniversalGroupMessagingCollection(Collection<SocialMediaUniversalGroupMessaging> socialMediaUniversalGroupMessagingCollection) {
        this.socialMediaUniversalGroupMessagingCollection = socialMediaUniversalGroupMessagingCollection;
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
        if (!(object instanceof SocialMediaUniversalMessaging)) {
            return false;
        }
        SocialMediaUniversalMessaging other = (SocialMediaUniversalMessaging) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SocialMediaUniversalMessaging[ id=" + id + " ]";
    }
    
}
