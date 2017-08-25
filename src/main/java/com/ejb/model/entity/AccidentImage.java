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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "accident_image")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccidentImage.findAll", query = "SELECT a FROM AccidentImage a")
    , @NamedQuery(name = "AccidentImage.findById", query = "SELECT a FROM AccidentImage a WHERE a.id = :id")
    , @NamedQuery(name = "AccidentImage.findByUrl", query = "SELECT a FROM AccidentImage a WHERE a.url = :url")
    , @NamedQuery(name = "AccidentImage.findByDescription", query = "SELECT a FROM AccidentImage a WHERE a.description = :description")})
public class AccidentImage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "url")
    private String url;
    @Size(max = 450)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "vehicle_insurance_clame_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VehicleInsuranceClame vehicleInsuranceClameId;

    public AccidentImage() {
    }

    public AccidentImage(Integer id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VehicleInsuranceClame getVehicleInsuranceClameId() {
        return vehicleInsuranceClameId;
    }

    public void setVehicleInsuranceClameId(VehicleInsuranceClame vehicleInsuranceClameId) {
        this.vehicleInsuranceClameId = vehicleInsuranceClameId;
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
        if (!(object instanceof AccidentImage)) {
            return false;
        }
        AccidentImage other = (AccidentImage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.AccidentImage[ id=" + id + " ]";
    }
    
}
