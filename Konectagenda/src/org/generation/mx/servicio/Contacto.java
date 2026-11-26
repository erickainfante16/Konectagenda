package org.generation.mx.servicio;

import java.util.Objects;

public class Contacto {
    private final String nombre;
    private String telefono;

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre.trim();
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Un contacto es igual a otro cuando sus nombres son iguales (sin importar mayúsculas)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contacto)) return false;
        Contacto otro = (Contacto) o;
        return nombre.equalsIgnoreCase(otro.nombre);
    }

    // Debe ser coherente con equals: solo depende del nombre
    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase());
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Teléfono: " + telefono;
    }
}