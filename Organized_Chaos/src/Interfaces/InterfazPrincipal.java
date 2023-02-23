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
        this.grafoWarehouse = new Grafo();
    }
    
    public void cargarArchivo(Grafo grafoWarehouse){
        JFileChooser archivo = new JFileChooser();
        archivo.showOpenDialog(archivo);
        File file = archivo.getSelectedFile();
        String almacenes_txt = "";
        if (!grafoWarehouse.esVacio()) {
            almacenes_txt += "Almacenes;\n";
            
            Nodo<Vertice> aux = grafoWarehouse.getListaPrincipal().getpFirst();
            for (int i = 0; i < grafoWarehouse.getListaPrincipal().getSize(); i++) {
                almacenes_txt += "Almacen " + aux.getElemento().getNombre() + ":\n";
                Nodo<Producto> aux2 = aux.getElemento().getListaDeProdutcos().getpFirst();
                for (int j = 0; j < aux.getElemento().getListaDeProdutcos().getSize(); j++) {
                    almacenes_txt += aux2.getElemento().getNombre() + "," + aux2.getElemento().getStock() + "\n";
                    aux2 = aux2.getpNext();
                }
                aux = aux.getpNext();
            }
            
            almacenes_txt += "Rutas;\n";
            Nodo<Vertice> aux3 = grafoWarehouse.getListaPrincipal().getpFirst();
            for (int i = 0; i < grafoWarehouse.getListaPrincipal().getSize(); i++) {
                Nodo<Arco> aux4 = aux3.getElemento().getListaDeAdyacencia().getpFirst();
                for (int j = 0; j < aux3.getElemento().getListaDeAdyacencia().getSize(); j++) {
                    almacenes_txt += aux4.getElemento().getVerticeOrigenNombre() + "," + aux4.getElemento().getVerticeDestinoNombre() + "," + aux4.getElemento().getDistancia() + "\n";
                    aux4 = aux4.getpNext();
                }
                aux3 = aux3.getpNext();
            }
        }
        try {
            PrintWriter pw = new PrintWriter(file);
            pw.print(almacenes_txt);
            pw.close();;
            JOptionPane.showMessageDialog(null, "GUARDADO EXITOSO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LEER ARCHIVO. \nTipo de error: " + e);
        }
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
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LEER ARCHIVO. \nTipo de error: " + e);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));

        CargarArchivoButton.setText("CARGAR ARCHIVO");
        CargarArchivoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarArchivoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(CargarArchivoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel1.setText("BIENVENIDO PA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CargarArchivoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarArchivoButtonActionPerformed
        // TODO add your handling code here:
        this.text = this.leerArchivo();
        InterfazMenu initEstacion = new InterfazMenu(grafoWarehouse);
        this.setVisible(false);
        initEstacion.setVisible(true);    
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the grafoWarehouse
     */
    public static Grafo getGrafoWarehouse() {
        return grafoWarehouse;
    }
}
