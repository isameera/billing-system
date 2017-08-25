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
import javax.persistence.Lob;
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
@Table(name = "vehicle_model")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehicleModel.findAll", query = "SELECT v FROM VehicleModel v")
    , @NamedQuery(name = "VehicleModel.findById", query = "SELECT v FROM VehicleModel v WHERE v.id = :id")
    , @NamedQuery(name = "VehicleModel.findByName", query = "SELECT v FROM VehicleModel v WHERE v.name = :name")})
public class VehicleModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 450)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleModelId")
    private Collection<SupportVehicleModels> supportVehicleModelsCollection;
    @JoinColumn(name = "vehicle_brand_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VehicleBrand vehicleBrandId;
    @JoinColumn(name = "vehicle_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VehicleType vehicleTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleModelId")
    private Collection<Vehicle> vehicleCollection;

    public VehicleModel() {
    }

    public VehicleModel(Integer id) {
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

    @XmlTransient
    public Collection<SupportVehicleModels> getSupportVehicleModelsCollection() {
        return supportVehicleModelsCollection;
    }

    public void setSupportVehicleModelsCollection(Collection<SupportVehicleModels> supportVehicleModelsCollection) {
        this.supportVehicleModelsCollection = supportVehicleModelsCollection;
    }

    public VehicleBrand getVehicleBrandId() {
        return vehicleBrandId;
    }

    public void setVehicleBrandId(VehicleBrand vehicleBrandId) {
        this.vehicleBrandId = vehicleBrandId;
    }

    public VehicleType getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(VehicleType vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    @XmlTransient
    public Collection<Vehicle> getVehicleCollection() {
        return vehicleCollection;
    }

    public void setVehicleCollection(Collection<Vehicle> vehicleCollection) {
        this.vehicleCollection = vehicleCollection;
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
        if (!(object instanceof VehicleModel)) {
            return false;
        }
        VehicleModel other = (VehicleModel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.VehicleModel[ id=" + id + " ]";
    }
    
}
