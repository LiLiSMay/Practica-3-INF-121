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
        Catalogo<Libro> catalogoLibros = new Catalogo<>();
        catalogoLibros.agregar(new Libro("El Principito"));
        catalogoLibros.agregar(new Libro("1984"));

        System.out.println("Esta '1984'?: " +
            catalogoLibros.buscar(new Libro("1984")));

        catalogoLibros.mostrar();

        Catalogo<Producto> catalogoProductos = new Catalogo<>();
        catalogoProductos.agregar(new Producto("Celular"));
        catalogoProductos.agregar(new Producto("Laptop"));

        System.out.println("Esta 'Tablet'?: " +
            catalogoProductos.buscar(new Producto("Tablet")));

        catalogoProductos.mostrar();
    }
}
