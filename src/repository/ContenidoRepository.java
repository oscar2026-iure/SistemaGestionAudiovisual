package repository;

import model.*;
import java.io.*;
import java.util.List;

public class ContenidoRepository {
    private final String rutaArchivo;

    // Inyección de dependencias mediante el constructor
    public ContenidoRepository(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    // Escritura de Archivos: Guarda todas las listas en el archivo CSV
    public void guardarTodo(List<ContenidoAudiovisual> contenidos, List<Actor> actores, 
                            List<Temporada> temporadas, List<Investigador> investigadores) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            // Guardar Contenidos Audiovisuales (Películas, Series, Documentales)
            for (ContenidoAudiovisual c : contenidos) {
                bw.write(c.toCSV());
                bw.newLine();
            }
            // Guardar Actores
            for (Actor a : actores) {
                bw.write(a.toCSV());
                bw.newLine();
            }
            // Guardar Temporadas
            for (Temporada t : temporadas) {
                bw.write(t.toCSV());
                bw.newLine();
            }
            // Guardar Investigadores
            for (Investigador i : investigadores) {
                bw.write(i.toCSV());
                bw.newLine();
            }
        }
    }

    // Lectura de Archivos: Inicializa las listas desde el archivo CSV
    public void cargarTodo(List<ContenidoAudiovisual> contenidos, List<Actor> actores, 
                           List<Temporada> temporadas, List<Investigador> investigadores) throws IOException {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) return; // Si no existe el archivo, inicia vacío de forma segura

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue; // Salta líneas vacías de seguridad
                
                String[] datos = linea.split(",");
                String tipo = datos[0];

                // Delegar el procesamiento para mantener métodos pequeños y legibles
                procesarLineaCSV(tipo, datos, contenidos, actores, temporadas, investigadores);
            }
        }
    }

    // Método auxiliar con sintaxis clásica (Estricta compatibilidad y sin errores)
    private void procesarLineaCSV(String tipo, String[] datos, List<ContenidoAudiovisual> contenidos, 
                                  List<Actor> actores, List<Temporada> temporadas, List<Investigador> investigadores) {
        try {
            switch (tipo) {
                case "PELICULA":
                    contenidos.add(new Pelicula(datos[1], datos[2], Integer.parseInt(datos[3]), Integer.parseInt(datos[4])));
                    break;
                case "SERIE":
                    contenidos.add(new SerieDeTV(datos[1], datos[2], Integer.parseInt(datos[3]), Integer.parseInt(datos[4])));
                    break;
                case "DOCUMENTAL":
                    contenidos.add(new Documental(datos[1], datos[2], Integer.parseInt(datos[3]), datos[4]));
                    break;
                case "ACTOR":
                    actores.add(new Actor(datos[1], datos[2], datos[3]));
                    break;
                case "TEMPORADA":
                    temporadas.add(new Temporada(datos[1], Integer.parseInt(datos[2]), Integer.parseInt(datos[3])));
                    break;
                case "INVESTIGADOR":
                	investigadores.add(new Investigador(datos[1], datos[2], datos[3]));// Mantiene la compatibilidad si usas la base de mapeo
                    break;
                default:
                    // Ignora o registra tipos no identificados de forma segura
                    break;
            }
        } catch (Exception e) {
            System.err.println("Error de formato al procesar línea: " + String.join(",", datos));
        }
    }
}