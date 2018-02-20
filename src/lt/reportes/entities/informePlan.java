package lt.reportes.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


/**
 *
 * @author User
 */
public class informePlan {
    private String codigo;
    private String tipoPlan;
    private String costoPlan;
    private String nDeCuentas;
    private String valorDeCuota;
    private String cliente;
    private String vehiculo;
    

    public informePlan(String codigo, String tipoPlan, String costoPlan, String nDeCuentas, String valorDeCuota, String cliente, String vehiculo) {
        this.codigo = codigo;
        this.tipoPlan = tipoPlan;
        this.costoPlan = costoPlan;
        this.nDeCuentas = nDeCuentas;
        this.valorDeCuota = valorDeCuota;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public String getCostoPlan() {
        return costoPlan;
    }

    public void setCostoPlan(String costoPlan) {
        this.costoPlan = costoPlan;
    }

    public String getnDeCuentas() {
        return nDeCuentas;
    }

    public void setnDeCuentas(String nDeCuentas) {
        this.nDeCuentas = nDeCuentas;
    }

    public String getValorDeCuota() {
        return valorDeCuota;
    }

    public void setValorDeCuota(String valorDeCuota) {
        this.valorDeCuota = valorDeCuota;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    
    
    
    
}
