package cr.ac.ucr.ecci.eseg.miexamen02;

import java.util.List;

public interface IServiceDataSource {
    // Método que recibe la lista de juegos cuando termina la tarea asincrónica
    void obtainItems(List<TableTop> juegos);
}
