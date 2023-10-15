/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ingeneo.logisticmanagement.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ingeneo.logisticmanagement.security.enums.RolNombre;

/**
 *
 * @author Alejandro Aragon
 */
@Entity
@Table(name = "rol", catalog = "delivery_logistics", schema = "")
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre_rol")
    private RolNombre nombreRol;

    public Rol() {
    }

    public Rol(Integer id) {
        this.id = id;
    }

    public Rol(Integer id, RolNombre nombreRol) {
        this.id = id;
        this.nombreRol = nombreRol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RolNombre getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(RolNombre nombreRol) {
        this.nombreRol = nombreRol;
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
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ingeneo.logisticmanagement.models.Rol[ id=" + id + " ]";
    }
    
}
