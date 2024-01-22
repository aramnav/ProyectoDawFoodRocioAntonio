/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonio Ramírez
 */
public class Carrito {

    private List<Producto> carrito;

    public Carrito() {
    }

    public List<Producto> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<Producto> carrito) {
        this.carrito = carrito;
    }

    public static void anadirCarrito(List<Producto> carrito, Producto p ){
        carrito.add(p);
    }
    
    public static void verCarrito(List<Producto> carrito){
        
        
        
        
        
    }
    
    
    
    
    
    
}
