package view;

import controller.ContenidoController;
import model.*;
import java.util.Scanner;

public class ContenidoView {
    private final ContenidoController controller;
    private final Scanner scanner;

    public ContenidoView(ContenidoController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = 0;
        do {
            System.out.println("\n========================================");
            System.out.println("  SISTEMA DE GESTIÓN AUDIOVISUAL (MVC)  ");
            System.out.println("========================================");
            System.out.println("1. Registrar Película");
            System.out.println("2. Registrar Serie de TV");
            System.out.println("3. Registrar Documental");
            System.out.println("4. Registrar Actor");
            System.out.println("5. Registrar Temporada");
            System.out.println("6. Registrar Investigador");
            System.out.println("7. Mostrar Catálogo de Contenidos");
            System.out.println("8. Guardar y Salir");
            System.out.println("========================================");
            
            opcion = leerEntero("Seleccione una opción: ");
            procesarOpcion(opcion);
        } while (opcion != 8);
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                registrarPelicula();
                break;
            case 2:
                registrarSerie();
                break;
            case 3:
                registrarDocumental();
                break;
            case 4:
                registrarActor();
                break;
            case 5:
                registrarTemporada();
                break;
            case 6:
                registrarInvestigador();
                break;
            case 7:
                mostrarCatalogos();
                break;
            case 8:
                if (controller.guardarCambios()) {
                    System.out.println("¡Datos guardados con éxito en datos_audiovisuales.csv! Saliendo...");
                }
                break;
            default:
                System.out.println("Opción inválida. Intente de nuevo.");
                break;
        }
    }

    private void registrarPelicula() {
        System.out.println("\n--- REGISTRAR PELÍCULA ---");
        String id = leerTexto("ID de Película: ");
        String titulo = leerTexto("Título: ");
        int ano = leerEntero("Año de Estreno: ");
        int duracion = leerEntero("Duración (minutos): ");
        
        controller.agregarContenido(new Pelicula(id, titulo, ano, duracion));
        System.out.println("¡Película registrada con éxito!");
    }

    private void registrarSerie() {
        System.out.println("\n--- REGISTRAR SERIE DE TV ---");
        String id = leerTexto("ID de Serie: ");
        String titulo = leerTexto("Título: ");
        int ano = leerEntero("Año de Estreno: ");
        int temporadas = leerEntero("Total de Temporadas: ");
        
        controller.agregarContenido(new SerieDeTV(id, titulo, ano, temporadas));
        System.out.println("¡Serie de TV registrada con éxito!");
    }

    private void registrarDocumental() {
        System.out.println("\n--- REGISTRAR DOCUMENTAL ---");
        String id = leerTexto("ID de Documental: ");
        String titulo = leerTexto("Título: ");
        int ano = leerEntero("Año de Estreno: ");
        String tematica = leerTexto("Temática: ");
        
        controller.agregarContenido(new Documental(id, titulo, ano, tematica));
        System.out.println("¡Documental registrado con éxito!");
    }

    private void registrarActor() {
        System.out.println("\n--- REGISTRAR ACTOR ---");
        String id = leerTexto("ID de Actor: ");
        String nombre = leerTexto("Nombre: ");
        String apellido = leerTexto("Apellido: ");
        
        controller.agregarActor(new Actor(id, nombre, apellido));
        System.out.println("¡Actor registrado con éxito!");
    }

    private void registrarTemporada() {
        System.out.println("\n--- REGISTRAR TEMPORADA ---");
        String idSerie = leerTexto("ID de la Serie vinculada: ");
        int num = leerEntero("Número de Temporada: ");
        int episodios = leerEntero("Cantidad de Episodios: ");
        
        controller.agregarTemporada(new Temporada(idSerie, num, episodios));
        System.out.println("¡Temporada registrada con éxito!");
    }

    private void registrarInvestigador() {
        System.out.println("\n--- REGISTRAR INVESTIGADOR ---");
        String id = leerTexto("ID de Investigador: ");
        String nombre = leerTexto("Nombre completo: ");
        String specialty = leerTexto("Especialidad: ");
        
        controller.agregarInvestigador(new Investigador(id, nombre, specialty));
        System.out.println("¡Investigador registrado con éxito!");
    }

    private void mostrarCatalogos() {
        System.out.println("\n--- CATÁLOGO DE CONTENIDOS AUDIOVISUALES ---");
        if (controller.getContenidos().isEmpty()) {
            System.out.println("No hay contenidos registrados.");
        } else {
            for (ContenidoAudiovisual c : controller.getContenidos()) {
                System.out.printf("- [%s] ID: %s | Título: %s (%d)\n", 
                        c.getClass().getSimpleName(), c.getId(), c.getTitulo(), c.getAnoEstreno());
            }
        }
    }

    // =========================================================================
    // MÉTODOS AUXILIARES DE CONTROL DE FLUJO Y SEGURIDAD (Refactorización)
    // =========================================================================
    
    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    private int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();
            try {
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingrese un número entero válido.");
            }
        }
    }
}