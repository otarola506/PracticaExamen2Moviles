package cr.ac.ucr.ecci.eseg.miexamen02;

import java.util.List;

public interface OnFinishTask {
    // Método que recibe la lista de juegos cuando termina la tarea asincrónica
    void onFinishedTask(List<TableTop> juegos);
}
