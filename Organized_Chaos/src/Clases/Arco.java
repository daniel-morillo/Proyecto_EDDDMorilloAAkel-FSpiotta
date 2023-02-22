/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author fabriziospiotta
 */
public class Arco {
    
    //private int destino; // Numero del vertice destino
    private int distancia;
    private String verticeOrigenNombre;
    private String verticeDestinoNombre;
    private int verticeDestinoNumero;
    
    //Constructor
    
    public Arco(int distancia, String verticeOrigenNombre, String verticeDestinoNombre, int verticeDestinoNumero) {
        //this.destino = destino;
        this.distancia = distancia;
        this.verticeOrigenNombre = verticeOrigenNombre;
        this.verticeDestinoNombre = verticeDestinoNombre;
        this.verticeDestinoNumero = verticeDestinoNumero;   
    }
    
    public Arco(String verticeOrigenNombre, String verticeDestinoNombre, int distancia) {
        //this.destino = destino;
        this.distancia = distancia;
        this.verticeOrigenNombre = verticeOrigenNombre;
        this.verticeDestinoNombre = verticeDestinoNombre;
        //this.verticeDestinoNumero = verticeDestinoNumero;   
    }
    
    // Metodos
    
//    public boolean equals(Arco n){
//        return this.destino == n.destino;
//    }

    
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
     * @return the verticeOrigenNombre
     */
    public String getVerticeOrigenNombre() {
        return verticeOrigenNombre;
    }

    /**
     * @param verticeOrigenNombre the verticeOrigenNombre to set
     */
    public void setVerticeOrigenNombre(String verticeOrigenNombre) {
        this.verticeOrigenNombre = verticeOrigenNombre;
    }

    /**
     * @return the verticeDestinoNombre
     */
    public String getVerticeDestinoNombre() {
        return verticeDestinoNombre;
    }

    /**
     * @param verticeDestinoNombre the verticeDestinoNombre to set
     */
    public void setVerticeDestinoNombre(String verticeDestinoNombre) {
        this.verticeDestinoNombre = verticeDestinoNombre;
    }

    /**
     * @return the verticeDestinoNumero
     */
    public int getVerticeDestinoNumero() {
        return verticeDestinoNumero;
    }

    /**
     * @param verticeDestinoNumero the verticeDestinoNumero to set
     */
    public void setVerticeDestinoNumero(int verticeDestinoNumero) {
        this.verticeDestinoNumero = verticeDestinoNumero;
    }
    


    
    
   
    
}
