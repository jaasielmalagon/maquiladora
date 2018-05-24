package mcmarc;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Hachi_Boy
 */
public final class panelPrincipal extends javax.swing.JFrame {

    movs m = new movs();
    int permiso = 0;
    String u;

    public panelPrincipal(int tipo, String usuario, String nombre, String img) throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        cargarMenu(tipo);
        ImageIcon perfil = new ImageIcon(img);
        foto.setIcon(perfil);
        m.fecha();
        fecha.setText(m.fecha()[0] + " " + m.fecha()[1] + "/" + m.fecha()[2] + "/" + m.fecha()[3]);
        //poner nombre de usuario
        bienvenido.setText("Bienvenido: " + nombre);
        nombreUsuario.setText(usuario);
        hora.setText("Sesión iniciada: " + m.fecha()[4] + ":" + m.fecha()[5] + ":" + m.fecha()[7] + " " + m.fecha()[6]);
        this.permiso = tipo;
        this.u = usuario;
    }

    public void cargarMenu(int user) {
        switch (user) {
            case 1:

                break;
            case 3:
                ajustes.setEnabled(false);
                break;
            case 2:
                //opcAlmacen.setEnabled(true);
                opcAdministracion.setEnabled(false);
                //opcCortes.setEnabled(false);
                opcEmpleados.setEnabled(false);
                ajustes.setEnabled(false);
                break;
            case 4:
                opcEmpleados.setEnabled(true);
                nuevoEmpleado.setEnabled(true);
                modificarEmpleado.setVisible(false);
                nomina.setVisible(false);
                //opcAlmacen.setEnabled(false);
                //opcCortes.setEnabled(false);
                opcAdministracion.setEnabled(false);
                ajustes.setEnabled(false);
                break;
            case 5:
                opcEmpleados.setEnabled(false);
                //opcAlmacen.setEnabled(false);
                //opcCortes.setEnabled(false);
                opcAdministracion.setEnabled(false);
                ajustes.setEnabled(false);
                break;
            case 6:
                //reporteAvios.setVisible(false);
                opcAdministracion.setEnabled(false);
                //opcCortes.setEnabled(false);
                opcEmpleados.setEnabled(false);
                ajustes.setEnabled(false);
                break;
            default:
                opcEmpleados.setEnabled(false);
                //opcAlmacen.setEnabled(false);
                //opcCortes.setEnabled(false);
                opcAdministracion.setEnabled(false);
                ajustes.setEnabled(false);
                break;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        fecha = new javax.swing.JLabel();
        bienvenido = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        foto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        opcEmpleados = new javax.swing.JMenu();
        nuevoEmpleado = new javax.swing.JMenu();
        modificarEmpleado = new javax.swing.JMenu();
        agregarTarea = new javax.swing.JMenu();
        nomina = new javax.swing.JMenu();
        opcAdministracion = new javax.swing.JMenu();
        nuevoUsuario = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        ajustes = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        Salir = new javax.swing.JMenu();

        jToggleButton1.setText("jToggleButton1");

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Mc&Marc Control Panel");
        setMinimumSize(new java.awt.Dimension(1300, 700));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));

        fecha.setBackground(new java.awt.Color(153, 153, 255));
        fecha.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        fecha.setForeground(new java.awt.Color(255, 255, 255));
        fecha.setText("Fecha");

        bienvenido.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        bienvenido.setForeground(new java.awt.Color(255, 255, 255));
        bienvenido.setText("Bienvenido:");
        bienvenido.setFocusTraversalPolicyProvider(true);
        bienvenido.setMinimumSize(new java.awt.Dimension(100, 25));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Seleccione la operación que \ndesea realizar dando click \nen el botón que indique dicha \noperación.\n\n¿Necesita ayuda?\n\nEnvíe un correo a la dirección \nmaalaagasz@gmail.com o llame\nal teléfono (238) 120-91-30 y con\ngusto se le brindará soporte\nespecializado.");
        jScrollPane1.setViewportView(jTextArea1);

        foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/image_missing.png"))); // NOI18N
        foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/contact.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bienvenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 201, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        nombreUsuario.setFont(new java.awt.Font("Trajan Pro", 3, 14)); // NOI18N
        nombreUsuario.setText("Nombre del usuario en turno");

        hora.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        hora.setText("Hora");

        opcEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/Profile.png"))); // NOI18N
        opcEmpleados.setText("Empleados");

        nuevoEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/Add.png"))); // NOI18N
        nuevoEmpleado.setText("Nuevo empleado");
        nuevoEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nuevoEmpleadoMouseClicked(evt);
            }
        });
        opcEmpleados.add(nuevoEmpleado);

        modificarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/modify_pencil.png"))); // NOI18N
        modificarEmpleado.setText("Modificar empleado");
        modificarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modificarEmpleadoMouseClicked(evt);
            }
        });
        modificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarEmpleadoActionPerformed(evt);
            }
        });
        opcEmpleados.add(modificarEmpleado);

        agregarTarea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/tarea.png"))); // NOI18N
        agregarTarea.setText("Agregar tarea");
        agregarTarea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarTareaMouseClicked(evt);
            }
        });
        opcEmpleados.add(agregarTarea);

        nomina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/Bar Chart.png"))); // NOI18N
        nomina.setText("Nómina");
        nomina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nominaMouseClicked(evt);
            }
        });
        opcEmpleados.add(nomina);

        jMenuBar1.add(opcEmpleados);

        opcAdministracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/admin.png"))); // NOI18N
        opcAdministracion.setText("Administración");

        nuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/Profile.png"))); // NOI18N
        nuevoUsuario.setText("Usuarios");
        nuevoUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nuevoUsuarioMouseClicked(evt);
            }
        });
        opcAdministracion.add(nuevoUsuario);

        jMenu1.setText("jMenu1");
        opcAdministracion.add(jMenu1);

        jMenuBar1.add(opcAdministracion);

        ajustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/ajustes.png"))); // NOI18N
        ajustes.setText("Ajustes avanzados");

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/cmd_icon.png"))); // NOI18N
        jMenu4.setText("Panel de ajustes");
        ajustes.add(jMenu4);

        jMenuBar1.add(ajustes);

        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/Exit.png"))); // NOI18N
        Salir.setText("Salir");
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(Salir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hora)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        boolean logout = false;
        try {
            logout = m.cerrarSesion(this.u);
        } catch (SQLException ex) {
            Logger.getLogger(panelPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (logout == true) {
            new sesionStart1().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_SalirMouseClicked

    private void nuevoEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoEmpleadoMouseClicked
        try {
            new nuevoEmpleado().setVisible(true);
            //this.hide();
        } catch (SQLException ex) {
            Logger.getLogger(panelPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        //this.dispose();
    }//GEN-LAST:event_nuevoEmpleadoMouseClicked

    private void modificarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarEmpleadoMouseClicked
        try {
            new editarEmpleado().setVisible(true);
            //this.hide();
        } catch (SQLException ex) {
            Logger.getLogger(panelPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_modificarEmpleadoMouseClicked

    private void modificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificarEmpleadoActionPerformed

    private void agregarTareaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarTareaMouseClicked
        try {
            new tareas(permiso).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(panelPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_agregarTareaMouseClicked

    private void nominaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nominaMouseClicked
        try {
            new nomina().setVisible(true);
//            this.hide();
        } catch (SQLException ex) {
            Logger.getLogger(panelPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nominaMouseClicked

    private void nuevoUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoUsuarioMouseClicked
        
    }//GEN-LAST:event_nuevoUsuarioMouseClicked

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
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Salir;
    private javax.swing.JMenu agregarTarea;
    private javax.swing.JMenu ajustes;
    private javax.swing.JLabel bienvenido;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel foto;
    private javax.swing.JLabel hora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JMenu modificarEmpleado;
    private javax.swing.JLabel nombreUsuario;
    private javax.swing.JMenu nomina;
    private javax.swing.JMenu nuevoEmpleado;
    private javax.swing.JMenu nuevoUsuario;
    private javax.swing.JMenu opcAdministracion;
    private javax.swing.JMenu opcEmpleados;
    // End of variables declaration//GEN-END:variables
}
