/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import EstructurasDeDatos.Lista;

/**
 *
 * @author fabriziospiotta
 */
public class Vertice {
    
    private String nombre;
    private Lista listaDeProdutcos;
    private int numVertice;
    private Lista listaDeAdyacencia;
    
    //Constructores
    
    public Vertice(String nombre, int numVertice) {
        this.nombre = nombre;
        this.listaDeProdutcos = new Lista();
        this.numVertice = numVertice; // porque no se que numero va a ser en mi grafo
        this.listaDeAdyacencia = new Lista();
    }
    

    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the numVertice
     */
    public int getNumVertice() {
        return numVertice;
    }

    /**
     * @param numVertice the numVertice to set
     */
    public void setNumVertice(int numVertice) {
        this.numVertice = numVertice;
    }

    /**
     * @return the listaDeAdyacencia
     */
    public Lista getListaDeAdyacencia() {
        return listaDeAdyacencia;
    }

    /**
     * @param listaDeAdyacencia the listaDeAdyacencia to set
     */
    public void setListaDeAdyacencia(Lista listaDeAdyacencia) {
        this.listaDeAdyacencia = listaDeAdyacencia;
    }

    /**
     * @return the listaDeProdutcos
     */
    public Lista getListaDeProdutcos() {
        return listaDeProdutcos;
    }

    /**
     * @param listaDeProdutcos the listaDeProdutcos to set
     */
    public void setListaDeProdutcos(Lista listaDeProdutcos) {
        this.listaDeProdutcos = listaDeProdutcos;
    }
    
    
}
