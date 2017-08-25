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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "advance_request_documents")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdvanceRequestDocuments.findAll", query = "SELECT a FROM AdvanceRequestDocuments a")
    , @NamedQuery(name = "AdvanceRequestDocuments.findById", query = "SELECT a FROM AdvanceRequestDocuments a WHERE a.id = :id")})
public class AdvanceRequestDocuments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "url")
    private String url;
    @JoinColumn(name = "advance_request_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AdvanceRequestManager advanceRequestManagerId;

    public AdvanceRequestDocuments() {
    }

    public AdvanceRequestDocuments(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AdvanceRequestManager getAdvanceRequestManagerId() {
        return advanceRequestManagerId;
    }

    public void setAdvanceRequestManagerId(AdvanceRequestManager advanceRequestManagerId) {
        this.advanceRequestManagerId = advanceRequestManagerId;
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
        if (!(object instanceof AdvanceRequestDocuments)) {
            return false;
        }
        AdvanceRequestDocuments other = (AdvanceRequestDocuments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.AdvanceRequestDocuments[ id=" + id + " ]";
    }
    
}
