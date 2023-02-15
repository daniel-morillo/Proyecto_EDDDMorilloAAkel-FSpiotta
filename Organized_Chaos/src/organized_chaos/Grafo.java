/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package organized_chaos;

/**
 *
 * @author fabriziospiotta
 */
public class Grafo {
    
    private int numeroDeVertices;
    //private int sizeVerts;
    private Lista listaPrincipal;
    
    public Grafo(int n) {
        this.numeroDeVertices = 0;
       // this.sizeVerts = n;
        this.listaPrincipal = new Lista();
    }
    
    public Grafo() {
        this.numeroDeVertices = 0;
        //this.sizeVerts = 0;
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
                Nodo<Arco> aux2 = aux.getElemento().getListaDeAdyacencia().getpFirst();
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
    
    public void insertarVertice(String nombre, int numVertice){
        Vertice newVertice = new Vertice(nombre, numVertice);
        if (this.esVacio()) {
            listaPrincipal.AppendAtTheEnd(newVertice);
            numeroDeVertices ++;
        }
        else {
            Nodo<Vertice> aux = listaPrincipal.getpFirst();
            boolean encontrado = false;
            for (int i = 0; i < this.getNumeroDeVertices(); i++) {
                if (aux.getElemento().getNombre().equals(newVertice.getNombre())) {
                    encontrado = true;
                }
            }
            if (encontrado == false) {
                listaPrincipal.AppendAtTheEnd(newVertice);
                numeroDeVertices ++;
            }
        }
    }
    
    public void insertarArco(int distancia, String verticeOrigenNombre, String verticeDestinoNombre, int verticeDestinoNumero) {
        if (!this.esVacio() && this.adyacente(verticeOrigenNombre, verticeDestinoNombre) == false) {
            Arco newArco = new Arco(distancia, verticeOrigenNombre, verticeDestinoNombre, verticeDestinoNumero);
            Nodo<Vertice> aux = listaPrincipal.getpFirst();
            for (int i = 0; i < listaPrincipal.getSize(); i++) {
                if (aux.getElemento().getNombre().equals(verticeOrigenNombre)) {
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
