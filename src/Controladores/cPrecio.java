/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Precio;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevin
 */
public class cPrecio {

    public static final String SEPARADOR = ";";
    public static final String QUOTE = "\"";
    public String path = Global.getPath() + "\\Data\\dataPrecio.csv";

    private ArrayList<Precio> listaPrecios = new ArrayList<>();

    public int cantidad() {
        return listaPrecios.size();
    }

    public void nuevo(Precio p) {
        listaPrecios.add(p);
    }

    public DefaultTableModel getTabla() {
        String[] columnName = {"Media Hora", "Una Hora"};
        DefaultTableModel tabla = new DefaultTableModel(columnName, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // celdas no editables
            }
        };

        for (int i = 0; i < cantidad(); i++) {
            Precio p = listaPrecios.get(i);
            Object[] row = {
                p.mediaHora, p.unaHora
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

    public void guardar() throws IOException {
        try (FileWriter file = new FileWriter(path)) {
            final String NL = "\n";
            file.append("MediaHora").append(SEPARADOR)
                    .append("UnaHora").append(NL);

            for (int i = 0; i < listaPrecios.size(); i++) {
                Precio p = listaPrecios.get(i);
                file.append(String.valueOf(p.mediaHora)).append(SEPARADOR)
                        .append(String.valueOf(p.unaHora)).append(NL);
            }

            file.flush();
            file.close();
        } catch (IOException e) {
            System.err.println("Error guardando precios: " + e.getMessage());
            throw e;
        }
    }
}
