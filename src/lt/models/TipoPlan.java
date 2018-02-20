/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author brother
 */
@Entity
@Table(name = "tipo_de_plan")

public class TipoPlan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_codigo")
    private int codigo;
    @Column(name = "tipo_nombre")
    private String nombrePlan;
    @Column(name = "tipo_monto_total")
    private Double montoPoliza;
    @Column(name = "tipo_numero_cuota")
    private int cantidadCuotas;
    @Column(name = "tipo_monto_cuotal")
    private Double montoCouta;

    @Column(name = "tipo_fecha_registro")
    private LocalDate fechaRegistro;
    
      @Column(name = "tipo_estado_activo")
    private Boolean estadoActivo;

    @OneToMany(mappedBy = "tipoPlan")
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private List<Cuota> cuotas = new ArrayList<Cuota>();
    
    

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;
    
    @ManyToOne
    private Cliente cliente;

    public TipoPlan() {
    }

    public Boolean getEstadoActivo() {
        return estadoActivo;
    }

    public void setEstadoActivo(Boolean estadoActivo) {
        this.estadoActivo = estadoActivo;
    }

 

    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    

    public void addCuota(Cuota cuota) {
        cuota.setTipoPlan(this);
        cuotas.add(cuota);
    }

    public List<Cuota> getCuotas() {
        return cuotas;
    }

    public void setCuotas(List<Cuota> cuotas) {
        this.cuotas = cuotas;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public Double getMontoPoliza() {
        return montoPoliza;
    }

    public void setMontoPoliza(Double montoPoliza) {
        this.montoPoliza = montoPoliza;
    }

    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    public Double getMontoCouta() {
        return montoCouta;
    }

    public void setMontoCouta(Double montoCouta) {
        this.montoCouta = montoCouta;
    }

}
