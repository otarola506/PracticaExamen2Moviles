package cr.ac.ucr.ecci.eseg.miexamen02;

import android.content.Context;

import java.util.List;

public class ServiceDataSource implements IServiceDataSource {
    // Se obtiene los items de la lista y los retorna
    // En este método hay que recuperar mediante una tarea asíncronica el archivo json con la clase TableTop.
    @Override
    public List<TableTop> obtainItems(Context context) {
        List<TableTop> items = null;
        return items;
    }
}
