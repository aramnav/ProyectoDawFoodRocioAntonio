package daw;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rocio
 */
public class Tarjeta {

    private String ultimosCuatroDigitos;
    private String fechaCaducidad;
    private String cvv;

    public Tarjeta(String ultimosCuatroDigitos, String fechaCaducidad, String cvv) {
    this.ultimosCuatroDigitos = ultimosCuatroDigitos;
    this.fechaCaducidad = fechaCaducidad;
    this.cvv = cvv;
    tarjetasRegistradas.put(ultimosCuatroDigitos, this);
}
    private static Map<String, Tarjeta> tarjetasRegistradas = new HashMap<>();

    public Tarjeta() {
    }
   
    public String getUltimosCuatroDigitos() {
        return ultimosCuatroDigitos;
    }

    public void setUltimosCuatroDigitos(String ultimosCuatroDigitos) {
        this.ultimosCuatroDigitos = ultimosCuatroDigitos;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
 public boolean verificarTarjeta(String ultimosCuatroDigitos) {
    return tarjetasRegistradas.containsKey(ultimosCuatroDigitos);
        }

       public boolean procesarTransaccion(double monto) {
    if (this.getFechaCaducidad().equals("01/25") && this.getCvv().equals("123")) {
        double saldoDisponible = obtenerSaldoDeLaTarjeta();
        if (saldoDisponible >= monto) {
            emitirTicket();
            return true;
        }
    }
        return false;
       }       
        private double obtenerSaldoDeLaTarjeta() {
            return 1000.0;
        }

        private void emitirTicket() {
            System.out.println("Imprimiendo ticket.");
        }
        

    public static void realizarTransaccion() {
        String ultimosCuatroDigitos = obtenerEntrada("Ingrese los últimos 4 dígitos de su tarjeta: ");
        while (!esNumeroDeCuatroDigitos(ultimosCuatroDigitos)) {
            mostrarMensaje("Número de tarjeta inválido. Por favor, inténtelo de nuevo.");
            ultimosCuatroDigitos = obtenerEntrada("Ingrese los últimos 4 dígitos de su tarjeta: ");
        }

        Tarjeta tj1 = new Tarjeta(ultimosCuatroDigitos, "", "");

        if (tj1.verificarTarjeta(ultimosCuatroDigitos)) {
            Tarjeta tarjeta = new Tarjeta(ultimosCuatroDigitos, "", "");

            String fechaCaducidad = obtenerEntrada("Ingrese la fecha de caducidad (MM/YY): ");
            while (!esFechaValida(fechaCaducidad)) {
                mostrarMensaje("Fecha de caducidad inválida. Por favor, inténtelo de nuevo.");
                fechaCaducidad = obtenerEntrada("Ingrese la fecha de caducidad (MM/YY): ");
            }
            tarjeta.setFechaCaducidad(fechaCaducidad);

            String cvv = obtenerEntrada("Ingrese el CVV: ");
            while (cvv.length() != 3 || !esNumero(cvv)) {
                mostrarMensaje("CVV inválido. Debe tener exactamente 3 dígitos. Por favor, inténtelo de nuevo.");
                cvv = obtenerEntrada("Ingrese el CVV: ");
            }
            tarjeta.setCvv(cvv);

            double montoCompra;
            do {
                String montoString = obtenerEntrada("Ingrese el monto de la compra: ");
                try {
                    montoCompra = Double.parseDouble(montoString);
                    if (montoCompra <= 0) {
                        mostrarMensaje("El monto debe ser mayor a cero. Por favor, inténtelo de nuevo.");
                    }
                } catch (NumberFormatException e) {
                    mostrarMensaje("Ingrese un monto válido. Por favor, inténtelo de nuevo.");
                    montoCompra = -1;
                }
            } while (montoCompra <= 0);

            if (tarjeta.procesarTransaccion(montoCompra)) {
                mostrarMensaje("Compra realizada");
            } else {
                mostrarMensaje("La transacción ha sido cancelada. Por favor, inténtelo de nuevo.");
            }
        } else {
            mostrarMensaje("Tarjeta no válida. La transacción ha sido cancelada. Por favor, inténtelo de nuevo.");
        }
    }

    private static String obtenerEntrada(String mensaje) {
        return JOptionPane.showInputDialog(null, mensaje);
    }

    private static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static boolean esNumeroDeCuatroDigitos(String numero) {
        return numero.matches("\\d{4}");
    }

    private static boolean esFechaValida(String fecha) {
        return fecha.matches("(0[1-9]|1[0-2])/\\d{2}");
    }

    private static boolean esNumero(String str) {
        return str.matches("\\d+");
    }

    private static boolean mostrarConfirmacion(String mensaje) {
        int opcion = JOptionPane.showConfirmDialog(null, mensaje, "Confirmación", JOptionPane.YES_NO_OPTION);
        return opcion == JOptionPane.YES_OPTION;
    }

   static void realizarTransaccionLoop() {
        boolean realizarOtraTransaccion;
        do {
            realizarTransaccion();

            realizarOtraTransaccion = mostrarConfirmacion("¿Desea realizar otra transacción?");
        } while (realizarOtraTransaccion);
    }
    }

