package daw;

 import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rocio
 */
public class Ticket {
   
    private static int numeroPedido = 1; 
    private List<Producto> productosComprados;
    private double montoTotal;
    private Date fechaHora;

    public Ticket(List<Producto> productosComprados, double montoTotal) {
        this.productosComprados = productosComprados;
        this.montoTotal = montoTotal;
        this.fechaHora = new Date();
    }

    public void imprimirTicket() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        StringBuilder ticketInfo = new StringBuilder();
        ticketInfo.append("Número de Pedido: ").append(numeroPedido++).append("\n");
        ticketInfo.append("Fecha y Hora: ").append(dateFormat.format(fechaHora)).append("\n");
        ticketInfo.append("Productos Comprados:\n");

        for (Producto producto : productosComprados) {
            ticketInfo.append("  - ").append(producto.getDescripcion()).append(" | Precio: ").append(producto.getPrecio()).append("\n");
        }

        ticketInfo.append("Monto Total: ").append(montoTotal);

        JOptionPane.showMessageDialog(null, ticketInfo.toString(), "Ticket de Compra", JOptionPane.INFORMATION_MESSAGE);
    }
}

