/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author brother
 */
@Entity
@Table(name = "cuota")
public class Cuota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "cuota_monto")
    private Double montoCuota;

    @Column(name = "cuota_numero")
    private int numeroCuota;
     @Column(name = "cuota_cantidad")
    private int cantidadCuota;
    @Column(name = "cuota_saldo")
    private Double saldoCuota;

    @Column(name = "cuota_estado")
    private boolean estadoCuotas;


    @Column(name = "cuota_vencimiento")
    private LocalDate fechaVencimiento;

    @ManyToOne
    
    @JoinColumn(name="poliza_id")
    private TipoPlan tipoPlan;

        @ManyToOne
        @JoinColumn(name="cliente_id")
    private Cliente cliente;


    public Cuota() {

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getCantidadCuota() {
        return cantidadCuota;
    }

    public void setCantidadCuota(int cantidadCuota) {
        this.cantidadCuota = cantidadCuota;
    }


    

//    public Cobranza getCobranza() {
//        return cobranza;
//    }
//
//    public void setCobranza(Cobranza cobranza) {
//        this.cobranza = cobranza;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getMontoCuota() {
        return montoCuota;
    }

    public void setMontoCuota(Double montoCuota) {
        this.montoCuota = montoCuota;
    }

    public int getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(int numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public Double getSaldoCuota() {
        return saldoCuota;
    }

    public void setSaldoCuota(Double saldoCuota) {
        this.saldoCuota = saldoCuota;
    }

    public boolean isEstadoCuotas() {
        return estadoCuotas;
    }

    public void setEstadoCuotas(boolean estadoCuotas) {
        this.estadoCuotas = estadoCuotas;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }



    public TipoPlan getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(TipoPlan tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

}
