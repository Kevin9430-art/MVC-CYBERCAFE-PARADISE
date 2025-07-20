/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author kevin
 */
public class Precio {

    public double mediaHora = 0.50;
    public double unaHora = 1.00;

    public Precio() {
    }

    public Precio(double mediaHora, double unaHora) {
        this.mediaHora = mediaHora;
        this.unaHora = unaHora;
    }

    public String getPrecio() {

        String datos = this.mediaHora + ";";
        datos += this.unaHora + ";";
        return datos;
    }
}
