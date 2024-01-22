/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
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

    public static List<Producto> crearLista(List<Producto> carta, Categoria c) {

        List<Producto> lista = new ArrayList<>();

        for (Producto producto : carta) {
            if (producto.getCategoria() == c) {
                lista.add(producto);
            }

        }
        return lista;
    }

    public static List<String> mostrarLista(List<Producto> carta) {
        List<String> cartaConFormato = new ArrayList<>();

        for (Producto producto : carta) {

            String formato = """
                             %s Id:%d %s %s Precio:%.2f€ Iva:%.2f Stock:%d
                             """.formatted(producto.getDescripcion(),
                    producto.getIdProducto(), producto.getCategoria(),
                    producto.getSubcategoria(), producto.getPrecio(),
                    producto.getIva().getTasa(), producto.getStock());

            formato = formato.replace(",", ".");

            cartaConFormato.add(formato);
        }

        return cartaConFormato;
    }

    private static Producto mostrarMenuDesplegable(List<Producto> carta) {
        String[] opciones = new String[carta.size()];
        for (int i = 0; i < carta.size(); i++) {
            opciones[i] = carta.get(i).getDescripcion();
        }

        String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione un producto:", "Menú",
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        Producto productoADevolver = null;

        for (Producto producto : carta) {
            if (producto.getDescripcion().equals(seleccion)) {
                productoADevolver = producto;
                break;
            }
        }

        return productoADevolver;

    }

    public static List<String> mostrarId(List<Producto> carta) {
        List<String> formato = new ArrayList<>();

        for (Producto producto : carta) {
            String vale = """
                         "El id de %s es %d
                         """.formatted(producto.getDescripcion(), producto.getIdProducto());
            formato.add(vale);
        }
        return formato;
    }

    public static void anadirProducto(List<Producto> carta, String nombre, Categoria c, Subcategoria s) {

        Producto p1 = new Producto(nombre, c, s);

        if (p1.getCategoria() == null || p1.getSubcategoria() == null) {
            JOptionPane.showMessageDialog(null, "Producto no válido");
        } else {
            carta.add(p1);
            JOptionPane.showMessageDialog(null, "Producto añadido");
        }

    }

    public static void anadirProductoExcepciones(List<Producto> carta) {
        Categoria[] categorias = Categoria.values();
        Subcategoria[] subcategorias = Subcategoria.values();
        Subcategoria subcategoriaSeleccionada = Subcategoria.AGUA;
        Categoria categoriaSeleccionada = Categoria.BEBIDA;
        String nombre = "";
        boolean valido = true;
        boolean valido2 = true;

        do {
            try {

                nombre = JOptionPane.showInputDialog(null, "Introduce el nombre del producto");

                categoriaSeleccionada = (Categoria) JOptionPane.showInputDialog(null, "Seleccione una categoría:",
                        "Selección de Categoría", JOptionPane.QUESTION_MESSAGE, null, categorias, categorias[0]);

                do {

                    switch (categoriaSeleccionada) {
                        case POSTRE ->
                            subcategoriaSeleccionada = (Subcategoria) JOptionPane.showInputDialog(null, "Seleccione una subcategoría:",
                                    "Selección de Subcategoría", JOptionPane.QUESTION_MESSAGE, null, subcategorias, subcategorias[0]);
                        case COMIDA ->
                            subcategoriaSeleccionada = (Subcategoria) JOptionPane.showInputDialog(null, "Seleccione una subcategoría:",
                                    "Selección de Subcategoría", JOptionPane.QUESTION_MESSAGE, null, subcategorias, subcategorias[0]);
                        case BEBIDA ->
                            subcategoriaSeleccionada = (Subcategoria) JOptionPane.showInputDialog(null, "Seleccione una subcategoría:",
                                    "Selección de Subcategoría", JOptionPane.QUESTION_MESSAGE, null, subcategorias, subcategorias[0]);

                    }

                    if (categoriaSeleccionada == Categoria.COMIDA && (subcategoriaSeleccionada == Subcategoria.CARNE || subcategoriaSeleccionada == Subcategoria.PESCADO || subcategoriaSeleccionada == Subcategoria.VERDURA)) {
                        valido2 = false;
                    } else {
                        JOptionPane.showMessageDialog(null, "Introduce una subcategoria válida");
                    }
                    if (categoriaSeleccionada == Categoria.BEBIDA && (subcategoriaSeleccionada == Subcategoria.AGUA || subcategoriaSeleccionada == Subcategoria.ALCOHOLICA || subcategoriaSeleccionada == Subcategoria.REFRESCO || subcategoriaSeleccionada == Subcategoria.ZUMO)) {
                        valido2 = false;
                    }
                    if (categoriaSeleccionada == Categoria.POSTRE && (subcategoriaSeleccionada == Subcategoria.NULL)) {
                        valido2 = false;
                    }

                } while (valido2);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
                valido = false;
            }
        } while (!valido);

        anadirProducto(carta, nombre, categoriaSeleccionada, subcategoriaSeleccionada);

    }

    public static void borrarProducto(List<Producto> carta, int id) {

        Iterator<Producto> iterator = carta.iterator();
        while (iterator.hasNext()) {
            Producto producto = iterator.next();
            if (producto.getIdProducto() == id) {
                iterator.remove();
                JOptionPane.showMessageDialog(null, "Producto con ID " + id + " eliminado");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró un producto con ID " + id);
    }

    public static void borrarProductoExcepciones(List<Producto> carta) {
        boolean valido = true;
        do {
            try {

                int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el id del producto a borrar" + mostrarId(carta)));
                borrarProducto(carta, id);
                valido = true;
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Introduce un id");
                valido = false;
            }
        } while (!valido);
    }

    private static void cambiarAtributos(Producto p) {

        String[] opcionesAtributos = {"Descripción", "Precio", "Stock"};
        int seleccionAtributo = JOptionPane.showOptionDialog(null, "Selecciona el atributo a cambiar", "Cambiar Atributo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesAtributos,
                opcionesAtributos[0]);

        if (seleccionAtributo >= 0) {
            String nuevoValorStr = JOptionPane.showInputDialog("Introduce el nuevo valor para " + opcionesAtributos[seleccionAtributo] + ":");

            switch (seleccionAtributo) {
                case 0 ->
                    p.setDescripcion(nuevoValorStr);
                case 1 -> {
                    double nuevoPrecio = Double.parseDouble(nuevoValorStr);
                    p.setPrecio(nuevoPrecio);
                }
                case 2 -> {
                    int nuevoStock = Integer.parseInt(nuevoValorStr);
                    p.setStock(nuevoStock);
                }
                default ->
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        }
    }

    public static void main(String[] messi) {

        List<Producto> carta = crearCarta();

        menuUsuario(carta);

    }

    private static String generarContrasena() {
        String caracteresMayuscula = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String caracteresMinuscula = "abcdefghijklmnopqrstuvwxyz";
        String caracteresNumeros = "0123456789";
        String caracteresEspeciales = "!@#$^&()_=+-*/%<>?[]{}";

        Random random = new Random();
        StringBuilder contraseña = new StringBuilder();

        int indiceMinuscula = random.nextInt(caracteresMinuscula.length());
        contraseña.append(caracteresMinuscula.charAt(indiceMinuscula));
        int indiceMayuscula = random.nextInt(caracteresMinuscula.length());
        contraseña.append(caracteresMayuscula.charAt(indiceMayuscula));
        int indiceNumeros = random.nextInt(caracteresNumeros.length());
        contraseña.append(caracteresNumeros.charAt(indiceNumeros));
        int indiceEspeciales = random.nextInt(caracteresEspeciales.length());
        contraseña.append(caracteresEspeciales.charAt(indiceEspeciales));

        for (int i = 1; i < 3; i++) {
            String caracteres = caracteresMayuscula + caracteresMinuscula + caracteresNumeros;
            int indice = random.nextInt(caracteres.length());
            char caracter = caracteres.charAt(indice);
            contraseña.append(caracter);
        }

        return contraseña.toString();
    }

    public static void menuInicial(List<Producto> carta) {
        String[] seleccion = {"Usuario", "Administrador", "Salir"};
        int opcion = 0;
        do {

            try {
                opcion = JOptionPane.showOptionDialog(null, "Elige una opcion", "Eleccion",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, seleccion, seleccion[0]);

                switch (opcion) {
                    case 0 ->
                        menuUsuario(carta);
                    case 1 -> {
                        String contrasena = generarContrasena();
                        System.out.println(contrasena);
                        verificarContrasena(contrasena);
                        menuAdministrador(carta);
                    }
                }
            } catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(null, "Has cerrado el programa");
            }
        } while (opcion != 2);
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

    public static void menuAdministrador(List<Producto> carta) {
        String[] eleccionAdmin = {"Cambiar datos", "Añadir producto", "Borrar producto", "Consultar ventas", "Salir"};

        try {

            int admin = JOptionPane.showOptionDialog(null, "Elige una accion",
                    "Eleccion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, eleccionAdmin, eleccionAdmin[0]);

            switch (admin) {
                case 0 -> {
                    Producto productoSeleccionado = mostrarMenuDesplegable(carta);
                    cambiarAtributos(productoSeleccionado);
                }
                case 1 ->
                    anadirProductoExcepciones(carta);
                case 2 ->
                    borrarProductoExcepciones(carta);
                case 3 ->
                    subMenuConsultarVentas();//Pendiente de hacer
            }
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, "Has cerrado el programa");
        }

    }

    public static void menuUsuario(List<Producto> carta) {
        String[] eleccionUsuario = {"Ver comidas", "Ver bebidas", "Ver postres", "Carrito", "Salir"};
        List<Producto> carrito = new ArrayList<>();
        int usuario = 0;
        do {

            try {

                usuario = JOptionPane.showOptionDialog(null, "Elige una opción",
                        "Eleccion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, eleccionUsuario, eleccionUsuario[0]);

                switch (usuario) {

                    case 0 ->
                        Carrito.anadirCarrito(carrito, mostrarMenuDesplegable(crearLista(carta, Categoria.COMIDA)));
                    case 1 ->
                        Carrito.anadirCarrito(carrito, mostrarMenuDesplegable(crearLista(carta, Categoria.BEBIDA)));
                    case 2 ->
                        Carrito.anadirCarrito(carrito, mostrarMenuDesplegable(crearLista(carta, Categoria.POSTRE)));
                    case 3 -> {
                        JOptionPane.showMessageDialog(null, "Ver carrito");
                        Carrito.verCarrito(carrito);
                    }
                }
            } catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(null, "Has cerrado el programa");
            }
        } while (usuario != 4);
    }

    public static void subMenuConsultarVentas() {

        int ConsultaVentas = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Consultar ventas\n\n 1.En día concreto\n 2.Hasta una fecha\n 3.Ver todas las ventas\n 4.Salir"));
        switch (ConsultaVentas) {
            case 1 ->
                JOptionPane.showMessageDialog(null, "Día concreto");
            case 2 ->
                JOptionPane.showMessageDialog(null, "Hasta una fecha");
            case 3 ->
                JOptionPane.showMessageDialog(null, "Ver todas las ventas");
            case 4 ->
                JOptionPane.showMessageDialog(null, "Salir");
            default ->
                JOptionPane.showInputDialog(null, "Opcion Incorrecta");
        }
    }

}
