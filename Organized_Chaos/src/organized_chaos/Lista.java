/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package organized_chaos;

/**
 *
 * @author fabriziospiotta
 */
public class Lista<T> {
    
    private Nodo pFirst;
    private Nodo pLast;
    private int size;
    
    public Lista() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }
    
    
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
    
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    
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
    
    public void Delete(T element){
        if (!isEmpty()) {
            if (pFirst.getElemento() == element) {
                pFirst = pFirst.getpNext();
                size -=1;
            }else {
                Nodo aux = pFirst;
                for (int i = 0; i < size; i++) {
                    if (aux.getpNext() != null) {
                        if (aux.getpNext().getElemento() == element) {
                        aux.setpNext(aux.getpNext().getpNext());
                        size -= 1;
                        }
                    }
                    aux = aux.getpNext();
                }    
            }
        }
    }
    
    public void DeleteObjeto(T element){
        if (!isEmpty()) {
            if (pFirst == element) {
                pFirst = pFirst.getpNext();
                size -=1;
            }else {
                Nodo aux = pFirst;
                for (int i = 0; i < size; i++) {
                    if (aux.getpNext() != null) {
                        if (aux.getpNext() == element) {
                        aux.setpNext(aux.getpNext().getpNext());
                        size -= 1;
                        }
                    }
                    aux = aux.getpNext();
                }    
            }
        }
    }
    
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
     * @return the pFirst
     */
    public Nodo getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the pLast
     */
    public Nodo getpLast() {
        return pLast;
    }

    /**
     * @param pLast the pLast to set
     */
    public void setpLast(Nodo pLast) {
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