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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "com_post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComPost.findAll", query = "SELECT c FROM ComPost c")
    , @NamedQuery(name = "ComPost.findById", query = "SELECT c FROM ComPost c WHERE c.id = :id")
    , @NamedQuery(name = "ComPost.findByDateTime", query = "SELECT c FROM ComPost c WHERE c.dateTime = :dateTime")
    , @NamedQuery(name = "ComPost.findByHead", query = "SELECT c FROM ComPost c WHERE c.head = :head")
    , @NamedQuery(name = "ComPost.findByBody", query = "SELECT c FROM ComPost c WHERE c.body = :body")})
public class ComPost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "head")
    private String head;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20000)
    @Column(name = "body")
    private String body;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comPostId")
    private Collection<ComPostTypeManager> comPostTypeManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comPostId")
    private Collection<ComPostController> comPostControllerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comPostId")
    private Collection<ComPostAttachments> comPostAttachmentsCollection;
    @JoinColumn(name = "sender", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile sender;

    public ComPost() {
    }

    public ComPost(Integer id) {
        this.id = id;
    }

    public ComPost(Integer id, Date dateTime, String head, String body) {
        this.id = id;
        this.dateTime = dateTime;
        this.head = head;
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @XmlTransient
    public Collection<ComPostTypeManager> getComPostTypeManagerCollection() {
        return comPostTypeManagerCollection;
    }

    public void setComPostTypeManagerCollection(Collection<ComPostTypeManager> comPostTypeManagerCollection) {
        this.comPostTypeManagerCollection = comPostTypeManagerCollection;
    }

    @XmlTransient
    public Collection<ComPostController> getComPostControllerCollection() {
        return comPostControllerCollection;
    }

    public void setComPostControllerCollection(Collection<ComPostController> comPostControllerCollection) {
        this.comPostControllerCollection = comPostControllerCollection;
    }

    @XmlTransient
    public Collection<ComPostAttachments> getComPostAttachmentsCollection() {
        return comPostAttachmentsCollection;
    }

    public void setComPostAttachmentsCollection(Collection<ComPostAttachments> comPostAttachmentsCollection) {
        this.comPostAttachmentsCollection = comPostAttachmentsCollection;
    }

    public GeneralUserProfile getSender() {
        return sender;
    }

    public void setSender(GeneralUserProfile sender) {
        this.sender = sender;
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
        if (!(object instanceof ComPost)) {
            return false;
        }
        ComPost other = (ComPost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ComPost[ id=" + id + " ]";
    }
    
}
