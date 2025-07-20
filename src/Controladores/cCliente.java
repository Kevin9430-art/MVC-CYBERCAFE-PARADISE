/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Cliente;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevin
 */
public class cCliente {

    public static final String SEPARADOR = ";";
    public static final String QUOTE = "\"";
    public String path = Global.getPath() + "\\Data\\dataClientes.csv";

    private ArrayList<Cliente> listaClientes = new ArrayList<>();

    public void nuevo(Cliente c) {
        listaClientes.add(c);
    }

    public int cantidad() {
        return listaClientes.size();
    }

    public Cliente getCliente(int posicion) {
        if (posicion >= 0 && posicion < listaClientes.size()) {
            return listaClientes.get(posicion);
        }
        return null;
    }

    public void limpiar() {
        listaClientes.clear();
    }

    private static String[] removeTrailingQuotes(String[] fields) {
        String result[] = new String[fields.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = fields[i].replaceAll("^" + QUOTE, "").replaceAll(QUOTE + "$", "");
        }
        return result;
    }

    public void leer() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            limpiar();
            String line = br.readLine(); // cabecera
            while ((line = br.readLine()) != null) {
                String[] row = removeTrailingQuotes(line.split(SEPARADOR));
                Cliente c = new Cliente();
                c.cedula = row[0];
                c.nombre = row[1];
                c.apellido = row[2];
                c.numeroMaquina = Integer.parseInt(row[3]);
                c.tiempoUso = row[4];
                c.estaActivo = Boolean.parseBoolean(row[5]);
                c.horaIngreso = java.time.LocalTime.parse(row[6]);
                c.horaSalida = java.time.LocalTime.parse(row[7]);
                nuevo(c);
            }
        } catch (IOException e) {
            System.err.println("Error leyendo clientes: " + e.getMessage());
            throw e;
        }
    }

    public void guardar() throws IOException {
        try (FileWriter file = new FileWriter(path)) {
            final String NL = "\n";
            file.append("Cedula").append(SEPARADOR)
                    .append("Nombre").append(SEPARADOR)
                    .append("Apellido").append(SEPARADOR)
                    .append("NumeroMaquina").append(SEPARADOR)
                    .append("TiempoUso").append(SEPARADOR)
                    .append("EstaActivo").append(SEPARADOR)
                    .append("HoraIngreso").append(SEPARADOR)
                    .append("HoraSalida").append(NL);

            for (int i = 0; i < listaClientes.size(); i++) {
                Cliente c = listaClientes.get(i);
                file.append(c.cedula).append(SEPARADOR)
                        .append(c.nombre).append(SEPARADOR)
                        .append(c.apellido).append(SEPARADOR)
                        .append(String.valueOf(c.numeroMaquina)).append(SEPARADOR)
                        .append(c.tiempoUso).append(SEPARADOR)
                        .append(String.valueOf(c.estaActivo)).append(SEPARADOR)
                        .append(c.horaIngreso.toString()).append(SEPARADOR)
                        .append(c.horaSalida.toString()).append(NL);
            }
            file.flush();
            file.close();
        } catch (IOException e) {
            System.err.println("Error guardando clientes: " + e.getMessage());
            throw e;
        }
    }
}
