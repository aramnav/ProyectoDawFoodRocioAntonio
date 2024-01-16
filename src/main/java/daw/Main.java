/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package daw;

import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class Main {

    public static void main(String[] args) {

        int opcionMenuPrincipal = Integer.parseInt(JOptionPane.showInputDialog("""
                                    1.- MODO USUARIO
                                    2.- MODO ADMINISTRADOR
                                    """));

        int opcionMenuUsuario = Integer.parseInt(JOptionPane.showInputDialog("""
                                    1.- Ver comida
                                    2.- Ver bebidas
                                    3.- Ver postres
                                    4.- Ver carrito                                         
                                    """));

        
        
        
        
        
        
        
        
        
        
        int opcionMenuAdmin = Integer.parseInt(JOptionPane.showInputDialog("""
                                    1.- Cambiar datos productos
                                    2.- Añadir Productos
                                    3.- Borrar Productos
                                    4.- Consultar Ventas
                                    5.- Consultar direccion o fecha
                                    """));
        
        int opcionConsultarVentas = Integer.parseInt(JOptionPane.showInputDialog("""
                                    1.- En un dia concreto
                                    2.- Hasta una fecha
                                    3.- Ver todas las ventas                                             
                                    """));

    }
}
