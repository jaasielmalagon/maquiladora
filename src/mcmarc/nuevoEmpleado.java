package mcmarc;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hachi_Boy
 */
public class nuevoEmpleado extends javax.swing.JFrame {

    movs movs = new movs();

    public nuevoEmpleado() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        JOptionPane.showMessageDialog(rootPane, "Asegúrese de completar todos los campos antes de guardar.");
        cargarAreas();
    }

    private void limpiar() {
        campoNomina.setText("");
        campoNombre.setText("");
        campoSueldo.setText("");
        campoTarea.setText("");
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

    private void sueldoTarea() {
        if (operacionBox.getSelectedItem() == "--Seleccione--" || areaBox.getSelectedItem() == "--Seleccione--") {
            campoSueldo.setText("");
            campoTarea.setText("");
        } else {
            try {
                String[] datos = movs.datosOperacion("tarea, sueldo_base", "op_" + areaBox.getSelectedItem().toString(),
                        "nombre_op='" + operacionBox.getSelectedItem().toString() + "'");
                if (datos[0] != null && datos[1] != null) {
                    campoTarea.setText(datos[0]);
                    campoSueldo.setText(datos[1]);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "No se encontró tarea ni sueldo definido para dicha operación.", "!Aviso¡", WIDTH);
                    campoSueldo.setText("");
                    campoTarea.setText("");
                }
            } catch (HeadlessException | SQLException e) {

            }
        }
    }

    private void guardar() throws SQLException {
        if (campoNomina.getText().isEmpty() || campoNombre.getText().isEmpty()|| campoSueldo.getText().isEmpty() || campoTarea.getText().isEmpty() || areaBox.getSelectedItem() == "--Seleccione--" || areaBox.getSelectedItem() == null || operacionBox.getSelectedItem() == "--Seleccione--" || operacionBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "Para continuar, por favor completa todos los campos.", "¡Hay campos vacíos!", 2);
        } else {
            String coincidencia[] = new String[5];
            ResultSet rs = movs.busquedaPreEliminacion(Integer.parseInt(campoNomina.getText()));
            int estado = 0;
            while (rs.next()) {
                //coincidencia[0] = rs.getString("curp");
                coincidencia[1] = rs.getString("estado");
                coincidencia[3] = rs.getString("nombre_empleado");
                coincidencia[4] = rs.getString("n_nomina");
                estado = Integer.parseInt(coincidencia[1]);
            }
            if (estado == 0 && coincidencia[4] != campoNomina.getText()) {
                try {
                    movs.nuevoEmpleado(Integer.parseInt(campoNomina.getText()) + ",'" + campoNombre.getText() + "','" + areaBox.getSelectedItem().toString()
                            + "','" + operacionBox.getSelectedItem().toString() + "', 1, now()," + Integer.parseInt(campoSueldo.getText()) + "," + Integer.parseInt(campoTarea.getText()) + ",0,0,0,0,0,0");
                    JOptionPane.showMessageDialog(rootPane, "¡Empleado guardado exitosamente!", "Guardado", WIDTH);
                    limpiar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Error al guardar" + ex);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Ya existe un registro con el mismo número de nómina.");
            }
        }
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoNomina = new javax.swing.JTextField();
        campoNombre = new javax.swing.JTextField();
        guardarDatos = new javax.swing.JToggleButton();
        limpiarDatos = new javax.swing.JToggleButton();
        areaBox = new javax.swing.JComboBox();
        operacionBox = new javax.swing.JComboBox();
        salir = new javax.swing.JToggleButton();
        campoSueldo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoTarea = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel1.setText("Nombre:");

        jLabel4.setText("Area:");

        jLabel5.setText("Número Nómina:");

        jLabel6.setText("Operación:");

        campoNomina.setToolTipText("Número de nómina");
        campoNomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNominaActionPerformed(evt);
            }
        });
        campoNomina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNominaKeyTyped(evt);
            }
        });

        campoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreActionPerformed(evt);
            }
        });
        campoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNombreKeyTyped(evt);
            }
        });

        guardarDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/Save.png"))); // NOI18N
        guardarDatos.setText("Guardar Datos");
        guardarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarDatosActionPerformed(evt);
            }
        });

        limpiarDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/Delete.png"))); // NOI18N
        limpiarDatos.setText("Cancelar");
        limpiarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarDatosActionPerformed(evt);
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

        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/Back.png"))); // NOI18N
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        campoSueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoSueldoActionPerformed(evt);
            }
        });
        campoSueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoSueldoKeyTyped(evt);
            }
        });

        jLabel7.setText("Sueldo sugerido:");

        jLabel2.setText("Tarea diaria sugerida:");

        campoTarea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTareaKeyTyped(evt);
            }
        });

        jLabel8.setText("$");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(guardarDatos)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(limpiarDatos))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(areaBox, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(41, 41, 41)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(operacionBox, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoNomina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(areaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(operacionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(campoTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salir)
                    .addComponent(guardarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpiarDatos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoNominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNominaActionPerformed

    }//GEN-LAST:event_campoNominaActionPerformed

    private void campoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreActionPerformed

    private void guardarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarDatosActionPerformed
        try {
            guardar();
        } catch (SQLException ex) {
            Logger.getLogger(nuevoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_guardarDatosActionPerformed

    private void limpiarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarDatosActionPerformed
        limpiar();
    }//GEN-LAST:event_limpiarDatosActionPerformed

    private void operacionBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operacionBoxActionPerformed
        sueldoTarea();
    }//GEN-LAST:event_operacionBoxActionPerformed

    private void areaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaBoxActionPerformed
        cargarOperaciones();
    }//GEN-LAST:event_areaBoxActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.dispose();        
    }//GEN-LAST:event_salirActionPerformed

    private void campoNominaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNominaKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9' || c == ' ') {
            evt.consume();
        }
    }//GEN-LAST:event_campoNominaKeyTyped

    private void campoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNombreKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && (c < ' ' || c > ' ')) {
            evt.consume();
        }
    }//GEN-LAST:event_campoNombreKeyTyped

    private void campoSueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoSueldoKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9' || c == ' ') {
            evt.consume();
        }
    }//GEN-LAST:event_campoSueldoKeyTyped

    private void campoTareaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTareaKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9' || c == ' ') {
            evt.consume();
        }
    }//GEN-LAST:event_campoTareaKeyTyped

    private void campoSueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoSueldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoSueldoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new nuevoEmpleado().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(nuevoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox areaBox;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoNomina;
    private javax.swing.JTextField campoSueldo;
    private javax.swing.JTextField campoTarea;
    private javax.swing.JToggleButton guardarDatos;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JToggleButton limpiarDatos;
    private javax.swing.JComboBox operacionBox;
    private javax.swing.JToggleButton salir;
    // End of variables declaration//GEN-END:variables
}
