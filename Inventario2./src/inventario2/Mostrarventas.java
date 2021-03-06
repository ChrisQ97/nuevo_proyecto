/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario2;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author chr97lubuntu
 */
public class Mostrarventas extends javax.swing.JFrame {
 Conexion con = new Conexion();
   private int mes=0,dia=0,año=0,dia2=0,año2=0,mes2=0;
    Connection Consulta = con.conexion();
 DefaultTableModel modeloBusqueda = new DefaultTableModel() {
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            };
    /**
     * Creates new form Mostrarventas
     */
    public Mostrarventas() {
        initComponents();
        this.setDefaultCloseOperation(this.HIDE_ON_CLOSE); 
        Todo.setSelected(true);
         modeloBusqueda.addColumn("Codigo");
            modeloBusqueda.addColumn("Producto");
            modeloBusqueda.addColumn("Marca");
            modeloBusqueda.addColumn("Fecha");
            modeloBusqueda.addColumn("No. Lote");
            modeloBusqueda.addColumn("Serie");
            modeloBusqueda.addColumn("Número");
            modeloBusqueda.addColumn("Nit");
            modeloBusqueda.addColumn("Cliente");
            modeloBusqueda.addColumn("Cantidad");
            modeloBusqueda.addColumn("Unidad");
            modeloBusqueda.addColumn("Precio Unitario");
            modeloBusqueda.addColumn("Total");
            
            rSTableMetro1.setModel(modeloBusqueda);

            String datos[] = new String[13];

          try {

            Statement sx = Consulta.createStatement();
            ResultSet Ca = sx.executeQuery("SELECT P.Codigo,P.Nombre,P.Marca,L.Fecha,L.NoLote,F.Serie,F.Numero,C.Nit,C.NombreC,C.Apellido,L.Cantidad,P.Medida,L.PrecioUnitario,L.PrecioTotal FROM Cliente C inner JOIN FacturaVenta F on C.id=F.Cliente_id inner JOIN LoteVenta L on L.FacturaVenta_id=F.id inner JOIN Producto P on P.id=L.Producto_id Order by L.Fecha");
          
            while (Ca.next()) {
               
                datos[0] = Ca.getString(1);
                datos[1] = Ca.getString(2);
                datos[2] = Ca.getString(3);
                datos[3] = Ca.getString(4);
                datos[4] = Ca.getString(5);
                datos[5] = Ca.getString(6);
                datos[6] = Ca.getString(7);
                datos[7] = Ca.getString(8);
                datos[8] = Ca.getString(9)+" "+Ca.getString(10); 
                datos[9] = Ca.getString(11);    
                datos[10] = Ca.getString(12);
                datos[11] = Ca.getString(13);
                datos[12] = Ca.getString(14);
                modeloBusqueda.addRow(datos);
                
            }
            rSTableMetro1.setModel(modeloBusqueda);
            
        } catch (SQLException ex) {
            Logger.getLogger(Ingreso.class.getName()).log(Level.SEVERE, null, ex);
        }
        rSTableMetro1.setSize(1000, 1000);
        rSTableMetro1.setVisible(true);
        rSTableMetro1.getColumn("No. Lote").setPreferredWidth(65);
        rSTableMetro1.getColumn("Codigo").setPreferredWidth(50);
        rSTableMetro1.getColumn("Serie").setPreferredWidth(45);
        rSTableMetro1.getColumn("Número").setPreferredWidth(65);
        rSTableMetro1.getColumn("Fecha").setPreferredWidth(90);
        rSTableMetro1.getColumn("Cliente").setPreferredWidth(90);
    rSTableMetro1.getColumn("Precio Unitario").setPreferredWidth(110);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        rSTableMetro1 = new rojerusan.RSTableMetro();
        Inicio = new com.toedter.calendar.JDateChooser();
        Inicio2 = new javax.swing.JLabel();
        Final2 = new javax.swing.JLabel();
        Final = new com.toedter.calendar.JDateChooser();
        Todo = new javax.swing.JRadioButton();
        Buscador = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        P = new javax.swing.JRadioButton();
        P2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(17, 111, 172));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSTableMetro1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        rSTableMetro1.setFuenteHead(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jScrollPane2.setViewportView(rSTableMetro1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 980, 380));
        jPanel1.add(Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 139, -1));

        Inicio2.setForeground(new java.awt.Color(255, 255, 255));
        Inicio2.setText("Inicio");
        jPanel1.add(Inicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        Final2.setForeground(new java.awt.Color(255, 255, 255));
        Final2.setText("Final");
        jPanel1.add(Final2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, -1));
        jPanel1.add(Final, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 134, -1));

        Todo.setForeground(new java.awt.Color(255, 255, 255));
        Todo.setText("Todo");
        Todo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TodoActionPerformed(evt);
            }
        });
        jPanel1.add(Todo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, -1));

        Buscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscadorActionPerformed(evt);
            }
        });
        jPanel1.add(Buscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 147, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconoso/icons8-multiedición-50.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconoso/icons8-multiedición-filled-50.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 70, -1));

        P.setForeground(new java.awt.Color(255, 255, 255));
        P.setText("Cliente");
        P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PActionPerformed(evt);
            }
        });
        jPanel1.add(P, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

        P2.setForeground(new java.awt.Color(255, 255, 255));
        P2.setText("Producto");
        P2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P2ActionPerformed(evt);
            }
        });
        jPanel1.add(P2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Generar reporte");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 50, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1001, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PActionPerformed
        try
        {
            año = Inicio.getCalendar().get(Calendar.YEAR);
            mes = Inicio.getCalendar().get(Calendar.MONTH) + 1;
            dia = Inicio.getCalendar().get(Calendar.DAY_OF_MONTH);
            año2 = Final.getCalendar().get(Calendar.YEAR);
            mes2= Final.getCalendar().get(Calendar.MONTH) + 1;
            dia2 = Final.getCalendar().get(Calendar.DAY_OF_MONTH);
        }

        catch(NullPointerException ex) {
            P.setSelected(false);

        }
        P2.setSelected(false);
            Todo.setSelected(false);
        
        if(año==0||dia==0||mes==00||año2==0||dia2==0||mes2==00)
        {
            JOptionPane.showMessageDialog(this, "Al menos selecciona una fecha válida!", "Error!", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            Buscador.removeAllItems();
            P2.setSelected(false);
            try {

                Statement sx = Consulta.createStatement();
                ResultSet Ca = sx.executeQuery("SELECT Nit FROM Cliente");
                while (Ca.next()) {

                    Buscador.addItem(Ca.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_PActionPerformed

    private void BuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscadorActionPerformed
        try
        {
            año = Inicio.getCalendar().get(Calendar.YEAR);
            mes = Inicio.getCalendar().get(Calendar.MONTH) + 1;
            dia = Inicio.getCalendar().get(Calendar.DAY_OF_MONTH);
            año2 = Final.getCalendar().get(Calendar.YEAR);
            mes2= Final.getCalendar().get(Calendar.MONTH) + 1;
            dia2 = Final.getCalendar().get(Calendar.DAY_OF_MONTH);
        }

        catch(NullPointerException ex) {
        }
        if(año==0||dia==0||mes==00||año2==0||dia2==0||mes2==00)
        {
            JOptionPane.showMessageDialog(this, "Al menos selecciona una fecha válida!", "Error!", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {

            String Completo = (String) Buscador.getSelectedItem();
            if(P.isSelected())
            {
                Llenar(Completo);
            }
            if(P2.isSelected())
            {
                llenar2(Completo);
            }
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscadorActionPerformed

    private void llenar2(String B)
    {
          modeloBusqueda.setRowCount(0);
        String datos[]=new String[13];
         try {

            Statement sx = Consulta.createStatement();
            ResultSet Ca = sx.executeQuery("SELECT P.Codigo,P.Nombre,P.Marca,L.Fecha,L.NoLote,F.Serie,F.Numero,C.Nit,C.NombreC,C.Apellido,L.Cantidad,P.Medida,L.PrecioUnitario,L.PrecioTotal\n" +

"FROM Producto P \n" +
"inner JOIN LoteVenta L \n" +   
"on P.id=L.Producto_id \n" +
"inner JOIN FacturaVenta F \n" +
"on F.id=L.FacturaVenta_id \n" +
"inner JOIN Cliente C \n" +
"on C.id=F.Cliente_id where P.Codigo='"+B+"'&& L.Fecha BETWEEN '"+año+"-"+mes+"-"+dia+"' AND '"+año2+"-"+mes2+"-"+dia2+"'");          
            while (Ca.next()) {
               
                datos[0] = Ca.getString(1);
                datos[1] = Ca.getString(2);
                datos[2] = Ca.getString(3);
                datos[3] = Ca.getString(4);
                datos[4] = Ca.getString(5);
                datos[5] = Ca.getString(6);
                datos[6] = Ca.getString(7);
                datos[7] = Ca.getString(8);
                datos[8] = Ca.getString(9)+" "+Ca.getString(10); 
                datos[9] = Ca.getString(11);    
                datos[10] = Ca.getString(12);
                datos[11] = Ca.getString(13);
                datos[12] = Ca.getString(14);
               
                modeloBusqueda.addRow(datos);
                
            }
            rSTableMetro1.setModel(modeloBusqueda);
            
        } catch (SQLException ex) {
            Logger.getLogger(Ingreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void Llenar(String B)
    {
        modeloBusqueda.setRowCount(0);
        String datos[]=new String[13];
         try {

            Statement sx = Consulta.createStatement();
            ResultSet Ca = sx.executeQuery("Select P.Codigo,P.Nombre,P.Marca,L.Fecha,L.NoLote,F.Serie,F.Numero,C.Nit,C.NombreC,C.Apellido,L.Cantidad,P.Medida,L.PrecioUnitario,L.PrecioTotal\n" +
"FROM Producto P \n" +
"inner JOIN LoteVenta L \n" +
"on P.id=L.Producto_id \n" +
"inner JOIN FacturaVenta F\n" +
"on F.id=L.FacturaVenta_id \n" +
"inner JOIN Cliente C \n" +
"on C.id=F.Cliente_id where nit="+B+" && L.Fecha BETWEEN '"+año+"-"+mes+"-"+dia+"' AND '"+año2+"-"+mes2+"-"+dia2+"';");          
            while (Ca.next()) {
               
              datos[0] = Ca.getString(1);
                datos[1] = Ca.getString(2);
                datos[2] = Ca.getString(3);
                datos[3] = Ca.getString(4);
                datos[4] = Ca.getString(5);
                datos[5] = Ca.getString(6);
                datos[6] = Ca.getString(7);
                datos[7] = Ca.getString(8);
                datos[8] = Ca.getString(9)+" "+Ca.getString(10); 
                datos[9] = Ca.getString(11);    
                datos[10] = Ca.getString(12);
                datos[11] = Ca.getString(13);
                datos[12] = Ca.getString(14);
                
               
                modeloBusqueda.addRow(datos);
                
            }
            rSTableMetro1.setModel(modeloBusqueda);
        } catch (SQLException ex) {
            Logger.getLogger(Ingreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void P2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P2ActionPerformed
        try
        {
            año = Inicio.getCalendar().get(Calendar.YEAR);
            mes = Inicio.getCalendar().get(Calendar.MONTH) + 1;
            dia = Inicio.getCalendar().get(Calendar.DAY_OF_MONTH);
            año2 = Final.getCalendar().get(Calendar.YEAR);
            mes2= Final.getCalendar().get(Calendar.MONTH) + 1;
            dia2 = Final.getCalendar().get(Calendar.DAY_OF_MONTH);
        }

        catch(NullPointerException ex) {
            P2.setSelected(false);
            
        }
        Todo.setSelected(false);
        P.setSelected(false);
        if(año==0||dia==0||mes==00||año2==0||dia2==0||mes2==00)
        {
            JOptionPane.showMessageDialog(this, "Al menos selecciona una fecha válida!", "Error!", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            Buscador.removeAllItems();
            P.setSelected(false);
            try {

                Statement sx = Consulta.createStatement();
                ResultSet Ca = sx.executeQuery("SELECT Codigo FROM Producto");
                while (Ca.next()) {

                    Buscador.addItem(Ca.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_P2ActionPerformed

    private void InformeProducto(String cod)
    {
                try {
                    
                  
            
            Date uno=new Date(año-1900,mes-1,dia);
            Date dos=new Date(año2-1900,mes2-1,dia2);
            Connection tr = con.conexion();
            JasperReport reporte= null;
            String path="/home/sys515/Documentos/ProyecoPEPS/Inventario2-master/Inventario2./src/Reportes/ventasProd.jasper";
            Map parametro =new HashMap();
            parametro.put("Fecha2",dos );
            parametro.put("Fecha1", uno);
            parametro.put("Codigo",cod);
            reporte= (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint =JasperFillManager.fillReport(reporte,parametro,tr);
            JasperViewer view = new JasperViewer(jprint,false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);

            // TODO add your handling code here:
        } catch (JRException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void InformeCliente(String Cod)
    {
                   try {
                    
                  
            
            Date uno=new Date(año-1900,mes-1,dia);
            Date dos=new Date(año2-1900,mes2-1,dia2);
            Connection tr = con.conexion();
            JasperReport reporte= null;
            String path="/home/sys515/Documentos/ProyecoPEPS/Inventario2-master/Inventario2./src/Reportes/ventaCl.jasper";
            Map parametro =new HashMap();
            parametro.put("Fecha2",dos );
            parametro.put("Fecha1", uno);
            parametro.put("Codigo",Cod);
            reporte= (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint =JasperFillManager.fillReport(reporte,parametro,tr);
            JasperViewer view = new JasperViewer(jprint,false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);

            // TODO add your handling code here:
        } catch (JRException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     private void Informe()
    {
                   try {
                    
                  
            Connection tr = con.conexion();
            JasperReport reporte= null;
            String path="/home/sys515/Documentos/ProyecoPEPS/Inventario2-master/Inventario2./src/Reportes/venta.jasper";
           
            reporte= (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint =JasperFillManager.fillReport(reporte,null,tr);
            JasperViewer view = new JasperViewer(jprint,false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);

            // TODO add your handling code here:
        } catch (JRException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(P2.isSelected())
        {
            InformeProducto((String)Buscador.getSelectedItem());
        }
        if(P.isSelected())
        {
            InformeCliente((String)Buscador.getSelectedItem());
        }
        if(Todo.isSelected())
        {
            Informe();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Menu xx=new Menu();
        xx.setVisible(true);
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void TodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TodoActionPerformed
                    P.setSelected(false);
            P2.setSelected(false);

        modeloBusqueda.setRowCount(0);

        String datos[] = new String[13];

          try {

            Statement sx = Consulta.createStatement();
            ResultSet Ca = sx.executeQuery("SELECT P.Codigo,P.Nombre,P.Marca,L.Fecha,L.NoLote,F.Serie,F.Numero,C.Nit,C.NombreC,C.Apellido,L.Cantidad,P.Medida,L.PrecioUnitario,L.PrecioTotal FROM Cliente C inner JOIN FacturaVenta F on C.id=F.Cliente_id inner JOIN LoteVenta L on L.FacturaVenta_id=F.id inner JOIN Producto P on P.id=L.Producto_id Order by L.Fecha");
          
            while (Ca.next()) {
               
                datos[0] = Ca.getString(1);
                datos[1] = Ca.getString(2);
                datos[2] = Ca.getString(3);
                datos[3] = Ca.getString(4);
                datos[4] = Ca.getString(5);
                datos[5] = Ca.getString(6);
                datos[6] = Ca.getString(7);
                datos[7] = Ca.getString(8);
                datos[8] = Ca.getString(9)+" "+Ca.getString(10); 
                datos[9] = Ca.getString(11);    
                datos[10] = Ca.getString(12);
                datos[11] = Ca.getString(13);
                datos[12] = Ca.getString(14);
                modeloBusqueda.addRow(datos);
                
            }
            rSTableMetro1.setModel(modeloBusqueda);
            
        } catch (SQLException ex) {
            Logger.getLogger(Ingreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TodoActionPerformed

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
            java.util.logging.Logger.getLogger(Mostrarventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mostrarventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mostrarventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mostrarventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mostrarventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Buscador;
    private com.toedter.calendar.JDateChooser Final;
    private javax.swing.JLabel Final2;
    private com.toedter.calendar.JDateChooser Inicio;
    private javax.swing.JLabel Inicio2;
    private javax.swing.JRadioButton P;
    private javax.swing.JRadioButton P2;
    private javax.swing.JRadioButton Todo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSTableMetro rSTableMetro1;
    // End of variables declaration//GEN-END:variables
}
