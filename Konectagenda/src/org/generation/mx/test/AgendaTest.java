package org.generation.mx.test;

import org.generation.mx.servicio.Agenda;
import org.generation.mx.servicio.Contacto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class AgendaTest {

    // Agenda imprime sus mensajes en pantalla; los capturamos para poder revisarlos
    private final ByteArrayOutputStream salida = new ByteArrayOutputStream();
    private PrintStream salidaOriginal;

    @Before
    public void capturarSalida() {
        salidaOriginal = System.out;
        System.setOut(new PrintStream(salida));
    }

    @After
    public void restaurarSalida() {
        System.setOut(salidaOriginal);
    }

    @Test
    public void probarAgregarContacto() {
        Agenda agenda = new Agenda();
        Contacto nuevo = new Contacto("Axel", "5551919617");

        agenda.añadirContacto(nuevo);

        assertTrue(agenda.existeContacto(nuevo));
    }

    @Test
    public void probarExisteContacto() {
        Agenda agenda = new Agenda();
        Contacto nuevo = new Contacto("Axel", "5551919617");

        assertFalse(agenda.existeContacto(nuevo));

        agenda.añadirContacto(nuevo);

        assertTrue(agenda.existeContacto(nuevo));
    }

    @Test
    public void probarExisteContactoSoloPorNombre() {
        Agenda agenda = new Agenda();
        agenda.añadirContacto(new Contacto("Axel", "5551919617"));

        // El teléfono no importa: basta con que el nombre coincida
        assertTrue(agenda.existeContacto(new Contacto("axel", "")));
    }

    @Test
    public void probarNoAgregarDuplicado() {
        Agenda agenda = new Agenda();
        agenda.añadirContacto(new Contacto("Axel", "5551919617"));
        agenda.añadirContacto(new Contacto("AXEL", "5534545678"));

        assertEquals(9, agenda.espaciosLibres());
        assertTrue(salida.toString().contains("Ya existe"));
    }

    @Test
    public void probarTamanioPorDefecto() {
        Agenda agenda = new Agenda();

        assertEquals(10, agenda.getTamanio());
        assertEquals(10, agenda.espaciosLibres());
    }

    @Test
    public void probarTamanioPersonalizado() {
        Agenda agenda = new Agenda(3);

        assertEquals(3, agenda.getTamanio());
        assertEquals(3, agenda.espaciosLibres());
    }

    @Test(expected = IllegalArgumentException.class)
    public void probarTamanioInvalido() {
        new Agenda(0);
    }

    @Test
    public void probarAgendaLlena() {
        Agenda agenda = new Agenda(2);

        assertFalse(agenda.agendaLlena());

        agenda.añadirContacto(new Contacto("Axel", "5551919617"));
        agenda.añadirContacto(new Contacto("Carlos", "5534545678"));

        assertTrue(agenda.agendaLlena());
        assertEquals(0, agenda.espaciosLibres());
    }

    @Test
    public void probarNoAgregarSiEstaLlena() {
        Agenda agenda = new Agenda(1);
        agenda.añadirContacto(new Contacto("Axel", "5551919617"));

        Contacto extra = new Contacto("Carlos", "5534545678");
        agenda.añadirContacto(extra);

        assertFalse(agenda.existeContacto(extra));
        assertTrue(salida.toString().contains("La agenda está llena"));
    }

    @Test
    public void probarEliminarContacto() {
        Agenda agenda = new Agenda();
        Contacto nuevo = new Contacto("Axel", "5551919617");
        agenda.añadirContacto(nuevo);

        agenda.eliminarContacto(nuevo);

        assertFalse(agenda.existeContacto(nuevo));
        assertEquals(10, agenda.espaciosLibres());
        assertTrue(salida.toString().contains("Contacto eliminado."));
    }

    @Test
    public void probarEliminarContactoInexistente() {
        Agenda agenda = new Agenda();

        agenda.eliminarContacto(new Contacto("Axel", ""));

        assertTrue(salida.toString().contains("No se eliminó"));
    }

    @Test
    public void probarBuscarPorNombre() {
        Agenda agenda = new Agenda();
        agenda.añadirContacto(new Contacto("Axel", "5551919617"));

        agenda.buscarPorNombre("axel");

        assertTrue(salida.toString().contains("Teléfono de Axel: 5551919617"));
    }

    @Test
    public void probarBuscarPorNombreInexistente() {
        Agenda agenda = new Agenda();

        agenda.buscarPorNombre("Carlos");

        assertTrue(salida.toString().contains("No se encontró"));
    }

    @Test
    public void probarListarContactos() {
        Agenda agenda = new Agenda();
        agenda.añadirContacto(new Contacto("Axel", "5551919617"));
        agenda.añadirContacto(new Contacto("Carlos", "5534545678"));

        agenda.listarContactos();

        String texto = salida.toString();
        assertTrue(texto.contains("Nombre: Axel | Teléfono: 5551919617"));
        assertTrue(texto.contains("Nombre: Carlos | Teléfono: 5534545678"));
    }

    @Test
    public void probarListarAgendaVacia() {
        new Agenda().listarContactos();

        assertTrue(salida.toString().contains("La agenda está vacía."));
    }
}
