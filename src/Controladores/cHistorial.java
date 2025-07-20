/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Historial;
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
public class cHistorial {

    public static final String SEPARADOR = ";";
    public static final String QUOTE = "\"";
    public String path = Global.getPath() + "\\Data\\dataHistorial.csv";

    private ArrayList<Historial> listaHistorial = new ArrayList<>();

    public void nuevo(Historial h) {
        listaHistorial.add(h);
    }

    public int cantidad() {
        return listaHistorial.size();
    }

    public Historial getHistorial(int posicion) {
        if (posicion >= 0 && posicion < listaHistorial.size()) {
            return listaHistorial.get(posicion);
        }
        return null;
    }

    public void limpiar() {
        listaHistorial.clear();
    }

    public DefaultTableModel getTabla() {
        // Encabezados de columnas de la tabla
        String[] columnName = {"Cédula", "Nombre", "Apellido", "Fecha", "Hora Ingreso", "Hora Salida", "N° Máquina"};
        DefaultTableModel tabla = new DefaultTableModel(columnName, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace que las celdas no sean editables
            }
        };

        for (int i = 0; i < listaHistorial.size(); i++) {
            Historial h = listaHistorial.get(i);
            Object[] row = {
                h.cedula, h.nombre, h.apellido, h.fecha,
                h.horaIngreso, h.horaSalida, h.numeroMaquina
            };
            tabla.addRow(row);
        }

        return tabla;
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
                Historial h = new Historial();
                h.cedula = row[0];
                h.nombre = row[1];
                h.apellido = row[2];
                h.fecha = row[3];
                h.horaIngreso = row[4];
                h.horaSalida = row[5];
                h.numeroMaquina = Integer.parseInt(row[6]);
                nuevo(h);
            }
        } catch (IOException e) {
            System.err.println("Error leyendo historial: " + e.getMessage());
            throw e;
        }
    }

    public void guardar() throws IOException {
        try (FileWriter file = new FileWriter(path)) {
            final String NL = "\n";
            file.append("Cedula").append(SEPARADOR)
                    .append("Nombre").append(SEPARADOR)
                    .append("Apellido").append(SEPARADOR)
                    .append("Fecha").append(SEPARADOR)
                    .append("HoraIngreso").append(SEPARADOR)
                    .append("HoraSalida").append(SEPARADOR)
                    .append("NumeroMaquina").append(NL);

            for (int i = 0; i < listaHistorial.size(); i++) {
                Historial h = listaHistorial.get(i);
                file.append(h.cedula).append(SEPARADOR)
                        .append(h.nombre).append(SEPARADOR)
                        .append(h.apellido).append(SEPARADOR)
                        .append(h.fecha).append(SEPARADOR)
                        .append(h.horaIngreso).append(SEPARADOR)
                        .append(h.horaSalida).append(SEPARADOR)
                        .append(String.valueOf(h.numeroMaquina)).append(NL);
            }
            file.flush();
            file.close();
        } catch (IOException e) {
            System.err.println("Error guardando historial: " + e.getMessage());
            throw e;
        }
    }

}
