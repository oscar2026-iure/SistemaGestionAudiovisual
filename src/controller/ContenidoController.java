package controller;

import model.*;
import repository.ContenidoRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContenidoController {
    private final List<ContenidoAudiovisual> contenidos;
    private final List<Actor> actores;
    private final List<Temporada> temporadas;
    private final List<Investigador> investigadores;
    private final ContenidoRepository repository;

    // El constructor inicializa las listas y carga los datos automáticamente
    public ContenidoController(ContenidoRepository repository) {
        this.repository = repository;
        this.contenidos = new ArrayList<>();
        this.actores = new ArrayList<>();
        this.temporadas = new ArrayList<>();
        this.investigadores = new ArrayList<>();
        
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        try {
            repository.cargarTodo(contenidos, actores, temporadas, investigadores);
        } catch (IOException e) {
            System.out.println("Nota: No se pudo cargar el archivo CSV (Se iniciará un archivo nuevo).");
        }
    }

    // Métodos limpios para agregar elementos a las listas
    public void agregarContenido(ContenidoAudiovisual c) { contenidos.add(c); }
    public void agregarActor(Actor a) { actores.add(a); }
    public void agregarTemporada(Temporada t) { temporadas.add(t); }
    public void agregarInvestigador(Investigador i) { investigadores.add(i); }

    // Métodos para obtener las listas (retornan copias para proteger el encapsulamiento)
    public List<ContenidoAudiovisual> getContenidos() { return new ArrayList<>(contenidos); }
    public List<Actor> getActores() { return new ArrayList<>(actores); }
    public List<Temporada> getTemporadas() { return new ArrayList<>(temporadas); }
    public List<Investigador> getInvestigadores() { return new ArrayList<>(investigadores); }

    // Guarda los cambios invocando al repositorio
    public boolean guardarCambios() {
        try {
            repository.guardarTodo(contenidos, actores, temporadas, investigadores);
            return true;
        } catch (IOException e) {
            System.err.println("Error crítico al guardar en el archivo: " + e.getMessage());
            return false;
        }
    }
}