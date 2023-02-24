/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import EstructurasDeDatos.Lista;

/**
 * Esta clase contiene a los vértices que conforman el grafo implementado por listas de adyacencia. En este caso los vértices son los almacenes
 * @author Fabrizio Spiotta, Georgina Akel, Daniel Morillo
 */
public class Vertice {
    
    private String nombre;
    private Lista listaDeProdutcos;
    private int numVertice;
    private Lista listaDeAdyacencia;
    
    
    /**
     * Constructor de la clase Vértice
     * @param nombre nombre del vértice
     * @param numVertice número del vértice
     */
    
    public Vertice(String nombre, int numVertice) {
        this.nombre = nombre;
        this.listaDeProdutcos = new Lista();
        this.numVertice = numVertice; 
        this.listaDeAdyacencia = new Lista();
    }
    

    /**
     * Método que devuelve el nombre del vértice
     * @return el nombre del vértice
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que establece el nombre del vértice
     * @param nombre el nombre a ser establecido
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que devuelve el número del vértice
     * @return el número del vértice
     */
    public int getNumVertice() {
        return numVertice;
    }

    /**
     * Método que establece el número del vértice
     * @param numVertice el número a ser establecido
     */
    public void setNumVertice(int numVertice) {
        this.numVertice = numVertice;
    }

    /**
     * Método que retorna la lista de adyacencia del vértice
     * @return la lista de adyacencia del vértice
     */
    public Lista getListaDeAdyacencia() {
        return listaDeAdyacencia;
    }

    /**
     * Método que asigna una lista de adyacencia al vértice
     * @param listaDeAdyacencia La lista de adyacencia a ser asignada
     */
    public void setListaDeAdyacencia(Lista listaDeAdyacencia) {
        this.listaDeAdyacencia = listaDeAdyacencia;
    }

    /**
     * Método que retorna la lista de productos al vértice (almacen)
     * @return la lista de productos del vértice o almacen
     */
    public Lista getListaDeProdutcos() {
        return listaDeProdutcos;
    }

    /**
     * Método que asigna una lista de productos al almacen
     * @param listaDeProdutcos la lista de productos a ser asignada al almacen
     */
    public void setListaDeProdutcos(Lista listaDeProdutcos) {
        this.listaDeProdutcos = listaDeProdutcos;
    }
    
    
}
