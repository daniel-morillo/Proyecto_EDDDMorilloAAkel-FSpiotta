/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.Arco;
import Clases.Producto;
import Clases.Vertice;
import EstructurasDeDatos.Grafo;
import EstructurasDeDatos.Nodo;
import java.io.File;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

/**
 * Es el menú que permite navegar hacia las otras ventanas
 * @author Fabrizio Spiotta, Georgina Akel, Daniel Morillo
 */
public class InterfazMenu extends javax.swing.JFrame {
    
    static Grafo grafoWarehouse;
    /**
     * Creates new form InterfazEstacion
     * @param grafoWarehouse
     */
    public InterfazMenu(Grafo grafoWarehouse) {
        this.grafoWarehouse = grafoWarehouse;
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    /**
     * Actualiza el archivo seleccionado por el usuario y lo sobreescribe con la información resultante de la corrida del programa
     * @param grafoWarehouse el grafo
     */
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
                    if (j == aux.getElemento().getListaDeProdutcos().getSize() - 1) {
                        almacenes_txt += aux2.getElemento().getNombre() + "," + aux2.getElemento().getStock() + ";\n";
                    } else {
                        almacenes_txt += aux2.getElemento().getNombre() + "," + aux2.getElemento().getStock() + "\n";
                    }
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
            JOptionPane.showMessageDialog(null, "NO SELECCIONO NINGUN ARCHIVO O NO SE PUDO CARGAR EL ARCHIVO");
        }
    }
    
    
    /**
     * Crea el grafo, para mostrarlo, mediante la libreria de GraphStream
     * 
     */
    public void CrearGraphStream() {
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("Warehouses");
        graph.setAttribute("ui.stylesheet", " graph {fill-color: #EEE; padding: 50px; } node {fill-color: orange; size: 95px, 95px;  icon: url('imagenes//Grafo2.png'); icon-mode: at-left; size-mode: dyn-size; shape: rounded-box; stroke-mode: plain; stroke-color: black; stroke-width: 2px; text-alignment: center; text-color: white; text-style: bold; text-size: 20;} edge {stroke-mode: plain; stroke-color: black; size: 1px; arrow-shape: arrow; arrow-size: 12; text-alignment: above; text-color: orange; text-style: bold; text-size: 50; text-padding: 20;}");                                                              
        Nodo<Vertice> aux = grafoWarehouse.getListaPrincipal().getpFirst();
        for (int i = 0; i < grafoWarehouse.getListaPrincipal().getSize(); i++) {
            graph.addNode(aux.getElemento().getNombre());
            graph.getNode(aux.getElemento().getNombre()).setAttribute("ui.label", "Almacen " + aux.getElemento().getNombre());
            aux = aux.getpNext();
        }
        
        aux = grafoWarehouse.getListaPrincipal().getpFirst();
        for (int i = 0; i < grafoWarehouse.getListaPrincipal().getSize(); i++) {
            Nodo<Arco> aux2 = aux.getElemento().getListaDeAdyacencia().getpFirst();
            for (int j = 0; j < aux.getElemento().getListaDeAdyacencia().getSize(); j++) {
                graph.addEdge(aux2.getElemento().getVerticeOrigenNombre() + aux2.getElemento().getVerticeDestinoNombre(), aux2.getElemento().getVerticeOrigenNombre() , aux2.getElemento().getVerticeDestinoNombre(), true);
                graph.getEdge(aux2.getElemento().getVerticeOrigenNombre() + aux2.getElemento().getVerticeDestinoNombre()).setAttribute("ui.label", aux2.getElemento().getDistancia());
                aux2 = aux2.getpNext();
            }
            aux = aux.getpNext();
        }
        
        Viewer viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
        
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
        ReporteAlmacenesButton = new javax.swing.JToggleButton();
        RealizarPedidoButton = new javax.swing.JButton();
        AgregarAlmacenButton = new javax.swing.JButton();
        AgregarCaminoButton = new javax.swing.JButton();
        GestionStockButton = new javax.swing.JButton();
        MostrarGrafoButton = new javax.swing.JButton();
        ActualizarRepoButton = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, -1));

        ReporteAlmacenesButton.setBackground(new java.awt.Color(204, 204, 204));
        ReporteAlmacenesButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        ReporteAlmacenesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1.png"))); // NOI18N
        ReporteAlmacenesButton.setText("REPORTE DE DISPONIBILIDAD POR ALMACENES");
        ReporteAlmacenesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporteAlmacenesButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ReporteAlmacenesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 340, -1));

        RealizarPedidoButton.setBackground(new java.awt.Color(204, 204, 204));
        RealizarPedidoButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        RealizarPedidoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/2.png"))); // NOI18N
        RealizarPedidoButton.setText("REALIZAR PEDIDO");
        RealizarPedidoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RealizarPedidoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(RealizarPedidoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 340, -1));

        AgregarAlmacenButton.setBackground(new java.awt.Color(204, 204, 204));
        AgregarAlmacenButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        AgregarAlmacenButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/6.png"))); // NOI18N
        AgregarAlmacenButton.setText("AGREGAR UN NUEVO ALMACEN");
        AgregarAlmacenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarAlmacenButtonActionPerformed(evt);
            }
        });
        getContentPane().add(AgregarAlmacenButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 340, -1));

        AgregarCaminoButton.setBackground(new java.awt.Color(204, 204, 204));
        AgregarCaminoButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        AgregarCaminoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/4.png"))); // NOI18N
        AgregarCaminoButton.setText("AGREGAR UN NUEVO CAMINO");
        AgregarCaminoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarCaminoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(AgregarCaminoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 340, -1));

        GestionStockButton.setBackground(new java.awt.Color(204, 204, 204));
        GestionStockButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        GestionStockButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/3.png"))); // NOI18N
        GestionStockButton.setText("GESTIÓN DE STOCK DE UN ALMACEN");
        GestionStockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionStockButtonActionPerformed(evt);
            }
        });
        getContentPane().add(GestionStockButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 340, -1));

        MostrarGrafoButton.setBackground(new java.awt.Color(204, 204, 204));
        MostrarGrafoButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        MostrarGrafoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/5.png"))); // NOI18N
        MostrarGrafoButton.setText("MOSTRAR GRAFO");
        MostrarGrafoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarGrafoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(MostrarGrafoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 340, -1));

        ActualizarRepoButton.setBackground(new java.awt.Color(255, 153, 0));
        ActualizarRepoButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        ActualizarRepoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/7.png"))); // NOI18N
        ActualizarRepoButton.setText("ACTUALIZAR REPOSITORIO");
        ActualizarRepoButton.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 0)));
        ActualizarRepoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarRepoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ActualizarRepoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 520, 250, 70));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo amazon.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Conduce a la interfaz de Reporte de Disponibilidad por Almacen
     * @param evt 
     */
    private void ReporteAlmacenesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReporteAlmacenesButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        InterfazReporteAlmacenes newI = new InterfazReporteAlmacenes(grafoWarehouse);
        newI.setVisible(true);
    }//GEN-LAST:event_ReporteAlmacenesButtonActionPerformed
    /**
     * Conduce a la interfaz de Realizar Pedido
     * @param evt 
     */
    private void RealizarPedidoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RealizarPedidoButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        InterfazRealizarPedido newI = new InterfazRealizarPedido(grafoWarehouse);
        newI.setVisible(true);
    }//GEN-LAST:event_RealizarPedidoButtonActionPerformed
    /**
     * Conduce a la interfaz de Gestión de Stock
     * @param evt 
     */
    private void GestionStockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionStockButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        InterfazGestionStock newI = new InterfazGestionStock(grafoWarehouse);
        newI.setVisible(true);
    }//GEN-LAST:event_GestionStockButtonActionPerformed
    /**
     * Conduce a la interfaz de Agregar Almacen
     * @param evt 
     */
    private void AgregarAlmacenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarAlmacenButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        InterfazAgregarAlmacen newI = new InterfazAgregarAlmacen(grafoWarehouse);
        newI.setVisible(true);
    }//GEN-LAST:event_AgregarAlmacenButtonActionPerformed
    /**
     * Conduce a la interfaz deAgregar Camino
     * @param evt 
     */
    private void AgregarCaminoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarCaminoButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        InterfazAgregarArco newI = new InterfazAgregarArco(grafoWarehouse);
        newI.setVisible(true);
    }//GEN-LAST:event_AgregarCaminoButtonActionPerformed
    /**
     * Llama a la función de cargar archivo
     * @param evt 
     */
    private void ActualizarRepoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarRepoButtonActionPerformed
        // TODO add your handling code here:
        this.cargarArchivo(grafoWarehouse);  
    }//GEN-LAST:event_ActualizarRepoButtonActionPerformed

    private void MostrarGrafoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarGrafoButtonActionPerformed
        // TODO add your handling code here:
        try {
            CrearGraphStream();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL IMPRIMIR EL GRAFO. \nTipo de error: " + e);
        }
    }//GEN-LAST:event_MostrarGrafoButtonActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazMenu(grafoWarehouse).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarRepoButton;
    private javax.swing.JButton AgregarAlmacenButton;
    private javax.swing.JButton AgregarCaminoButton;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton GestionStockButton;
    private javax.swing.JButton MostrarGrafoButton;
    private javax.swing.JButton RealizarPedidoButton;
    private javax.swing.JToggleButton ReporteAlmacenesButton;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
