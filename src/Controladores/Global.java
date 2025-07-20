/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;
import java.io.File;

/**
 *
 * @author kevin
 */
public class Global {
      //obtiene ruta del c�digo fuente del Proyecto
    public static String getPath() {
        //extraer ruta del proyecto de forma din�mica
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        //eliminar los dos caracteres del final del path
        path = path.substring(0, path.length() - 2);
        path += "\\src";// solo hasta el codigo fuente
        System.out.println("Path o ruta del Proyecto " + path);
        return path;
    }
}
