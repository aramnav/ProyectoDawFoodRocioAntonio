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
        //menuInicial();

    }

    private static String generarContrasena() {
        String caracteresMayuscula = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String caracteresMinuscula = "abcdefghijklmnopqrstuvwxyz";
        String caracteresNumeros = "0123456789";
        String caracteresEspeciales = "!@#$^&()_=+-*/%<>?[]{}";

        Random random = new Random();
        StringBuilder contraseña = new StringBuilder();

        // Añadir al menos uno de cada
        int indiceMinuscula = random.nextInt(caracteresMinuscula.length());
        contraseña.append(caracteresMinuscula.charAt(indiceMinuscula));
        int indiceMayuscula = random.nextInt(caracteresMinuscula.length());
        contraseña.append(caracteresMayuscula.charAt(indiceMayuscula));
        int indiceNumeros = random.nextInt(caracteresNumeros.length());
        contraseña.append(caracteresNumeros.charAt(indiceNumeros));
        int indiceEspeciales = random.nextInt(caracteresEspeciales.length());
        contraseña.append(caracteresEspeciales.charAt(indiceEspeciales));

        // Añadir el resto de la contraseña
        for (int i = 1; i < 3; i++) {
            String caracteres = caracteresMayuscula + caracteresMinuscula + caracteresNumeros;
            int indice = random.nextInt(caracteres.length());
            char caracter = caracteres.charAt(indice);
            contraseña.append(caracter);
        }

        return contraseña.toString();
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

    private static boolean verificarContrasena(String contrasenya) {
        boolean valida = true;

        do {
            String entradaUsuario = JOptionPane.showInputDialog("Introduce la contraseña: ");

            if (entradaUsuario.equals(contrasenya)) {
                JOptionPane.showMessageDialog(null, "Contraseña correcta");
                valida = true;
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                valida = false;

            }

        } while (!valida);

        return valida;

    }

    public static void menuAdministrador() {
        int Admin = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Admin\n\n 1.Cambiar datos\n 2.Dar de alta productos nuevos\n 3.Borrar "
                + "productos\n 4.Consultar ventas\n 5.Consultar direccion o fecha\n 6.Salir"));
        switch (Admin) {
            case 1:
                JOptionPane.showMessageDialog(null, "Cambiar datos de los productos");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Dar de alta productos nuevos");
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Borrar productos");
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "Consultar ventas");
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "Consultar direccion o fecha");
                break;
            default:
                JOptionPane.showInputDialog(null, "Opcion Incorrecta");
        }

    }

    public static void subMenuConsultarVentas() {

        int ConsultaVentas = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Consultar ventas\n\n 1.En día concreto\n 2.Hasta una fecha\n 3.Ver todas las ventas\n 4.Salir"));
        switch (Admin) {
            case 1:
                JOptionPane.showMessageDialog(null, "Día concreto");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Hasta una fecha");
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Ver todas las ventas");
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "Salir");
                break;
            default:
                JOptionPane.showInputDialog(null, "Opcion Incorrecta");
        }
    }

}
