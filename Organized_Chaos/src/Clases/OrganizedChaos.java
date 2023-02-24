/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clases;

import EstructurasDeDatos.Lista;
import EstructurasDeDatos.Nodo;
import Interfaces.InterfazPrincipal;

/**
 * Esta clase corresponde
 * @author Fabrizio Spiotta, Georgina Akel, Daniel Morillo
 */
public class OrganizedChaos {

    /**
     *
     * @param numeroVertices el numero de vertices 
     * @param listaPrincipal es la lista de almacenes del grafo
     * @param nodoFuente es el nodo desde el cual se va a buscar el camino más corto hacia los otros nodos
     * @return
     */
    public static int[] djikstra(int numeroVertices, Lista listaPrincipal, int nodoFuente){
        if (listaPrincipal.BuscarVertice(nodoFuente) != null) {
            
        
            Lista<Pair> priorityList = new Lista();
            int[] dist = new int[numeroVertices];
            for (int i = 0; i < numeroVertices; i++) {
                dist[i] = Integer.MAX_VALUE;
            }

            dist[nodoFuente] = 0;
            priorityList.AppendOrdenadoPair(new Pair(0,nodoFuente));

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
     *
     * @param numeroVertices
     * @param listaPrincipal
     * @param nodoFuente
     * @return
     */
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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
             
        int[] dist = djikstraLetra(InterfazPrincipal.getGrafoWarehouse().getNumeroDeVertices(), InterfazPrincipal.getGrafoWarehouse().getListaPrincipal(), "B");
        
        if (dist != null) {
            for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i]);
            }
        }
        
        System.out.println("Prueba para git");
        
    }
    
}
