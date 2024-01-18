/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

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

    //Metodo admin
    public static void anadirProducto(List<Producto> carta, String nombre, Categoria c, Subcategoria s) {

        Producto p1 = new Producto(nombre, c, s);

        if (p1.getCategoria() == null || p1.getSubcategoria() == null) {
            JOptionPane.showMessageDialog(null, "El producto es erróneo");
        } else {
            carta.add(p1);
        }

    }

    private static String generarContrasena() {
        String caracteresMayuscula = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String caracteresMinuscula = "abcdefghijklmnopqrstuvwxyz";
        String caracteresNumeros = "0123456789";
        String caracteresEspeciales = "!@#$^&()_=+-*/%<>?[]{}";

        Random random = new Random();
        StringBuilder contrasena = new StringBuilder();

        // Añadir al menos uno de cada
        int indiceMinuscula = random.nextInt(caracteresMinuscula.length());
        contrasena.append(caracteresMinuscula.charAt(indiceMinuscula));
        int indiceMayuscula = random.nextInt(caracteresMinuscula.length());
        contrasena.append(caracteresMayuscula.charAt(indiceMayuscula));
        int indiceNumeros = random.nextInt(caracteresNumeros.length());
        contrasena.append(caracteresNumeros.charAt(indiceNumeros));
        int indiceEspeciales = random.nextInt(caracteresEspeciales.length());
        contrasena.append(caracteresEspeciales.charAt(indiceEspeciales));

        // Añadir el resto de la contraseña
        for (int i = 1; i < 3; i++) {
            String caracteres = caracteresMayuscula + caracteresMinuscula + caracteresNumeros;
            int indice = random.nextInt(caracteres.length());
            char caracter = caracteres.charAt(indice);
            contrasena.append(caracter);
        }

        return contrasena.toString();
    }

    private static boolean verificarContrasena(String contrasenya) {
        Scanner scanner = new Scanner(System.in);
        boolean valida = true;

        do {
            String entradaUsuario = JOptionPane.showInputDialog("Introduce la contraseña: ");

            if (entradaUsuario.equals(contrasenya)) {
                JOptionPane.showMessageDialog(null,"Contraseña correcta");
                valida = true;
            } else {
                JOptionPane.showMessageDialog(null,"Contraseña incorrecta");
                valida = false;
            }
        } while (!valida);

        return valida;
    }

    public static void llevarNavegacion() {

        int numDiapositivas = 0;
        String[] opciones = {"Admin", "Usuario"};

        switch (numDiapositivas) {
            //Menu eleccion admin
            case 0:

                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;

        }

    }

    public static void main(String[] messi) {

        List<Producto> carta = crearCarta();

        //Funciones.mostrarLista(carta);
        //anadirProducto(carta, "Pinchitos de cerdo", Categoria.COMIDA, Subcategoria.CARNE);
        //System.out.println("----------------------------------------");
        //Funciones.mostrarLista(carta);
        menuInicial();

    }

    public static void menuInicial() {

        String[] seleccion = {"Usuario", "Administrador"};

        int opcion = JOptionPane.showOptionDialog(null, "Elige una opcion", "Eleccion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, seleccion, seleccion[0]);

        switch (opcion) {
            case 0:
                System.out.println("Eres usuario");
                break;
            case 1:
                String contrasena = generarContrasena();
                System.out.println(contrasena);
                verificarContrasena(contrasena);
                    
                

                break;

        }
    }
    
    public static void menuAdministrador(String[] args) {
        
    }

}
