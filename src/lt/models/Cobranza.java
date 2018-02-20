/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.models;

import java.io.Serializable;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


/**
 *
 * @author brother
 */
@Entity
@Table(name = "cobranza")

public class Cobranza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "cobran_codigo")
    private Integer codigo;
    @Column(name = "cobran_fecha")
     private LocalDate fechaCobro;
  
    @Column(name = "cobran_monto")
    private Double montoCobro;
   
    @Column(name = "cobran_cuota")
    private Double montoCuota;

    @Column(name = "cobran_saldo")
    private Double saldoPendiente;

    @JoinColumn(name = "cli_codigo", referencedColumnName = "cli_codigo")
    @ManyToOne(optional = false)
    
    
    private Cliente cliente;
   
      @ManyToOne
    private Vehiculo vehiculo;

    public Cobranza() {
    }
    
    

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }



    


    public Cobranza(Integer cobranCodigo) {
        this.codigo = cobranCodigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaCobro() {
        return fechaCobro;
    }

    public void setFechaCobro(LocalDate fechaCobro) {
        this.fechaCobro = fechaCobro;
    }



    public Double getMontoCobro() {
        return montoCobro;
    }

    public void setMontoCobro(Double montoCobro) {
        this.montoCobro = montoCobro;
    }

    public Double getMontoCuota() {
        return montoCuota;
    }

    public void setMontoCuota(Double montoCuota) {
        this.montoCuota = montoCuota;
    }

    public Double getSaldoPendiente() {
        return saldoPendiente;
    }

    public void setSaldoPendiente(Double saldoPendiente) {
        this.saldoPendiente = saldoPendiente;
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
        if (!(object instanceof Cobranza)) {
            return false;
        }
        Cobranza other = (Cobranza) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ltsgva.entities.Cobranza[ cobranCodigo=" + codigo + " ]";
    }
    
}
