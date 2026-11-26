package org.generation.mx.test;
import org.junit.Test;
import static org.junit.Assert.*;
import org.generation.mx.servicio.Agenda;
import org.generation.mx.servicio.contacto;
public class AgendaTest {

    @Test
    public void probarAgregarContacto() {
        Agenda agenda = new Agenda();
        contacto nuevo = new contacto("Axel", "Garcia","5551919617");

        agenda.añadirContacto(nuevo);

        assertTrue(agenda.existeContacto(nuevo));
    }

    @Test
    public void probarExisteContacto() {
        Agenda agenda = new Agenda();
        contacto nuevo = new contacto("Axel","Garcia","5551919617");

        assertFalse(agenda.existeContacto(nuevo));

        agenda.añadirContacto(nuevo);

        assertTrue(agenda.existeContacto(nuevo));
    }
}
