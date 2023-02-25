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
import javax.swing.JOptionPane;

/**
 * Esta interfaz permite hacer un pedido de un producto al usuario, a su vez, se encuentran funciones las cuales son usadas para hacer estas peticiones posibles
 * @author Fabrizio Spiotta, Georgina Akel, Daniel Morillo
 */
public class InterfazRealizarPedido extends javax.swing.JFrame {
    
    static Grafo grafoWarehouse;
    /**
     * Creates new form InterfazRealizarPedido
     * @param grafoWarehouse el grafo que contiene la información
     */
    public InterfazRealizarPedido(Grafo grafoWarehouse) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.grafoWarehouse = grafoWarehouse;
    }
    
    /**
     * Este método retorna un string todos los productos
     * @param listaDeProductos La lista que contiene los productos a ser vendidos
     * @return un string con todos los productos
     */
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
    
    /**
     * Este método permite recorrer la información de todo el grafo y muestra todos los productos en sus respectivos almacenes y con su stock
     * @param startAlmacen Es el primer vértice o almacén por el cual empieza el recorrido BFS
     * @param grafoWarehouse el grafo que contiene la información
     * @return un string con toda la información de los almacenes, productos y stock disponible
     */
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
     * Crea una lista con todos los productos solicitados por el cliente
     * @return la lista con los productos solicitados
     */
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
    
    /**
     * Este método corresponde al algoritmo de Djikstra, el cual encuentra el camino más corto de un nodo inicial a otro dentro del grafo
     * @param numeroVertices Es el numero de vértices del grafo
     * @param listaPrincipal La lista principal dentro del grafo
     * @param nodoFuente El nodo de donde partirá la búsqueda
     * @return La distancia más corta posible desde nodoFuente hasta los otros nodos de la lista de adyacencia
     */
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
    
    /**
     * Descuenta del stock de un producto las existencias ya pedidas de éste
     * @param listaProductosSolicitados
     * @param almacen
     */
    public void DescontarStock(Lista listaProductosSolicitados, Vertice almacen) {
        Nodo<Producto> aux =  listaProductosSolicitados.getpFirst();
        Nodo<Producto> aux2 = almacen.getListaDeProdutcos().getpFirst();

        for (int i = 0; i < listaProductosSolicitados.getSize(); i++) {
            for (int j = 0; j < almacen.getListaDeProdutcos().getSize(); j++) {
                if (!listaProductosSolicitados.isEmpty() && aux2 != null) {
                    if (aux.getElemento().getNombre().equalsIgnoreCase(aux2.getElemento().getNombre())) {
                        int stockOriginal = aux.getElemento().getStock();
                        for (int k = 0; k < stockOriginal; k++) {
                            if (aux2.getElemento().getStock()!= 0) {
                                aux2.getElemento().setStock(aux2.getElemento().getStock() -1);
                                aux.getElemento().setStock(aux.getElemento().getStock() -1);  
                                if (aux.getElemento().getStock() == 0) {
                                    listaProductosSolicitados.DeleteObjeto(aux);
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
    
//    public void DescontarStockBien(Lista listaProductosSolicitados, Vertice almacen) {
//        Nodo<Producto> aux =  listaProductosSolicitados.getpFirst();
//        Nodo<Producto> aux2 = almacen.getListaDeProdutcos().getpFirst();
//
//        for (int i = 0; i < listaProductosSolicitados.getSize(); i++) {
//            for (int j = 0; j < almacen.getListaDeProdutcos().getSize(); j++) {
//                if (aux2.getElemento().getNombre().equalsIgnoreCase(aux.getElemento().getNombre())) {
//                    for (int k = 0; k < aux.getElemento().getStock(); k++) {
//                        if (aux2.getElemento().getStock() != 0 ) {
//                            aux2.getElemento().setStock(aux2.getElemento().getStock() -1);
//                            aux.getElemento().setStock(aux.getElemento().getStock() -1);
//                            if (aux.getElemento().getStock() == 0) {
//                                listaProductosSolicitados.DeleteObjeto(aux);
//                            }
//                        }
//                    }
//                }
//                aux2 = aux2.getpNext();
//            }
//            aux = aux.getpNext();
//        }
//    }
    
    

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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TextAreaAlmacen = new javax.swing.JTextArea();
        VerProductosButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, -1));

        VolverMenuButton.setBackground(new java.awt.Color(255, 153, 0));
        VolverMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MENU.png"))); // NOI18N
        VolverMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverMenuButtonActionPerformed(evt);
            }
        });
        getContentPane().add(VolverMenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 530, -1, -1));

        VerProductosTextArea.setEditable(false);
        VerProductosTextArea.setBackground(new java.awt.Color(204, 204, 204));
        VerProductosTextArea.setColumns(20);
        VerProductosTextArea.setRows(5);
        jScrollPane1.setViewportView(VerProductosTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 270, 350));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setText("Ingrese la lista de los productos que desea adquirir ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setText("con la siguiente estructura. De lo contrario, no se acepta");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setText("NombreDelProducto,Cantidad \\n");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, -1));

        TextAreaPedirProductos.setBackground(new java.awt.Color(204, 204, 204));
        TextAreaPedirProductos.setColumns(20);
        TextAreaPedirProductos.setRows(5);
        jScrollPane2.setViewportView(TextAreaPedirProductos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 270, 90));

        PedirProductosButton.setBackground(new java.awt.Color(204, 204, 204));
        PedirProductosButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        PedirProductosButton.setText("PEDIR PRODUCTOS");
        PedirProductosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PedirProductosButtonActionPerformed(evt);
            }
        });
        getContentPane().add(PedirProductosButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 470, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setText("Coloque aqui el almacen desde el cual ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setText("quiere realizar el pedido (Coloque la letra)");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, -1, -1));

        TextAreaAlmacen.setBackground(new java.awt.Color(204, 204, 204));
        TextAreaAlmacen.setColumns(20);
        TextAreaAlmacen.setRows(5);
        jScrollPane3.setViewportView(TextAreaAlmacen);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 260, 90));

        VerProductosButton.setBackground(new java.awt.Color(204, 204, 204));
        VerProductosButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        VerProductosButton.setText("VER PRODUCTOS OFERTADOS");
        VerProductosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerProductosButtonActionPerformed(evt);
            }
        });
        getContentPane().add(VerProductosButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, -1, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setText("SELECCIONE ALMACEN");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/2.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
                            JOptionPane.showMessageDialog(null, "Estos productos no se han podido comprar --> \n" + this.mostrarProductosNoComprados(listaProductosSolicitados));
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
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton PedirProductosButton;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
