/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import EstructurasDeDatos.Cola;
import EstructurasDeDatos.Grafo;
import EstructurasDeDatos.Nodo;
import EstructurasDeDatos.Pila;
import Clases.Arco;
import Clases.Producto;
import Clases.Vertice;
import javax.swing.JOptionPane;

/**
 * Esta Interfaz muestra el reporte de disponibilidad de todos los almacenes
 * @author Fabrizio Spiotta, Georgina Akel, Daniel Morillo 
 */
public class InterfazReporteAlmacenes extends javax.swing.JFrame {
    
    static Grafo grafoWarehouse;
    /**
     * Crea la interfaz
     */
    public InterfazReporteAlmacenes(Grafo grafoWarehouse) {
        this.grafoWarehouse = grafoWarehouse;
        initComponents();
        this.setLocationRelativeTo(null);
    }
    /**
     * Esta función Realiza un recorrido DFS (profundidad), pasando por todos los almacenes siguiendo el orden de sus adyacencias
     * @param startAlmacen Almacen por el cual empieza el recorrido
     * @param grafoWarehouse El grafo
     * @return Un string con toda la información referente a los almacenes, productos y stocks del grafo
     */
    public String recorridoDFS(Vertice startAlmacen, Grafo grafoWarehouse) {
        String cadena = "";
        boolean[] visited = new boolean[grafoWarehouse.getListaPrincipal().getSize()]; 
        Pila<Vertice> pila = new Pila();
        
        pila.apilar(startAlmacen);
        char verticeInicial = startAlmacen.getNombre().charAt(0);
        int verticeInicialInt = verticeInicial - 65;
        visited[verticeInicialInt] = true;
        
        cadena += "RECORRIDO EN PROFUNDIDAD DFS \n";
        cadena += "\n";
        
        while(!pila.esVacio()) {
            Vertice cimaAgarrada = pila.pop();
            char nodeChar = cimaAgarrada.getNombre().charAt(0);
            int node = nodeChar - 65;
            cadena += "ALMACEN " + cimaAgarrada.getNombre() + "\n";
            
            Nodo<Producto> aux = cimaAgarrada.getListaDeProdutcos().getpFirst();
            for (int i = 0; i < cimaAgarrada.getListaDeProdutcos().getSize(); i++) {
                cadena += "PRODUCTO --> " + aux.getElemento().getNombre() + "  STOCK --> " + aux.getElemento().getStock() + "\n";
                aux = aux.getpNext();
            }
            
            Nodo<Arco> aux2 = cimaAgarrada.getListaDeAdyacencia().getpFirst();
            for (int i = 0; i < cimaAgarrada.getListaDeAdyacencia().getSize() ; i++) {
                char sigVertice = aux2.getElemento().getVerticeDestinoNombre().charAt(0);
                int sigVerticeInt = sigVertice - 65;
                if (!visited[sigVerticeInt]) {
                    pila.apilar(grafoWarehouse.getListaPrincipal().BuscarVerticeLetra(aux2.getElemento().getVerticeDestinoNombre()));
                    visited[sigVerticeInt] = true;
                }
                aux2 = aux2.getpNext();
            }
            cadena += "\n";
        }
        return cadena;
    }
    
