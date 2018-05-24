package mcmarc;

import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hachi_Boy
 */
public class nomina extends javax.swing.JFrame {

    movs movs = new movs();

    public nomina() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        cargarAreas();
        fecha.setText(movs.fecha()[0] + " " + movs.fecha()[1] + "/" + movs.fecha()[2] + "/" + movs.fecha()[3]);
    }
    
    private void limpiar() {
        txtNomina.setText("");
        areaBox.setSelectedItem("--Seleccione--");
    }

    private void cargarAreas() throws SQLException {
        areaBox.setModel(movs.areas());
    }

    private void cargarOperaciones() {
        if (areaBox.getSelectedItem() == "--Seleccione--") {
            operacionBox.removeAllItems();
        } else {
            try {
                operacionBox.setModel(movs.operaciones(areaBox.getSelectedItem().toString()));
            } catch (SQLException ex) {
                Logger.getLogger(nuevoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void llenarTabla() throws SQLException {
        if (txtNomina.getText().isEmpty() && areaBox.getSelectedItem() == "--Seleccione--") {
            DefaultTableModel tablaGeneral = movs.tablaNomina("estado=1");
            JOptionPane.showMessageDialog(rootPane, "No hay datos para buscar, se mostrará la nómina general.");
            tablaNomina.setModel(tablaGeneral);
            
        } else if (areaBox.getSelectedItem() == "--Seleccione--") {
            int n = Integer.parseInt(txtNomina.getText());
            DefaultTableModel tablaXnumero = movs.tablaNomina("n_nomina=" + n);
            tablaNomina.setModel(tablaXnumero);
            
        } else if (txtNomina.getText().isEmpty() && areaBox.getSelectedItem() != "--Seleccione--" && operacionBox.getSelectedItem() != "--Seleccione--") {
            String operacion = operacionBox.getSelectedItem().toString();
            String area = areaBox.getSelectedItem().toString();
            DefaultTableModel tablaXoperacion = movs.tablaNomina("area='" + area + "' AND operacion='" + operacion + "'");
            tablaNomina.setModel(tablaXoperacion);
            
        } else if (txtNomina.getText().isEmpty() && areaBox.getSelectedItem() != "--Seleccione--") {
            String area = areaBox.getSelectedItem().toString();
            DefaultTableModel tablaXarea = movs.tablaNomina("area='" + area + "'");
            tablaNomina.setModel(tablaXarea);
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaNomina = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNomina = new javax.swing.JTextField();
        areaBox = new javax.swing.JComboBox();
        operacionBox = new javax.swing.JComboBox();
        buscar = new javax.swing.JToggleButton();
        salir = new javax.swing.JToggleButton();
        btnGenerarNomina = new javax.swing.JToggleButton();
        fecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);

        tablaNomina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Nombre", "Area", "Operación", "Sueldo base ($)", "Tarea Diaria (pzas)", "Tarea Semanal (pzas)", "Factor x pieza ($)", "Miercoles", "Jueves", "Viernes", "Sábado", "Lunes", "Martes", "Total Producido (pzas)", "Rendimiento general (%)", "Sueldo al dia ($)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaNomina.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaNomina);

        jLabel1.setText("Número:");

        jLabel2.setText("Area:");

        jLabel3.setText("Operación:");

        txtNomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNominaActionPerformed(evt);
            }
        });
        txtNomina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNominaKeyTyped(evt);
            }
        });

        areaBox.setToolTipText("Seleccione su área.");
        areaBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        areaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaBoxActionPerformed(evt);
            }
        });

        operacionBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operacionBoxActionPerformed(evt);
            }
        });

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/Search.png"))); // NOI18N
        buscar.setText("Consultar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/Back.png"))); // NOI18N
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        btnGenerarNomina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/excel.png"))); // NOI18N
        btnGenerarNomina.setText("Generar Archivo Nómina");
        btnGenerarNomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarNominaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(operacionBox, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(areaBox, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(buscar)
                                        .addGap(76, 76, 76)
                                        .addComponent(btnGenerarNomina)))
                                .addGap(32, 32, 32)
                                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salir))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salir)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNomina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buscar)
                                    .addComponent(btnGenerarNomina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(areaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(operacionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNominaActionPerformed
        int n = 0;
        if (areaBox.getSelectedItem() == "--Seleccione--" && txtNomina.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "No hay datos para buscar, se mostrará la nómina general.");
            DefaultTableModel tablaGeneral;
            try {
                tablaGeneral = movs.tablaNomina("estado=1");
                tablaNomina.setModel(tablaGeneral);
            } catch (SQLException ex) {
                Logger.getLogger(nomina.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                n = Integer.parseInt(txtNomina.getText());
                DefaultTableModel tablaXnumero = movs.tablaNomina("n_nomina=" + n);
                tablaNomina.setModel(tablaXnumero);
            } catch (SQLException ex) {
                Logger.getLogger(nomina.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtNominaActionPerformed

    private void areaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaBoxActionPerformed
        cargarOperaciones();
    }//GEN-LAST:event_areaBoxActionPerformed

    private void operacionBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operacionBoxActionPerformed

    }//GEN-LAST:event_operacionBoxActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        try {
            llenarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(nomina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void btnGenerarNominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarNominaActionPerformed
        JFileChooser ruta = new JFileChooser();
        ruta.showSaveDialog(this);

        File f = new File(ruta.getSelectedFile() + "(" + movs.fecha()[0] + "-" + movs.fecha()[1] + "-" + movs.fecha()[2] + "-" + movs.fecha()[3] + ").xls");
        int respuesta = JOptionPane.showConfirmDialog(rootPane, "Esta acción generará un archivo .xls y reiniciará por completo los campos "
                + "\nseleccionados. Presione 'Si' para reiniciar todo, presione 'No' para guardar el archivo sin reiniciar. ", "¡Precaución!", 0);
        if (respuesta != 0) {
            if (txtNomina.getText().isEmpty()) {
                try {
                    movs.exportarExcel(tablaNomina, f);
                    JOptionPane.showMessageDialog(rootPane, "Se ha guardado el archivo " + f);
                } catch (Exception e) {
                }
            } else if (areaBox.getSelectedItem() == "--Seleccione--") {
                try {
                    movs.exportarExcel(tablaNomina, f);
                    JOptionPane.showMessageDialog(rootPane, "Se ha guardado el archivo " + f);
                } catch (Exception e) {
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se pudo guardar el archivo en la ruta específicada.", "Error", ERROR);
            }
        } else {
            if (txtNomina.getText().isEmpty()) {
                try {
                    movs.exportarExcel(tablaNomina, f);
                    movs.reiniciarCampos("1");
                    JOptionPane.showMessageDialog(rootPane, "Se ha guardado el archivo y se han reiniciado los campos seleccionados" + f);
                } catch (Exception e) {
                }
            } else if (areaBox.getSelectedItem() == "--Seleccione--") {
                try {
                    movs.exportarExcel(tablaNomina, f);
                    movs.reiniciarCampos("n_nomina=" + txtNomina.getText());
                    JOptionPane.showMessageDialog(rootPane, "Se ha guardado el archivo y se han reiniciado los campos seleccionados " + f);
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_btnGenerarNominaActionPerformed

    private void txtNominaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNominaKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9' || c == ' ') {
            evt.consume();
        }
    }//GEN-LAST:event_txtNominaKeyTyped

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
            java.util.logging.Logger.getLogger(nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new nomina().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(nomina.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox areaBox;
    private javax.swing.JToggleButton btnGenerarNomina;
    private javax.swing.JToggleButton buscar;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox operacionBox;
    private javax.swing.JToggleButton salir;
    private javax.swing.JTable tablaNomina;
    private javax.swing.JTextField txtNomina;
    // End of variables declaration//GEN-END:variables
}
