/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJER1;

import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class Empleado implements Serializable {
    private String nombre;
    private int edad;
    private float salario;

    public Empleado(String nombre, int edad, float salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public float getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
               "nombre: " + nombre +
               ", edad: " + edad +
               ", salario: " + salario +
               '}';  
}}
