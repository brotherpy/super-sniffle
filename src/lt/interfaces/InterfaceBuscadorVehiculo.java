/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.interfaces;


import java.util.List;
import lt.models.Vehiculo;


/**
 *
 * @author brother
 */
public interface InterfaceBuscadorVehiculo {
    public void setVehiculo(Vehiculo vehiculo);
    public List<Vehiculo> listaDeVehiculos();
}
