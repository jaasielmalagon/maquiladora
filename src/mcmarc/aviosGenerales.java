package mcmarc;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jaasiel Malagon
 */
public class aviosGenerales extends javax.swing.JFrame {

    movs m = new movs();
    controlAlmacen ca = new controlAlmacen();
    String almacn[] = new String[2];

    public aviosGenerales(String u, int tipo) throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        limpiar();
        this.setTitle(u);
        txtCorte.requestFocusInWindow();
        this.almacn[0] = ca.nombreAlmacen(u)[0];
        this.almacn[1] = ca.nombreAlmacen(u)[1];
        iniciarTabla(tipo, u);
        if ("Administrador".equals(almacn[0]) || "Superusuario".equals(almacn[0])) {
            almacenBox.setModel(ca.destinosComboBox());
            almacn[1] = ca.nombreAlmacen(almacenBox.getSelectedItem().toString())[1];
        }else{
            almacenBox.setVisible(false);
            this.almacn[1] = ca.nombreAlmacen(u)[1];
        }
    }

    private void iniciarTabla(int permiso, String u) throws SQLException {
        if (permiso == 1 || permiso == 2 || permiso == 3) {
            tablaAviosGenerales.setModel(ca.tablaAvios("1"));
        } else {
            tablaAviosGenerales.setModel(ca.tablaAvios("almacen='" + ca.nombreAlmacen(u)[1] + "'"));
        }
    }

    private void limpiar() {
        txtCorte.setText("D");
        txtCierre.setText("0");
        txtDeslizador.setText("0");
        txtMarca.setText("0");
        txtMonach.setText("0");
        txtTalla.setText("0");
        txtFus.setText("0");
        txtHilo.setText("0");
        txtResorte.setText("0");
        txtPiel.setText("0");
        txtTabtam.setText("0");
        txtTabtalla.setText("0");
        comentarios.setText("");
    }

    private void guardar() throws SQLException {
        String corte = txtCorte.getText();
        String cierre = txtCierre.getText();
        String deslizador = txtDeslizador.getText();
        String marca = txtMarca.getText();
        String monach = txtMonach.getText();
        String talla = txtTalla.getText();
        String cintaFus = txtFus.getText();
        String hilo = txtHilo.getText();
        String resorte = txtResorte.getText();
        String piel = txtPiel.getText();
        String tabtam = txtTabtam.getText();
        String tabtalla = txtTabtalla.getText();
        String coment = comentarios.getText();
        if (corte.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe introducir un número de corte", "¡Campos vacíos!", 2);
            txtCorte.requestFocusInWindow();
        } else {
            
            boolean guardar = ca.guardarAvios(almacn[1]+",'" + corte + "'," + Integer.parseInt(cierre) + "," + Integer.parseInt(deslizador) + "," + Integer.parseInt(marca) + "," + Integer.parseInt(monach) + "," + Integer.parseInt(talla) + ","
                    + Integer.parseInt(cintaFus) + "," + Integer.parseInt(hilo) + "," + Integer.parseInt(resorte) + "," + Integer.parseInt(piel) + "," + Integer.parseInt(tabtam) + "," + Integer.parseInt(tabtalla) + ",'" + coment + "',now(),now()");
            if (guardar == true) {
                JOptionPane.showMessageDialog(rootPane, "Avíos guardados correctamente", "Guardado", 1);
                //tablaAviosGenerales.setModel(ca.tablaAvios("almacen='" + almacn + "'"));
                iniciarTabla(4, almacn[0]);
                limpiar();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Por favor verifique que todos los campos se encuentren llenos.", "Error al guardar.", 0);
            }
        }
    }

    // private void 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAviosGenerales = new javax.swing.JTable();
        btnBuscar = new javax.swing.JToggleButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDeslizador = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        txtMarca = new javax.swing.JTextField();
        txtMonach = new javax.swing.JTextField();
        btnSalir = new javax.swing.JToggleButton();
        txtTalla = new javax.swing.JTextField();
        txtFus = new javax.swing.JTextField();
        txtResorte = new javax.swing.JTextField();
        txtPiel = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCorte = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHilo = new javax.swing.JTextField();
        txtCierre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTabtam = new javax.swing.JTextField();
        txtTabtalla = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        comentarios = new javax.swing.JTextArea();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel14 = new javax.swing.JLabel();
        almacenBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel9.setText("Resorte:");

        jLabel10.setText("Etiq. Piel:");

        jLabel11.setText("Etiq. Tabtam:");

        jLabel12.setText("Etiq. Tabtalla:");

        tablaAviosGenerales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Corte", "Cierre", "Deslizador", "Etiq. Marca", "Etiq. Monach", "Etiq. Talla", "Cinta FUS", "Hilo", "Resorte", "Etiq. Piel", "Etiq. Tabtam", "Etiq. Tabtalla", "Comentarios:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaAviosGenerales);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/Search.png"))); // NOI18N
        btnBuscar.setText("Buscar corte");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel13.setText("Buscar:");

        jLabel6.setText("Etiq. Monach:");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        jLabel7.setText("Etiq. Talla:");

        jLabel8.setText("Cinta FUS:");

        txtDeslizador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDeslizadorActionPerformed(evt);
            }
        });
        txtDeslizador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDeslizadorKeyTyped(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/Save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });
        txtMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMarcaKeyTyped(evt);
            }
        });

        txtMonach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonachActionPerformed(evt);
            }
        });
        txtMonach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMonachKeyTyped(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/Back.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        txtTalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTallaActionPerformed(evt);
            }
        });
        txtTalla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTallaKeyTyped(evt);
            }
        });

        txtFus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFusActionPerformed(evt);
            }
        });
        txtFus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFusKeyTyped(evt);
            }
        });

        txtResorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtResorteActionPerformed(evt);
            }
        });

        txtPiel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPielActionPerformed(evt);
            }
        });

        jLabel1.setText("Corte:");

        txtCorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorteActionPerformed(evt);
            }
        });
        txtCorte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorteKeyTyped(evt);
            }
        });

        jLabel2.setText("Hilo:");

        txtHilo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHiloActionPerformed(evt);
            }
        });
        txtHilo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHiloKeyTyped(evt);
            }
        });

        txtCierre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCierreActionPerformed(evt);
            }
        });
        txtCierre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCierreKeyTyped(evt);
            }
        });

        jLabel3.setText("Cierre:");

        jLabel4.setText("Deslizador:");

        jLabel5.setText("Etiq. Marca:");

        txtTabtam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTabtamActionPerformed(evt);
            }
        });

        txtTabtalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTabtallaActionPerformed(evt);
            }
        });

        comentarios.setColumns(18);
        comentarios.setFont(new java.awt.Font("Arial", 0, 9)); // NOI18N
        comentarios.setRows(3);
        comentarios.setBorder(javax.swing.BorderFactory.createTitledBorder("Comentarios:"));
        jScrollPane2.setViewportView(comentarios);

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/enviar.png"))); // NOI18N
        jToggleButton1.setText("Eviar avios");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/ark.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDeslizador))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCierre, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCorte, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtMonach)
                                    .addComponent(txtMarca)
                                    .addComponent(txtTalla, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtResorte, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel2))
                                        .addGap(15, 15, 15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtHilo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFus, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPiel)
                                    .addComponent(txtTabtam)
                                    .addComponent(txtTabtalla, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton1)
                                .addGap(33, 33, Short.MAX_VALUE)
                                .addComponent(jLabel14))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(almacenBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtCorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtCierre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtDeslizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(txtMonach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(txtTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtFus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtPiel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(txtHilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel9)
                                            .addComponent(txtResorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel11)
                                            .addComponent(txtTabtam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel12)
                                            .addComponent(txtTabtalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalir))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(almacenBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDeslizadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDeslizadorKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDeslizadorKeyTyped

    private void txtMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMarcaKeyTyped

    private void txtMonachKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMonachKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMonachKeyTyped

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtTallaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTallaKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTallaKeyTyped

    private void txtFusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFusKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFusKeyTyped

    private void txtCorteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorteKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'A' || c > 'Z') && (c < '0' || c > '9')) {
            evt.consume();
            //JOptionPane.showMessageDialog(rootPane,"Solo pueden introducirse letras mayúsculas y números","Aviso",1);
        }
    }//GEN-LAST:event_txtCorteKeyTyped

    private void txtHiloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHiloKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtHiloKeyTyped

    private void txtCierreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCierreKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCierreKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            guardar();
        } catch (SQLException ex) {
            Logger.getLogger(aviosGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtTabtamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTabtamActionPerformed
        try {
            guardar();
        } catch (SQLException ex) {
            Logger.getLogger(aviosGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtTabtamActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        if (txtBuscar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Primero ingrese un número de corte", "No hay número", 0);
        } else {
            try {
                if ("master".equals(almacn[0]) || "admin".equals(almacn[0])) {
                    tablaAviosGenerales.setModel(ca.tablaAvios("corte='" + txtBuscar.getText() + "'"));
                } else {
                    tablaAviosGenerales.setModel(ca.tablaAvios("corte='" + txtBuscar.getText() + "' AND almacen='" + almacn[1] + "'"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(aviosGenerales.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtBuscar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Primero ingrese un número de corte", "No hay número", 0);
        } else {
            try {
                tablaAviosGenerales.setModel(ca.tablaAvios("corte='" + txtBuscar.getText() + "' AND almacen='" + almacn + "'"));
            } catch (SQLException ex) {
                Logger.getLogger(aviosGenerales.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        try {
            new enviarAvios(almacn[0], almacn[1]).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(aviosGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void txtCorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorteActionPerformed
        try {
            guardar();
        } catch (SQLException ex) {
            Logger.getLogger(aviosGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtCorteActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        try {
            guardar();
        } catch (SQLException ex) {
            Logger.getLogger(aviosGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtFusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFusActionPerformed
        try {
            guardar();
        } catch (SQLException ex) {
            Logger.getLogger(aviosGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtFusActionPerformed

    private void txtPielActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPielActionPerformed
        try {
            guardar();
        } catch (SQLException ex) {
            Logger.getLogger(aviosGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtPielActionPerformed

    private void txtCierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCierreActionPerformed
        try {
            guardar();
        } catch (SQLException ex) {
            Logger.getLogger(aviosGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtCierreActionPerformed

    private void txtMonachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonachActionPerformed
        try {
            guardar();
        } catch (SQLException ex) {
            Logger.getLogger(aviosGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtMonachActionPerformed

    private void txtHiloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHiloActionPerformed
        try {
            guardar();
        } catch (SQLException ex) {
            Logger.getLogger(aviosGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtHiloActionPerformed

    private void txtDeslizadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDeslizadorActionPerformed
        try {
            guardar();
        } catch (SQLException ex) {
            Logger.getLogger(aviosGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtDeslizadorActionPerformed

    private void txtTallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTallaActionPerformed
        try {
            guardar();
        } catch (SQLException ex) {
            Logger.getLogger(aviosGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtTallaActionPerformed

    private void txtResorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtResorteActionPerformed
        try {
            guardar();
        } catch (SQLException ex) {
            Logger.getLogger(aviosGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtResorteActionPerformed

    private void txtTabtallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTabtallaActionPerformed
        try {
            guardar();
        } catch (SQLException ex) {
            Logger.getLogger(aviosGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtTabtallaActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'A' || c > 'Z') && (c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

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
            java.util.logging.Logger.getLogger(aviosGenerales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(aviosGenerales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(aviosGenerales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(aviosGenerales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new aviosGenerales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox almacenBox;
    private javax.swing.JToggleButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JToggleButton btnSalir;
    private javax.swing.JTextArea comentarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable tablaAviosGenerales;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCierre;
    private javax.swing.JTextField txtCorte;
    private javax.swing.JTextField txtDeslizador;
    private javax.swing.JTextField txtFus;
    private javax.swing.JTextField txtHilo;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtMonach;
    private javax.swing.JTextField txtPiel;
    private javax.swing.JTextField txtResorte;
    private javax.swing.JTextField txtTabtalla;
    private javax.swing.JTextField txtTabtam;
    private javax.swing.JTextField txtTalla;
    // End of variables declaration//GEN-END:variables
}
