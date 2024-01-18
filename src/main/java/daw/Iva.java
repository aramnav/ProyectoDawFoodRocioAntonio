/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

/**
 *
 * @author Antonio Ramírez
 */
public enum Iva {
    SIN_IVA(0.0),
    IVA_10(0.1),
    IVA_21(0.21);

    private final double tasa;

    Iva(double tasa) {
        this.tasa = tasa;
    }

    public double getTasa() {
        return tasa;
    }

}
