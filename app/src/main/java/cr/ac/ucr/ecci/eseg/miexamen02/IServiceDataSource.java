package cr.ac.ucr.ecci.eseg.miexamen02;

import android.content.Context;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface IServiceDataSource {
    // Se define un método para obtener los items de tipo TableTop
    void obtainItems (Context context);
}
