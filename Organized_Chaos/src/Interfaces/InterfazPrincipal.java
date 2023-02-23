/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import EstructurasDeDatos.Grafo;
import EstructurasDeDatos.Nodo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Clases.Arco;
import Clases.Producto;
import Clases.Vertice;

/**
 *
 * @author danielmorillo
 */

public class InterfazPrincipal extends javax.swing.JFrame {
    
    static String text;
    private static Grafo grafoWarehouse;
    /**
     * Creates new form InterfazPrincipal
     */
    public InterfazPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.grafoWarehouse = new Grafo();
    }
        
    public String leerArchivo(){
        JFileChooser archivo = new JFileChooser();
        archivo.showOpenDialog(archivo);
        File file = archivo.getSelectedFile();
        String line;
        String texto = "";

        try { 
            if (!file.exists()){
                file.createNewFile();
            } else {               
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                
                while((line = br.readLine()) != null){
                    if (!line.isEmpty()) {
                        texto += line + "\n";
                    }
                    
                }
                
                if (!"".equals(texto)) {
                    String [] textoSeparado = texto.split(";");
                    for (int i = 1; i < textoSeparado.length -1; i++) {
                        if (!textoSeparado[i].equalsIgnoreCase("\nRutas")) {
                            String [] almacenesSeparados = textoSeparado[i].split(":");
                            for (int j = 0; j < almacenesSeparados.length; j++) {
                                if (almacenesSeparados[j].contains("Almacen")) {
                                    String [] nombreAlmacenLetra = almacenesSeparados[j].split(" ");
                                    char letra = nombreAlmacenLetra[1].charAt(0);
                                    int numeroLetra = letra - 65;
                                    Vertice newVertice = new  Vertice(nombreAlmacenLetra[1], numeroLetra);
                                    getGrafoWarehouse().insertarVertice(newVertice);
                                } else {
                                    String [] arrayProducts = almacenesSeparados[j].split("\n");
                                    for (int k = 1; k < arrayProducts.length ; k++) {
                                        String [] miniArrayProduct = arrayProducts[k].split(",");
                                        Producto newProduct = new Producto(miniArrayProduct[0], Integer.parseInt(miniArrayProduct[1]));
                                        Vertice Warehouse = (Vertice) getGrafoWarehouse().getListaPrincipal().getpLast().getElemento();
                                        Warehouse.getListaDeProdutcos().AppendAtTheEnd(newProduct);
                                    }
                                }
                            }
                        } else {
                            String[] arrayArcos = textoSeparado[i+1].split("\n");
                            for (int j = 1; j < arrayArcos.length; j++) {
                                String[] miniArrayArco = arrayArcos[j].split(",");
                                Arco newArco = new Arco(miniArrayArco[0], miniArrayArco[1], Integer.parseInt(miniArrayArco[2]));
                                Nodo<Vertice> aux = getGrafoWarehouse().getListaPrincipal().getpFirst();
                                for (int k = 0; k < getGrafoWarehouse().getListaPrincipal().getSize(); k++) {
                                    if (aux.getElemento().getNombre().equalsIgnoreCase(newArco.getVerticeOrigenNombre())) {
                                        aux.getElemento().getListaDeAdyacencia().AppendAtTheEnd(newArco);
                                    }
                                    aux = aux.getpNext();
                                }
                            }
                        }
                    }   
                }
                br.close();
                JOptionPane.showMessageDialog(null, "LECTURA COMPLETADA");
                InterfazMenu initEstacion = new InterfazMenu(grafoWarehouse);
                this.setVisible(false);
                initEstacion.setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO SELECCIONO NINGUN ARCHIVO O NO SE PUDO LEER PROPORCIONADO");
        } return texto;
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
        CargarArchivoButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));

        CargarArchivoButton.setBackground(new java.awt.Color(255, 153, 51));
        CargarArchivoButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        CargarArchivoButton.setText("CARGAR ARCHIVO");
        CargarArchivoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CargarArchivoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarArchivoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(CargarArchivoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, -1, -1));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setText("¡Bienvenido Usuario!");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setText("Esta es la interfaz que contiene todos los");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 360, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setText("Para poder utilizarla a continuación debes cargar el archivo txt ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setText("que contiene toda la información de nuestros productos y almacenes");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Flecha.png"))); // NOI18N
        jLabel5.setText("--->");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 50, 60));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel6.setText("requerimientos funcionales de Amazon");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, -1, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel7.setText("--------------------------------------------------------------");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        Fondo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo amazon.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CargarArchivoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarArchivoButtonActionPerformed
        // TODO add your handling code here:
        InterfazPrincipal.text = this.leerArchivo(); 
    }//GEN-LAST:event_CargarArchivoButtonActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CargarArchivoButton;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the grafoWarehouse
     */
    public static Grafo getGrafoWarehouse() {
        return grafoWarehouse;
    }
}
