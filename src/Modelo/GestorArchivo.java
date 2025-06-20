/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Kirig
 */
public class GestorArchivo {
     private final String nombreArchivo = "registros.dat";

    public void guardarRegistro(Alumno alumno) {
        PrintWriter escritor = null;
        try {
            escritor = new PrintWriter(new FileWriter(nombreArchivo, true));

            String actividades = alumno.getActividades();
            if (actividades == null || actividades.trim().isEmpty()) {
                actividades = "NINGUNA";
            }

            escritor.println("Matrícula: " + alumno.getMatricula());
            escritor.println("Nombre: " + alumno.getNombre());
            escritor.println("Apellidos: " + alumno.getApellidos());
            escritor.println("Edad: " + alumno.getEdad());
            escritor.println("Género: " + alumno.getGenero());
            escritor.println("División: " + alumno.getDivision());
            escritor.println("Actividades: " + actividades);
            escritor.println("----------");

        } catch (IOException e) {
            System.err.println("Error al guardar el registro: " + e.getMessage());
        } finally {
            if (escritor != null) {
                escritor.close();
            }
        }
    }
}

