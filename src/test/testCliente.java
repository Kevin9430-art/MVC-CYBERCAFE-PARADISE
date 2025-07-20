/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import Controladores.cCliente;
import Modelos.Cliente;
import java.io.IOException;

/**
 *
 * @author kevin
 */
public class testCliente {

    public static void main(String[] args) {
        cCliente lista = new cCliente();

        // Crear algunos clientes de prueba
        Cliente c1 = new Cliente("0102030405", "Juan", "Perez", 1, "30 minutos", true,
                java.time.LocalTime.of(9, 0), java.time.LocalTime.of(9, 30));
        Cliente c2 = new Cliente("0203040506", "Maria", "Lopez", 2, "1 hora", false,
                java.time.LocalTime.of(10, 0), java.time.LocalTime.of(11, 0));

        // Agregar clientes a la lista
        lista.nuevo(c1);
        lista.nuevo(c2);

        try {
            // Guardar clientes en archivo CSV
            lista.guardar();

            // Limpiar lista para simular carga desde archivo
            lista.limpiar();

            // Leer clientes desde archivo CSV
            lista.leer();

            // Mostrar clientes leídos en consola
            for (int i = 0; i < lista.cantidad(); i++) {
                Cliente c = lista.getCliente(i);
                System.out.println("Cliente " + (i + 1) + ": "
                        + c.cedula + ", " + c.nombre + " " + c.apellido
                        + ", Maquina: " + c.numeroMaquina
                        + ", Tiempo: " + c.tiempoUso
                        + ", Activo: " + c.estaActivo
                        + ", Ingreso: " + c.horaIngreso
                        + ", Salida: " + c.horaSalida);
            }
        } catch (IOException e) {
            System.err.println("Error al guardar o leer clientes: " + e.getMessage());
        }
    }

}
