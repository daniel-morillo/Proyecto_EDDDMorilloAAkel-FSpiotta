/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

import Clases.Arco;
import Clases.Vertice;


/**
 *
 * @author fabriziospiotta
 */
public class Grafo {
    
    private int numeroDeVertices;
    private Lista listaPrincipal;
    
    public Grafo(int n) {
        this.numeroDeVertices = 0;
        this.listaPrincipal = new Lista();
    }
    
    public Grafo() {
        this.numeroDeVertices = 0;
        this.listaPrincipal = new Lista();
    }
    
    //Metodos
    
    public boolean esVacio(){
        return this.getNumeroDeVertices() == 0;
    }
    
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
     * @return the numeroDeVertices
     */
    public int getNumeroDeVertices() {
        return numeroDeVertices;
    }

    /**
     * @param numeroDeVertices the numeroDeVertices to set
     */
    public void setNumeroDeVertices(int numeroDeVertices) {
        this.numeroDeVertices = numeroDeVertices;
    }

//    /**
//     * @return the sizeVerts
//     */
//    public int getSizeVerts() {
//        return sizeVerts;
//    }
//
//    /**
//     * @param sizeVerts the sizeVerts to set
//     */
//    public void setSizeVerts(int sizeVerts) {
//        this.sizeVerts = sizeVerts;
//    }

    /**
     * @return the listaPrincipal
     */
    public Lista getListaPrincipal() {
        return listaPrincipal;
    }

    /**
     * @param listaPrincipal the listaPrincipal to set
     */
    public void setListaPrincipal(Lista listaPrincipal) {
        this.listaPrincipal = listaPrincipal;
    }
    

    
    
    
}
