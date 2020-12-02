package cr.ac.ucr.ecci.eseg.miexamen02;

import android.content.Context;

import java.util.List;

public class TableTopInteractor implements IServiceDataSource {
    private MainActivityView mainActivityView;
    public TableTopInteractor (MainActivity mainActivityView){
        this.mainActivityView = mainActivityView;
    }
    // Método que instancia la clase Service DataSource y ejecuta el obtener los datos
    public void iniciarTareaAsyncJuegos(Context context){
        ServiceDataSource serviceD = new ServiceDataSource(context);
        serviceD.iniciarRecuperacionJuegos(this);
    }

    // Utilizamos la interfaz IServiceDataSource para obtener los juegos y paserselos al view
    @Override
    public void obtainItems(List<TableTop> juegos) {
        mainActivityView.setItems(juegos);
    }


}
