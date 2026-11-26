package org.generation.mx.servicio;
import java.util.*;
public class Agenda {

    private HashMap<contacto, String> agenda = new HashMap<>(); //correccion
    private int espaciosAgenda = 10; //int
    private int contactosAlMomento = 0;  //int

    public void añadirContacto(contacto c){
        if(!existeContacto(c) && ! agendaLlena()){
            contactosAlMomento++;   //&&! agendaLlena ento++

            String valor = c.getNumero(); //acento
            agenda.put(c, valor);
        }else{
            System.out.println("Ya existe ese contacto");
        }
    }

    public boolean existeContacto(contacto c){
         // ()
        return agenda.containsKey(c);

    }

    public void listarContactos(){
        for(contacto i: agenda.keySet()){//Imprimir todos los elementos de la agenda
            System.out.println("Nombre: " + i.getNombre() +
                    " Apellido: " + i.getApellido() +
                    " Número de contacto: " + i.getNumero()); // i ? y acento
        }
    }

    public contacto buscarContacto(String nombre){
        for(contacto c : agenda.keySet()){
            if(nombre.equals (c.getNombre())){
                return c; //()
            }
        }
        return null;
    }

    public void eliminarContacto(contacto c){

        if (agenda.remove(c) !=null) {
            contactosAlMomento--; //if !=null contactosAlMomento--
        }
    }


   public void modificarTelefono(String nombre, String apellido, String nuevoTelefono){
        contacto c = new contacto(nombre, apellido, nuevoTelefono);

        if(agenda.containsKey(c)) {  //todo este
            agenda.remove(c);
            agenda.put(c,nuevoTelefono); //hasta aca I
        }
    }

    public boolean agendaLlena(){ //declaracion Llena

        return (contactosAlMomento==espaciosAgenda);
    }

    public int espaciosLibres(){

        return (espaciosAgenda-contactosAlMomento);
    }
}
