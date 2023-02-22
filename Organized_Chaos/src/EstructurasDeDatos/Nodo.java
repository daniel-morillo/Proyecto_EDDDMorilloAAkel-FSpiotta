/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 *
 * @author fabriziospiotta
 */
public class Nodo<T> {
    
    private T elemento;
    private Nodo pNext;

    public Nodo(T elemento, Nodo pNext) {
        this.elemento = elemento;
        this.pNext = pNext;
    }
    
    public Nodo(T elemento) {
        this.elemento = elemento;
        this.pNext = null;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public Nodo getpNext() {
        return pNext;
    }

    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }
        
}
