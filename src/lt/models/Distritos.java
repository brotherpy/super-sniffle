/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.models;

import java.io.Serializable;
import java.util.List;
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

/**
 *
 * @author brother
 */
@Entity
@Table(name = "distritos")

public class Distritos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "ciudades")
    private String ciudades;
    @JoinColumn(name = "departamento_id", referencedColumnName = "id")
    @ManyToOne
    private Departamentos departamentoId;
    
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "distrito")
    private List<Cliente> clienteList;

    public Distritos() {
    }

    public Distritos(Integer id) {
        this.id = id;
    }

    public Distritos(Integer id, String ciudades) {
        this.id = id;
        this.ciudades = ciudades;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCiudades() {
        return ciudades;
    }

    public void setCiudades(String ciudades) {
        this.ciudades = ciudades;
    }

    public Departamentos getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Departamentos departamentoId) {
        this.departamentoId = departamentoId;
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
        if (!(object instanceof Distritos)) {
            return false;
        }
        Distritos other = (Distritos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lt.models.Distritos[ id=" + id + " ]";
    }
    
}
