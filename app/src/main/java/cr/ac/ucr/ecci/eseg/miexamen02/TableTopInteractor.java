package cr.ac.ucr.ecci.eseg.miexamen02;

import android.content.Context;

public class TableTopInteractor {
    // Clase que instancia la clase Service DataSource y ejecuta el obtener los datos
    public void obtenerDatos(Context context){
        ServiceDataSource serviceD = new ServiceDataSource(context);
        serviceD.obtainItems();
    }
}
