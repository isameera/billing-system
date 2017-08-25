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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "com_post_controller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComPostController.findAll", query = "SELECT c FROM ComPostController c")
    , @NamedQuery(name = "ComPostController.findById", query = "SELECT c FROM ComPostController c WHERE c.id = :id")
    , @NamedQuery(name = "ComPostController.findByIsActive", query = "SELECT c FROM ComPostController c WHERE c.isActive = :isActive")})
public class ComPostController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "is_active")
    private Short isActive;
    @JoinColumn(name = "receiver", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile receiver;
    @JoinColumn(name = "com_post_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ComPost comPostId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comPostControllerId")
    private Collection<SocialMediaInvitationController> socialMediaInvitationControllerCollection;

    public ComPostController() {
    }

    public ComPostController(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getIsActive() {
        return isActive;
    }

    public void setIsActive(Short isActive) {
        this.isActive = isActive;
    }

    public GeneralUserProfile getReceiver() {
        return receiver;
    }

    public void setReceiver(GeneralUserProfile receiver) {
        this.receiver = receiver;
    }

    public ComPost getComPostId() {
        return comPostId;
    }

    public void setComPostId(ComPost comPostId) {
        this.comPostId = comPostId;
    }

    @XmlTransient
    public Collection<SocialMediaInvitationController> getSocialMediaInvitationControllerCollection() {
        return socialMediaInvitationControllerCollection;
    }

    public void setSocialMediaInvitationControllerCollection(Collection<SocialMediaInvitationController> socialMediaInvitationControllerCollection) {
        this.socialMediaInvitationControllerCollection = socialMediaInvitationControllerCollection;
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
        if (!(object instanceof ComPostController)) {
            return false;
        }
        ComPostController other = (ComPostController) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ComPostController[ id=" + id + " ]";
    }
    
}
