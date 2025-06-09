/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package EJER3;

/**
 *
 * @author LENOVO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArchivoCliente archivo = new ArchivoCliente("clientes.dat");
        archivo.crearArchivo();

        Cliente c1 = new Cliente(1, "Maya", 77712345);
        Cliente c2 = new Cliente(2, "Lucas", 76543210);

        archivo.guardaCliente(c1);
        archivo.guardaCliente(c2);

        System.out.println("Buscar por ID 2:");
        System.out.println(archivo.buscarCliente(2));

        System.out.println("Buscar por Telefono 77712345:");
        System.out.println(archivo.buscarCelularCliente(77712345));
    }
    
}
