/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package EJER1;

/**
 *
 * @author LENOVO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        ArchivoEmpleado archivo = new ArchivoEmpleado("empleados.dat");
        archivo.crearArchivo();

        archivo.guardarEmpleado(new Empleado("Laura", 30, 4000f));
        archivo.guardarEmpleado(new Empleado("Luis", 28, 3800f));
        archivo.guardarEmpleado(new Empleado("Jose", 35, 4500f));

        Empleado e1 = archivo.buscaEmpleado("Luis");
        System.out.println("Empleado encontrado: " + e1);

        Empleado e2 = archivo.mayorSalario(3900f);
        System.out.println("Empleado con mayor salario > 3900: " + e2);
    }    
}
