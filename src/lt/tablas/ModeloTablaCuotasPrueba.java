package lt.tablas;


import java.time.LocalDate;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import lt.models.Cuota;


public class ModeloTablaCuotasPrueba extends AbstractTableModel {

    private LocalDate vencimientoAtrasado;

    private String[] columnas = {"N°", "Saldo", "Vencimiento", "N° de Contrato", "Pagado", "Id"};
    private Object[][] datos = new Object[0][columnas.length];
    private int filasTabla;
    //set cars list to table
    public void setLista(List<Cuota> cuotas) {
        vencimientoAtrasado = LocalDate.now();
        filasTabla = 0;
        //primer for para determinar el tamanho de mi tabla
        for (int j = 0; j < cuotas.size(); j++) {
            Boolean estado = cuotas.get(j).isEstadoCuotas();

            if (estado.equals(false)) {
                //variable que determinara el tamanho de la tabla
                filasTabla++;

            }

        }
        datos = new Object[filasTabla][columnas.length];
        //segundo for que seteara los datos a la tabla
        int filaDeDatos = 0;
        for (int j = 0; j < cuotas.size(); j++) {

            Boolean estadoCuota = cuotas.get(j).isEstadoCuotas();

            if (estadoCuota.equals(false)) {

                if (filaDeDatos < filasTabla) {
                    datos[filaDeDatos][0] = cuotas.get(j).getNumeroCuota();
                    // if (vencimientoAtrasado.isAfter(cuotas.get(i).getFechaVencimiento())) {
                    //datos[i][1] = cuotas.get(i).getSaldoCuota()*0.05;
                    // }else{
                    datos[filaDeDatos][1] = cuotas.get(j).getSaldoCuota();
                    //}
                    datos[filaDeDatos][2] = cuotas.get(j).getFechaVencimiento();
                    datos[filaDeDatos][3] = cuotas.get(j).getTipoPlan().getCodigo();
                    datos[filaDeDatos][4] = cuotas.get(j).isEstadoCuotas();
                    datos[filaDeDatos][5] = cuotas.get(j).getId();
                }
                filaDeDatos++;

            }

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

    @Override
    public boolean isCellEditable(int f, int c) {
        return c == 4;
    }

    @Override
    public Class<?> getColumnClass(int c) {
        if (c == 4) {
            return Boolean.class;
        }

        return super.getColumnClass(c);
    }

    @Override
    public void setValueAt(Object object, int f, int c) {

        datos[f][c] = object;
        
        fireTableCellUpdated(f, c);

    }
    


}
