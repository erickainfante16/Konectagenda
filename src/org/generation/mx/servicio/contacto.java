package org.generation.mx.servicio;

public class contacto {

    // Atributos
    private String nombre;
    private String apellido;
    private String numero;

   //Constructores
    public contacto() { //Constructor vacío
    }

    public contacto(String nombre, String apellido, String numero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero = numero;
    }

   // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

   // ToString
    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + numero;
    }
}