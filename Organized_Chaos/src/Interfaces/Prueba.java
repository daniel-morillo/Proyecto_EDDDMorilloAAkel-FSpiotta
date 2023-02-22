/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import EstructurasDeDatos.Lista;
import EstructurasDeDatos.Nodo;
import Clases.Arco;
import Clases.Pair;

/**
 *
 * @author Daniel Morillo
 */
public class Prueba extends javax.swing.JFrame {
    public static InterfazPrincipal inicio;
    public static String txt;
    /**
     * Creates new form Prueba
     */
    public Prueba(InterfazPrincipal inicio) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.inicio =inicio;
        inicio.setVisible(true);
        this.setVisible(true);
        this.txt = InterfazPrincipal.text;
    }
    
    public static int[] djikstraLetra(int numeroVertices, Lista listaPrincipal, String nodoFuente){
        if (listaPrincipal.BuscarVerticeLetra(nodoFuente) != null) {
            
            Lista<Pair> priorityList = new Lista();
            int[] dist = new int[numeroVertices];
            for (int i = 0; i < numeroVertices; i++) {
                dist[i] = Integer.MAX_VALUE;
            }
            
            char nodoFuenteChar = nodoFuente.charAt(0);
            int nodoFuenteNumero =  nodoFuenteChar - 65;
            dist[nodoFuenteNumero] = 0;
            priorityList.AppendOrdenadoPair(new Pair(0,nodoFuenteNumero));

            while(priorityList.getSize() != 0) {
                Pair top = (Pair) priorityList.getpFirst().getElemento();
                int dis = top.getDistance();
                int node = top.getNumeroVertice();
                char nodeChar = (char) (node + 65);
                String nodeString = String.valueOf(nodeChar);
                priorityList.Delete(top);

                Nodo<Arco> aux = listaPrincipal.BuscarVerticeLetra(nodeString).getListaDeAdyacencia().getpFirst();
                for (int i = 0; i < listaPrincipal.BuscarVerticeLetra(nodeString).getListaDeAdyacencia().getSize(); i++) {
                    int edgeWeight = aux.getElemento().getDistancia();
                    String adjNodeString = aux.getElemento().getVerticeDestinoNombre();
                    char adjNodeChar = adjNodeString.charAt(0);
                    int adjNode = adjNodeChar - 65;

                    if (dis +  edgeWeight < dist[adjNode]) {
                        dist[adjNode] = dis + edgeWeight;
                        priorityList.AppendOrdenadoPair(new Pair(dist[adjNode], adjNode));
                    }     
                    aux = aux.getpNext();
                }  
            }
            return dist;
        } else {
            System.out.println("El vertice no esta en el grafo");
            return null;
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

        DjikstraButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DjikstraButton.setText("Algoritmo de Djikstra");
        DjikstraButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DjikstraButtonActionPerformed(evt);
            }
        });
        getContentPane().add(DjikstraButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DjikstraButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DjikstraButtonActionPerformed
        // TODO add your handling code here:
        int[] dist = djikstraLetra(InterfazPrincipal.getGrafoWarehouse().getListaPrincipal().getSize(), InterfazPrincipal.getGrafoWarehouse().getListaPrincipal(), "B");
        
        if (dist != null) {
            for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i]);
            }
        }
    }//GEN-LAST:event_DjikstraButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prueba(inicio).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DjikstraButton;
    // End of variables declaration//GEN-END:variables
}