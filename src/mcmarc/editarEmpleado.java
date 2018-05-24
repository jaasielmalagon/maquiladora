package mcmarc;

import java.awt.HeadlessException;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hachi_Boy
 */
public class editarEmpleado extends javax.swing.JFrame {

    movs movs = new movs();

    public editarEmpleado() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        cargarAreas();
        DefaultTableModel t;
        deshablitar();
        campoNomina.requestFocusInWindow();
    }

    private void buscarEmpleado() throws SQLException {
        if (campoNomina.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Primero ingrese el número de nómina para buscar al empleado.");
        } else {
            tablaFrm.removeAll();
            int n = Integer.parseInt(campoNomina.getText());
            DefaultTableModel modeloTabla = movs.LlenarTablaEmpleados(n);
            tablaFrm.setModel(modeloTabla);
        }
    }

    private void llenarCampos() throws SQLException {
        int n = Integer.parseInt(campoNomina.getText());
        String[] rs = movs.llenarCampos(n);
        if (rs[0] != null) {
            campoNombre.setText(rs[0]);
            campoSueldo.setText(rs[4]);
            campoTarea.setText(rs[5]);
            areaBox.setSelectedItem(rs[2]);
            operacionBox.setSelectedItem(rs[3]);
        } else {
            JOptionPane.showMessageDialog(rootPane, "No existe el empleado con el número de nómina " + n + ".");
            deshablitar();
        }
    }

    private void limpiar() {
        campoNomina.setText("");
        campoNombre.setText("");
        //campoDireccion.setText("");
        //campoCurp.setText("");
        campoSueldo.setText("");
        campoTarea.setText("");
        areaBox.setSelectedItem("--Seleccione--");
        deshablitar();
    }

    private void habilitar() {
        campoNombre.setEnabled(true);
        //campoDireccion.setEnabled(true);
        campoSueldo.setEnabled(true);
        campoTarea.setEnabled(true);
        areaBox.setEnabled(true);
        operacionBox.setEnabled(true);
    }

    void deshablitar() {
        campoNombre.setEnabled(false);
        // campoDireccion.setEnabled(false);
        campoSueldo.setEnabled(false);
        campoTarea.setEnabled(false);
        areaBox.setEnabled(false);
        operacionBox.setEnabled(false);
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

    private void eliminarEmpleado() throws SQLException {
        if (campoNomina.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Primero busque al empleado y presione eliminar para darle de baja.");
        } else {
            int n = Integer.parseInt(campoNomina.getText());
            if (campoNomina.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "No hay número de nómina para realizar la eliminación.");
            } else {
                boolean b = movs.eliminarEmpleado(n);
                if (b == true) {
                    JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "¡Algo falló! Por favor, intente de nuevo.", "¡Ups!", 2);
                }
            }
        }
    }

    private void modificar() throws SQLException {
        if (campoNomina.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Primero ingrese un número de nómina.", "¡Falta número de nómina!", 2);
        } else {
            int n = Integer.parseInt(campoNomina.getText());
            String nom = campoNombre.getText();
            // String dir = campoDireccion.getText();
            String area = areaBox.getSelectedItem().toString();
            String op = operacionBox.getSelectedItem().toString();
            int sueldo = Integer.parseInt(campoSueldo.getText());
            int tarea = Integer.parseInt(campoTarea.getText());
            try {
                movs.modificarEmpleado("nombre_empleado='" + nom + "', area='" + area + "', operacion='" + op + "', sueldo_base=" + sueldo + ", tarea=" + tarea, "n_nomina=" + n);
                buscarEmpleado();
                limpiar();
                JOptionPane.showMessageDialog(rootPane, "¡Empleado modificado exitosamente!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Error al actualizar datos.");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        salir = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        campoSueldo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoNomina = new javax.swing.JTextField();
        campoTarea = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        guardarDatos = new javax.swing.JToggleButton();
        limpiarDatos = new javax.swing.JToggleButton();
        areaBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        operacionBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFrm = new javax.swing.JTable();
        buscar = new javax.swing.JToggleButton();
        campoNombre = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JToggleButton();
        modificar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Modificar Empleados");
        setAlwaysOnTop(true);
        setResizable(false);

        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/Back.png"))); // NOI18N
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        jLabel4.setText("Area:");

        campoSueldo.setNextFocusableComponent(campoTarea);
        campoSueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoSueldoKeyTyped(evt);
            }
        });

        jLabel5.setText("Número Nómina:");

        jLabel7.setText("Sueldo:");

        jLabel6.setText("Operación:");

        jLabel2.setText("Tarea diaria:");

        campoNomina.setToolTipText("Número de nómina");
        campoNomina.setNextFocusableComponent(campoNombre);
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

        campoTarea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTareaKeyTyped(evt);
            }
        });

        jLabel8.setText("$");

        guardarDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/Save.png"))); // NOI18N
        guardarDatos.setText("Guardar Cambios");
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
        areaBox.setNextFocusableComponent(operacionBox);
        areaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre:");

        operacionBox.setNextFocusableComponent(campoSueldo);
        operacionBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operacionBoxActionPerformed(evt);
            }
        });

        tablaFrm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaFrm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaFrmMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaFrm);

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/Search.png"))); // NOI18N
        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        campoNombre.setNextFocusableComponent(areaBox);
        campoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNombreKeyTyped(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/delete_2.png"))); // NOI18N
        btnEliminar.setText("Eliminar Emp.");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/Modify.png"))); // NOI18N
        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(limpiarDatos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(guardarDatos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(areaBox, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(operacionBox, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel2)
                                        .addGap(6, 6, 6)
                                        .addComponent(campoTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(campoNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(buscar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(modificar)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(campoNomina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel2)
                        .addComponent(campoTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(areaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(operacionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(guardarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(limpiarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void campoSueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoSueldoKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9' || c == ' ') {
            evt.consume();
        }
    }//GEN-LAST:event_campoSueldoKeyTyped

    private void campoNominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNominaActionPerformed
        try {
            buscarEmpleado();
        } catch (SQLException ex) {
            Logger.getLogger(editarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_campoNominaActionPerformed

    private void campoNominaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNominaKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9' || c == ' ') {
            evt.consume();
        }
    }//GEN-LAST:event_campoNominaKeyTyped

    private void campoTareaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTareaKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9' || c == ' ') {
            evt.consume();
        }
    }//GEN-LAST:event_campoTareaKeyTyped

    private void guardarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarDatosActionPerformed
        try {
            modificar();
        } catch (SQLException ex) {
            Logger.getLogger(editarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_guardarDatosActionPerformed

    private void limpiarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarDatosActionPerformed
        limpiar();
    }//GEN-LAST:event_limpiarDatosActionPerformed

    private void areaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaBoxActionPerformed
        cargarOperaciones();
    }//GEN-LAST:event_areaBoxActionPerformed

    private void operacionBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operacionBoxActionPerformed
        sueldoTarea();
    }//GEN-LAST:event_operacionBoxActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        try {
            buscarEmpleado();

        } catch (SQLException ex) {
            Logger.getLogger(editarEmpleado.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void tablaFrmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaFrmMouseClicked
//        if (evt.getButton() == 1) {
//            try{
//            int fila = tablaFrm.getSelectedRow();
//            String seleccionar = (tablaFrm.getModel().getValueAt(fila, 0).toString());
//            } catch (Exception e) {
//            }
//        }
    }//GEN-LAST:event_tablaFrmMouseClicked

    private void campoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNombreKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && (c < ' ' || c > ' ')) {
            evt.consume();
        }
    }//GEN-LAST:event_campoNombreKeyTyped

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            eliminarEmpleado();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "No se ha podido eliminar", "Algo falló", 2);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        if (campoNomina.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Primero ingrese el número de empleado a modificar.");
        } else {
            habilitar();
            try {
                llenarCampos();
            } catch (SQLException ex) {
                //JOptionPane.showMessageDialog(null, "No existe empleado con ese número de nómina.");
            }
        }
    }//GEN-LAST:event_modificarActionPerformed

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
            java.util.logging.Logger.getLogger(editarEmpleado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editarEmpleado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editarEmpleado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editarEmpleado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new editarEmpleado().setVisible(true);

                } catch (SQLException ex) {
                    Logger.getLogger(editarEmpleado.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox areaBox;
    private javax.swing.JToggleButton btnEliminar;
    private javax.swing.JToggleButton buscar;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoNomina;
    private javax.swing.JTextField campoSueldo;
    private javax.swing.JTextField campoTarea;
    private javax.swing.JToggleButton guardarDatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton limpiarDatos;
    private javax.swing.JToggleButton modificar;
    private javax.swing.JComboBox operacionBox;
    private javax.swing.JToggleButton salir;
    private javax.swing.JTable tablaFrm;
    // End of variables declaration//GEN-END:variables
}
