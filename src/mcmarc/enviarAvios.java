package mcmarc;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jaasiel Malagon
 */
public class enviarAvios extends javax.swing.JFrame {

    controlAlmacen ca = new controlAlmacen();
    String origen;
    public enviarAvios(String origen, String id_origen) throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        desactivar();
        lblOrigen.setText(origen);
        if ("Administrador".equals(origen) || "Superusuario".equals(origen)) {
            origenBox.setModel(ca.destinosComboBox());
            
        }else{
            origenBox.setVisible(false);
            this.origen = id_origen;
        }
        destinoBox.setModel(ca.destinosComboBox());
        System.err.println(origen);
        System.err.println(id_origen);
    }

    private void desactivar() {
        cantidadCierre.setText("0");
        cantidadCintaFus.setText("0");
        cantidadDeslizador.setText("0");
        cantidadEtMarca.setText("0");
        cantidadHilo.setText("0");
        cantidadMonach.setText("0");
        cantidadPiel.setText("0");
        cantidadResorte.setText("0");
        cantidadTabtalla.setText("0");
        cantidadTabtam.setText("0");
        cantidadTalla.setText("0");
    }

    private int[] variables() {
        int[] variables = new int[11];
        variables[0] = Integer.parseInt(cantidadCierre.getText());
        variables[1] = Integer.parseInt(cantidadCintaFus.getText());
        variables[2] = Integer.parseInt(cantidadDeslizador.getText());
        variables[3] = Integer.parseInt(cantidadEtMarca.getText());
        variables[4] = Integer.parseInt(cantidadHilo.getText());
        variables[5] = Integer.parseInt(cantidadMonach.getText());
        variables[6] = Integer.parseInt(cantidadPiel.getText());
        variables[7] = Integer.parseInt(cantidadResorte.getText());
        variables[8] = Integer.parseInt(cantidadTabtalla.getText());
        variables[9] = Integer.parseInt(cantidadTabtam.getText());
        variables[10] = Integer.parseInt(cantidadTalla.getText());
        //variables[11] = comentario.getText();
        return variables;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblOrigen = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        destinoBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cantidadCierre = new javax.swing.JTextField();
        cantidadDeslizador = new javax.swing.JTextField();
        cantidadEtMarca = new javax.swing.JTextField();
        cantidadMonach = new javax.swing.JTextField();
        cantidadTalla = new javax.swing.JTextField();
        cantidadPiel = new javax.swing.JTextField();
        cantidadTabtam = new javax.swing.JTextField();
        cantidadCintaFus = new javax.swing.JTextField();
        cantidadHilo = new javax.swing.JTextField();
        cantidadResorte = new javax.swing.JTextField();
        cantidadTabtalla = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        comentario = new javax.swing.JTextArea();
        btnSalir = new javax.swing.JToggleButton();
        btnCancelar = new javax.swing.JToggleButton();
        btnEnviar = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        txtCorte = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        origenBox = new javax.swing.JComboBox();

        jLabel14.setText("Resorte:");

        jLabel17.setText("Et. Tabtam:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Origen:");

        jLabel2.setText("Destino:");

        jLabel3.setText("Avios:");

        cantidadCierre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadCierreKeyTyped(evt);
            }
        });

        cantidadDeslizador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadDeslizadorKeyTyped(evt);
            }
        });

        cantidadEtMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadEtMarcaKeyTyped(evt);
            }
        });

        cantidadMonach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadMonachKeyTyped(evt);
            }
        });

        cantidadTalla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadTallaKeyTyped(evt);
            }
        });

        cantidadPiel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadPielKeyTyped(evt);
            }
        });

        cantidadTabtam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadTabtamKeyTyped(evt);
            }
        });

        cantidadCintaFus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadCintaFusKeyTyped(evt);
            }
        });

        cantidadHilo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadHiloKeyTyped(evt);
            }
        });

        cantidadResorte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cantidadResorteMouseClicked(evt);
            }
        });
        cantidadResorte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadResorteKeyTyped(evt);
            }
        });

        cantidadTabtalla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadTabtallaKeyTyped(evt);
            }
        });

        comentario.setColumns(20);
        comentario.setRows(1);
        comentario.setBorder(javax.swing.BorderFactory.createTitledBorder("Comentario:"));
        jScrollPane1.setViewportView(comentario);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/Back.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/Delete.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mcmarc/send.png"))); // NOI18N
        btnEnviar.setText("Enviar avios");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        jLabel4.setText("Corte:");

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

        jLabel6.setText("Cierre:");

        jLabel7.setText("Deslizador:");

        jLabel8.setText("Et. Marca");

        jLabel9.setText("Et. Monach");

        jLabel10.setText("Et. Talla");

        jLabel11.setText("Cinta FUS:");

        jLabel12.setText("Hilo:");

        jLabel13.setText("Resorte:");

        jLabel15.setText("Et. Piel:");

        jLabel16.setText("Et. Tabtam:");

        jLabel18.setText("Et. Tabtalla:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSalir)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEnviar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cantidadResorte, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cantidadPiel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cantidadTabtam, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(cantidadTabtalla, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cantidadCierre, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(cantidadDeslizador, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cantidadEtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(cantidadMonach, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cantidadTalla, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cantidadCintaFus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(cantidadHilo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCorte, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOrigen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(destinoBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 223, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(origenBox, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                        .addComponent(lblOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(origenBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destinoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(104, 104, 104)
                            .addComponent(cantidadTabtalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(78, 78, 78)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cantidadMonach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(11, 11, 11)
                                        .addComponent(cantidadCierre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cantidadDeslizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel12))
                                    .addGap(18, 18, 18)
                                    .addComponent(cantidadEtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cantidadTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cantidadHilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cantidadCintaFus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(jLabel18)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cantidadResorte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cantidadPiel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cantidadTabtam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnCancelar)
                    .addComponent(btnEnviar))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cantidadResorteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cantidadResorteMouseClicked

    }//GEN-LAST:event_cantidadResorteMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        desactivar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorteActionPerformed

    private void txtCorteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorteKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'A' || c > 'Z') && (c < '0' || c > '9')) {
            evt.consume();
            //JOptionPane.showMessageDialog(rootPane,"Solo pueden introducirse letras mayúsculas y números","Aviso",1);
        }
    }//GEN-LAST:event_txtCorteKeyTyped

    private void cantidadCierreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadCierreKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();            
        }
    }//GEN-LAST:event_cantidadCierreKeyTyped

    private void cantidadDeslizadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadDeslizadorKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();            
        }
    }//GEN-LAST:event_cantidadDeslizadorKeyTyped

    private void cantidadEtMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadEtMarcaKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();            
        }
    }//GEN-LAST:event_cantidadEtMarcaKeyTyped

    private void cantidadMonachKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadMonachKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();            
        }
    }//GEN-LAST:event_cantidadMonachKeyTyped

    private void cantidadTallaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadTallaKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();            
        }
    }//GEN-LAST:event_cantidadTallaKeyTyped

    private void cantidadCintaFusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadCintaFusKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();            
        }
    }//GEN-LAST:event_cantidadCintaFusKeyTyped

    private void cantidadHiloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadHiloKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();            
        }
    }//GEN-LAST:event_cantidadHiloKeyTyped

    private void cantidadResorteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadResorteKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();            
        }
    }//GEN-LAST:event_cantidadResorteKeyTyped

    private void cantidadPielKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadPielKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();            
        }
    }//GEN-LAST:event_cantidadPielKeyTyped

    private void cantidadTabtamKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadTabtamKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();            
        }
    }//GEN-LAST:event_cantidadTabtamKeyTyped

    private void cantidadTabtallaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadTabtallaKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();            
        }
    }//GEN-LAST:event_cantidadTabtallaKeyTyped

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        if (txtCorte.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Por favor complete todos los campos, en caso de no enviar ninguna pieza de \n dicho objeto complete el campo con un 0", "¡Campos vacíos!", 3);
        }else{
            try {
                origen = origenBox.getSelectedItem().toString();            
                int destino = ca.id_destino(destinoBox.getSelectedItem().toString());
                int origin = ca.id_destino(origen);
                System.out.println("El id del origen es: ");
                boolean enviar = ca.enviarAvios(txtCorte.getText(), origin, destino, variables()[0],variables()[2], variables()[3], variables()[5], variables()[10], variables()[1],
                        variables()[4], variables()[7], variables()[6], variables()[9], variables()[8], comentario.getText());
                if (enviar==true) {
                    JOptionPane.showMessageDialog(rootPane, "¡Envío exitoso a "+destinoBox.getSelectedItem().toString()+"!", "Enviado", 1);
                }else{
                    JOptionPane.showMessageDialog(rootPane, "¡El envío falló", "Error al enviar avios", 0);
                }
            } catch (SQLException ex) {
                Logger.getLogger(enviarAvios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

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
            java.util.logging.Logger.getLogger(enviarAvios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(enviarAvios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(enviarAvios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(enviarAvios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new enviarAvios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JToggleButton btnEnviar;
    private javax.swing.JToggleButton btnSalir;
    private javax.swing.JTextField cantidadCierre;
    private javax.swing.JTextField cantidadCintaFus;
    private javax.swing.JTextField cantidadDeslizador;
    private javax.swing.JTextField cantidadEtMarca;
    private javax.swing.JTextField cantidadHilo;
    private javax.swing.JTextField cantidadMonach;
    private javax.swing.JTextField cantidadPiel;
    private javax.swing.JTextField cantidadResorte;
    private javax.swing.JTextField cantidadTabtalla;
    private javax.swing.JTextField cantidadTabtam;
    private javax.swing.JTextField cantidadTalla;
    private javax.swing.JTextArea comentario;
    private javax.swing.JComboBox destinoBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblOrigen;
    private javax.swing.JComboBox origenBox;
    private javax.swing.JTextField txtCorte;
    // End of variables declaration//GEN-END:variables
}
