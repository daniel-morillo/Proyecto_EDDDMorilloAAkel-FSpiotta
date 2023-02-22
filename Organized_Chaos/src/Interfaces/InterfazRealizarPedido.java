/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.Arco;
import Clases.Pair;
import Clases.Producto;
import Clases.Vertice;
import EstructurasDeDatos.Cola;
import EstructurasDeDatos.Grafo;
import EstructurasDeDatos.Lista;
import EstructurasDeDatos.Nodo;
import static Interfaces.InterfazReporteAlmacenes.grafoWarehouse;
import javax.swing.JOptionPane;

/**
 *
 * @author fabriziospiotta
 */
public class InterfazRealizarPedido extends javax.swing.JFrame {
    
    static Grafo grafoWarehouse;
    /**
     * Creates new form InterfazRealizarPedido
     */
    public InterfazRealizarPedido(Grafo grafoWarehouse) {
        initComponents();
        this.grafoWarehouse = grafoWarehouse;
    }
    
    public String mostrarProductosNoComprados(Lista listaDeProductos) {
        String cadena = "PRODUCTOS NO COMPRADOS \n";
        cadena += "\n";
        Nodo<Producto> aux = listaDeProductos.getpFirst();
        for (int i = 0; i < listaDeProductos.getSize(); i++) {
            cadena += "PRODUCTO --> " + aux.getElemento().getNombre() + "  CANTIDAD NO DISPONIBLE EN LOS ALMACENES ACTUALMENTE --> " + aux.getElemento().getStock() + "\n";
            aux = aux.getpNext();
        }
        return cadena;   
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
    
    public Lista leerListaDeProductos(){
        Lista productosSolicitadosList = new Lista();
        String texto = TextAreaPedirProductos.getText();
        String [] arrayGrande = texto.split("\n");
        for (int i = 0; i < arrayGrande.length; i++) {
            String [] productoCantidadArray = arrayGrande[i].split(",");
            Producto newProduct = new Producto(productoCantidadArray[0], Integer.parseInt(productoCantidadArray[1]));
            productosSolicitadosList.AppendAtTheEnd(newProduct);
        }
        return productosSolicitadosList;
    }
    
    public static int[] djikstra(int numeroVertices, Lista listaPrincipal, String nodoFuente){
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
                priorityList.Delete(top);

                Nodo<Arco> aux = listaPrincipal.BuscarVertice(node).getListaDeAdyacencia().getpFirst();
                for (int i = 0; i < listaPrincipal.BuscarVertice(node).getListaDeAdyacencia().getSize(); i++) {
                    int edgeWeight = aux.getElemento().getDistancia();
                    int adjNode = aux.getElemento().getVerticeDestinoNumero();

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
    
    public void DescontarStock(Lista listaProductosSolicitados, Vertice almacen) {
        Nodo<Producto> aux = almacen.getListaDeProdutcos().getpFirst();
        Nodo<Producto> aux2 = listaProductosSolicitados.getpFirst();

        for (int i = 0; i < almacen.getListaDeProdutcos().getSize(); i++) {
            for (int j = 0; j < listaProductosSolicitados.getSize(); j++) {
                if (!listaProductosSolicitados.isEmpty() && aux2 != null) {
                    if (aux.getElemento().getNombre().equalsIgnoreCase(aux2.getElemento().getNombre())) {
                        for (int k = 0; k < aux2.getElemento().getStock(); k++) {
                            if (aux.getElemento().getStock()!= 0) {
                                aux.getElemento().setStock(aux.getElemento().getStock() -1);
                                aux2.getElemento().setStock(aux2.getElemento().getStock() -1);  
                                if (aux2.getElemento().getStock() == 0) {
                                    listaProductosSolicitados.DeleteObjeto(aux2);
                                }
                            } 
                        }
                    }    
                    aux2 = aux2.getpNext();
                }
            }  
            aux = aux.getpNext();
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

        jPanel1 = new javax.swing.JPanel();
        VolverMenuButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        VerProductosTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextAreaPedirProductos = new javax.swing.JTextArea();
        PedirProductosButton = new javax.swing.JButton();
        SeleccioneAlmacenButton = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TextAreaAlmacen = new javax.swing.JTextArea();
        VerProductosButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, -1));

        VolverMenuButton.setText("VOLVER AL MENU");
        VolverMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverMenuButtonActionPerformed(evt);
            }
        });
        getContentPane().add(VolverMenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 380, -1, -1));

        VerProductosTextArea.setEditable(false);
        VerProductosTextArea.setColumns(20);
        VerProductosTextArea.setRows(5);
        jScrollPane1.setViewportView(VerProductosTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 220, 210));

        jLabel1.setText("Ingrese la lista de los productos que desea adquirir ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jLabel2.setText("con la siguiente estructura. De lo contrario, no se acepta");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, -1));

        jLabel3.setText("NombreDelProducto,Cantidad \\n");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, -1));

        TextAreaPedirProductos.setColumns(20);
        TextAreaPedirProductos.setRows(5);
        jScrollPane2.setViewportView(TextAreaPedirProductos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 300, 190));

        PedirProductosButton.setText("PEDIR PRODUCTOS");
        PedirProductosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PedirProductosButtonActionPerformed(evt);
            }
        });
        getContentPane().add(PedirProductosButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, -1, -1));

        SeleccioneAlmacenButton.setText("SELECCIONE ALMACEN");
        SeleccioneAlmacenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccioneAlmacenButtonActionPerformed(evt);
            }
        });
        getContentPane().add(SeleccioneAlmacenButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, -1, -1));

        jLabel4.setText("Coloque aqui el almacen desde el cual ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, -1, -1));

        jLabel5.setText("quiere realizar el pedido (Coloque la letra)");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, -1, -1));

        TextAreaAlmacen.setColumns(20);
        TextAreaAlmacen.setRows(5);
        jScrollPane3.setViewportView(TextAreaAlmacen);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, 220, 30));

        VerProductosButton.setText("VER PRODUCTOS OFERTADOS");
        VerProductosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerProductosButtonActionPerformed(evt);
            }
        });
        getContentPane().add(VerProductosButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolverMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverMenuButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        InterfazMenu menu = new InterfazMenu(grafoWarehouse);
        menu.setVisible(true);
    }//GEN-LAST:event_VolverMenuButtonActionPerformed

    private void PedirProductosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PedirProductosButtonActionPerformed
        // TODO add your handling code here:
        if ("".equals(TextAreaPedirProductos.getText())) {
            JOptionPane.showMessageDialog(null, "ERROR! No ha solicitado ningun producto");
        } 
        else if("".equals(TextAreaAlmacen.getText())) {
            JOptionPane.showMessageDialog(null, "ERROR! No ha seleccionado ningun almacen desde el cual realizar el pedido");
        } else {
            try{
                Lista listaProductosSolicitados = leerListaDeProductos();
                Vertice almacen = grafoWarehouse.getListaPrincipal().BuscarVerticeLetra(TextAreaAlmacen.getText());
                if (almacen != null) {
                    this.DescontarStock(listaProductosSolicitados, almacen);
                    if (listaProductosSolicitados.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "PEDIDO REALIZADO EXITOSAMENTE");
                    }
                    else {
                        Lista listaConDistanciasOrdenadas = new Lista();
                        int[] arrayConDistanciasMasCortas = djikstra(grafoWarehouse.getListaPrincipal().getSize(), grafoWarehouse.getListaPrincipal(),almacen.getNombre());
                        for (int i = 0; i < arrayConDistanciasMasCortas.length; i++) {
                            Pair newPair = new Pair(arrayConDistanciasMasCortas[i], i);
                            listaConDistanciasOrdenadas.AppendOrdenadoPair(newPair);
                        }
                        listaConDistanciasOrdenadas.DeletePair(almacen);

                        for (int i = 0; i < listaConDistanciasOrdenadas.getSize(); i++) {
                            Nodo<Pair> aux = listaConDistanciasOrdenadas.getpFirst();
                            for (int j = 0; j < listaConDistanciasOrdenadas.getSize(); j++) {
                                char character = (char) (aux.getElemento().getNumeroVertice() + 65);
                                String NombreVertice = String.valueOf(character);
                                Vertice almacenAgarrado = grafoWarehouse.getListaPrincipal().BuscarVerticeLetra(NombreVertice); 
                                this.DescontarStock(listaProductosSolicitados, almacenAgarrado);
                                aux = aux.getpNext();
                            }  
                        }

                        if (!listaProductosSolicitados.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "ERROR! Existen algunos productos que se encuentran out of stock");
                            JOptionPane.showMessageDialog(null, "Estos productos nose han podido comprar --> " + this.mostrarProductosNoComprados(listaProductosSolicitados));
                        } else {
                            JOptionPane.showMessageDialog(null, "PEDIDO REALIZADO EXITOSAMENTE");
                        }    
                    } 
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR! El almacen seleccionado no existe");
                }   
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR! Revise la forma en que proporciono la lista de productos al sistema");
            }
        }
    }//GEN-LAST:event_PedirProductosButtonActionPerformed

    private void VerProductosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerProductosButtonActionPerformed
        // TODO add your handling code here:
        String cadena = recorridoBFS((Vertice) grafoWarehouse.getListaPrincipal().getpFirst().getElemento(), grafoWarehouse);
        VerProductosTextArea.setText(cadena);
    }//GEN-LAST:event_VerProductosButtonActionPerformed

    private void SeleccioneAlmacenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccioneAlmacenButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeleccioneAlmacenButtonActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazRealizarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazRealizarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazRealizarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazRealizarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazRealizarPedido(grafoWarehouse).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PedirProductosButton;
    private javax.swing.JTextField SeleccioneAlmacenButton;
    private javax.swing.JTextArea TextAreaAlmacen;
    private javax.swing.JTextArea TextAreaPedirProductos;
    private javax.swing.JButton VerProductosButton;
    private javax.swing.JTextArea VerProductosTextArea;
    private javax.swing.JButton VolverMenuButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
