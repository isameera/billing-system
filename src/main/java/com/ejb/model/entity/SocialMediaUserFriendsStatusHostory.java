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
@Table(name = "social_media_user_friends_status_hostory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SocialMediaUserFriendsStatusHostory.findAll", query = "SELECT s FROM SocialMediaUserFriendsStatusHostory s")
    , @NamedQuery(name = "SocialMediaUserFriendsStatusHostory.findById", query = "SELECT s FROM SocialMediaUserFriendsStatusHostory s WHERE s.id = :id")
    , @NamedQuery(name = "SocialMediaUserFriendsStatusHostory.findByDate", query = "SELECT s FROM SocialMediaUserFriendsStatusHostory s WHERE s.date = :date")})
public class SocialMediaUserFriendsStatusHostory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "social_media_user_friends_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaUserFriendsStatus socialMediaUserFriendsStatusId;
    @JoinColumn(name = "social_media_user_friends_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaUserFriends socialMediaUserFriendsId;

    public SocialMediaUserFriendsStatusHostory() {
    }

    public SocialMediaUserFriendsStatusHostory(Integer id) {
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

    public SocialMediaUserFriendsStatus getSocialMediaUserFriendsStatusId() {
        return socialMediaUserFriendsStatusId;
    }

    public void setSocialMediaUserFriendsStatusId(SocialMediaUserFriendsStatus socialMediaUserFriendsStatusId) {
        this.socialMediaUserFriendsStatusId = socialMediaUserFriendsStatusId;
    }

    public SocialMediaUserFriends getSocialMediaUserFriendsId() {
        return socialMediaUserFriendsId;
    }

    public void setSocialMediaUserFriendsId(SocialMediaUserFriends socialMediaUserFriendsId) {
        this.socialMediaUserFriendsId = socialMediaUserFriendsId;
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
        if (!(object instanceof SocialMediaUserFriendsStatusHostory)) {
            return false;
        }
        SocialMediaUserFriendsStatusHostory other = (SocialMediaUserFriendsStatusHostory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SocialMediaUserFriendsStatusHostory[ id=" + id + " ]";
    }
    
}
