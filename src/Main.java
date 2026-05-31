import controller.ContenidoController;
import repository.ContenidoRepository;
import view.ContenidoView;

public class Main {
    public static void main(String[] args) {
        // 1. Definimos el nombre del archivo físico CSV que se va a generar
        String archivoCSV = "datos_audiovisuales.csv";
        
        // 2. Instanciamos el repositorio (Persistencia de datos)
        ContenidoRepository repository = new ContenidoRepository(archivoCSV);
        
        // 3. Pasamos el repositorio al controlador (Cerebro)
        ContenidoController controller = new ContenidoController(repository);
        
        // 4. Pasamos el controlador a la vista (Interfaz de usuario)
        ContenidoView vista = new ContenidoView(controller);
        
        // 5. Encendemos el menú interactivo en la consola
        vista.mostrarMenu();
    }
}