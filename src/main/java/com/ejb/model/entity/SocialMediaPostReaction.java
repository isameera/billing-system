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
@Table(name = "social_media_post_reaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SocialMediaPostReaction.findAll", query = "SELECT s FROM SocialMediaPostReaction s")
    , @NamedQuery(name = "SocialMediaPostReaction.findById", query = "SELECT s FROM SocialMediaPostReaction s WHERE s.id = :id")})
public class SocialMediaPostReaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "social_media_profile_page_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaProfilePage socialMediaProfilePageId;
    @JoinColumn(name = "social_media_univarsal_post_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaUnivarsalPost socialMediaUnivarsalPostId;
    @JoinColumn(name = "social_media_user_reaction_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaUserReactionType socialMediaUserReactionTypeId;

    public SocialMediaPostReaction() {
    }

    public SocialMediaPostReaction(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SocialMediaProfilePage getSocialMediaProfilePageId() {
        return socialMediaProfilePageId;
    }

    public void setSocialMediaProfilePageId(SocialMediaProfilePage socialMediaProfilePageId) {
        this.socialMediaProfilePageId = socialMediaProfilePageId;
    }

    public SocialMediaUnivarsalPost getSocialMediaUnivarsalPostId() {
        return socialMediaUnivarsalPostId;
    }

    public void setSocialMediaUnivarsalPostId(SocialMediaUnivarsalPost socialMediaUnivarsalPostId) {
        this.socialMediaUnivarsalPostId = socialMediaUnivarsalPostId;
    }

    public SocialMediaUserReactionType getSocialMediaUserReactionTypeId() {
        return socialMediaUserReactionTypeId;
    }

    public void setSocialMediaUserReactionTypeId(SocialMediaUserReactionType socialMediaUserReactionTypeId) {
        this.socialMediaUserReactionTypeId = socialMediaUserReactionTypeId;
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
        if (!(object instanceof SocialMediaPostReaction)) {
            return false;
        }
        SocialMediaPostReaction other = (SocialMediaPostReaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SocialMediaPostReaction[ id=" + id + " ]";
    }
    
}
