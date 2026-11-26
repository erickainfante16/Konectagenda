package org.generation.mx.test;

import org.generation.mx.servicio.Contacto;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactoTest {

    // Prueba 1: Constructor con parámetros
    @Test
    public void probarConstructorConParametros() {
        Contacto nuevoContacto = new Contacto("Axel", "5551919617");

        assertNotNull(nuevoContacto);
        assertEquals("Axel", nuevoContacto.getNombre());
        assertEquals("5551919617", nuevoContacto.getTelefono());
    }

    // Prueba 2: El constructor quita espacios sobrantes del nombre
    @Test
    public void probarConstructorQuitaEspacios() {
        Contacto nuevoContacto = new Contacto("  Axel  ", "5551919617");

        assertEquals("Axel", nuevoContacto.getNombre());
    }

    // Prueba 3: Getter nombre
    @Test
    public void probarGetNombre() {
        Contacto nuevoContacto = new Contacto("Axel", "5551919617");

        assertEquals("Axel", nuevoContacto.getNombre());
    }

    // Prueba 4: Getter teléfono
    @Test
    public void probarGetTelefono() {
        Contacto nuevoContacto = new Contacto("Axel", "5551919617");

        assertEquals("5551919617", nuevoContacto.getTelefono());
    }

    // Prueba 5: Setter teléfono
    @Test
    public void probarSetTelefono() {
        Contacto nuevoContacto = new Contacto("Axel", "5551919617");
        nuevoContacto.setTelefono("5534545678");

        assertEquals("5534545678", nuevoContacto.getTelefono());
    }

    // Prueba 6: Dos contactos con el mismo nombre son iguales aunque tengan distinto teléfono
    @Test
    public void probarEqualsMismoNombre() {
        Contacto c1 = new Contacto("Axel", "5551919617");
        Contacto c2 = new Contacto("Axel", "5534545678");

        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());
    }

    // Prueba 7: La comparación de nombres no distingue mayúsculas
    @Test
    public void probarEqualsIgnoraMayusculas() {
        Contacto c1 = new Contacto("Axel", "5551919617");
        Contacto c2 = new Contacto("AXEL", "5551919617");

        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());
    }

    // Prueba 8: Contactos con distinto nombre no son iguales
    @Test
    public void probarEqualsDistintoNombre() {
        Contacto c1 = new Contacto("Axel", "5551919617");
        Contacto c2 = new Contacto("Carlos", "5551919617");

        assertNotEquals(c1, c2);
    }

    // Prueba 9: ToString
    @Test
    public void probarToString() {
        Contacto nuevoContacto = new Contacto("Axel", "5551919617");

        assertEquals(
                "Nombre: Axel | Teléfono: 5551919617",
                nuevoContacto.toString()
        );
    }
}
