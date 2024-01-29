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
         List<Producto> carta = Funciones.crearCarta();
        Funciones.menuInicial(carta);

        //poner colores 
        JButton boton = new JButton("Aceptar");
        UIManager.put("OptionPane.background", Color.decode("#ef7bba"));
        UIManager.getLookAndFeelDefaults().put("Panel.background", Color.decode("#ef7bba"));
        boton.setBackground(Color.decode("#b976cd"));
        boton.setForeground(Color.WHITE);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.getRootFrame().dispose();
            }
        });
        JButton[] botones = {boton};
        JOptionPane.showOptionDialog(null, "Bye bye", "¡Hasta la próxima!",
                JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, botones, botones[0]);
    }
    }

    public void encenderTpv() {
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

    public static void encenderTpv(){
        Funciones.menuInicial();
    }
    
}
