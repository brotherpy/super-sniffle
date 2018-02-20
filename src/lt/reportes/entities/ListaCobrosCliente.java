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
public class ListaCobrosCliente {
    private String fecha;
    private String monto;

    public ListaCobrosCliente() {
    }

    public ListaCobrosCliente(String fecha, String monto) {
        this.fecha = fecha;
        this.monto = monto;
    }
    

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }
    
   
}
