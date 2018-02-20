



import java.util.List;

import javax.swing.table.AbstractTableModel;
import lt.models.TipoPlan;
import lt.util.Utilidad;



public class ModeloTablaInformePlan extends AbstractTableModel{
	
	private String[] columnas = {"Código","Tipo Plan", "Costo del Plan","N° de Cuotas", "Valor de la Cuota","Cliente","Vehículo"};
	private Object[][] datos = new Object[0][columnas.length]; 
	
       
	public void setLista(List<TipoPlan> planes) {
		datos = new Object[planes.size()][columnas.length];
		
		for (int i = 0; i < planes.size(); i++) {
			
			datos[i][0] = planes.get(i).getCodigo();
			datos[i][1] = planes.get(i).getNombrePlan();
			datos[i][2] = Utilidad.formatoValorNumeroDoubleSinComa(planes.get(i).getMontoPoliza())+" Gs";
                        datos[i][3] = planes.get(i).getCantidadCuotas();
			datos[i][4] = Utilidad.formatoValorNumeroDoubleSinComa(planes.get(i).getMontoCouta())+" Gs";
			datos[i][5] = planes.get(i).getCliente().getNombre()+ " "
                                + " "+planes.get(i).getCliente().getApellido();
			datos[i][6] = planes.get(i).getVehiculo().getPlaca();
                        
                        
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
	
//	@Override
//	public Class<?> getColumnClass(int c) {
//		if(c == 3) return Boolean.class;
//		
//		return super.getColumnClass(c);
//	}
	

}
