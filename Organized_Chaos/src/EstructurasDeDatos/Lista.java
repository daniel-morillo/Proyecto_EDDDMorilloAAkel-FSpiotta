/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

import Clases.Arco;
import Clases.Pair;
import Clases.Vertice;

/**
 * Estra clase contiene las listas que serán de utilidad para todo el proyecto
 * @author Fabrizio Spiotta, Georgina Akel, Daniel Morillo
 * @param <T>
 */
public class Lista<T> {
    
    private Nodo pFirst;
    private Nodo pLast;
    private int size;
    
    /**
     * Constructor de la clase Lista
     */
    public Lista() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }
    
    /**
     * Método que busca un vértice (almacen) por su número
     * @param numeroVertice el número de del vértice que se quiere buscar
     * @return El vértice que se está buscando si es encontrado
     */
    public Vertice BuscarVertice(int numeroVertice){
        Nodo<Vertice> aux = this.getpFirst();
        for (int i = 0; i < this.getSize(); i++) {
            if (aux.getElemento().getNumVertice() == numeroVertice) {
                return aux.getElemento();
            }
            aux = aux.getpNext();
        }
        return null;
    }
    
    /**
     * Método para buscar un vértice (almacen) por su letra
     * @param letraVertice La letra del almacen que se quiere encontrar
     * @return El vértice que se está buscando si es encontrado
     */
    public Vertice BuscarVerticeLetra(String letraVertice){
        Nodo<Vertice> aux = this.getpFirst();
        for (int i = 0; i < this.getSize(); i++) {
            if (aux.getElemento().getNombre().equalsIgnoreCase(letraVertice)) {
                return aux.getElemento();
            }
            aux = aux.getpNext();
        }
        return null;
    }
    
    /**
     * Método que agrega un pair (vértice y distancia) de una forma ordenada 
     * @param element Pair que se quiere agregar
     */
    public void AppendOrdenadoPair(Pair element) {
        Nodo<Pair> pNew = new Nodo(element);
        if (!isEmpty()) {
            Nodo<Pair> aux = pFirst;
            for (int i = 0; i < size; i++) {
                if (aux.getElemento().getDistance() >= pNew.getElemento().getDistance()) {
                    pNew.setpNext(pFirst);
                    pFirst = pNew;
                    //pNew.setpNext(pFirst);
                    break;
                }
                else if (aux.getElemento().getDistance() < pNew.getElemento().getDistance() &&  aux.getpNext() == null) {
                    aux.setpNext(pNew);
                    pLast = pNew; 
                    break;
                }
                else if (aux.getElemento().getDistance() > pNew.getElemento().getDistance() &&  aux.getpNext() == null) {
                    pFirst = pNew;
                    pNew.setpNext(aux);
                    break;
                }
                Pair cu = (Pair) aux.getpNext().getElemento();
                if (aux.getElemento().getDistance() < pNew.getElemento().getDistance() && cu.getDistance() >= pNew.getElemento().getDistance()) {
                    pNew.setpNext(aux.getpNext());
                    aux.setpNext(pNew);
                    //pNew.setpNext(aux.getpNext().getpNext());
                    break;
                }
                aux = aux.getpNext();
            }
            size ++;
        } else {
        pFirst = pNew;
        pLast = pNew;
        size ++;
        }
    }
    
    /**
     * Método que verifica si la lista está vacía
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Método que agrega un elemento al final de la lista
     * @param element elemento que quiere ser agregado
     */
    public void AppendAtTheEnd(T element) {
        Nodo pNew = new Nodo (element);
        if (!isEmpty()) {
            pLast.setpNext(pNew);
            pLast = pNew;
            size ++;
        } else {
        pLast = pNew;
        pFirst = pNew;
        size ++;
        }
    }
    
    /**
     * Método que agrega un elemento al principio de la lista
     * @param element elemento que quiere ser agregado
     */
    public void AppendAthTheBeginning(T element) {
        Nodo pNew = new Nodo(element);
        if (!isEmpty()) {
            pNew.setpNext(pFirst);
            pFirst = pNew;
            size ++;
        }else {
        pLast = pNew;
        pFirst = pNew;
        size ++;
        }
    }
    
    /**
     * Método que agrega un elemento en una posición dada, contando de izquierda a derecha
     * @param index posición en la que quiere agregarse el elemento
     * @param element elemento a ser agregado
     */
    public void AppendAtThePosition_LeftToRight(int index, T element) {
        if (!isEmpty()) {
            Nodo pNew = new Nodo(element);
            Nodo aux = this.getpFirst();
            for (int i = 1; i <= this.getSize(); i++) {
                if (i == index-1) {
                    pNew.setpNext(aux.getpNext());
                    aux.setpNext(pNew);
                }
                aux = aux.getpNext();
            }  
        }
    }
    
    /**
     * Método que elimina un elemento
     * @param element elemento que quiere ser eliminado
     */
    public void Delete(T element){
        if (!isEmpty()) {
            if (pFirst.getElemento() == element) {
                if (pFirst.getpNext() == null) {
                    pFirst = null;
                    pLast = null;
                } else {
                    pFirst = pFirst.getpNext();
                }
                size -=1;
            } else {
                Nodo aux = pFirst;
                while(aux != null){
                    if (aux.getpNext() != null) {
                        if (aux.getpNext().getElemento() == element && aux.getpNext().getpNext() == null) {
                            pLast = aux;
                            pLast.setpNext(null);
                            size -= 1;
                        } else {
                            if (aux.getpNext().getElemento() == element) {
                            aux.setpNext(aux.getpNext().getpNext());
                            size -= 1;
                            }
                        }
                    }    
                    aux = aux.getpNext();
                }    
            }
        }
    }
    
    /**
     * Elimina un pair dentro de la lista 
     * @param element vertice que se quiere eliminar
     */
    public void DeletePair(Vertice element){
        if (!isEmpty()) {
            char character = element.getNombre().charAt(0);
            int numeroV = character - 65;
            Pair aux = (Pair) pFirst.getElemento();
            if (aux.getNumeroVertice() == numeroV) {
                if (pFirst.getpNext() == null) {
                    pFirst = null;
                    pLast = null;
                } else {
                    pFirst = pFirst.getpNext();
                }
                size -=1;
            } else {
                Nodo<Pair> aux2 = pFirst;
                while(aux2 != null){
                    if (aux2.getpNext() != null) {
                        if (Pair.class.cast(aux2.getpNext().getElemento()).getNumeroVertice() == numeroV && aux2.getpNext().getpNext() == null) {
                            pLast = aux2;
                            pLast.setpNext(null);
                            size -= 1;
                        } else {
                            if (Pair.class.cast(aux2.getpNext().getElemento()).getNumeroVertice() == numeroV) {
                            aux2.setpNext(aux2.getpNext().getpNext());
                            size -= 1;
                            }
                        }
                    }    
                    aux2 = aux2.getpNext();
                }    
            }
        }
    }
    
    /**
     * Elimina un objeto dentro de la lista
     * @param element el objeto a ser eliminado
     */
    public void DeleteObjeto(T element){
        if (!isEmpty()) {
            if (pFirst == element) {
                if (pFirst.getpNext() == null) {
                    pFirst = null;
                    pLast = null;
                } else {
                    pFirst = pFirst.getpNext();
                }
                size -=1;
            } else {
                Nodo aux = pFirst;
                while(aux != null){
                    if (aux.getpNext() != null) {
                        if (aux.getpNext() == element && aux.getpNext().getpNext() == null) {
                            pLast = aux;
                            pLast.setpNext(null);
                            size -= 1;
                        } else {
                            if (aux.getpNext() == element) {
                            aux.setpNext(aux.getpNext().getpNext());
                            size -= 1;
                            }
                        }
                    }    
                    aux = aux.getpNext();
                }    
            }
        }
    }
    
    /**
     * Método que imprime la lista de adyacencia 
     */
    public void imprimirListaAdyacencia(){
        if (!isEmpty()) {
                String cadena = "";
                Nodo<Arco> aux = this.getpFirst();
                for (int i = 0; i < this.getSize(); i++) {
                    cadena += (aux.getElemento().getDistancia() + " , " + aux.getElemento().getVerticeOrigenNombre() + " , " + aux.getElemento().getVerticeDestinoNombre() + " | ");
                    aux = aux.getpNext();
                }
                System.out.println(cadena);
            } else {
                System.out.println("El vertice no tiene arcos");
            }
    }
    
    /**
     * Método que imprime la lista principal del grafo
     */
    public void imprimirListaPrincipal(){
        if (!isEmpty()) {
            Nodo<Vertice> aux = this.getpFirst();
            for (int i = 0; i < this.getSize(); i++) {
                aux.getElemento().getListaDeAdyacencia().imprimirListaAdyacencia();
                aux = aux.getpNext();
            }
        } else {
            System.out.println("La lista principal no tiene vertices");
        }
    }
    
    /**
     * Método que elimina un arco del grafo
     * @param element arco que quiere ser eliminado
     */
    public void DeleteArco(Arco element){
        if (!isEmpty()) {
            Nodo<Arco> aux = this.getpFirst();
            if (aux.getElemento().getDistancia() == element.getDistancia() && aux.getElemento().getVerticeOrigenNombre().equals(element.getVerticeOrigenNombre()) && aux.getElemento().getVerticeDestinoNombre().equals(element.getVerticeDestinoNombre())) {
                pFirst = pFirst.getpNext();
                size -=1;
            }else {
                Nodo<Arco> aux2 = pFirst;
                for (int i = 0; i < size; i++) {
                    if (aux2.getpNext() != null) {
                        Arco cu = (Arco) aux2.getpNext().getElemento();
                        if (cu.getVerticeOrigenNombre().equals(element.getVerticeOrigenNombre()) && cu.getDistancia() == element.getDistancia() && cu.getVerticeDestinoNombre().equals(element.getVerticeDestinoNombre())) {
                        aux2.setpNext(aux2.getpNext().getpNext());
                        size -= 1;
                        }
                    }
                    aux2 = aux2.getpNext();
                }    
            }
        }
    }
    
        
    /**
     * Obtiene el primer nodo de la lista
     * @return el primero nodo de la lista
     */
    public Nodo getpFirst() {
        return pFirst;
    }

    /**
     * Establece el primer nodo de la lista
     * @param pFirst el nodo a ser establecido como primero
     */
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * Retorna el último nodo de la lista
     * @return el último nodo de la lista
     */
    public Nodo getpLast() {
        return pLast;
    }

    /**
     * Establece el último nodo de la lista
     * @param pLast el último nodo a ser establecido
     */
    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    /**
     * Obtiene el tamaño de la lista
     * @return tamaño de la lista
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño de la lista
     * @param size el tamaño a ser establecido
     */
    public void setSize(int size) {
        this.size = size;
    }

   
    
}