package mcmarc;

import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Hachi_Boy
 */
public class sesionStart1 extends javax.swing.JFrame {

    movs movimientos = new movs();

    public sesionStart1() {
        initComponents();
        setLocationRelativeTo(null);
        userID.requestFocusInWindow();
        movimientos.fecha();
        fecha.setText(movimientos.fecha()[0] + " " + movimientos.fecha()[1] + "/" + movimientos.fecha()[2] + "/" + movimientos.fecha()[3]);
    }

    public void sesion() {
        String u = userID.getText();
        String p = userPw.getText();
        if (userID.getText().isEmpty() || userPw.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese nombre de usuario y contraseña para continuar.", "Acceso denegado.", 0);
        } else {
            if (userID.getText().length() >= 5 && userPw.getText().length() >= 5) {
                try {
                    String[] ses = movimientos.usuario(u, p);
                    if (ses[0] != null && ses[1] != null && "0".equals(ses[6])) {
                        boolean regSes = movimientos.registroSesion(ses[0]);
                        if (regSes == true) {
                            JOptionPane.showMessageDialog(null, "Bienvenido " + ses[0]);
                            new panelPrincipal(Integer.parseInt(ses[2]), ses[0], ses[3], ses[4]).setVisible(true);
                            this.dispose();
                        }
                    } else if (ses[0] != null && ses[1] != null && "1".equals(ses[6])) {
                        JOptionPane.showMessageDialog(rootPane, "¡Su sesión ya ha sido iniciada en otra PC\ncierrela para poder iniciar una nueva.!", "Sesión iniciada previamente.", 0);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "¡Usuario o contraseña incorrectos!", "Error de autenticación", 0);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(sesionStart1.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El usuario o contraseña son demasiado cortos, recuerde que un usuario y contraseña validos deben tener 5 o más caractéres.", "Error de autenticación", 1);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userID = new javax.swing.JTextField();
        btnIniciarSesion = new javax.swing.JToggleButton();
        userPw = new javax.swing.JPasswordField();
        salir = new javax.swing.JToggleButton();
        fecha = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Iniciar Sesión");
        setIconImage(
            Toolkit.getDefaultToolkit().getImage("sesion_user.png"));
        setResizable(false);

        jLabel1.setText("User ID:");

        jLabel2.setText("Password:");

        userID.setToolTipText("Nombre de Usuario");
        userID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        userID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIDActionPerformed(evt);
            }
        });
        userID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userIDKeyTyped(evt);
            }
        });

        btnIniciarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/admin.png"))); // NOI18N
        btnIniciarSesion.setText("Iniciar Sesión");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        userPw.setToolTipText("Contraseña de usuario");
        userPw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userPwActionPerformed(evt);
            }
        });
        userPw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userPwKeyTyped(evt);
            }
        });

        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/Exit.png"))); // NOI18N
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        fecha.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userPw))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnIniciarSesion)
                        .addGap(21, 21, 21)
                        .addComponent(salir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userID)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userPw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(salir, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/usuario.png"))); // NOI18N
        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIDActionPerformed
        sesion();
    }//GEN-LAST:event_userIDActionPerformed

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        sesion();
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void userPwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userPwActionPerformed
        sesion();
    }//GEN-LAST:event_userPwActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir?", "¡Precaución!", 0);
        if (respuesta == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_salirActionPerformed

    private void userIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userIDKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && (c == ' ' || c == 'ñ' || c == 'Ñ')) {
            //evt.consume();
        }
    }//GEN-LAST:event_userIDKeyTyped

    private void userPwKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userPwKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && (c == ' ' || c == 'ñ' || c == 'Ñ')) {
            evt.consume();
        }
    }//GEN-LAST:event_userPwKeyTyped

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
                new sesionStart1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnIniciarSesion;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton salir;
    private javax.swing.JTextField userID;
    private javax.swing.JPasswordField userPw;
    // End of variables declaration//GEN-END:variables
}
