/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJER3;

/**
 *
 * @author LENOVO
 */
import java.util.ArrayList;
import java.util.List;

public class Catalogo<T> {
    private List<T> elementos = new ArrayList<>();

    public void agregar(T item) {
        elementos.add(item);
    }

    public boolean buscar(T item) {
        return elementos.contains(item);
    }

    public void mostrar() {
        for (T e : elementos) {
            System.out.println(e);
        }
    }
}

