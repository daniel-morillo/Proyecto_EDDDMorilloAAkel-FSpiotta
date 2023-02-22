/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 *
 * @author fabriziospiotta
 */
public class Cola<T> {
    
    private Nodo<T> pFirst;
    private Nodo<T> pLast;
    private int size;
    
    public Cola(){
        pFirst = null;
        pLast = null;
        size = 0;
    }
    
    public boolean esVacia() {
        if (size == 0) {
            return true;
        }
        return false;
    }
    
    public void destructor() {
        //Nodo aux = this.getpFirst();
        while(pFirst!= null) {
            pFirst = pFirst.getpNext();
        }
    }
    
    public void encolar(T valor) {
        Nodo<T> pNew = new Nodo(valor);
        if (pFirst == null) {
            pFirst = pNew;
        } else {
            pLast.setpNext(pNew);
        }
        pLast = pNew;
        size ++; 
    }
    
    public void desencolar() {
        pFirst = pFirst.getpNext();
        size --;
        if (pFirst == null) {
            pLast = null;
        }
    }
    
    public T leerCabeza() {
        return pFirst.getElemento();
    }
    
    /**
     * @return the pFirst
     */
    public Nodo<T> getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(Nodo<T> pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the pLast
     */
    public Nodo<T> getpLast() {
        return pLast;
    }

    /**
     * @param pLast the pLast to set
     */
    public void setpLast(Nodo<T> pLast) {
        this.pLast = pLast;
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
