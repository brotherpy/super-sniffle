/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.reportes.view;


import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import lt.dao.DaoCliente;
import lt.models.Cliente;
import lt.reportes.entities.ListadoCliente;
import lt.tablas.ModeloTablaListadoCliente;
import lt.util.ConnectionHelper;
import net.sf.jasperreports.engine.JasperCompileManager;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author brother
 */
public class ListaClienteView extends javax.swing.JDialog {

  
    private DaoCliente daoCliente;
    private List<Cliente> clientes;
    private ModeloTablaListadoCliente mtListaCliente;
    private DefaultTableModel tablaModelo;

    /**
     * Creates new form ListaClienteView
     */
    public ListaClienteView() {
        super();
        initComponents();
        setLocationRelativeTo(this);
        recuperarClientes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mtListaCliente = new ModeloTablaListadoCliente();
        jTable1 = new javax.swing.JTable();
        btnImprimir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblOrden = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Clientes");
        setModal(true);

        jTable1.setModel(mtListaCliente);
        jScrollPane1.setViewportView(jTable1);

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        jLabel2.setText("Ordenado por:");

        lblOrden.setText("Defecto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(531, Short.MAX_VALUE)
                        .addComponent(btnImprimir)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblOrden)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblOrden))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnImprimir)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
       imprimirLista();
    }//GEN-LAST:event_btnImprimirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        ConnectionHelper.setUp();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListaClienteView dialog = new ListaClienteView();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblOrden;
    // End of variables declaration//GEN-END:variables

    private void imprimirLista() {
      List listado = new ArrayList();
      
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            //"N°","Nombre", "Apellido","Teléfono", "Ciudad"
            ListadoCliente cliente = new ListadoCliente();
            cliente.setId_cliente(Integer.parseInt(jTable1.getValueAt(i, 0).toString()));
            cliente.setNombre_cliente(jTable1.getValueAt(i, 1).toString());
            cliente.setApellido_cliente(jTable1.getValueAt(i, 2).toString());
            cliente.setDireccion_cliente(jTable1.getValueAt(i, 3).toString());
            listado.add(cliente);
        }
        Map parametro = new HashMap();
        parametro.put("Orden", lblOrden.getText());

         try {
           JasperReport jasper = (JasperReport) JRLoader.loadObjectFromFile("reportes/ClienteListaReporte.jasper");
           // InputStream file = getClass().getResourceAsStream("/reportes/ClienteListaReporte.jrxml");
             //JasperDesign jasperDesign = JRXmlLoader.load(file);
            // JasperReport jasper = (JasperReport) JRLoader.loadObject(file);
            // JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
             JasperPrint print = JasperFillManager.fillReport(jasper, parametro, new JRBeanCollectionDataSource(listado));
             JasperViewer view = new JasperViewer(print, false);
             view.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
             view.setExtendedState(Frame.MAXIMIZED_BOTH);
             view.setVisible(true);
        } catch (Exception e) {
        }
    }

    private void recuperarClientes() {
       daoCliente = new DaoCliente();
       clientes = daoCliente.recuperarTodo();
       mtListaCliente.setLista(clientes);
       ordenarColumnas();
       capturarColumnaSeleccionada();
    }
        private void ordenarColumnas() {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable1.getModel());
        jTable1.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        int columnIndexToSort = 0;
        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }
private void capturarColumnaSeleccionada(){
       jTable1.getTableHeader().addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e){
               int col = jTable1.columnAtPoint(e.getPoint());
              String nombreColumna = jTable1.getColumnName(col);
               lblOrden.setText(nombreColumna);
           }
});
}


}
