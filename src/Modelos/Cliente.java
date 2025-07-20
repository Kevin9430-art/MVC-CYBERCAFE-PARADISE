/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.time.LocalTime;

/**
 *
 * @author kevin
 */
public class Cliente {

    public String cedula;
    public String nombre;
    public String apellido;
    public int numeroMaquina;     // Número de computadora que usa
    public String tiempoUso;      // Tiempo reservado o usado (ej: "30 minutos", "1 hora")
    public boolean estaActivo;
    public LocalTime horaIngreso;
    public LocalTime horaSalida;

    public Cliente() {
    }

    public Cliente(String cedula, String nombre, String apellido, int numeroMaquina, String tiempoUso, boolean estaActivo, LocalTime horaIngreso, LocalTime horaSalida) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroMaquina = numeroMaquina;
        this.tiempoUso = tiempoUso;
        this.estaActivo = estaActivo;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;

    }

    public String getDatos() {
        return cedula + ";" + nombre + ";" + apellido;
    }

    public String getCliente() {
        String datos = this.cedula + ";";
        datos += this.nombre + ";";
        datos += this.apellido + ";";
        datos += this.numeroMaquina + ";";
        datos += this.tiempoUso + ";";
        datos += this.estaActivo + ";";
        datos += this.horaIngreso + ";";
        datos += this.horaSalida + ";";
        return datos;
    }
}
