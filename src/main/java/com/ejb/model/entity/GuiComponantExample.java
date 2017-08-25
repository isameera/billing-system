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
@Table(name = "gui_componant_example")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GuiComponantExample.findAll", query = "SELECT g FROM GuiComponantExample g")
    , @NamedQuery(name = "GuiComponantExample.findById", query = "SELECT g FROM GuiComponantExample g WHERE g.id = :id")})
public class GuiComponantExample implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Lob
    @Size(max = 65535)
    @Column(name = "example")
    private String example;
    @Lob
    @Size(max = 65535)
    @Column(name = "code")
    private String code;
    @JoinColumn(name = "gui_componant_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GuiComponant guiComponantId;
    @JoinColumn(name = "gui_componant_example_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GuiComponantExampleType guiComponantExampleTypeId;

    public GuiComponantExample() {
    }

    public GuiComponantExample(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public GuiComponant getGuiComponantId() {
        return guiComponantId;
    }

    public void setGuiComponantId(GuiComponant guiComponantId) {
        this.guiComponantId = guiComponantId;
    }

    public GuiComponantExampleType getGuiComponantExampleTypeId() {
        return guiComponantExampleTypeId;
    }

    public void setGuiComponantExampleTypeId(GuiComponantExampleType guiComponantExampleTypeId) {
        this.guiComponantExampleTypeId = guiComponantExampleTypeId;
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
        if (!(object instanceof GuiComponantExample)) {
            return false;
        }
        GuiComponantExample other = (GuiComponantExample) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.GuiComponantExample[ id=" + id + " ]";
    }
    
}
