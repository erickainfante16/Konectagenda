package org.generation.mx.servicio;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Agenda agenda = crearAgenda();
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Elige una opción: ");

            switch (opcion) {
                case 1: {
                    String nombre = leerTexto("Nombre: ");
                    String telefono = leerTexto("Teléfono: ");
                    agenda.añadirContacto(new Contacto(nombre, telefono));
                    break;
                }
                case 2: {
                    String nombre = leerTexto("Nombre a comprobar: ");
                    // El teléfono no importa: dos contactos son iguales si tienen el mismo nombre
                    boolean existe = agenda.existeContacto(new Contacto(nombre, ""));
                    System.out.println(existe ? "El contacto existe." : "El contacto no existe.");
                    break;
                }
                case 3:
                    agenda.listarContactos();
                    break;
                case 4:
                    agenda.buscarPorNombre(leerTexto("Nombre a buscar: "));
                    break;
                case 5:
                    agenda.eliminarContacto(new Contacto(leerTexto("Nombre a eliminar: "), ""));
                    break;
                case 6:
                    System.out.println(agenda.agendaLlena() ? "La agenda está llena." : "La agenda no está llena.");
                    break;
                case 7:
                    System.out.println("Espacios libres: " + agenda.espaciosLibres());
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }

    private static Agenda crearAgenda() {
        String entrada = leerTexto("Tamaño de la agenda (Enter para 10): ");
        if (entrada.isEmpty()) {
            return new Agenda();
        }
        try {
            int tamanio = Integer.parseInt(entrada);
            if (tamanio > 0) {
                return new Agenda(tamanio);
            }
        } catch (NumberFormatException ignored) {
        }
        System.out.println("Tamaño no válido, se usará 10.");
        return new Agenda();
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("===== AGENDA =====");
        System.out.println("1. Añadir contacto");
        System.out.println("2. Comprobar si existe un contacto");
        System.out.println("3. Listar contactos");
        System.out.println("4. Buscar contacto por nombre");
        System.out.println("5. Eliminar contacto");
        System.out.println("6. ¿Está llena la agenda?");
        System.out.println("7. Espacios libres");
        System.out.println("0. Salir");
    }

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.hasNextLine() ? sc.nextLine().trim() : "";
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            String entrada = leerTexto(mensaje);
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                if (!sc.hasNextLine() && entrada.isEmpty()) return 0; // fin de la entrada
                System.out.println("Escribe un número.");
            }
        }
    }
}