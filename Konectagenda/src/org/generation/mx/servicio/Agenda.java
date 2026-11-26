package org.generation.mx.servicio;

import java.util.HashSet;
import java.util.Set;

public class Agenda {
    private static final int TAMANIO_POR_DEFECTO = 10;

    // Conjunto de contactos: HashSet da consultas en O(1) y no admite duplicados
    // (usa equals/hashCode de Contacto, que comparan solo el nombre)
    private final Set<Contacto> contactos = new HashSet<>();
    private final int tamanio;

    public Agenda() {
        this(TAMANIO_POR_DEFECTO);
    }

    public Agenda(int tamanio) {
        if (tamanio <= 0) {
            throw new IllegalArgumentException("El tamaño de la agenda debe ser mayor que 0");
        }
        this.tamanio = tamanio;
    }

    public void añadirContacto(Contacto c) {
        if (agendaLlena()) {
            System.out.println("La agenda está llena, no se pueden añadir más contactos.");
        } else if (existeContacto(c)) {
            System.out.println("Ya existe un contacto con el nombre \"" + c.getNombre() + "\".");
        } else {
            contactos.add(c);
            System.out.println("Contacto añadido.");
        }
    }

    public boolean existeContacto(Contacto c) {
        return contactos.contains(c);
    }

    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
            return;
        }
        for (Contacto c : contactos) {
            System.out.println(c);
        }
    }

    public void buscarPorNombre(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre.trim())) {
                System.out.println("Teléfono de " + c.getNombre() + ": " + c.getTelefono());
                return;
            }
        }
        System.out.println("No se encontró el contacto \"" + nombre + "\".");
    }

    public void eliminarContacto(Contacto c) {
        if (contactos.remove(c)) {
            System.out.println("Contacto eliminado.");
        } else {
            System.out.println("No se eliminó: el contacto no existe.");
        }
    }

    public boolean agendaLlena() {
        return contactos.size() >= tamanio;
    }

    public int espaciosLibres() {
        return tamanio - contactos.size();
    }

    public int getTamanio() {
        return tamanio;
    }
}