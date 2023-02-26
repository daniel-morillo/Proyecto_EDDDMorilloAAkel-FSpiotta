/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import EstructurasDeDatos.Lista;

/**
 * Esta clase contiene las distancias mas cortas guaradas y la lista de las rutas recorridas. Esa union es la que se denomina Pareja. Se emplea solo para el algortimo de djikstra y para mostrar las rutas en la interfaz de realizar pedido
 * @author Fabrizio Spiotta, Georgina Akel, Daniel Morillo
 */
public class Pareja {
    
    private int distancia;
    private Lista listaRutas;

    public Pareja(int distancia, Lista listaRutas) {
        this.distancia = distancia;
        this.listaRutas = listaRutas;
    }

    /**
     * @return the distancia
     */
    public int getDistancia() {
        return distancia;
    }

    /**
     * @param distancia the distancia to set
     */
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    /**
     * @return the listaRutas
     */
    public Lista getListaRutas() {
        return listaRutas;
    }

    /**
     * @param listaRutas the listaRutas to set
     */
    public void setListaRutas(Lista listaRutas) {
        this.listaRutas = listaRutas;
    }
    
    
}
