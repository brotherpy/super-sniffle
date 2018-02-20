package lt.tablas;




import java.util.List;

import javax.swing.table.AbstractTableModel;
import lt.models.Cobranza;



public class ModeloTablaCobranzasInforme extends AbstractTableModel{
	
	private String[] columnas = {"N° Mov.","Cliente","Vehículo", "Monto Pagado"};
	private Object[][] datos = new Object[0][columnas.length]; 

 
	
	public void setLista(List<Cobranza> cobranzas) {
		datos = new Object[cobranzas.size()][columnas.length];
		
		for (int i = 0; i < cobranzas.size(); i++) {
			
			datos[i][0] = cobranzas.get(i).getCodigo();
			datos[i][1] = cobranzas.get(i).getCliente().getNombre()+" "+
                                                                                              cobranzas.get(i).getCliente().getApellido();
			datos[i][2] = cobranzas.get(i).getVehiculo().getPlaca();
			datos[i][3] = cobranzas.get(i).getMontoCobro();
							
                                                      
                        
			
		}
		
		//Refrezca la vista de la tabla
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
