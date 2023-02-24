/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 * Esta clase contiene la sintáxis y procedimientos competentes para la creación de arcos para ser implementados en el grafo.
 * @author Fabrizio Spiotta, Georgina Akel, Daniel Morillo
 */
public class Arco {
    
    private int distancia;
    private String verticeOrigenNombre;
    private String verticeDestinoNombre;
    private int verticeDestinoNumero;
    
    /**
     * Constructor de la clase Arco
     * @param verticeOrigenNombre Define el nombre del vértice origen
     * @param verticeDestinoNombre Define el nombre del vértice destino
     * @param distancia Corresponde a la distancia entre el vértice de origen y el vértice de destino
     * @param verticeDestinoNumero Define el número del vértice destino
     */
    public Arco(int distancia, String verticeOrigenNombre, String verticeDestinoNombre, int verticeDestinoNumero) {
        //this.destino = destino;
        this.distancia = distancia;
        this.verticeOrigenNombre = verticeOrigenNombre;
        this.verticeDestinoNombre = verticeDestinoNombre;
        this.verticeDestinoNumero = verticeDestinoNumero;   
    }
    
    
    /**
     * Constructor de la clase Arco
     * @param verticeOrigenNombre Define el nombre del vértice origen
     * @param verticeDestinoNombre Define el nombre del vértice destino
     * @param distancia Corresponde a la distancia entre el vértice de origen y el vértice de destino
     */
    public Arco(String verticeOrigenNombre, String verticeDestinoNombre, int distancia) {
        
        this.distancia = distancia;
        this.verticeOrigenNombre = verticeOrigenNombre;
        this.verticeDestinoNombre = verticeDestinoNombre; 
    }
    
    // Metodos
    

    
    /**
     * Método que devuelve la distancia
     * @return the distancia
     */
    public int getDistancia() {
        return distancia;
    }

    /**
     * Método que establece la distancia
     * @param distancia la distancia que será establecida
     */
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    /**
     * Método que devuelve el nombre del vértice origen
     * @return the verticeOrigenNombre
     */
    public String getVerticeOrigenNombre() {
        return verticeOrigenNombre;
    }

    /**
     * Método que establece el nombre del vértice origen
     * @param verticeOrigenNombre the verticeOrigenNombre to set
     */
    public void setVerticeOrigenNombre(String verticeOrigenNombre) {
        this.verticeOrigenNombre = verticeOrigenNombre;
    }

    /**
     * Método que devuelve el nombre del vértice destino
     * @return the verticeDestinoNombre
     */
    public String getVerticeDestinoNombre() {
        return verticeDestinoNombre;
    }

    /**
     * Método que establece el nombre del vértice destino
     * @param verticeDestinoNombre the verticeDestinoNombre to set
     */
    public void setVerticeDestinoNombre(String verticeDestinoNombre) {
        this.verticeDestinoNombre = verticeDestinoNombre;
    }

    /**
     * Métotodo que devuelve el número del vértice destino
     * @return the verticeDestinoNumero
     */
    public int getVerticeDestinoNumero() {
        return verticeDestinoNumero;
    }

    /**
     * Método que establece el número del vértice destino
     * @param verticeDestinoNumero the verticeDestinoNumero to set
     */
    public void setVerticeDestinoNumero(int verticeDestinoNumero) {
        this.verticeDestinoNumero = verticeDestinoNumero;
    }
    
       
}
