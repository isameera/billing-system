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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "page")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Page.findAll", query = "SELECT p FROM Page p")
    , @NamedQuery(name = "Page.findById", query = "SELECT p FROM Page p WHERE p.id = :id")
    , @NamedQuery(name = "Page.findByName", query = "SELECT p FROM Page p WHERE p.name = :name")
    , @NamedQuery(name = "Page.findByHeight", query = "SELECT p FROM Page p WHERE p.height = :height")
    , @NamedQuery(name = "Page.findByWidth", query = "SELECT p FROM Page p WHERE p.width = :width")})
public class Page implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "height")
    private Integer height;
    @Column(name = "width")
    private Integer width;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pageId")
    private Collection<RowColumnPage> rowColumnPageCollection;
    @JoinColumn(name = "page_layout_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PageLayout pageLayoutId;

    public Page() {
    }

    public Page(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @XmlTransient
    public Collection<RowColumnPage> getRowColumnPageCollection() {
        return rowColumnPageCollection;
    }

    public void setRowColumnPageCollection(Collection<RowColumnPage> rowColumnPageCollection) {
        this.rowColumnPageCollection = rowColumnPageCollection;
    }

    public PageLayout getPageLayoutId() {
        return pageLayoutId;
    }

    public void setPageLayoutId(PageLayout pageLayoutId) {
        this.pageLayoutId = pageLayoutId;
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
        if (!(object instanceof Page)) {
            return false;
        }
        Page other = (Page) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.Page[ id=" + id + " ]";
    }
    
}
