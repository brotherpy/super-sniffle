package lt.tablas;




import java.util.List;

import javax.swing.table.AbstractTableModel;
import lt.models.Cliente;




public class ModeloTablaCliente extends AbstractTableModel{
	
	private String[] columnas = {"Nombre y Apellido", "Teléfono", "Ciudad","C.I.N°"};
	private Object[][] datos = new Object[0][columnas.length]; 

 
	
	public void setLista(List<Cliente> clientes) {
		datos = new Object[clientes.size()][columnas.length];
		
		for (int i = 0; i < clientes.size(); i++) {
			//datos[i][0] = clientes.get(i).getCodigo();
			datos[i][0] = clientes.get(i).getNombre()
							+ " " + clientes.get(i).getApellido();
			datos[i][1] = clientes.get(i).getTelefono();
			datos[i][2] = clientes.get(i).getDistrito().getCiudades();
                                                      datos[i][3] = clientes.get(i).getCin();
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
//	
//	@Override
//	public Class<?> getColumnClass(int c) {
//		if(c == 3) return Boolean.class;
//		
//		return super.getColumnClass(c);
//	}
	

}
