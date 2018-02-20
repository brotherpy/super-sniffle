package lt.reportes.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lt.dao.DaoTipoPlan;
import lt.models.TipoPlan;
import lt.reportes.entities.informePlan;
import lt.tablas.ModeloTablaInformePlan;
import lt.util.ConnectionHelper;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class InfomeDePlan extends javax.swing.JDialog {

    /**
     * Creates new form InfomeDeCobranza
     */
    private ModeloTablaInformePlan mtPlan;
    private DaoTipoPlan daoPlan;
    private List<TipoPlan> plan;
    private Boolean verificarCodigo;
    private String campo;
    private String filtro;
    
    public InfomeDePlan() {
        //super();
        initComponents();
        setLocationRelativeTo(this);
        jComboOpciones.setSelectedIndex(0);
        panelParametro.setVisible(false);
        btnImprimir.setEnabled(false);
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
        mtPlan = new ModeloTablaInformePlan();
        jTable1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnImprimir = new javax.swing.JButton();
        btnProcesar = new javax.swing.JButton();
        panelParametro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txDesde = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txHasta = new javax.swing.JTextField();
        jcPlan = new javax.swing.JComboBox<>();
        jComboOpciones = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);

        jTable1.setModel(mtPlan);
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 102, 255));
        jLabel3.setText("Informe de Planes");

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        btnImprimir.setForeground(new java.awt.Color(51, 102, 255));
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel1.add(btnImprimir);

        btnProcesar.setForeground(new java.awt.Color(51, 102, 255));
        btnProcesar.setText("Procesar");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });
        jPanel1.add(btnProcesar);

        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setText("Desde:");

        txDesde.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("Hasta:");

        txHasta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jcPlan.setBackground(new java.awt.Color(204, 204, 204));
        jcPlan.setForeground(new java.awt.Color(51, 102, 255));
        jcPlan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Básico", "Medio", "Plus" }));
        jcPlan.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jcPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcPlanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelParametroLayout = new javax.swing.GroupLayout(panelParametro);
        panelParametro.setLayout(panelParametroLayout);
        panelParametroLayout.setHorizontalGroup(
            panelParametroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelParametroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelParametroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelParametroLayout.createSequentialGroup()
                        .addGroup(panelParametroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelParametroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txHasta, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                            .addComponent(txDesde)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelParametroLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jcPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelParametroLayout.setVerticalGroup(
            panelParametroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelParametroLayout.createSequentialGroup()
                .addGroup(panelParametroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelParametroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jComboOpciones.setForeground(new java.awt.Color(51, 102, 255));
        jComboOpciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Tipo Plan", "Cod.Vehículo", "Cod.Cliente" }));
        jComboOpciones.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jComboOpciones.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboOpcionesItemStateChanged(evt);
            }
        });
        jComboOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboOpcionesActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(51, 102, 255));
        jLabel4.setForeground(new java.awt.Color(51, 102, 255));
        jLabel4.setText("Listar por");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelParametro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(327, 327, 327)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelParametro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboOpcionesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboOpcionesItemStateChanged
       cargarParametro();
    }//GEN-LAST:event_jComboOpcionesItemStateChanged

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        procesar();
    }//GEN-LAST:event_btnProcesarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
       imprimirPlan();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void jComboOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboOpcionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboOpcionesActionPerformed

    private void jcPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcPlanActionPerformed
            seleccionarItemPlan();
    }//GEN-LAST:event_jcPlanActionPerformed

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
            java.util.logging.Logger.getLogger(InfomeDePlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfomeDePlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfomeDePlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfomeDePlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        ConnectionHelper.setUp();
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InfomeDePlan dialog = new InfomeDePlan();
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
    private javax.swing.JButton btnProcesar;
    private javax.swing.JComboBox<String> jComboOpciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jcPlan;
    private javax.swing.JPanel panelParametro;
    private javax.swing.JTextField txDesde;
    private javax.swing.JTextField txHasta;
    // End of variables declaration//GEN-END:variables

    
    public void cargarParametro(){
      if(jComboOpciones.getSelectedIndex()==0){
          panelParametro.setVisible(false);
          vaciarCampos();
          verificarCodigo = false;
          jcPlan.setVisible(false);
          btnImprimir.setEnabled(false);
        }else if(jComboOpciones.getSelectedIndex()==1){
          vaciarCampos();
          jcPlan.setVisible(true);
          jcPlan.requestFocus();
          filtro = jcPlan.getSelectedItem()+ "";
          panelParametro.setVisible(true);
          jLabel1.setVisible(false);
          jLabel2.setVisible(false);
          txDesde.setVisible(false);
          txHasta.setVisible(false);
          verificarCodigo = false;
          jcPlan.setSelectedIndex(0);
          btnImprimir.setEnabled(false);
       }else if(jComboOpciones.getSelectedIndex()==2){
          vaciarCampos();
          panelParametro.setVisible(true);
          jLabel1.setVisible(true);
          jLabel2.setVisible(true);
          txDesde.setVisible(true);
          txHasta.setVisible(true);          
          txDesde.requestFocus();
          txDesde.setText("1");
          txHasta.setText("1");
          verificarCodigo = true;
          campo = "vehiculo_id";
          jcPlan.setVisible(false);
          btnImprimir.setEnabled(false);
       }else if(jComboOpciones.getSelectedIndex()==3){
          vaciarCampos();
          panelParametro.setVisible(true);          
          txDesde.setText("1");
          txHasta.setText("1");
          verificarCodigo = true;
          campo = "cliente_cli_codigo";
          jcPlan.setVisible(false);
          btnImprimir.setEnabled(false);
       }
    }
    
    private void seleccionarItemPlan(){
        switch (jcPlan.getSelectedIndex()){
            case 0:
                vaciarCampos();
                filtro = (String) jcPlan.getSelectedItem();
                btnImprimir.setEnabled(false);
                break;
            case 1:
                vaciarCampos();
                filtro = (String) jcPlan.getSelectedItem();
                btnImprimir.setEnabled(false);
                break;
            default:
                vaciarCampos();
                filtro = (String) jcPlan.getSelectedItem();
                btnImprimir.setEnabled(false);
                break;
    }
    }
    
    private void procesar(){
        switch(jComboOpciones.getSelectedIndex()){
            case 0:
                listarTodoOrdenado();
              break;
            case 1:
                recuperarPorPlan(filtro);
              break;
            case 2:
                if(txDesde.getText().isEmpty() || txHasta.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "¡Debe ingresar parámetros de código!!! ");
                }else{
                recuperarPorParametro(txDesde.getText(), txHasta.getText(), campo);
                }
              break;
            default:
                if(txDesde.getText().isEmpty() || txHasta.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "¡Debe ingresar parámetros de código!!! ");
                }else{
                recuperarPorParametro(txDesde.getText(), txHasta.getText(), campo);
                }
                break;  
        }
    }
    

    private void listarTodoOrdenado(){
        daoPlan = new DaoTipoPlan();
        plan = daoPlan.recuperarTodo();
        if(plan.isEmpty()){
        JOptionPane.showMessageDialog(this,"¡No existe datos con el rango seleccionado!!!");
        btnImprimir.setEnabled(false);
        }else{
        mtPlan.setLista(plan);
        jTable1.setModel(mtPlan);
        btnImprimir.setEnabled(true);
        }
    }

    private void recuperarPorParametro( String desde, String hasta,String campo) {
        daoPlan = new DaoTipoPlan();
        plan = daoPlan.recuperarPorParametro(desde, hasta, campo);
        if(plan.isEmpty()){
         JOptionPane.showMessageDialog(this,"¡No existe datos con el rango seleccionado!!!");  
        btnImprimir.setEnabled(false);
        }else{
        mtPlan.setLista(plan);
        jTable1.setModel(mtPlan);
        btnImprimir.setEnabled(true);
        }
    }
    private void recuperarPorPlan(String filtro){
        daoPlan = new DaoTipoPlan();
        plan = daoPlan.recuperarPorTipoPlan(filtro);
        if(plan.isEmpty()){
            JOptionPane.showMessageDialog(this,"¡No existe datos con el rango seleccionado!!!");
        btnImprimir.setEnabled(false);
        }else{
         mtPlan.setLista(plan);
         jTable1.setModel(mtPlan);
        btnImprimir.setEnabled(true);
        }
    }

    private void vaciarCampos() {
        
    mtPlan = new ModeloTablaInformePlan();
    jTable1.setModel(mtPlan);
    txDesde.setText("");
    txHasta.setText("");
    }
    
    

        private void imprimirPlan() {


        
        List <informePlan> lista = new ArrayList();
//        daoConfiguracion = new DaoConfig();
//        configuracion = daoConfiguracion.recuperarPorId(1);

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            informePlan reporte = new informePlan(
                    jTable1.getValueAt(i, 0).toString(),
                    jTable1.getValueAt(i, 1).toString(),
                    jTable1.getValueAt(i, 2).toString(),
                    jTable1.getValueAt(i, 3).toString(),
                    jTable1.getValueAt(i, 4).toString(),
                    jTable1.getValueAt(i, 5).toString(),
                    jTable1.getValueAt(i, 6).toString());
            lista.add(reporte);
            System.out.println("planes" + reporte.getCliente());
        }
        try {
            Map parametro = new HashMap();

        
            parametro.put("Orden",jComboOpciones.getSelectedItem());

            //JasperReport informe = (JasperReport) JRLoader.loadObjectFromFile("/home/brother/NetBeansProjects/JavaFXm/LtNw/src/lt/reportes/InformPlan.jasper");
            JasperReport informe = (JasperReport) JRLoader.loadObjectFromFile("reportes/InformPlan.jasper");
            JasperPrint j = JasperFillManager.fillReport(informe, parametro, new JRBeanCollectionDataSource(lista));
            JasperViewer jv = new JasperViewer(j, false);
            jv.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setExtendedState(MAXIMIZED_BOTH);
            jv.setVisible(true);

        } catch (JRException ex) {
            
            System.out.println("Error al mostrar "+ex);
        }
    }


}
