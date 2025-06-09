/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJER1;

/**
 *
 * @author LENOVO
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoEmpleado {
    private String nomA;

    public ArchivoEmpleado(String n) {
        this.nomA = n;
    }

    public void crearArchivo() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomA))) {
            out.writeObject(new ArrayList<Empleado>());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarEmpleado(Empleado e) {
        try {
            List<Empleado> empleados;
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomA))) {
                empleados = (List<Empleado>) in.readObject();
            }
            empleados.add(e);
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomA))) {
                out.writeObject(empleados);
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public Empleado buscaEmpleado(String nombre) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomA))) {
            List<Empleado> empleados = (List<Empleado>) in.readObject();
            for (Empleado e : empleados) {
                if (e.getNombre().equals(nombre)) {
                    return e;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Empleado mayorSalario(float s) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomA))) {
            List<Empleado> empleados = (List<Empleado>) in.readObject();
            for (Empleado e : empleados) {
                if (e.getSalario() > s) {
                    return e;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

