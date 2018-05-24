package mcmarc;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hachi_Boy
 */
public class tareas extends javax.swing.JFrame {

    movs movs = new movs();
    Calendar fecha = new GregorianCalendar();

    public tareas(int user) throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        permiso(user);
        dateTittle.setText(movs.fecha()[0]+"  "+movs.fecha()[1]+"/"+movs.fecha()[2] +"/"+movs.fecha()[3]);
        JOptionPane.showMessageDialog(null, "Para agregar tarea de un dia distinto a ayer \npor favor contacte al"
                + " administrador del sistema o \nal encargado de producción.", "Aviso", 1);
    }

    public void permiso(int user) {
        if (user == 3 || user == 1) {
            diaBox.setEnabled(true);
        } else {
            diaBox.setEnabled(false);
        }
    }

    private void limpiar() {
        txtNomina.setText("");
        txtProduccion.setText("");
        txtNomina.requestFocusInWindow();
    }

    private String dias() {
        int ds = fecha.get(Calendar.DAY_OF_WEEK);
        String dia = "";
        switch (ds - 1) {
            case 2:
                dia = "Lunes";
                break;
            case 3:
                dia = "Martes";
                break;
            case 4:
                dia = "Miercoles";
                break;
            case 5:
                dia = "Jueves";
                break;
            case 6:
                dia = "Viernes";
                break;
            case 7:
                dia = "Sabado";
                break;
            default:
                dia = "Domingo";
                break;
        }
        return dia;
    }

    public void guardar() {
        if ("0".equals(txtNomina.getText()) || "0".equals(txtProduccion.getText()) || txtNomina.getText().isEmpty() || txtProduccion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe completar los campos y seleccionar el dia correspondiente para continuar.", "¡Campos vacíos!", 2);
            // || "--Seleccione--".equals(diaBox.getSelectedItem().toString())
        } else {
            int nn = Integer.parseInt(txtNomina.getText());
            int prod = Integer.parseInt(txtProduccion.getText());
            String dia = "";
            boolean permiso = false;
            if (diaBox.isEnabled()) {
                dia = diaBox.getSelectedItem().toString();
                permiso = true;
            } else {
                dia = dias();
                permiso = false;
            }
            boolean tareas = false;
            try {
                tareas = movs.tareas(dia, nn, prod);

            } catch (SQLException ex) {
                Logger.getLogger(tareas.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            if (tareas == true && permiso == true) {
                JOptionPane.showMessageDialog(null, "¡Listo!", "Tarea agregada", 2);
                txtProduccion.setText("");
                txtProduccion.requestFocusInWindow();
                //limpiar();
            } else if (tareas == true && permiso == false) {
                JOptionPane.showMessageDialog(null, "¡Listo!", "Tarea agregada", 2);
                //txtProduccion.setText("");
                limpiar();

            } else {
                //JOptionPane.showMessageDialog(null, "¡Algo salió mal!","¡Ups!",0);
                JOptionPane.showMessageDialog(null, "Ya se ha agregado tarea del dia " + dia + " para el empleado " + nn + " o tal vez dicho empleado aún no se encuentra registrado.", "Alerta", 0);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNomina = new javax.swing.JTextField();
        txtProduccion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JToggleButton();
        diaBox = new javax.swing.JComboBox();
        dateTittle = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Numero nómina:");

        jLabel2.setText("Producción:");

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

        txtProduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProduccionActionPerformed(evt);
            }
        });
        txtProduccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProduccionKeyTyped(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/Save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        diaBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Seleccione--", "Miercoles", "Jueves", "Viernes", "Sabado", "Lunes", "Martes" }));
        diaBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                diaBoxMouseClicked(evt);
            }
        });
        diaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diaBoxActionPerformed(evt);
            }
        });

        dateTittle.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(diaBox, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnGuardar)))
                        .addGap(91, 91, 91))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dateTittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(85, 85, 85))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dateTittle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(diaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnGuardar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNominaActionPerformed

    }//GEN-LAST:event_txtNominaActionPerformed

    private void txtNominaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNominaKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9' || c == ' ') {
            evt.consume();
        }
    }//GEN-LAST:event_txtNominaKeyTyped

    private void txtProduccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProduccionKeyTyped
        char c = evt.getKeyChar();
        if (dias() != "Sabado") {
            if (c < '0' || c > '9' || c == ' ') {
                getToolkit().beep();
                evt.consume();
            }
        } else {
//            if (c < '0' || c > '9' || c == ' ') {
//                evt.consume();
//            }
        }
    }//GEN-LAST:event_txtProduccionKeyTyped

    private void diaBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diaBoxMouseClicked

    }//GEN-LAST:event_diaBoxMouseClicked

    private void diaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diaBoxActionPerformed
        guardar();
    }//GEN-LAST:event_diaBoxActionPerformed

    private void txtProduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProduccionActionPerformed
        guardar();
    }//GEN-LAST:event_txtProduccionActionPerformed

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
            java.util.logging.Logger.getLogger(tareas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tareas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tareas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tareas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                try {
//                    new tareas().setVisible(true);
//
//                } catch (SQLException ex) {
//                    Logger.getLogger(tareas.class
//                            .getName()).log(Level.SEVERE, null, ex);
//                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnGuardar;
    private javax.swing.JLabel dateTittle;
    private javax.swing.JComboBox diaBox;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtNomina;
    private javax.swing.JTextField txtProduccion;
    // End of variables declaration//GEN-END:variables
}
