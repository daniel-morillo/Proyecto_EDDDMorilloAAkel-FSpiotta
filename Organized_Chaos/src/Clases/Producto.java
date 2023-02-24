/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 * Esta clase corresponde a los productos dispuestos en los almacenes
 * @author Fabrizio Spiotta, Georgina Akel, Daniel Morillo
 */
public class Producto {
    
    private String nombre;
    private int stock;

    /**
     * Constructor de la clase Producto
     * @param nombre Se refiere al nombre del producto
     * @param stock Se refiere a la cantidad disponible inicialmente del producto en cuestión
     */
    public Producto(String nombre, int stock) {
        this.nombre = nombre;
        this.stock = stock;
    }
    

    /**
     * Método que devuelve el nombre del producto
     * @return el nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que establece el nombre del producto
     * @param nombre el nombre que será establecido
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que devuelve el stock disponible del producto
     * @return el stock del producto
     */
    public int getStock() {
        return stock;
    }

    /**
     * Método que establece el stock del producto
     * @param stock el stock a ser establecido para ese producto
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
       
}
