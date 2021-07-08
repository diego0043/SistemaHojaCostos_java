/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemahojacostos;

import javax.swing.SwingConstants;

/**
 *
 * @author Diego
 */
public class FrmMensajes extends javax.swing.JFrame {

    int codMensaje = 0;

    /**
     * Creates new form FrmMensajes
     */
    public FrmMensajes() {
        initComponents();
        lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
        setLocation(400, 200);
    }

    public int queMensaje(int codMensajee) {
        codMensaje = codMensajee;
        return codMensaje;
    }

    public void mandarMensaje() {
        switch (codMensaje) {
            case 0:

                break;
            case 1:
                lblMensaje.setText("No se encontro la hoja");
                break;
            case 2:
                lblMensaje.setText("No ha escrito ningun codigo de hoja valido");
                break;
            case 3:
                lblMensaje.setText("No hay ningun registro seleccionado");
                break;
            case 4:
                lblMensaje.setText("Ya se le asigno codigo");
                break;
            case 5:
                lblMensaje.setText("Hoja registrada exitosamente");
                break;
            case 6:
                lblMensaje.setText("Falta completar algunos campos");
                break;
            case 7:
                lblMensaje.setText("Se actualizo la hoja exitosamente");
                break;
            case 8:
                lblMensaje.setText("Este insumo ya fue agregado anteriormente a la hoja");
                break;
            case 9:
                lblMensaje.setText("Falta ingresar la cantidad");
                break;
            case 10:
                lblMensaje.setText("No ha seleccionado ningun insumo en la tabla");
                break;
            case 11:
                lblMensaje.setText("Insumo eliminado exitosamente");
                break;
            case 12:
                lblMensaje.setText("Esta unidad de medida ya existe");
                break;
            case 13:
                lblMensaje.setText("Se agrego la unidad de medida exitosamente");
                break;
            case 14:
                lblMensaje.setText("Se agrego el insumo exitosamente");
                break;
            default:
                throw new AssertionError();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(229, 229, 229));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Aceptar.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        lblMensaje.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 380, 30));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/frmSecundarios.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMensajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMensajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMensajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMensajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMensajes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblMensaje;
    // End of variables declaration//GEN-END:variables
}
