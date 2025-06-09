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
    public static void main(String[] args) {
        Caja<String> caja1 = new Caja<>();
        caja1.guardar("libros de programacion ");

        Caja<Integer> caja2 = new Caja<>();
        caja2.guardar(1263);

        System.out.println("Contenido de caja1: " + caja1.obtener());
        System.out.println("Contenido de caja2: " + caja2.obtener());
    }
    
}
