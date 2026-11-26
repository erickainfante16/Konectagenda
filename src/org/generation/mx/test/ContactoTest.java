package org.generation.mx.test;

import org.generation.mx.servicio.contacto;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactoTest {

    // Prueba 1: Constructor vacío
    @Test
    public void probarConstructorVacio() {
        contacto nuevoContacto = new contacto();

        assertNotNull(nuevoContacto);
    }

    // Prueba 2: Constructor con parámetros
    @Test
    public void probarConstructorConParametros() {
        contacto nuevoContacto = new contacto("Axel", "Garcia", 551234567);

        assertEquals("Axel", nuevoContacto.getNombre());
        assertEquals("Garcia", nuevoContacto.getApellido());
        assertEquals(551234567, nuevoContacto.getNumero());
    }

    // Prueba 3: Getter nombre
    @Test
    public void probarGetNombre() {
        contacto nuevoContacto = new contacto("Axel", "Garcia", 551234567);

        assertEquals("Axel", nuevoContacto.getNombre());
    }

    // Prueba 4: Getter apellido
    @Test
    public void probarGetApellido() {
        contacto nuevoContacto = new contacto("Axel", "Garcia", 551234567);

        assertEquals("Garcia", nuevoContacto.getApellido());
    }

    // Prueba 5: Getter número
    @Test
    public void probarGetNumero() {
        contacto nuevoContacto = new contacto("Axel", "Garcia", 551234567);

        assertEquals(551234567, nuevoContacto.getNumero());
    }

    // Prueba 6: Setter nombre
    @Test
    public void probarSetNombre() {
        contacto nuevoContacto = new contacto();
        nuevoContacto.setNombre("Carlos");

        assertEquals("Carlos", nuevoContacto.getNombre());
    }

    // Prueba 7: Setter apellido
    @Test
    public void probarSetApellido() {
        contacto nuevoContacto = new contacto();
        nuevoContacto.setApellido("Lopez");

        assertEquals("Lopez", nuevoContacto.getApellido());
    }

    // Prueba 8: Setter número
    @Test
    public void probarSetNumero() {
        contacto nuevoContacto = new contacto();
        nuevoContacto.setNumero(558765432);

        assertEquals(558765432, nuevoContacto.getNumero());
    }

    // Prueba 9: ToString
    @Test
    public void probarToString() {
        contacto nuevoContacto = new contacto("Axel", "Garcia", 551234567);

        assertEquals(
                "Axel Garcia - 551234567",
                nuevoContacto.toString()
        );
    }
}
