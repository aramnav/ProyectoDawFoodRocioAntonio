/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antonio Ramírez
 */
public class Funciones {

    public static List<Producto> crearCarta() {

        List<Producto> carta = new ArrayList<>();

        carta.add(new Producto("Solomillo de cerdo", Categoria.COMIDA, Subcategoria.CARNE));
        carta.add(new Producto("Secreto iberico", Categoria.COMIDA, Subcategoria.CARNE));
        carta.add(new Producto("Pinchitos de pollo", Categoria.COMIDA, Subcategoria.CARNE));
        carta.add(new Producto("Abadejo", Categoria.COMIDA, Subcategoria.PESCADO));
        carta.add(new Producto("Calamares", Categoria.COMIDA, Subcategoria.PESCADO));
        carta.add(new Producto("Gambas al pil pil", Categoria.COMIDA, Subcategoria.PESCADO));
        carta.add(new Producto("Ensalada mixta", Categoria.COMIDA, Subcategoria.VERDURA));
        carta.add(new Producto("Ensalada César", Categoria.COMIDA, Subcategoria.VERDURA));
        carta.add(new Producto("Revuelto de espárragos", Categoria.COMIDA, Subcategoria.VERDURA));
        carta.add(new Producto("Fanta", Categoria.BEBIDA, Subcategoria.REFRESCO));
        carta.add(new Producto("Coca-Cola", Categoria.BEBIDA, Subcategoria.REFRESCO));
        carta.add(new Producto("Nesteá", Categoria.BEBIDA, Subcategoria.REFRESCO));
        carta.add(new Producto("Cerveza", Categoria.BEBIDA, Subcategoria.ALCOHOLICA));
        carta.add(new Producto("Vino tinto", Categoria.BEBIDA, Subcategoria.ALCOHOLICA));
        carta.add(new Producto("Whisky", Categoria.BEBIDA, Subcategoria.ALCOHOLICA));
        carta.add(new Producto("Zumo de piña", Categoria.BEBIDA, Subcategoria.ZUMO));
        carta.add(new Producto("Zumo de melocotón", Categoria.BEBIDA, Subcategoria.ZUMO));
        carta.add(new Producto("Zumo de naranja", Categoria.BEBIDA, Subcategoria.ZUMO));
        carta.add(new Producto("Zumo de manzana", Categoria.BEBIDA, Subcategoria.ZUMO));
        carta.add(new Producto("Agua con gas", Categoria.BEBIDA, Subcategoria.AGUA));
        carta.add(new Producto("Agua sin gas", Categoria.BEBIDA, Subcategoria.AGUA));
        carta.add(new Producto("Tarta de queso", Categoria.POSTRE, Subcategoria.NULL));
        carta.add(new Producto("Helado", Categoria.POSTRE, Subcategoria.NULL));
        carta.add(new Producto("Natillas", Categoria.POSTRE, Subcategoria.NULL));
        carta.add(new Producto("Arroz con leche", Categoria.POSTRE, Subcategoria.NULL));

        return carta;

    }

    public static List<Producto> crearLista(List<Producto> carta, Categoria c, Subcategoria s) {

        List<Producto> lista = new ArrayList<>();

        for (Producto producto : carta) {
            if (producto.getCategoria() == c && producto.getSubcategoria() == s) {
                lista.add(producto);
            }

        }
        return lista;
    }

    public static void mostrarLista(List<Producto> lista) {

        for (Producto p : lista) {
            System.out.println(p);
        }

    }

    public static void anadirProducto(List<Producto> carta, String nombre, Categoria c, Subcategoria s) {

        Producto p1 = new Producto(nombre, c, s);

        if (p1.getCategoria() == null || p1.getSubcategoria() == null) {
            System.out.println("No se ha podido añadir el producto porque no era válido");
        } else {
            carta.add(p1);
        }

    }

    public static void main(String[] messi) {

        List<Producto> carta = crearCarta();

        Funciones.mostrarLista(carta);
        anadirProducto(carta, "Pinchitos de cerdo", Categoria.COMIDA, Subcategoria.CARNE);
        System.out.println("----------------------------------------");
        Funciones.mostrarLista(carta);

    }

}
