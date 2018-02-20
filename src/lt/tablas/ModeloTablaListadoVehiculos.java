package lt.tablas;




import java.util.List;

import javax.swing.table.AbstractTableModel;
import lt.models.Vehiculo;



public class ModeloTablaListadoVehiculos extends AbstractTableModel{
	
	private String[] columnas = {"Marca", "Modelo", "Matricula", "Propietario"};
	private Object[][] datos = new Object[0][columnas.length]; 
	
        //set cars list to table
	public void setLista(List<Vehiculo> vehiculos) {
		datos = new Object[vehiculos.size()][columnas.length];
		
		for (int i = 0; i < vehiculos.size(); i++) {
			
			datos[i][0] = vehiculos.get(i).getMarca();
                                                      datos[i][1] = vehiculos.get(i).getModelo();
			datos[i][2] = vehiculos.get(i).getPlaca();
			datos[i][3] = vehiculos.get(i).getCliente().getNombre()+" "+
                                                                           vehiculos.get(i).getCliente().getApellido();
                                                      
                        
		}
		
		
		fireTableDataChanged();
	}

	@Override
	public String getColumnName(int column) {
		return columnas[column];
	}
	
	@Override
	public int getRowCount() {
		return datos.length;
	}

	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public Object getValueAt(int f, int c) {
		return datos[f][c];
	}
	


}