    /**
     * Esta función Realiza un recorrido BFS (anchura), pasando por todos los almacenes en orden, es decir, A,B,c..
     * @param startAlmacen Almacen por el cual empieza el recorrido
     * @param grafoWarehouse El grafo
     * @return Un string con toda la información referente a los almacenes, productos y stocks del grafo
     */
    public String recorridoBFS(Vertice startAlmacen, Grafo grafoWarehouse) {
        String cadena = "";
        boolean[] visited = new boolean[grafoWarehouse.getListaPrincipal().getSize()]; 
        Cola<Vertice> cola = new Cola();
                
        cola.encolar(startAlmacen);
        char verticeInicial = startAlmacen.getNombre().charAt(0);
        int verticeInicialInt = verticeInicial - 65;
        visited[verticeInicialInt] = true;
        
        cadena += "RECORRIDO EN ANCHURA BFS \n";
        cadena += "\n";
        
        while(!cola.esVacia()) {
            char nodeChar = cola.leerCabeza().getNombre().charAt(0);
            int node = nodeChar - 65;
            cadena += "ALMACEN " + cola.leerCabeza().getNombre() + "\n";
            Nodo<Producto> aux = cola.leerCabeza().getListaDeProdutcos().getpFirst();
            for (int i = 0; i < cola.leerCabeza().getListaDeProdutcos().getSize(); i++) {
                cadena += "PRODUCTO --> " + aux.getElemento().getNombre() + "  STOCK --> " + aux.getElemento().getStock() + "\n";
                aux = aux.getpNext();
            }
            
            Nodo<Arco> aux2 = cola.leerCabeza().getListaDeAdyacencia().getpFirst();
            for (int i = 0; i < cola.leerCabeza().getListaDeAdyacencia().getSize() ; i++) {
                char sigVertice = aux2.getElemento().getVerticeDestinoNombre().charAt(0);
                int sigVerticeInt = sigVertice - 65;
                if (!visited[sigVerticeInt]) {
                    cola.encolar(grafoWarehouse.getListaPrincipal().BuscarVerticeLetra(aux2.getElemento().getVerticeDestinoNombre()));
                    visited[sigVerticeInt] = true;
                }
                aux2 = aux2.getpNext();
            }
            cadena += "\n";
            cola.desencolar();   
        }
        return cadena;
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
        BFSButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        BFSTextArea = new javax.swing.JTextArea();
        DFSButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        DFSTextArea = new javax.swing.JTextArea();
        VolverMenuButton = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, -1, -1));

        BFSButton.setBackground(new java.awt.Color(204, 204, 204));
        BFSButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        BFSButton.setText("RECORRIDO BFS");
        BFSButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFSButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BFSButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, -1));

        BFSTextArea.setEditable(false);
        BFSTextArea.setBackground(new java.awt.Color(204, 204, 204));
        BFSTextArea.setColumns(20);
        BFSTextArea.setRows(5);
        jScrollPane1.setViewportView(BFSTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 310, 170));

        DFSButton.setBackground(new java.awt.Color(204, 204, 204));
        DFSButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        DFSButton.setText("RECORRIDO DFS");
        DFSButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DFSButtonActionPerformed(evt);
            }
        });
        getContentPane().add(DFSButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, -1, -1));

        DFSTextArea.setEditable(false);
        DFSTextArea.setBackground(new java.awt.Color(204, 204, 204));
        DFSTextArea.setColumns(20);
        DFSTextArea.setRows(5);
        jScrollPane2.setViewportView(DFSTextArea);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 310, 170));

        VolverMenuButton.setBackground(new java.awt.Color(255, 153, 0));
        VolverMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MENU.png"))); // NOI18N
        VolverMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverMenuButtonActionPerformed(evt);
            }
        });
        getContentPane().add(VolverMenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 530, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Llama al recorrido BFS y lo muestra
     * @param evt 
     */
    private void BFSButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFSButtonActionPerformed
        // TODO add your handling code here:
        try {
            String cadena = recorridoBFS((Vertice) grafoWarehouse.getListaPrincipal().getpFirst().getElemento(), grafoWarehouse);
            BFSTextArea.setText(cadena);
        }  catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR DESCONOCIDO!. \nTipo de error: " + e);
        }    
    }//GEN-LAST:event_BFSButtonActionPerformed
    
    /**
     * Llama al recorrido DFS y lo muestra
     * @param evt 
     */
    private void DFSButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DFSButtonActionPerformed
        // TODO add your handling code here:
        try {
            String cadena = recorridoDFS((Vertice) grafoWarehouse.getListaPrincipal().getpFirst().getElemento(), grafoWarehouse);
            DFSTextArea.setText(cadena);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR DESCONOCIDO!. \nTipo de error: " + e);
        }
    }//GEN-LAST:event_DFSButtonActionPerformed

    private void VolverMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverMenuButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        InterfazMenu menu = new InterfazMenu(grafoWarehouse);
        menu.setVisible(true);
    }//GEN-LAST:event_VolverMenuButtonActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazReporteAlmacenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazReporteAlmacenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazReporteAlmacenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazReporteAlmacenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazReporteAlmacenes(grafoWarehouse).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BFSButton;
    private javax.swing.JTextArea BFSTextArea;
    private javax.swing.JButton DFSButton;
    private javax.swing.JTextArea DFSTextArea;
    private javax.swing.JLabel Fondo;
    private javax.swing.JToggleButton VolverMenuButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
