/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author brother
 */
@Entity
@Table(name = "config")

public class Config implements Serializable {

    private static final long serialVersionUID = 1L;
    
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "cfg_orga")
    private String organizacionNombre;
    @Column(name = "cfg_tel")
    private String organizacionTelefono;
    @Column(name = "cfg_direc")
    private String organizacionDomicilio;

    public Config() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Config(String cfgOrga) {
        this.organizacionNombre = cfgOrga;
    }

    public String getOrganizacionNombre() {
        return organizacionNombre;
    }

    public void setOrganizacionNombre(String organizacionNombre) {
        this.organizacionNombre = organizacionNombre;
    }

    public String getOrganizacionTelefono() {
        return organizacionTelefono;
    }

    public void setOrganizacionTelefono(String organizacionTelefono) {
        this.organizacionTelefono = organizacionTelefono;
    }

    public String getOrganizacionDomicilio() {
        return organizacionDomicilio;
    }

    public void setOrganizacionDomicilio(String organizacionDomicilio) {
        this.organizacionDomicilio = organizacionDomicilio;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (organizacionNombre != null ? organizacionNombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Config)) {
            return false;
        }
        Config other = (Config) object;
        if ((this.organizacionNombre == null && other.organizacionNombre != null) || (this.organizacionNombre != null && !this.organizacionNombre.equals(other.organizacionNombre))) {
            return false;
        }
        return true;
    }

   
    
}
