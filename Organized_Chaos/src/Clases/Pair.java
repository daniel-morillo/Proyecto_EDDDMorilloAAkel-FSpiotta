/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 * En la Clase Pair se almacenan distancias y vértices, esa unión es la que se denomina pair. Se emplea solo para el algoritmo de Djikstra
 * @author Fabrizio Spiotta, Georgina Akel, Daniel Morillo
 */
public class Pair {
    private int distance;
    private int numeroVertice;

    /**
     * Constructor de la clase Pair
     * @param distance corresponde a la distancia
     * @param numeroVertice corresponde al número de vértice
     */
    public Pair(int distance, int numeroVertice){
        this.distance = distance;
        this.numeroVertice = numeroVertice;
        
    }
    
    /**
     * Método que retorna la distancia del pair
     * @return la distancia
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Método que establece la distancia del pair
     * @param distance la distancia que será establecida en el pair
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * Método que retorna el número de vértice del pair
     * @return El número del vértice
     */
    public int getNumeroVertice() {
        return numeroVertice;
    }

    /**
     * Método que establece el número de vértice del pair
     * @param numeroVertice el número de vértice a ser establecido
     */
    public void setNumeroVertice(int numeroVertice) {
        this.numeroVertice = numeroVertice;
    }
    
    
}
