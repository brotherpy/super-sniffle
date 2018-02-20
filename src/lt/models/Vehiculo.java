/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author brother
 */
@Entity
@Table(name = "vehiculo")

public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "ve_codigo")
    private Integer codigo;
    
    @Column(name = "ve_placa", nullable = false, length = 10, unique = true)
    private String placa;
    
    @Column(name = "ve_marca", nullable = false, length = 20)
    private String marca;
    //original como propone el diccionario=20
    @Column(name = "ve_ano", nullable = false, length = 4)
    
    private int anho;
    
    @Column(name = "ve_modelo", nullable = false, length = 30)
    private String modelo;
    
    @Column(name = "ve_num_motor", nullable = false, length = 20)
    private String numeroMotor;
    
    @Column(name = "ve_num_serie", nullable = false, length = 20)
    private String numeroSerie;
    
    @Column(name = "ve_combustible", nullable=false, length = 20)
    private String combustible;
    
   
     
    @Column(name = "ve_color", nullable=false, length = 20)
    private String color;
    
    @Column(name = "ve_dir_auto")
    private String direccion;
    
    @Column(name = "ve_pote_maxima", nullable = false, length = 30)
    private String potenciaMaxima;
    
    @Column(name = "ve_cilindrada", nullable = false, length = 30)
    private String cilindrada;
    
    @Column(name = "ve_aire_condicionado")
    private boolean aireAcondicionado;
    
    @JoinColumn(name = "cli_codigo", referencedColumnName = "cli_codigo")
    @ManyToOne()
    private Cliente cliente;
    
           @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "vehiculo")
    //@Cascade({org.hibernate.annotations.CascadeType.ALL})
   private List<TipoPlan> polizas = new ArrayList<TipoPlan>();
    
       @OneToMany(mappedBy = "vehiculo")
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private List<Cobranza> planes = new ArrayList<Cobranza>();

    public Vehiculo() {
    }

    public List<TipoPlan> getPolizas() {
        return polizas;
    }

    public void setPolizas(List<TipoPlan> polizas) {
        this.polizas = polizas;
    }
    

    public List<Cobranza> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Cobranza> planes) {
        this.planes = planes;
    }
    

    public Vehiculo(Integer veCodigo) {
        this.codigo = veCodigo;
    }

    
    



    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroMotor() {
        return numeroMotor;
    }

    public void setNumeroMotor(String numeroMotor) {
        this.numeroMotor = numeroMotor;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPotenciaMaxima() {
        return potenciaMaxima;
    }

    public void setPotenciaMaxima(String potenciaMaxima) {
        this.potenciaMaxima = potenciaMaxima;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

  

 
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ltsgva.entities.Vehiculo[ veCodigo=" + codigo + " ]";
    }
    
}
