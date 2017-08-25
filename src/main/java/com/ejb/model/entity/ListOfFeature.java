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
@Table(name = "list_of_feature")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListOfFeature.findAll", query = "SELECT l FROM ListOfFeature l")
    , @NamedQuery(name = "ListOfFeature.findById", query = "SELECT l FROM ListOfFeature l WHERE l.id = :id")
    , @NamedQuery(name = "ListOfFeature.findByName", query = "SELECT l FROM ListOfFeature l WHERE l.name = :name")
    , @NamedQuery(name = "ListOfFeature.findByVideo", query = "SELECT l FROM ListOfFeature l WHERE l.video = :video")
    , @NamedQuery(name = "ListOfFeature.findByImage", query = "SELECT l FROM ListOfFeature l WHERE l.image = :image")})
public class ListOfFeature implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Size(max = 405)
    @Column(name = "video")
    private String video;
    @Size(max = 145)
    @Column(name = "image")
    private String image;
    @JoinColumn(name = "list_of_feature_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ListOfFeatureType listOfFeatureTypeId;
    @JoinColumn(name = "system_module_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SystemModule systemModuleId;
    @JoinColumn(name = "system_module_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SystemModuleType systemModuleTypeId;

    public ListOfFeature() {
    }

    public ListOfFeature(Integer id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ListOfFeatureType getListOfFeatureTypeId() {
        return listOfFeatureTypeId;
    }

    public void setListOfFeatureTypeId(ListOfFeatureType listOfFeatureTypeId) {
        this.listOfFeatureTypeId = listOfFeatureTypeId;
    }

    public SystemModule getSystemModuleId() {
        return systemModuleId;
    }

    public void setSystemModuleId(SystemModule systemModuleId) {
        this.systemModuleId = systemModuleId;
    }

    public SystemModuleType getSystemModuleTypeId() {
        return systemModuleTypeId;
    }

    public void setSystemModuleTypeId(SystemModuleType systemModuleTypeId) {
        this.systemModuleTypeId = systemModuleTypeId;
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
        if (!(object instanceof ListOfFeature)) {
            return false;
        }
        ListOfFeature other = (ListOfFeature) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ListOfFeature[ id=" + id + " ]";
    }
    
}
