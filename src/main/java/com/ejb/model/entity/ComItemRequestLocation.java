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
@Table(name = "com_item_request_location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComItemRequestLocation.findAll", query = "SELECT c FROM ComItemRequestLocation c")
    , @NamedQuery(name = "ComItemRequestLocation.findById", query = "SELECT c FROM ComItemRequestLocation c WHERE c.id = :id")
    , @NamedQuery(name = "ComItemRequestLocation.findByConstructionSiteLocationId", query = "SELECT c FROM ComItemRequestLocation c WHERE c.constructionSiteLocationId = :constructionSiteLocationId")})
public class ComItemRequestLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "construction_site_location_id")
    private int constructionSiteLocationId;
    @JoinColumn(name = "com_item_request_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ComItemRequest comItemRequestId;

    public ComItemRequestLocation() {
    }

    public ComItemRequestLocation(Integer id) {
        this.id = id;
    }

    public ComItemRequestLocation(Integer id, int constructionSiteLocationId) {
        this.id = id;
        this.constructionSiteLocationId = constructionSiteLocationId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getConstructionSiteLocationId() {
        return constructionSiteLocationId;
    }

    public void setConstructionSiteLocationId(int constructionSiteLocationId) {
        this.constructionSiteLocationId = constructionSiteLocationId;
    }

    public ComItemRequest getComItemRequestId() {
        return comItemRequestId;
    }

    public void setComItemRequestId(ComItemRequest comItemRequestId) {
        this.comItemRequestId = comItemRequestId;
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
        if (!(object instanceof ComItemRequestLocation)) {
            return false;
        }
        ComItemRequestLocation other = (ComItemRequestLocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ComItemRequestLocation[ id=" + id + " ]";
    }
    
}
