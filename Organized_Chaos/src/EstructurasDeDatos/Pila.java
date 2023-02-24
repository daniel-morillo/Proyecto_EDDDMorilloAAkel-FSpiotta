/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * Esta clase corresponde a una pila y todos sus métodos
 * @author Fabrizio Spiotta, Georgina Akel, Daniel Morillo
 * @param <T>
 */
public class Pila<T> {
    private Nodo<T> pCima;
    private int size;
    
    /**
     *Constructor de la clase Pila
     */
    public Pila() {
        size = 0;
        pCima = null;
    }
    
    /**
     *Destructor de la clase Pila
     */
    public void destructor() {
        while (pCima != null) {
            pCima = pCima.getpNext();
        }
    }
    
    /**
     * Método que indica si la pila está vacía
     * @return Verdadero/Falso
     */
    public boolean esVacio() {
        return size == 0;
    }
    
    /**
     * Método para apilar en la pila
     * @param valor El valor que quiere ser apilado
     */
    public void apilar(T valor) {
        Nodo<T> pNew = new Nodo(valor);
        pNew.setpNext(pCima);
        pCima = pNew;
        size ++;
    }
    
    /**
     * Método que desapila elprimer valor de la pila
     */
    public void desapilar() {
        pCima = pCima.getpNext();
        size --;
    }
    
    /**
     * Método que devuelve el valor del primer elemento de la pila
     * @return valor del primer elemento
     */
    public T leerCima() {
        return pCima.getElemento();
    }
    
    /**
     * Método que desapila y devuelve el valor del nodo desapilado
     * @return valor del nodo desapilado
     */
    public T pop() {
        Nodo<T> aux = pCima;
        pCima = pCima.getpNext();
        size --;
        return aux.getElemento();  
    }

    /**
     * Método que devuelve el nodo que se encuentra en la cima
     * @return Nodo de la cima
     */
    public Nodo<T> getpCima() {
        return pCima;
    }

    /**
     * Método que establece la cima de la pila
     * @param pCima Nodo que se quiere establecer en la cima
     */
    public void setpCima(Nodo<T> pCima) {
        this.pCima = pCima;
    }

    /**
     * Método que devuelve el tamaño de la pila
     * @return tamaño de la pila
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño de la pila
     * @param size el tamaño que se le quiere asignar
     */
    public void setSize(int size) {
        this.size = size;
    }  
}
