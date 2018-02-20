package lt.tablas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import lt.models.Cuota;
import lt.util.Utilidad;
import org.apache.poi.hssf.record.formula.functions.Days360;

public class ModeloTablaCuotas extends AbstractTableModel {

    private LocalDate vencimientoAtrasado;

    private String[] columnas = {"N°", "Saldo", "Vencimiento", "Situación", "Pagado", "Id"};
    private Object[][] datos = new Object[0][columnas.length];
    private long diasAtrasados;
    private String fechaFormateada;
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd - MMM - uuuu");
    LocalDate fecha;

    //set cars list to table
    public void setLista(List<Cuota> cuotas) {
        datos = new Object[cuotas.size()][columnas.length];
        vencimientoAtrasado = LocalDate.now();

        for (int i = 0; i < cuotas.size(); i++) {
            datos[i][0] = cuotas.get(i).getNumeroCuota() + "/" + cuotas.get(i).getCantidadCuota();
            if (vencimientoAtrasado.isAfter(cuotas.get(i).getFechaVencimiento())) {
                double monto = cuotas.get(i).getSaldoCuota();
                diasAtrasados = DAYS.between(cuotas.get(i).getFechaVencimiento(), vencimientoAtrasado);
                datos[i][1] = Utilidad.formatoValorNumeroDoubleAString(monto + (monto * 0.05));
            } else {
                datos[i][1] = Utilidad.formatoValorNumeroDoubleAString(cuotas.get(i).getSaldoCuota());
            }
            fecha = cuotas.get(i).getFechaVencimiento();
            fechaFormateada = fecha.format(formato);
            datos[i][2] = fechaFormateada;
            if (diasAtrasados > 0) {
                datos[i][3] = diasAtrasados + " días de atraso";
                diasAtrasados = 0;
            } else {
                datos[i][3] = "A vencer";
            }

            datos[i][4] = cuotas.get(i).isEstadoCuotas();
            datos[i][5] = cuotas.get(i).getId();

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
        if (c == 5) {
            return Integer.class;
        }

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
