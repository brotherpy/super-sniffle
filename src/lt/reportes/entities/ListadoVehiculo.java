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
public class ListadoVehiculo {
    
    private String marca;
    private String modelo;
    private String matricula;
    private String propietario;

    public ListadoVehiculo() {
    }

    public ListadoVehiculo(String marca, String modelo, String matricula, String propietario) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.propietario = propietario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    
    
}
