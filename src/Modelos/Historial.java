/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author kevin
 */
public class Historial {

    public String cedula;
    public String nombre;
    public String apellido;
    public String fecha;
    public String horaIngreso;
    public String horaSalida;
    public int numeroMaquina;

    public Historial() {
    }// const vacio

    public Historial(String cedula, String nombre, String apellido, String fecha, String horaIngreso, int numeroMaquina) {//parametros
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.horaIngreso = horaIngreso;
        this.numeroMaquina = numeroMaquina;
    }

    public String getHistorial() {
        String datos = this.cedula + ";";
        datos += this.nombre + ";";
        datos += this.apellido + ";";
        datos += this.fecha + ";";
        datos += this.horaIngreso + ";";
        datos += this.horaSalida + ";";
        datos += this.numeroMaquina + ";";
        return datos;
    }
}
