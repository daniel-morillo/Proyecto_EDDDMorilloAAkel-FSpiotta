/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.Arco;
import Clases.Producto;
import Clases.Vertice;
import EstructurasDeDatos.Cola;
import EstructurasDeDatos.Grafo;
import EstructurasDeDatos.Nodo;
import static Interfaces.InterfazAgregarArco.grafoWarehouse;
import static Interfaces.InterfazReporteAlmacenes.grafoWarehouse;
import javax.swing.JOptionPane;

/**
 *
 * @author fabriziospiotta
 */
public class InterfazGestionStock extends javax.swing.JFrame {
    
    static Grafo grafoWarehouse;
    /**
     * Creates new form InterfazGestionStock
     */
    public InterfazGestionStock(Grafo grafoWarehouse) {
        this.grafoWarehouse = grafoWarehouse;
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public String recorridoBFS(Vertice startAlmacen, Grafo grafoWarehouse) {
        String cadena = "";
        boolean[] visited = new boolean[grafoWarehouse.getListaPrincipal().getSize()]; 
        Cola<Vertice> cola = new Cola();
                
        cola.encolar(startAlmacen);
        char verticeInicial = startAlmacen.getNombre().charAt(0);
        int verticeInicialInt = verticeInicial - 65;
        visited[verticeInicialInt] = true;
        
        cadena += "PRODUCTOS DISPONIBLES \n";
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
        VolverMenuButton = new javax.swing.JButton();
        MostrarTodoButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextAreaMostrarTodo = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextAreaStockAgregar = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        TextAreaAlmacenLetra = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        TextAreaProducto = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        AgregarButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TextAreaAlmacenLetraAgregarP = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        TextAreaAgregarP = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        AgregarProductoButton = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        TextAreaStockAgregarInicial = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        VolverMenuButton.setBackground(new java.awt.Color(255, 153, 0));
        VolverMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MENU.png"))); // NOI18N
        VolverMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverMenuButtonActionPerformed(evt);
            }
        });
        getContentPane().add(VolverMenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 530, -1, -1));

        MostrarTodoButton.setBackground(new java.awt.Color(204, 204, 204));
        MostrarTodoButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        MostrarTodoButton.setText("MOSTRAR ALMACENES REGISTRADO");
        MostrarTodoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarTodoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(MostrarTodoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, -1, -1));

        TextAreaMostrarTodo.setBackground(new java.awt.Color(204, 204, 204));
        TextAreaMostrarTodo.setColumns(20);
        TextAreaMostrarTodo.setRows(5);
        jScrollPane1.setViewportView(TextAreaMostrarTodo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 320, 130));

        TextAreaStockAgregar.setBackground(new java.awt.Color(204, 204, 204));
        TextAreaStockAgregar.setColumns(20);
        TextAreaStockAgregar.setRows(5);
        jScrollPane2.setViewportView(TextAreaStockAgregar);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 110, -1));

        TextAreaAlmacenLetra.setBackground(new java.awt.Color(204, 204, 204));
        TextAreaAlmacenLetra.setColumns(20);
        TextAreaAlmacenLetra.setRows(5);
        jScrollPane3.setViewportView(TextAreaAlmacenLetra);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 110, -1));

        TextAreaProducto.setBackground(new java.awt.Color(204, 204, 204));
        TextAreaProducto.setColumns(20);
        TextAreaProducto.setRows(5);
        jScrollPane4.setViewportView(TextAreaProducto);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 110, -1));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setText("STOCK A AGREGAR --> ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setText("ALMACEN --> ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setText("PRODUCTO --> ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, -1, -1));

        AgregarButton.setBackground(new java.awt.Color(204, 204, 204));
        AgregarButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        AgregarButton.setText("AGREGAR EXISTENCIAS");
        AgregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(AgregarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, -1, -1));

        TextAreaAlmacenLetraAgregarP.setBackground(new java.awt.Color(204, 204, 204));
        TextAreaAlmacenLetraAgregarP.setColumns(20);
        TextAreaAlmacenLetraAgregarP.setRows(5);
        jScrollPane5.setViewportView(TextAreaAlmacenLetraAgregarP);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 110, -1));

        TextAreaAgregarP.setBackground(new java.awt.Color(204, 204, 204));
        TextAreaAgregarP.setColumns(20);
        TextAreaAgregarP.setRows(5);
        jScrollPane6.setViewportView(TextAreaAgregarP);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 110, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setText("ALMACEN --> ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setText("PRODUCTO --> ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));

        AgregarProductoButton.setBackground(new java.awt.Color(204, 204, 204));
        AgregarProductoButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        AgregarProductoButton.setText("AGREGAR PRODUCTO");
        AgregarProductoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarProductoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(AgregarProductoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, -1, -1));

        TextAreaStockAgregarInicial.setBackground(new java.awt.Color(204, 204, 204));
        TextAreaStockAgregarInicial.setColumns(20);
        TextAreaStockAgregarInicial.setRows(5);
        jScrollPane7.setViewportView(TextAreaStockAgregarInicial);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 110, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setText("STOCK INICIAL --> ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/3.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolverMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverMenuButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        InterfazMenu menu = new InterfazMenu(grafoWarehouse);
        menu.setVisible(true);
    }//GEN-LAST:event_VolverMenuButtonActionPerformed

    private void MostrarTodoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarTodoButtonActionPerformed
        // TODO add your handling code here:
        try {
            String cadena = recorridoBFS((Vertice) grafoWarehouse.getListaPrincipal().getpFirst().getElemento(), grafoWarehouse);
            TextAreaMostrarTodo.setText(cadena);
        }  catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR DESCONOCIDO!. \nTipo de error: " + e);
        } 
    }//GEN-LAST:event_MostrarTodoButtonActionPerformed

    private void AgregarProductoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarProductoButtonActionPerformed
        // TODO add your handling code here:
        if ("".equals(TextAreaAlmacenLetraAgregarP.getText()) || "".equals(TextAreaAgregarP.getText()) || "".equals(TextAreaStockAgregarInicial.getText())) {
            JOptionPane.showMessageDialog(null, "ERROR! ambos campos deben estar llenos");
        } 
        else if (grafoWarehouse.encontrarAlmacenNombre(TextAreaAlmacenLetraAgregarP.getText()) == false) {
            JOptionPane.showMessageDialog(null, "ERROR! No se encontraron dichos almacenes en el grafo");
        } else {
            try{
                Vertice almacenSelected = grafoWarehouse.getListaPrincipal().BuscarVerticeLetra(TextAreaAlmacenLetraAgregarP.getText());
                if (almacenSelected != null) {
                    Producto newProduct = new Producto(TextAreaAgregarP.getText(), Integer.parseInt(TextAreaStockAgregarInicial.getText()));
                    almacenSelected.getListaDeProdutcos().AppendAtTheEnd(newProduct);
                    JOptionPane.showMessageDialog(null, "PRODUCTO AGREGADO CON EXITO");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR DESCONOCIDO!. \nTipo de error: " + e);
            }
        }    
    }//GEN-LAST:event_AgregarProductoButtonActionPerformed

    private void AgregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarButtonActionPerformed
        // TODO add your handling code here:
        if ("".equals(TextAreaAlmacenLetra.getText()) || "".equals(TextAreaProducto.getText()) || "".equals(TextAreaStockAgregar.getText())) {
            JOptionPane.showMessageDialog(null, "ERROR! Los tres campos deben estar llenos");
        } 
        else if (grafoWarehouse.encontrarAlmacenNombre(TextAreaAlmacenLetra.getText()) == false) {
            JOptionPane.showMessageDialog(null, "ERROR! No se encontraron dichos almacenes en el grafo");
        } else {
            try{
                boolean encontrado = false;
                Vertice almacenSelected = grafoWarehouse.getListaPrincipal().BuscarVerticeLetra(TextAreaAlmacenLetra.getText());
                if (almacenSelected != null) {
                    Nodo<Producto> aux = almacenSelected.getListaDeProdutcos().getpFirst();
                    for (int i = 0; i < almacenSelected.getListaDeProdutcos().getSize(); i++) {
                        if (aux.getElemento().getNombre().equalsIgnoreCase(TextAreaProducto.getText())) {
                            aux.getElemento().setStock(aux.getElemento().getStock() + Integer.parseInt(TextAreaStockAgregar.getText()));
                            encontrado = true;
                        }
                        aux = aux.getpNext();
                    }
                }
                
                if (encontrado == true) {
                    JOptionPane.showMessageDialog(null, "GESTION REALIZADA CON EXITO");
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR! NO SE HA ENCONTRADO DICHO PRODUCTO EN EL ALMACEN SELECCIONADO");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR DESCONOCIDO!. \nTipo de error: " + e);
            }
            
        }
    }//GEN-LAST:event_AgregarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazGestionStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazGestionStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazGestionStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazGestionStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazGestionStock(grafoWarehouse).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarButton;
    private javax.swing.JButton AgregarProductoButton;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton MostrarTodoButton;
    private javax.swing.JTextArea TextAreaAgregarP;
    private javax.swing.JTextArea TextAreaAlmacenLetra;
    private javax.swing.JTextArea TextAreaAlmacenLetraAgregarP;
    private javax.swing.JTextArea TextAreaMostrarTodo;
    private javax.swing.JTextArea TextAreaProducto;
    private javax.swing.JTextArea TextAreaStockAgregar;
    private javax.swing.JTextArea TextAreaStockAgregarInicial;
    private javax.swing.JButton VolverMenuButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    // End of variables declaration//GEN-END:variables
}
