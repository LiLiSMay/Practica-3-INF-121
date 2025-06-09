/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJER3;

/**
 *
 * @author LENOVO
 */
public class Producto {
    private String nombre;

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Producto: " + nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto producto = (Producto) obj;
        return nombre.equals(producto.nombre);
    }
}
