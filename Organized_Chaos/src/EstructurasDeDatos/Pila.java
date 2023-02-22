/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 *
 * @author fabriziospiotta
 */
public class Pila<T> {
    private Nodo<T> pCima;
    private int size;
    
    public Pila() {
        size = 0;
        pCima = null;
    }
    
    public void destructor() {
        while (pCima != null) {
            Nodo<T> aux = pCima;
            pCima = pCima.getpNext();
        }
    }
    
    public boolean esVacio() {
        return size == 0;
    }
    
    public void apilar(T valor) {
        Nodo<T> pNew = new Nodo(valor);
        pNew.setpNext(pCima);
        pCima = pNew;
        size ++;
    }
    
    public void desapilar() {
        Nodo<T> aux = pCima;
        pCima = pCima.getpNext();
        size --;
    }
    
    public T leerCima() {
        return pCima.getElemento();
    }
    
    public T pop() {
        Nodo<T> aux = pCima;
        pCima = pCima.getpNext();
        size --;
        return aux.getElemento();  
    }

    /**
     * @return the pCima
     */
    public Nodo<T> getpCima() {
        return pCima;
    }

    /**
     * @param pCima the pCima to set
     */
    public void setpCima(Nodo<T> pCima) {
        this.pCima = pCima;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    
    
}
