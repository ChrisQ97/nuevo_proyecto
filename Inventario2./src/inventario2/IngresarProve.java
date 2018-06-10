/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario2;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sys515
 */
public class IngresarProve extends javax.swing.JFrame {
    
    Conexion con = new Conexion();
    Connection cn = con.conexion();
    Connection tr = con.conexion();

    /**
     * Creates new form IngresarProve
     */
    public IngresarProve() {
        initComponents();
        this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        this.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();    
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        Nombre.setText("");
                Nit.setText("");
                Direccion.setText("");
                Representante.setText("");
                Telefono.setText("");
                Correo.setText("");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        Representante = new javax.swing.JTextField();
        Nit = new javax.swing.JTextField();
        Direccion = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        Telefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Correo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(189, 189, 189));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 14, -1, -1));

        jLabel2.setText("Dirección");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 114, -1, -1));

        jLabel3.setText("Representante");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 51, -1, -1));

        jLabel4.setText("Nit");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 84, -1, -1));
        jPanel1.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 12, 180, -1));
        jPanel1.add(Representante, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 49, 180, -1));
        jPanel1.add(Nit, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 80, 106, -1));

        Direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DireccionActionPerformed(evt);
            }
        });
        jPanel1.add(Direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 112, 302, -1));

        jToggleButton1.setText("Agregar");
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 98, 38));

        jLabel5.setText("Telefono");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 82, -1, -1));

        Telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 80, 110, -1));

        jLabel6.setText("Correo");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));
        jPanel1.add(Correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 300, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DireccionActionPerformed
    private void CrearPro() {
        try {
            PreparedStatement CrearPro = cn.prepareStatement("INSERT INTO Proveedor(Nombre,Representante,Nit,Direccion,Numero,Correo) VALUES(?,?,?,?,?,?)");
            CrearPro.setString(1, Nombre.getText());
            CrearPro.setString(2, Representante.getText());
            CrearPro.setString(3, Nit.getText());
            CrearPro.setString(4, Direccion.getText());
            CrearPro.setString(5, Telefono.getText());
            CrearPro.setString(6, Correo.getText());
            CrearPro.executeUpdate();
            CrearPro.close();
            JOptionPane.showMessageDialog(null, "Nuevo Proveedor Agregado");

        } catch (SQLException ex) {
            Logger.getLogger(IngresarProve.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked
        if(Nombre.getText().equals("")||Representante.getText().equals("")||Nit.getText().equals("")
                ||Telefono.getText().equals("")||Direccion.getText().equals("")||Correo.getText().equals(""))
        {
           JOptionPane.showMessageDialog(null, "Revise que todos los campos esten llenos");

        }
        else {
        try {
            Statement st = cn.createStatement();
            ResultSet rd = st.executeQuery("SELECT Nit FROM Proveedor WHERE Nit ='" + Nit.getText() + "'");
            int CR = 0;
            while (rd.next()) {
                CR++;
            }

            if (CR == 0) {

                CrearPro();
                Nombre.setText("");
                Nit.setText("");
                Direccion.setText("");
                Representante.setText("");
                Telefono.setText("");
                Correo.setText("");

            } else {
                JOptionPane.showMessageDialog(null, "Usted ya tiene Registrado el Nit " + Nit.getText());
                Nombre.setText("");
                Nit.setText("");
                Direccion.setText("");
                Representante.setText("");
                Telefono.setText("");
                Correo.setText("");


            }
        } catch (SQLException ex) {
            Logger.getLogger(IngresarProve.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
        }

    }//GEN-LAST:event_jToggleButton1MouseClicked

    private void TelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelefonoKeyTyped
         int k = (int) evt.getKeyChar();
        if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "No puede ingresar letras!!!", "Ventana Error Datos", JOptionPane.ERROR_MESSAGE);
        }
        if (k == 241 || k == 209) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "No puede ingresar letras!!!", "Ventana Error Datos", JOptionPane.ERROR_MESSAGE);
        }
        if (k >= 33 && k <=47 ) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "No puede ingresar Simbolos!!!", "Ventana Error Datos", JOptionPane.ERROR_MESSAGE);
        }
        if (k == 10) {
            Telefono.transferFocus();
        }
    }//GEN-LAST:event_TelefonoKeyTyped

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(IngresarProve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarProve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarProve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarProve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresarProve().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Correo;
    private javax.swing.JTextField Direccion;
    private javax.swing.JTextField Nit;
    private javax.swing.JTextField Nombre;
    private javax.swing.JTextField Representante;
    private javax.swing.JTextField Telefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
