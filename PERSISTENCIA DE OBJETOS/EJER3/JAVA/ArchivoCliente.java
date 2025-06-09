/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJER3;

/**
 *
 * @author LENOVO
 */
import java.io.*;
import java.util.ArrayList;

public class ArchivoCliente {
    private String nomA;

    public ArchivoCliente(String n) {
        this.nomA = n;
    }

    public void crearArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomA))) {
            oos.writeObject(new ArrayList<Cliente>());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardaCliente(Cliente c) {
        ArrayList<Cliente> clientes = leerClientes();
        clientes.add(c);
        guardarLista(clientes);
    }

    public Cliente buscarCliente(int c) {
        for (Cliente cli : leerClientes()) {
            if (cli.getId() == c) {
                return cli;
            }
        }
        return null;
    }

    public Cliente buscarCelularCliente(int c) {
        for (Cliente cli : leerClientes()) {
            if (cli.getTelefono() == c) {
                return cli;
            }
        }
        return null;
    }

    private ArrayList<Cliente> leerClientes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomA))) {
            return (ArrayList<Cliente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    private void guardarLista(ArrayList<Cliente> clientes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomA))) {
            oos.writeObject(clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

