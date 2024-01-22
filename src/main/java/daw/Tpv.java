/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author antonio
 */
public class Tpv {

    private UUID numSerie;
    private String direccion;
    private LocalDate fecha;
    private LocalTime hora;

    public Tpv(String direccion) {
        this.numSerie = UUID.randomUUID();
        this.direccion = direccion;
        this.fecha = LocalDate.now();
        this.hora = LocalTime.now();
    }

    public Tpv() {
    }

    public void encenderTpv() {
        List<Producto> carta = Funciones.crearCarta();
        Funciones.menuInicial(carta);

    }

    public UUID getNumSerie() {
        return numSerie;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate verFecha() {
        return fecha;
    }

    public LocalTime verHora() {
        return hora;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
