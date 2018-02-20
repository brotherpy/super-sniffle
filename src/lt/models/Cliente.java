/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.models;

import java.io.Serializable;
import java.util.ArrayList;
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
import org.hibernate.annotations.Cascade;

/**
 *
 * @author brother
 */
@Entity
@Table(name = "cliente")

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "cli_codigo")
    private Integer codigo;

    @Column(name = "cli_cin", unique = true)
    private int cin;

    @Column(name = "cli_nombre")
    private String nombre;
 
    @Column(name = "cli_apellido")
    private String apellido;
    @Column(name = "cli_telefono")
    private String telefono;
    @Column(name = "cli_direccion")
    private String direccion;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Cobranza> cobranzaList;
    
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "cliente")
    private List<Vehiculo> vehiculoList;
    @ManyToOne
    private Distritos distrito;
    
    
      @OneToMany(mappedBy = "cliente")
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private List<Cuota> cuotas = new ArrayList<Cuota>();
      
      @OneToMany(mappedBy = "cliente")
    @Cascade({org.hibernate.annotations.CascadeType.PERSIST})
    private List<TipoPlan> planes = new ArrayList<TipoPlan>();
    


    
    
    

    public Cliente() {
    }

    public List<TipoPlan> getPlanes() {
        return planes;
    }

    public void setPlanes(List<TipoPlan> planes) {
        this.planes = planes;
    }
    
 
 public void addCuota(Cuota cuota) {
        cuota.setCliente(this);
        cuotas.add(cuota);
    }

public Cliente(Integer codigo){
    this.codigo = codigo;
}

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Distritos getDistrito() {
        return distrito;
    }

    public void setDistrito(Distritos distrito) {
        this.distrito = distrito;
    }





  

    public List<Cobranza> getCobranzaList() {
        return cobranzaList;
    }

    public void setCobranzaList(List<Cobranza> cobranzaList) {
        this.cobranzaList = cobranzaList;
    }

    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }
//
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ltsgva.entities.Cliente[ cliCodigo=" + codigo + " ]";
    }
    
}
