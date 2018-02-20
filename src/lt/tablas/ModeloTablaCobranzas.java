package lt.tablas;




import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import lt.models.Cobranza;
import lt.util.Utilidad;



public class ModeloTablaCobranzas extends AbstractTableModel{
	
	private String[] columnas = {"Fecha", "Monto"};
	private Object[][] datos = new Object[0][columnas.length]; 

                   String fechaFormateada;
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd - MMM - uuuu");
                   LocalDate fecha;
	public void setLista(List<Cobranza> cobranzas) {
		datos = new Object[cobranzas.size()][columnas.length];
		
		for (int i = 0; i < cobranzas.size(); i++) {
			//datos[i][0] = clientes.get(i).getCodigo();
                                                       
                                                       fecha= cobranzas.get(i).getFechaCobro();
                                                       fechaFormateada = fecha.format(formato);
			datos[i][0] = fechaFormateada;
							
			datos[i][1] = Utilidad.formatoValorNumeroDoubleAString(cobranzas.get(i).getMontoCobro());
			
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
