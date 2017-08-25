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
@Table(name = "social_media_universal_users_messaging")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SocialMediaUniversalUsersMessaging.findAll", query = "SELECT s FROM SocialMediaUniversalUsersMessaging s")
    , @NamedQuery(name = "SocialMediaUniversalUsersMessaging.findById", query = "SELECT s FROM SocialMediaUniversalUsersMessaging s WHERE s.id = :id")
    , @NamedQuery(name = "SocialMediaUniversalUsersMessaging.findByDate", query = "SELECT s FROM SocialMediaUniversalUsersMessaging s WHERE s.date = :date")
    , @NamedQuery(name = "SocialMediaUniversalUsersMessaging.findByTime", query = "SELECT s FROM SocialMediaUniversalUsersMessaging s WHERE s.time = :time")})
public class SocialMediaUniversalUsersMessaging implements Serializable {

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
    @JoinColumn(name = "social_media_universal_messaging_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaUniversalMessaging socialMediaUniversalMessagingId;
    @JoinColumn(name = "social_media_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaProfilePage socialMediaUserId;

    public SocialMediaUniversalUsersMessaging() {
    }

    public SocialMediaUniversalUsersMessaging(Integer id) {
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

    public SocialMediaUniversalMessaging getSocialMediaUniversalMessagingId() {
        return socialMediaUniversalMessagingId;
    }

    public void setSocialMediaUniversalMessagingId(SocialMediaUniversalMessaging socialMediaUniversalMessagingId) {
        this.socialMediaUniversalMessagingId = socialMediaUniversalMessagingId;
    }

    public SocialMediaProfilePage getSocialMediaUserId() {
        return socialMediaUserId;
    }

    public void setSocialMediaUserId(SocialMediaProfilePage socialMediaUserId) {
        this.socialMediaUserId = socialMediaUserId;
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
        if (!(object instanceof SocialMediaUniversalUsersMessaging)) {
            return false;
        }
        SocialMediaUniversalUsersMessaging other = (SocialMediaUniversalUsersMessaging) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SocialMediaUniversalUsersMessaging[ id=" + id + " ]";
    }
    
}
