/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

/**
 *
 * @author antonio
 */
public class Productos {
       
    int idProducto;
    Categoria categoria;
   // Subcategoria subcategoria;
    double precio;
    int iva;    
    int stock;

    public Productos(int idProducto, Categoria categoria, double precio, int iva, int stock) {
        this.idProducto = idProducto;
        this.categoria = categoria;
        this.precio = precio;
        this.iva = iva;
        this.stock = stock;
    }

    public Productos() {
    }
    
    
    
    
    
    
}
