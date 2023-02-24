/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

import Clases.Arco;
import Clases.Vertice;


/**
 * La clase Grafo implementa los grafos, así como los métodos usados para el proyecto
 * @author Fabrizio Spiotta, Georgina Akel, Daniel Morillo
 */
public class Grafo {
    
    private int numeroDeVertices;
    private Lista listaPrincipal;
        
    
    /**
     *Constructor de la clase Grafo
     */
    public Grafo() {
        this.numeroDeVertices = 0;
        this.listaPrincipal = new Lista();
    }
    

    /**
     * Método que indica si el grafo está vacío
     * @return Falso/Verdadero
     */
    
    public boolean esVacio(){
        return this.getNumeroDeVertices() == 0;
    }
    
    /**
     * Método que verifica si determinado arco existe
     * @param verticeOrigenNombre Nombre del vértice de origen
     * @param verticeDestinoNombre Nombre del vértice de destino
     * @return Falso/Verdadero
     */
    public boolean adyacente(String verticeOrigenNombre, String verticeDestinoNombre) {
        if (!esVacio()) {
            Nodo<Vertice> aux = listaPrincipal.getpFirst();
            for (int i = 0; i < this.getNumeroDeVertices(); i++) {
                Nodo<Arco> aux2 = (Nodo<Arco>) aux.getElemento().getListaDeAdyacencia().getpFirst();
                if (!aux.getElemento().getListaDeAdyacencia().isEmpty()) {
                    for (int j = 0; j < aux.getElemento().getListaDeAdyacencia().getSize(); j++) {
                        if (aux.getElemento().getNombre().equals(verticeOrigenNombre) && aux2.getElemento().getVerticeDestinoNombre().equals(verticeDestinoNombre)) {
                            return true;
                        }
                        aux2 = aux2.getpNext();
                    }
                }
                aux = aux.getpNext();
            }
        }
        return false;
    }
    
    /**
     * Método que verifica si un almacen existe o no
     * @param newVertice es el almacen que se quiere verificar
     * @return
     */
    public boolean encontrarAlmacen(Vertice newVertice) {
        Nodo<Vertice> aux = listaPrincipal.getpFirst();
        for (int i = 0; i < this.getNumeroDeVertices(); i++) {
            if (aux.getElemento().getNombre().equals(newVertice.getNombre())) {
                return true;
            }
            aux = aux.getpNext();
        }
        return false;
    }
    
    /**
     * Método que, por el nombre del almacen, verifica si éste existe o no
     * @param nombre nombre del almacen a encontrar
     * @return
     */
    public boolean encontrarAlmacenNombre(String nombre) {
        Nodo<Vertice> aux = listaPrincipal.getpFirst();
        for (int i = 0; i < this.getNumeroDeVertices(); i++) {
            if (aux.getElemento().getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
            aux = aux.getpNext();
        }
        return false;
    }
    
    /**
     * Método que crea un nuevo almacen si este no existe
     * @param newVertice el nuevo almacen que se quiere introducir
     */
    public void insertarVertice(Vertice newVertice){
        if (this.esVacio()) {
            listaPrincipal.AppendAtTheEnd(newVertice);
            numeroDeVertices ++;
        }
        else {
            if (this.encontrarAlmacen(newVertice) == false) {
                listaPrincipal.AppendAtTheEnd(newVertice);
                numeroDeVertices ++;
            }
        }
    }
    
    /**
     * Método que inserta un nuevo arco
     * @param newArco el arco se que quiere insertar
     */
    public void insertarArco(Arco newArco) {
        if (!this.esVacio() && this.adyacente(newArco.getVerticeOrigenNombre(), newArco.getVerticeDestinoNombre()) == false) {
            Nodo<Vertice> aux = listaPrincipal.getpFirst();
            for (int i = 0; i < listaPrincipal.getSize(); i++) {
                if (aux.getElemento().getNombre().equals(newArco.getVerticeOrigenNombre())) {
                    aux.getElemento().getListaDeAdyacencia().AppendAtTheEnd(newArco);
                }
                aux = aux.getpNext();
            }
        }
    }
    
    /**
     * Método que borra un arco
     * @param distancia La distancia del arco
     * @param verticeOrigenNombre El nombre del vértice de origen
     * @param verticeDestinoNombre El nombre del vértice de destino
     */
    public void borrarArco(int distancia, String verticeOrigenNombre, String verticeDestinoNombre) {
        if (!this.esVacio()) {
            //Arco arcoAux = new Arco(distancia, verticeOrigen, verticeDestino);
            Nodo<Vertice> aux = listaPrincipal.getpFirst();
            for (int i = 0; i < listaPrincipal.getSize(); i++) {
                Nodo<Arco> aux2 = aux.getElemento().getListaDeAdyacencia().getpFirst();
                if (!aux.getElemento().getListaDeAdyacencia().isEmpty()) {
                    for (int j = 0; j < aux.getElemento().getListaDeAdyacencia().getSize(); j++) {
                        if (aux.getElemento().getNombre().equals(verticeOrigenNombre) && aux2.getElemento().getVerticeDestinoNombre().equals(verticeDestinoNombre)) {
                            aux.getElemento().getListaDeAdyacencia().DeleteObjeto(aux2);
                            //aux.getElemento().getListaDeAdyacencia().DeleteArco(arcoAux);
                        }
                        aux2 = aux2.getpNext();
                    }
                }
                aux = aux.getpNext();
            }
        }
    }
    
    /**
     * Método que borra un vértice
     * @param verticeNombre nombre del vértice que se quiera borrar
     */
    public void borrarVertice(String verticeNombre) {
        if (!this.esVacio()) {
            Nodo<Vertice> aux = listaPrincipal.getpFirst();
            for (int i = 0; i < listaPrincipal.getSize(); i++) {
                if (aux.getElemento().getNombre().equals(verticeNombre)) {
                    listaPrincipal.DeleteObjeto(aux);
                }
                aux = aux.getpNext();
            }
            Nodo<Vertice> aux2 = listaPrincipal.getpFirst();
            for (int i = 0; i < listaPrincipal.getSize(); i++) {
                Nodo<Arco> aux3 = aux2.getElemento().getListaDeAdyacencia().getpFirst();
                for (int j = 0; j < aux2.getElemento().getListaDeAdyacencia().getSize(); j++) {
                    if (aux3.getElemento().getVerticeDestinoNombre().equals(verticeNombre)) {
                        aux2.getElemento().getListaDeAdyacencia().DeleteObjeto(aux3);
                    }
                }
                aux2 = aux2.getpNext();
            }
               
        }
    }
    
    

    /**
     * Método que obtiene el numero de vértices del grafo
     * @return the numeroDeVertices
     */
    public int getNumeroDeVertices() {
        return numeroDeVertices;
    }

    /**
     * Método para establecer el número de vértices
     * @param numeroDeVertices el número de vértices que se quieren establecer
     */
    public void setNumeroDeVertices(int numeroDeVertices) {
        this.numeroDeVertices = numeroDeVertices;
    }

    /**
     * Método que devuelve la Lista Principal del Grafo
     * @return la Lista Principal del grafo
     */
    public Lista getListaPrincipal() {
        return listaPrincipal;
    }

    /**
     * Método que establece la lista principal del grafo
     * @param listaPrincipal la lista principal a ser establecida en el grafo
     */
    public void setListaPrincipal(Lista listaPrincipal) {
        this.listaPrincipal = listaPrincipal;
    }
    

    
    
    
}
