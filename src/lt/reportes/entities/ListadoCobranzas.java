/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.reportes.entities;



/**
 *
 * @author brother
 */
public class ListadoCobranzas {
    private int id_Cobranza;
    private String nombreCliente_Cobranza;
    private String apellidoCliente_Cobranza;
    private String matriculaVehiculo_Cobranza;
    private Double monto_Cobranza;
   

    public ListadoCobranzas() {
    }

    public ListadoCobranzas(int id_Cobranza, String nombreCliente_Cobranza, String apellidoCliente_Cobranza, String matriculaVehiculo_Cobranza, Double monto_Cobranza) {
        this.id_Cobranza = id_Cobranza;
        this.nombreCliente_Cobranza = nombreCliente_Cobranza;
        this.apellidoCliente_Cobranza = apellidoCliente_Cobranza;
        this.matriculaVehiculo_Cobranza = matriculaVehiculo_Cobranza;
        this.monto_Cobranza = monto_Cobranza;
    }

 

    public int getId_Cobranza() {
        return id_Cobranza;
    }

    public void setId_Cobranza(int id_Cobranza) {
        this.id_Cobranza = id_Cobranza;
    }

    public String getNombreCliente_Cobranza() {
        return nombreCliente_Cobranza;
    }

    public void setNombreCliente_Cobranza(String nombreCliente_Cobranza) {
        this.nombreCliente_Cobranza = nombreCliente_Cobranza;
    }

    public String getApellidoCliente_Cobranza() {
        return apellidoCliente_Cobranza;
    }

    public void setApellidoCliente_Cobranza(String apellidoCliente_Cobranza) {
        this.apellidoCliente_Cobranza = apellidoCliente_Cobranza;
    }

    public String getMatriculaVehiculo_Cobranza() {
        return matriculaVehiculo_Cobranza;
    }

    public void setMatriculaVehiculo_Cobranza(String matriculaVehiculo_Cobranza) {
        this.matriculaVehiculo_Cobranza = matriculaVehiculo_Cobranza;
    }

    public Double getMonto_Cobranza() {
        return monto_Cobranza;
    }

    public void setMonto_Cobranza(Double monto_Cobranza) {
        this.monto_Cobranza = monto_Cobranza;
    }


    
        
    
}
