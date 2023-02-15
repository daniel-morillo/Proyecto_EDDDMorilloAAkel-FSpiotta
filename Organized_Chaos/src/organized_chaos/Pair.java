/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package organized_chaos;

/**
 *
 * @author fabriziospiotta
 */
public class Pair {
    private int distance;
    private int numeroVertice;

    public Pair(int distance, int numeroVertice){
        this.distance = distance;
        this.numeroVertice = numeroVertice;
        
    }
    
    /**
     * @return the distance
     */
    public int getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * @return the numeroVertice
     */
    public int getNumeroVertice() {
        return numeroVertice;
    }

    /**
     * @param numeroVertice the numeroVertice to set
     */
    public void setNumeroVertice(int numeroVertice) {
        this.numeroVertice = numeroVertice;
    }
    
    
}
