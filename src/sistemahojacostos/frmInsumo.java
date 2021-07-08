package sistemahojacostos;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrador
 */
public class frmInsumo extends javax.swing.JFrame {

    Unidades unidad = new Unidades();
    DefaultComboBoxModel modeloTipo = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloUnidad = new DefaultComboBoxModel();
    frmHoja ir = new frmHoja();
    ResultSet rstUnidad = null;
    ResultSet rstTipo = null;
    ResultSet rstInsumo = null;
    Unidades unida = new Unidades();
    Tipos tip = new Tipos();
    Insumos insu = new Insumos();
    FrmMensajes mandar = new FrmMensajes();
    int xx, xy;

    /**
     * Creates new form frmUnidad
     */
    public frmInsumo() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/iconos/imageTodo.png")).getImage());
        setLocation(380, 200);
        llenarCmbs();
        maximoCodigo();
    }

    public void llenarCmbs() {
        modeloUnidad.removeAllElements();
        modeloTipo.removeAllElements();
        rstUnidad = unidad.llenarUnidades();
        rstTipo = tip.llenarTipos();
        try {
            while (rstUnidad.next()) {
                modeloUnidad.addElement(rstUnidad.getString("descripcion"));
            }
            cmbUnidad.setModel(modeloUnidad);

            while (rstTipo.next()) {
                modeloTipo.addElement(rstTipo.getString("descripcion"));
            }
            cmbTipo.setModel(modeloTipo);

            cmbTipo.setSelectedIndex(-1);
            cmbUnidad.setSelectedIndex(-1);
        } catch (SQLException ex) {

        }
    }

    public String buscarUnidad(String descripcion) {
        String salida = "";
        rstUnidad = unida.EncontrarCod(descripcion);
        try {
            while (rstUnidad.next()) {
                salida = rstUnidad.getString("unidad");
            }

        } catch (SQLException ex) {

        }

        return salida;
    }

    public String buscarTipo(String descripcion) {
        String salida = "";
        rstTipo = tip.EncontrarTipo(descripcion);
        try {
            while (rstTipo.next()) {
                salida = rstTipo.getString("tipo");
            }
        } catch (SQLException ex) {

        }

        return salida;
    }

    public String maximoCodigo() {
        String salida = "";
        int cantidad, mayor = 0;
        rstInsumo = insu.contarRegistros();
        try {
            while (rstInsumo.next()) {
                cantidad = rstInsumo.getInt(1);
                if (cantidad != 0) {
                    rstInsumo = null;
                    rstInsumo = insu.mayorRegistro();
                    while (rstInsumo.next()) {
                        mayor = rstInsumo.getInt(1) + 1;
                    }
                    lblID.setText(String.valueOf(mayor));
                    salida = lblID.getText();
                } else {
                    lblDescripcion.setText("1");
                    salida = lblID.getText();
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "AVISO DEL SISTEMA", 0);
        }
        return salida;
    }

    public void limpiar() {
        txtDescripcion.setText("");
        txtPrecio.setText("");
        cmbTipo.setSelectedIndex(-1);
        cmbUnidad.setSelectedIndex(-1);
        lblID.setText("");
        lblID.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        lblDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        lblPrecioUnitario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbUnidad = new javax.swing.JComboBox<>();
        cmbTipo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setBackground(new java.awt.Color(229, 229, 229));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Untitled (7).png"))); // NOI18N
        btnGuardar.setBorder(null);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, -1, -1));

        lblDescripcion.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        lblDescripcion.setText("Descripción :");
        jPanel2.add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 100, -1));

        txtDescripcion.setBackground(new java.awt.Color(229, 229, 229));
        txtDescripcion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtDescripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 250, 30));

        txtPrecio.setBackground(new java.awt.Color(229, 229, 229));
        txtPrecio.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtPrecio.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        jPanel2.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 140, 30));

        lblPrecioUnitario.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblPrecioUnitario.setForeground(new java.awt.Color(0, 0, 0));
        lblPrecioUnitario.setText("Precio Unitario :");
        jPanel2.add(lblPrecioUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 120, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Tipo :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 115, -1, 30));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Unidad :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 115, 70, 30));

        cmbUnidad.setBackground(new java.awt.Color(229, 229, 229));
        cmbUnidad.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(cmbUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 115, 200, 30));

        cmbTipo.setBackground(new java.awt.Color(229, 229, 229));
        cmbTipo.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(cmbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 115, 150, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/4115230-cancel-close-cross-delete_114048.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 510, 10));

        lblID.setForeground(new java.awt.Color(229, 229, 229));
        jPanel2.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 40, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/frmSecundario2.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel2MouseDragged(evt);
            }
        });
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 300));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 300));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/4115230-cancel-close-cross-delete_114048.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtPrecio.getText().isEmpty() || txtDescripcion.getText().isEmpty() || cmbUnidad.getSelectedIndex() == -1 || cmbTipo.getSelectedIndex() == -1) {
            mandar.setVisible(true);
            mandar.queMensaje(6);
            mandar.mandarMensaje();
        } else {
            insu.insertar(Integer.parseInt(maximoCodigo()), txtDescripcion.getText(), buscarTipo(cmbTipo.getSelectedItem().toString()),
                    buscarUnidad(cmbUnidad.getSelectedItem().toString()), txtPrecio.getText());
            limpiar();
            mandar.setVisible(true);
            mandar.queMensaje(14);
            mandar.mandarMensaje();
            ir.llenarDetalleHoja();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jLabel2MouseDragged

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        dispose();

    }//GEN-LAST:event_jLabel6MouseClicked

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

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
            java.util.logging.Logger.getLogger(frmInsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInsumo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JComboBox<String> cmbUnidad;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblPrecioUnitario;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
