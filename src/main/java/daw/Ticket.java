package daw;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author rocio
 */
public class Ticket {

    Random r1 = new Random();

    private static int numeroPedido = 1; // cambiar para que no sea siempre uno
    private List<Integer> cantidades;
    private List<Producto> productosComprados;
    private int idTicket;
    private double precio;
    private LocalDate fecha;
    private LocalTime hora;

    public Ticket(List<Integer> cantidades, List<Producto> productosComprados, double precio) {
        this.cantidades = cantidades;
        this.productosComprados = productosComprados;
        this.idTicket = r1.nextInt(1000, 9999);
        this.precio = precio;
        this.fecha = LocalDate.now();
        this.hora = LocalTime.now();
    }

    public Ticket() {

    }

    public void imprimirTicket() {
        DecimalFormat dosDecimales = new DecimalFormat("#.##");
        StringBuilder ticketInfo = new StringBuilder();

        ticketInfo.append("Número de Pedido: ").append(numeroPedido++).append("\n");
        ticketInfo.append("Fecha y Hora: ").append(fecha).append("        ").append(hora.withNano(0)).append("\n");
        ticketInfo.append("*******************************************\n");

        for (int i = 0; i < productosComprados.size(); i++) {
            ticketInfo.append(this.cantidades.get(i));
            ticketInfo.append(" x ");
            ticketInfo.append(this.productosComprados.get(i).getIdProducto());
            ticketInfo.append(":");
            ticketInfo.append(this.productosComprados.get(i).getDescripcion());
            ticketInfo.append(" | ");
            ticketInfo.append(dosDecimales.format(this.productosComprados.get(i).getPrecio()));
            ticketInfo.append("€ | IVA: ");
            ticketInfo.append(this.productosComprados.get(i).getIva().getTasa() * 100);
            ticketInfo.append("%");
            ticketInfo.append("\n");
        }
        ticketInfo.append("*******************************************\n");

        ticketInfo.append("Precio Total: ").append(dosDecimales.format(precio)).append("€");

        JOptionPane.showMessageDialog(null, ticketInfo.toString(), "Ticket de Compra", JOptionPane.INFORMATION_MESSAGE);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getIdTicket() {
        return idTicket;
    }

}
