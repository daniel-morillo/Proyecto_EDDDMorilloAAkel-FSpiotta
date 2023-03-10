/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.Arco;
import EstructurasDeDatos.Grafo;
import javax.swing.JOptionPane;

/**
 * Esta interfaz tiene la función de agregar arcos dentro del grafo
 * @author Fabrizio Spiotta, Georgina Akel, Daniel Morillo
 */
public class InterfazAgregarArco extends javax.swing.JFrame {
    
    static Grafo grafoWarehouse;
    /**
     * Crea la interfaz
     * @param grafoWarehouse el grafo 
     */
    public InterfazAgregarArco(Grafo grafoWarehouse) {
        this.grafoWarehouse = grafoWarehouse;
                
        initComponents();
        this.setLocationRelativeTo(null);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TextAreaDistancia = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextAreaVerticeOrigen = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        TextAreaVerticeDestino = new javax.swing.JTextArea();
        AgregarArcoButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        MenuButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setText("Para insertar un camino nuevo, debe ingresar el almacen al que le agregara el dicho camino");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setText("Asi mismo, debe ingresar tambien el peso del camino para que se pueda registrar en el sistema");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        TextAreaDistancia.setBackground(new java.awt.Color(204, 204, 204));
        TextAreaDistancia.setColumns(20);
        TextAreaDistancia.setRows(5);
        jScrollPane1.setViewportView(TextAreaDistancia);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, 130, -1));

        TextAreaVerticeOrigen.setBackground(new java.awt.Color(204, 204, 204));
        TextAreaVerticeOrigen.setColumns(20);
        TextAreaVerticeOrigen.setRows(5);
        jScrollPane2.setViewportView(TextAreaVerticeOrigen);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 140, -1));

        TextAreaVerticeDestino.setBackground(new java.awt.Color(204, 204, 204));
        TextAreaVerticeDestino.setColumns(20);
        TextAreaVerticeDestino.setRows(5);
        jScrollPane3.setViewportView(TextAreaVerticeDestino);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 130, -1));

        AgregarArcoButton.setBackground(new java.awt.Color(204, 204, 204));
        AgregarArcoButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        AgregarArcoButton.setText("AGREGAR ARCO");
        AgregarArcoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarArcoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(AgregarArcoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setText("INGRESE PESO DEL CAMINO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setText("INGRESE ALMACEN ORIGEN");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setText("INGRESE ALMACEN DESTINO");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));

        MenuButton.setBackground(new java.awt.Color(255, 153, 0));
        MenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MENU.png"))); // NOI18N
        MenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuButtonActionPerformed(evt);
            }
        });
        getContentPane().add(MenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 520, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/4.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        InterfazMenu menu = new InterfazMenu(grafoWarehouse);
        menu.setVisible(true);
    }//GEN-LAST:event_MenuButtonActionPerformed
    /**
     * Recoge la información de los text area y crea el nuevo arco
     * @param evt 
     */
    private void AgregarArcoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarArcoButtonActionPerformed
        // TODO add your handling code here:
        if ("".equals(TextAreaVerticeOrigen.getText()) || "".equals(TextAreaVerticeDestino.getText()) || "".equals(TextAreaDistancia.getText())) {
            JOptionPane.showMessageDialog(null, "ERROR! Los tres campos deben estar llenos");
        } 
        else if (grafoWarehouse.encontrarAlmacenNombre(TextAreaVerticeDestino.getText()) == false || grafoWarehouse.encontrarAlmacenNombre(TextAreaVerticeOrigen.getText()) == false) {
            JOptionPane.showMessageDialog(null, "ERROR! No se encontraron dichos almacenes en el grafo");
        }
        else {
            try{
                Arco newArco = new Arco(TextAreaVerticeOrigen.getText(), TextAreaVerticeDestino.getText(), Integer.parseInt(TextAreaDistancia.getText()));
                grafoWarehouse.insertarArco(newArco);
                JOptionPane.showMessageDialog(null, "ARCO INSERTADO CON EXITO!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR DESCONOCIDO!. \nTipo de error: " + e);
            }
        }
    }//GEN-LAST:event_AgregarArcoButtonActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazAgregarArco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazAgregarArco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazAgregarArco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazAgregarArco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazAgregarArco(grafoWarehouse).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarArcoButton;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton MenuButton;
    private javax.swing.JTextArea TextAreaDistancia;
    private javax.swing.JTextArea TextAreaVerticeDestino;
    private javax.swing.JTextArea TextAreaVerticeOrigen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
