package org.generation.mx.servicio;
import java.utils.*;

public class Agenda {
    private HashMap<Contacto, int> agenda = new HashMap<Contacto, int>(); //HashMap para que el tiempo en consulta sea constante (1) y evitar duplicados
    private espaciosAgenda = 10;
    private contactosAlMomento = 0;

    public void añadirContacto(Contacto c){
        if(!existeContacto(c)){
            ++contactosAlMomento;

            int valor = c.getNúmero();
            agenda.put(c, valor);
        }else{
            System.out.println("Ya existe ese contacto");
        }
    }

    public boolean existeContacto(Contacto c){
        return(agenda.containsKey(c));
    }

    public void listarContactos(){
        for(Contacto i : agenda.keySet()){//Imprimir todos los elementos de la agenda
            System.out.println("Nombre: " + i.getNombre() + " Apellido: " + c.getApellido() + " Número de contacto: " + c.getNúmero());
        }
    }

    public Contacto buscarContacto(String nombre){
        for(Contacto c : agenda.keySet()){
            if(nombre.equals( c.getNombre() )){
                return(c);
            }
        }
        return null;
    }

    public void eliminarContacto(Contacto c){
        agenda.remove(c);
    }

    void modificarTelefono(String nombre, String apellido, String nuevoTelefono){
        Contacto c = new Contacto(nombre, apellido, nuevoTelefono);
        agenda.put(c, nuevoTelefono)
    }

    public boolean agendaLLena(){
        return (contactosAlMomento==espaciosAgenda);
    }

    public int espaciosLibres(){
        return (espaciosAgenda-contactosAlMomento);
    }
}
