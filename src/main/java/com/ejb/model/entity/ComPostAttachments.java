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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "com_post_attachments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComPostAttachments.findAll", query = "SELECT c FROM ComPostAttachments c")
    , @NamedQuery(name = "ComPostAttachments.findById", query = "SELECT c FROM ComPostAttachments c WHERE c.id = :id")
    , @NamedQuery(name = "ComPostAttachments.findByAttachType", query = "SELECT c FROM ComPostAttachments c WHERE c.attachType = :attachType")
    , @NamedQuery(name = "ComPostAttachments.findByIsInactive", query = "SELECT c FROM ComPostAttachments c WHERE c.isInactive = :isInactive")})
public class ComPostAttachments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "attach_type")
    private short attachType;
    @Column(name = "is_inactive")
    private Short isInactive;
    @JoinColumn(name = "com_post_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ComPost comPostId;

    public ComPostAttachments() {
    }

    public ComPostAttachments(Integer id) {
        this.id = id;
    }

    public ComPostAttachments(Integer id, short attachType) {
        this.id = id;
        this.attachType = attachType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getAttachType() {
        return attachType;
    }

    public void setAttachType(short attachType) {
        this.attachType = attachType;
    }

    public Short getIsInactive() {
        return isInactive;
    }

    public void setIsInactive(Short isInactive) {
        this.isInactive = isInactive;
    }

    public ComPost getComPostId() {
        return comPostId;
    }

    public void setComPostId(ComPost comPostId) {
        this.comPostId = comPostId;
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
        if (!(object instanceof ComPostAttachments)) {
            return false;
        }
        ComPostAttachments other = (ComPostAttachments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ComPostAttachments[ id=" + id + " ]";
    }
    
}
